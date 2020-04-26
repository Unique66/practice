package com.sxh.designMode.designbook.observermode.jdkobserver;/**
 * Created by SXH on 2020/1/19 18:26.
 */

import com.sxh.designMode.designbook.observermode.jdkobserver.CurrentConditionsDisplay;

/**
 * @author SXH
 * @description
 * @date 2020/1/19 18:26.
 */
public class WeatherStationForJDK {
	public static void main(String[] args) {
		WeatherData weatherData = new WeatherData();
		CurrentConditionsDisplay currentConditionsDisplay =  new CurrentConditionsDisplay(weatherData);
		weatherData.setMeasurements(80, 65, 30.4f);
		weatherData.setMeasurements(82, 70, 29.2f);
		weatherData.setMeasurements(78, 90, 20.4f);


	}
}
