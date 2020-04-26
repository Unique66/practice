package com.sxh.designMode.designpractic.adaptorpattern.adapter;


import com.sxh.designMode.designpractic.adaptorpattern.duck.Duck;
import com.sxh.designMode.designpractic.adaptorpattern.turkey.WildTurkey;
// 类适配器：适配器通过继承或实现的方式 把被适配者和目标类接入类适配器中，以完成适配
public class TurkeyAdapter2 extends WildTurkey implements Duck {

	@Override
	public void quack() {
		// TODO Auto-generated method stub
		super.gobble();
	}
	@Override
	public void fly() {
		// TODO Auto-generated method stub
		super.fly();
		super.fly();
		super.fly();
	}
}
