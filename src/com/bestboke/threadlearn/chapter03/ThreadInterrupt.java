package com.bestboke.threadlearn.chapter03;

import java.util.concurrent.TimeUnit;

public class ThreadInterrupt {

    public static void main(String [] args){
        Thread t = new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(3L);
            }catch (InterruptedException e){
                // 一旦线程在阻塞状态被打断，则会抛出一个InterruptException异常，用于通知当前线程被中断
                System.out.println("被中断了");
            }
        });
        t.start();
        try {
            // 确保线程已经启动
            TimeUnit.MILLISECONDS.sleep(2L);
        }catch (Exception e){

        }
        t.interrupt();
    }

}
