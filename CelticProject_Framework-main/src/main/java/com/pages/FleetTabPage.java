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
	
	
	
	
	public void navigateToServiceProvider() throws Exception {
		//ElementUtil.scrollToViewAndClickElement(Fleettab3);  //click on service Provider under Address details
		ElementUtil.waitUntilElementClickable(Fleettab3);
		ElementUtil.clickElement(Fleettab3);
		Thread.sleep(2000);
		
	}

	public void clickPowerOfAttroney() {
		if(ElementUtil.isPresentAndDisplayed(FleetService_PowerOfAttroneychk)) {
			ElementUtil.webCheckON(FleetService_PowerOfAttroneychk);
		}
	}
	public void enterEmailID(String EmailIDValue) {
		Boolean valueexists=ElementUtil.validateTextbox(FleetDetails_EmailIDtxt);
		if(valueexists==true) {
		ElementUtil.webEditTxtChange(FleetDetails_EmailIDtxt, EmailIDValue);  }
	}
	public void selectIRPRequirementForm(String selectValue) {
		ElementUtil.selectFromDropdownByVisibleText(FleetDocCollection_IRPRequirementsFormdd,selectValue);  //C - COLLECTED
	}
	public void selectStatementofUnderstanding(String selectValue) {
		ElementUtil.selectFromDropdownByVisibleText(FleetDocCollection_StatementOfUnderstandingdd,selectValue); //C - COLLECTED
	}
	public void selectInstallmentAgreement(String selectValue) {
		ElementUtil.selectFromDropdownByVisibleText(FleetDocCollection_InstallmentAgreementdd,selectValue); //C - COLLECTED
	}
	public void selectPowerOfAttroney(String selectValue) {
		ElementUtil.selectFromDropdownByVisibleText(FleetDocCollection_PowerOfAttorneydd,selectValue); //C - COLLECTED
	}

	public void selectHVUTForm(String selectValue) {
		ElementUtil.selectFromDropdownByVisibleText(FleetVehDocument_HVUTFormdd,selectValue); //C - COLLECTED
	}
	public void selectPropertyTax(String selectValue) {
		ElementUtil.selectFromDropdownByVisibleText(FleetVehDocument_PropertyTaxdd,selectValue); //C - COLLECTED
	}

	public void selectEffectiveDate(String EffDate) {
		Boolean valueexists=ElementUtil.validateTextbox(FleetDetails_FltEffDatedtPicker);
		if(valueexists==true) {
			ElementUtil.clickElement(FleetDetails_FltEffDatedtPicker);
			ElementUtil.webEditTxt(FleetDetails_FltEffDatedtPicker,EffDate); 
			}
	}
	public void selectExpirationDate(String ExpDate) {
		Boolean valueexists=ElementUtil.validateTextbox(FleetDetails_FltExpDatedtPicker);
		if(valueexists==true) {
			ElementUtil.clickElement(FleetDetails_FltExpDatedtPicker);
			ElementUtil.webEditTxt(FleetDetails_FltExpDatedtPicker,ExpDate); 
			}
	}
	public void selectFirstOperatedDate(String FirstOperatedDate) {
		Boolean valueexists=ElementUtil.validateTextbox(FleetDetails_FirstOperatedDatedtPicker);
		if(valueexists==true) {
			ElementUtil.clickElement(FleetDetails_FirstOperatedDatedtPicker);
			ElementUtil.webEditTxt(FleetDetails_FirstOperatedDatedtPicker,FirstOperatedDate); 
			}
	}
public void selectFleetType(String FleettypeValue) {
	Boolean selectedornot=ElementUtil.validateDropdownSelected(FleetDetails_FltTypedd);
	if(selectedornot==true) {
	ElementUtil.selectFromDropdownByVisibleText(FleetDetails_FltTypedd, FleettypeValue);  }
	//FHE - FOR HIRE EXEMPT (FH),FOR - FOR HIRE (FH),FHL - FOR HIRE LEASE (FH),FHR - FOR HIRE RENTAL CARRIER (FH),PVR - PRIVATE RENTAL (PC),PVT - PRIVATE CARRIER (PC)
}


public void selectCommodityClass(String CommodityClassValue) {
	Boolean selectedornot=ElementUtil.validateDropdownSelected(FleetDetails_CommodityClassdd);
	if(selectedornot==true) {
	ElementUtil.selectFromDropdownByVisibleText(FleetDetails_CommodityClassdd, CommodityClassValue);  }
	//A - ALL,B - BUS,E - EXEMPT,H - HOUSEHOLD GOODS (HG),L - LOGS
}

public void enterContactName(String contactnamevalue) {
	//System.out.println("contact name:"+FleetDetails_ContactNametxt.getAttribute("value"));
	Boolean valueexists=ElementUtil.validateTextbox(FleetDetails_ContactNametxt);
	//System.out.println("check boolean status:"+valueexists);
	if(valueexists== true) {
	ElementUtil.webEditTxtChange(FleetDetails_ContactNametxt, contactnamevalue);
	}
}
public void enterprimaryPhone(String PrimaryPhonevalue) {
	Boolean valueexists=ElementUtil.validateTextbox(FleetDetails_PrimaryCellNbrtxt);
	if(valueexists == true) {
	ElementUtil.webEditTxtChange(FleetDetails_PrimaryCellNbrtxt, PrimaryPhonevalue);
	}
}

public void clickMailingAddress() throws InterruptedException {
	ElementUtil.clickElement(Fleettab2);
	Thread.sleep(1000);
}

public void clickOnTimeMailingAddress() throws InterruptedException {
	ElementUtil.clickElement(Fleettab4);
	Thread.sleep(1000);
}















//---------------------------------------------
public String fetchRegistrationtypelbl() {
	return ElementUtil.FetchTextBoxValuewithText(FleetRegistrationtypelbl);
}

public String fetchRegistrationtype() {
	return ElementUtil.FetchDropdownSelectedValue(FleetRegistrationtypedd);
}
public String fetchfltstatuslbl() {
	return ElementUtil.FetchTextBoxValuewithText(FleetfltStatuslbl);
}

public String fetchfltstatus() {
	return ElementUtil.FetchDropdownSelectedValue(FleetfltStatusdd);
}

public String fetchcarriertypelbl() {
	return ElementUtil.FetchTextBoxValuewithText(FleetCarriertypelbl);
}

public String fetchcarriertype() {
	return ElementUtil.FetchTextBoxValuewithattribute(FleetCarriertypetxt,"value");
}

public String fetchDBANamelbl() {
	return ElementUtil.FetchTextBoxValuewithText(FleetDBANamelbl);
}

public String fetchDBAName() {
	return ElementUtil.FetchTextBoxValuewithattribute(FleetDBANametxt,"value");
}

public String FleetStreet0lbl() {
	return ElementUtil.FetchTextBoxValuewithText(FleetStreet0lbl);
}

public String FleetStreet0() {
	return ElementUtil.FetchTextBoxValuewithattribute(FleetStreet0txt,"value");
}

public String FleetZip0lbl() {
	return ElementUtil.FetchTextBoxValuewithText(FleetZip0lbl);
}

public String FleetZip0() {
	return ElementUtil.FetchTextBoxValuewithattribute(FleetZip0txt,"value");
}
public String FleetJur0lbl() {
	return ElementUtil.FetchTextBoxValuewithText(FleetJur0lbl);
}

public String FleetJur0() {
	return ElementUtil.FetchTextBoxValuewithattribute(FleetJur0dd,"value");
}
public String FleetCity0lbl() {
	return ElementUtil.FetchTextBoxValuewithText(FleetCity0lbl);
}

public String FleetCity0() {
	return ElementUtil.FetchTextBoxValuewithattribute(FleetCity0txt,"value");
}
public String FleetCounty0lbl() {
	return ElementUtil.FetchTextBoxValuewithText(FleetCounty0lbl);
}

public String FleetCounty0() {
	return ElementUtil.FetchTextBoxValuewithattribute(FleetCounty0txt,"value");
}
public String FleetCountry0lbl() {
	return ElementUtil.FetchTextBoxValuewithText(FleetCountry0lbl);
}

public String FleetCountry0() {
	return ElementUtil.FetchTextBoxValuewithattribute(FleetCountry0txt,"value");
}
public String FleetNonDeliverable0lbl() {
	return ElementUtil.FetchTextBoxValuewithText(FleetNonDeliverable0lbl);
}

public String FleetNonDeliverable0() {
	return ElementUtil.FetchTextBoxValuewithattribute(FleetNonDeliverable0chk,"checked");
}

public String FleetStreet1lbl() {
	return ElementUtil.FetchTextBoxValuewithText(FleetStreet1lbl);
}

public String FleetStreet1() {
	return ElementUtil.FetchTextBoxValuewithattribute(FleetStreet1txt,"value");
}

public String FleetZip1lbl() {
	return ElementUtil.FetchTextBoxValuewithText(FleetZip1lbl);
}

public String FleetZip1() {
	return ElementUtil.FetchTextBoxValuewithattribute(FleetZip1txt,"value");
}
public String FleetJur1lbl() {
	return ElementUtil.FetchTextBoxValuewithText(FleetJur1lbl);
}

public String FleetJur1() {
	return ElementUtil.FetchTextBoxValuewithattribute(FleetJur1dd,"value");
}
public String FleetCity1lbl() {
	return ElementUtil.FetchTextBoxValuewithText(FleetCity1lbl);
}

public String FleetCity1() {
	return ElementUtil.FetchTextBoxValuewithattribute(FleetCity1txt,"value");
}
public String FleetCounty1lbl() {
	return ElementUtil.FetchTextBoxValuewithText(FleetCounty1lbl);
}

public String FleetCounty1() {
	return ElementUtil.FetchTextBoxValuewithattribute(FleetCounty1txt,"value");
}
public String FleetCountry1lbl() {
	return ElementUtil.FetchTextBoxValuewithText(FleetCountry1lbl);
}

public String FleetCountry1() {
	return ElementUtil.FetchTextBoxValuewithattribute(FleetCountry1txt,"value");
}
public String FleetNonDeliverable1lbl() {
	return ElementUtil.FetchTextBoxValuewithText(FleetNonDeliverable1lbl);
}

public String FleetNonDeliverable1() {
	return ElementUtil.FetchTextBoxValuewithattribute(FleetNonDeliverable1chk,"checked");
}
public String FleetAttentionTOlbl() {
	return ElementUtil.FetchTextBoxValuewithText(FleetAttentionTOlbl);
}

public String FleetAttentionTO() {
	return ElementUtil.FetchTextBoxValuewithattribute(FleetAttentionTO1txt,"value");
}


public String FleetServiceProviderlbl() {
	return ElementUtil.FetchTextBoxValuewithText(FleetServiceProviderlbl);
}

public String FleetServiceProvider() {
	return ElementUtil.FetchTextBoxValuewithText(FleetServiceProviderdd);
}
public String FleetServiceLegalNamelbl() {
	return ElementUtil.FetchTextBoxValuewithText(FleetLegalNamelbl);
}

public String FleetServiceLegalName() {
	return ElementUtil.FetchTextBoxValuewithattribute(FleetLegalNametxt,"value");
}
public String FleetService_DBANamelbl() {
	return ElementUtil.FetchTextBoxValuewithText(FleetService_DBANamelbl);
}

public String FleetService_DBAName() {
	return ElementUtil.FetchTextBoxValuewithattribute(FleetService_DBANametxt,"value");
}
public String FleetService_PowerOfAttroneylbl() {
	return ElementUtil.FetchTextBoxValuewithText(FleetService_PowerOfAttroneylbl);
}

public String FleetService_PowerOfAttroney() {
	return ElementUtil.FetchTextBoxValuewithattribute(FleetService_PowerOfAttroneychk,"value");
}
public String FleetService_PowerOfAttroneyEffDatelbl() {
	return ElementUtil.FetchTextBoxValuewithText(FleetService_PowerOfAttroneyEffDatelbl);
}


public String FleetService_PowerOfAttroneyEffDate() {
	return ElementUtil.FetchTextBoxValuewithattribute(FleetService_PowerOfAttroneyEffDatetxt,"value");
}
public String FleetService_PowerOfAttroneyExpDatelbl() {
	return ElementUtil.FetchTextBoxValuewithText(FleetService_PowerOfAttroneyExpDatelbl);
}

public String FleetService_PowerOfAttroneyExpDate() {
	return ElementUtil.FetchTextBoxValuewithattribute(FleetService_PowerOfAttroneyExpDatetxt,"value");
}

public String FleetService_EmailIDlbl() {
	return ElementUtil.FetchTextBoxValuewithText(FleetService_EmailIDlbl);
}

public String FleetService_EmailID() {
	return ElementUtil.FetchTextBoxValuewithattribute(FleetService_EmailIDtxt,"value");
}
public String FleetService_PhoneNolbl() {
	return ElementUtil.FetchTextBoxValuewithText(FleetService_PhoneNolbl);
}

public String FleetService_PhoneNo() {
	return ElementUtil.FetchTextBoxValuewithattribute(FleetService_PhoneNotxt,"value");
}

public String FleetService_FaxNolbl() {
	return ElementUtil.FetchTextBoxValuewithText(FleetService_FaxNolbl);
}

public String FleetService_FaxNo() {
	return ElementUtil.FetchTextBoxValuewithattribute(FleetService_FaxNotxt,"value");
}
public String FleetService_Streetlbl() {
	return ElementUtil.FetchTextBoxValuewithText(FleetService_Streetlbl);
}

public String FleetService_Street() {
	return ElementUtil.FetchTextBoxValuewithattribute(FleetService_Streettxt,"value");
}
public String FleetService_Citylbl() {
	return ElementUtil.FetchTextBoxValuewithText(FleetService_Citylbl);
}

public String FleetService_City() {
	return ElementUtil.FetchTextBoxValuewithattribute(FleetService_Citytxt,"value");
}
public String FleetService_Jurlbl() {
	return ElementUtil.FetchTextBoxValuewithText(FleetService_Jurlbl);
}

public String FleetService_Jur() {
	return ElementUtil.FetchTextBoxValuewithattribute(FleetService_Jurtxt,"value");
}
public String FleetService_ZipCodelbl() {
	return ElementUtil.FetchTextBoxValuewithText(FleetService_ZipCodelbl);
}

public String FleetService_ZipCode() {
	return ElementUtil.FetchTextBoxValuewithattribute(FleetService_ZipCodetxt,"value");
}

public String FleetService_Countrylbl() {
	return ElementUtil.FetchTextBoxValuewithText(FleetService_Countrylbl);
}

public String FleetService_Country() {
	return ElementUtil.FetchTextBoxValuewithattribute(FleetService_Countrytxt,"value");
}


public String FleetServiceMailing_Streetlbl() {
	return ElementUtil.FetchTextBoxValuewithText(FleetServiceMailing_Streetlbl);
}

public String FleetServiceMailing_Street() {
	return ElementUtil.FetchTextBoxValuewithattribute(FleetServiceMailing_Streettxt,"value");
}

public String FleetServiceMailing_ZipCodelbl() {
	return ElementUtil.FetchTextBoxValuewithText(FleetServiceMailing_ZipCodelbl);
}

public String FleetServiceMailing_ZipCode() {
	return ElementUtil.FetchTextBoxValuewithattribute(FleetServiceMailing_ZipCodetxt,"value");
}
public String FleetServiceMailing_Jurlbl() {
	return ElementUtil.FetchTextBoxValuewithText(FleetServiceMailing_Jurlbl);
}

public String FleetServiceMailing_Jur() {
	return ElementUtil.FetchTextBoxValuewithattribute(FleetServiceMailing_Jurtxt,"value");
}
public String FleetServiceMailing_Citylbl() {
	return ElementUtil.FetchTextBoxValuewithText(FleetServiceMailing_Citylbl);
}

public String FleetServiceMailing_City() {
	return ElementUtil.FetchTextBoxValuewithattribute(FleetServiceMailing_Citytxt,"value");
}
public String FleetServiceMailing_Countylbl() {
	return ElementUtil.FetchTextBoxValuewithText(FleetServiceMailing_Countylbl);
}
public String FleetServiceMailing_County() {
	return ElementUtil.FetchTextBoxValuewithattribute(FleetServiceMailing_Countytxt,"value");
}
public String FleetServiceMailing_Countrylbl() {
	return ElementUtil.FetchTextBoxValuewithText(FleetServiceMailing_Countrylbl);
}

public String FleetServiceMailing_Country() {
	return ElementUtil.FetchTextBoxValuewithattribute(FleetServiceMailing_Countrytxt,"value");
}
public String FleetServiceMailing_AttentionTOlbl() {
	return ElementUtil.FetchTextBoxValuewithText(FleetServiceMailing_AttentionTOlbl);
}

public String FleetServiceMailing_AttentionTO() {
	return ElementUtil.FetchTextBoxValuewithattribute(FleetServiceMailing_AttentionTOtxt,"value");
}

public String FleetDetails_ContactNamelbl() {
	return ElementUtil.FetchTextBoxValuewithText(FleetDetails_ContactNamelbl);
}

public String FleetDetails_ContactName() {
	return ElementUtil.FetchTextBoxValuewithattribute(FleetDetails_ContactNametxt,"value");
}
public String FleetDetails_EmailIDlbl() {
	return ElementUtil.FetchTextBoxValuewithText(FleetDetails_EmailIDlbl);
}
public String FleetDetails_EmailID() {
	return ElementUtil.FetchTextBoxValuewithattribute(FleetDetails_EmailIDtxt,"value");
}
public String FleetDetails_PrimaryCellNbrlbl() {
	return ElementUtil.FetchTextBoxValuewithText(FleetDetails_PrimaryCellNbrlbl);
}

public String FleetDetails_PrimaryCellNbr() {
	return ElementUtil.FetchTextBoxValuewithattribute(FleetDetails_PrimaryCellNbrtxt,"value");
}
public String FleetDetails_AlternateCellNbrlbl() {
	return ElementUtil.FetchTextBoxValuewithText(FleetDetails_AlternateCellNbrlbl);
}

public String FleetDetails_AlternateCellNbr() {
	return ElementUtil.FetchTextBoxValuewithattribute(FleetDetails_AlternateCellNbrtxt,"value");
}
public String FleetDetails_FaxNolbl() {
	return ElementUtil.FetchTextBoxValuewithText(FleetDetails_FaxNolbl);
}
public String FleetDetails_FaxNo() {
	return ElementUtil.FetchTextBoxValuewithattribute(FleetDetails_FaxNotxt,"value");
}
public String FleetDetails_TPIDlbl() {
	return ElementUtil.FetchTextBoxValuewithText(FleetDetails_TPIDlbl);
}

public String FleetDetails_TPID() {
	return ElementUtil.FetchTextBoxValuewithattribute(FleetDetails_TPIDtxt,"value");
}
public String FleetDetails_UsdotNbrlbl() {
	return ElementUtil.FetchTextBoxValuewithText(FleetDetails_UsdotNbrlbl);
}
public String FleetDetails_UsdotNbr() {
	return ElementUtil.FetchTextBoxValuewithattribute(FleetDetails_UsdotNbrtxt,"value");
}
public String FleetDetails_ChangeVehUsdotTinlbl() {
	return ElementUtil.FetchTextBoxValuewithText(FleetDetails_ChangeVehUsdotTinlbl);
}

public String FleetDetails_ChangeVehUsdotTin() {
	return ElementUtil.FetchTextBoxValuewithattribute(FleetDetails_ChangeVehUsdotTinchk,"checked");
}

public String FleetDetails_FltTypelbl() {
	return ElementUtil.FetchTextBoxValuewithText(FleetDetails_FltTypelbl);
}

public String FleetDetails_FltType() {
	return ElementUtil.FetchTextBoxValuewithattribute(FleetDetails_FltTypedd,"value");
}
public String FleetDetails_CommodityClasslbl() {
	return ElementUtil.FetchTextBoxValuewithText(FleetDetails_CommodityClasslbl);
}
public String FleetDetails_CommodityClass() {
	return ElementUtil.FetchTextBoxValuewithattribute(FleetDetails_CommodityClassdd,"value");
}
public String FleetDetails_FltEffDatelbl() {
	return ElementUtil.FetchTextBoxValuewithText(FleetDetails_FltEffDatelbl);
}

public String FleetDetails_FltEffDatedtPicker() {
	return ElementUtil.FetchTextBoxValuewithattribute(FleetDetails_FltEffDatedtPicker,"value");
}
public String FleetDetails_FltExpDatelbl() {
	return ElementUtil.FetchTextBoxValuewithText(FleetDetails_FltExpDatelbl);
}
public String FleetDetails_FltExpDate() {
	return ElementUtil.FetchTextBoxValuewithattribute(FleetDetails_FltExpDatedtPicker,"value");
}

public String FleetDetails_changeAddrOnUsdotlbl() {
	return ElementUtil.FetchTextBoxValuewithText(FleetDetails_changeAddrOnUsdotlbl);
}

public String FleetDetails_changeAddrOnUsdot() {
	return ElementUtil.FetchTextBoxValuewithattribute(FleetDetails_changeAddrOnUsdotchk,"checked");
}
public String FleetDetails_FirstOperatedDatelbl() {
	return ElementUtil.FetchTextBoxValuewithText(FleetDetails_FirstOperatedDatelbl);
}

public String FleetDetails_FirstOperatedDate() {
	return ElementUtil.FetchTextBoxValuewithattribute(FleetDetails_FirstOperatedDatedtPicker,"value");
}
public String FleetDetails_WyomingIndicatorlbl() {
	return ElementUtil.FetchTextBoxValuewithText(FleetDetails_WyomingIndicatorlbl);
}
public String FleetDetails_WyomingIndicator() {
	return ElementUtil.FetchTextBoxValuewithattribute(FleetDetails_WyomingIndicatorchk,"checked");
}
public String FleetDetails_IFTADistancelbl() {
	return ElementUtil.FetchTextBoxValuewithText(FleetDetails_IFTADistancelbl);
}

public String FleetDetails_IFTADistance() {
	return ElementUtil.FetchTextBoxValuewithattribute(FleetDetails_IFTADistancechk,"checked");
}
public String FleetDetails_MobileNotificationlbl() {
	return ElementUtil.FetchTextBoxValuewithText(FleetDetails_MobileNotificationlbl);
}
public String FleetDetails_MobileNotification() {
	return ElementUtil.FetchTextBoxValuewithattribute(FleetDetails_MobileNotificationchk,"checked");
}

public String FleetDetails_IRPRequirementslbl() {
	return ElementUtil.FetchTextBoxValuewithText(FleetDocCollection_IRPRequirementsFormlbl);
}

public String FleetDetails_IRPRequirements() {
	return ElementUtil.FetchDropdownSelectedValue(FleetDocCollection_IRPRequirementsFormdd);
}

public String FleetDetails_StatementOfUnderstandinglbl() {
	return ElementUtil.FetchTextBoxValuewithText(FleetDocCollection_StatementOfUnderstandinglbl);
}
public String FleetDetails_StatementOfUnderstanding() {
	return ElementUtil.FetchDropdownSelectedValue(FleetDocCollection_StatementOfUnderstandingdd);
}

public String FleetDetails_InstallmentAgreementlbl() {
	return ElementUtil.FetchTextBoxValuewithText(FleetDocCollection_InstallmentAgreementlbl);
}
public String FleetDetails_InstallmentAgreement() {
	return ElementUtil.FetchDropdownSelectedValue(FleetDocCollection_InstallmentAgreementdd);
}
public String FleetDetails_PowerOfAttorneylbl() {
	return ElementUtil.FetchTextBoxValuewithText(FleetDocCollection_PowerOfAttorneylbl);
}
public String FleetDetails_PowerOfAttorney() {
	return ElementUtil.FetchDropdownSelectedValue(FleetDocCollection_PowerOfAttorneydd);
}





}
