package com.sxh.designMode.designbook.decoratemode;/**
 * Created by SXH on 2020/1/22 22:50.
 */

/**
 * @author SXH
 * @description 摩卡调料
 * @date 2020/1/22 22:50.
 */
public class Mocha extends CondimentDecorator {
	Beverage beverage;

	public Mocha(Beverage beverage) {
		this.beverage = beverage;
	}

	@Override
	public String getDescription() {
		return beverage.getDescription() + ",Mocha";
	}

	@Override
	public double cost() {
		return .20 + beverage.cost();
	}
}
