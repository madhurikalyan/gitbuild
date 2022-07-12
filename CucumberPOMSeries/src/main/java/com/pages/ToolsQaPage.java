package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ToolsQaPage {
	private WebDriver driver;
	private By HomeLink = By.xpath("//a[text()='ome']");
	
	public ToolsQaPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getLoginPageTitle() {
		return driver.getTitle();
	}

	
	public boolean isHomeLinkExist() {
		return driver.findElement(HomeLink).isDisplayed();
	}


}
