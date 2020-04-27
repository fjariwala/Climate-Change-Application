package climatechange;

import java.util.Comparator;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;

public class ITemperature implements Comparator<ITemperature> {

	@CsvBindByName(column = "temperature")
	@CsvBindByPosition(position = 0)
	private double temperature;

	@CsvBindByName(column = "year")
	@CsvBindByPosition(position = 1)
	private int year;

	@CsvBindByName(column = "month")
	@CsvBindByPosition(position = 2)
	private String month;

	@CsvBindByName(column = "country")
	@CsvBindByPosition(position = 3)
	private String country;

	@CsvBindByName(column = "country3LetterCode")
	@CsvBindByPosition(position = 4)
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

//	@Override
//	public int compareTo(ITemperature s) {
//		return Integer.compare(s.getTemperature(), getTemperature());
//	}

	@Override
	public int compare(ITemperature o1, ITemperature o2) {
		// TODO Auto-generated method stub
		return 0;
	}

}
