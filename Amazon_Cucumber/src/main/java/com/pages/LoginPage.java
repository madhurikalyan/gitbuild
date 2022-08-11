package com.pages;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import com.qa.util.ConfigReader;
import com.qa.util.ElementUtil;

public class LoginPage {

	public WebDriver driver;

	// 1. By Locators: OR
	@FindBy(id="nav-signin-tooltip") WebElement login;
	@FindBy(id="ap_email") WebElement Userid;
	@FindBy(id="continue") WebElement cont;
//	@FindBy(id="//input[@type='password']") WebElement Password;
	@FindBy(id="ap_password") WebElement Password;
	@FindBy(id="signInSubmit") WebElement singinbutton;
	@FindBy(xpath="//a[contains(text(),'United') and contains(text(),'States')]") WebElement changecountry;
	//@FindBy(id="searchDropdownBox") WebElement alldepartments;
	@FindBy(xpath="//div[@class='nav-search-scope nav-sprite']") WebElement alldepartments;
	
	@FindBy(id="nav-hamburger-menu") WebElement Menutab;
	@FindBy(id="searchDropdownBox") WebElement	searchdd;
	@FindBy(id="nav-hamburger-menu") WebElement menutab;
	// 2. Constructor of the page class:

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// 3. page actions: features(behavior) of the page the form of methods:

	public String getLoginPageTitle() {

		return driver.getTitle();

	}

	public void clickonsigin() {
		ElementUtil.highlightElement(driver, login);
		ElementUtil.clickElement(login);
		
	}

	public void enterUserName() throws IOException {
		ElementUtil.highlightElement(driver, Userid);
		ElementUtil.webEditTxtChange(Userid, ConfigReader.readuserid());

	}
	
	public void clickoncontinue() {
		ElementUtil.highlightElement(driver, cont);
		ElementUtil.clickElement(cont);
	
		
	}

	
	public void enterPassword() throws InterruptedException {
		Thread.sleep(2000);
		ElementUtil.highlightElement(driver, Password);
         ElementUtil.webEditTxtChange(Password, ConfigReader.readpswrd());
	}

	public void clickOnLogin() {
		ElementUtil.highlightElement(driver, singinbutton);
ElementUtil.clickElement(singinbutton);	
	}

	public void clickoncountrytab() {
		//ElementUtil.highlightElement(driver, changecountry);
ElementUtil.clickElementUsingJavscriptExecutor(changecountry);
	}
	
	public void validateonalldepartment()  {
		ElementUtil.highlightElement(driver, alldepartments);
ElementUtil.clickElement(alldepartments);	
		
		 Select s = new Select(searchdd);
	      List <WebElement> op = s.getOptions();
	      int size = op.size();
	      for(int i =0; i<size ; i++){
	         String options = op.get(i).getText();
	         System.out.println(options);
	      }
	}
	public void validatemenutab() {
		ElementUtil.highlightElement(driver, Menutab);
ElementUtil.clickElement(Menutab);

	    	 // WebElement menutab = driver.findElement(By.id("nav-hamburger-menu"));
	    	  System.out.println(menutab.getSize());
	    	/*  for(int i =0; i<menutab.getSize() ; i++){
	 	         String options = op.get(i).getText();
	 	         System.out.println(options);
	 	      }*/
	      }
}