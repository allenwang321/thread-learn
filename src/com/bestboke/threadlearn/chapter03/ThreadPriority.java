package com.bestboke.threadlearn.chapter03;

import static java.lang.Thread.currentThread;

public class ThreadPriority {

    public static void main(String[] args) {
        ThreadGroup group = currentThread().getThreadGroup();
        group.setMaxPriority(1);
        Thread t1 = new Thread(() -> {
            while (true) {
                System.out.println("t1");
            }
        });
        // 大于等于1小于等于10
        t1.setPriority(3);
        Thread t2 = new Thread(() -> {
            while (true) {
                System.out.println("t2");
            }
        });
        t2.setPriority(10);
        t1.start();
        //t2.start();
    }

}
