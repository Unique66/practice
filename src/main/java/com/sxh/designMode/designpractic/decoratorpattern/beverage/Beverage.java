package com.sxh.designMode.designpractic.decoratorpattern.beverage;/**
 * Created by SXH on 2020/3/17 20:28.
 */

/**
 * @author SXH
 * @description 饮料的抽象父类
 * @date 2020/3/17 20:28.
 */
public abstract class Beverage {
	public String description;// 饮料的描述
	private float price; // 饮料的价格

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public abstract float cost();
}
