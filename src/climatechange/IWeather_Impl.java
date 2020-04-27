package climatechange;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.HeaderColumnNameTranslateMappingStrategy;

public class IWeather_Impl implements IWeatherIO_DAO {

	@Override
	public ArrayList<ITemperature> readDataFromFile() {
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
			return (ArrayList<ITemperature>) list;

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
		final String csv = "C:\\Users\\fenil\\Desktop\\" + topic + filename + ".csv";

		List<String> list = new ArrayList<>();

		for (ITemperature string : theWeatherList) {

			list.add(string.toString());
		}

//		for (String string : list) {
//			System.out.println(string);
//		}

		String collect = list.stream().collect(Collectors.joining(","));

		try {

			FileWriter writer = new FileWriter(csv);
			System.out.println(collect);

			writer.write(collect);
			writer.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*---------------------------------------------------------------*/

//		try {
//
//			// Creating writer class to generate
//			// csv file
//			FileWriter writer = new FileWriter(csv);
//
//			// create a list of employee
//			List<ITemperature> tempList = new ArrayList<ITemperature>();
//
//			for (ITemperature iTemperature : theWeatherList) {
//				tempList.add(iTemperature);
//			}
//			for (ITemperature iTemperature : tempList) {
//				System.out.println(iTemperature);
//			}
//
//			// Create Mapping Strategy to arrange the
//			// column name in order
//			ColumnPositionMappingStrategy<ITemperature> mappingStrategy = new ColumnPositionMappingStrategy<ITemperature>();
//			mappingStrategy.setType(ITemperature.class);
//
//			// Arrange column name as provided in below array.
//			String[] columns = new String[] { "temperature", "year", "month", "country", "country3LetterCode" };
//			mappingStrategy.setColumnMapping(columns);
//
//			// Creating StatefulBeanToCsv object
//			StatefulBeanToCsvBuilder<ITemperature> builder = new StatefulBeanToCsvBuilder<ITemperature>(writer);
//			StatefulBeanToCsv<ITemperature> beanWriter = builder.withMappingStrategy(mappingStrategy).build();
//
//			// Write list to StatefulBeanToCsv object
//			beanWriter.write(tempList);
//
//			// closing the writer object
//			writer.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

//		ColumnPositionMappingStrategy<ITemperature> mappingStrategy = new ColumnPositionMappingStrategy<>();
//		mappingStrategy.setType(ITemperature.class);
//
//		Writer writer = new FileWriter(csv);
//		StatefulBeanToCsv<ITemperature> beanToCsv = new StatefulBeanToCsvBuilder<ITemperature>(writer)
//				.withMappingStrategy(mappingStrategy).withSeparator(',').withApplyQuotesToAll(false).build();
//		beanToCsv.write(theWeatherList);
//		writer.close();
	}

}
