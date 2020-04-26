package com.sxh.designMode.designpractic.decoratorpattern.beverage;/**
 * Created by SXH on 2020/3/17 20:37.
 */

/**
 * @author SXH
 * @description 浓缩咖啡
 * @date 2020/3/17 20:37.
 */
public class ShortBlackCoffee extends Coffee {
	public ShortBlackCoffee() {
		super.setDescription("Short Black Coffee");
		super.setPrice(6.0f);
	}
}
