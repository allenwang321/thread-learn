package com.bestboke.threadlearn.chapter01;



/**
 * Thread 模拟营业大厅叫号机
 */
public class TicketWindow extends Thread{

    // 柜台名称
    private final String name;

    // 最多受理50笔业务
    private static final int MAX = 50;

    private static int index = 1;

    public TicketWindow(String name) {
        this.name = name;
    }

    @Override
    public void run(){
        while (index <= MAX){
            System.out.println("柜台：" + name + " 当前的号码是：" + (index ++));
            System.out.println("线程名称："+ Thread.currentThread().getName() +" 线程ID:" +Thread.currentThread().getId());
        }
    }

    public static void main(String [] args){
        TicketWindow ticketWindow1 = new TicketWindow("一号机");
        ticketWindow1.start();
        TicketWindow ticketWindow2 = new TicketWindow("二号机");
        ticketWindow2.start();
        TicketWindow ticketWindow3 = new TicketWindow("三号机");
        ticketWindow3.start();
    }
}
