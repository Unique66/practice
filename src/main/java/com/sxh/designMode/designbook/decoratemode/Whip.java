package com.sxh.designMode.designbook.decoratemode;/**
 * Created by SXH on 2020/1/22 22:50.
 */

/**
 * @author SXH
 * @description 调料：奶油
 * @date 2020/1/22 22:50.
 */
public class Whip extends CondimentDecorator {
	Beverage beverage;

	public Whip(Beverage beverage) {
		this.beverage = beverage;
	}

	@Override
	public String getDescription() {
		return beverage.getDescription() + ",Whip";
	}

	@Override
	public double cost() {
		return .40 + beverage.cost();
	}
}
