package com.sxh.designMode.singleton;/**
 * Created by SXH on 2019/8/5 22:46.
 */

/**
 * @author SXH
 * @description 懒汉模式
 * @date 2019/8/5 22:46.
 */
public class SingletonLazy {
    private static SingletonLazy singletonLazy = null;

    private SingletonLazy () {}

    public SingletonLazy getSingletonLazy () {
        if (singletonLazy == null) {
            singletonLazy = new SingletonLazy();
        }
        return singletonLazy;
    }
}
