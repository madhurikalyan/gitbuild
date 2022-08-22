package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.util.ElementUtil;

public class DashBoardPage {
	public WebDriver driver;
	
	@FindBy(xpath="//a[@title='Services']") WebElement DashboardServicesLink;
	@FindBy(xpath="//a[@title='IRP']") WebElement DashboardIRPLink;
	@FindBy(xpath="//div[@class='PageHeader row']") WebElement DashboardHeader;
	@FindBy(xpath="//div[@class='PageHeader row']//li[contains(@class,'breadcrumb-item')]") WebElement Dashboardsecondrow;
	@FindBy(xpath="//div[@class='PageHeader row']//li[contains(@class,'breadcrumb-item')]/strong") WebElement DashboardIRPHeader;
	@FindBy(xpath="//a[@title='Renew Fleet']") WebElement DashboardRenewFleetLink;
	
	// Elements for SiteMappage

		@FindBy(xpath="//a[text()='Add Vehicle']") WebElement SitemapAddvechile;
		@FindBy(id="AccountNo") WebElement VehicleAccountNo;
		@FindBy(id="FleetNbr") WebElement VehicleFleetNo;
		@FindBy(id="FltExpYear") WebElement VehicleExpyr;
		@FindBy(id="btnProceed") WebElement VehicleProceed;

	public DashBoardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void validatetitle() {
		if(driver.getTitle().equalsIgnoreCase("Missouri Department of Transportation -  Enterprise")) {
			System.out.println("Current screen is Missouri Department of Transportation -  Enterprise");
		}
		else {
			System.out.println("Current screen is not Missouri Department of Transportation -  Enterprise");
		}
	}
	public void clickServiceLink() throws InterruptedException {
		ElementUtil.clickElementUsingActions(DashboardServicesLink);
		Thread.sleep(2000);
	}
	public void clickIRPLink() throws InterruptedException {
		ElementUtil.clickElementUsingActions(DashboardIRPLink);
		Thread.sleep(2000);
	}

	public void validateIRPScreen() throws InterruptedException {
		ElementUtil.highlightElement(driver, DashboardIRPHeader);
		if(DashboardIRPHeader.getText().equalsIgnoreCase("IRP")) {
			
			System.out.println("Current screen is IRP");
		}
		else {
			System.out.println("Current screen is not IRP");
		}
		Thread.sleep(2000);
	}


	public void clickRenewFleetLink() throws InterruptedException {
		ElementUtil.clickElementUsingActions(DashboardRenewFleetLink);
		Thread.sleep(2000);
	}

}
