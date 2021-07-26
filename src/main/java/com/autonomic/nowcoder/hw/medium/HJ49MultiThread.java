/*
 * Copyright (c) 2021.  User:Unique66 File:HJ49MultiThread.java
 * Date:2021/07/26 22:49:26
 */

package com.autonomic.nowcoder.hw.medium;

import java.util.Scanner;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Unique66
 * @description HJ49 多线程
 * @date 2021/7/26 22:49
 *
 * https://www.nowcoder.com/practice/cd99fbc6154d4074b4da0e74224a1582?tpId=37&&tqId=21272&rp=1&ru=/ta/huawei&qru=/ta/huawei/question-ranking
 * 描述
 * 问题描述：有4个线程和1个公共的字符数组。线程1的功能就是向数组输出A，线程2的功能就是向字符输出B，线程3的功能就是向数组输出C，线程4的功能就是向数组输出D。要求按顺序向数组赋值ABCDABCDABCD，ABCD的个数由线程函数1的参数指定。[注：C语言选手可使用WINDOWS SDK库函数]
 * 接口说明：
 * void init();  //初始化函数
 * void Release(); //资源释放函数
 * unsignedint__stdcall ThreadFun1(PVOID pM)  ; //线程函数1，传入一个int类型的指针[取值范围：1 – 250，测试用例保证]，用于初始化输出A次数，资源需要线程释放
 * unsignedint__stdcall ThreadFun2(PVOID pM)  ;//线程函数2，无参数传入
 * unsignedint__stdcall ThreadFun3(PVOID pM)  ;//线程函数3，无参数传入
 * Unsigned int __stdcall ThreadFunc4(PVOID pM);//线程函数4，无参数传入
 * char  g_write[1032]; //线程1,2,3,4按顺序向该数组赋值。不用考虑数组是否越界，测试用例保证
 *
 * 输入描述：
 * 本题含有多个样例输入。
 * 输入一个int整数
 *
 * 输出描述：
 * 对于每组样例，输出多个ABCD
 *
 * 示例1
 * 输入：
 * 10
 * 复制
 * 输出：
 * ABCDABCDABCDABCDABCDABCDABCDABCDABCDABCD
 */
public class HJ49MultiThread {
    private volatile int count = 1;
    private Lock lock = new ReentrantLock();
    private Condition conditionA = lock.newCondition();
    private Condition conditionB = lock.newCondition();
    private Condition conditionC = lock.newCondition();
    private Condition conditionD = lock.newCondition();

    // 主要：所有的都要用 while
    public void addA() {
        lock.lock();
        try {
            // 如果当前不是 1 ，则要阻塞等待
            while (count != 1) {
                conditionA.await();
            }
            count++;
            System.out.print("A");
            conditionB.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void addB() {
        lock.lock();
        try {
            // 如果当前不是 2 ，就要阻塞等待
            while (count != 2) {
                conditionB.await();
            }
            count++;
            System.out.print("B");
            conditionC.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    public void addC() {
        lock.lock();
        try {
            // 如果当前不是 3，则阻塞等待
            while (count != 3) {
                conditionC.await();
            }
            count++;
            System.out.print("C");
            conditionD.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void addD() {
        lock.lock();
        try {
            // 当前不是 4 ，则阻塞等待
            while (count != 4) {
                conditionD.await();
            }
            System.out.print("D");
            count = 1;
            conditionA.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            HJ49MultiThread hj = new HJ49MultiThread();
            CountDownLatch countDownLatch = new CountDownLatch(4);

            // 线程1
            new Thread(() -> {
                // A 线程负责add 10 次
                for (int i = 0; i < n; i++) {
                    hj.addA();
                }
                countDownLatch.countDown();
            }, "A").start();

            // 线程2
            new Thread(() -> {
                // A 线程负责add 10 次
                for (int i = 0; i < n; i++) {
                    hj.addB();
                }
                countDownLatch.countDown();
            }, "B").start();

            // 线程3
            new Thread(() -> {
                // A 线程负责add 10 次
                for (int i = 0; i < n; i++) {
                    hj.addC();
                }
                countDownLatch.countDown();
            }, "C").start();

            // 线程4
            new Thread(() -> {
                // A 线程负责add 10 次
                for (int i = 0; i < n; i++) {
                    hj.addD();
                }
                countDownLatch.countDown();
                System.out.println();
            }, "D").start();
            countDownLatch.await();
        }
    }
}
