package com.bestboke.threadlearn.chapter05;

import java.util.LinkedList;

import static java.lang.Thread.currentThread;

public class EventQueue {

    private final int max;

    static class Event {

    }

    private final LinkedList<Event> eventQueue = new LinkedList<>();

    private final static int DEFAULT_MAX_EVENT = 10;

    public EventQueue(){
        this(DEFAULT_MAX_EVENT);
    }

    public EventQueue(int max) {
        this.max = max;
    }

    private void console(String msg){
        System.out.println(currentThread().getName() + ": " + msg);
    }

    public void offer(Event event){
        synchronized(eventQueue){
            if(eventQueue.size() >= max){
                try {
                    console("队列已满！");
                    eventQueue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            console("事件已经提交");
            eventQueue.addLast(event);
            eventQueue.notify();
        }
    }

    public Event task(){
        synchronized (eventQueue){
            if(eventQueue.isEmpty()){
                try {
                    console("队列还是空的");
                    eventQueue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            Event event = eventQueue.removeLast();
            this.eventQueue.notify();
            console(event + " 已经处理");
            return event;
        }
    }
}
