package AutoIT;

import java.awt.AWTException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class UpLoadFillesUsingAutoIt {

	
		@SuppressWarnings("deprecation")
		public static void main(String[] args) throws InterruptedException, AWTException, IOException 
		{

			// 1. open chrome browser //set property
	//		System.setProperty("webdriver.chrome.driver",  "D:\\SeleniumSoftwares\\All Selenium Jar Files\\chromedriver_win32Ver96\\chromedriver.exe");		//		  
			WebDriverManager.chromedriver().setup();
			WebDriver driver= new ChromeDriver();

			// open url in browser
			driver.get("file:///D:/Practise/qtp%20practise/web%20apps/ALL%20Web%20objects.html");
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			//D:\Practise\qtp practise\web apps\calendar.html

			// 1. upload file 

			String fileName= "D:\\Practise\\qtp practise\\web apps\\calendar.html";
			driver.findElement(By.name("uploadname")).sendKeys(fileName);
			//

			// 2. d way 
			//		driver.findElement(By.xpath("//input[@id='fileid']")).click();// nok
			//		main" org.openqa.selenium.InvalidArgumentException: invalid argument

			Actions act = new Actions(driver);
					act.click(driver.findElement(By.xpath("//input[@id='fileid']"))).perform();
//					act.doubleClick(driver.findElement(By.xpath("//input[@id='fileid']"))).perform();

			// HW : use Javascript Executor 


			Thread.sleep(4000);
			// execute autoIT.exe file  --  dbl clk .exe file 
		//	Runtime.getRuntime().exec("D:\\SeleniumSoftwares\\AutoIT\\Sumnath\\BasicNotepad.exe");

			Runtime.getRuntime().exec("D:\\SeleniumSoftwares\\AutoIT\\UploadFile.exe");
			
			//  HW : Verify file is uploaded or not



			System.out.println("ends");

		}

	}
