package com.pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.util.ElementUtil;

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

//Vehicle Supplement Enquiry
public void VehicleSupplementEnquiryvaluevalidation(String valuecheck) {
	if(ElementUtil.isPresentAndDisplayed(VehicleSupplementEnquiryGrid)) {
		for(int i=0;i<FleetEnquiryRowValues.size();i++) {
			if(FleetEnquiryRowValues.get(i).getText().equalsIgnoreCase(valuecheck))
				assert true;
			break;
		}
	}
}
}
