package com.sxh.designMode.designbook.designintroduction.ducktest;/**
 * Created by SXH on 2020/1/18 23:19.
 */

/**
 * @author SXH
 * @description
 * @date 2020/1/18 23:19.
 */
public class FlyWithWings implements FlyBehavior {
	@Override
	public void fly() {
		System.out.println("I'm flying!");
	}
}
