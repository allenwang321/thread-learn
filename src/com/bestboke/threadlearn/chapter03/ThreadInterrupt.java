package com.bestboke.threadlearn.chapter03;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.currentThread;

public class ThreadInterrupt {

    public static void main(String [] args){
        Thread t = new Thread(){
            @Override
            public void run(){
                try {
                    TimeUnit.SECONDS.sleep(3L);
                }catch (InterruptedException e){
                    // 一旦线程在阻塞状态被打断，则会抛出一个InterruptException异常，用于通知当前线程被中断
                    System.out.println("被中断了");
                    System.out.println(isInterrupted());
                }
            }
        };
        t.start();
        try {
            // 确保线程已经启动
            TimeUnit.MILLISECONDS.sleep(2L);
        }catch (Exception e){

        }
        t.interrupt();
    }

    @Test
    public void test1(){
        Thread t = new Thread(){
            int i = 0;
            @Override
            public void run(){
                // 判断线程的中断状态，根据状态退出while条件
                while (!isInterrupted()){
                    i ++;
                }
                System.out.println(i);
            }
        };
        t.start();
        // 同样确保线程能够完全启动
        try{
            TimeUnit.MILLISECONDS.sleep(100L);
            System.out.println(currentThread().getName());
        }catch (InterruptedException e){

        }
        // 使中断
        t.interrupt();
    }

    @Test
    public void test2(){

        Thread t = new Thread(){
            @Override
            public void run() {
                System.out.println(interrupted());
                System.out.println(interrupted());
                System.out.println(interrupted());
                System.out.println(interrupted());
                System.out.println(interrupted());
            }
        };
        t.start();
        t.interrupt();

    }

    @Test
    public void test3(){
        System.out.println(Thread.interrupted());
        Thread.currentThread().interrupt();
        System.out.println(Thread.currentThread().isInterrupted());
        try {
            TimeUnit.SECONDS.sleep(1L);
        }catch (InterruptedException e){
            System.out.println(e);
        }
    }

}
