package com.bestboke.threadlearn.chapter08;

/**
 * 定义线程池应该具备的基本功能
 */
public interface ThreadPool {

    /**
     * 提交任务到线程池
     *
     * @param runnable
     */
    void execute(Runnable runnable);

    /**
     * 关闭线程池
     */
    void shutdown();

    /**
     * 获取线程池的初始大小
     *
     * @return
     */
    int getInitSize();

    /**
     * 获取线程池的最大线程数
     *
     * @return
     */
    int getMaxSize();

    /**
     * 获取线程池的核心线程数量
     *
     * @return
     */
    int getCoreSize();

    /**
     * 获取线程池中用于缓存任务队列的大小
     *
     * @return
     */
    int getQueueSize();

    /**
     * 获取线程池中活跃的线程数量
     *
     * @return
     */
    int getActiveSize();

    /**
     * 判断线程池是否已经被shutdown
     *
     * @return
     */
    boolean isShutdown();

}
