package com.sxh.designMode.prototypeMode;/**
 * Created by SXH on 2019/8/5 23:11.
 */

/**
 * @author SXH
 * @description 客户端调用原型方法
 * @date 2019/8/5 23:11.
 */
public class Client {
    public static void main(String[] args) {
        ConcretePrototype concretePrototype = new ConcretePrototype();
        for (int i = 0; i < 10; i++) {
            ConcretePrototype cp = (ConcretePrototype) concretePrototype.clone();
            cp.show();
        }
    }
}
