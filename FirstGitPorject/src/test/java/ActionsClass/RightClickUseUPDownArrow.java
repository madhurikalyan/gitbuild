package ActionsClass;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RightClickUseUPDownArrow {

	public static void main(String[] args) throws InterruptedException {

		// 1. open chrome browser //set property
		//System.setProperty("webdriver.chrome.driver",  "D:\\SeleniumSoftwares\\All Selenium Jar Files\\chromedriver_win32V94\\chromedriver.exe");		//		  
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		
		// open url in browser
		driver.get("file:///D:/Practise/qtp%20practise/web%20apps/ALL%20Web%20objects.html");
		
//		keyDown: key - Either Keys.SHIFT, Keys.ALT or Keys.CONTROL. If the provided key is none of those, IllegalArgumentException is thrown.
		Actions act = new Actions(driver);
		
		// rght lcick on tool tip sumanth ele  and
	WebElement	ToolTipSumanthele = driver.findElement(By.linkText("ToolTip Sumanth"));
//		act.contextClick(ToolTipSumanthele).perform();
			
		// down arrow and down arrow and press enter
//		act.sendKeys(Keys.ARROW_DOWN).perform();
//		Thread.sleep(3000);
//		act.sendKeys(Keys.ARROW_DOWN).perform();
//		Thread.sleep(3000);
//		act.sendKeys(Keys.ARROW_DOWN).perform();
//		Thread.sleep(3000);
//		
//		act.sendKeys(Keys.ARROW_DOWN).perform();
//		Thread.sleep(3000);
//	act.contextClick(ToolTipSumanthele).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();//ok
//	act.contextClick(ToolTipSumanthele).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).build().perform();//ok
	
	
//		----------------------------
//		act.sendKeys(Keys.DOWN).perform();
//		Thread.sleep(3000);
//		act.sendKeys(Keys.DOWN).perform();
//		Thread.sleep(3000);
//		act.sendKeys(Keys.DOWN).perform();
//		Thread.sleep(3000);
//		
//		act.sendKeys(Keys.DOWN).perform();
//		Thread.sleep(3000);
//		
//		act.sendKeys(Keys.ENTER).perform(); //???
		//*********
		/*
		 * act.keyDown(Keys.SHIFT).perform();
		 * 
		 * act.sendKeys(Keys.DOWN).perform(); Thread.sleep(3000);
		 * act.sendKeys(Keys.DOWN).perform(); Thread.sleep(3000);
		 * act.sendKeys(Keys.DOWN).perform(); Thread.sleep(3000);
		 * act.sendKeys(Keys.DOWN).perform(); Thread.sleep(3000);
		 * act.sendKeys(Keys.DOWN).perform(); Thread.sleep(3000);
		 * 
		 * act.sendKeys(Keys.ENTER).perform(); act.keyUp(Keys.SHIFT).perform();
		 */
		//???????????? not working 
				
		// **************************
		
//	act.contextClick(ToolTipSumanthele).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
	// not perefect
	
	// or  Ctrl + click desired Link
	act.keyDown(Keys.CONTROL).click(ToolTipSumanthele).keyUp(Keys.CONTROL).perform(); // ok
	
	
	
		System.out.println("end ");
		
		//********************************
	


	}

}
