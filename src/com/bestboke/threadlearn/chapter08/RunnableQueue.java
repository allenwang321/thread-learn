package com.bestboke.threadlearn.chapter08;

/**
 * 用于存放提交的Runnable
 */
public interface RunnableQueue {

    /**
     * 当有新的任务进来时首先会offer到队列中
     *
     * @param runnable
     */
    void offer(Runnable runnable);

    /**
     * 工作线程通过take方式获取Runnable
     *
     * @return
     */
    Runnable take() throws InterruptedException;

    /**
     * 获取任务队列中任务的数量
     *
     * @return
     */
    int size();

}
