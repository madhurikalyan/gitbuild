package util;



import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONUtils {
	private static FileWriter file;
	static HashMap<String,Object> testSuiteData;
	static HashMap<String,Object> NestedtestSuiteData;
	static JSONArray value=null;
	//static String filePath = "./src/main/resources/testdataJSON/Imagility_CapH1B.json";
	static  HashMap<String, String> nestedTestDataMap;
	static HashMap<String, Object> MainTestData;
	 
	 
	/*
	 * @description: reads the data from JSON File & provides JSONArray
	 * @Param: JSON File Path as String
	 * @return: JSONArray
	 */
public static  JSONArray readJsonFiletoArray(String JsonPath) throws IOException, ParseException {
	FileReader reader = new FileReader(JsonPath);
	JSONParser parser = new JSONParser();
	JSONArray jsonArr = (JSONArray)parser.parse(reader);
	return jsonArr;
}
//----------------------------------------------
public static  JSONObject readJsonFiletoJSONObject(String JsonPath) throws IOException, ParseException {
	FileReader reader = new FileReader(JsonPath);
	JSONParser parser = new JSONParser();
	Object jsonArray = parser.parse(reader);
	JSONObject json =(JSONObject)jsonArray;
	return json;
}
//----------------------------------------------
public static int getrowcount(JSONArray jsonArr) throws IOException, ParseException  {
	//System.out.println(jsonArr.size());
	return jsonArr.size();
}
//----------------------------
/*
 * @description: reads the data from Object
 * @param :JSON Object
 * @return: stores Nested data in the form of Key-value pair in NestedtestSuiteData Map
 */

public static HashMap<String, Object> getTestDataintoMap(Object obj) {
	testSuiteData= new HashMap<String,Object>();	
	JSONObject json =(JSONObject)obj;
		@SuppressWarnings("unchecked")
		Set<String> Keys=json.keySet();
		Iterator<String> iterator = Keys.iterator();
	    if (iterator != null) {
	        while (iterator.hasNext()) {
	            String key = iterator.next();
				Object value = json.get(key);
				testSuiteData.put(key,value);
	         }
	    }
	return testSuiteData;
}
//------------------------
public static HashMap<String, String> getNestedTestDataintoMap(Object abc) {
	testSuiteData= new HashMap<String,Object>();
	nestedTestDataMap=new HashMap<String, String>();
	JSONObject json =(JSONObject)abc;
	@SuppressWarnings("unchecked")
	Set<String> Keys=json.keySet();
	Iterator<String> iterator = Keys.iterator();
    if (iterator != null) {
        while (iterator.hasNext()) {
            String key = iterator.next();
			String value = (String) json.get(key);
			nestedTestDataMap.put(key,value);
         }
    }
return nestedTestDataMap;
}
//------------------------------------------
public static HashMap<String, String> getNestedTestDataInMap(String Mainkey) {
	try {
		testSuiteData= new HashMap<String,Object>();
		nestedTestDataMap=new HashMap<String, String>();
		JSONObject jsonobj =(readJsonFiletoJSONObject(ReadPropertyFile.getJSONPath()));
		testSuiteData=getTestDataintoMap(jsonobj);
				value=(JSONArray) testSuiteData.get(Mainkey);
				String dataType = value.getClass().getSimpleName();  //JSONArray
				//System.out.println("value is:"+value +" & Datatype is : "+dataType);
				if(dataType.equalsIgnoreCase("JSONArray")) {
					for(Object obj:value) {
						nestedTestDataMap=getNestedTestDataintoMap(obj);
					}
				}
	} 
	catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return nestedTestDataMap;
	
}
//------------------------------------------
/*
 * @description: reads the data from a map corresponding to the key passed as string argument
 * @param :key for which data is to be fetched
 * @param :map in which data is stored
 * @return: row data as a Object
 */
public static Object getTestData(String Keyword, Map<String,Object> testSuiteData){
	testSuiteData= new HashMap<String,Object>();
	Object testData = new ArrayList<String>();
	try {
	testData = testSuiteData.get(Keyword);
	}
	catch(Exception e) {
	e.printStackTrace();
	}
	return testData;
}
//----------------------------------------------------------------------------

	 /*
	  * @description: reads the data from JSON Path
	  * @param :JSON File Path,Key to be searched, Nested Searchkey
	  * @return: NA
	  */
	public static String readJSONArraytoNestedValue(JSONArray jsonArr,String Searchkey, String nestedsearchkey) throws IOException, ParseException {
	String NestedValue= null;
		for(Object obj:jsonArr) {
			JSONObject json =(JSONObject)obj;
			@SuppressWarnings("unchecked")
			Set<String> Keys=json.keySet();
			Iterator<String> iterator = Keys.iterator();
		    if (iterator != null) {
		        while (iterator.hasNext()) {
		            String key = iterator.next();
		            if(key.equalsIgnoreCase(Searchkey)) {
			            Object value =  json.get(key);
			            String dataType = value.getClass().getSimpleName();
			            if (dataType.equalsIgnoreCase("JSONObject")){
							NestedtestSuiteData =getTestDataintoMap(value);
			            	 for (String name : NestedtestSuiteData.keySet())
			            		 if(name.equalsIgnoreCase(nestedsearchkey))
									NestedValue=(String) NestedtestSuiteData.get(name);
			            }
			        }
		        }   
	    }
		    	}//for
		return NestedValue;
	}
	/*
 * @description: reads the data from Object
 * @param :JSON Object & key to be searched in nested JSON Array/Block
 * @return: Stores the value of serached key from Nested JSON Block in an Object as nestedSearchedKeyData
 */
public static String getnestedSearchedKeyData(Object abc,String NestedSearchkey) {
	Map<String,Object> myNestedmap;
	String datatype=abc.getClass().getSimpleName();
	Object nestedSearchedKeyData = null;
	myNestedmap=getTestDataintoMap(abc);
	if(datatype.equalsIgnoreCase("JSONObject")) {
		nestedSearchedKeyData=getTestData(NestedSearchkey, myNestedmap);
	}
	return  (String) nestedSearchedKeyData;
}

//----------------------
@SuppressWarnings("unchecked")
public static JSONObject toJsonObject(HashMap<String, String> map) {
    JSONObject jsonObject = new JSONObject();

    for (String key : map.keySet()) {
        try {
            Object obj = map.get(key);
            if (obj instanceof Map) {
                jsonObject.put(key, toJsonObject((HashMap<String, String>) obj));
            }
            else {
                jsonObject.put(key, map.get(key));
            }
        }
        catch(Exception e) {
        	e.printStackTrace();
        }
    }
 //   System.out.println(jsonObject);
    return jsonObject;
}
//------------------------------------------
@SuppressWarnings("unchecked")
public static JSONArray toJsonArray(JSONObject jobj) {
	JSONArray jsonArray =new JSONArray();
	jsonArray.add(jobj);
	//System.out.println(jsonArray);
	return jsonArray;
	
}
//---------------------------------------------
public static HashMap<String, Object> ConvertJSONArray(String Mainkey,JSONArray jarray) {
	try {
		testSuiteData= new HashMap<String,Object>();
		JSONObject jsonobj =(readJsonFiletoJSONObject(ReadPropertyFile.getJSONPath()));
		testSuiteData=getTestDataintoMap(jsonobj);
		for(String mainKeyName: testSuiteData.keySet()) {
			if(mainKeyName.equals(Mainkey)) {
				testSuiteData.put(mainKeyName, jarray);
			}
		}	
	} 
	catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return testSuiteData;
	
}
//-----------------------------------------
@SuppressWarnings("unchecked")
public static JSONObject ObjectMaptoJsonObject(HashMap<String, Object> map) {
    JSONObject jsonObject = new JSONObject();

    for (String key : map.keySet()) {
        try {
            Object obj = map.get(key);
            if (obj instanceof Map) {
                jsonObject.put(key, toJsonObject((HashMap<String, String>) obj));
            }
            else {
                jsonObject.put(key, map.get(key));
            }
        }
        catch(Exception e) {
        	e.printStackTrace();
        }
    }
  //  System.out.println(jsonObject);
    return jsonObject;
}
//-------------------------------------------
public static void WriteintoJSONFile(String path,JSONObject jobj)  {
	
    try {
   	 file = new FileWriter(ReadPropertyFile.getJSONPath());
   	 file.write(jobj.toJSONString());
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    finally {
   	 
        try {
            file.flush();
            file.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
//----------------------------

public static void writing(String sheetname,HashMap<String, String> sheettestData) {
	JSONObject sheetJSONObject=toJsonObject(sheettestData);
	MainTestData=ConvertJSONArray(sheetname, toJsonArray(sheetJSONObject));
	JSONObject jj=ObjectMaptoJsonObject(MainTestData);
	WriteintoJSONFile(ReadPropertyFile.getJSONPath(),jj);
}
}
