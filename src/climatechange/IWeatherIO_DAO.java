package climatechange;

import java.util.ArrayList;

public interface IWeatherIO_DAO {

	public ArrayList<ITemperature> readDataFromFile();

	public void writeSubjectHeaderInFile(String filename, String subject);

	void writeDataToFile(String filename, String topic, ArrayList<ITemperature> theWeatherList);
}
