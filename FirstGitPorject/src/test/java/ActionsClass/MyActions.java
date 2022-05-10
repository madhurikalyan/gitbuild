package ActionsClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MyActions {

	public static void main(String[] args) throws InterruptedException {

		// 1. open chrome browser //set property
		//System.setProperty("webdriver.chrome.driver",  "D:\\SeleniumSoftwares\\All Selenium Jar Files\\chromedriver_win32V94\\chromedriver.exe");		//		  
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		
		// open url in browser
		driver.get("file:///D:/Practise/qtp%20practise/web%20apps/MenuDesciption.html");
			
		// Actions: -- predefined Class in selenium API
		  //  check :  Sele APi
//		why :  to perform mouse movement operations  and also k/b operations (ctrl+  up/Down)
//		,, movetoelement(), drag and drop
		// move to elemnt and lcick()...
		// double click
		// right click 
		
		// move mouse over 'W3Schools.com'		
		//1  create Actions class obj  and pass driver
		Actions act = new Actions(driver);
		WebElement  W3schoolsEle= driver.findElement(By.id("id1"));
//		act.moveToElement(W3schoolsEle);
		// composite actions:  movetoelemnt().click() --- 
//		act.moveToElement(W3schoolsEle).build().perform();
		//or or performing the actions without calling build() first.
		act.moveToElement(W3schoolsEle).perform();
		
		String onmouseoverText= W3schoolsEle.getAttribute("onmouseover");
		System.out.println("onmouseoverText="+onmouseoverText);
		//onmouseoverText=gettip('W3Schools is the best Web Developers resource on the Web')
		//get only required msg:W3Schools is the best Web Developers resource on the Web
//		LEarn String methods in Java
		
//		Way2:
		String TooltipText=driver.findElement(By.id("tip")).getText();
		System.out.println("TooltipText="+TooltipText);
		//TooltipText=W3Schools is the best Web Developers resource on the Web
		
		// Hw2:  move mouse over 'Internet Explorer' and get tool tip msg
		
		
		// Hw3:move mouse over "Netscape Navigator " and and get tool tip msg
		
		
		System.out.println("end ");
		
		//********************************
	


	}

}
