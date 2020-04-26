package com.sxh.designMode.designpractic.factorypattern.pizzastore.absfactory;


import com.sxh.designMode.designpractic.factorypattern.pizzastore.pizza.Pizza;

public interface AbsFactory {
	public Pizza CreatePizza(String ordertype) ;
}
