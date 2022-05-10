package AllWebElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Checkbox {

	public static void main(String[] args) throws InterruptedException {

		// 1. open chrome browser //set property
	//	System.setProperty("webdriver.chrome.driver",  "D:\\SeleniumSoftwares\\All Selenium Jar Files\\chromedriver_win32V94\\chromedriver.exe");		//		  
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		
		// open url in browser
		driver.get("file:///D:/Practise/qtp%20practise/web%20apps/ALL%20Web%20objects.html");
			
		// click or sleect checkbox
//		bikeid
		driver.findElement(By.xpath("//input[@value='Bike']")).click();
		
		driver.findElement(By.xpath("//input[@value='Car']")).click();
		
		// Hw1: checkbox is sleectd
		
		// Hw2 : Checkbox is displayed
		
		//Hw: checkbox is enabled
		
		// unsleect checkbox
		driver.findElement(By.xpath("//input[@value='Bike']")).click();
		
		driver.findElement(By.xpath("//input[@value='Car']")).click();
		// Hw1: checkbox is selectd or not			


	}

}
