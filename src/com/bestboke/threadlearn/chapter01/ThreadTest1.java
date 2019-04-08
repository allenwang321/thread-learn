package com.bestboke.threadlearn.chapter01;

public class ThreadTest1 {

    public void test1(){
        Interface1 interface1 = new InterfaceTest();
        interface1.test1();
        Interface2 interface2 = ((InterfaceTest) interface1);
    }

}
