package com.sxh.designMode.singleton;/**
 * Created by SXH on 2019/8/5 22:51.
 */

/**
 * @author SXH
 * @description 双检锁
 * @date 2019/8/5 22:51.
 */
public class SingletonSynchronizeDemo {
    private static SingletonSynchronizeDemo instance = null;

    private SingletonSynchronizeDemo () {}

    public static SingletonSynchronizeDemo getInstance (){
        if (instance == null) {
            synchronized (SingletonSynchronizeDemo.class) {
                if (instance == null) {
                    instance = new SingletonSynchronizeDemo();
                }
            }
        }
        return instance;
    }
}
