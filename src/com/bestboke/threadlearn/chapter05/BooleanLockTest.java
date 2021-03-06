package com.bestboke.threadlearn.chapter05;

import java.util.concurrent.TimeoutException;
import java.util.stream.IntStream;

import static java.lang.Thread.currentThread;
import static java.util.concurrent.ThreadLocalRandom.current;

public class BooleanLockTest {

    private final Lock lock = new BooleanLock();

    public void syncMethod() {

        try {

            int randomInt = current().nextInt(10);
            lock.lock(randomInt);
            System.out.println(currentThread() + " 获得锁");
            //System.out.println(lock.getBlockedThreads());
            //TimeUnit.SECONDS.sleep(randomInt);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        BooleanLockTest booleanLockTest = new BooleanLockTest();
        IntStream.range(0, 10).mapToObj(i -> new Thread(booleanLockTest::syncMethod)).forEach(Thread::start);
    }
}
