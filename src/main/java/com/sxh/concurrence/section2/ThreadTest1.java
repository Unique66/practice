package com.sxh.concurrence.section2;

/**
 * Created by SXH on 2019/3/9.
 * 匿名内部类
 */
public class ThreadTest1 {
    public void test() {
        Thread thread = new Thread(){
            @Override
            public void run() {
                System.out.println("thread");
            }
        };
    }
    Thread thread1 = new Thread(){
        @Override
        public void run() {
            System.out.println("thread1");
        }
    };

    public static void main(String[] args) {
        ThreadTest1 s = new ThreadTest1();
        s.thread1.start();
        s.test();
    }
}
