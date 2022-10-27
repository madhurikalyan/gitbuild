package com.celtic.automation.cmcs.pages;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.celtic.automation.cmcs.util.ElementUtil;


public class Enquiry {
	public WebDriver driver;
	public Enquiry(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
//Fleet Enquiry
@FindBy(xpath="//table[@id='FltInquiryGrid']") WebElement FleetEnquiryGrid;
@FindBy(xpath="//td[contains(@class,'leftAlign')]") List<WebElement> FleetEnquiryRowValues;

//Supplement Enquiry
@FindBy(xpath="//input[@id='AccountNO']") WebElement SupplementEnquiryAccountNo;
@FindBy(xpath="//table[@id='supplementInquiryGrid']") WebElement SupplementEnquiryGrid;

//Vehicle Enquiry
@FindBy(xpath="//table[@id='VehInquiryGrid']") WebElement VehicleEnquiryGrid;
@FindBy(xpath="//th[contains(@aria-label,'VIN')]") WebElement VehicleEnquiry_VIN;
@FindBy(xpath="//th[contains(@aria-label,'Unit')]") WebElement VehicleEnquiry_UnitNo;

//Vehicle Supplement Enquiry
@FindBy(xpath="//table[@id='gvVinTransInquiryGrid']") WebElement VehicleSupplementEnquiryGrid;
//Fleet Enquiry

public void fleetenquiryvaluevalidation(String valuecheck) {
	if(ElementUtil.isPresentAndDisplayed(FleetEnquiryGrid)) {
		for(int i=0;i<FleetEnquiryRowValues.size();i++) {
			if(FleetEnquiryRowValues.get(i).getText().equalsIgnoreCase(valuecheck))
				assert true;
			break;
		}
	}
}

//Supplement Enquiry
public void enterSupplementEnquiryAccountNo(String AccountNoValue) throws IOException {
	ElementUtil.webEditTxtChange(SupplementEnquiryAccountNo,AccountNoValue);
}
public void SupplementEnquiryvaluevalidation(String valuecheck) {
	if(ElementUtil.isPresentAndDisplayed(SupplementEnquiryGrid)) {
		for(int i=0;i<FleetEnquiryRowValues.size();i++) {
			if(FleetEnquiryRowValues.get(i).getText().equalsIgnoreCase(valuecheck))
				assert true;
			break;
		}
	}
}
//Vehicle Enquiry

public void clickVehicleEnquiryUnitNo() {
	if(ElementUtil.isPresentAndDisplayed(VehicleEnquiryGrid)) {
		if(!(ElementUtil.FetchTextBoxValuewithattribute(VehicleEnquiry_UnitNo,"class").contains("asc"))) {
			ElementUtil.clickElement(VehicleEnquiry_UnitNo); 
		}
	}
}

public String fetchVehicleEnquiryVIN(String i,String YearValue) {
	String VIN_TableValue=null;
	WebElement ExpiryYear=driver.findElement(By.xpath("//table[@id='VehInquiryGrid']/tbody/tr["+i+"]/td[5]"));
	WebElement VIN=driver.findElement(By.xpath("//table[@id='VehInquiryGrid']/tbody/tr["+i+"]/td[6]"));
	if(ElementUtil.isPresentAndDisplayed(VehicleEnquiryGrid)) {
		if(ExpiryYear.getText().equalsIgnoreCase(YearValue)) {
			VIN_TableValue=ElementUtil.FetchTextBoxValuewithText(VIN);
		}
	}
	return VIN_TableValue;
}
//Vehicle Supplement Enquiry
public void clickVehicleSupplementUnitNo() {
	if(ElementUtil.isPresentAndDisplayed(VehicleSupplementEnquiryGrid)) {
		if(!(ElementUtil.FetchTextBoxValuewithattribute(VehicleEnquiry_UnitNo,"class").contains("asc"))) {
			ElementUtil.clickElement(VehicleEnquiry_UnitNo); 
		}
	}
}

public String FetchVehicleSupplementEnquiryVIN(String i,String YearValue) {
	String VIN_TableValue=null;
	WebElement ExpiryYear=driver.findElement(By.xpath("//tr["+i+"]//td[contains(@class,'Alignment')][4]"));
	WebElement VIN=driver.findElement(By.xpath("//tr["+i+"]//td[contains(@class,'Alignment')][8]"));
	if(ElementUtil.isPresentAndDisplayed(VehicleSupplementEnquiryGrid)) {
		if(ExpiryYear.getText().equalsIgnoreCase(YearValue)) {
			VIN_TableValue=ElementUtil.FetchTextBoxValuewithText(VIN);
		}
	}
	return VIN_TableValue;
}














}
