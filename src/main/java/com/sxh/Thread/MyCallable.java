package com.sxh.Thread;/**
 * Created by SXH on 2019/7/28 18:01.
 */

import java.util.concurrent.Callable;

/**
 * @author SXH
 * @description
 * @date 2019/7/28 18:01.
 */
public class MyCallable implements Callable{
    @Override
    public Object call() throws Exception {
        String value = "test";
        System.out.println("Ready to work");
        Thread.currentThread().sleep(5000);
        System.out.println("task done");
        return value;
    }
}
