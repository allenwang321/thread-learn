package com.bestboke.threadlearn.chapter03;

import org.junit.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import static java.lang.Thread.currentThread;
import static java.util.stream.Collectors.toList;

public class ThreadJoin {

    public static void main(String [] args) throws InterruptedException {
        List<Thread> threadList = IntStream.range(1, 3).mapToObj(ThreadJoin::create).collect(toList());
        threadList.forEach(Thread::start);
        for (Thread thread : threadList) {
            thread.join();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(currentThread().getName() + "#" + i);
            shortSleep();
        }
    }

    private static Thread create(int seq) {
        return new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(currentThread().getName() + "#" + i);
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
        Thread t1 = new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(1L);
                System.out.println("t1:" + currentThread().getName());
            }catch (InterruptedException e){
                e.printStackTrace();

            }
        },"t1");
        Thread t2 = new Thread(){
            @Override
            public void run(){
                try {
                    TimeUnit.SECONDS.sleep(2L);
                    System.out.println("t2:" + currentThread().getName());
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        };
        t1.start();
        t2.setName("t2");
        t2.run();
        System.out.println("main:" + currentThread().getName());
    }

}
