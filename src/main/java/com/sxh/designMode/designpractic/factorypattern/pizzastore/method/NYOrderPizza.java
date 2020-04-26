package com.sxh.designMode.designpractic.factorypattern.pizzastore.method;


import com.sxh.designMode.designpractic.factorypattern.pizzastore.pizza.NYCheesePizza;
import com.sxh.designMode.designpractic.factorypattern.pizzastore.pizza.NYPepperPizza;
import com.sxh.designMode.designpractic.factorypattern.pizzastore.pizza.Pizza;

public class NYOrderPizza extends OrderPizza {

	@Override
	Pizza createPizza(String ordertype) {
		Pizza pizza = null;

		if (ordertype.equals("cheese")) {
			pizza = new NYCheesePizza();
		} else if (ordertype.equals("pepper")) {
			pizza = new NYPepperPizza();
		}
		return pizza;

	}

}
