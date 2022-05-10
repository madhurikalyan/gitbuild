package JavaScriptExecutorPractise;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.internal.EventFiringTouch;



public class Button {

	public static void main(String[] args) throws InterruptedException {

		// 1. open chrome browser //set property
		System.setProperty("webdriver.chrome.driver",  "D:\\SeleniumSoftwares\\All Selenium Jar Files\\chromedriver_win32V94\\chromedriver.exe");		//		  
		WebDriver driver= new ChromeDriver();
		
		// open url in browser
		driver.get("file:///D:/Practise/qtp%20practise/web%20apps/ALL%20Web%20objects.html");
			
		// why javascriptexecuot
		//some times we are not able click by using selenium findElemnt().click();
		// handle hidden element 
		// Note:   Actions.click(ele);
		
		// if not working  act.doubleclick(ele);
		
		//  I will go for JavascriptExcutor , we can click ele
		
		
		
		//1.c,lick   Mysubmit Button 
		JavascriptExecutor js= (JavascriptExecutor)driver;
		driver.findElement(By.name("firstname")).sendKeys("Ram");
		Thread.sleep(3000);
		WebElement MysubmitBtnEle= driver.findElement(By.id("MyButton"));
		js.executeScript("arguments[0].click();", MysubmitBtnEle);//ok
		
//		js.executeScript("arguments[1].click();", MysubmitBtnEle);//error
		//".JavascriptException: javascript error: Cannot read properties of undefined (reading 'click')
		// Dont invlaid values in 1st argument arguments[1] always uses arguments[0]
		
		
		//2 nd way using docuemnt...
		js.executeScript("document.getElementById(\"MyButton\").click();");//ok
		
		

		

	}

}
