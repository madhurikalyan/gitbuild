package AllWebElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LocatorsAll {


	
	public static void main(String[] args) throws InterruptedException {

		// 1. open chrome browser //set property
	//	System.setProperty("webdriver.chrome.driver",  "D:\\SeleniumSoftwares\\All Selenium Jar Files\\chromedriver_win32V94\\chromedriver.exe");		//		  
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		
		// open url in browser
		driver.get("file:///D:/Practise/qtp%20practise/web%20apps/ALL%20Web%20objects.html");
		driver.findElement(By.id("idfirst")).clear();
		
//		 1.id
		driver.findElement(By.id("idfirst")).sendKeys("Ramu");
		// first name text box ele 		
		
		driver.findElement(By.id("idfirst")).clear();
		
//		 2.name
		driver.findElement(By.name("firstname")).sendKeys("My Name");
		
		
		driver.findElement(By.name("lastname")).sendKeys("Last name");
		// returns last name text box ele -- what action to be done -- send ddata-
		
		// HW1 enter data in pwd ele
			
		
//		Hw:
//		 3.class
		
		
//		 4.linktext()
//		  ToolTip Link  
//		driver.findElement(By.linkText("ToolTip Link")).click();
		
//		 5.partiallinksText() 
//		driver.findElement(By.partialLinkText("ToolTip")).click();
		
//		findElement():  it finds eleme or identified the element  and returns first mathced ele by class mechnism...(link text=ToolTip)
		
//		note: If no element is found on page, it throws NoSucelement exception
//		driver.findElement(By.partialLinkText("ToolTipp")).click();// 
		
		
//		 6.tagname()
		driver.findElement(By.tagName("input")).sendKeys("Raju");
		
		
//		 7.Xpath()
		
		
		
//		 8.CssSelector



	}

}
