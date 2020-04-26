package com.sxh.designMode.designbook.singletonmode;/**
 * Created by SXH on 2020/1/28 20:26.
 */

/**
 * @author SXH
 * @description 双重检查加锁（double-checked locking），首先检查是否实例已经创建了，如果尚未 创建，
 * “才”进行同步。这样一来，只有第一次会同步，这正是我们想要的
 * 注：双重检查加锁不适用于1.4及更早版本的Java
 * @date 2020/1/28 20:26.
 */
public class DoubleCheckSingleton {
	// volatile 关键词确保：当doubleCheckSingleton 变量被初始化成Singleton 实例时，多个线程正确地处理doubleCheckSingleton 变量。
	private static volatile DoubleCheckSingleton doubleCheckSingleton;

	private DoubleCheckSingleton(){}

	public static DoubleCheckSingleton getInstance() {
		if (doubleCheckSingleton == null) {// 检查实例，如果不存在，就进入同步区块
			synchronized (DoubleCheckSingleton.class) {// 注意，只有第一次才彻底执行这里的代码
				if (doubleCheckSingleton == null) {// 进入区块后，再检查一次。如果仍是null，才创建实例。
					doubleCheckSingleton = new DoubleCheckSingleton();
				}
			}
		}
		return doubleCheckSingleton;
	}
}
