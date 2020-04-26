package com.sxh.Thread;/**
 * Created by SXH on 2019/7/28 18:04.
 */

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author SXH
 * @description
 * @date 2019/7/28 18:04.
 */
public class FutureTaskDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> future = new FutureTask<String>(new MyCallable());
        new Thread(future).start();
        if (!future.isDone()) {
            System.out.println("task has not finished,please wait!");
        }
        System.out.println("task return:" + future.get());
    }
}
