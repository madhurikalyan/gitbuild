package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	private WebDriver driver;
	// 1. By Locators: OR
		private By Username = By.id("txtUsername");
		private By Password = By.id("txtPassword");
		private By LOGIN = By.id("btnLogin");
		
		
	public String getLoginPageTitle() {
		return driver.getTitle();
	}
	public void enterUserName(String username) {
		driver.findElement(Username).sendKeys(username);
	}

	public void enterPassword(String pwd) {
		driver.findElement(Password).sendKeys(pwd);
	}

	public void clickOnLogin() {
		driver.findElement(LOGIN).click();
	}

}
