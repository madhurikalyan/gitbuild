package AllWebElements;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LinksAll {

	public static void main(String[] args) throws InterruptedException {

		// 1. open chrome browser //set property
	//	System.setProperty("webdriver.chrome.driver",  "D:\\SeleniumSoftwares\\All Selenium Jar Files\\chromedriver_win32V94\\chromedriver.exe");		//		  
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		
		// open url in browser
		driver.get("file:///D:/Practise/qtp%20practise/web%20apps/ALL%20Web%20objects.html");
		
		// identify links- a tag <a href="http://gmail.com">  My gmail </a>
		
		// 1.clikc link -using linkText
//		 diff ways
		driver.findElement(By.linkText("ToolTip Link")).click();
		
		// go back to page
		driver.navigate().back();
		
		// 1.clikc link -using partialLinkText
		driver.findElement(By.partialLinkText("Sumanth")).click();
		driver.navigate().back();
		
		//3. name. id, xpath,conatins text. text()
		driver.findElement(By.xpath("//a[contains(text(),'ToolTip Sumanth')]")).click();
		driver.navigate().back();
		
		// 2. get url from link -for ToolTip Sumanth
		String getUrlHref=driver.findElement(By.linkText("ToolTip Sumanth")).getAttribute("href");
		System.out.println("getUrlHref="+getUrlHref);
//		getUrlHref=file:///D:/Practise/qtp%20practise/web%20apps/WebTableAll.html

		
		
				
		//3.  get all links count and link names and link urls from page
		//.getText();  <a> My gmail  </a>
		
//		way1:
		
		List<WebElement> allAnchorTagsList= driver.findElements(By.tagName("a"));
		int allLinksCount= allAnchorTagsList.size();
		System.out.println("allLinksCount="+allLinksCount);//allLinksCount=7
		// way2:	
//		Hw 2 or  use xpath 
		
		System.out.println("get all links count and link names and link urls from page");
		for(int i=0;i<=allLinksCount-1;i++)
		{
			// get link tex
			String getLinkText=allAnchorTagsList.get(i).getText();
			System.out.println("getLinkText="+getLinkText);
			
			// get url 
			String  getUrl=allAnchorTagsList.get(i).getAttribute("href");
			System.out.println("getUrl="+getUrl);
			
		}
//		get all links count and link names and link urls from page
//		getLinkText=ToolTip Sumanth
//		getUrl=file:///D:/Practise/qtp%20practise/web%20apps/WebTableAll.html
//		getLinkText=ToolTip Link
//		getUrl=file:///D:/Practise/qtp%20practise/web%20apps/tooltip.html
//		getLinkText=WebTableAll Link
//		getUrl=file:///D:/Practise/qtp%20practise/web%20appsweb%20apps/WebTableAll.html
//		getLinkText=Login Form Link
//		getUrl=file:///D:/Practise/qtp%20practise/web%20apps/Login%20Form.html
//		getLinkText=
//		getUrl=file:///D:/Practise/qtp%20practise/web%20apps/default.asp
//		getLinkText=
//		getUrl=file:///D:/Practise/qtp%20practise/web%20apps/default.asp
//		getLinkText=Click here!
//		getUrl=http://www.w3schools.com/

		
		 // Hw:  same use -for each loop
		
			
		

	}

}
