package AllWebElements;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ReadPropsFile {

	public static void main(String[] args) throws IOException {
	
		// create obj for props
		Properties props = new Properties();
		FileInputStream fis= new FileInputStream("D:\\Practise\\FrameWorkDeisgnsPractiseWorkSpace\\SumanthNewSelenium\\src\\test\\AllXPathProperties.properties");
		
		props.load(fis);
				
		// read props file 
		String BrowserUrl=props.getProperty("BrowserUrl");
		System.out.println("BrowserUrl="+BrowserUrl);
		
		String Browser=props.getProperty("Browser");
		System.out.println("Browser="+Browser);
		
//		BrowserUrl=file:///D:/Practise/qtp%20practise/web%20apps/ALL%20Web%20objects.html
//			Browser=Chrome
			
		// FirstName_Textbox
		String FirstName_Textbox=props.getProperty("FirstName_Textbox");
		System.out.println("FirstName_Textbox="+FirstName_Textbox);
		//FirstName_Textbox=//*[@name='firstname']
		
		// 1. open chrome browser //set property
	//	System.setProperty("webdriver.chrome.driver",  "D:\\SeleniumSoftwares\\All Selenium Jar Files\\chromedriver_win32V94\\chromedriver.exe");		//		  
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		
		// open url in browser
//		Remove hard code val and use the data from props file 
		//driver.get("file:///D:/Practise/qtp%20practise/web%20apps/ALL%20Web%20objects.html");
		driver.get(BrowserUrl);
		//or
//		driver.get(props.getProperty("BrowserUrl"));
		
		driver.findElement(By.xpath(FirstName_Textbox)).clear();
		driver.findElement(By.xpath(FirstName_Textbox)).sendKeys("Sam");
		
		// HW2: Read LastName_Textbox  and enter sthng
		
		// Hw:REad I have a car checkbox  and click it 
		
		
	}

}
