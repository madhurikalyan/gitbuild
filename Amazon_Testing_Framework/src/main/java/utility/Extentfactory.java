package utility;

import com.relevantcodes.extentreports.ExtentReports;

public class Extentfactory {
 
	public static ExtentReports getInstance() {
		
		ExtentReports extent;
		
	     String Path = "./test-output\\reportdemoAmazon1.html";
	     extent = new ExtentReports(Path, false);

	return extent;


			
			
			
			
		}


}
