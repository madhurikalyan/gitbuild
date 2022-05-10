package JavaScriptExecutorPractise;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.internal.EventFiringTouch;

public class StylesinRedcolor {

	public static void main(String[] args) throws InterruptedException {
		// 1. open chrome browser //set property
		System.setProperty("webdriver.chrome.driver",  "D:\\SeleniumSoftwares\\All Selenium Jar Files\\chromedriver_win32Ver96\\chromedriver.exe");		//		  
		WebDriver driver= new ChromeDriver();
		
		// open url in browser
		driver.get("file:///D:/Practise/qtp%20practise/web%20apps/ALL%20Web%20objects.html");
		//*********************************
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		WebElement lastNameEle = driver.findElement(By.name("lastname"));
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 5px solid red;');", lastNameEle);
		//<input id="idfirst" type="text" name="lastname" class="firstclass" style="background: black; border: 5px solid red;">
		
//		apply style : background color : pink ; border : 15 px
		//  Hw:  high light button in b
		
		
		// or 
//		js.executeScript("arguments[0].setAttribute('style','background:yellow');",lastNameEle);		// ???????
//		Thread.sleep(3000);
//		js.executeScript("arguments[0].setAttribute('style','border:5px solid red');",lastNameEle);
//		Thread.sleep(3000);
//		
//		js.executeScript("arguments[0].style.background='yellow'",lastNameEle);// ok

		System.out.println("end ");
		
		//********************************
	


	}

}
