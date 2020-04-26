package com.sxh.designMode.designpractic.adaptorpattern;


import com.sxh.designMode.designpractic.adaptorpattern.adapter.TurkeyAdapter2;
import com.sxh.designMode.designpractic.adaptorpattern.duck.Duck;
import com.sxh.designMode.designpractic.adaptorpattern.duck.GreenHeadDuck;
import com.sxh.designMode.designpractic.adaptorpattern.turkey.WildTurkey;

public class MainTest {
	public static void main(String[] args) {
		GreenHeadDuck duck=new GreenHeadDuck();
		
		WildTurkey turkey=new WildTurkey();
		
		Duck duck2turkeyAdapter=new TurkeyAdapter2();
		turkey.gobble();
		turkey.fly();
		duck.quack();
		duck.fly();
		duck2turkeyAdapter.quack();
		duck2turkeyAdapter.fly();
		
	
	}
}
