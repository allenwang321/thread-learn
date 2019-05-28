package com.bestboke.threadlearn.chapter03;

import org.junit.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class ThreadJoin {

    public static void main(String [] args) throws InterruptedException {
        List<Thread> threadList = IntStream.range(1, 3).mapToObj(ThreadJoin::create).collect(toList());
        threadList.forEach(Thread::start);
        for (Thread thread : threadList) {
            thread.join();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "#" + i);
            shortSleep();
        }
    }

    private static Thread create(int seq) {
        return new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + "#" + i);
            }
            shortSleep();
        }, String.valueOf(seq));
    }

    private static void shortSleep() {
        try {
            TimeUnit.SECONDS.sleep(1L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void test(){
        Thread thread = new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(11L);
                System.out.println(0);
            }catch (InterruptedException e){
                e.printStackTrace();

            }
        },"t1");

        Thread thread1 = new Thread(){
            @Override
            public void run(){
                try {
                    TimeUnit.SECONDS.sleep(1L);
                    System.out.println(1);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        };

        try {
            thread1.setName("t2");
            thread1.start();
            thread.start();

//            TimeUnit.SECONDS.sleep(1L);
            thread.join();
            System.out.println(123);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
