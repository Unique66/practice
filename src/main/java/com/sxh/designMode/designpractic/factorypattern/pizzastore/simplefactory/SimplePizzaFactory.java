package com.sxh.designMode.designpractic.factorypattern.pizzastore.simplefactory;

import com.sxh.designMode.designpractic.factorypattern.pizzastore.pizza.CheesePizza;
import com.sxh.designMode.designpractic.factorypattern.pizzastore.pizza.GreekPizza;
import com.sxh.designMode.designpractic.factorypattern.pizzastore.pizza.PepperPizza;
import com.sxh.designMode.designpractic.factorypattern.pizzastore.pizza.Pizza;

public class SimplePizzaFactory {

	public Pizza CreatePizza(String ordertype) {
		Pizza pizza = null;

		if (ordertype.equals("cheese")) {
			pizza = new CheesePizza();
		} else if (ordertype.equals("greek")) {
			pizza = new GreekPizza();
		} else if (ordertype.equals("pepper")) {
			pizza = new PepperPizza();
		}
		return pizza;

	}

}
