package com.sxh.multithreading;

/**
 * Created by SXH on 2018/7/17.
 */
public class Actor extends Thread {

    public void run(){
        System.out.println(getName()+"是一个演员！");//快捷键：sout
        int count = 0;
        boolean keepRunning = true;
        while (keepRunning){
            System.out.println(getName()+"登台演出："+(++count));
            if (count == 100){
                keepRunning = false;
            }
            if (count%10 == 0){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(getName()+"的演出结束了！");
    }
    public static void main(String[] args) {//快捷键：psvm
        Thread thread = new Actor();
        thread.setName("Mr.Thread");
        thread.start();

        Thread actressThread = new Thread(new Actress(),"Ms.Runnable");
        actressThread.start();
    }
}

class Actress implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"是一个演员！");//快捷键：sout
        int count = 0;
        boolean keepRunning = true;
        while (keepRunning){
            System.out.println(Thread.currentThread().getName()+"登台演出："+(++count));
            if (count == 100){
                keepRunning = false;
            }
            if (count%10 == 0){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(Thread.currentThread().getName()+"的演出结束了！");
    }
}
