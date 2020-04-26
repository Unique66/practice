package com.sxh.designMode.designpractic.decoratorpattern.condiment;/**
 * Created by SXH on 2020/3/17 20:39.
 */

import com.sxh.designMode.designpractic.decoratorpattern.beverage.Beverage;

/**
 * @author SXH
 * @description 调料父类
 * @date 2020/3/17 20:39.
 */
public class Condiment extends Beverage {
	private Beverage beverage;

	public Condiment(Beverage beverage) {
		this.beverage = beverage;
	}

	@Override
	public float cost() {
		return super.getPrice() + beverage.cost();
	}

	@Override
	public String getDescription() {
		return super.getDescription() + "-" + super.getPrice() + "&&" + beverage.getDescription();
	}
}
