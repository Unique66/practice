package com.sxh.designMode.designpractic.decoratorpattern.beverage;/**
 * Created by SXH on 2020/3/17 20:35.
 */

/**
 * @author SXH
 * @description （用汽加压煮出的）浓咖啡
 * @date 2020/3/17 20:35.
 */
public class EspressoCoffee extends Coffee {
	public EspressoCoffee() {
		super.setDescription("Espresso Coffee");
		super.setPrice(4.0f);
	}
}
