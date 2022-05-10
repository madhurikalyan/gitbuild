package FrameHandling;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.internal.EventFiringTouch;
import org.openqa.selenium.support.ui.Select;

public class InnerFrameHandling3Sumath {

	public static void main(String[] args) throws InterruptedException {
		// 1. open chrome browser //set property
		System.setProperty("webdriver.chrome.driver",  "D:\\SeleniumSoftwares\\All Selenium Jar Files\\chromedriver_win32V94\\chromedriver.exe");		//		  
		WebDriver driver= new ChromeDriver();

		// open url in browser
		driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");

		/*
		 * //siwtch frame 1 driver.switchTo().frame("frame1");
		 * driver.findElement(By.xpath("//b[@id='topic']/following-sibling::input")).
		 * sendKeys("Ram");
		 * 
		 * // swicth to inner frame //Inner Frame Check box :
		 * 
		 * driver.switchTo().frame("frame3"); driver.findElement(By.id("a")).click();
		 * driver.switchTo().defaultContent();// ctrl comes to main page only
		 * 
		 * String paraTxtFromMainPage=
		 * driver.findElement(By.xpath("//*[contains(text(),'Not a Friendly Topic')]")).
		 * getText(); System.out.println("paraTxtFromMainPage="+paraTxtFromMainPage);
		 * 
		 * // swicth to last frame driver.switchTo().frame("frame2");
		 * 
		 * WebElement dropdownEle= driver.findElement(By.id("animals")); Select sel= new
		 * Select(dropdownEle); sel.selectByVisibleText("Avatar");
		 */

		//***********************
		// parent frame...

		//siwtch frame 1
//		driver.switchTo().frame("frame1");
//		driver.findElement(By.xpath("//b[@id='topic']/following-sibling::input")).sendKeys("Ram");

		 // swicth to inner frame //Inner Frame Check box :
		
		 driver.switchTo().frame("frame3"); 
		 driver.findElement(By.id("a")).click();
		  // swicth to parent frame and enter some text in topic
		 driver.switchTo().parentFrame();//  control goes paren frame i.e frame-1
		 driver.findElement(By.xpath("//b[@id='topic']/following-sibling::input")).sendKeys("Swathi");

		 //   can we swicth to inner frame directly :  no. we cannot swicth 
		 //Exception in thread "main" org.openqa.selenium.NoSuchFrameException: No frame element found by name or id frame3
		 

		System.out.println("end ");

		//********************************



	}

}
