package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.qa.util.ElementUtil;

public class AccountVerification {

	@FindBy(xpath="//input[@id='AccountNo']//parent::div/preceding-sibling::div/span") WebElement AccountNbrlbl;
	@FindBy(xpath="//input[@id='AccountNo']") WebElement AccountNbr;
	
	@FindBy(xpath="//input[@id='MCECustomerID']//parent::div/preceding-sibling::div/span") WebElement AccountMCECustomerIDlbl;
	@FindBy(xpath="//input[@id='MCECustomerID']") WebElement AccountMCECustomerIDtxt;
	
	@FindBy(xpath="//input[@id='RegistrantType']//parent::div/preceding-sibling::div/span") WebElement AccountRegistrantTypelbl;
	@FindBy(xpath="//input[@id='RegistrantType']") WebElement AccountRegistrantTypetxt;
	
	@FindBy(xpath="//input[@id='CarrierType']//parent::div/preceding-sibling::div/span") WebElement AccountCarrierTypelbl;
	@FindBy(xpath="//input[@id='CarrierType']") WebElement AccountCarrierTypetxt;
	
	@FindBy(xpath="//input[@id='LegalName']//parent::div/preceding-sibling::div/span") WebElement AccountLegalNamelbl;
	@FindBy(xpath="//input[@id='LegalName']") WebElement AccountlegalNametxt;
	
	@FindBy(xpath="//input[@id='IFTAAccountNo']//parent::div/preceding-sibling::div/span") WebElement AccountIFTAAccountNolbl;
	@FindBy(xpath="//input[@id='IFTAAccountNo']") WebElement AccountIFTAAccountNotxt;
	
	@FindBy(xpath="//input[@id='ClientStatus']//parent::div/preceding-sibling::div/span") WebElement AccountCustomerStatuslbl;
	@FindBy(xpath="//input[@id='ClientStatus']") WebElement AccountCustomerStatustxt;
	
	@FindBy(xpath="//input[@id='DBA']//parent::div/preceding-sibling::div/span") WebElement AccountDBAlbl;
	@FindBy(xpath="//input[@id='DBA']") WebElement AccountDBAtxt;
	
	
	
	@FindBy(xpath="//input[@id='Addressess_0__AddrLine1']//parent::div/preceding-sibling::div/span") WebElement AccountStreet0lbl;
	@FindBy(xpath="//input[@id='Addressess_0__AddrLine1']") WebElement AccountStreet0txt;
	
	@FindBy(xpath="//input[@id='Addressess_0__Zip']//parent::div/preceding-sibling::div/span") WebElement AccountZip0lbl;
	@FindBy(xpath="//input[@id='Addressess_0__Zip']") WebElement AccountZip0txt;
	
	@FindBy(xpath="//input[@id='Addressess_0__Jur']//parent::div/preceding-sibling::div/span") WebElement AccountJur0lbl;
	@FindBy(xpath="//input[@id='Addressess_0__Jur']") WebElement AccountJur0dd;
	
	@FindBy(xpath="//input[@id='Addressess_0__City']//parent::div/preceding-sibling::div/span") WebElement AccountCity0lbl;
	@FindBy(xpath="//input[@id='Addressess_0__City']") WebElement AccountCity0dd;
	
	@FindBy(xpath="//input[@id='Addressess_0__County']//parent::div/preceding-sibling::div/span") WebElement AccountCounty0lbl;
	@FindBy(xpath="//input[@id='Addressess_0__County']") WebElement AccountCounty0txt;
	
	@FindBy(xpath="//input[@id='Addressess_0__Country']//parent::div/preceding-sibling::div/span") WebElement AccountCountry0lbl;
	@FindBy(xpath="//input[@id='Addressess_0__Country']") WebElement AccountCountry0txt;
	
	@FindBy(xpath="//input[@id='Addressess_1__AddrLine1']//parent::div/preceding-sibling::div/span") WebElement AccountStreet1lbl;
	@FindBy(xpath="//input[@id='Addressess_1__AddrLine1']") WebElement AccountStreet1txt;
	
	@FindBy(xpath="//input[@id='Addressess_1__Zip']//parent::div/preceding-sibling::div/span") WebElement AccountZip1lbl;
	@FindBy(xpath="//input[@id='Addressess_1__Zip']") WebElement AccountZip1txt;
	
	@FindBy(xpath="//input[@id='Addressess_1__Jur']//parent::div/preceding-sibling::div/span") WebElement AccountJur1lbl;
	@FindBy(xpath="//input[@id='Addressess_1__Jur']") WebElement AccountJur1dd;
	
	@FindBy(xpath="//input[@id='Addressess_1__City']//parent::div/preceding-sibling::div/span") WebElement AccountCity1lbl;
	@FindBy(xpath="//input[@id='Addressess_1__City']") WebElement AccountCity1dd;
	
	@FindBy(xpath="//input[@id='Addressess_1__County']//parent::div/preceding-sibling::div/span") WebElement AccountCounty1lbl;
	@FindBy(xpath="//input[@id='Addressess_1__County']") WebElement AccountCounty1txt;
	
	@FindBy(xpath="//input[@id='Addressess_1__Country']//parent::div/preceding-sibling::div/span") WebElement AccountCountry1lbl;
	@FindBy(xpath="//input[@id='Addressess_1__Country']") WebElement AccountCountry1txt;
	
	@FindBy(xpath="//input[@id='USDOTNo']//parent::div/preceding-sibling::div/span") WebElement AccountUSDOTNolbl;
	@FindBy(xpath="//input[@id='USDOTNo']") WebElement AccountUSDOTNo;
	
	@FindBy(xpath="//input[@id='TIN']//parent::div/preceding-sibling::div/span") WebElement AccountTPIDlbl;
	@FindBy(xpath="//input[@id='TIN']") WebElement AccountTPID;
	
	@FindBy(xpath="//input[@id='ConatactName']//parent::div/preceding-sibling::div/span") WebElement AccountContactnamelbl;
	@FindBy(xpath="//input[@id='ConatactName']") WebElement AccountContactname;
	
	@FindBy(xpath="//input[@id='EmailAddress']//parent::div/preceding-sibling::div/span") WebElement AccountEmaillbl;
	@FindBy(xpath="//input[@id='EmailAddress']") WebElement AccountEmail;
	
	@FindBy(xpath="//input[@id='PrimaryPhone']//parent::div/preceding-sibling::div/span") WebElement AccountPrimaryPhonelbl;
	@FindBy(xpath="//input[@id='PrimaryPhone']") WebElement AccountPrimaryPhone;
	
	@FindBy(xpath="//input[@id='AlternatePhone']//parent::div/preceding-sibling::div/span") WebElement AccountAlternatePhonelbl;
	@FindBy(xpath="//input[@id='AlternatePhone']") WebElement AccountAlternatePhone;
	
	@FindBy(xpath="//input[@id='FaxNo']//parent::div/preceding-sibling::div/span") WebElement AccountFaxNolbl;
	@FindBy(xpath="//input[@id='FaxNo']") WebElement AccountFaxNo;
	
	
	@FindBy(xpath="//input[@id='EmailNotification']//parent::div/preceding-sibling::div/label") WebElement AccountEmailnotificationlbl;
	@FindBy(xpath="//input[@id='EmailNotification']") WebElement AccountEmailnotification;
	@FindBy(xpath="//input[@id='FaxNotification']//parent::div/preceding-sibling::div/span") WebElement AccountFaxnotificationlbl;
	@FindBy(xpath="//input[@id='FaxNotification']") WebElement AccountFaxnotification;
	
	
	
	
	//Verification screen Fetching Data
	public String fetchAccountnolbl() {
		return ElementUtil.FetchTextBoxValuewithText(AccountNbrlbl);
	}

	public String fetchAccountno() {
		return ElementUtil.FetchTextBoxValuewithattribute(AccountNbr,"value");
	}

	public String fetchMCECustomernolbl() {
		return ElementUtil.FetchTextBoxValuewithText(AccountMCECustomerIDlbl);
	}

	public String fetchMCECustomerno() {
		return ElementUtil.FetchTextBoxValuewithattribute(AccountMCECustomerIDtxt,"value");
	}

	public String fetchAccountCarrierTypelbl() {
		return ElementUtil.FetchTextBoxValuewithText(AccountCarrierTypelbl);
	}

	public String fetchAccountCarrierType() {
		return ElementUtil.FetchTextBoxValuewithattribute(AccountCarrierTypetxt,"value");
	}

	public String fetchIFTAAccountNbrlbl() {
		return ElementUtil.FetchTextBoxValuewithText(AccountIFTAAccountNolbl);
	}

	public String fetchIFTAAccountNbr() {
		return ElementUtil.FetchTextBoxValuewithattribute(AccountIFTAAccountNotxt,"value");
	}

	public String fetchAccountCustomerStatuslbl() {
		return ElementUtil.FetchTextBoxValuewithText(AccountCustomerStatuslbl);
	}

	public String fetchAccountCustomerStatus() {
		return ElementUtil.FetchTextBoxValuewithattribute(AccountCustomerStatustxt,"value");
	}


}
