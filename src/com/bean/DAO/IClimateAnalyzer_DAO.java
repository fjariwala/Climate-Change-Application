package com.bean.DAO;

import java.util.ArrayList;
import java.util.List;

import com.bean.Entity.ITemperature;

public interface IClimateAnalyzer_DAO {

	public ITemperature getLowestTempByMonth(String country, String month);

	public ITemperature getHighestTempByMonth(String country, String month);

	public ITemperature getLowestTempByYear(String country, int year);

	public ITemperature getHighestTempByYear(String country, int year);

	public List<ITemperature> getTempWithinRange(String country, double rangeLowTemp, double rangeHighTemp);

	public ITemperature getLowestTempYearByCountry(String country);

	public ITemperature getHighestTempYearByCountry(String country);

	public List<ITemperature> allCountriesGetTop10LowestTemp(String month);

	public List<ITemperature> allCountriesGetTop10HighestTemp(String month);

	public ArrayList<ITemperature> allCountriesGetTop10LowestTemp();

	public ArrayList<ITemperature> allCountriesGetTop10HighestTemp();

	public ArrayList<ITemperature> allCountriesGetAllDataWithinTempRange(double lowRangeTemp, double highRangeTemp);

	public ArrayList<ITemperature> allCountriesTop10TempDelta(String month, int year1, int year2);

	public void runClimateAnalyzer();
}
