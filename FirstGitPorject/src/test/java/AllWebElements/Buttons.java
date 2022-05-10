package AllWebElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Buttons {

	public static void main(String[] args) throws InterruptedException {

		// 1. open chrome browser //set property
	//	System.setProperty("webdriver.chrome.driver",  "D:\\SeleniumSoftwares\\All Selenium Jar Files\\chromedriver_win32V94\\chromedriver.exe");		//		  
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		
		// open url in browser
		driver.get("file:///D:/Practise/qtp%20practise/web%20apps/ALL%20Web%20objects.html");
			
		// HW1
		// 1. send ''Ramu  into first name . last name , pwd 
		driver.findElement(By.name("firstname")).sendKeys("Swathi");
		
		driver.findElement(By.name("lastname")).sendKeys("Last name");
		
		driver.findElement(By.xpath("//*[@id='MyButton']")).click();
		
		// get button name
		// getATtribute() --
		String Buttonname= driver.findElement(By.xpath("//*[@id='MyButton']")).getAttribute("value");
		System.out.println("Buttonname="+Buttonname);
		//Buttonname=My Submit
		
		


	}

}
