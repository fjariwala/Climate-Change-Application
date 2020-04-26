package com.bean.DAO;

import java.util.ArrayList;
import java.util.TreeSet;

import com.bean.Entity.ITemperature;

public class IClimateAnalyzer_Impl implements IClimateAnalyzer_DAO {

	@Override
	public ITemperature getData() {
		// TODO Auto-generated method stub

		return null;
	}

	@Override
	public ITemperature getLowestTempByMonth(String country, int month) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ITemperature getHighestTempByMonth(String country, int month) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ITemperature getLowestTempByYear(String country, int year) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ITemperature getHighestTempByYear(String country, int year) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TreeSet<ITemperature> getTempWithinRange(String country, double rangeLowTemp, double rangeHighTemp) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ITemperature getLowestTempYearByCountry(String country) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ITemperature getHighestTempYearByCountry(String country) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ITemperature> allCountriesGetTop10LowestTemp(int month) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ITemperature> allCountriesGetTop10HighestTemp(int month) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ITemperature> allCountriesGetTop10LowestTemp() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ITemperature> allCountriesGetTop10HighestTemp() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ITemperature> allCountriesGetAllDataWithinTempRange(double lowRangeTemp, double highRangeTemp) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ITemperature> allCountriesTop10TempDelta(int month, int year1, int year2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void runClimateAnalyzer() {
		// TODO Auto-generated method stub

	}

}
