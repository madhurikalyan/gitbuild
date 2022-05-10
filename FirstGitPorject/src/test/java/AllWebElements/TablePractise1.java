package AllWebElements;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TablePractise1 {

	public static void main(String[] args) throws InterruptedException {

		// 1. open chrome browser //set property
	//	System.setProperty("webdriver.chrome.driver",  "D:\\SeleniumSoftwares\\All Selenium Jar Files\\chromedriver_win32V94\\chromedriver.exe");		//		  
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		
		// open url in browser
		driver.get("file:///D:/Practise/qtp%20practise/web%20apps/WebTableAll.html");
		
		// how to identify table   
		
		// get rows cnt
		List<WebElement> AllTrTagsList=driver.findElements(By.xpath("//table[@id='TestCaseTable01']/tbody/tr"));
		////table[@id='TestCaseTable01']/descendant::tr
		int rowsCnt=AllTrTagsList.size();
		System.out.println("rowsCnt="+rowsCnt);// rowsCnt=4
		
		// cols cnt 
		//table[@id='TestCaseTable01']/tbody/tr[1]/th
		List<WebElement> AllTHTagsList= driver.findElements(By.xpath("//table[@id='TestCaseTable01']/tbody/tr[1]/th"));
		int colcnt=AllTHTagsList.size();
		System.out.println("colcnt="+colcnt);//colcnt=5
		
		// or we can use //table[@id='TestCaseTable01']/descendant::th
		
		
		// verify column headings i.e
//		TCID	Test Case Description	Expected Value	Actual Value	Result
		boolean colexist=driver.findElement(By.xpath("//table[@id='TestCaseTable01']/descendant::th[contains(text(),'TCID')]")).isDisplayed();
		System.out.println("colexist="+colexist);
		
//		colexist=driver.findElement(By.xpath("//table[@id='TestCaseTable01']/descendant::th[contains(text(),'TCID01Invkhkh')]")).isDisplayed();
//		System.out.println("colexist="+colexist);// Exception as invalid xpath given
		// note: if element not found with given xpath, isDisplayed() throws NoSuchElementException but not boolean false
		// org.openqa.selenium.NoSuchElementException: no such element: Unable to locate element: {"method":"xpath","selector":"//table[@id='TestCaseTable01']/descendant::th[contains(text(),'TCID01Invkhkh')]"}
		
		
		//get all column names
		
		for(int i=0;i<=AllTHTagsList.size()-1;i++)
		{
			String Colname= AllTHTagsList.get(i).getText();
			System.out.println("Colno ="+ (i+1) + ",Col Name="+Colname);
				
		}
//				Colno =1,Col Name=TCID
//				Colno =2,Col Name=Test Case Description
//				Colno =3,Col Name=Expected Value
//				Colno =4,Col Name=Actual Value
//				Colno =5,Col Name=Result
		
		// Hw" For each loop
		
		// get all rows data
		for(int i=0;i<=AllTrTagsList.size()-1;i++)
		{
			String RowData= AllTrTagsList.get(i).getText();
			System.out.println("RowData ="+ (i+1) + ",RowData="+RowData);
				
		}
//				RowData =1,RowData=TCID Test Case Description Expected Value Actual Value Result
//				RowData =2,RowData=TC_01 Verify Login Login must be successfull Login is successfull Pass
//				RowData =3,RowData=TC_02 Verify Logout Logout must be successfull Logout is successfull Fail
//				RowData =4,RowData=TC_03 Verify Order creation Order must be created Order is created Pass
	
		// get data cell wise
		// //table[@id='TestCaseTable01']//tr[2]/td[1]
		//table[@id='TestCaseTable01']//tr[2]/td[2]
		
		//table[@id='TestCaseTable01']//tr[2]/td[5]
		
		// get only 2nd rows of data cell wise
		for(int i=1;i<=AllTHTagsList.size();i++)// 5
		{
			String myxpath="//table[@id='TestCaseTable01']//tr[2]/td[" + i+ "]";
			System.out.println("myxpath="+myxpath);
			String RowData= driver.findElement(By.xpath(myxpath)).getText();
			System.out.println("RowData ="+ (i+1) + ",RowData="+RowData);
			
		}
//		       myxpath=//table[@id='TestCaseTable01']//tr[2]/td[1]
//				RowData =2,RowData=TC_01
//				myxpath=//table[@id='TestCaseTable01']//tr[2]/td[2]
//				RowData =3,RowData=Verify Login
//				myxpath=//table[@id='TestCaseTable01']//tr[2]/td[3]
//				RowData =4,RowData=Login must be successfull
//				myxpath=//table[@id='TestCaseTable01']//tr[2]/td[4]
//				RowData =5,RowData=Login is successfull
//				myxpath=//table[@id='TestCaseTable01']//tr[2]/td[5]
//				RowData =6,RowData=Pass
		
		
		// get all rows  and all cell wise
		System.out.println("get all rows  and all cell wise");
		for(int i=2;i<=AllTrTagsList.size();i++)
		{
			for(int j=1;j<=AllTHTagsList.size();j++)
			{ // 2,1,  ,2,,2,  ,2 ,3
				String myxpath="//table[@id='TestCaseTable01']//tr[" +i+ " ]/td[" + j+ "]";
				System.out.println("myxpath="+myxpath);
				String RowDataCellWise= driver.findElement(By.xpath(myxpath)).getText();
				System.out.println("RowData ="+ (i+1) + ",RowDataCellWise="+RowDataCellWise);
				
			}				
		}
//		get all rows  and all cell wise
//		myxpath=//table[@id='TestCaseTable01']//tr[2 ]/td[1]
//		RowData =3,RowDataCellWise=TC_01
//		myxpath=//table[@id='TestCaseTable01']//tr[2 ]/td[2]
//		RowData =3,RowDataCellWise=Verify Login
//		myxpath=//table[@id='TestCaseTable01']//tr[2 ]/td[3]
//		RowData =3,RowDataCellWise=Login must be successfull
//		myxpath=//table[@id='TestCaseTable01']//tr[2 ]/td[4]
//		RowData =3,RowDataCellWise=Login is successfull
//		myxpath=//table[@id='TestCaseTable01']//tr[2 ]/td[5]
//		RowData =3,RowDataCellWise=Pass
//		myxpath=//table[@id='TestCaseTable01']//tr[3 ]/td[1]
//		RowData =4,RowDataCellWise=TC_02
//		myxpath=//table[@id='TestCaseTable01']//tr[3 ]/td[2]
//		RowData =4,RowDataCellWise=Verify Logout
//		myxpath=//table[@id='TestCaseTable01']//tr[3 ]/td[3]
//		RowData =4,RowDataCellWise=Logout must be successfull
//		myxpath=//table[@id='TestCaseTable01']//tr[3 ]/td[4]
//		RowData =4,RowDataCellWise=Logout is successfull
//		myxpath=//table[@id='TestCaseTable01']//tr[3 ]/td[5]
//		RowData =4,RowDataCellWise=Fail
//		myxpath=//table[@id='TestCaseTable01']//tr[4 ]/td[1]
//		RowData =5,RowDataCellWise=TC_03
//		myxpath=//table[@id='TestCaseTable01']//tr[4 ]/td[2]
//		RowData =5,RowDataCellWise=Verify Order creation
//		myxpath=//table[@id='TestCaseTable01']//tr[4 ]/td[3]
//		RowData =5,RowDataCellWise=Order must be created
//		myxpath=//table[@id='TestCaseTable01']//tr[4 ]/td[4]
//		RowData =5,RowDataCellWise=Order is created
//		myxpath=//table[@id='TestCaseTable01']//tr[4 ]/td[5]
//		RowData =5,RowDataCellWise=Pass
		
		
		// way2:  use   findelement xpath :  //table[@id='TestCaseTable01']//tr/td
		
		List<WebElement> AllTRTDTagsList =driver.findElements(By.xpath("//table[@id='TestCaseTable01']//tr/td"));
				
//		for(int i=2;i<=AllTRTDTagsList.size();i++)//Exception in thread "main" java.lang.IndexOutOfBoundsException: Index 15 out of bounds for length 15
			for(int i=0;i<=AllTRTDTagsList.size()-1;i++)// 
		{
			String eachTRTDData= AllTRTDTagsList.get(i).getText();
			System.out.println("eachTRTDData="+eachTRTDData);
		}
//					eachTRTDData=TC_01
//					eachTRTDData=Verify Login
//					eachTRTDData=Login must be successfull
//					eachTRTDData=Login is successfull
//					eachTRTDData=Pass
			
//					eachTRTDData=TC_02
//					eachTRTDData=Verify Logout
//					eachTRTDData=Logout must be successfull
//					eachTRTDData=Logout is successfull
//					eachTRTDData=Fail
			
//					eachTRTDData=TC_03
//					eachTRTDData=Verify Order creation
//					eachTRTDData=Order must be created
//					eachTRTDData=Order is created
//					eachTRTDData=Pass
					
			//Hw use for each loop
			System.out.println("use for each loop");
			for(WebElement  EachEle: AllTRTDTagsList)
			{
				
				String eachTRTDData= EachEle.getText();
				System.out.println("eachTRTDData="+eachTRTDData);
			}
//			use for each loop
//			eachTRTDData=TC_01
//			eachTRTDData=Verify Login
//			eachTRTDData=Login must be successfull
//			eachTRTDData=Login is successfull
//			eachTRTDData=Pass
//			eachTRTDData=TC_02
//			eachTRTDData=Verify Logout
//			eachTRTDData=Logout must be successfull
//			eachTRTDData=Logout is successfull
//			eachTRTDData=Fail
//			eachTRTDData=TC_03
//			eachTRTDData=Verify Order creation
//			eachTRTDData=Order must be created
//			eachTRTDData=Order is created
//			eachTRTDData=Pass
			
		// HW  Verify given text is exist in table
		
			//table[@id='TestCaseTable01']//tr/td[contains(text(),'Verify Login')]
				
		
		

	}

}
