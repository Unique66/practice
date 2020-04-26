package com.sxh.designMode.designbook.observermode.myobserver;/**
 * Created by SXH on 2020/1/19 16:53.
 */

/**
 * @author SXH
 * @description
 * @date 2020/1/19 16:53.
 */
public class CurrentConditionsDisplay implements Observer, DisplayElement {
	private float temperature;
	private float humidity;
	private Subject weatherData;

	public CurrentConditionsDisplay(Subject weatherData) {
		this.weatherData = weatherData;
		weatherData.registerObserver(this);
	}

	@Override
	public void display() {
		System.out.println("Current conditions:" + temperature + "F degrees and " +
				humidity + "% humidity");
	}

	@Override
	public void update(float temperature, float humidity, float pressure) {
		this.temperature = temperature;
		this.humidity = humidity;
		display();
	}
}
