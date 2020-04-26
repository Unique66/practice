package com.sxh.designMode.designpractic.observerpattern.normalobserver;/**
 * Created by SXH on 2020/3/17 16:34.
 */

import java.util.Random;

/**
 * @author SXH
 * @description 明天天气预报，实现observer 接口
 * @date 2020/3/17 16:34.
 */
public class TomorrowObserver implements Observer {

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
		System.out.println("明日气温：" + temperature * Math.random());
		System.out.println("明日气压：" + pressure * 10 * Math.random());
		System.out.println("明日湿度：" + humidity * 100 * Math.random());
	}
}
