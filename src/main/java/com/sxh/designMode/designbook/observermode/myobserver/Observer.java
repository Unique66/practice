package com.sxh.designMode.designbook.observermode.myobserver;

/**
 * Created by SXH on 2020/1/19 16:10.
 * 观察者
 */
public interface Observer {
	// 更新布告板状态
	void update(float temp, float humidity, float pressure);
}
