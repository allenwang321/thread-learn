package com.bestboke.threadlearn.chapter03;

public class CurrentThread {



    public static void main(String [] args){
        Thread t = new Thread(){
            @Override
           public void run(){
                // currentThread()方法返回当前线程的一些信息
                System.out.println(Thread.currentThread() == this);
                System.out.println(Thread.currentThread().getName());
           }
        };
        t.start();
        String name =  Thread.currentThread().getName();
        System.out.println("main".equals(name));
    }

}
