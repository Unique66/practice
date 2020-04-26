package com.sxh.designMode.designbook.singletonmode;/**
 * Created by SXH on 2020/1/28 20:17.
 */

/**
 * @author SXH
 * @description 饿汉模式
 * @date 2020/1/28 20:17.
 */
public class HungarySingleton {
	private static HungarySingleton hungarySingleton = new HungarySingleton();

	private HungarySingleton(){}

	public static HungarySingleton getInstance() {
		return hungarySingleton;
	}
}
