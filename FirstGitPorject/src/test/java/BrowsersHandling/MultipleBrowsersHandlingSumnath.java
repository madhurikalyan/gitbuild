package BrowsersHandling;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleBrowsersHandlingSumnath {

	
	public static void main(String[] args) throws InterruptedException {

		// 1. open chrome browser //set property
		System.setProperty("webdriver.chrome.driver",  "D:\\SeleniumSoftwares\\All Selenium Jar Files\\chromedriver_win32V94\\chromedriver.exe");		//		  
		WebDriver driver= new ChromeDriver();
		
		// open url in browser
		driver.get("file:///D:/Practise/qtp%20practise/web%20apps/ALL%20Web%20objects.html");
		
		driver.findElement(By.id("loginid")).click();
		// it opne new browser window  . cnt= 2
		
		// get  browser windows cnt
		Set<String>  AllWindows= driver.getWindowHandles();
		// reurn browser address in sequential order
		//  returms mlutiple browser windows address
		Iterator<String> it= AllWindows.iterator();
		//  
		String Browser1Addr= it.next();
		String Browser2Addr= it.next();
		
		// swotch to brower2 i.e login form window 
		driver.switchTo().window(Browser2Addr);
		driver.findElement(By.id("userid")).sendKeys("Raju");
		driver.findElement(By.id("pwdid")).sendKeys("mercury");
		System.out.println("Browser-2 title="+driver.getTitle());
		Thread.sleep(2000);
		driver.close();
		
		// go to browser 1  main page
		driver.switchTo().window(Browser1Addr);
		driver.findElement(By.name("lastname")).sendKeys("mercury");
		System.out.println("Browser-1 title="+driver.getTitle());
		Thread.sleep(2000);
		driver.close();
		
		/*
		 * Browser-2 title=Login page Browser-1 title=All webobjects MyTitle Sumanth
		 */
		
		
		System.out.println("ends");

	}

}
