package com.sxh.Thread;/**
 * Created by SXH on 2019/7/28 18:11.
 */

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author SXH
 * @description
 * @date 2019/7/28 18:11.
 */
public class ThreadPoolDemo {
    public static void main(String[] args) {
        ExecutorService es = Executors.newCachedThreadPool();
        Future future = es.submit(new MyCallable());
        if (!future.isDone()) {
            System.out.println("task is not done");
        }
        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } finally {
            es.shutdown();
        }
    }
}
