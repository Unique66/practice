package com.sxh.designMode.designbook.decoratemode;/**
 * Created by SXH on 2020/1/22 22:55.
 */

/**
 * @author SXH
 * @description 测试点餐功能
 * @date 2020/1/22 22:55.
 */
public class StarbuzzCoffe {
	public static void main(String[] args) {
		Beverage beverage = new Espresso();
		System.out.println(beverage.getDescription() + "  $" + beverage.cost());

		Beverage beverage1 = new DarkRoast();
		beverage1 = new Mocha(beverage1);
		beverage1 = new Mocha(beverage1);
		beverage1 = new Whip(beverage1);
		System.out.println(beverage1.getDescription() + "  $" + beverage1.cost());

		Beverage beverage2 = new HouseBlend();
		beverage2 = new Soy(beverage2);
		beverage2 = new Mocha(beverage2);
		beverage2 = new Whip(beverage2);
		System.out.println(beverage2.getDescription() + "  $" + beverage2.cost());
	}
}
