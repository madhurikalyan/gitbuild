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

public class textBox {

	public static void main(String[] args) throws InterruptedException {
		// 1. open chrome browser //set property
		System.setProperty("webdriver.chrome.driver",  "D:\\SeleniumSoftwares\\All Selenium Jar Files\\chromedriver_win32V94\\chromedriver.exe");		//		  
		WebDriver driver= new ChromeDriver();
		
		// open url in browser
		driver.get("file:///D:/Practise/qtp%20practise/web%20apps/ALL%20Web%20objects.html");
		
		
		// enter data in textbox
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		// document.getElementById("idfirst").value="Sumanth";
		js.executeScript("document.getElementById(\"idfirst\").value=\"Sumanth\";");
		
		// HW: enter pwd,last name 
		
		//2 way 2 args
		WebElement lastNameEle = driver.findElement(By.name("lastname"));
		js.executeScript("arguments[0].value=\"ramu\";", lastNameEle);
		
		
		//// get val from textbox
		//  ele.getAttribute("value");
		String ValFromTextbix =js.executeScript("return document.getElementById(\"idfirst\").value;").toString();
		
	//	String ValFromTextbix1 = (String) js.executeScript("return document.getElementById(\"idfirst\").value;");
		
		System.out.println("ValFromTextbix="+ValFromTextbix);
		//ValFromTextbix=Sumanth
		
		
		// 2 
		
		String ValFromTextbox2= js.executeScript("return arguments[0].value;",lastNameEle ).toString();
		System.out.println("ValFromTextbox2="+ValFromTextbox2);
		//ValFromTextbox2=ramu
		
		//*******************************
//		// enter data in textbox
//		//1. usin document
//		js.executeScript("document.getElementById(\"idfirst\").value=\"First :Ram\";");
//		
		
//		Thread.sleep(2000);
//		//2.
//		WebElement FirstnameEle= driver.findElement(By.id("idfirst"));
//		js.executeScript("arguments[0].value='Raju'", FirstnameEle);
//		Thread.sleep(2000);
//		
//		// get val from textbox
//		String getValFromtextbox=js.executeScript("return document.getElementById(\"idfirst\").value;").toString();
//		System.out.println("getValFromtextbox="+getValFromtextbox);
////		Exception in thread "main" org.openqa.selenium.JavascriptException: 
//		//javascript error: Invalid or unexpected token
//		//getValFromtextbox=Raju

		System.out.println("end ");
		
		//********************************
	


	}

}
