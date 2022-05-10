package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
			// how to add selenum 4.0  jar files?
		// how download chromedriver.exe
		
		System.out.println("Hi");
		
		
		// 1.   open chrome browser 
		System.setProperty("webdriver.chrome.driver", "D:\\SeleniumSoftwares\\All Selenium Jar Files\\chromedriver_win32V94\\chromedriver.exe");
		
		// open chrome browser
		WebDriver driver= new ChromeDriver();
		
//		new ChromeDriver();
//		new ChromeDriver().get("");
		
		// open the given url in browser
		//		driver.get("https://www.facebook.com/");
		// line2 
		
//		driver.navigate().to("https://chromedriver.chromium.org/downloads");
//		driver.navigate().back();
//		Thread.sleep(3000);
//		driver.navigate().forward();
//		
		// refresh 
//		driver.navigate().refresh();
		
		

		
		//close 
		//driver.close();
		
		driver.get("file:///D:/Practise/qtp%20practise/web%20apps/ALL%20Web%20objects.html");
		// get current url
		
		String getURL= driver.getCurrentUrl();
		System.out.println("getURL="+getURL);
//		getURL=https://www.facebook.com/
		
//		driver.findElement(By.linkText("Login Form Link"));
//		Thread.sleep(3000);
//		driver.close();
//		Thread.sleep(3000);
//		driver.quit();// close all browsers which are opened by selenium
		// page1 > click link>  open new window (Page-2) 
		
//		close--close only browser1	 not browser2	
		
		// get ttiel page
		String getTitle= driver.getTitle();
		System.out.println("getTitle="+getTitle);
		// getTitle=All webobjects MyTitle
		
		String getPageSource= driver.getPageSource();
		System.out.println("getPageSource="+getPageSource);
		
		
		System.out.println("ends");	
		
		
		
	}

}
