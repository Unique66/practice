package com.sxh.concurrence.section3;/**
 * Created by SXH on 2019/4/3 20:35.
 */

import java.util.concurrent.*;

/**
 * @author SXH
 * @description 演示自定义线程池和拒绝策略的使用
 * @date 2019/4/3 20:35.
 */
public class RejectedThreadPoolDemo {
    public static class MyTask implements Runnable {
        @Override
        public void run() {
            System.out.println(System.currentTimeMillis() + "Thread ID:" + Thread.currentThread().getId());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyTask myTask = new MyTask();
        ExecutorService es = new ThreadPoolExecutor(5, 5, 0L,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(10),
                Executors.defaultThreadFactory(),
                new RejectedExecutionHandler() {
                    @Override
                    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                        System.out.println(r.toString() + " is discard");
                    }
                });
//        for (int i = 0; i < Integer.MAX_VALUE; i++) {
//            es.submit(myTask);
//            Thread.sleep(10);
//        }

        System.out.println( Runtime.getRuntime().availableProcessors());
    }
}
