package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.util.ElementUtil;

public class VehicleVerification {
	public WebDriver driver;
	public VehicleVerification(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//label[@for='NoOfAmendVeh']") WebElement AmendVehicleslbl; //text
	@FindBy(xpath="//input[@id='NoOfAmendVeh']") WebElement AmendVehicles;  //value
	@FindBy(xpath="//label[@for='NoOfAddVeh']") WebElement AddVehicleslbl;
	@FindBy(xpath="//input[@id='NoOfAddVeh']") WebElement AddVehicles;
	@FindBy(xpath="//label[@for='NoOfDelVeh']") WebElement DeleteVehicleslbl;
	@FindBy(xpath="//input[@id='NoOfDelVeh']") WebElement DeleteVehicles;
	@FindBy(xpath="//label[@for='NoOfRenewVeh']") WebElement RenewVehicleslbl;
	@FindBy(xpath="//input[@id='NoOfRenewVeh']") WebElement RenewVehicles;

	public String FetchAmendVehiclelbl() {
		return ElementUtil.FetchTextBoxValuewithText(AmendVehicleslbl);
	}
	public String FetchAmendVehicle() {
		return ElementUtil.FetchTextBoxValuewithattribute(AmendVehicles, "value");
	}
	
	public String FetchAddVehicleslbl() {
		return ElementUtil.FetchTextBoxValuewithText(AddVehicleslbl);
	}
	public String FetchAddVehicles() {
		return ElementUtil.FetchTextBoxValuewithattribute(AddVehicles, "value");
	}
	
	public String FetchdeleteVehiclelbl() {
		return ElementUtil.FetchTextBoxValuewithText(DeleteVehicleslbl);
	}
	public String FetchdeleteVehicle() {
		return ElementUtil.FetchTextBoxValuewithattribute(DeleteVehicles, "value");
	}
	
	public String FetchRenewVehiclelbl() {
		return ElementUtil.FetchTextBoxValuewithText(RenewVehicleslbl);
	}
	public String FetchRenewVehicle() {
		return ElementUtil.FetchTextBoxValuewithattribute(RenewVehicles, "value");
	}
	
}
