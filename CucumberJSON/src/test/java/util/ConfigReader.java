package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	static Properties prop = new Properties();
	static String proFileName = "./src/test/java/util/config.Properties";
	static FileReader reader;
	
	public Properties init_prop() {

		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream("./src/test/java/util/config.Properties");
			prop.load(ip);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return prop;

	}
	
	public static String readJSONFilePath() throws Exception {
		try {
			reader=new FileReader(proFileName);
			prop.load(reader);
			//prop.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(proFileName));  
			return prop.getProperty("JSONFilePath");
	}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
			
	}
}
