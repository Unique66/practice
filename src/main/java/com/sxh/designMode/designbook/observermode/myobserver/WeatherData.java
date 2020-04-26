package com.sxh.designMode.designbook.observermode.myobserver;/**
 * Created by SXH on 2020/1/19 16:14.
 */

import java.util.ArrayList;

/**
 * @author SXH
 * @description
 * @date 2020/1/19 16:14.
 */
public class WeatherData implements Subject {
	private ArrayList observers;
	private float temperature;
	private float humidity;
	private float pressure;

	public WeatherData() {
		observers = new ArrayList();
	}

	@Override
	public void registerObserver(Observer o) {
		observers.add(o);
	}

	@Override
	public void removeObserver(Observer o) {
		int i = observers.indexOf(o);
		if (i >= 0) {
			observers.remove(i);
		}
	}

	@Override
	public void notifyObservers() {
		for (int i = 0; i < observers.size(); i++) {
			Observer observer = (Observer) observers.get(i);
			observer.update(temperature, humidity, pressure);
		}
	}

	// 当气象台得到更新观测值时，我们通知观察者
	public void measurementsChanged() {
		notifyObservers();
	}

	// 模拟气象台的动态参数变化
	public void setMeasurements(float temperature, float humidity, float pressure) {
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
		measurementsChanged();
	}

}
