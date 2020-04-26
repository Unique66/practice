package com.sxh.designMode.designbook.designintroduction.ducktest;/**
 * Created by SXH on 2020/1/18 23:12.
 */

/**
 * @author SXH
 * @description 鸭子抽象类
 * @date 2020/1/18 23:12.
 */
public abstract class Duck {
	FlyBehavior flyBehavior;
	QuackBehavior quackBehavior;

	public abstract void display();
	public void performFly() {
		flyBehavior.fly();
	}

	public void performQuack(){
		quackBehavior.quack();
	}

	public void swim(){
		System.out.println("All ducks float, even decoys!");
	}

	public void setFlyBehavior(FlyBehavior flyBehavior) {
		this.flyBehavior = flyBehavior;
	}

	public void setQuackBehavior(QuackBehavior quackBehavior) {
		this.quackBehavior = quackBehavior;
	}
}
