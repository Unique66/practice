package com.sxh.concurrence.section3;/**
 * Created by SXH on 2019/3/30 17:55.
 */

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author SXH
 * @description Practice Executor for ThreadPool
 * @date 2019/3/30 17:55.
 */
public class ThreadPollDemo {
    public static class ExecutorCachedDemo implements Runnable{
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getId()+"done.");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ExecutorCachedDemo executorCachedDemo = new ExecutorCachedDemo();
        ExecutorService executorService = Executors.newCachedThreadPool();//创建带缓冲的线程池
        for (int i = 0; i < 10; i++) {
            executorService.submit(executorCachedDemo);
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        System.out.println(System.currentTimeMillis()+":"+sdf.format(1426515345));
    }
}
