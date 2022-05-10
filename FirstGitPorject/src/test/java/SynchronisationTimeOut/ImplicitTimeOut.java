package SynchronisationTimeOut;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.internal.EventFiringTouch;

public class ImplicitTimeOut {

	public static void main(String[] args) throws InterruptedException {

		// 1. open chrome browser //set property
		System.setProperty("webdriver.chrome.driver",  "D:\\SeleniumSoftwares\\All Selenium Jar Files\\chromedriver_win32V94\\chromedriver.exe");		//		  
		WebDriver driver= new ChromeDriver();
		// why  implicit time out
		
		
		
		// open url in browser
		driver.get("file:///D:/Practise/qtp%20practise/web%20apps/ALL%20Web%20objects.html");
//		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		// old it was obsolete... 
		// new 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		System.out.println("Starts time");
//		driver.findElement(By.id("idfirstSFASF")).clear();
		
		// it will throw NoSuchElementException immeditaley if elemnt not found using locators
		// wont wait
		//  appp -- is too slow to give response when we clikc button it takes 3 sec to display page
		// when we click link , it takes 5 sec pr 10 sec to display new page
		// I will ask Selenium Wait max time =20 sec
		
		//Define 
//		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//		1.  applicablle for all findElement() -- global time out
//		2.Define once and applies for all elements
			
		// it waits given max time out=20 sec,  once if it identifies ele within 20 sec, it will execute next stmts else
		// if ele found  in 5 sec, it perofrms actions and it goes to next stmt and executes..
		// if max time out=20 sec cross,  throws NoSuchElementException
		
		// Selenium 4 
		
//		 1.id
		driver.findElement(By.id("idfirst")).sendKeys("Ramu");
		// first name text box ele 		
		
//		driver.findElement(By.id("idfirstInvalid")).clear();
		// ele not found. so it check implcit time out. 20 sec. waits max 20 sec after that
//		it throws nosuchelemntexception
		
//		 2.name
		driver.findElement(By.name("firstnameInvlai")).sendKeys("My Name");
		
		
		driver.findElement(By.name("lastname")).sendKeys("Last name");
		// returns last name text box ele -- what action to be done -- send ddata-
		
//		Revise:
//		implicit  define: 
		//Way 2:
		Thread.sleep(10000);	// waits max 10 sec even ele found / appears in the appl
		

	}

}
