package com.bestboke.threadlearn.chapter10;

public class TestJvm {

    public static void main(String [] args){
        while (true){
            for (int j = 0; j < 20_00000000; j ++){
                int i =10;
            }
            try {
                Thread.sleep(100L);
                System.out.println(System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
