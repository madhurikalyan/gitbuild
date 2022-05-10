package AlertPractise;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertPopupHandling {

	public static void main(String[] args) throws InterruptedException {
		// 1. open chrome browser //set property
	//	System.setProperty("webdriver.chrome.driver",  "D:\\SeleniumSoftwares\\All Selenium Jar Files\\chromedriver_win32V94\\chromedriver.exe");		//		  
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		
		// open url in browser
		driver.get("file:///D:/Practise/qtp%20practise/web%20apps/jscript/Alert%20Prompt.html");
		//*********************************
//		driver.findElement(By.id("btnid")).click();
		
//		Alert popup: 
//		how to identify alter popup: we are not able to  inspect element in popup widow
		//   Alert - Interace and has methods clikc ok, cncel buton....etc
		
		Alert  al= driver.switchTo().alert();
		// if alert is not exist, if we try to swicth to alter popwindow
//		,it throws org.openqa.selenium.NoAlertPresentException: no such alert
		
		
		al.sendKeys("Sam");
		
		// get text from popup alert
		String AlertText=  al.getText();
		System.out.println("AlertText="+AlertText);//AlertText=Please enter Employee name
		
		// clikc ok
//		al.accept();
		
		// cancel 
		al.dismiss();
		
		// GET  paragraph msg
		String paragraphMsg= driver.findElement(By.tagName("body")).getText();
		System.out.println("paragraphMsg="+paragraphMsg);
			// paragraphMsg=Hello Sam! How are you today?
		
		//def content ????
		
		System.out.println("end ");
		
		//********************************
	


	}

}
