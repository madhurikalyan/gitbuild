package com.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.factory.Driver_Factory;
//import com.relevantcodes.extentreports.LogStatus;
import com.qa.util.ConfigReader;
import com.qa.util.ElementUtil;

public class ProductPage {
	public WebDriver driver;
    public ProductPage(WebDriver driver) {
    	this.driver = driver;
		PageFactory.initElements(driver, this);
    }
	
	@FindBy(id="nav-signin-tooltip") WebElement siginbutton;
	@FindBy(id="ap_email") WebElement username;
	@FindBy(id="continue") WebElement cont;
	@FindBy(id="ap_password") WebElement password;
	@FindBy(id="signInSubmit") WebElement submitbutton;
	@FindBy(id="twotabsearchtextbox") WebElement Searchtextbox;
	@FindBy(id="nav-search-submit-button") WebElement submitsearch;
	@FindBy(xpath="//div[contains(@class,'s-main-slot s-result-list s-search-results sg-row')]/descendant::a[1]") WebElement item1;
	@FindBy(xpath="//span[contains(@id,'amazons-choice')]") WebElement amazonschoice;
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
	@FindBy(xpath="//select[@id='quantity']")
	public WebElement ddquantity;
	@FindBy(xpath=".//*[@id='nav-link-accountList']") WebElement ActionEle;
	@FindBy(xpath=".//*[@id='nav-al-your-account']") WebElement ActionEle1;
	@FindBy(xpath="//span[contains(text(),'Sign Out')]") WebElement signout;
	
	@FindBy(xpath="//input[@value='Delete']") WebElement delete;
	@FindBy(name="proceedToRetailCheckout") WebElement proceedcheckout;
	@FindBy(xpath="//h1[@class='a-spacing-base']	") WebElement selectAddress;
	@FindBy(xpath="//span[@class='a-dropdown-prompt']") WebElement quantityselected;
	@FindBy(xpath="//a[contains(text(),'Go to')]") WebElement gotocart;
	@FindBy(xpath="//input[@value='Save for later']") WebElement saveforlater;


	@FindBy(xpath="//a[contains(@aria-label,'Choose a language for shopping.')]") WebElement ddcountry;
	@FindBy(xpath="//div[contains(text(),'Change country/region.')]") WebElement changecountrylink;
	@FindBy(xpath="//select[@id='icp-dropdown']") WebElement ddcountryselect;

	
	
	public void searchproduct(String  searchele) throws  Exception{
		ElementUtil.webEditTxtChange(Searchtextbox, searchele);
		Thread.sleep(2000);
		ElementUtil.highlightElement(driver, Searchtextbox);
		Thread.sleep(3000);
		ElementUtil.highlightElement(driver, submitsearch);
		ElementUtil.clickElementUsingActions(submitsearch);
		Thread.sleep(2000);
		if(amazonschoice.isDisplayed()) {
			ElementUtil.highlightElement(driver, amazonschoice);
			ElementUtil.clickElementUsingActions(amazonschoice);
		}
		else {
			ElementUtil.highlightElement(driver, item1);
			ElementUtil.clickElementUsingActions(item1);
		}
		Thread.sleep(2000);
	}
	
	
	public void inputQuantity(WebElement dd,String quantityvalue) throws  Exception{
		WebDriverWait ww =new WebDriverWait(driver,Duration.ofSeconds(3000));
		ww.until(ExpectedConditions.elementToBeClickable(dd));
		Select quantity = new Select(dd);
		quantity.selectByValue(quantityvalue);
		Thread.sleep(2000);
	}
	public void NavigatetoCart() throws  Exception{
		ElementUtil.highlightElement(driver, addtocart);
		ElementUtil.clickElementUsingActions(addtocart);
		Thread.sleep(2000);
		ElementUtil.highlightElement(driver, validateaddtocart);
		ElementUtil.clickElementUsingActions(validateaddtocart);
		Thread.sleep(2000);		
	}
	public void NavigatetoCheckout() throws  Exception{
		ElementUtil.highlightElement(driver, addtocart);
		ElementUtil.clickElementUsingActions(addtocart);
		Thread.sleep(2000);
		ElementUtil.highlightElement(driver, proceedcheckout);
		ElementUtil.clickElementUsingActions(proceedcheckout);
		Thread.sleep(2000);		
			}

	public void ValidateCart(String Expectedquantityvalue) throws  Exception{
		ElementUtil.highlightElement(driver, quantityselected);
		String Actualquantityvalue=quantityselected.getText();
		if(Actualquantityvalue.equalsIgnoreCase(Expectedquantityvalue)) {
			System.out.println("Pass for validating the cart");
		}
		else {
			System.out.println("Fail for validating the cart"+Expectedquantityvalue);
		}
	}
	public void delete() throws Exception{
		ElementUtil.highlightElement(driver, delete);
		ElementUtil.clickElementUsingActions(delete);
		Thread.sleep(3000);
	}
public void Login() throws Exception { 
	Driver_Factory.getDriver().get(ConfigReader.readLoginURL());
	//driver.get(ConfigReader.readLoginURL());
	Thread.sleep(1000);
	ElementUtil.highlightElement(driver, siginbutton);
	ElementUtil.clickElementUsingActions(siginbutton);
	Thread.sleep(1000);		
	ElementUtil.highlightElement(driver,username);
	ElementUtil.webEditTxtChange(username,ConfigReader.readuserid());
	Thread.sleep(1000);
	ElementUtil.highlightElement(driver, cont);
	ElementUtil.clickElementUsingActions(cont);
	Thread.sleep(1000);
	ElementUtil.highlightElement(driver, password);
	ElementUtil.webEditTxtChange(password,ConfigReader.readpswrd() );
	Thread.sleep(1000);
	ElementUtil.highlightElement(driver, submitbutton);
	ElementUtil.clickElementUsingActions(submitbutton);
	Thread.sleep(1000);
}
public  void item1() throws Exception{
	//Item1
	searchproduct("Amazon Essentials Women's Digital Chronograph Resin Strap Watch");
			NavigatetoCart();
			ValidateCart("1");
			Thread.sleep(3000);
}
public  void item2() throws Exception{
	//Item2
			searchproduct("Mobile");
			inputQuantity(ddquantity, "2");
			NavigatetoCart();
			ValidateCart("2");
			Thread.sleep(3000);
}
public  void item3() throws Exception{
			//Item3
			searchproduct("mouse");
			NavigatetoCart();
			Thread.sleep(3000);
			delete();
}
public  void item4() throws Exception{
			//Item4
			searchproduct("Watch");
			NavigatetoCheckout();
			validateshippingscreen();
			navigateback();
			saveforlaterandgotocart();
			
}
public void validateshippingscreen() throws InterruptedException {
	ElementUtil.highlightElement(driver, selectAddress);
	if(selectAddress.getText().equalsIgnoreCase("Select a shipping address")) {
		System.out.println("Pass");
	}
	else {
		System.out.println("Fail");
	}
	Thread.sleep(3000);

}
public void navigateback() throws InterruptedException {
	driver.navigate().back();
	Thread.sleep(2000);
}	
public void saveforlaterandgotocart() throws InterruptedException {
	ElementUtil.highlightElement(driver, gotocart);
	ElementUtil.clickElementUsingActions(gotocart);
	Thread.sleep(3000);
	ElementUtil.highlightElement(driver, saveforlater);
	ElementUtil.clickElementUsingActions(saveforlater);
	Thread.sleep(3000);
}
}

