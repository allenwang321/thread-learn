package com.bestboke.threadlearn.chapter05;

import java.util.concurrent.TimeUnit;

public class SynchronizedDefect {

    public synchronized  void syncMethod(){
        try{
            TimeUnit.HOURS.sleep(1L);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public static void main(String [] args) throws InterruptedException{

        SynchronizedDefect defect = new SynchronizedDefect();

        Thread t1 = new Thread(defect::syncMethod, "t1");
        t1.start();
        TimeUnit.MILLISECONDS.sleep(1L);
        Thread t2 = new Thread(defect::syncMethod, "t2");
        t2.start();

    }

}
