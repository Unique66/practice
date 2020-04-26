package com.sxh.designMode.designpractic.decoratorpattern.beverage;/**
 * Created by SXH on 2020/3/17 20:34.
 */

/**
 * @author SXH
 * @description 无咖啡因咖啡
 * @date 2020/3/17 20:34.
 */
public class DecafCoffee extends Coffee {
	public DecafCoffee() {
		super.setDescription("Decaf Coffee");
		super.setPrice(3.0f);
	}
}
