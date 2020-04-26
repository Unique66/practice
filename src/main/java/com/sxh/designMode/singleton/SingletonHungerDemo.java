package com.sxh.designMode.singleton;/**
 * Created by SXH on 2019/8/5 22:43.
 */

/**
 * @author SXH
 * @description 饿汉模式
 * @date 2019/8/5 22:43.
 */
public class SingletonHungerDemo {
    private static SingletonHungerDemo singletonHungerDemo = new SingletonHungerDemo();

    private SingletonHungerDemo () {}

    public static SingletonHungerDemo getInstance() {
        return singletonHungerDemo;
    }
}
