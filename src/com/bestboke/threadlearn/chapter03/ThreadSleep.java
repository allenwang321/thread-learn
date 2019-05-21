package com.bestboke.threadlearn.chapter03;

public class ThreadSleep {

    public static void main(String[] args) {
        new Thread(() -> {
            long startTime = System.currentTimeMillis();
            sleep(2000L);
            long endTime = System.currentTimeMillis();
            System.out.println(endTime - startTime);
        }).start();
        long startTime = System.currentTimeMillis();
        sleep(3000L);
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
    }

    private static void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {

        }
    }
}
