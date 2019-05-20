package com.bestboke.threadlearn.chapter08;

/**
 * 用于当Queue中的Runnable达到了limit上限时，决定采取何种方式通知提交者
 */
public interface DenyPolicy {


    void reject(Runnable runnable, ThreadPool threadPool);

    /**
     * 该策略会直接将任务丢弃
     */
    class DiscardDenyPolicy implements DenyPolicy{
        @Override
        public void reject(Runnable runnable, ThreadPool threadPool) {

        }
    }

    /**
     * 该策略抛出异常
     */
    class AbortDenyPolicy implements DenyPolicy{
        @Override
        public void reject(Runnable runnable, ThreadPool threadPool) {
            throw new RunnableDenyException(runnable + "： 该线程将会被中止");
        }
    }

    /**
     * 该拒绝策略会使任务在提交者所在的线程中执行
     */
    class RunnableDenyPolicy implements DenyPolicy{
        @Override
        public void reject(Runnable runnable, ThreadPool threadPool) {
            if(!threadPool.isShutdown()){
                runnable.run();
            }
        }
    }



}
