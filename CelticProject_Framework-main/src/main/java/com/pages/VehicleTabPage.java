package com.pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.qa.util.ElementUtil;

public class VehicleTabPage {
	public WebDriver driver;
	public VehicleTabPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	// Elements for SiteMappage

	
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
	for(int i=0;i<VehicleList_rows.size();i++) {
		List<WebElement>Unitvalueineachrow=driver.findElements(By.xpath("//table[@id='gvVehicleList']//tr[contains(@class,'odd') or contains(@class,'even')]["+i+"]//td[contains(@class,'white')]"));
	System.out.print("check row value"+Unitvalueineachrow.get(i).getText());
		if(Unitvalueineachrow.get(i).getText().equalsIgnoreCase(unitvalue)) {
		ElementUtil.clickElement(HandimgsList.get(i));
		break;
	}
	
	}
}
	/*

	
	@FindBy(xpath="//a[text()='Add Vehicle']") WebElement SitemapAddvechile;
	@FindBy(id="AccountNo") WebElement VehicleAccountNo;
	@FindBy(id="FleetNbr") WebElement VehicleFleetNo;
	@FindBy(id="FltExpYear") WebElement VehicleExpyr;
	@FindBy(id="btnProceed") WebElement VehicleProceed;

	//Element for VehicleDetails

	@FindBy(id="CopyVIN") WebElement VehicledetailsVinno;
	@FindBy(id="btnSearch") WebElement VehicleSearch;
	@FindBy(id="VehDtlUnitNo") WebElement VehicleUnitNo;
	@FindBy(id="VehDtlWeightGroupNo") WebElement VehicleWeightGroupNo;
	@FindBy(id="PurchasePrice") WebElement VehiclePurchaseprice;
	@FindBy(id="PurchaseDate")WebElement VehiclePurchasedate;
	@FindBy(id="VehDtlTitleJurisdiction") WebElement VehicleTitlejur;
	
	@FindBy(id="VehDtlTitleNo") WebElement VehicleTitleNo;
	@FindBy(id="OwnerDtlName") WebElement VehicleOwnerName;
	@FindBy(id="OwnerPhoneNo") WebElement VehicleOwnerPhNo;
	@FindBy(id="SaftyChangeDuringYear") WebElement VehicleSaftchange;
	
	@FindBy(xpath="//a[@role='button']") WebElement VehicleComment;
	@FindBy(id="editComment_CommentTxtcommentsVM1") WebElement Vehiclecomtext;
	@FindBy(id="addUpdateCommentBtncommentsVM1") WebElement Vehiclecomupdate;
	//@FindBy(id="btnProceed") WebElement VehicleProceed;

	//Validate VehicleDetails

	@FindBy(id="btnProceed") WebElement ValidateVehicleProceed;
	@FindBy(id="btnDone") WebElement ValidateVehicleDone;

	//WebProcessing

	@FindBy(id="ISFAXDOC") WebElement WebprocessingChecklist;
	@FindBy(id="lnkGridSelectgvDocTrack_View") WebElement WebprocessingVehicledocs;
	@FindBy(id="UploadedFile") WebElement Webprocessingbrowsefile;
	@FindBy(xpath="//button[@id='btnUpload']") WebElement Webprocessingupload;
	@FindBy(id="btnDone") WebElement WebprocessingDonefile;
	@FindBy(xpath="//a[@role='button']") WebElement WebprocessingComment;
	@FindBy(id="editComment_CommentTxtcommentsVM1") WebElement Webprocessingcomtext;
	@FindBy(id="addUpdateCommentBtncommentsVM1") WebElement Webprocessingcomupdate;
	@FindBy(id="btnSubmit") WebElement WebprocessingSubmit;
*/


	/*Select s = new Select(VehicleTitlejur);
	s.selectByValue("MO");

	Select s = new Select(VehicleSaftchange)
			s.selectByValue("Y")*/

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

	 
}
