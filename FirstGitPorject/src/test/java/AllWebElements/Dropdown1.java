package AllWebElements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dropdown1 {

	public static void main(String[] args) throws InterruptedException {

		// 1. open chrome browser //set property
		//System.setProperty("webdriver.chrome.driver",  "D:\\SeleniumSoftwares\\All Selenium Jar Files\\chromedriver_win32V94\\chromedriver.exe");		//		  
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		
		// open url in browser
		driver.get("file:///D:/Practise/qtp%20practise/web%20apps/ALL%20Web%20objects.html");
			
		// how can we handle dropdown :
		//  select any val from dropdpwn
		WebElement CarsDropdpwnEle= driver.findElement(By.xpath("//select[@name='cars']"));
		Select sel= new Select(CarsDropdpwnEle);
		
		sel.selectByVisibleText("Audi");
		String getFirstSelectedOption= sel.getFirstSelectedOption().getText();
			
//		WebElement  optionEle= sel.getFirstSelectedOption();
//		getFirstSelectedOption= optionEle.getText();
		System.out.println("getFirstSelectedOption="+getFirstSelectedOption);//Audi
		
		//Note: getText() 
//		<a> gmail link </a>
//		<p> My para </p>
//		<option> Audi </option>
		
		sel.selectByVisibleText("Maruthi");		
		
		//invalid
		//sel.selectByVisibleText("Invlaid");// erorr
		//Exception in thread "main" org.openqa.selenium.NoSuchElementException:
		//Cannot locate option with text: Invlaid
		
		
		// case senisitive
//		sel.selectByVisibleText("audi"); // errror  as dropdpwn vals are case senisitve
//		 org.openqa.selenium.NoSuchElementException: Cannot locate option with text: audi
		// sol: We must give exact value from Dropdown i.e Audi
		//2 .  
		sel.selectByIndex(0);
		Thread.sleep(3000);
		sel.selectByIndex(1);
		Thread.sleep(3000);		
		
		
	// -ve invlaid   index no = 6  
//		sel.selectByIndex(6);
		//Error:org.openqa.selenium.NoSuchElementException: Cannot locate option with index: 6
		
		// 3. 
		sel.selectByValue("Swiftvdival");
	
		// get selected val from dropdown
		 getFirstSelectedOption= sel.getFirstSelectedOption().getText();
		System.out.println("getFirstSelectedOption="+getFirstSelectedOption);
		//getFirstSelectedOption=Maruthi
		
		
		
		// get all dropdown vals count
		List<WebElement> allOptionsEle = sel.getOptions();
		
		//count of drop down vals
		int dropdownValscnt= allOptionsEle.size();
		System.out.println("dropdownValscnt="+dropdownValscnt);// 5
		
		// Way -1 
		for(int i=0;i<= allOptionsEle.size()-1;i++)
			
		{
			WebElement  optionEle=	allOptionsEle.get(i);
			
			 String DropdownOptionval= optionEle.getText();
			 System.out.println("DropdownOptionval="+DropdownOptionval);
				/*
				 * DropdownOptionval=Maruthi 
				 * DropdownOptionval=Swiftvdi
				 * DropdownOptionval=Mercedes 
				 * DropdownOptionval=Audi 
				 * DropdownOptionval=Kia
				 */
			}
			
		
		//2 . For each loop
		for(WebElement EachEle: allOptionsEle)
		{
			String eachDropdownVal=EachEle.getText();
			System.out.println("eachDropdownVal="+eachDropdownVal);
			/*
			 * eachDropdownVal=Maruthi eachDropdownVal=Swiftvdi eachDropdownVal=Mercedes
			 * eachDropdownVal=Audi eachDropdownVal=Kia
			 */
		}
		
		
		//  HW is displayed
		
		//Hw  is enabled
		
		// isselected  --  error ???
		
		
		//******************************************
		// 1 send text through k/b 
		//	WebElement carsDropdwonEle= driver.findElement(By.xpath("//select[@name='cars']"));
//		System.out.println("Selecting Audi");
//		Thread.sleep(4000);
//		carsDropdwonEle.sendKeys("Audi");
//		
//		Thread.sleep(4000);
//		System.out.println("Selecting Mercedes");
//		carsDropdwonEle.sendKeys("Mercedes");
//		
//		Thread.sleep(4000);
//		System.out.println("Selecting Invalid");
//		carsDropdwonEle.sendKeys("Invalid");
//		System.out.println("ends");

	}

}
