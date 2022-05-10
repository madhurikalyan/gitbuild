package ActionsClass;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownThroughActiosnClass {

	public static void main(String[] args) throws InterruptedException {

		// 1. open chrome browser //set property
		//System.setProperty("webdriver.chrome.driver",  "D:\\SeleniumSoftwares\\All Selenium Jar Files\\chromedriver_win32V94\\chromedriver.exe");		//		  
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		
		// open url in browser
		driver.get("file:///D:/Practise/qtp%20practise/web%20apps/ALL%20Web%20objects.html");
		
		// When to go:  some times dropdown ele is not developed by using Select, option tag - standard drodown
		
		// dropdown will be developed by div, ul , li tag--  non standrad dropdown
		// click on dropdoown ele
		driver.findElement(By.name("cars")).click();		
		Thread.sleep(3000);
		
		// through k/b type "Audi" and Press enter
		Actions act = new Actions(driver);
//		act.sendKeys("Kia").sendKeys(Keys.ENTER).perform();
//		act.sendKeys("M").sendKeys(Keys.ENTER).perform();
		act.sendKeys("A").sendKeys(Keys.ENTER).perform();
		
		System.out.println("end ");
		
		//********************************
	


	}

}
