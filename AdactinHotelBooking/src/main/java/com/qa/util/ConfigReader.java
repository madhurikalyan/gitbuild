package com.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	public static String URL;
	public static Properties prop;
	
	
	
	public static Properties init_prop() {
		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream("./src/test/resources/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;

	}

	public static  String readBrowser() throws IOException {
		prop = init_prop();
		String browservalue=prop.getProperty("browser");
		return browservalue;
	}
	public static  String readLoginURL() {
		prop = init_prop();
		String LoginURL=prop.getProperty("loginURL");
		return LoginURL;
	}
	public static  String readsearchHotelURL() {
		prop = init_prop();
		String searchHotelURL=prop.getProperty("searchHotelURL");
		return searchHotelURL;
	}
	public static  String readexcel_SearchHotel() {
		prop = init_prop();
		String excel_SearchHotel=prop.getProperty("excel_SearchHotel");
		return excel_SearchHotel;
	}	
	public static  String readBookHotelURL() {
		prop = init_prop();
		String BookHotelURL=prop.getProperty("BookHotelURL");
		return BookHotelURL;
	}	
	public static  String readjson_Payment() {
		prop = init_prop();
		String json_Payment=prop.getProperty("json_Payment");
		return json_Payment;
	}	
	public static  String readuserid() {
		prop = init_prop();
		String login_userid=prop.getProperty("userid");
		return login_userid;
	}
	public static  String readpswrd() {
		prop = init_prop();
		String login_pswrd=prop.getProperty("pswrd");
		return login_pswrd;
	}
}
