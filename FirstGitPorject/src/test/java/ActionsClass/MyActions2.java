package ActionsClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MyActions2 {

	public static void main(String[] args) throws InterruptedException {

		// 1. open chrome browser //set property
		//System.setProperty("webdriver.chrome.driver",  "D:\\SeleniumSoftwares\\All Selenium Jar Files\\chromedriver_win32V94\\chromedriver.exe");		//		  
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		
		// open url in browser
		driver.get("file:///D:/Practise/qtp%20practise/web%20apps/ALL%20Web%20objects.html");
		
		// click 
		Actions act = new Actions(driver);
		
		// move to last name textbox ele and Click  and send data
		WebElement LastNameTextboxEle= driver.findElement(By.name("lastname"));
//		act.moveToElement(LastNameTextboxEle).click().sendKeys("Rao").perform();
		
//		 or 
		// click on last name elem and send data
//		act.click(LastNameTextboxEle).sendKeys("2nd way").perform();
				
		// double click 
		act.moveToElement(LastNameTextboxEle).doubleClick().sendKeys("Raju").perform();
		
		//or
		act.doubleClick(LastNameTextboxEle).sendKeys("Sam3").perform();
		
		
		// click button , link  
		WebElement MybuttonEle= driver.findElement(By.id("MyButton"));
		act.doubleClick(MybuttonEle).perform();
		
			//  right lick on '  ToolTip Sumanth ' link
		WebElement ToolStipSumnathLink= driver.findElement(By.linkText("ToolTip Sumanth"));
		act.contextClick(ToolStipSumnathLink).perform();	
		
		// drag and drop (srcEle, TargetEle)
		
		driver.get("file:///D:/Practise/qtp%20practise/web%20apps/dragdrop.html");
		
		WebElement SrcEle= driver.findElement(By.id("drag1"));
		WebElement targetEle= driver.findElement(By.id("div1"));
		
		act.dragAndDrop(SrcEle, targetEle).perform();
		// 2
		
		// sendkeys
		
//		clickAndHold()
		
		
		
		
		System.out.println("end ");
		
		//********************************
	


	}

}
