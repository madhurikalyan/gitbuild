package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	// 1. By Locators: OR
		//private By Username = By.id("txtUsername");
		//private By Password = By.id("txtPassword");
		//private By LOGIN = By.id("btnLogin");
		
		@FindBy(id="txtUsername")
		@CacheLookup
		WebElement txtboxusername;
		
		@FindBy(id="txtPassword")
		@CacheLookup
		WebElement txtboxpsswrd;
		
		@FindBy(id="btnLogin")
		@CacheLookup
		WebElement btnlogin;
	public String getLoginPageTitle() {
		return ldriver.getTitle();
	}
	
	public void enterUserName(String username) {
		txtboxusername.sendKeys(username);
		//driver.findElement(Username).sendKeys(username);
	}

	public void enterPassword(String pwd) {
		txtboxpsswrd.sendKeys(pwd);
		//driver.findElement(Password).sendKeys(pwd);
	}

	public void clickOnLogin() {
		btnlogin.click();
		//driver.findElement(LOGIN).click();
	}

}
