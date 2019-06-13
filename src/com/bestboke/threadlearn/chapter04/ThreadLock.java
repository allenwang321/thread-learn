package com.bestboke.threadlearn.chapter04;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class ThreadLock {

    public int i = 0;

    public int j = 0;

    private final static Object LOCK1 = new Object();
    private final static Object LOCK2 = new Object();

    public void count() {
        System.out.println(Thread.currentThread().getName() + " count");
        synchronized (LOCK1) {
            i++;
            try {
                TimeUnit.MILLISECONDS.sleep(1L);
            }catch (InterruptedException e){

            }
            subtract();
            System.out.println(Thread.currentThread().getName() + " i++    " + i);

        }
    }

    public void subtract() {
        System.out.println(Thread.currentThread().getName() + " subtract");
        synchronized (LOCK2) {
            i--;
            try {
                TimeUnit.MILLISECONDS.sleep(1L);
            }catch (InterruptedException e){

            }
            count();
            System.out.println(Thread.currentThread().getName() + " i--    " + i);
        }
    }

    public void compute() {
        System.out.println(Thread.currentThread().getName() + " 开始");
        while (j < 10) {
            count();
            subtract();
            System.out.println(Thread.currentThread().getName() + " j++    " + j);
            j++;
            System.out.println(Thread.currentThread().getName() + " 运行中");
        }
        System.out.println(Thread.currentThread().getName() + " 结束");
    }

    @Test
    public void test() {
        Thread t1 = new Thread(() -> count(), "t1");

        Thread t2 = new Thread(() -> subtract(), "t2");

        t1.start();
        t2.start();

    }


}
