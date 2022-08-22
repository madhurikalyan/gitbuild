package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.util.ElementUtil;
import com.qa.util.ExcelReader;

public class AccountTabPage {
	public WebDriver driver;
	ExcelReader reader = new ExcelReader();
	public AccountTabPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	//Account Tab
	@FindBy(xpath="//a[@id='AccountBtn']") WebElement AccountActMainTab;

	
	
	//Customer Details section
	
	@FindBy(xpath="(//div[contains(@class,'box-title')]/h4)[1]") WebElement Accountcustomerdetailssubhdr;
	
	@FindBy(xpath="//label[@for='MCECustomerID']") WebElement AccountMCECustomerIDlbl;
	@FindBy(xpath="//input[@id='MCECustomerID']") WebElement AccountMCECustomerIDtxt;
	
	@FindBy(xpath="//label[@for='RegistrantType']") WebElement AccountRegistrantTypelbl;
	@FindBy(xpath="//input[@id='RegistrantType']") WebElement AccountRegistrantTypetxt;
	
	@FindBy(xpath="//label[@for='CarrierType']") WebElement AccountCarrierTypelbl;
	@FindBy(xpath="//input[@id='CarrierType']") WebElement AccountCarrierTypetxt;
	
	@FindBy(xpath="//label[@for='IFTAAccountNo']") WebElement AccountIFTAAccountNolbl;
	@FindBy(xpath="//input[@id='IFTAAccountNo']") WebElement AccountIFTAAccountNotxt;
	
	@FindBy(xpath="//label[@for='ClientStatus']") WebElement AccountCustomerStatuslbl;
	@FindBy(xpath="//input[@id='ClientStatus']") WebElement AccountCustomerStatustxt;
	
	//Address Details Section
	@FindBy(xpath="(//div[contains(@class,'box-title')]/h4)[2]") WebElement AccountAddressDetailssubhdr;
	@FindBy(xpath="//li[@aria-controls='tabs-1']") WebElement Accounttab1;
	
	@FindBy(xpath="//label[@for='Addressess_0__AddrLine1']") WebElement AccountStreet0lbl;
	@FindBy(xpath="//input[@id='Addressess_0__AddrLine1']") WebElement AccountStreet0txt;
	
	@FindBy(xpath="//label[@for='Addressess_0__Zip']") WebElement AccountZip0lbl;
	@FindBy(xpath="//input[@id='Addressess_0__Zip']") WebElement AccountZip0txt;
	
	@FindBy(xpath="//label[@for='Addressess_0__Jur']") WebElement AccountJur0lbl;
	@FindBy(xpath="//select[@id='Addressess_0__Jur']") WebElement AccountJur0dd;
	
	@FindBy(xpath="//label[@for='Addressess_0__County']") WebElement AccountCounty0lbl;
	@FindBy(xpath="//input[@id='Addressess_0__County']") WebElement AccountCounty0txt;
	
	@FindBy(xpath="//label[@for='Addressess_0__Country']") WebElement AccountCountry0lbl;
	@FindBy(xpath="//input[@id='Addressess_0__Country']") WebElement AccountCountry0txt;
	
	
	@FindBy(xpath="//li[@aria-controls='tabs-2']") WebElement Accounttab2;
	@FindBy(xpath="//label[@for='Addressess_1__AddrLine1']") WebElement AccountStreet1lbl;
	@FindBy(xpath="//input[@id='Addressess_1__AddrLine1']") WebElement AccountStreet1txt;
	
	@FindBy(xpath="//label[@for='Addressess_1__Zip']") WebElement AccountZip1lbl;
	@FindBy(xpath="//input[@id='Addressess_1__Zip']") WebElement AccountZip1txt;
	
	@FindBy(xpath="//label[@for='Addressess_1__Jur']") WebElement AccountJur1lbl;
	@FindBy(xpath="//select[@id='Addressess_1__Jur']") WebElement AccountJur1dd;
	
	@FindBy(xpath="//label[@for='Addressess_1__County']") WebElement AccountCounty1lbl;
	@FindBy(xpath="//input[@id='Addressess_1__County']") WebElement AccountCounty1txt;
	
	@FindBy(xpath="//label[@for='Addressess_1__Country']") WebElement AccountCountry1lbl;
	@FindBy(xpath="//input[@id='Addressess_1__Country']") WebElement AccountCountry1txt;
	
	
	//Business Customer Details Section
	@FindBy(xpath="(//div[contains(@class,'box-title')]/h4)[3]") WebElement AccountBusinesscustomerdetailssubhdr;
	
	@FindBy(xpath="//label[@for='USDOTNo']") WebElement AccountUSDOTNolbl;
	@FindBy(xpath="//input[@id='USDOTNo']") WebElement AccountUSDOTNotxt;
	
	@FindBy(xpath="//label[@for='TIN']") WebElement AccountTPIDlbl;
	@FindBy(xpath="//input[@id='TIN']") WebElement AccountTPIDtxt;
	
	@FindBy(xpath="//label[@for='ConatactName']") WebElement AccountContactnamelbl;
	@FindBy(xpath="//input[@id='ConatactName']") WebElement AccountContactnametxt;
	
	@FindBy(xpath="//label[@for='EmailAddress']") WebElement AccountEmaillbl;
	@FindBy(xpath="//input[@id='EmailAddress']") WebElement AccountEmailtxt;
	
	@FindBy(xpath="//label[@for='PrimaryPhone']") WebElement AccountPrimaryPhonelbl;
	@FindBy(xpath="//input[@id='PrimaryPhone']") WebElement AccountPrimaryPhonetxt;
	
	@FindBy(xpath="//label[@for='AlternatePhone']") WebElement AccountAlternatePhonelbl;
	@FindBy(xpath="//input[@id='AlternatePhone']") WebElement AccountAlternatePhonetxt;
	
	@FindBy(xpath="//label[@for='FaxNo']") WebElement AccountFaxNolbl;
	@FindBy(xpath="//input[@id='FaxNo']") WebElement AccountFaxNotxt;
	
	//Account Details
	@FindBy(xpath="(//div[contains(@class,'box-title')]/h4)[4]") WebElement AccountAccountDetailssubhdr;
	@FindBy(xpath="//input[@id='EmailNotification']") WebElement AccountEmailnotification;
	@FindBy(xpath="//input[@id='FaxNotification']") WebElement AccountFaxnotification;
	
	
	
	
	
	/*
	@FindBy(id="Document_ProofOfResidency") WebElement AccountProofResidence;
	@FindBy(id="Document_chkDriversLicense") WebElement AccountDriverLicense;
	@FindBy(id="Document_chkCorporationDocs") WebElement AccountCorporationDocs;
	@FindBy(id="Document_chkUtilityBills") WebElement AccountUtilityBill;
	@FindBy(id="Document_chkIncomeTaxDocs") WebElement AccountIncometax;
	@FindBy(id="Document_chkTitle") WebElement AccountValidatetitlingreceipt;
	@FindBy(id="Document_chkTaxFilling") WebElement AccountRealestatetax;
	//@FindBy(id="EmailNotification") WebElement AccountEmailnotification;
	//@FindBy(id="FaxNotification") WebElement AccountFaxNotification;
	@FindBy(id="SelfIssuanceInventory") WebElement AccountSelfissuance;
	@FindBy(xpath="//div[@id='accordion']") WebElement AccountComment;
	
	@FindBy(id="btnProceed")  WebElement AccountProceed;
	@FindBy(id="btnRefresh") WebElement AccountRefersh;
	@FindBy(id="btnQuit") WebElement AccountQuit;*/

			
	public void validateAccountstabPresence() {
		ElementUtil.isPresentAndDisplayed(AccountActMainTab);
		ElementUtil.highlightElement(driver, AccountActMainTab);
	}
		
	public void checkEmailNotification() {
		ElementUtil.webCheckON(AccountEmailnotification);
	}

	public void checkFaxNotification() {
		ElementUtil.webCheckON(AccountFaxnotification);
	}





}

