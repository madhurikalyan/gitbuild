package com.Amazon_demo.pages;

import java.time.Duration;

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
	
	private String baseUrl="https://www.amazon.com/";
	
	@FindBy(id="nav-signin-tooltip") WebElement siginbutton;
	@FindBy(id="ap_email") WebElement username;
	@FindBy(id="continue") WebElement cont;
	@FindBy(id="ap_password") WebElement password;
	@FindBy(id="signInSubmit") WebElement submitbutton;
	@FindBy(id="twotabsearchtextbox") WebElement Searchtextbox;
	@FindBy(id="nav-search-submit-button") WebElement submitsearch;
	//@FindBy(xpath="44 Ltrs Casual Backpack (11629-Wolf_Blue)") WebElement watchsearch;
	//@FindBy(xpath="//span[contains(@id,'amazons-choice-label')]") WebElement item1;
	@FindBy(xpath="//div[contains(@class,'s-main-slot s-result-list s-search-results sg-row')]/descendant::a[1]") WebElement item1;
	//@FindBy(xpath="//span[contains(text(),'includes TV controls')and contains(text(),'Fire TV Stick with Alexa')]") WebElement item1;
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
	@FindBy(xpath="//select[@id='quantity']") WebElement ddquantity;
	@FindBy(xpath=".//*[@id='nav-link-accountList']") WebElement ActionEle;
	@FindBy(xpath=".//*[@id='nav-al-your-account']") WebElement ActionEle1;
	@FindBy(xpath="//span[contains(text(),'Sign Out')]") WebElement signout;
	
	@FindBy(xpath="//input[@value='Delete']") WebElement delete;
	@FindBy(name="proceedToRetailCheckout") WebElement proceedcheckout;
	@FindBy(xpath="//h1[@class='a-spacing-base']") WebElement selectAddress;
@FindBy(xpath="//span[@class='a-dropdown-prompt']") WebElement quantityselected;
@FindBy(xpath="//a[contains(text(),'Go to')]") WebElement gotocart;
@FindBy(xpath="//input[@value='Save for later']") WebElement saveforlater;


@FindBy(xpath="//a[contains(@aria-label,'Choose a language for shopping.')]") WebElement ddcountry;
@FindBy(xpath="//div[contains(text(),'Change country/region.')]") WebElement changecountrylink;
@FindBy(xpath="//select[@id='icp-dropdown']") WebElement ddcountryselect;
	public AmazondemoPage(WebDriver driver) {
    	this.driver = driver;
        //This initElements method will create all WebElements
        PageFactory.initElements(driver, this);
    }
	
	ExcelReader reader = new ExcelReader();
	
	public void AmazonPagedemo_test() throws Exception { 
		test.log(LogStatus.INFO, "about to open Web Application");
		driver.get(baseUrl);
		Thread.sleep(1000);
		test.log(LogStatus.INFO, "Web Application opened");
		Thread.sleep(1000);
		Thread.sleep(2000);
		ElementUtil.highlightElement(driver, siginbutton);
		ElementUtil.clickElement(siginbutton);
		//siginbutton.click();
		test.log(LogStatus.INFO, "Click on Sigup Link");
		Thread.sleep(1000);
		Utility.captureScreenshot(driver, "Sig in Button");		
		ElementUtil.highlightElement(driver, username);
		ElementUtil.webEditTxtChange(username, "9445758113");
		//username.sendKeys("9445758113");
		test.log(LogStatus.INFO, "Enter Username");
		Thread.sleep(1000);
		ElementUtil.highlightElement(driver, username);
		Utility.captureScreenshot(driver, "Enter Username");
		ElementUtil.highlightElement(driver, cont);
		ElementUtil.clickElement(cont);
		//cont.click();
		test.log(LogStatus.INFO, "Click on Continue");
		Utility.captureScreenshot(driver, "Click on continue");
		Thread.sleep(1000);
		ElementUtil.highlightElement(driver, password);
		ElementUtil.webEditTxtChange(password, "Suchi@0617");
	//	password.sendKeys("Suchi@0617");
		test.log(LogStatus.INFO, "Enter Password");
		Utility.captureScreenshot(driver, "Enter Password");
		Thread.sleep(1000);
		ElementUtil.highlightElement(driver, submitbutton);
		ElementUtil.clickElement(submitbutton);
		//submitbutton.click();
		test.log(LogStatus.INFO, "Click on Submit");
		Utility.captureScreenshot(driver, "Click on Submit");
		Thread.sleep(1000);
		//String parentTab = driver.getWindowHandle();
		//selectcountry();
		//Item1
		searchproduct("Amazon Essentials Women's Digital Chronograph Resin Strap Watch");
				NavigatetoCart();
				ValidateCart("1");
				Thread.sleep(3000);
		//Item2
				searchproduct("Mobile");
				inputQuantity(ddquantity, "2");
				NavigatetoCart();
				ValidateCart("2");
				Thread.sleep(3000);
				//Item3
				searchproduct("mouse");
				NavigatetoCart();
				Thread.sleep(3000);
				ElementUtil.highlightElement(driver, delete);
				ElementUtil.clickElement(delete);
				//delete.click();
				Thread.sleep(3000);
				//Item4
				searchproduct("Watch");
				NavigatetoCheckout();
				ElementUtil.highlightElement(driver, selectAddress);
				if(selectAddress.getText().equalsIgnoreCase("Select a shipping address")) {
					test.log(LogStatus.PASS,"Page is navigated to Select a shipping address");
				}
				else {
					test.log(LogStatus.FAIL,"Page is not navigated to Select a shipping address");
				}
				Thread.sleep(3000);
				driver.navigate().back();
				Thread.sleep(2000);
				ElementUtil.highlightElement(driver, gotocart);
				ElementUtil.clickElement(gotocart);
				//gotocart.click();
				Thread.sleep(3000);
				ElementUtil.highlightElement(driver, saveforlater);
				ElementUtil.clickElement(saveforlater);
			//	saveforlater.click();
				Thread.sleep(3000);
				
				
	}		
		public void AmazonSignout() throws Exception {
		ElementUtil.mouseoveronElement(driver,ActionEle);	
		Thread.sleep(3000);
		ElementUtil.highlightElement(driver, signout);
		ElementUtil.clickElement(signout);
		//signout.click();
		Thread.sleep(3000);	
	}
	
	public void searchproduct(String  searchele) throws  Exception{
		ElementUtil.webEditTxtChange(Searchtextbox, searchele);
		//Searchtextbox.sendKeys(searchele);
		Thread.sleep(2000);
		//Utility.captureScreenshot(driver, "Enter the Product");
		ElementUtil.highlightElement(driver, Searchtextbox);
		Thread.sleep(3000);
		test.log(LogStatus.INFO, "Search Product");
//	Utility.captureScreenshot(driver, "Click on Submit Search");
		ElementUtil.highlightElement(driver, submitsearch);
		ElementUtil.clickElement(submitsearch);
		//submitsearch.click();
		test.log(LogStatus.INFO, "Click Search Button");
		Thread.sleep(2000);
		// Find out the exact bag and click on the searched option
		//ElementUtil.scrollIntoView(ele1);
		ElementUtil.highlightElement(driver, item1);
		ElementUtil.clickElement(item1);
		//ele1.click();
		//Utility.captureScreenshot(driver, "Click on Selected Bag");
		test.log(LogStatus.INFO, "Click Selected Item");
		Thread.sleep(2000);
	}
	
	
	public void inputQuantity(WebElement dd,String quantityvalue) throws  Exception{
		Select quantity = new Select(dd);
		quantity.selectByValue(quantityvalue);
		Thread.sleep(2000);
		//Utility.captureScreenshot(driver, "Click on Quantity");
		test.log(LogStatus.INFO, "Click on Adding Quantity");
		Thread.sleep(2000);
	}
	public void NavigatetoCart() throws  Exception{
		ElementUtil.highlightElement(driver, addtocart);
		//addtocart.click();
		Thread.sleep(2000);
		//Utility.captureScreenshot(driver, "Click Add To Cart");
		test.log(LogStatus.INFO, "Click Add To Cart");
		Thread.sleep(2000);
		ElementUtil.highlightElement(driver, validateaddtocart);
		ElementUtil.clickElement(validateaddtocart);
		//validateaddtocart.click();
		Thread.sleep(2000);		
		//Utility.captureScreenshot(driver, "Click On Validate Cart");
		test.log(LogStatus.INFO, "Click to Validate Cart");

		
	}
	public void NavigatetoCheckout() throws  Exception{
		ElementUtil.highlightElement(driver, addtocart);
		addtocart.click();
		Thread.sleep(2000);
		//Utility.captureScreenshot(driver, "Click Add To Cart");
		test.log(LogStatus.INFO, "Click Add To Cart");
		Thread.sleep(2000);
		ElementUtil.highlightElement(driver, proceedcheckout);
		proceedcheckout.click();
		Thread.sleep(2000);		
		//Utility.captureScreenshot(driver, "Click On Validate Cart");
				test.log(LogStatus.INFO, "Click to proceed to check out");
				Thread.sleep(2000);

		
	}

	public void ValidateCart(String Expectedquantityvalue) throws  Exception{
		
		//ElementUtil.waitUntilElementVisible(quantityselected, Duration.ofSeconds(1000));
		ElementUtil.highlightElement(driver, quantityselected);
		String Actualquantityvalue=quantityselected.getText();
		test.log(LogStatus.INFO, Actualquantityvalue);
		ElementUtil.highlightElement(driver, quantityselected);
		if(Actualquantityvalue.equalsIgnoreCase(Expectedquantityvalue)) {
			test.log(LogStatus.PASS, "Quantity is same as selected");
		}
		else {
			test.log(LogStatus.FAIL, "Quantity is same as selected");
		}
	}
	
public void selectcountry() throws InterruptedException {
	ElementUtil.highlightElement(driver, ddcountry);
	ElementUtil.mouseoveronElement(driver,ddcountry);
	ElementUtil.highlightElement(driver, changecountrylink);
	ElementUtil.clickElement(changecountrylink);
	//changecountrylink.click();
	Thread.sleep(2000);
	ElementUtil.highlightElement(driver, ddcountryselect);
	Select quantity = new Select(ddcountryselect);
	//ElementUtil.highlightElement(driver, ddcountryselect);//
	quantity.selectByVisibleText("United States");
	Thread.sleep(2000);
	//Utility.captureScreenshot(driver, "Click on Quantity");
	test.log(LogStatus.INFO, "Click on Adding Quantity");
	Thread.sleep(2000);
	
}
}

