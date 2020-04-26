package com.sxh.designMode.designpractic.observerpattern.jdkobserver;/**
 * Created by SXH on 2020/3/17 16:55.
 */

import java.util.Observable;

/**
 * @author SXH
 * @description 使用Java内置观察者 Observable，注：Observable 是类不是接口，要继承而不是实现
 * @date 2020/3/17 16:55.
 */
public class WeatherStationJDK extends Observable {
	private Integer temperature;
	private Integer humidity;
	private Integer pressure;

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
	public void dataChange(){
		this.setChanged();
		this.notifyObservers(new Data(getTemperature(), getPressure(), getHumidity()));
	}

	public  void setData(Integer mTemperature, Integer mPressure, Integer mHumidity){
		this.temperature = mTemperature;
		this.pressure = mPressure;
		this.humidity = mHumidity;
		dataChange();
	}

	public class Data {
		private Integer temperature;
		private Integer humidity;
		private Integer pressure;

		public Data(Integer temperature, Integer humidity, Integer pressure) {
			this.temperature = temperature;
			this.humidity = humidity;
			this.pressure = pressure;
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
	}
}
