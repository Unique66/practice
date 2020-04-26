package com.sxh.designMode.designpractic.factorypattern.pizzastore.absfactory;

import com.sxh.designMode.designpractic.factorypattern.pizzastore.pizza.NYCheesePizza;
import com.sxh.designMode.designpractic.factorypattern.pizzastore.pizza.NYPepperPizza;
import com.sxh.designMode.designpractic.factorypattern.pizzastore.pizza.Pizza;

public class NYFactory implements AbsFactory {

	
	@Override
	public Pizza CreatePizza(String ordertype) {
		Pizza pizza = null;

		if (ordertype.equals("cheese")) {
			pizza = new NYCheesePizza();
		} else if (ordertype.equals("pepper")) {
			pizza = new NYPepperPizza();
		}
		return pizza;

	}

}
