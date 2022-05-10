package JavaScriptExecutorPractise;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.internal.EventFiringTouch;

public class Browser {

	public static void main(String[] args) throws InterruptedException {

		// 1. open chrome browser //set property
		System.setProperty("webdriver.chrome.driver",  "D:\\SeleniumSoftwares\\All Selenium Jar Files\\chromedriver_win32V94\\chromedriver.exe");		//		  
		WebDriver driver= new ChromeDriver();
		
		// open url in browser
		driver.get("file:///D:/Practise/qtp%20practise/web%20apps/ALL%20Web%20objects.html");
			
		// JavascriptExecutor  is an interface. and it has some metohds ,
		//which can be used to execute the javascript code  in the browser
		
		
//
		
		//  javscript code : in  chrome brower
		// inspect>  console >   write js code 
		
		
		//document.title;
		
//		document.URL;
//		'file:///D:/Practise/qtp%20practise/web%20apps/ALL%20Web%20objects.html'
		
//		alert("My alert Popup window");
		
//		window.scrollBy(10,0);
		
		// 
//		JavascriptExecutor js=  new JavascriptExecutor();
		JavascriptExecutor js= (JavascriptExecutor)driver;
//		js.executeScript("alert(\"My laert popup window\");");
		
		// get  browser title
//		String  ttile= js.executeScript("return document.title;");
		String  title= js.executeScript("return document.title;").toString();
		//Type mismatch: cannot convert from Object to String
		System.out.println("title="+title);
		
		//get  browser url
		String url =js.executeScript("return document.URL;").toString();
		System.out.println("url="+url);
		
		// get domain
		
		String domain =js.executeScript("return document.domain;").toString();
		System.out.println("domain"+domain);
//		title=All webobjects MyTitle Sumanth
//				url=file:///D:/Practise/qtp%20practise/web%20apps/ALL%20Web%20objects.html
//				domain
		
		js.executeScript("window.scrollBy(0,100);");
		//  
		
		
		String a="My name is \"Brahma\". he is good.";
		System.out.println("a="+a);// My name is "Brahma". he is good.
		

	}

}
