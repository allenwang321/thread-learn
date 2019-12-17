package com.bestboke.threadlearn.chapter09;


public class Signleton {

    private static Signleton instance = new Signleton();
    private static int x = 0;
    private static int y ;


    private Signleton(){
        x++;
        y++;
    }

    public static Signleton getInstance(){
        return instance;
    }

    public static void main(String [] args){
        Signleton signleton = Signleton.getInstance();
        System.out.println(signleton.x);
        System.out.println(signleton.y);
    }


}
