package com.sxh.designMode.designpractic.factorypattern.pizzastore.pizza;

public class GreekPizza extends Pizza {

	@Override
	public void prepare() {
		// TODO Auto-generated method stub
		super.setname("GreekPizza");
		
		System.out.println(name+" preparing;");
	}

}
