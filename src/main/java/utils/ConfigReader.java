package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

//Config reader file is used to read url and browser at runtime
//at run time we can provide input for browser type e.g. chrome, firefox or safari

public class ConfigReader {
	
	private static Properties properties;
	
	private static void loadProperties() {
		
		if(properties == null) {
			properties = new Properties();
		}		
		try {
			FileInputStream file = new FileInputStream(Constants.configReader);
			properties.load(file);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static String getProperty(String key) {
		
		loadProperties();  							// Ensure properties are loaded before access
		
		return System.getProperty(key, properties.getProperty(key));
		
	}

}
