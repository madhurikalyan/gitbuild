package com.qa.util;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.qa.factory.Driver_Factory;

public class Screenshot_Utility extends Driver_Factory{
	
	private ConfigReader config =new ConfigReader();
public  void captureScreenshot(String screenshotName) throws Exception {
	int c=0;
	c++;
	String exeTime = new SimpleDateFormat("ddMMYYYYHH").format(new Date());
		TakesScreenshot ts = (TakesScreenshot)getDriver();
	File source=ts.getScreenshotAs(OutputType.FILE);
	File f = new File(config.readPassedScreenshotFile()+"\\"+exeTime);
	if(f.exists() && !f.isDirectory()) { 
		FileUtils.copyFile(source, new File(config.readPassedScreenshotFile()+"\\"+exeTime+c,screenshotName+".png"));
		c++;
	}	
	else {
		FileUtils.copyFile(source, new File(config.readPassedScreenshotFile()+"\\"+exeTime,screenshotName+".png"));
	}
	
	
}
}



