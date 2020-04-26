package com.sxh.concurrence.section3;/**
 * Created by SXH on 2019/3/30 18:40.
 */

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author SXH
 * @description 练习计划任务线程池
 * @date 2019/3/30 18:40.
 */
public class ScheduleThreadPoolDemo {
    public static void main(String[] args) {
        ScheduledExecutorService ses = Executors.newScheduledThreadPool(10);
        ses.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(8000);
                    System.out.println(System.currentTimeMillis()/1000+"s");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },0,2, TimeUnit.SECONDS);


    }
}
