package com.qa.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import com.qa.factory.Driver_Factory;

import io.cucumber.java.Scenario;

public class Screenshot_Utility extends Driver_Factory{
	
	private ConfigReader config =new ConfigReader();
public  void captureScreenshot(String screenshotName) throws Exception {
		
		TakesScreenshot ts = (TakesScreenshot)getDriver();
	File source=ts.getScreenshotAs(OutputType.FILE);
	
		FileUtils.copyFile(source, new File(config.readPassedScreenshotFile(),screenshotName+".png"));

	
	
}
}



