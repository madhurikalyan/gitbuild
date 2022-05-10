package JavaScriptExecutorPractise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.internal.EventFiringTouch;

public class Checkbox {

	public static void main(String[] args) throws InterruptedException {

		// 1. open chrome browser //set property
		System.setProperty("webdriver.chrome.driver",  "D:\\SeleniumSoftwares\\All Selenium Jar Files\\chromedriver_win32V94\\chromedriver.exe");		//		  
		WebDriver driver= new ChromeDriver();
		
		// open url in browser
		driver.get("file:///D:/Practise/qtp%20practise/web%20apps/ALL%20Web%20objects.html");
			
		// click or sleect checkbox
//		Hw1:
//			document.getElementById("bikeid").click();
			
			
			
			// 2 
			//document.getElementById("bikeid").checked=true;
			
			
		
		// Hw1: bike checkbox is sleectd	
		
		
		
		// HW2 unsleect checkbox
		//document.getElementById("bikeid").checked=false;
			
			// Hw1: bike checkbox is sleectd
//			document.getElementById("bikeid").checked;
			
			
			


	}

}
