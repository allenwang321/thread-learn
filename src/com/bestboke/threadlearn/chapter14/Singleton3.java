package com.bestboke.threadlearn.chapter14;

/**
 * 懒汉式 + 同步方法
 */
public final class Singleton3 {

    private byte[] data = new byte[1024];

    private static Singleton3 instance = null;

    private Singleton3(){

    }

    public static synchronized Singleton3 getInstance(){
        if(instance == null){
            instance = new Singleton3();
        }
        return instance;
    }
}
