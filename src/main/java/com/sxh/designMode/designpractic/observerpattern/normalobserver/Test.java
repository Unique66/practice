package com.sxh.designMode.designpractic.observerpattern.normalobserver;/**
 * Created by SXH on 2020/3/17 16:39.
 */

/**
 * @author SXH
 * @description 测试观察者模式
 * @date 2020/3/17 16:39.
 */
public class Test {
	public static void main(String[] args) {
		WeatherStation weatherStation = new WeatherStation();
		TodayObserver todayObserver = new TodayObserver();
		TomorrowObserver tomorrowObserver = new TomorrowObserver();
		// 将两个observer注册到 subject中
		weatherStation.registObserver(todayObserver);
		weatherStation.registObserver(tomorrowObserver);

		weatherStation.dataChange(10, 150, 200);

		weatherStation.removeObserver(todayObserver);
		weatherStation.dataChange(30, 200, 3000);

	}
}
