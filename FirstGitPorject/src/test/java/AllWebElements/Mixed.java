package AllWebElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Mixed {

	public static void main(String[] args) throws InterruptedException {
		
		  // 1. open chrome browser //set property
// System.setProperty("webdriver.chrome.driver",  "D:\\SeleniumSoftwares\\All Selenium Jar Files\\chromedriver_win32V94\\chromedriver.exe");
		  
//		  create obj for chromedriver clas 
		WebDriverManager.chromedriver().setup();  
		WebDriver driver= new ChromeDriver();
		  
		  // open url in browsr driver.get(
//		  "file:///D:/Practise/qtp%20practise/web%20apps/ALL%20Web%20objects.html");
		 
		// comment multiple lines = ctrl +shft + /
		// uncommnet    ==ctrl +shft + \ 
		
	
		// IE 
//		System.setProperty("webdriver.ie.driver", "D:\\SeleniumSoftwares\\All Selenium Jar Files\\IEDriverServer_x64_3.150.2\\IEDriverServer.exe");
//		WebDriver driver=  new InternetExplorerDriver();
		
		// maximise browser
		driver.manage().window().maximize();
		driver.get("file:///D:/Practise/qtp%20practise/web%20apps/SumanthFirstHtmlPage.html");
		Thread.sleep(3000);
		
		// Ff    
		//HW1 :  // download geckodriver.exe  and open Fireox browser
//		FirefoxDriver
		
		// 1. identify ele by using By class locators 
		WebElement firstNameEle= driver.findElement(By.name("firstName"));
		//2. what type of action/operation we are doing
		// send Rama to first name element
		firstNameEle.sendKeys("Rama");
		Thread.sleep(3000);
		
		// clear  the entered val in fist name ele
		firstNameEle.clear();
		
		// again send "Sam" in to fist name ele
		firstNameEle.sendKeys("Sam");
		
		// get val from text box
		
//		String Textboxval=firstNameEle.getAttribute("id");// firstId
//		String Textboxval=firstNameEle.getAttribute("name");// foirstName
		String Textboxval=firstNameEle.getAttribute("value");//  text box value
		System.out.println("Textboxval="+Textboxval);// Sam
		//Textboxval=Sam
		
//		HW2: use  id  for all Last name text box 
//		ex:driver.findElement(By.name("firstName")).sendKeys("Ramu");
		
//		driver.findElement(By.name("firstName")).clear();
		
		
//		By.id("");
//		By.name("");
		


	}

}
