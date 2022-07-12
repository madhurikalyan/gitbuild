package com.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {
	
	public WebDriver driver;

	// 1. By Locators: OR
	@FindBy(id="username") WebElement Userid;
	@FindBy(id="password") WebElement Passcode;
	@FindBy(id="login") WebElement Loginbutton;
	@FindBy(linkText="Forgot Password?12") WebElement Forgotpwdlink;
				// 2. Constructor of the page class:
		public Loginpage(WebDriver driver) {
			this.driver = driver;	
			PageFactory.initElements(driver, this);
		}
		
		// 3. page actions: features(behavior) of the page the form of methods:
		public String getLoginPageTitle() {	
			return driver.getTitle();
					}
		
		public boolean isForgotPwdLinkExist() {
			return Forgotpwdlink.isDisplayed();
		}

		public void enterUserName(String userid) throws IOException {
			Userid.sendKeys(userid);
		}
		public void enterPassword(String pswd) {
			Passcode.sendKeys(pswd);			  
		}	
		public void clickOnLogin()  {
			Loginbutton.click();
		}

		public
		SearchHotelpage doLogin(String un, String pwd) {
			System.out.println("login with: " + un + " and " + pwd);
			Userid.sendKeys(un);
			Passcode.sendKeys(pwd);
			Loginbutton.click();
			return new SearchHotelpage(driver);
			}
		
}
