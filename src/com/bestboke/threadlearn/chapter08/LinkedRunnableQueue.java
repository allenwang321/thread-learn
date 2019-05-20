package com.bestboke.threadlearn.chapter08;

import java.util.LinkedList;

public class LinkedRunnableQueue implements RunnableQueue {

    private final int limit;

    private final DenyPolicy denyPolicy;

    private final LinkedList<Runnable> runnableList = new LinkedList<>();

    private final ThreadPool threadPool;

    public LinkedRunnableQueue(int limit, DenyPolicy denyPolicy, ThreadPool threadPool) {
        this.limit = limit;
        this.denyPolicy = denyPolicy;
        this.threadPool = threadPool;
    }

    @Override
    public void offer(Runnable runnable) {
        synchronized (runnableList){
            // 无法容纳新的任务时执行拒绝策略
            if(runnableList.size() >= limit){
                denyPolicy.reject(runnable, threadPool);
            }else {
                // 将任务加入队尾，并唤醒阻塞中的线程
                runnableList.addLast(runnable);
                runnableList.notifyAll();
            }
        }
    }

    @Override
    public Runnable take() throws InterruptedException {
        synchronized (runnableList){
            // 如果队列中的任务数为空时，则当前线程将会挂起，等待新的任务加入时唤醒
            while (runnableList.isEmpty()){
                try {
                    runnableList.wait();
                }catch (InterruptedException e){
                    throw e;
                }
            }
            // 从队列头部移除一个任务
            return runnableList.removeFirst();
        }
    }

    @Override
    public int size() {
        synchronized (runnableList){
            // 返回当前任务队列中的任务数
            return runnableList.size();
        }
    }
}
