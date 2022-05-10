package AllWebElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class RadioButton {


	public static void main(String[] args) throws InterruptedException {

		// 1. open chrome browser //set property
	//	System.setProperty("webdriver.chrome.driver",  "D:\\SeleniumSoftwares\\All Selenium Jar Files\\chromedriver_win32V94\\chromedriver.exe");		//		  
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		
		// open url in browser
		driver.get("file:///D:/Practise/qtp%20practise/web%20apps/ALL%20Web%20objects.html");
			
		// Click
		driver.findElement(By.xpath("//input[@id='maleid']")).click();
		
		// Hw: Click Female raduo button
		
		// Selected or not
		boolean isSelected=driver.findElement(By.xpath("//input[@id='maleid']")).isSelected();
		System.out.println("isSelected= "+isSelected);// true
		
		// check radio button isdisplayed
		boolean isDisplayed=driver.findElement(By.xpath("//input[@id='maleid']")).isDisplayed();
		System.out.println("isDisplayed= "+isDisplayed);// true
		
		// check ele is enabled		
		boolean isEnabled=driver.findElement(By.xpath("//input[@id='maleid']")).isEnabled();
		System.out.println("isEnabled= "+isEnabled);// true
		
		// check female radio btn is selected
		isSelected=driver.findElement(By.xpath("//input[@id='femaleid']")).isSelected();
		System.out.println("isSelected= "+isSelected);// false
		
		driver.findElement(By.xpath("//input[@id='femaleid']")).click();
		
		isSelected=driver.findElement(By.xpath("//input[@id='femaleid']")).isSelected();
		System.out.println("isSelected= "+isSelected);// true
		
		
		// Hw: -ve  invalid xpath or if ele not found , noSuchelementfoundexception
		
		
		
		
	}

}
