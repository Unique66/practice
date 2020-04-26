package com.sxh.designMode.designpractic.observerpattern.normalobserver;/**
 * Created by SXH on 2020/3/17 16:16.
 */

import java.util.ArrayList;

/**
 * @author SXH
 * @description 气象站，实现subject接口
 * @date 2020/3/17 16:16.
 */
public class WeatherStation implements Subject {
	private Integer temperature;
	private Integer humidity;
	private Integer pressure;
	private ArrayList<Observer> observers;

	public WeatherStation() {
		observers = new ArrayList<>();
	}

	public Integer getTemperature() {
		return temperature;
	}

	public Integer getHumidity() {
		return humidity;
	}

	public Integer getPressure() {
		return pressure;
	}

	// 模拟修改气象数据的操作
	public void dataChange(Integer mTemperature, Integer mPressure, Integer mHumidity){
		this.temperature = mTemperature;
		this.pressure = mPressure;
		this.humidity = mHumidity;
		notifyObservers();
	}

	@Override
	public void registObserver(Observer observer) {
		observers.add(observer);
	}

	@Override
	public void removeObserver(Observer observer) {
		if (observers.contains(observer)) {
			observers.remove(observer);
		}
	}

	@Override
	public void notifyObservers() {
		for (int i = 0, len = observers.size(); i < len; i++) {
			observers.get(i).update(getTemperature(), getPressure(), getHumidity());
		}
	}
}
