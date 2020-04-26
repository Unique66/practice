package com.sxh.designMode.designpractic.decoratorpattern;/**
 * Created by SXH on 2020/3/17 20:49.
 */

import com.sxh.designMode.designpractic.decoratorpattern.beverage.Beverage;
import com.sxh.designMode.designpractic.decoratorpattern.beverage.DecafCoffee;
import com.sxh.designMode.designpractic.decoratorpattern.beverage.ShortBlackCoffee;
import com.sxh.designMode.designpractic.decoratorpattern.condiment.Chocolate;
import com.sxh.designMode.designpractic.decoratorpattern.condiment.Milk;

/**
 * @author SXH
 * @description 测试装饰者模式效果
 * @date 2020/3/17 20:49.
 */
public class Test {
	public static void main(String[] args) {
		Beverage beverage;
		beverage = new DecafCoffee();
		System.out.println("Beverage1 price:" + beverage.cost());
		System.out.println("Beverage1 desc:" + beverage.getDescription());

		System.out.println("**************************************************");
		beverage = new ShortBlackCoffee();
		beverage = new Milk(beverage);
		beverage = new Chocolate(beverage);
		System.out.println("Beverage2 price:" + beverage.cost());
		System.out.println("Beverage2 desc:" + beverage.getDescription());
	}
}
