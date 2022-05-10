package ActionsClass;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class KeyBoardRelatedOperations {

	public static void main(String[] args) throws InterruptedException {

		// 1. open chrome browser //set property
		//System.setProperty("webdriver.chrome.driver",  "D:\\SeleniumSoftwares\\All Selenium Jar Files\\chromedriver_win32V94\\chromedriver.exe");		//		  
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		
		// open url in browser
		driver.get("file:///D:/Practise/qtp%20practise/web%20apps/ALL%20Web%20objects.html");
		
		// ctrl+ a , delte
		Actions act = new Actions(driver);
		WebElement firstNameTextboxEle= driver.findElement(By.name("firstname"));
		act.click(firstNameTextboxEle).sendKeys("Raaju").perform();;
		
		// press tab
		act.sendKeys(Keys.TAB).perform();
		Thread.sleep(2000);
		
		act.sendKeys("Last anme").perform();
		
		act.sendKeys(Keys.TAB).perform();
		act.sendKeys("pwd").perform();
		Thread.sleep(2000);
		
		// Radio btn
		act.sendKeys(Keys.TAB).perform();
		act.sendKeys(Keys.SPACE).perform();
		
		Thread.sleep(2000);
		
		act.sendKeys(Keys.TAB).perform();
		// checkbox
		act.sendKeys(Keys.SPACE).perform();
		
		Thread.sleep(2000);
		act.sendKeys(Keys.TAB).perform();
		// 2nd check box
		act.sendKeys(Keys.SPACE).perform();
		
		Thread.sleep(2000);
//		act.keyDown(Keys.TAB).sendKeys("LAstname").perform();// dont use like this
		//Exception in thread "main" java.lang.IllegalArgumentException: Key Down / Up events only make sense for modifier keys.
//		key - Either Keys.SHIFT, Keys.ALT or Keys.CONTROL. If the provided key is none of those, IllegalArgumentException is thrown.
		

		
//		Note:
//		Exception in thread "main" org.openqa.selenium.WebDriverException: chrome not reachable
		 // while runnin test, if we close browser manullay - it throws  WebDriverException
		
//		act.click(firstNameTextboxEle).keyDown(Keys.CONTROL).  ??? later
		
		System.out.println("end ");
		
		//********************************
	


	}

}
