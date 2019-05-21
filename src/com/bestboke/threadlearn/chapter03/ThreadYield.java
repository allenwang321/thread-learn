package com.bestboke.threadlearn.chapter03;

import java.util.stream.IntStream;

public class ThreadYield {

    public static void main(String [] args){
//        for (int j = 0; j < 100; j ++){
            IntStream.range(0,2).mapToObj(ThreadYield::create).forEach(Thread::start);
//        }

    }

    private static Thread create(int index){
        return new Thread(() ->{
            if(index == 0){
                Thread.yield();
            }
            System.out.println(index);
        });
    }
}
