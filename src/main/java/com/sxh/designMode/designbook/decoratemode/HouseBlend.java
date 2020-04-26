package com.sxh.designMode.designbook.decoratemode;/**
 * Created by SXH on 2020/1/22 22:46.
 */

/**
 * @author SXH
 * @description
 * @date 2020/1/22 22:46.
 */
public class HouseBlend extends Beverage {
	public HouseBlend() {
		description = "House Blend Coffee";
	}

	@Override
	public double cost() {
		return .89;
	}
}
