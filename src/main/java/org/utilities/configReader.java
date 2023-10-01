package org.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class configReader {

	public Properties getData() {

		try {	
			FileInputStream fis = new FileInputStream
					("./src/test/resources/org/config/Config.properties");
			Properties prop = new Properties();
			prop.load(fis);
			return prop;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
