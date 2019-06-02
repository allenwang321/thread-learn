package com.bestboke.threadlearn.chapter04;

import java.util.concurrent.TimeUnit;

public class TicketWindowRuannable implements Runnable {


    private int index = 1;

    private final static int MAX = 500;

    private final static Object MUTEX = new Object();


    @Override
    public void run() {
        synchronized (MUTEX){
            while (index <= MAX){
                System.out.println(Thread.currentThread().getName() + " 的号码是: " + (index ++));
                try {
                    TimeUnit.MILLISECONDS.sleep(2L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public static void main(String []  args){
        final TicketWindowRuannable task = new TicketWindowRuannable();

        Thread windowThread1 = new Thread(task, "一号窗口");
        Thread windowThread2 = new Thread(task, "二号窗口");
        Thread windowThread3 = new Thread(task, "三号窗口");
        Thread windowThread4 = new Thread(task, "四号窗口");

        windowThread2.start();
        windowThread1.start();
        windowThread3.start();
        windowThread4.start();

    }
}
