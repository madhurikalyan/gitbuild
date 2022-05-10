package AllWebElements;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TablePractise3 {

	public static void main(String[] args) throws InterruptedException {

		// 1. open chrome browser //set property
	//	System.setProperty("webdriver.chrome.driver",  "D:\\SeleniumSoftwares\\All Selenium Jar Files\\chromedriver_win32V94\\chromedriver.exe");		//		  
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		
		// open url in browser
		driver.get("file:///D:/Practise/qtp%20practise/web%20apps/WebTableAll.html");
	
		
		/*
		 * WebElement DropdownEle=
		 * driver.findElement(By.xpath("//*[@id='ListboxTable01']//tr[2]/td/select"));
		 * 
		 * Select sel = new Select(DropdownEle); sel.selectByVisibleText("Honda");
		 */
		
		//
		//*[@id='ListboxTable01']//td[contains(text(),'Raj')]/preceding::select[1]
		
		//WebElement DropdownEle2= driver.findElement(By.xpath("//*[@id='ListboxTable01']//td[contains(text(),'Swathi')]/preceding-sibling::td[1]/select"));
		
		// remove hard code value -data
		String ename="Ram";
		WebElement DropdownEle2= driver.findElement(By.xpath("//*[@id='ListboxTable01']//td[contains(text(),'" + ename +"')]/preceding-sibling::td[1]/select"));
		
		Select sel2 = new Select(DropdownEle2);
		sel2.selectByVisibleText("Honda");
		
		System.out.println("ends");
		
	}
}
