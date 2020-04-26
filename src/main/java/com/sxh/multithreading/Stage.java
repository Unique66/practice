package com.sxh.multithreading;

/**
 * Created by SXH on 2018/7/18.
 */
public class Stage extends Thread {
    public void run(){
        System.out.println("很久以前.....");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("大幕揭开....");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ArmyRunnable armyTaskOfSuiDynasty = new ArmyRunnable();
        ArmyRunnable armyTaskOfRevolt = new ArmyRunnable();

        //使用接口创建线程
        Thread armyOfSuiDynasty = new Thread(armyTaskOfSuiDynasty,"隋军");
        Thread armyOfRevolt = new Thread(armyTaskOfRevolt,"农民起义军");

        armyOfSuiDynasty.start();
        armyOfRevolt.start();

        //舞台线程休眠
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("关键人物登场！！！！！！！");
        Thread mrCheng = new KeyPersonThread();
        mrCheng.setName("程咬金");

        System.out.println("程咬金的理想是使百姓安居乐业");

        //停止军队线程的作战
        armyTaskOfSuiDynasty.keepRunning = false;
        armyTaskOfRevolt.keepRunning = false;

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        /*
        历史人物登场
         */
        mrCheng.start();

        //万众瞩目，所有线程等待程先生完成历史使命
        try {
            mrCheng.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("战争结束，人民安居乐业");
        System.out.println("全剧终！");
    }
    public static void main(String[] args) {
        new Stage().start();
    }
}
