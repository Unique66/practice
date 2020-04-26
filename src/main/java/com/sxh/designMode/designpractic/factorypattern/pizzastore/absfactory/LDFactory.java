package com.sxh.designMode.designpractic.factorypattern.pizzastore.absfactory;


import com.sxh.designMode.designpractic.factorypattern.pizzastore.pizza.LDCheesePizza;
import com.sxh.designMode.designpractic.factorypattern.pizzastore.pizza.LDPepperPizza;
import com.sxh.designMode.designpractic.factorypattern.pizzastore.pizza.Pizza;

public class LDFactory implements AbsFactory {

	@Override
	public Pizza CreatePizza(String ordertype) {
		Pizza pizza = null;

		if (ordertype.equals("cheese")) {
			pizza = new LDCheesePizza();
		} else if (ordertype.equals("pepper")) {
			pizza = new LDPepperPizza();
		}
		return pizza;

	}

}
