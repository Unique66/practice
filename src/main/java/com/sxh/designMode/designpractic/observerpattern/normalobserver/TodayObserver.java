package com.sxh.designMode.designpractic.observerpattern.normalobserver;/**
 * Created by SXH on 2020/3/17 16:25.
 */

/**
 * @author SXH
 * @description observer 接口的实现类，展示今日天气
 * @date 2020/3/17 16:25.
 */
public class TodayObserver implements Observer {

	private Integer temperature;
	private Integer pressure;
	private Integer humidity;

	@Override
	public void update(Integer temperature, Integer pressure, Integer humidity) {
		this.temperature = temperature;
		this.pressure = pressure;
		this.humidity = humidity;
		display();
	}

	public void display() {
		System.out.println("Today's Temperature：" + temperature);
		System.out.println("Today's Pressure：" + pressure);
		System.out.println("Today's Humidity：" + humidity);
	}
}
