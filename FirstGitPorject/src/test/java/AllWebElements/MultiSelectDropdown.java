package AllWebElements;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MultiSelectDropdown {

	public static void main(String[] args) throws InterruptedException {

		// 1. open chrome browser //set property
	//	System.setProperty("webdriver.chrome.driver",  "D:\\SeleniumSoftwares\\All Selenium Jar Files\\chromedriver_win32V94\\chromedriver.exe");		//		  
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		
		// open url in browser
		driver.get("file:///D:/Practise/qtp%20practise/web%20apps/ALL%20Web%20objects.html");
			
		WebElement MultiDrpdwn= driver.findElement(By.xpath("//select[@name='MultiCars']"));
		Select sel= new Select(MultiDrpdwn);
		
		// is it multi sleect dropdown or not
		boolean isMultiple = sel.isMultiple();
		System.out.println("isMultiple="+isMultiple);// true
		
		// 1. selectByVisibleText  --select mu;ltiple vals
//		sel.selectByVisibleText("Maruthi");
//		sel.selectByVisibleText("Audi");
		
		//2.selectByIndex
//		sel.selectByIndex(0);
//		sel.selectByIndex(2);// if already sleectd,  it will select but not deselected
//		sel.selectByIndex(3);
//		
		//Hw: invalid index no ??
	
		// 3. selectByValue
//		sel.selectByValue("Maruthival");
//		sel.selectByValue("Benzval");
//		sel.selectByValue("audival");
		
		//**********************************
		//delsect vals 
//		sel.deselectByVisibleText("Maruthi");
//		sel.deselectByVisibleText("Benz");
//		sel.deselectByVisibleText("Audi");
		
//		sel.deselectAll();
		sel.selectByVisibleText("Maruthi");
		sel.selectByVisibleText("Audi");
		sel.selectByVisibleText("Benz");
		
		List<WebElement> getAllSelectedOptions=sel.getAllSelectedOptions();
		
		for(int i=0;i<=getAllSelectedOptions.size()-1;i++)
		{
			String val =getAllSelectedOptions.get(i).getText();
			System.out.println("val="+val);
			/*
			 * val=Maruthi val=Benz val=Audi
			 */
		}
		
		
		
		// HW :get all vals from dropdown	
		
		
		
		

	}

}
