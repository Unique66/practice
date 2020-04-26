package com.sxh.designMode.designbook.decoratemode;/**
 * Created by SXH on 2020/1/22 22:50.
 */

/**
 * @author SXH
 * @description 豆浆调料
 * @date 2020/1/22 22:50.
 */
public class Soy extends CondimentDecorator {
	Beverage beverage;

	public Soy(Beverage beverage) {
		this.beverage = beverage;
	}

	@Override
	public String getDescription() {
		return beverage.getDescription() + ",Soy";
	}

	@Override
	public double cost() {
		return .30 + beverage.cost();
	}
}
