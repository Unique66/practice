package com.sxh.designMode.designpractic.decoratorpattern.condiment;/**
 * Created by SXH on 2020/3/17 20:45.
 */

import com.sxh.designMode.designpractic.decoratorpattern.beverage.Beverage;

/**
 * @author SXH
 * @description 调料：巧克力
 * @date 2020/3/17 20:45.
 */
public class Chocolate extends Condiment {
	public Chocolate(Beverage beverage) {
		super(beverage);
		super.setDescription("Chocolate");
		super.setPrice(3.0f);
	}
}
