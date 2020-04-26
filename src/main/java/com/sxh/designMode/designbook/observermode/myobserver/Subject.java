package com.sxh.designMode.designbook.observermode.myobserver;

/**
 * Created by SXH on 2020/1/19 16:08.
 * 主题
 */
public interface Subject {
	// 注册观察者
	void registerObserver(Observer o);
	// 删除观察者
	void removeObserver(Observer o);
	// 通知所有观察者
	void notifyObservers();
}
