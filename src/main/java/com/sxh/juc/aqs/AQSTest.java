/*
 * Copyright (c) 2021.  User:SXH  File:AQSTest.java
 * Date:2021/03/30 23:02:30
 */

package com.sxh.juc.aqs;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author SXH
 * @description AQS 源码分析
 * @date 2021/3/30 23:02
 */
public class AQSTest {
    private static ReentrantLock lock = new ReentrantLock();
    public static void main(String[] args) {
        lock.lock();
        lock.unlock();
    }
}
