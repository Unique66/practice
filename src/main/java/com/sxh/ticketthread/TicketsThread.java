package com.sxh.ticketthread;

/**
 * Created by SXH on 2018/7/22.
 */
class MyThread extends Thread{
    private int ticketsCont = 5;//票数
    private String name;

    public MyThread(String name){
        this.name = name;
    }

    @Override
    public void run() {
        while(ticketsCont > 0){
            ticketsCont--;//有票就卖一张
            System.out.println(name+"卖出一张票，剩余"+ticketsCont+"张票。");
        }
    }
}

public class TicketsThread {
    public static void main(String[] args) {
        //创建三个线程，模拟三个窗口买票
        MyThread mt1 = new MyThread("窗口一");
        MyThread mt2 = new MyThread("窗口二");
        MyThread mt3 = new MyThread("窗口三");

        //开始卖票
        mt1.start();
        mt2.start();
        mt3.start();
    }
}
