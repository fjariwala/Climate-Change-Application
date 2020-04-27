package climatechange;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Application {

	public static void main(String[] args) {

		IClimateAnalyzer_DAO cliDao = new IClimateAnalyzer_Impl();
		IWeatherIO_DAO weDao = new IWeather_Impl();

		System.out.println("====== Climate Change Analysis Application ======");

		Scanner scanner = new Scanner(System.in);

		System.out.println("\nPlease select the query");

		while (true) {
			System.out.println("\n----------A----------");
			System.out.println("1) Get data which has the lowest and highest temperature reading for a given month. ");
			System.out
					.println("2) Get data for the month which has the lowest and highest temperature in a given year.");
			System.out.println("3) Get all data that falls within a specific temperature range");
			System.out.println(
					"4) Get data for the year with the lowest temperature and for the year with the highest\r\n"
							+ "temperature reading");
			System.out.println("----------B----------");
			System.out.println(
					"5) The top 10 countries with the lowest temperature reading and the top 10 countries with\r\n"
							+ "the highest temperature reading for a given month between 2000 and 2016.");
			System.out.println(
					"6) The top 10 countries with the lowest temperature reading and the top 10 countries with\r\n"
							+ "the highest temperature readings between 2000 and 2016");
			System.out.println("7) List all of the countries that fall within a specific temperature range");
			System.out.println("----------C----------");
			System.out.println(
					"8) The top 10 countries with the largest change in temperature in the same month between\r\n"
							+ "two different years (given), for example: March 2000 and March 2016. Consider absolute\r\n"
							+ "values such as -14C to 28C = 42C )");

			System.out.print("\nChoice =");
			int choice = scanner.nextInt();

			String country, month;
			int year;

			ArrayList<ITemperature> writableData = new ArrayList<ITemperature>();

			ITemperature data1, data2, data3, data4, data5;

			switch (choice) {
			case 1:

				System.out.print("Country=");
				country = scanner.next().toLowerCase().trim();

				System.out.print("Month=");
				month = scanner.next().toLowerCase().trim();

				data1 = cliDao.getLowestTempByMonth(country, month);

				/* A1 */
				System.out.println(
						"The lowest temperature in " + country + " in " + month + " was :" + data1.getTemperature());

				/* Printing to the file */

				/* Writable arraylist */
				writableData.add(data1);
				// weDao.writeDataToFile("_climate_info", "taskA1", writableData);

				/* A2 */
				data2 = cliDao.getHighestTempByMonth(country, month);
				System.out.println(
						"The highest temperature in " + country + " in " + month + " was :" + data2.getTemperature());

				/* Writing to the file */
				writableData.add(data2);
				weDao.writeDataToFile("_climate_info", "taskA1", writableData);

				break;

			case 2:

				System.out.print("Country=");
				country = scanner.next().toLowerCase().trim();

				System.out.print("Year=");
				year = scanner.nextInt();

				data3 = cliDao.getLowestTempByYear(country, year);
				writableData.add(data3);
				System.out.println("The lowest temperature month is :" + data3.getMonth());

				data4 = cliDao.getHighestTempByYear(country, year);
				writableData.add(data4);
				System.out.println("The highest temperature month is :" + data4.getMonth());

				weDao.writeDataToFile("_climate_info", "taskA2", writableData);

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

				/* Writing to file */
				for (ITemperature iTemperature : data) {
					writableData.add(iTemperature);
				}
				// writableData.add(data);
				weDao.writeDataToFile("_climate_info", "taskA3", writableData);

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

				System.out.println("\nTop 10 high to low temperatures in month : " + month + " are => \n");
				List<ITemperature> firstNElementsList = listData.stream().limit(10).collect(Collectors.toList());
				for (ITemperature iTemperature : firstNElementsList) {
					System.out.println(iTemperature);
				}
				System.out.println("This output is vise versa of Lower to higher..");

				break;

			case 6:
				/* Lowest top 10 */
				List<ITemperature> listData1 = cliDao.allCountriesGetTop10LowestTemp();
				System.out.println("\nAll countries top 10 lowest =>");

				List<ITemperature> firstNElementsList1 = listData1.stream().limit(10).collect(Collectors.toList());
				for (ITemperature iTemperature : firstNElementsList1) {
					System.out.println(iTemperature);
				}

				/* Highest top 10 */
				List<ITemperature> listData2 = cliDao.allCountriesGetTop10HighestTemp();
				System.out.println("\nAll countries top 10 highest =>");

				List<ITemperature> firstNElementsList2 = listData2.stream().limit(10).collect(Collectors.toList());
				for (ITemperature iTemperature : firstNElementsList2) {
					System.out.println(iTemperature);
				}

				break;

			case 7:
				/* All countries range */

				System.out.println("Highest Temp = ");
				double high1 = scanner.nextDouble();

				System.out.println("Lowest Temp = ");
				double low1 = scanner.nextDouble();
				int count = 0;

				List<ITemperature> rangeData = cliDao.allCountriesGetAllDataWithinTempRange(low1, high1);

				System.out.println("\nThe temperature data within range of " + low1 + " to " + high1 + " is ");
				for (ITemperature iTemperature : rangeData) {
					System.out.println(iTemperature);
					count++;
				}
				System.out.println(count + " results");
				break;

			case 8:

				/* Difference between months */

				System.out.print("Month = ");
				month = scanner.next().toLowerCase().trim();

				System.out.print("\nLowest Year = ");
				int y1 = scanner.nextInt();

				System.out.print("\nHighest Year = ");
				int y2 = scanner.nextInt();

				List<ITemperature> tempData = cliDao.allCountriesTop10TempDelta(month, y1, y2);
				System.out.println("\n The major change data are => ");
				for (ITemperature iTemperature : tempData) {
					System.out.println(tempData);
				}

				break;

			default:
				System.out.println("Incorrect input!!! Please re-enter choice from our menu");
			}
		}

	}
}
