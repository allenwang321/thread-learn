package com.bestboke.threadlearn.chapter03;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class InterruptThreadExit {

    public static void main(String [] args) throws InterruptedException{
        Thread t = new Thread(){

            @Override
            public void run(){
                System.out.println("开始");
                long i = 0;
                while (!isInterrupted()){
                    i++;
                }
                System.out.println("工作结束: " + i);
            }
        };

        t.start();
        TimeUnit.SECONDS.sleep(1L);
        System.out.println("工作即将结束");
        t.interrupt();
    }

}
