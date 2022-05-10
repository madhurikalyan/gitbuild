package FrameHandling;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FrameHandling {

	public static void main(String[] args) throws InterruptedException {
		// 1. open chrome browser //set property
		System.setProperty("webdriver.chrome.driver",  "D:\\SeleniumSoftwares\\All Selenium Jar Files\\chromedriver_win32V94\\chromedriver.exe");		//		  
		WebDriver driver= new ChromeDriver();
		
		// open url in browser
		driver.get("file:///D:/Practise/qtp%20practise/web%20apps/iframes.html");
		//*********************************
		// develop frame-   frameset tag> frame  src="mypahe.html"
		// <iframe name=  id= ""  src="webtableall.html"  >
		// get frames count
		List<WebElement> AllIframesList= driver.findElements(By.tagName("iframe"));
		System.out.println("AllIframesList cnt="+AllIframesList.size());//3
		
		
		//Note: eevn if name prop is correct, but it will not perform action on the desired ele,
//		we need to check the elemen is presetn in frame, swicth ctrol to frame then perorom action
// desired ele
		//NoSuchElementException: no such element: Unable to locate element: {"method":"css selector","selector":"*[name='lastname']
		
			// must swicth ctrl to frame
//		driver.findElement(By.name("lastname")).sendKeys("Last name");// error 
//		  Swicth to frame by index 
			/*
			 * driver.switchTo().frame(0);
			 * driver.findElement(By.name("lastname")).sendKeys("Last name");
			 * driver.findElement(By.name("pwd")).sendKeys("mercury");
			 * driver.switchTo().defaultContent();// must come nack to main page
			 * 
			 * Thread.sleep(3000); driver.switchTo().frame(1);
			 * driver.findElement(By.name("username")).sendKeys("My user name");
			 * driver.findElement(By.name("password")).sendKeys("My pwd");
			 * driver.switchTo().defaultContent();
			 */
			
		// 2 name or id 		
//		driver.findElement(By.name("lastname")).sendKeys("Last name");// must switch to frame
		
		/*
		 * driver.switchTo().frame("iframe1name");
		 * driver.findElement(By.name("lastname")).sendKeys("Last name");
		 * driver.findElement(By.name("pwd")).sendKeys("mercury");
		 * driver.switchTo().defaultContent();
		 * 
		 * Thread.sleep(3000); driver.switchTo().frame("iframe2name");
		 * driver.findElement(By.name("username")).sendKeys("My user name");
		 * driver.findElement(By.name("password")).sendKeys("My pwd"); // //
		 * driver.findElement(By.name("myname")).sendKeys("Out of frame"); // must //
		 * swithc to default page //NoSuchElementException: no such element: Unable to
		 * // locate element: {"method":"css selector","selector":"*[name='myname']"}
		 * 
		 * driver.switchTo().defaultContent();
		 * driver.findElement(By.name("myname")).sendKeys("Out of frame");//ok
		 */
		//id
		
		/*
		 * driver.switchTo().frame("iframe1id");
		 * driver.findElement(By.name("lastname")).sendKeys("Last name");
		 * driver.findElement(By.name("pwd")).sendKeys("mercury");
		 * driver.switchTo().defaultContent();
		 * 
		 * Thread.sleep(3000); 
		 * driver.switchTo().frame("iframe2id");
		 * driver.findElement(By.name("username")).sendKeys("My user name");
		 * driver.findElement(By.name("password")).sendKeys("My pwd");
		 * driver.switchTo().defaultContent();
		 */
		
				
		//3. switchTo().frame(Iframe1Ele);
		
		/*
		 * WebElement Iframe1Ele= driver.findElement(By.name("iframe1name")) ;
		 * driver.switchTo().frame(Iframe1Ele);
		 * driver.findElement(By.name("lastname")).sendKeys("Last name");
		 * driver.findElement(By.name("pwd")).sendKeys("mercury");
		 * driver.switchTo().defaultContent();
		 * 
		 * Thread.sleep(3000); WebElement Iframe2Ele=
		 * driver.findElement(By.name("iframe2name")) ;
		 * driver.switchTo().frame(Iframe2Ele);
		 * driver.findElement(By.name("username")).sendKeys("My user name");
		 * driver.findElement(By.name("password")).sendKeys("My pwd");
		 * driver.switchTo().defaultContent();
		 */
		 
		
		//*******************************************************
		//     ele by id 
		/*
		 * WebElement Iframe1Ele= driver.findElement(By.id("iframe1id")) ;
		 * driver.switchTo().frame(Iframe1Ele);
		 * driver.findElement(By.name("lastname")).sendKeys("Last name");
		 * driver.findElement(By.name("pwd")).sendKeys("mercury");
		 * driver.switchTo().defaultContent();
		 * 
		 * Thread.sleep(3000); WebElement Iframe2Ele=
		 * driver.findElement(By.id("iframe2id")) ; driver.switchTo().frame(Iframe2Ele);
		 * driver.findElement(By.name("username")).sendKeys("My user name");
		 * driver.findElement(By.name("password")).sendKeys("My pwd");
		 * driver.switchTo().defaultContent();
		 */
		  
		  //********************************
		// ele by xpath
			/*
			 * WebElement Iframe1Elexpath=
			 * driver.findElement(By.xpath("//*[@id='iframe1id']"));//ok
			 * driver.switchTo().frame(Iframe1Elexpath);
			 * driver.findElement(By.name("lastname")).sendKeys("Last name");
			 * driver.findElement(By.name("pwd")).sendKeys("mercury"); //
			 * driver.switchTo().defaultContent(); //switch
			 * driver.switchTo().parentFrame();//ok
			 * 
			 * Thread.sleep(3000); WebElement Iframe2Elexpath=
			 * driver.findElement(By.xpath("//*[@id='iframe2id']")) ;
			 * driver.switchTo().frame(Iframe2Elexpath);
			 * driver.findElement(By.name("username")).sendKeys("My user name");
			 * driver.findElement(By.name("password")).sendKeys("My pwd");
			 * driver.switchTo().defaultContent();
			 */
		  		
			  
		System.out.println("end ");
		
		//********************************
	
	}

}
