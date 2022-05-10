package FrameHandling;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.internal.EventFiringTouch;

public class InnerFrameHandling {

	public static void main(String[] args) throws InterruptedException {
		// 1. open chrome browser //set property
		System.setProperty("webdriver.chrome.driver",  "D:\\SeleniumSoftwares\\All Selenium Jar Files\\chromedriver_win32V94\\chromedriver.exe");		//		  
		WebDriver driver= new ChromeDriver();
		
		// open url in browser
		driver.get("file:///D:/Practise/qtp%20practise/web%20apps/NestedFrames.html");
		// use https://chercher.tech/practice/frames-example-selenium-webdriver
		//*********************************
		
		driver.switchTo().frame("iframe2name");
		 driver.findElement(By.name("username")).sendKeys("My user name");
		  driver.findElement(By.name("password")).sendKeys("My pwd");
		  //
//		  driver.switchTo().defaultContent();//if u write also, it is working ????
		  
		  // switch to inner frame
		  driver.switchTo().frame("iframe3name");	//NoSuchFrameException: No frame element found by name or id iframe3name
		  
		  driver.findElement(By.name("firstname")).sendKeys("My first name");
			 driver.findElement(By.name("username")).sendKeys("My user name-2");

		System.out.println("end ");
		
		//********************************
	


	}

}
