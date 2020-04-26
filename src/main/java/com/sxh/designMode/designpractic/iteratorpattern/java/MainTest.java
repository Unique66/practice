package com.sxh.designMode.designpractic.iteratorpattern.java;


import java.util.HashMap;

public class MainTest {
	public static void main(String[] args) {
		Waitress mWaitress=new Waitress();
		CakeHouseMenu mCakeHouseMenu = new CakeHouseMenu();
		DinerMenu	mDinerMenu = new DinerMenu();
		CafeMenu mCafeMenu=new CafeMenu();
		
		mWaitress.addIterator(mCakeHouseMenu.getIterator());
		mWaitress.addIterator(mDinerMenu.getIterator());
		mWaitress.addIterator(mCafeMenu.getIterator());
		mWaitress.printMenu();

	}
}
