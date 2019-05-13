package com.bestboke.threadlearn.chapter03;

public class ThreadYield {

    public static void main(String [] args){

    }

    private static Thread create(int index){
        return new Thread(() ->{
            System.out.println(index);
        });
    }
}
