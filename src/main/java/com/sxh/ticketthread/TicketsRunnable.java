package com.sxh.ticketthread;

import com.sun.deploy.util.StringUtils;

/**
 * Created by SXH on 2018/7/22.
 * 卖票
 */
class MyRunnable implements Runnable{
    private  int ticketsCont = 5;
    @Override
    public void run() {
        while(ticketsCont > 0){
            ticketsCont--;//有票就卖一张
            System.out.println(Thread.currentThread().getName()+"卖出一张票，剩余"+ticketsCont+"张票。");
        }
    }
}

public class TicketsRunnable {
    public static void main(String[] args) {
        MyRunnable mr = new MyRunnable();
        //
        Thread th1 = new Thread(mr,"窗口1");
        Thread th2 = new Thread(mr,"窗口2");
        Thread th3 = new Thread(mr,"窗口3");
        th1.start();
        th2.start();
        th3.start();
    }
}
