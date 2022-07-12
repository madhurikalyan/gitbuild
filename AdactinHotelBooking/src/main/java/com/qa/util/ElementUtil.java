package com.qa.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ElementUtil {
	static FileReader reader;
	static JSONParser jsonparser = new JSONParser();
	static JSONObject jsonObject = null;
	String keyvalue=null;
	public static JSONObject getJSONObjectfromJSONFile() throws IOException, ParseException {
		
		try {
			reader = new FileReader(ConfigReader.readjson_Payment());
			Object obj = jsonparser.parse(reader);
			 jsonObject = (JSONObject)obj;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonObject;
	}
	public static String getvalueFromJSONObject(String key) throws IOException, ParseException {
		JSONObject jsonObject=getJSONObjectfromJSONFile();
		String keyvalue=(String) jsonObject.get(key);
		return keyvalue;
		
	}
}
