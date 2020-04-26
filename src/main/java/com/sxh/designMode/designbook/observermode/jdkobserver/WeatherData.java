package com.sxh.designMode.designbook.observermode.jdkobserver;/**
 * Created by SXH on 2020/1/19 17:53.
 */

import org.hibernate.validator.internal.engine.ValidatorContextImpl;

import java.util.Observable;

/**
 * @author SXH
 * @description  jdk
 * @date 2020/1/19 17:53.
 */
public class WeatherData extends Observable {
	private float temperature;
	private float humidity;
	private float pressure;

	public WeatherData(){}

	public void measurementsChanged() {
		setChanged();// 调用notifyObserver() 之前，要先调用setChanged() 来指示状态在改变
		notifyObservers();
	}

	// jdk 自带观察者模式 模拟气象台的动态参数变化
	public void setMeasurements(float temperature, float humidity, float pressure) {
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
		measurementsChanged();
	}

	public float getTemperature() {
		return temperature;
	}

	public float getHumidity() {
		return humidity;
	}

	public float getPressure() {
		return pressure;
	}
}
