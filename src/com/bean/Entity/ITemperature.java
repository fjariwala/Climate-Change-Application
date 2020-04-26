package com.bean.Entity;

public class ITemperature {

	private double temperature;
	private int year;
	private String month;
	private String country;
	private String country3LetterCode;

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country.toLowerCase().trim();
	}

	public String getCountry3LetterCode() {
		return country3LetterCode;
	}

	public void setCountry3LetterCode(String country3LetterCode) {
		this.country3LetterCode = country3LetterCode.toLowerCase().trim();
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month.toLowerCase().trim();
	}

	public double getTemperature() {
		return temperature;
	}

	public void setTemperature(double temperature) {
		double roundOffTemp = (double) Math.round(temperature * 100) / 100;
		this.temperature = roundOffTemp;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "ITemperature [temperature=" + temperature + ", year=" + year + ", month=" + month + ", country="
				+ country + ", country3LetterCode=" + country3LetterCode + "]";
	}

}
