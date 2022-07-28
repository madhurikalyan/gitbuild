/***************************************************************************

*                                                                          *

*             Page details:  This is the page file for login page          *
                             Contains object and associated actions
*             Author:        Venukrishnan VR                               *

*                                                                          *

*                                                                          *

***************************************************************************/
package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class loginPageB {
	public WebDriver driver;
	public homePageB obj_homePage=new homePageB(null);
	// Page Factory - OR
	
	@FindBy(xpath="//span[@id='a-autoid-0']/span[@class='a-button-inner']")
	WebElement link_signIn;
	
	@FindBy(name="email")
	WebElement textbox_username;
	
	@FindBy(id="continue")
	WebElement button_continue;
	
	@FindBy(name="password")
	WebElement textbox_password;
	
	@FindBy(id="signInSubmit")
	WebElement button_login;
	
	@FindBy(xpath="//div[@id='nav-logo']/a[@class='nav-logo-link']")
	WebElement img_logo;
	
	// Initializing the page objects.
	public loginPageB(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	// Actions
	public boolean validateLogo(){
		return img_logo.isDisplayed();
	}
	
	public String selectsigninlink(){
		link_signIn.click();
		return driver.getTitle();
	}
	
	public void enterUserName(String un){
		textbox_username.sendKeys(un);
		button_continue.click();
	}
	
	public void enterPassword(String pw){
		textbox_password.sendKeys(pw);
		button_login.click();
	}
	
	public homePageB verifyHomePage(){
		
		return obj_homePage;
	}
	
	
	
}
