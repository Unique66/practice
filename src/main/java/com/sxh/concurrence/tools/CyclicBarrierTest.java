package com.sxh.concurrence.tools;/**
 * Created by SXH on 2019/8/4 18:26.
 */

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author SXH
 * @description CyclicBarrier:阻塞当前线程，等待其他线程
 * 等待其他线程，且会阻塞当前线程，所有线程必须同时到达位置后，才能继续执行
 * @date 2019/8/4 18:26.
 */
public class CyclicBarrierTest {
    public static void main(String[] args) throws InterruptedException {
        new CyclicBarrierTest().go();
    }

    private void go () throws InterruptedException {
        // 初始化栅栏的参与者为3
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
        // 依次创建3个线程，并启动
        new Thread(new Task(cyclicBarrier), "Thread1").start();
        Thread.sleep(1000);
        new Thread(new Task(cyclicBarrier), "Thread2").start();
        Thread.sleep(1000);
        new Thread(new Task(cyclicBarrier), "Thread3").start();
    }
}
class Task implements Runnable {
    private CyclicBarrier cyclicBarrier;
    public Task(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        System.out.println("thread " + Thread.currentThread().getName() + "arrive " + System.currentTimeMillis());
        try {
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println("thread " + Thread.currentThread().getName() + "deal " + System.currentTimeMillis());
    }
}
