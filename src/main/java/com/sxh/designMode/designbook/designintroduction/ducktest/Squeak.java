package com.sxh.designMode.designbook.designintroduction.ducktest;/**
 * Created by SXH on 2020/1/18 23:23.
 */

/**
 * @author SXH
 * @description
 * @date 2020/1/18 23:23.
 */
public class Squeak implements QuackBehavior {
	@Override
	public void quack() {
		System.out.println("Squeak");
	}
}
