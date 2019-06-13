package com.bestboke.threadlearn.chapter04;

public class TicketWindowRunnable implements Runnable {


    private int index = 1;

    private final static int MAX = 5;

    private final static Object MUTEX = new Object();


    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        synchronized (MUTEX){
            while (index <= MAX){
                System.out.println(Thread.currentThread().getName() + " 的号码是: " + (index ++));
            }
        }
        System.out.println(Thread.currentThread().getName());


    }

    public void count(){
        synchronized (MUTEX){
            if(index <= MAX){
                System.out.println(Thread.currentThread().getName() + " 的号码是: " + (index ++));
            }
        }
    }

    public static void main(String []  args){
        final TicketWindowRunnable task = new TicketWindowRunnable();

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
