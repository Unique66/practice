package com.sxh.designMode.designpractic.strategypattern.duck;


import com.sxh.designMode.designpractic.strategypattern.flybehavior.BadFlyBehavior;
import com.sxh.designMode.designpractic.strategypattern.quackbehavior.GeGeQuackBehavior;

public class RedHeadDuck extends Duck {

	public RedHeadDuck() {
		mFlyBehavior = new BadFlyBehavior();
		mQuackBehavior = new GeGeQuackBehavior();
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.println("**RedHead**");
	}

}
