package com.sxh.designMode.designpractic.strategypattern;

import com.sxh.designMode.designpractic.strategypattern.duck.Duck;
import com.sxh.designMode.designpractic.strategypattern.duck.GreenHeadDuck;
import com.sxh.designMode.designpractic.strategypattern.duck.RedHeadDuck;
import com.sxh.designMode.designpractic.strategypattern.flybehavior.NoFlyBehavior;
import com.sxh.designMode.designpractic.strategypattern.quackbehavior.NoQuackBehavior;


public class StimulateDuck {

	public static void main(String[] args) {

		Duck mGreenHeadDuck = new GreenHeadDuck();
		Duck mRedHeadDuck = new RedHeadDuck();

		mGreenHeadDuck.display();
		mGreenHeadDuck.Fly();
		mGreenHeadDuck.Quack();
		mGreenHeadDuck.swim();

		mRedHeadDuck.display();
		mRedHeadDuck.Fly();
		mRedHeadDuck.Quack();
		mRedHeadDuck.swim();
		mRedHeadDuck.display();
		mRedHeadDuck.SetFlyBehavoir(new NoFlyBehavior());
		mRedHeadDuck.Fly();
		mRedHeadDuck.SetQuackBehavoir(new NoQuackBehavior());
		mRedHeadDuck.Quack();
	}

}
