package SynchronisationTimeOut;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.internal.EventFiringTouch;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitTimeoutWebdriverWait {

	public static void main(String[] args) throws InterruptedException {

		// 1. open chrome browser //set property
		System.setProperty("webdriver.chrome.driver",  "D:\\SeleniumSoftwares\\All Selenium Jar Files\\chromedriver_win32V94\\chromedriver.exe");		//		  
		WebDriver driver= new ChromeDriver();
			
		// open url in browser
		//driver.get("http://localhost/login.do");
		driver.navigate().to("http://localhost/login.do");
		
//		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		// implicit :  global time out,  define only applicable for all elemnt 
		// Explicit :    applicable for specific eleent
		
		driver.findElement(By.xpath("//*[@name='username']")).sendKeys("admin");
		driver.findElement(By.xpath("//*[@name='pwd']")).sendKeys("manager");
		
		driver.findElement(By.xpath("//a[@id='loginButton']")).click();
		//possiblityi of getting error		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='content tasksInVlaid']")));

		// wait for speciic  ele  max time= 6 sec.   it throws Excpetion  - TimeoutExcpetion or
//		Exception in thread "main" org.openqa.selenium.TimeoutException: Expected condition failed:
//		waiting for presence of element located by: By.xpath: //*[@class='content tasksInVlaid'] 
//		(tried for 6 second(s) with 500 milliseconds interval)
			
//		ExpectedConditions.visibilityOf(ele)
//		ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(""))
//		ExpectedConditions.invisibilityOf(Ele);
		ExpectedConditions.invisibilityOfElementLocated(By.xpath(""));
//		ExpectedConditions.invisibilityOfElementWithText(loc, text);
	
		// tile is
		ExpectedConditions.titleContains("");
		ExpectedConditions.titleIs("Create new csutomer");
		
		// alert
//		ExpectedConditions.alertIsPresent();
		
		//  element 
		
		
		
		
		
		
		
		
		
		
		
		
		ExpectedConditions.alertIsPresent();
		
		
			
		driver.findElement(By.xpath("//*[@class='content tasks']")).click();
		
		driver.findElement(By.linkText("Projects & Customers")).click();
		
		
		driver.findElement(By.xpath("//*[text()='Create Customer']")).click();
		
		

		
		
		
	

	}

}
