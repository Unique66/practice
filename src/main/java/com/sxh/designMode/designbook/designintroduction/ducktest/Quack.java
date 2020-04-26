package com.sxh.designMode.designbook.designintroduction.ducktest;/**
 * Created by SXH on 2020/1/18 23:21.
 */

/**
 * @author SXH
 * @description
 * @date 2020/1/18 23:21.
 */
public class Quack implements QuackBehavior {
	@Override
	public void quack() {
		System.out.println("Quack");
	}
}
