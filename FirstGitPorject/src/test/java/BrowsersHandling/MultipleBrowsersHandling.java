package BrowsersHandling;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleBrowsersHandling {

	public static void main(String[] args) throws InterruptedException {

		// 1. open chrome browser //set property
		System.setProperty("webdriver.chrome.driver",  "D:\\SeleniumSoftwares\\All Selenium Jar Files\\chromedriver_win32V94\\chromedriver.exe");		//		  
		WebDriver driver= new ChromeDriver();
		
		// open url in browser
		driver.get("file:///D:/Practise/qtp%20practise/web%20apps/ALL%20Web%20objects.html");
			
//		driver.findElement(By.id("simpleid")).click();
//		Thread.sleep(2000);
		
		driver.findElement(By.id("loginid")).click();
		Thread.sleep(2000);
		
//		driver.findElement(By.id("allid")).click();
//		Thread.sleep(2000);
		
		// get count of browsers 
		Set<String> allBrowsers= driver.getWindowHandles();
		int browsersCnt= allBrowsers.size();
		System.out.println("browsersCnt="+browsersCnt);//4
		
		Iterator<String> it=allBrowsers.iterator();
		String BrowserMain = it.next();
		String Browser2 = it.next();
//		String Browser3= it.next();
		
		// gte titles
		driver.switchTo().window(BrowserMain);
		System.out.println("getTitle="+driver.getTitle());
		driver.switchTo().defaultContent();
		
		driver.switchTo().window(Browser2);
		System.out.println("getTitle="+driver.getTitle());
		driver.switchTo().defaultContent();
		
//		driver.switchTo().window(Browser3);
//		System.out.println("getTitle="+driver.getTitle());
//		driver.switchTo().defaultContent();
		
		// Go ot browser 2
		Thread.sleep(3000);
		driver.switchTo().window(Browser2);
		driver.findElement(By.id("userid")).sendKeys("Raju");
		driver.findElement(By.id("pwdid")).sendKeys("mercry");
		driver.close();
//		driver.switchTo().defaultContent();//???
		
		driver.switchTo().window(BrowserMain);
		driver.findElement(By.name("lastname")).sendKeys("Raju");
		Thread.sleep(3000);
//		driver.close();//bSocketHandler handleException
	
//		driver.switchTo().defaultContent();//????
		driver.close();
		
		System.out.println("ends");

	}

}
