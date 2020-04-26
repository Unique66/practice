package com.sxh.designMode.designbook.designintroduction.ducktest;/**
 * Created by SXH on 2020/1/18 23:23.
 */

/**
 * @author SXH
 * @description
 * @date 2020/1/18 23:23.
 */
public class TestMiniDuckSimulator {
	// testduck 属于策略模式：定义了算法族，分别封装起来，让它们之间可以互相替换，此模式让算法的变化独立于使用算法的客户。
	public static void main(String[] args) {
		Duck mallard = new MallardDuck();
		mallard.setFlyBehavior(new FlyNoWay());
		mallard.performFly();
		mallard.performQuack();
	}
}
