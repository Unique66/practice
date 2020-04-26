package com.sxh.designMode.designpractic.singletonpattern;/**
 * Created by SXH on 2020/3/18 16:18.
 */

/**
 * @author SXH
 * @description 饿汉模式
 * @date 2020/3/18 16:18.
 */
public class HungrySingleton {
	private static HungrySingleton hungrySingleton = new HungrySingleton();

	private  HungrySingleton(){}

	public static HungrySingleton getInstance () {
		return hungrySingleton;
	}
}
