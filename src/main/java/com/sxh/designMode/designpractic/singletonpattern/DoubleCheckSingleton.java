package com.sxh.designMode.designpractic.singletonpattern;/**
 * Created by SXH on 2020/3/18 16:23.
 */

/**
 * @author SXH
 * @description 双重检验的单例模式，避免多线程环境下数据混乱
 *
 * @date 2020/3/18 16:23.
 */
public class DoubleCheckSingleton {
	private static volatile  DoubleCheckSingleton doubleCheckSingleton;

	private DoubleCheckSingleton () {}

	public static DoubleCheckSingleton getInstance () {
		if (doubleCheckSingleton == null) {
			synchronized (DoubleCheckSingleton.class) {
				if (doubleCheckSingleton == null) {
					doubleCheckSingleton = new DoubleCheckSingleton();
				}
			}
		}
		return doubleCheckSingleton;
	}
}
