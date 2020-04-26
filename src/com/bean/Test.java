package com.bean;

import java.util.List;

import com.bean.DAO.IWeatherIO_DAO;
import com.bean.DAO.IWeather_Impl;
import com.bean.Entity.ITemperature;

public class Test {

	public static void main(String[] args) {

		IWeatherIO_DAO wDao = new IWeather_Impl();
		List<ITemperature> data = wDao.readDataFromFile();
		int count = 0;
//		for (ITemperature iTemperature : data) {
//			System.out.println(iTemperature);
//			count++;
//		}
		System.out.println(count);
	}
}
