package com.pages;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.util.ElementUtil;

public class Loginpage {

	public WebDriver driver;

	// 1. By Locators: OR
	@FindBy(id="username") WebElement Userid;
	@FindBy(id="password") WebElement Passcode;
	@FindBy(className ="login_button") WebElement Loginbutton;
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
		
			ElementUtil.webEditTxtChange(Userid, userid);
			//Userid.sendKeys(userid);
		}
		public void enterPassword(String pswd) {
			ElementUtil.webEditTxtChange(Passcode, pswd);
			//Passcode.sendKeys(pswd);
		}
		public void clickOnLogin()  {
			ElementUtil.clickElement(Loginbutton, Duration.ofSeconds(100));
			//ElementUtil.clickElementUsingActions(Loginbutton);
			//Loginbutton.click();
		}

		public
		SearchHotelpage doLogin(String un, String pwd) {
			System.out.println("login with: " + un + " and " + pwd);
			ElementUtil.webEditTxtChange(Userid, un);
			ElementUtil.webEditTxtChange(Passcode, pwd);
			ElementUtil.clickElement(Loginbutton, Duration.ofSeconds(100));
			//ElementUtil.clickElementUsingActions(Loginbutton);
			//Loginbutton.click();
			/*Userid.sendKeys(un);
			Passcode.sendKeys(pwd);
			Loginbutton.click();*/
			return new SearchHotelpage(driver);
			}

}
