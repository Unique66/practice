package com.sxh.concurrence.tools;/**
 * Created by SXH on 2019/8/4 18:37.
 */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author SXH
 * @description 控制某个资源同时被访问的线程数
 * @date 2019/8/4 18:37.
 */
public class SemaphoreTest {
    public static void main(String[] args) {
        // 线程池
        ExecutorService exec = Executors.newCachedThreadPool();
        // 只能5个线程同时访问
        final Semaphore semaphore = new Semaphore(5);
        // 模拟20个客户端的访问
        for (int i = 0; i < 20; i++) {
            final int NO = i;
            Runnable run = new Runnable() {
                @Override
                public void run() {
                    // 获取许可
                    try {
                        semaphore.acquire();
                        System.out.println("Accessing:" + NO);
                        Thread.sleep((long) (Math.random() * 10000));
                        // 访问完成，释放
                        semaphore.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            exec.execute(run);
        }
        // 退出线程池
        exec.shutdown();
    }
}
