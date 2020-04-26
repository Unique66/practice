package com.sxh.designMode.designbook.singletonmode;/**
 * Created by SXH on 2020/1/28 19:56.
 */

/**
 * @author SXH
 * @description 单件模式   饱汉模式
 * @date 2020/1/28 19:56.
 */
public class Singleton {
	private static Singleton uniqueInstance;
	// 这里是其他的有用实例化变量
	private Singleton() {}

	public static Singleton getInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new Singleton();
		}
		return uniqueInstance;
	}
}
