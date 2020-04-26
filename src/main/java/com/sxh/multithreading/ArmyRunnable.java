package com.sxh.multithreading;

/**
 * Created by SXH on 2018/7/18.
 */
public class ArmyRunnable implements Runnable {
    //volatile保证线程可以读取共享区中的值（其他线程写入的值）
    volatile boolean keepRunning = true;
    @Override
    public void run() {
        while(keepRunning){
            //发动五次攻击
            for (int i = 0;i < 5;i++){
                System.out.println(Thread.currentThread().getName()+"进攻对方["+i+"]");
                //让出处理器时间，下次随机竞争
                Thread.yield();
            }
        }
        System.out.println(Thread.currentThread().getName()+"结束战斗");
    }
}
