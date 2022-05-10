package SynchronisationTimeOut;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.internal.EventFiringTouch;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitTimeoutWebdriverWait3 {

	public static void main(String[] args) throws InterruptedException {

		// 1. open chrome browser //set property
		System.setProperty("webdriver.chrome.driver",  "D:\\SeleniumSoftwares\\All Selenium Jar Files\\chromedriver_win32V94\\chromedriver.exe");		//		  
		WebDriver driver= new ChromeDriver();
			
		// open url in browser
		//driver.get("http://localhost/login.do");
		driver.navigate().to("file:///D:/Practise/qtp%20practise/web%20apps/disabled.html");
		
		
		driver.findElement(By.name("enable")).click();
		
		WebElement dropdownEle=  driver.findElement(By.name("MyCombobox"));
		//dropdownEle.click();
		
		Select sel= new Select(dropdownEle);		
		sel.selectByVisibleText("Orange");//?????????????why 
		
		
		boolean isDisplayed=driver.findElement(By.xpath("//*[text()='Elements are Enabled']")).isDisplayed();
		System.out.println("isDisplayed="+isDisplayed);//??? 
		
			

	}

}
