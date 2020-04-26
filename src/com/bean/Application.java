package com.bean;

import java.util.List;
import java.util.Scanner;

import com.bean.DAO.IClimateAnalyzer_DAO;
import com.bean.DAO.IClimateAnalyzer_Impl;
import com.bean.Entity.ITemperature;

public class Application {

	public static void main(String[] args) {

		IClimateAnalyzer_DAO cliDao = new IClimateAnalyzer_Impl();

		System.out.println("====== Climate Change Analysis Application ======");

		Scanner scanner = new Scanner(System.in);

		System.out.println("\nPlease select the query");

		while (true) {
			System.out
					.println("\n1) Get data which has the lowest and highest temperature reading for a given month. ");
			System.out
					.println("2) Get data for the month which has the lowest and highest temperature in a given year.");
			System.out.println("3) Get all data that falls within a specific temperature range");
			System.out.println(
					"4) Get data for the year with the lowest temperature and for the year with the highest\r\n"
							+ "temperature reading");
			System.out.println(
					"5) The top 10 countries with the lowest temperature reading and the top 10 countries with\r\n"
							+ "the highest temperature reading for a given month between 2000 and 2016.");

			System.out.print("\nChoice =");
			int choice = scanner.nextInt();

			String country, month;
			int year;

			ITemperature data1, data2, data3, data4, data5;

			switch (choice) {
			case 1:

				System.out.print("Country=");
				country = scanner.next().toLowerCase().trim();

				System.out.print("Month=");
				month = scanner.next().toLowerCase().trim();

				data1 = cliDao.getLowestTempByMonth(country, month);
				System.out.println(
						"The lowest temperature in " + country + " in " + month + " was :" + data1.getTemperature());

				data2 = cliDao.getHighestTempByMonth(country, month);
				System.out.println(
						"The highest temperature in " + country + " in " + month + " was :" + data2.getTemperature());

				break;

			case 2:

				System.out.print("Country=");
				country = scanner.next().toLowerCase().trim();

				System.out.print("Year=");
				year = scanner.nextInt();

				data3 = cliDao.getLowestTempByYear(country, year);
				System.out.println("The lowest temperature month is :" + data3.getMonth());

				data4 = cliDao.getHighestTempByYear(country, year);
				System.out.println("The highest temperature month is :" + data4.getMonth());

				break;

			case 3:

				System.out.print("Country=");
				country = scanner.next().toLowerCase().trim();

				System.out.println("Highest Temp = ");
				double high = scanner.nextDouble();

				System.out.println("Lowest Temp = ");
				double low = scanner.nextDouble();

				List<ITemperature> data = cliDao.getTempWithinRange(country, low, high);

				for (ITemperature iTemperature : data) {
					System.out.println(iTemperature);
				}

				break;

			case 4:

				System.out.print("Country=");
				country = scanner.next().toLowerCase().trim();

				data3 = cliDao.getLowestTempYearByCountry(country);
				System.out.println("Lowest temperature in " + country + " in was : " + data3.getYear());

				data4 = cliDao.getHighestTempYearByCountry(country);
				System.out.println("Highest temperature in " + country + " in was : " + data4.getYear());

				break;

			case 5:

				System.out.print("Month=");
				month = scanner.next().toLowerCase().trim();

				List<ITemperature> listData = cliDao.allCountriesGetTop10LowestTemp(month);

				break;

			default:
				System.out.println("Incorrect input!!! Please re-enter choice from our menu");
			}
		}

	}
}
