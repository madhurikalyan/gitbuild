package AlertPractise;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MultipleAlertsHandling {

	public static void main(String[] args) throws InterruptedException {
		// 1. open chrome browser //set property
		System.setProperty("webdriver.chrome.driver",  "D:\\SeleniumSoftwares\\All Selenium Jar Files\\chromedriver_win32V94\\chromedriver.exe");		//		  
		WebDriver driver= new ChromeDriver();
		
		// open url in browser
		driver.get("file:///D:/Practise/qtp%20practise/web%20apps/ALL%20Web%20objects.html");
		//*********************************
		driver.findElement(By.id("alertid2")).click();
				
		// wait for alert popup window
		WebDriverWait wait=  new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.alertIsPresent());
		
		
		/*
		 * // 1st alert popup window Alert al= driver.switchTo().alert(); String
		 * AlertPopupMsg= al.getText();
		 * System.out.println("AlertPopupMsg="+AlertPopupMsg); Thread.sleep(3000);
		 * al.sendKeys("Ram"); System.out.println("Clikc ok button  in 1st alert");
		 * al.accept();
		 * 
		 * Thread.sleep(2000); //2nd alert popup
		 * System.out.println("Clikc ok button in 2nd alert"); //
		 * 
		 * al.accept(); //if we dont handle 2nd alert popup window by click ok, cancel
		 * button, try to perofrm any actions on main page, // it
		 * throows,UnhandledAlertException: unexpected alert open: //{Alert text : Order
		 * No : 101 created successfully}
		 * System.out.println("Clicked ok button in 2nd alert");
		 * 
		 * driver.findElement(By.name("lastname")).sendKeys("Raju");
		 * System.out.println("end ");
		 */
		
		/*
		 * AlertPopupMsg=Please enter Employee name ==Sam,
		 *  Clikc ok again in 1st alert Clikc ok
		 * again in 2nd alert Clicked ok again in 2nd alert end
		 */
		//********************************
		
		/*
		 * Alert al= driver.switchTo().alert(); String AlertPopupMsg= al.getText();
		 * System.out.println("AlertPopupMsg="+AlertPopupMsg); Thread.sleep(3000);
		 * al.sendKeys("Ram"); System.out.println("Click ok button in 1st alert");
		 * al.accept(); Thread.sleep(3000);
		 * 
		 * System.out.println("Clikc ok again in 2nd alert"); Alert al2=
		 * driver.switchTo().alert();// this also ok Thread.sleep(3000); al2.accept();
		 * System.out.println("Clicked ok button in 2nd alert");
		 * 
		 * driver.findElement(By.name("lastname")).sendKeys("Raju");
		 * System.out.println("end ");
		 */
		 

		// can i use defaultcontemt()
		
		  Alert al= driver.switchTo().alert(); 
		  String AlertPopupMsg= al.getText();
		  System.out.println("AlertPopupMsg="+AlertPopupMsg); 
		  Thread.sleep(3000);
		  al.sendKeys("Ram"); 
		  System.out.println("Click ok  in 1st alert");
		  al.accept();
		  Thread.sleep(3000);
		  driver.switchTo().defaultContent();//
		  
		  System.out.println("Clikc ok again in 2nd alert"); 
		  Alert al2=driver.switchTo().alert();// this also ok 
		  Thread.sleep(3000); 
		  al2.accept();
		  driver.switchTo().defaultContent();
		  // org.openqa.selenium.UnhandledAlertException: unexpected alert open: {Alert text : Order No : 101 created successfully}
		  //?????????????????????
		  System.out.println("Clicked ok again in 2nd alert");
		  driver.findElement(By.name("lastname")).sendKeys("Raju");
		  System.out.println("end ");
		 
		

	}

}
