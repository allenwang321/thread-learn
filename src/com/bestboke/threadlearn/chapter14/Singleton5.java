package com.bestboke.threadlearn.chapter14;

/**
 * Holder方式
 */
public class Singleton5 {

    private byte[] data = new byte[1024];

    private Singleton5(){

    }

    private static class Holder{
        private static Singleton5 instance = new Singleton5();
    }

    public static Singleton5 getInstance(){
        return Holder.instance;
    }

}
