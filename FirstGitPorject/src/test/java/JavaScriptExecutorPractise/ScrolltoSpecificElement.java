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

public class ScrolltoSpecificElement {

	public static void main(String[] args) throws InterruptedException {
		// 1. open chrome browser //set property
		System.setProperty("webdriver.chrome.driver",  "D:\\SeleniumSoftwares\\All Selenium Jar Files\\chromedriver_win32V94\\chromedriver.exe");		//		  
		WebDriver driver= new ChromeDriver();
		
		// open url in browser
		driver.get("file:///D:/Practise/qtp%20practise/web%20apps/WebTableAll.html");
		//*********************************
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
//		window.scrollBy(0,30);
//		js.executeScript("window.scrollBy(0,30);");
//		Thread.sleep(3000);
//		
//		js.executeScript("window.scrollBy(0,30);");
//		Thread.sleep(3000);
//		
//		js.executeScript("window.scrollBy(0,30);");
//		Thread.sleep(3000);
		
		//*****************************
		// Imp :  
		//document.getElementById("loginid").scrollIntoView();
		WebElement RelevantCodesTableId = driver.findElement(By.id("RelevantCodesTableId"));
	//	js.executeScript("document.getElementById(\"RelevantCodesTableId\").scrollIntoView();");
		//ok
		
		
		//  with 2ars
		js.executeScript("arguments[0].scrollIntoView();", RelevantCodesTableId);//ok
		// Revise :
//		browser: title, url..
		// textbox :   .value="ramu";  . doc.value; 
		//   return doc.value
		// 2 ars jsexescript("arguments[0].value=""ram";, ele)
		
		// button  ..rguments[0].click()
		// chlbox
		// arguments[0].click();
		// arguments[0].checked=true;  return arguments[0].checked=true; .tosString()
		// radio button
		
		// dropdown :   .value == ???? not working 
		//  selecetdIndex  1
		// scrollBY(0,100);
		// scroll to desired ele..   argumets[0].scrollIntoView();

		System.out.println("end ");
		
		//********************************
	


	}

}
