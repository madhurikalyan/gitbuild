package AllWebElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LocatorsXpath {

	public static void main(String[] args) throws InterruptedException {

		// 1. open chrome browser //set property
	//	System.setProperty("webdriver.chrome.driver",  "D:\\SeleniumSoftwares\\All Selenium Jar Files\\chromedriver_win32V94\\chromedriver.exe");		//		  
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		
		// open url in browser
		driver.get("file:///D:/Practise/qtp%20practise/web%20apps/ALL%20Web%20objects.html");
			
		
//		 7.Xpath()
//		xpath sysntas:  // tagname[@Attrname= 'Attr val']
		
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Last name");
		
		
//		 8.CssSelector
//		syntax:   tagname[Attrname= 'Attr val']

//		ex:input[name='pwd']
		driver.findElement(By.cssSelector("input[name='pwd']")).sendKeys("Mercury");


	}

}
