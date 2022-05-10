package AllWebElements;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TablePractise2 {

	public static void main(String[] args) throws InterruptedException {

		// 1. open chrome browser //set property
	//	System.setProperty("webdriver.chrome.driver",  "D:\\SeleniumSoftwares\\All Selenium Jar Files\\chromedriver_win32V94\\chromedriver.exe");		//		  
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		
		// open url in browser
		driver.get("file:///D:/Practise/qtp%20practise/web%20apps/WebTableAll.html");
		
		// click checkbox based on Activity Code=10110101
		String ActivityCode="10110103";
		driver.findElement(By.xpath("//*[@id='HulTablee01']//td/a[contains(text(),'" +ActivityCode  +"')]/../following-sibling::td[last()]/input[1]")).click();
		
		//HW 1 : click 1st check box in Activity Code' table
		
		// HW2:HW 1 : click 2nd check box in Activity Code' table
		
		
		// Hw: click all checkboxes in Activity Code' table
			
		
		
		
		
		
	}
}
