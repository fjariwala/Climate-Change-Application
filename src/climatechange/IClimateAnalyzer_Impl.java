package climatechange;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class IClimateAnalyzer_Impl implements IClimateAnalyzer_DAO {

	IWeatherIO_DAO wDao = new IWeather_Impl();

	@Override
	public ITemperature getLowestTempByMonth(String country, String month) {
		// TODO Auto-generated method stub
		List<ITemperature> data = wDao.readDataFromFile();

		// taking low temprature as 0
		double lowTemp = 200.00;
		ITemperature newObject = null;
		int count = 0;

		for (ITemperature iTemperature : data) {

			/* Setting up the temporary variables */
			String con = iTemperature.getCountry();
			String mon = iTemperature.getMonth();

			if (con.equals(country) && mon.equals(month) && iTemperature.getTemperature() < lowTemp) {
				count++;
				lowTemp = iTemperature.getTemperature();
				newObject = iTemperature;
			}
		}
		// System.out.println("Total =" + count);
		return newObject;
	}

	@Override
	public ITemperature getHighestTempByMonth(String country, String month) {
		// TODO Auto-generated method stub
		List<ITemperature> data = wDao.readDataFromFile();

		// taking low temprature as 0
		double highTemp = -400.00;
		ITemperature newObject = null;

		for (ITemperature iTemperature : data) {

			/* Setting up the temporary variables */
			String con = iTemperature.getCountry();
			String mon = iTemperature.getMonth();

			if (con.equals(country) && mon.equals(month) && iTemperature.getTemperature() > highTemp) {
				highTemp = iTemperature.getTemperature();
				newObject = iTemperature;
			}
		}
		// System.out.println("Total =" + count);
		return newObject;
	}

	@Override
	public ITemperature getLowestTempByYear(String country, int year) {
		// TODO Auto-generated method stub
		List<ITemperature> data = wDao.readDataFromFile();

		double lowTemp = 200.00;
		ITemperature newObject = null;

		for (ITemperature iTemperature : data) {

			String con = iTemperature.getCountry();
			int ye = iTemperature.getYear();

			if (con.equals(country) && ye == year && iTemperature.getTemperature() < lowTemp) {

				lowTemp = iTemperature.getTemperature();
				newObject = iTemperature;
			}
		}

		return newObject;
	}

	@Override
	public ITemperature getHighestTempByYear(String country, int year) {
		// TODO Auto-generated method stub
		List<ITemperature> data = wDao.readDataFromFile();

		double highTemp = -400;
		ITemperature newObject = null;

		for (ITemperature iTemperature : data) {

			String con = iTemperature.getCountry();
			int ye = iTemperature.getYear();

			if (con.equals(country) && ye == year && iTemperature.getTemperature() > highTemp) {

				highTemp = iTemperature.getTemperature();
				newObject = iTemperature;
			}
		}

		return newObject;
	}

	@Override
	public List<ITemperature> getTempWithinRange(String country, double rangeLowTemp, double rangeHighTemp) {
		// TODO Auto-generated method stub

		List<ITemperature> data = wDao.readDataFromFile();
		List<ITemperature> treeData = new ArrayList<ITemperature>();

		for (ITemperature iTemperature : data) {

			if (iTemperature.getCountry().equals(country) && rangeLowTemp <= iTemperature.getTemperature()
					&& iTemperature.getTemperature() <= rangeHighTemp) {

				treeData.add(iTemperature);
			}

		}

		return treeData;
	}

	@Override
	public ITemperature getLowestTempYearByCountry(String country) {
		// TODO Auto-generated method stub
		List<ITemperature> data = wDao.readDataFromFile();

		// taking low temprature as 0
		double lowTemp = 200.00;
		ITemperature newObject = null;

		for (ITemperature iTemperature : data) {

			/* Setting up the temporary variables */
			String con = iTemperature.getCountry();

			if (con.equals(country) && iTemperature.getTemperature() < lowTemp) {
				lowTemp = iTemperature.getTemperature();
				newObject = iTemperature;
			}
		}

		return newObject;
	}

	@Override
	public ITemperature getHighestTempYearByCountry(String country) {
		// TODO Auto-generated method stub
		List<ITemperature> data = wDao.readDataFromFile();

		// taking low temprature as 0
		double highTemp = -400.00;
		ITemperature newObject = null;

		for (ITemperature iTemperature : data) {

			/* Setting up the temporary variables */
			String con = iTemperature.getCountry();

			if (con.equals(country) && iTemperature.getTemperature() > highTemp) {
				highTemp = iTemperature.getTemperature();
				newObject = iTemperature;
			}
		}

		return newObject;
	}

	@Override
	public List<ITemperature> allCountriesGetTop10LowestTemp(String month) {
		// TODO Auto-generated method stub
		List<ITemperature> data = wDao.readDataFromFile();

		List<ITemperature> filteredData = new ArrayList<>();

		Collections.sort(data, new Comparator<ITemperature>() {
			@Override
			public int compare(ITemperature o1, ITemperature o2) {
				return Double.compare(o2.getTemperature(), o1.getTemperature());
			}
		});

		// Collections.sort(data, Collections.reverseOrder());

		for (ITemperature iTemperature : data) {
			String mon = iTemperature.getMonth();
			if (mon.equals(month) == true) {
				filteredData.add(iTemperature);
			}
		}

		return filteredData;
	}

	@Override
	public List<ITemperature> allCountriesGetTop10HighestTemp(String month) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ITemperature> allCountriesGetTop10LowestTemp() {
		// TODO Auto-generated method stub
		List<ITemperature> data = wDao.readDataFromFile();

		Collections.sort(data, new Comparator<ITemperature>() {
			@Override
			public int compare(ITemperature o1, ITemperature o2) {
				return Double.compare(o2.getTemperature(), o1.getTemperature());
			}
		});
		Collections.reverse(data);

		return (ArrayList<ITemperature>) data;
	}

	@Override
	public ArrayList<ITemperature> allCountriesGetTop10HighestTemp() {
		// TODO Auto-generated method stub
		List<ITemperature> data = wDao.readDataFromFile();

		Collections.sort(data, new Comparator<ITemperature>() {
			@Override
			public int compare(ITemperature o1, ITemperature o2) {
				return Double.compare(o2.getTemperature(), o1.getTemperature());
			}
		});
		return (ArrayList<ITemperature>) data;
	}

	@Override
	public ArrayList<ITemperature> allCountriesGetAllDataWithinTempRange(double lowRangeTemp, double highRangeTemp) {
		// TODO Auto-generated method stub
		List<ITemperature> data = wDao.readDataFromFile();
		List<ITemperature> filteredData = new ArrayList<ITemperature>();

		for (ITemperature iTemperature : data) {
			double temp = iTemperature.getTemperature();

			if (temp > lowRangeTemp && temp < highRangeTemp) {
				filteredData.add(iTemperature);

			}
		}

		return (ArrayList<ITemperature>) filteredData;
	}

	@Override
	public ArrayList<ITemperature> allCountriesTop10TempDelta(String month, int year1, int year2) {
		// TODO Auto-generated method stub

		List<ITemperature> data = wDao.readDataFromFile();
		List<ITemperature> filteredData = new ArrayList<ITemperature>();

		double lowestTemp = 400;
		double highestTemp = -400;

		for (ITemperature iTemperature : data) {

			double year = iTemperature.getYear();
			double temp = iTemperature.getTemperature();
			String mon = iTemperature.getMonth();

			if (year1 < year && year < year2 && mon.equals(month)) {

				if (temp < lowestTemp) {
					lowestTemp = temp;

					if (temp > highestTemp) {
						highestTemp = temp;
						filteredData.add(iTemperature);
					}
				}
			}
		}

		return (ArrayList<ITemperature>) filteredData;
	}

	@Override
	public void runClimateAnalyzer() {
		// TODO Auto-generated method stub

	}

}
