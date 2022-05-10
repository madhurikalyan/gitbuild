package JavaScriptExecutorPractise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.internal.EventFiringTouch;

public class RadioButton {


	public static void main(String[] args) throws InterruptedException {

		// 1. open chrome browser //set property
		System.setProperty("webdriver.chrome.driver",  "D:\\SeleniumSoftwares\\All Selenium Jar Files\\chromedriver_win32V94\\chromedriver.exe");		//		  
		WebDriver driver= new ChromeDriver();
		
		// open url in browser
		driver.get("file:///D:/Practise/qtp%20practise/web%20apps/ALL%20Web%20objects.html");
			
		//1/ Click male radio btn
//		document.getElementById("maleid").click();
		
		//2 with 2 args
		
//		/.args check male radiobutn is sleectdor not
				
		
		// Hw: Click Female raduo button
		
		//HW: check feamle radio btnn is Selected or not
	
		
		// HW2 way with2 args
		
		
		// Hw: -ve  invalid xpath or if ele not found , noSuchelementfoundexception
		
		
		
		
	}

}
