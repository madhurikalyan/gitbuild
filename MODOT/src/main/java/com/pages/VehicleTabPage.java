package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.util.ExcelReader;

public class VehicleTabPage {
	public WebDriver driver;
	ExcelReader reader = new ExcelReader();
	public VehicleTabPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	// Elements for SiteMappage

	
	@FindBy(xpath="(//div[contains(@class,'box-title')]/h4)[1]") WebElement VehicleRenewalDetailsSubHdr;
	@FindBy(xpath="//label[@for='NoOfAmendVeh']") WebElement VehicleAmendedVehicleslbl;
	
	
	
	
	
	
	
	
	
	
	
	
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



	/*Select s = new Select(VehicleTitlejur);
	s.selectByValue("MO");

	Select s = new Select(VehicleSaftchange)
			s.selectByValue("Y")*/


	 
}
