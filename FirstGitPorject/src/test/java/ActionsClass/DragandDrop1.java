package ActionsClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


import io.github.bonigarcia.wdm.WebDriverManager;

public class DragandDrop1 {

	public static void main(String[] args) throws InterruptedException {

		// 1. open chrome browser //set property
//		System.setProperty("webdriver.chrome.driver",  "D:\\SeleniumSoftwares\\All Selenium Jar Files\\chromedriver_win32V95\\chromedriver.exe");		//		  
//		WebDriver driver= new ChromeDriver();
		
		//System.setProperty("webdriver.gecko.driver",  "D:\\SeleniumSoftwares\\All Selenium Jar Files\\geckodriver-v0.30.0-win64\\geckodriver.exe");		//		  
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		
		// open url in browser
		driver.get("https://www.w3schools.com/html/html5_draganddrop.asp");
		

		
		WebElement SrcEle= driver.findElement(By.id("drag1"));
		WebElement targetEle= driver.findElement(By.id("div2"));
		Actions act = new Actions(driver);
		act.dragAndDrop(SrcEle, targetEle).perform();// Not working as expected
		// Check in firefox, IE  browser 
		
		
		// 2 nd way		
//		clickAndHold()
		act.clickAndHold(SrcEle).moveToElement(targetEle).release().perform();;
		act.clickAndHold(SrcEle).release(targetEle).perform();
		
		
		
		System.out.println("end ");
		
		//********************************
	


	}

}
