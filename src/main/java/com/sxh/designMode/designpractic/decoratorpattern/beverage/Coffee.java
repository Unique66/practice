package com.sxh.designMode.designpractic.decoratorpattern.beverage;/**
 * Created by SXH on 2020/3/17 20:32.
 */

/**
 * @author SXH
 * @description 中间层 coffee 的总类
 * @date 2020/3/17 20:32.
 */
public class Coffee extends Beverage {
	@Override
	public float cost() {
		return super.getPrice();
	}
}
