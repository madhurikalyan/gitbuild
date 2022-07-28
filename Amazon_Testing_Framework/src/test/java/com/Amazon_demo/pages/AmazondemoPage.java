package com.Amazon_demo.pages;

import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.LogStatus;

import utility.ElementUtil;
import utility.ExcelReader;
import utility.TestBase;
import utility.Utility;

public class AmazondemoPage extends TestBase {
	WebDriver driver;
	
	private String baseUrl="https://www.amazon.in/";
	
	@FindBy(id="nav-signin-tooltip") WebElement siginbutton;
	@FindBy(id="ap_email") WebElement username;
	@FindBy(id="continue") WebElement cont;
	@FindBy(id="ap_password") WebElement password;
	@FindBy(id="signInSubmit") WebElement submitbutton;
	@FindBy(id="twotabsearchtextbox") WebElement Searchtextbox;
	@FindBy(id="nav-search-submit-button") WebElement submitsearch;
	@FindBy(linkText="44 Ltrs Casual Backpack (11629-Wolf_Blue)") WebElement watchsearch;
	@FindBy(xpath="//input[@id='add-to-cart-button']") WebElement addtocart;
	@FindBy(id="nav-cart-text-container") WebElement validateaddtocart;
	@FindBy(id="nav-link-accountList-nav-line-1") WebElement page;
	@FindBy(xpath="//*[text()='Edit addresses for orders and gifts']") WebElement youraddress;
	@FindBy(id="address-ui-widgets-enterAddressPostalCode") WebElement postalcode;
	@FindBy(id="address-ui-widgets-enterAddressLine1") WebElement addressline1;
	@FindBy(id="address-ui-widgets-enterAddressLine2") WebElement addressline2;
	@FindBy(id="address-ui-widgets-landmark") WebElement landmark;
	@FindBy(id="address-ui-widgets-enterAddressCity") WebElement cityname;
	@FindBy(id="address-ui-widgets-enterAddressStateOrRegion") WebElement statename;
	@FindBy(id="ya-myab-plus-address-icon") WebElement addaddress;
	@FindBy(xpath="//*[@id='address-ui-widgets-form-submit-button']/span/input") WebElement addaddress2;
	@FindBy(id="address-ui-widgets-enterAddressFullName") WebElement fullname;
	@FindBy(id="address-ui-widgets-enterAddressPhoneNumber") WebElement phonenumber;
	@FindBy(id="quantity") WebElement ddquantity;
	@FindBy(xpath=".//*[@id='nav-link-accountList']") WebElement ActionEle;
	@FindBy(xpath=".//*[@id='nav-al-your-account']") WebElement ActionEle1;
	@FindBy(xpath="//span[contains(text(),'Sign Out')]") WebElement signout;
	
	@FindBy(xpath="//input[@value='Delete']") WebElement delete;
	public AmazondemoPage(WebDriver driver) {
		System.out.println("a");
    	this.driver = driver;
    	System.out.println("b");
        //This initElements method will create all WebElements
        PageFactory.initElements(driver, this);
        System.out.println("c");
    }
	
	ExcelReader reader = new ExcelReader();
	
	public void AmazonPagedemo_test() throws Exception { 
		System.out.println("check");
		System.out.println("about to open Web Application");
		test.log(LogStatus.INFO, "about to open Web Application");
		driver.get(baseUrl);
		Thread.sleep(1000);
		test.log(LogStatus.INFO, "Web Application opened");
		Thread.sleep(1000);
		siginbutton.click();
		test.log(LogStatus.INFO, "Click on Sigup Link");
		Thread.sleep(1000);
		Utility.captureScreenshot(driver, "Sig in Button");		
		username.sendKeys("9445758113");
		test.log(LogStatus.INFO, "Enter Username");
		Thread.sleep(1000);
		Utility.captureScreenshot(driver, "Enter Username");	
		cont.click();
		test.log(LogStatus.INFO, "Click on Continue");
		Utility.captureScreenshot(driver, "Click on continue");
		Thread.sleep(1000);
		password.sendKeys("Suchi@0617");
		test.log(LogStatus.INFO, "Enter Password");
		Utility.captureScreenshot(driver, "Enter Password");
		Thread.sleep(1000);
		submitbutton.click();
		test.log(LogStatus.INFO, "Click on Submit");
		Utility.captureScreenshot(driver, "Click on Submit");
		Thread.sleep(1000);
		String parentTab = driver.getWindowHandle();
		searchproduct();
		//delete
		delete.click();
		Thread.sleep(5000);
		//closing the child window
		driver.close();

		Thread.sleep(3000);

		driver.switchTo().window(parentTab);
		Thread.sleep(5000);
		
		
		Utility.captureScreenshot(driver, "click on Home Page");
		
		test.log(LogStatus.INFO, "Click on Home Page");
Thread.sleep(2000);
		searchproduct();
		Thread.sleep(2000);
		driver.close();
		driver.switchTo().window(parentTab);
		//add address
		//ElementUtil.mouseoveronElement(driver,ActionEle);
		page.click();
		
		Utility.captureScreenshot(driver, "Click on Your Address");

		youraddress.click();
		
		test.log(LogStatus.INFO, "Click on Your Address");


		Thread.sleep(2000);
		

		Utility.captureScreenshot(driver, "Click on Add Address");

		addaddress.click();
		
		test.log(LogStatus.INFO, "Click on Add Address");
		Thread.sleep(2000);
			fullname.sendKeys(ExcelReader.readExcel(1, 0));
			Utility.captureScreenshot(driver, "Enter first name");

			test.log(LogStatus.INFO, "Enter FullName");

			Thread.sleep(2000);
			//phonenumber.sendKeys(ExcelReader.readExcel(1,6));
			phonenumber.sendKeys("9445758113");
			Utility.captureScreenshot(driver, "Enter Phonenumber");

			test.log(LogStatus.INFO, "Enter Phonenumber");

			Thread.sleep(2000);
			postalcode.clear();

			//postalcode.sendKeys(ExcelReader.readExcel(1, 7));
			postalcode.sendKeys("600072");
					

			Utility.captureScreenshot(driver, "Enter PostalCode");

			test.log(LogStatus.INFO, "Enter PostalCode");

			addressline1.sendKeys(ExcelReader.readExcel(1,1));

			Utility.captureScreenshot(driver, "Enter Addressline 1");

			test.log(LogStatus.INFO, "Enter Addressline 1");
			addressline2.sendKeys(ExcelReader.readExcel(1, 2));

			Utility.captureScreenshot(driver, "Enter Addressline 2");

			test.log(LogStatus.INFO, "Enter Addressline 2");

			landmark.sendKeys(ExcelReader.readExcel(1,3));

			Utility.captureScreenshot(driver, "Enter Landmark");

			test.log(LogStatus.INFO, "Enter Landmark");

			//cityname.sendKeys(ExcelReader.readExcel(1,4));

			Utility.captureScreenshot(driver, "Enter City");

			test.log(LogStatus.INFO, "Enter CityName");

			statename.sendKeys(ExcelReader.readExcel(1,5));

			Utility.captureScreenshot(driver, "Enter StateName");
			test.log(LogStatus.INFO, "Enter StateName");
			addaddress2.click();
			Utility.captureScreenshot(driver, "Enter Click Add Address");
			test.log(LogStatus.INFO, "Click Add Address");
			
			Thread.sleep(6000);
			}
	
	
	public void AmazonSignout() throws Exception {
		ElementUtil.mouseoveronElement(driver,ActionEle);	
		Thread.sleep(3000);
		signout.click();
		Thread.sleep(3000);	
	}
	public void searchproduct() throws  Exception{
		Searchtextbox.sendKeys("Wildcraft bag");
		Utility.captureScreenshot(driver, "Enter the Product");
		test.log(LogStatus.INFO, "Search Product");
	Utility.captureScreenshot(driver, "Click on Submit Search");
		submitsearch.click();
		test.log(LogStatus.INFO, "Click Search Button");
		Thread.sleep(2000);
		String parentTab = driver.getWindowHandle();
		// Find out the exact bag and click on the searched option
		watchsearch.click();
		Utility.captureScreenshot(driver, "Click on Selected Bag");
		test.log(LogStatus.INFO, "Click Selected bag");
		Thread.sleep(2000);
		String parent = driver.getWindowHandle();
		Set<String> s1 = driver.getWindowHandles();
		Iterator<String> iterator = s1.iterator();
		while (iterator.hasNext()) {
			String ChildWindow = iterator.next();
			if (!parent.equalsIgnoreCase(ChildWindow)) {
				driver.switchTo().window(ChildWindow);
			}
		}
		Select quantity = new Select(ddquantity);
		quantity.selectByValue("4");
		Thread.sleep(2000);
		Utility.captureScreenshot(driver, "Click on Quantity");
		test.log(LogStatus.INFO, "Click on Adding Quantity");
		Thread.sleep(2000);
		addtocart.click();
		Utility.captureScreenshot(driver, "Click Add To Cart");
		test.log(LogStatus.INFO, "Click Add To Cart");
		Thread.sleep(2000);
		validateaddtocart.click();
		Utility.captureScreenshot(driver, "Click On Validate Cart");
		test.log(LogStatus.INFO, "Click to Validate Cart");

	}
	}


