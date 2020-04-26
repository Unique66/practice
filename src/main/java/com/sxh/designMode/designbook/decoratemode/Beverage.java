package com.sxh.designMode.designbook.decoratemode;/**
 * Created by SXH on 2020/1/22 22:41.
 */

/**
 * @author SXH
 * @description 饮料抽象类
 * @date 2020/1/22 22:41.
 */
public abstract class Beverage {
	String description = "Unknown Beverage";

	public String getDescription() {
		return description;
	}

	public abstract double cost();
}
