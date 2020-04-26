package com.sxh.designMode.designbook.designintroduction.ducktest;/**
 * Created by SXH on 2020/1/18 23:22.
 */

/**
 * @author SXH
 * @description
 * @date 2020/1/18 23:22.
 */
public class MuteQuack implements QuackBehavior {
	@Override
	public void quack() {
		System.out.println("<< Silence >>");
	}
}
