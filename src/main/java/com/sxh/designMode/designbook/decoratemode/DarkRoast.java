package com.sxh.designMode.designbook.decoratemode;/**
 * Created by SXH on 2020/1/22 22:46.
 */

/**
 * @author SXH
 * @description  饮料
 * @date 2020/1/22 22:46.
 */
public class DarkRoast extends Beverage {
	public DarkRoast() {
		description = "DarkRoast Coffee";
	}

	@Override
	public double cost() {
		return 2.89;
	}
}
