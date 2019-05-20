package com.bestboke.threadlearn.chapter08;

/**
 * runnable 的一个实现，主要用于线程池内部，用到RunnableQueue然后不断的从queue中提取中某个runnable，并运行runnable的run方法
 */
public class InternalTask implements Runnable {


    private final RunnableQueue runnableQueue;

    private volatile boolean running = true;

    public InternalTask(RunnableQueue runnableQueue) {
        this.runnableQueue = runnableQueue;
    }

    @Override
    public void run() {
        while (running && !Thread.currentThread().isInterrupted()) {
            try {
                Runnable task = runnableQueue.take();
                task.run();
            } catch (InterruptedException e) {
                running = false;
                break;
            }
        }
    }

    public void stop() {
        this.running = false;
    }
}
