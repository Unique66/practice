package com.sxh.jdk8newfeature;/**
 * Created by SXH on 2020/1/18 15:26.
 */

/**
 * @author SXH
 * @description Java 8允许我们给接口添加一个非抽象的方法实现，只需要使用 default关键字即可，这个特征又叫做扩展方法
 * @date 2020/1/18 15:26.
 */
public interface ExtentMethodTest {
	double calculate(int a);
	default double sqrt(int a){
		return Math.sqrt(a);
	}
}
