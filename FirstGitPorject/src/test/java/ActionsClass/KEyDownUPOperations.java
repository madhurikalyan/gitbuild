package ActionsClass;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class KEyDownUPOperations {

	public static void main(String[] args) throws InterruptedException {

		// 1. open chrome browser //set property
		//System.setProperty("webdriver.chrome.driver",  "D:\\SeleniumSoftwares\\All Selenium Jar Files\\chromedriver_win32V94\\chromedriver.exe");		//		  
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		
		// open url in browser
		driver.get("file:///D:/Practise/qtp%20practise/web%20apps/ALL%20Web%20objects.html");
		
//		keyDown: key - Either Keys.SHIFT, Keys.ALT or Keys.CONTROL. If the provided key is none of those, IllegalArgumentException is thrown.
		Actions act = new Actions(driver);
		
	
		
		driver.findElement(By.name("lastname")).click();
		// press shift + type = ramu  == RAMU
		act.keyDown(Keys.SHIFT).sendKeys("ramu").perform();
//		Performs a modifier key press. Does not release the modifier key - subsequent interactions may assume it's kept pressed. Note that the modifier key is never released implicitly - either keyUp(theKey) or sendKeys(Keys.NULL) must be called to release the modifier.
		
		//  must shift modiffier btn - to be relealsed
		act.keyUp(Keys.SHIFT).perform();
		
		driver.findElement(By.name("firstname")).click();
		act.keyDown(Keys.SHIFT).sendKeys("First NAme").perform();
		act.keyUp(Keys.SHIFT).perform();
		
		
		// press ctrl +A  and delete 
		driver.findElement(By.name("firstname")).click();
		act.keyDown(Keys.CONTROL).sendKeys("A").perform();//  must use keyup
//		act.sendKeys(Keys.BACK_SPACE).perform();
		act.sendKeys(Keys.DELETE).perform();
		act.keyUp(Keys.CONTROL).perform();
			
		
		System.out.println("end ");
		
		//********************************
	


	}

}
