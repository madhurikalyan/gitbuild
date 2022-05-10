package AlertPractise;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitForAlert {

	public static void main(String[] args) throws InterruptedException {
		// 1. open chrome browser //set property
		System.setProperty("webdriver.chrome.driver",  "D:\\SeleniumSoftwares\\All Selenium Jar Files\\chromedriver_win32V94\\chromedriver.exe");		//		  
		WebDriver driver= new ChromeDriver();
		
		// open url in browser
		driver.get("file:///D:/Practise/qtp%20practise/web%20apps/ALL%20Web%20objects.html");
		//*********************************
		driver.findElement(By.id("alertid1")).click();
		
				
//		// wait for alert popup window
		WebDriverWait wait=  new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
		
		// eleem present, visible, wait for title, wait ele is invisible/ disappears....etc
		// wait for frame appears
		
		// 1. first checks condition  alert is present or not
		// it checks time out given =10 sec, 500ms ---alert is there or not
		// ..  checks alert is there or not
		//   after 4 or 5 sec - alert is presesnt..- it executes next stmts
				
		Alert al= driver.switchTo().alert();
		////org.openqa.selenium.NoAlertPresentException: no such alert
		String AlertPopupMsg= al.getText();
		Thread.sleep(3000);
		System.out.println("AlertPopupMsg="+AlertPopupMsg);
		
		al.accept();
		
		System.out.println("end ");
		
		//********************************
	


	}

}
