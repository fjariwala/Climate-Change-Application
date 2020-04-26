package com.bean.DAO;

import java.util.ArrayList;
import java.util.List;

import com.bean.Entity.ITemperature;

public interface IWeatherIO_DAO {

	public List<ITemperature> readDataFromFile();

	public void writeSubjectHeaderInFile(String filename, String subject);

	public void writeDataToFile(String filename, String topic, ArrayList<ITemperature> theWeatherList);
}
