package com.bestboke.threadlearn.chapter06;

import java.util.concurrent.TimeUnit;

public class ThreadGroupBasic {


    public static void main(String [] args) throws InterruptedException {
        ThreadGroup group = new ThreadGroup("group1");

        Thread thread = new Thread(group, ()->{
            while(true){
                try {
                    TimeUnit.SECONDS.sleep(1L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "thread");
        // 设置为守护线程
        thread.setDaemon(true);

        thread.start();

        TimeUnit.MILLISECONDS.sleep(1L);

        ThreadGroup mainGroup = Thread.currentThread().getThreadGroup();

        System.out.println("activeCount=" + mainGroup.activeCount());

        System.out.println("activeGroupCount=" + mainGroup.activeGroupCount());

        System.out.println("getMaxPriority=" + mainGroup.getMaxPriority());

        System.out.println("getName=" + mainGroup.getName());

        System.out.println("getParent=" + mainGroup.getParent());

        mainGroup.list();

        System.out.println("parentOf=" + mainGroup.parentOf(group));

        System.out.println("parentOf=" + mainGroup.parentOf(mainGroup));

    }
}
