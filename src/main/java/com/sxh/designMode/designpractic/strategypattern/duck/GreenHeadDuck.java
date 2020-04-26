package com.sxh.designMode.designpractic.strategypattern.duck;


import com.sxh.designMode.designpractic.strategypattern.flybehavior.GoodFlyBehavior;
import com.sxh.designMode.designpractic.strategypattern.quackbehavior.GaGaQuackBehavior;

public class GreenHeadDuck extends Duck {

	public GreenHeadDuck() {
		mFlyBehavior = new GoodFlyBehavior();
		mQuackBehavior = new GaGaQuackBehavior();
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.println("**GreenHead**");
	}

}