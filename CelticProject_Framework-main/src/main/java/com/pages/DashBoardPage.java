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
	//Links
	@FindBy(xpath="//a[@title='Renew Fleet']") WebElement DashboardRenewFleetLink;
	@FindBy(xpath="//a[@title='Fleet Inquiry']") WebElement DashboardFleetEnquiry;
	@FindBy(xpath="//a[@title='Supplement Continuance']") WebElement Dashboard_SupplementContinuancelnk;
	@FindBy(xpath="//a[@title='Vehicle Inquiry']") WebElement DashboardVehicleEnquiry;
	@FindBy(xpath="//a[@title='Vehicle Supplement Inquiry']") WebElement DashboardVehicleSupplementEnquiry;
	@FindBy(xpath="//a[@title='Supplement Inquiry']") WebElement DashboardSupplementEnquiry;
	@FindBy(xpath="//a[@title='Account Inquiry']") WebElement DashboardAccountEnquiry;
	@FindBy(xpath="//a[@title='Supplement Documents']") WebElement DashboardSupplementDocuments;
@FindBy(xpath="//a[@title='Logout']") WebElement DashboardLogout;	
	// Elements for SiteMappage

		@FindBy(xpath="//a[text()='Add Vehicle']") WebElement SitemapAddvechile;
		@FindBy(xpath="//input[@id='AccountNo']") WebElement AccountNo;
		@FindBy(id="FleetNbr") WebElement VehicleFleetNo;
		@FindBy(id="FltExpYear") WebElement VehicleExpyr;
		@FindBy(id="btnProceed") WebElement VehicleProceed;
		
		//After Successfully added into cart
@FindBy(xpath="//ul[@class='errorMessage']//span") WebElement Dashboard_Message;


@FindBy(xpath="//ul[contains(@class,'errorMessage')]/li/span") WebElement Dashboard_ErrorMessge;
@FindBy(xpath="//a[@id='cartRef']") WebElement Cartimg;


//Reinstatement
@FindBy(xpath="//li[@class='dropdown']/a[contains(text(),'More')]") WebElement Dashboard_FleetMore;
@FindBy(xpath="//a[text()='Fleet Reinstatement']") WebElement Dashoboad_More_FleetReinstatement;


public DashBoardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void validatetitle() {
		if(driver.getTitle().equalsIgnoreCase("Missouri Department of Transportation -  Enterprise")) {
			assert true;
			System.out.println("Current screen is Missouri Department of Transportation -  Enterprise");
		}
		else {
			assert false;
			System.out.println("Current screen is not Missouri Department of Transportation -  Enterprise");
		}
	}
	public void clickServiceLink() throws InterruptedException {
		ElementUtil.clickElementUsingActions(DashboardServicesLink);
		ElementUtil.sleepTime(2000);
	}
	public void clickIRPLink() throws InterruptedException {
		ElementUtil.clickElementUsingActions(DashboardIRPLink);
		ElementUtil.sleepTime(2000);
	}

	public void validateIRPScreen(String title) throws InterruptedException {
		ElementUtil.highlightElement(driver, DashboardIRPHeader);
		if(DashboardIRPHeader.getText().equalsIgnoreCase(title)) {
			assert true;
		}
		else {
			assert false;
		}
		ElementUtil.sleepTime(2000);
	}


	public void clickRenewFleetLink() throws InterruptedException {
		ElementUtil.clickElementUsingActions(DashboardRenewFleetLink);
		ElementUtil.sleepTime(2000);
	}
public void validateMessage(CharSequence SuccessMessageValue) {
	
	if(Dashboard_Message.getText().contains(SuccessMessageValue)) { //Transaction is added to cart - 4113 successfully.
		assert true;
		System.out.println("Pass");
	}
	else {
		assert false;
		System.out.println("Fail");
	}
	
}
public void clickSupplementContinuance() throws InterruptedException {
	ElementUtil.clickElementUsingActions(Dashboard_SupplementContinuancelnk);
	ElementUtil.sleepTime(2000);
}
public void clickFleetEnquiry() throws InterruptedException {
	ElementUtil.clickElementUsingActions(DashboardFleetEnquiry);
	ElementUtil.sleepTime(2000);
}
public void clickVehicleEnquiry() throws InterruptedException {
	ElementUtil.clickElementUsingActions(DashboardVehicleEnquiry);
	ElementUtil.sleepTime(2000);
}
public void clickVehicleSupplementEnquiry() throws InterruptedException {
	ElementUtil.clickElementUsingActions(DashboardVehicleSupplementEnquiry);
	ElementUtil.sleepTime(2000);
}
public void clickSupplementEnquiry() throws InterruptedException {
	ElementUtil.clickElementUsingActions(DashboardSupplementEnquiry);
	ElementUtil.sleepTime(2000);
}
public void clickAccountEnquiry() throws InterruptedException {
	ElementUtil.clickElementUsingActions(DashboardAccountEnquiry);
	ElementUtil.sleepTime(2000);
}
public void clickSupplementDocuments() throws InterruptedException {
	ElementUtil.clickElementUsingActions(DashboardSupplementDocuments);
	ElementUtil.sleepTime(2000);
}


public void enterAccountNo(String AccountNoValue) {
	ElementUtil.webEditTxt(AccountNo, AccountNoValue);
}
public void validateErrorMessage(String ErrorMessgeValue) {
	//GENPAY01 : [E] This transaction already exists in the cart.
	if(Dashboard_ErrorMessge.getText().contains(ErrorMessgeValue)) {
		assert true;
		System.out.println("Pass");
	}
	else {
		assert false;
		System.out.println("Fail");
	}
	
}
public void clickCartimg() {
	ElementUtil.clickElement(Cartimg);
}
//Reinstatement
public void clickFleetMore() throws InterruptedException {
	ElementUtil.clickElement(Dashboard_FleetMore);
	ElementUtil.sleepTime(2000);
}
public void clickFleetReinstatement() {
	ElementUtil.clickElement(Dashoboad_More_FleetReinstatement);
}
public void clickLogout() {
	ElementUtil.clickElement(DashboardLogout);
}
}
