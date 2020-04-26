package com.sxh.designMode.designpractic.observerpattern.jdkobserver;/**
 * Created by SXH on 2020/3/17 17:08.
 */

/**
 * @author SXH
 * @description
 * @date 2020/3/17 17:08.
 */
public class TestJDK {
	public static void main(String[] args) {
		WeatherStationJDK weatherStationJDK = new WeatherStationJDK();
		TodayObserverJDK todayObserverJDK = new TodayObserverJDK();
		TomorrowObserverJDK tomorrowObserverJDK = new TomorrowObserverJDK();

		weatherStationJDK.addObserver(todayObserverJDK);
		weatherStationJDK.addObserver(tomorrowObserverJDK);

		weatherStationJDK.setData(30, 50, 100);
	}
}
