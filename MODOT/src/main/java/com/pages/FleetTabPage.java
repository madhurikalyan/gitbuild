package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.util.ElementUtil;
import com.qa.util.ExcelReader;

public class FleetTabPage {
	public WebDriver driver;
	ExcelReader reader = new ExcelReader();
	public FleetTabPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	//Fleet Tab
		@FindBy(xpath="//a[@id='FleetBtn']") WebElement FleetfltMainTab;

		
		//Fleet Summary
		@FindBy(xpath="(//div[contains(@class,'box-title')]/h4)[1]") WebElement FleetfltSummarysubhdr;
		
		@FindBy(xpath="//label[@for='CustomerType']") WebElement FleetRegistrationtypelbl;
		@FindBy(xpath="//select[@id='CustomerType']") WebElement FleetRegistrationtypedd;
		
		@FindBy(xpath="//label[@for='FltStatus']") WebElement FleetfltStatuslbl;
		@FindBy(xpath="//select[@id='FltStatus']") WebElement FleetfltStatusdd;
		
		@FindBy(xpath="//label[@for='CarrierType']") WebElement FleetCarriertypelbl;
		@FindBy(xpath="//input[@id='CarrierType']") WebElement FleetCarriertypetxt;
		
		@FindBy(xpath="//label[@for='DBA']") WebElement FleetDBANamelbl;
		@FindBy(xpath="//input[@id='DBA']") WebElement FleetDBANametxt;
		
		
		//Address Details Section
		@FindBy(xpath="(//div[contains(@class,'box-title')]/h4)[2]") WebElement FleetAddressDetailssubhdr;
		@FindBy(xpath="//input[@id='btnAddrOverride']") WebElement FleetAddressOverridesubhdr;
		
		@FindBy(xpath="//li[@aria-controls='tabs-1']") WebElement Fleettab1;  //Business Address
		
		@FindBy(xpath="//label[@for='Addressess_0__AddrLine1']") WebElement FleetStreet0lbl;
		@FindBy(xpath="//input[@id='Addressess_0__AddrLine1']") WebElement FleetStreet0txt;
		
		@FindBy(xpath="//label[@for='Addressess_0__Zip']") WebElement FleetZip0lbl;
		@FindBy(xpath="//input[@id='Addressess_0__Zip']") WebElement FleetZip0txt;
		
		@FindBy(xpath="//label[@for='Addressess_0__Jur']") WebElement FleetJur0lbl;
		@FindBy(xpath="//select[@id='Addressess_0__Jur']") WebElement FleetJur0dd;
		

		@FindBy(xpath="//label[@for='Addressess_0__City']") WebElement FleetCity0lbl;
		@FindBy(xpath="//input[@id='Addressess_0__City']") WebElement FleetCity0txt;
		
		@FindBy(xpath="//label[@for='Addressess_0__County']") WebElement FleetCounty0lbl;
		@FindBy(xpath="//input[@id='Addressess_0__County']") WebElement FleetCounty0txt;
		
		@FindBy(xpath="//label[@for='Addressess_0__Country']") WebElement FleetCountry0lbl;
		@FindBy(xpath="//input[@id='Addressess_0__Country']") WebElement FleetCountry0txt;
		
		@FindBy(xpath="//label[@for='Addressess_0__IsNonDeliverableAddr']") WebElement FleetNonDeliverable0lbl;
		@FindBy(xpath="//input[@id='Addressess_0__IsNonDeliverableAddr']") WebElement FleetNonDeliverable0chk;
		
		
		@FindBy(xpath="//li[@aria-controls='tabs-2']") WebElement Fleettab2;  //Mailing Address
		@FindBy(xpath="//label[@for='Addressess_1__AddrLine1']") WebElement FleetStreet1lbl;
		@FindBy(xpath="//input[@id='Addressess_1__AddrLine1']") WebElement FleetStreet1txt;
		
		@FindBy(xpath="//label[@for='Addressess_1__Zip']") WebElement FleetZip1lbl;
		@FindBy(xpath="//input[@id='Addressess_1__Zip']") WebElement FleetZip1txt;
		
		@FindBy(xpath="//label[@for='Addressess_1__Jur']") WebElement FleetJur1lbl;
		@FindBy(xpath="//select[@id='Addressess_1__Jur']") WebElement FleetJur1dd;
		
		@FindBy(xpath="//label[@for='Addressess_1__City']") WebElement FleetCity1lbl;
		@FindBy(xpath="//input[@id='Addressess_1__City']") WebElement FleetCity1txt;
		
		@FindBy(xpath="//label[@for='Addressess_1__County']") WebElement FleetCounty1lbl;
		@FindBy(xpath="//input[@id='Addressess_1__County']") WebElement FleetCounty1txt;
		
		@FindBy(xpath="//label[@for='Addressess_1__Country']") WebElement FleetCountry1lbl;
		@FindBy(xpath="//input[@id='Addressess_1__Country']") WebElement FleetCountry1txt;
		
		@FindBy(xpath="//label[@for='Addressess_1__IsNonDeliverableAddr']") WebElement FleetNonDeliverable1lbl;
		@FindBy(xpath="//input[@id='Addressess_1__IsNonDeliverableAddr']") WebElement FleetNonDeliverable1chk;
		
		@FindBy(xpath="//input[@id='Addressess_1__AttnTo']") WebElement FleetAttentionTO1txt;
		@FindBy(xpath="//label[@for='Addressess_1__AttnTo']") WebElement FleetAttentionTOlbl;
		
		
		
		@FindBy(xpath="//li[@aria-controls='tabs-3']") WebElement Fleettab3;  //Service provider
		@FindBy(xpath="//label[@for='reportingServices_ServiceProviderID']") WebElement FleetServiceProviderlbl;
		@FindBy(xpath="//select[@id='reportingServices_ServiceProviderID']") WebElement FleetServiceProviderdd;
		
		@FindBy(xpath="//label[@for='reportingServices_LegalName']") WebElement FleetLegalNamelbl;
		@FindBy(xpath="//input[@id='reportingServices_LegalName']") WebElement FleetLegalNametxt;
		
		@FindBy(xpath="//label[@for='reportingServices_DBAName']") WebElement FleetService_DBANamelbl;
		@FindBy(xpath="//input[@id='reportingServices_DBAName']") WebElement FleetService_DBANametxt;
		
		@FindBy(xpath="//label[@for='reportingServices_checkedPwrattoony']") WebElement FleetService_PowerOfAttroneylbl;
		@FindBy(xpath="//input[@id='reportingServices_checkedPwrattoony']") WebElement FleetService_PowerOfAttroneychk;
		
		@FindBy(xpath="//label[@for='reportingServices_PowerOfAttEffDate']") WebElement FleetService_PowerOfAttroneyEffDatelbl;
		@FindBy(xpath="//input[@id='reportingServices_PowerOfAttEffDate']") WebElement FleetService_PowerOfAttroneyEffDatetxt;
		
		@FindBy(xpath="//label[@for='reportingServices_PowerOfAttExpDate']") WebElement FleetService_PowerOfAttroneyExpDatelbl;
		@FindBy(xpath="//input[@id='reportingServices_PowerOfAttExpDate']") WebElement FleetService_PowerOfAttroneyExpDatetxt;
		
		
		@FindBy(xpath="//label[@for='reportingServices_EmailID']") WebElement FleetService_EmailIDlbl;
		@FindBy(xpath="//input[@id='reportingServices_EmailID']") WebElement FleetService_EmailIDtxt;
		
		@FindBy(xpath="//label[@for='reportingServices_PhoneNo']") WebElement FleetService_PhoneNolbl;
		@FindBy(xpath="//input[@id='reportingServices_PhoneNo']") WebElement FleetService_PhoneNotxt;
		
		@FindBy(xpath="//label[@for='reportingServices_Fax']") WebElement FleetService_FaxNolbl;
		@FindBy(xpath="//input[@id='reportingServices_Fax']") WebElement FleetService_FaxNotxt;
		
		@FindBy(xpath="//label[@for='reportingServices_Street1']") WebElement FleetService_Streetlbl;
		@FindBy(xpath="//input[@id='reportingServices_Street1']") WebElement FleetService_Streettxt;
		
		
		@FindBy(xpath="//label[@for='reportingServices_City']") WebElement FleetService_Citylbl;
		@FindBy(xpath="//input[@id='reportingServices_City']") WebElement FleetService_Citytxt;
		
		@FindBy(xpath="//label[@for='reportingServices_Jur']") WebElement FleetService_Jurlbl;
		@FindBy(xpath="//input[@id='reportingServices_Jur']") WebElement FleetService_Jurtxt;
		
		@FindBy(xpath="//label[@for='reportingServices_ZipCode']") WebElement FleetService_ZipCodelbl;
		@FindBy(xpath="//input[@id='reportingServices_ZipCode']") WebElement FleetService_ZipCodetxt;
		
		@FindBy(xpath="//label[@for='reportingServices_Country']") WebElement FleetService_Countrylbl;
		@FindBy(xpath="//input[@id='reportingServices_Country']") WebElement FleetService_Countrytxt;
		
		
		@FindBy(xpath="//li[@aria-controls='tabs-4']") WebElement Fleettab4;  //One-Time Mailing Address
		
		@FindBy(xpath="//label[@for='Addressess_2__AddrLine1']") WebElement FleetServiceMailing_Streetlbl;
		@FindBy(xpath="//input[@id='Addressess_2__AddrLine1']") WebElement FleetServiceMailing_Streettxt;
		
		@FindBy(xpath="//label[@for='Addressess_2__Zip']") WebElement FleetServiceMailing_ZipCodelbl;
		@FindBy(xpath="//input[@id='Addressess_2__Zip']") WebElement FleetServiceMailing_ZipCodetxt;
		
		@FindBy(xpath="//label[@for='Addressess_2__Jur']") WebElement FleetServiceMailing_Jurlbl;
		@FindBy(xpath="//select[@id='Addressess_2__Jur']") WebElement FleetServiceMailing_Jurtxt;
		
		@FindBy(xpath="//label[@for='Addressess_2__City']") WebElement FleetServiceMailing_Citylbl;
		@FindBy(xpath="//input[@id='Addressess_2__City']") WebElement FleetServiceMailing_Citytxt;
		
		@FindBy(xpath="//label[@for='Addressess_2__County']") WebElement FleetServiceMailing_Countylbl;
		@FindBy(xpath="//input[@id='Addressess_2__County']") WebElement FleetServiceMailing_Countytxt;
		
		@FindBy(xpath="//label[@for='Addressess_2__Country']") WebElement FleetServiceMailing_Countrylbl;
		@FindBy(xpath="//input[@id='Addressess_2__Country']") WebElement FleetServiceMailing_Countrytxt;
		
		@FindBy(xpath="//input[@id='Addressess_2__AttnTo']") WebElement FleetServiceMailing_AttentionTOtxt;
		@FindBy(xpath="//label[@for='Addressess_2__AttnTo']") WebElement FleetServiceMailing_AttentionTOlbl;
		
		//Fleet Details
		@FindBy(xpath="(//div[contains(@class,'box-title')]/h4)[3]") WebElement FleetfltDetailssubhdr;
		
		@FindBy(xpath="//label[@for='ContactName']") WebElement FleetDetails_ContactNamelbl;
		@FindBy(xpath="//input[@id='ContactName']") WebElement FleetDetails_ContactNametxt;
		
		@FindBy(xpath="//label[@for='Email']") WebElement FleetDetails_EmailIDlbl;
		@FindBy(xpath="//input[@id='Email']") WebElement FleetDetails_EmailIDtxt;
		
		@FindBy(xpath="//label[@for='PhoneNumber']") WebElement FleetDetails_PrimaryCellNbrlbl;
		@FindBy(xpath="//input[@id='PhoneNumber']") WebElement FleetDetails_PrimaryCellNbrtxt;
		
		@FindBy(xpath="//label[@for='FlCellNbr']") WebElement FleetDetails_AlternateCellNbrlbl;
		@FindBy(xpath="//input[@id='FlCellNbr']") WebElement FleetDetails_AlternateCellNbrtxt;
		
		@FindBy(xpath="//label[@for='FaxNo']") WebElement FleetDetails_FaxNolbl;
		@FindBy(xpath="//input[@id='FaxNo']") WebElement FleetDetails_FaxNotxt;
		
		@FindBy(xpath="//label[@for='TinNbr']") WebElement FleetDetails_TPIDlbl;
		@FindBy(xpath="//input[@id='TinNbr']") WebElement FleetDetails_TPIDtxt;
		
		@FindBy(xpath="//label[@for='UsdotNbr']") WebElement FleetDetails_UsdotNbrlbl;
		@FindBy(xpath="//input[@id='UsdotNbr']") WebElement FleetDetails_UsdotNbrtxt;
		
		@FindBy(xpath="//label[@for='ChangeVehUsdotTin']") WebElement FleetDetails_ChangeVehUsdotTinlbl;
		@FindBy(xpath="//input[@id='ChangeVehUsdotTin']") WebElement FleetDetails_ChangeVehUsdotTinchk;
		
		@FindBy(xpath="//label[@for='FltType']") WebElement FleetDetails_FltTypelbl;
		@FindBy(xpath="//select[@id='FltType']") WebElement FleetDetails_FltTypedd;
		
		@FindBy(xpath="//label[@for='CommodityClass']") WebElement FleetDetails_CommodityClasslbl;
		@FindBy(xpath="//select[@id='CommodityClass']") WebElement FleetDetails_CommodityClassdd;
		
		@FindBy(xpath="//label[@for='FltEffDate']") WebElement FleetDetails_FltEffDatelbl;
		@FindBy(xpath="//input[@id='FltEffDate']") WebElement FleetDetails_FltEffDatedtPicker;
		
		@FindBy(xpath="//label[@for='FltExpDate']") WebElement FleetDetails_FltExpDatelbl;
		@FindBy(xpath="//input[@id='FltExpDate']") WebElement FleetDetails_FltExpDatedtPicker;
		
		@FindBy(xpath="//label[@for='changeAddrOnUsdot']") WebElement FleetDetails_changeAddrOnUsdotlbl;
		@FindBy(xpath="//input[@id='changeAddrOnUsdot']") WebElement FleetDetails_changeAddrOnUsdotchk;
		
		@FindBy(xpath="//label[@for='FirstOperationDate']") WebElement FleetDetails_FirstOperatedDatelbl;
		@FindBy(xpath="//input[@id='FirstOperationDate']") WebElement FleetDetails_FirstOperatedDatedtPicker;
		
		@FindBy(xpath="//label[@for='WyIntraStF']") WebElement FleetDetails_WyomingIndicatorlbl;
		@FindBy(xpath="//input[@id='WyIntraStF']") WebElement FleetDetails_WyomingIndicatorchk;
		
		@FindBy(xpath="//label[@for='IftaMileageChk']") WebElement FleetDetails_IFTADistancelbl;
		@FindBy(xpath="//input[@id='IftaMileageChk']") WebElement FleetDetails_IFTADistancechk;
		
		@FindBy(xpath="//label[@for='MobileIND']") WebElement FleetDetails_MobileNotificationlbl;
		@FindBy(xpath="//input[@id='MobileIND']") WebElement FleetDetails_MobileNotificationchk;
		
		
		//Document Collection
		@FindBy(xpath="(//div[contains(@class,'box-title')]/h4)[5]") WebElement FleetDocumentationCollectionsubhdr;
		
		@FindBy(xpath="//label[@for='IRPRequirementsForm']") WebElement FleetDocCollection_IRPRequirementsFormlbl;
		@FindBy(xpath="//select[@id='IRPRequirementsForm']") WebElement FleetDocCollection_IRPRequirementsFormdd;
		
		@FindBy(xpath="//label[@for='StatementOfUnderstanding']") WebElement FleetDocCollection_StatementOfUnderstandinglbl;
		@FindBy(xpath="//select[@id='StatementOfUnderstanding']") WebElement FleetDocCollection_StatementOfUnderstandingdd;
		
		@FindBy(xpath="//label[@for='InstallmentAgreement']") WebElement FleetDocCollection_InstallmentAgreementlbl;
		@FindBy(xpath="//select[@id='InstallmentAgreement']") WebElement FleetDocCollection_InstallmentAgreementdd;
		
		@FindBy(xpath="//label[@for='PowerOfAttorney']") WebElement FleetDocCollection_PowerOfAttorneylbl;
		@FindBy(xpath="//select[@id='PowerOfAttorney']") WebElement FleetDocCollection_PowerOfAttorneydd;
		
		//Vehicle Document 
		@FindBy(xpath="(//div[contains(@class,'box-title')]/h4)[6]") WebElement FleetVehicleDocumentsubhdr;
		
		@FindBy(xpath="//label[@for='HVUTForm2290']") WebElement FleetVehDocument_HVUTFormlbl;
		@FindBy(xpath="//select[@id='HVUTForm2290']") WebElement FleetVehDocument_HVUTFormdd;
		
		@FindBy(xpath="//label[@for='PropertyTaxVehDocument']") WebElement FleetVehDocument_PropertyTaxlbl;
		@FindBy(xpath="//select[@id='PropertyTaxVehDocument']") WebElement FleetVehDocument_PropertyTaxdd;
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//-------------------------------------
		
	@FindBy(id="FltType") WebElement FleetFleettype;
	@FindBy(id="CommodityClass") WebElement FleetCommodity;
	@FindBy(id="FltEffDate") WebElement FleetEffectivedate;
	@FindBy(id="FltExpDate") WebElement FleetExpdate;
	@FindBy(id="FirstOperationDate") WebElement FleetFirstoperationdate;
	@FindBy(id="IRPRequirementsForm") WebElement FleetIRPreq;
	@FindBy(id="StatementOfUnderstanding") WebElement FleetStatement;
	@FindBy(id="InstallmentAgreement") WebElement FleetInstallment;
	@FindBy(id="PowerOfAttorney") WebElement FleetPowerofattorny;

	
	@FindBy(id="btnProceed") public WebElement AccountProceed;
	@FindBy(id="btnRefresh") WebElement AccountRefersh;
	@FindBy(id="btnQuit") WebElement AccountQuit;

	/*	Select s = new Select(FleetFleettype);
	s.selectByValue("FHE");
	Select s = new Select(FleetCommodity);
	s.selectByValue("B");

	Select s = new Select(FleetIRPreq);
	s.selectByValue("C");
	Select s = new Select(FleetStatement);
	s.selectByValue("C");
	Select s = new Select(FleetInstallment);
	s.selectByValue("C");
	Select s = new Select(FleetInstallment);
	s.selectByValue("C");
*/
	
	
	
	
	public void navigateToPowerOfAttroney() throws Exception {
		ElementUtil.scrollToViewAndClickElement(Fleettab3);  //click on service Provider under Address details
		//ElementUtil.clickElement(Fleettab3);
		Thread.sleep(2000);
		
	}

	public void clickPowerOfAttroney() {
		ElementUtil.isPresentAndDisplayed(FleetService_PowerOfAttroneylbl);
		if(ElementUtil.isPresentAndDisplayed(FleetService_PowerOfAttroneychk)) {
			//ElementUtil.clickElement(FleetService_PowerOfAttroneychk);
			ElementUtil.webCheckON(FleetService_PowerOfAttroneychk);
		}
	}
	public void enterEmailID(String EmailIDValue) {
		ElementUtil.webEditTxtChange(FleetDetails_EmailIDtxt, EmailIDValue);
	}
	public void selectIRPRequirementForm(String selectValue) {
		ElementUtil.selectFromDropdownByVisibleText(FleetIRPreq,selectValue);  //C - COLLECTED
	}
	public void selectStatementofUnderstanding(String selectValue) {
		ElementUtil.selectFromDropdownByVisibleText(FleetStatement,selectValue); //C - COLLECTED
	}
	public void selectInstallmentAgreement(String selectValue) {
		ElementUtil.selectFromDropdownByVisibleText(FleetInstallment,selectValue); //C - COLLECTED
	}
	public void selectPowerOfAttroney(String selectValue) {
		ElementUtil.selectFromDropdownByVisibleText(FleetPowerofattorny,selectValue); //C - COLLECTED
	}

	public void selectHVUTForm(String selectValue) {
		ElementUtil.selectFromDropdownByVisibleText(FleetVehDocument_HVUTFormdd,selectValue); //C - COLLECTED
	}
	public void selectPropertyTax(String selectValue) {
		ElementUtil.selectFromDropdownByVisibleText(FleetVehDocument_PropertyTaxdd,selectValue); //C - COLLECTED
	}









}
