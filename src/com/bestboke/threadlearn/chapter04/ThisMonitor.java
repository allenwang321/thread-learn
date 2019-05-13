package com.bestboke.threadlearn.chapter04;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.currentThread;

public class ThisMonitor {

    private static Unsafe unsafe;


    private final Object object1 = new Object();

    private final Object object2 = new Object();

    static final boolean is64bit = true;

    static {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            unsafe = (Unsafe) field.get(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public  void method1(){
        synchronized (object1){
            System.out.println(object1);
            addressOf(object1);
            System.out.println(currentThread().getName() + " enter to method1");
            try {
                TimeUnit.MINUTES.sleep(10L);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }

    }

    public static void addressOf(Object o) {

        Object[] array = new Object[] { o };

        long baseOffset = unsafe.arrayBaseOffset(Object[].class);
        int addressSize = unsafe.addressSize();
        Long last = 0L;
        switch (addressSize) {
            case 4:
                long factor = is64bit ? 8 : 1;
                Long i1 = (unsafe.getInt(o, baseOffset) & 0xFFFFFFFFL) * factor;
                System.out.print(Long.toHexString(i1));
                last = i1;
                for (int i = 1; i < array.length; i++) {
                    final long i2 = (unsafe.getInt(o, baseOffset + i * 4) & 0xFFFFFFFFL) * factor;
                    if (i2 > last)
                        System.out.print(", +" + Long.toHexString(i2 - last));
                    else
                        System.out.print(", -" + Long.toHexString( last - i2));
                    last = i2;
                }
                break;
            case 8:
                long factor1 = is64bit ? 8 : 1;
                Long i2 = (unsafe.getLong(array, baseOffset) & 0xFFFFFFFFL) * factor1;
                System.out.print(Long.toHexString(i2));
                break;
            default:
                throw new Error("unsupported address size: " + addressSize);
        }
    }

    // 0x00000007156b4d00
    // 0x00000007156bb600
    // 0x00000007156bb6e0
    // 0x00000007156bbac8
    // 0x00000007156bbac8
    // 30424124672
    // 3803018944
    // 2034349848
    // 30424151552


    public  void method2(){
        synchronized (object1){
            System.out.println(currentThread().getName() + " enter to method2");
            try{
                TimeUnit.MINUTES.sleep(10L);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String [] args){
        ThisMonitor thisMonitor = new ThisMonitor();
        new Thread(thisMonitor::method1, "T1").start();

        new Thread(thisMonitor::method2, "T2").start();
    }

}
