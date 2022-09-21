package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.qa.util.ElementUtil;

public class LoginPage {
	public WebDriver driver;
	
	@FindBy(xpath="//input[@id='UserName']") WebElement LoginUserId;  
	@FindBy(xpath="//input[@id='Password']") WebElement LoginPassword;
	@FindBy(xpath="//input[@id='btnlogin']") WebElement LoginbtnLogin;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// 3. page actions: features(behavior) of the page the form of methods:

	public String getLoginPageTitle() {
		return driver.getTitle();
	}

	public void enterUsername(String username) throws Exception {
		ElementUtil.webEditTxtChange(LoginUserId,username);
	}
	public void enterPassword(String password) {
		ElementUtil.webEditTxtChange(LoginPassword,password);
	}
	public void clickLoginbtn() throws InterruptedException {
		ElementUtil.clickElementUsingActions(LoginbtnLogin);
		Thread.sleep(2000);
	}
}
