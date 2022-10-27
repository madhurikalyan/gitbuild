package com.celtic.automation.cmcs.pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.celtic.automation.cmcs.util.ElementUtil;

public class VehicleTabPage {
	public WebDriver driver;
	public VehicleTabPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	// Elements for SiteMappage
	@FindBy(xpath="//div[@class='validation-summary-errors clearfix']") WebElement Vehicle_Validatemeesage;
	@FindBy(css ="#contentMsg > div > ul > li > span") WebElement Vehicle_Verificationmessage;
	@FindBy(css ="#contentMsg > div > ul") WebElement Vehicle_Verificationmessage2;
	@FindBy(css ="#contentMsg > div > ul > li:nth-child(1) > span") WebElement Vehicle_Verificationmessage3;
	@FindBy(css ="#contentMsg > div > ul > li:nth-child(2) > span") WebElement Vehicle_Verificationmessage4;

	@FindBy(xpath="(//div[contains(@class,'box-title')]/h4)[1]") WebElement VehicleRenewalDetailsSubHdr;
	@FindBy(xpath="//label[@for='NoOfAmendVeh']") WebElement VehicleAmendedVehicleslbl;
	@FindBy(xpath="//input[@id='NoOfAmendVeh']") WebElement VehicleAmendedVehiclestxt;
	
	@FindBy(xpath="//label[@for='NoOfAddVeh']") WebElement VehicleAddedVehicleslbl;
	@FindBy(xpath="//input[@id='NoOfAddVeh']") WebElement VehicleAddedVehiclestxt;
	
	@FindBy(xpath="//label[@for='NoOfDelVeh']") WebElement VehicleDeleteVehicleslbl;
	@FindBy(xpath="//input[@id='NoOfDelVeh']") WebElement VehicleDeleteVehiclestxt;
	
	@FindBy(xpath="//label[@for='NoOfRenewVeh']") WebElement VehicleRenewVehicleslbl;
	@FindBy(xpath="//input[@id='NoOfRenewVeh']") WebElement VehicleRenewVehiclestxt;
	
	@FindBy(xpath="//input[@id='VehicleAction' and contains(@title,'AMEND')]") WebElement VehicleAmendRd; 
	@FindBy(xpath="//input[@id='VehicleAction' and contains(@title,'DELETE')]") WebElement VehicleDeleteRd; 
	@FindBy(xpath="//input[@id='VehicleAction' and contains(@title,'Add')]") WebElement VehicleAddRd;
	
	@FindBy(xpath="//input[@id='btnUpdateFromPrevYear']") WebElement VehicleUpdateFromPreviousYearbtn;
	@FindBy(xpath="//input[@id='btnVehicleList']") WebElement VehicleVehicleListbtn;
	
	
	@FindBy(xpath="//table[@id='gvVehicleList']//tr[contains(@class,'odd') or contains(@class,'even')]") List<WebElement> VehicleList_rows;
	@FindBy(xpath="(//td//a[@id='lnkGridSelectgvVehicleList'])") List<WebElement>  HandimgsList;
	
	public void clickAmendVehicleRadioButton() {
		ElementUtil.clickElement(VehicleAmendRd);
	}
	public void clickDeleteVehicleRadioButton() {
		ElementUtil.clickElement(VehicleDeleteRd);
	}
	public void clickAddVehicleRadioButton() {
		ElementUtil.clickElement(VehicleAddRd);
	}
	public void clickUpdateFromPreviousYear() {
		ElementUtil.clickElement(VehicleUpdateFromPreviousYearbtn);
	}
	public void clickVehicleList() {
		ElementUtil.clickElement(VehicleVehicleListbtn);
	}
@SuppressWarnings("unlikely-arg-type")
public void validateAmendedVehiclesCount(String AmendedVehiclesCount) {
	assert equals(VehicleAmendedVehiclestxt.getAttribute("value").toString().equalsIgnoreCase(AmendedVehiclesCount)); 
}
@SuppressWarnings("unlikely-arg-type")
public void validateDeleteVehiclesCount(String AmendedVehiclesCount) {
	assert equals(VehicleDeleteVehiclestxt.getAttribute("value").toString().equalsIgnoreCase(AmendedVehiclesCount)); 
}


public void selectRow(String unitvalue) {
	for(int i=1;i<=VehicleList_rows.size();i++) {
		WebElement Unitvalueineachrow=driver.findElement(By.xpath("//table[@id='gvVehicleList']//tr[contains(@class,'odd') or contains(@class,'even')]["+i+"]//td[contains(@class,'white')]"));
		ElementUtil.highlightElement(driver, HandimgsList.get(i-1));
		ElementUtil.highlightElement(driver, Unitvalueineachrow);
		if(Unitvalueineachrow.getText().equals(unitvalue)){
		ElementUtil.clickElement(HandimgsList.get(i-1));
		break;
	}
	
	}
}

//Fetch values
public String FetchAmendVehiclelbl() {
	return ElementUtil.FetchTextBoxValuewithText(VehicleAmendedVehicleslbl);
}
public String FetchAmendVehicle() {
	return ElementUtil.FetchTextBoxValuewithattribute(VehicleAmendedVehiclestxt, "value");
}

public String FetchAddVehicleslbl() {
	return ElementUtil.FetchTextBoxValuewithText(VehicleAddedVehicleslbl);
}
public String FetchAddVehicles() {
	return ElementUtil.FetchTextBoxValuewithattribute(VehicleAddedVehiclestxt, "value");
}

public String FetchdeleteVehiclelbl() {
	return ElementUtil.FetchTextBoxValuewithText(VehicleDeleteVehicleslbl);
}
public String FetchdeleteVehicle() {
	return ElementUtil.FetchTextBoxValuewithattribute(VehicleDeleteVehiclestxt, "value");
}

public String FetchRenewVehiclelbl() {
	return ElementUtil.FetchTextBoxValuewithText(VehicleRenewVehicleslbl);
}
public String FetchRenewVehicle() {
	return ElementUtil.FetchTextBoxValuewithattribute(VehicleRenewVehiclestxt, "value");
}
public void vehiclevalidatemessage() {
	ElementUtil.highlightElement(driver, Vehicle_Validatemeesage);
}
public String VehicleValidateMessage1() {
	 
	 ElementUtil.highlightElement(driver, Vehicle_Verificationmessage);
	 return ElementUtil.FetchTextBoxValuewithText(Vehicle_Verificationmessage);
}


public String VehicleValidateMessage2() {
	 ElementUtil.waitUntilElementVisible(Vehicle_Verificationmessage2);
	 ElementUtil.highlightElement(driver, Vehicle_Verificationmessage2);
	 return ElementUtil.FetchTextBoxValuewithText(Vehicle_Verificationmessage2);
}
public String VehicleValidateMessage3() {
	 
	 ElementUtil.highlightElement(driver, Vehicle_Verificationmessage3);
	 return ElementUtil.FetchTextBoxValuewithText(Vehicle_Verificationmessage3);
}
public String VehicleValidateMessage4() {
	 
	 ElementUtil.highlightElement(driver, Vehicle_Verificationmessage4);
	 return ElementUtil.FetchTextBoxValuewithText(Vehicle_Verificationmessage4);
}
 
}
