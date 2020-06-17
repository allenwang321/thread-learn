package com.bestboke.threadlearn.newlearn;

import java.util.concurrent.atomic.AtomicInteger;

public class CAS {

    private AtomicInteger atomicInteger = new AtomicInteger();

    public void test1(){
        atomicInteger.incrementAndGet();
    }


}
