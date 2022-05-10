package JavaScriptExecutorPractise;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.internal.EventFiringTouch;
import org.openqa.selenium.support.ui.Select;

public class Dropdown1 {

	public static void main(String[] args) throws InterruptedException {

		// 1. open chrome browser //set property
		System.setProperty("webdriver.chrome.driver",  "D:\\SeleniumSoftwares\\All Selenium Jar Files\\chromedriver_win32V94\\chromedriver.exe");		//		  
		WebDriver driver= new ChromeDriver();
		
		// open url in browser
		driver.get("file:///D:/Practise/qtp%20practise/web%20apps/ALL%20Web%20objects.html");
			
		//  select any val from dropdpwn
		WebElement CarsDropdpwnEle= driver.findElement(By.xpath("//select[@name='cars']"));
		
		
		
		//document.getElementById("bikesid").selectedIndex="1";
		
		// ????????????????  
		//document.getElementById("bikesid").selectedIndex;
		
		
		
		// get sleectd val from dropdown  ?????? ??
		
		
		System.out.println("ends");

	}

}
