package com.bestboke.threadlearn.chapter14;

/**
 * 饿汉式
 */
public final class Singleton1 {

    // 实例变量
    private byte[] data = new byte[1024];

    // 在实例化对象的时候直接初始化
    private static Singleton1 instance = new Singleton1();

    private Singleton1(){

    }
    public static Singleton1 getInstance(){
        return instance;
    }

}
