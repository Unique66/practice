package com.sxh.designMode.designpractic.decoratorpattern.condiment;/**
 * Created by SXH on 2020/3/17 20:47.
 */

import com.sxh.designMode.designpractic.decoratorpattern.beverage.Beverage;

/**
 * @author SXH
 * @description 调料：牛奶
 * @date 2020/3/17 20:47.
 */
public class Milk extends Condiment {
	public Milk(Beverage beverage) {
		super(beverage);
		super.setDescription("Milk");
		super.setPrice(1.0f);
	}
}
