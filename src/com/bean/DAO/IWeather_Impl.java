package com.bean.DAO;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bean.Entity.ITemperature;
import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.HeaderColumnNameTranslateMappingStrategy;

public class IWeather_Impl implements IWeatherIO_DAO {

	@Override
	public List<ITemperature> readDataFromFile() {
		// TODO Auto-generated method stub

		// Hash map to map CSV data to
		// Bean attributes.
		Map<String, String> mapping = new HashMap<String, String>();
		mapping.put("Temperature", "temperature");
		mapping.put(" Year", "year");
		mapping.put(" Month_Avg", "month");
		mapping.put(" Country", "country");
		mapping.put(" Country_Code", "country3LetterCode");

		// HeaderColumnNameTranslateMappingStrategy
		// for Temperature class
		HeaderColumnNameTranslateMappingStrategy<ITemperature> strategy = new HeaderColumnNameTranslateMappingStrategy<ITemperature>();
		strategy.setType(ITemperature.class);
		strategy.setColumnMapping(mapping);

		// Create castobaen and csvreader object
		CSVReader csvReader = null;
		try {
			csvReader = new CSVReader(new FileReader("D:\\Eclipse Workspace\\world_temp_2000-2016.csv"));

		} catch (FileNotFoundException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		CsvToBean<ITemperature> csvToBean = new CsvToBean<ITemperature>();

		// call the parse method of CsvToBean
		// pass strategy, csvReader to parse method
		try {

			List<ITemperature> list = csvToBean.parse(strategy, csvReader);
//			int count = 0;
//			for (ITemperature e : list) {
//				count++;
//				System.out.println(e);
//			}
//			System.out.println(count);
			return list;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public void writeSubjectHeaderInFile(String filename, String subject) {
		// TODO Auto-generated method stub

	}

	@Override
	public void writeDataToFile(String filename, String topic, ArrayList<ITemperature> theWeatherList) {
		// TODO Auto-generated method stub

	}

}
