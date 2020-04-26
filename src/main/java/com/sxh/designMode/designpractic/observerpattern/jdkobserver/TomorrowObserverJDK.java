package com.sxh.designMode.designpractic.observerpattern.jdkobserver;/**
 * Created by SXH on 2020/3/17 17:03.
 */

import java.util.Observable;
import java.util.Observer;

/**
 * @author SXH
 * @description 实现内置的Observer接口  明日天气预报
 * @date 2020/3/17 17:03.
 */
public class TomorrowObserverJDK implements Observer {
	private Integer temperature;
	private Integer pressure;
	private Integer humidity;

	@Override
	public void update(Observable o, Object arg) {
		this.temperature = ((WeatherStationJDK.Data) (arg)).getTemperature();
		this.pressure = ((WeatherStationJDK.Data) (arg)).getPressure();
		this.humidity = ((WeatherStationJDK.Data) (arg)).getHumidity();
		display();
	}

	public void display() {
		System.out.println("明日气温：" + temperature * Math.random());
		System.out.println("明日气压：" + pressure * 10 * Math.random());
		System.out.println("明日湿度：" + humidity * 100 * Math.random());
	}
}
