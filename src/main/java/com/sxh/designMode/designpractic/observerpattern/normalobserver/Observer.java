package com.sxh.designMode.designpractic.observerpattern.normalobserver;

/**
 * Created by SXH on 2020/3/17 16:13.
 * 观察者模式中的 观察者（多），依赖subject数据变化
 */
public interface Observer {
	void update(Integer temperature, Integer pressure, Integer humidity);
}
