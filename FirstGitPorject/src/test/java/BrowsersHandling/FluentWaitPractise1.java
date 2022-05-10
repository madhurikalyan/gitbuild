package BrowsersHandling;

import java.time.Duration;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FluentWaitPractise1 {

	
	public static void main(String[] args) throws InterruptedException {

		// 1. open chrome browser //set property
		System.setProperty("webdriver.chrome.driver",  "D:\\SeleniumSoftwares\\All Selenium Jar Files\\chromedriver_win32V94\\chromedriver.exe");		//		  
		WebDriver driver= new ChromeDriver();
		
		// open url in browser
		driver.get("file:///D:/Practise/qtp%20practise/web%20apps/ALL%20Web%20objects.html");
		
		driver.findElement(By.id("loginid")).click();
		driver.findElement(By.id("allid")).click();
		// wait  for 3 browser cnt
//		WebDriverWait wait= new WebDriverWait(driver, 20);
//		wait.until(ExpectedConditions.numberOfWindowsToBe(4));
		
		// Fluent wait - is predefined c;lass in selenium
		// wait for spcific element  and given time out ,with p
		
		FluentWait<WebDriver> flwait= new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(2))
				.ignoring(NoSuchElementException.class);
				
		flwait.until(ExpectedConditions.numberOfWindowsToBe(4));
		// after 20 sec , if expeccted  condi is false, it throws timeoutexception
	
		
		
//		 org.openqa.selenium.TimeoutException: 
//			 Expected condition failed: waiting for number of open windows to be 4 (tried for 20 second(s) with 500 milliseconds interval)
		 
		// it opens 2 windows apart from main browser 
		// total windows -3		
		Set<String>  AllWindowHandleAddresses= driver.getWindowHandles();
		// for
		for(String EachWindowAddress : AllWindowHandleAddresses )
		{
			String eachWindAddr= EachWindowAddress;
			System.out.println("eachWindAddr="+eachWindAddr);
					//  swicth to each bropwse  and get title
			driver.switchTo().window(eachWindAddr);
			
			System.out.println("driver.getTitle()="+driver.getTitle());
			/*
			 * eachWindAddr=CDwindow-C3087AD56BF2C1D149F840D84B4B0691 driver.getTitle()=All
			 * webobjects MyTitle Sumanth
			 * eachWindAddr=CDwindow-25D04242F94F8B71CF0D62156DA6E18C
			 * driver.getTitle()=WebtableAll Title
			 * eachWindAddr=CDwindow-8A041B5A2DDE4E396846A24D18704007
			 * driver.getTitle()=Login page ends
			 */
			
		}
		
		
		
		System.out.println("ends");

	}

}
