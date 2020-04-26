package com.sxh.designMode.designbook.decoratemode;/**
 * Created by SXH on 2020/1/22 22:44.
 */

/**
 * @author SXH
 * @description 浓咖啡
 * @date 2020/1/22 22:44.
 */
public class Espresso extends Beverage {
	public Espresso() {
		description = "Espresso";
	}
	@Override
	public double cost() {
		return 1.99;
	}
}
