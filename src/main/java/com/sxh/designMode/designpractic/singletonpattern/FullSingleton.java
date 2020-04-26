package com.sxh.designMode.designpractic.singletonpattern;/**
 * Created by SXH on 2020/3/18 16:22.
 */

/**
 * @author SXH
 * @description 饱汉模式
 * @date 2020/3/18 16:22.
 */
public class FullSingleton {
	private static FullSingleton fullSingleton;

	private FullSingleton(){}

	public static FullSingleton getInstance() {
		if (fullSingleton == null) {
			fullSingleton = new FullSingleton();
		}
		return fullSingleton;
	}
}
