package com.sxh.designMode.designbook.designintroduction.ducktest;/**
 * Created by SXH on 2020/1/18 23:25.
 */

/**
 * @author SXH
 * @description
 * @date 2020/1/18 23:25.
 */
public class MallardDuck extends Duck {
	public MallardDuck () {
		quackBehavior = new Quack();
		flyBehavior = new FlyWithWings();
	}
	@Override
	public void display() {
		System.out.println("I'm a real Mallard duck");
	}
}
