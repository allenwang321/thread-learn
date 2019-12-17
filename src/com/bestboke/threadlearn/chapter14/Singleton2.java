package com.bestboke.threadlearn.chapter14;

/**
 * 懒汉式
 */
public final class Singleton2 {

    // 实例变量
    private byte[] data = new byte[1024];

    private static Singleton2 instance = null;

    private Singleton2(){

    }

    public static Singleton2 getInstance(){
        if(instance == null){
            instance = new Singleton2();
        }
        return instance;
    }

}
