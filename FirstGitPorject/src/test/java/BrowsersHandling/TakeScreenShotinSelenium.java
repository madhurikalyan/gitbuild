package BrowsersHandling;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TakeScreenShotinSelenium {

	
	public static void main(String[] args) throws InterruptedException, IOException {

		// 1. open chrome browser //set property
		System.setProperty("webdriver.chrome.driver",  "D:\\SeleniumSoftwares\\All Selenium Jar Files\\chromedriver_win32V94\\chromedriver.exe");		//		  
		WebDriver driver= new ChromeDriver();
		
		// open url in browser
		driver.get("file:///D:/Practise/qtp%20practise/web%20apps/ALL%20Web%20objects.html");
		
		// TakesScreenshots  ---- Inter face in selenium
		
		
		
		//  store all screen in "TestResults" Folder in my project 
		
		// first get project folder name
		String ProjDir= System.getProperty("user.dir");			
		System.out.println("ProjDir="+ProjDir);
//		String username= System.getProperty("username");// if given key is not exist, it diaplsy null			
		String id= System.getProperty("username.id");
		System.out.println("id="+id);
		
		String username= System.getProperty("user.name");//username=brahma
		System.out.println("username="+username);
		
		//D:\\Practise\\FrameWorkDeisgnsPractiseWorkSpace\\SumanthNewSelenium
		
		File scrFile= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//System.out.println("Src= " +Src);
		// Src= C:\Users\brahma\AppData\Local\Temp\screenshot9906248943379099586.png
		//File destFile= new File("D:\\Practise\\FrameWorkDeisgnsPractiseWorkSpace\\SumanthNewSelenium\\src\\BrowsersHandling\\MyScreensot.jpg");
		File destFile= new File(ProjDir+"\\TestResults\\MyScreensot.jpg");	// overriade if we run again
		// but it does not throw any error 
		FileUtils.copyFile(scrFile, destFile);	// add common.io jar files 
				
		
		System.out.println("ends");

	}

}
