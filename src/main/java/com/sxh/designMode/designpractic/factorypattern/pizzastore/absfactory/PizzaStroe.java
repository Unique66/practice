package com.sxh.designMode.designpractic.factorypattern.pizzastore.absfactory;



public class PizzaStroe {
	public static void main(String[] args) {
		
		OrderPizza mOrderPizza;
		mOrderPizza=new	OrderPizza(new LDFactory());
		
	}

	

}
