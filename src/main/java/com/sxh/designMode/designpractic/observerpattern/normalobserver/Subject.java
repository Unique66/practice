package com.sxh.designMode.designpractic.observerpattern.normalobserver;

/**
 * Created by SXH on 2020/3/17 16:09.
 * 观察者模式中的1，用于observer的注册、删除、通知
 */
public interface Subject {
	void registObserver(Observer observer);
	void removeObserver(Observer observer);
	void notifyObservers();
}
