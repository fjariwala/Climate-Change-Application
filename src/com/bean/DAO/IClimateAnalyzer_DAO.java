package com.bean.DAO;

import java.util.ArrayList;
import java.util.TreeSet;

import com.bean.Entity.ITemperature;

public interface IClimateAnalyzer_DAO {

	public ITemperature getData();

	public ITemperature getLowestTempByMonth(String country, int month);

	public ITemperature getHighestTempByMonth(String country, int month);

	public ITemperature getLowestTempByYear(String country, int year);

	public ITemperature getHighestTempByYear(String country, int year);

	public TreeSet<ITemperature> getTempWithinRange(String country, double rangeLowTemp, double rangeHighTemp);

	public ITemperature getLowestTempYearByCountry(String country);

	public ITemperature getHighestTempYearByCountry(String country);

	public ArrayList<ITemperature> allCountriesGetTop10LowestTemp(int month);

	public ArrayList<ITemperature> allCountriesGetTop10HighestTemp(int month);

	public ArrayList<ITemperature> allCountriesGetTop10LowestTemp();

	public ArrayList<ITemperature> allCountriesGetTop10HighestTemp();

	public ArrayList<ITemperature> allCountriesGetAllDataWithinTempRange(double lowRangeTemp, double highRangeTemp);

	public ArrayList<ITemperature> allCountriesTop10TempDelta(int month, int year1, int year2);

	public void runClimateAnalyzer();
}
