package com.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.qa.util.ElementUtil;

public class AccountTabPage {
	public WebDriver driver;
	public AccountTabPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	//Account Tab
	@FindBy(xpath="//a[@id='AccountBtn']") WebElement AccountActMainTab;

	@FindBy(css = "#contentMsg > div > ul") WebElement Account_VerificationMessage;
	//Customer Details section
	
	@FindBy(xpath="(//div[contains(@class,'box-title')]/h4)[1]") WebElement Accountcustomerdetailssubhdr;
	@FindBy(xpath="//span[text()='Account No.']") WebElement AccountaccountNbrlbl;
	@FindBy(xpath="//input[@id='AccountNo']") WebElement AccountaccountNbrtxt;
	
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
	
	@FindBy(xpath="//label[@for='Addressess_0__City']") WebElement AccountCity0lbl;
	@FindBy(xpath="//input[@id='Addressess_0__City']") WebElement AccountCity0txt;
	
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
	
	@FindBy(xpath="//label[@for='Addressess_1__City']") WebElement AccountCity1lbl;
	@FindBy(xpath="//input[@id='Addressess_1__City']") WebElement AccountCity1txt;
	
	@FindBy(xpath="//label[@for='Addressess_1__County']") WebElement AccountCounty1lbl;
	@FindBy(xpath="//input[@id='Addressess_1__County']") WebElement AccountCounty1txt;
	
	@FindBy(xpath="//label[@for='Addressess_1__Country']") WebElement AccountCountry1lbl;
	@FindBy(xpath="//input[@id='Addressess_1__Country']") WebElement AccountCountry1txt;
	
	@FindBy(xpath="//label[@for='Addressess_1__AttnTo']") WebElement AccountAttentionTolbl;
	@FindBy(xpath="//input[@id='Addressess_1__AttnTo']") WebElement AccountAttentionTotxt;
	
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
	@FindBy(xpath="//label[@for='EmailNotification']") WebElement AccountEmailnotificationlbl; //text
	@FindBy(xpath="//input[@id='EmailNotification']") WebElement AccountEmailnotification; //checked
	@FindBy(xpath="//label[@for='FaxNotification']") WebElement AccountFaxnotificationlbl;
	@FindBy(xpath="//input[@id='FaxNotification']") WebElement AccountFaxnotification; //checked

			
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

//Fetch Details
public String fetchMCECustomernolbl() {
	return ElementUtil.FetchTextBoxValuewithText(AccountMCECustomerIDlbl);
}

public String fetchMCECustomerno() {
	return ElementUtil.FetchTextBoxValuewithattribute(AccountMCECustomerIDtxt,"value");
}

public String fetchRegistrationTypelbl() {
	return ElementUtil.FetchTextBoxValuewithText(AccountRegistrantTypelbl);
}

public String fetchRegistrationType() {
	return ElementUtil.FetchTextBoxValuewithattribute(AccountRegistrantTypetxt,"value");
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
	return ElementUtil.FetchTextBoxValuewithattributedisabled(AccountIFTAAccountNotxt,"value");
}

public String fetchAccountCustomerStatuslbl() {
	return ElementUtil.FetchTextBoxValuewithText(AccountCustomerStatuslbl);
}

public String fetchAccountCustomerStatus() {
	return ElementUtil.FetchTextBoxValuewithattribute(AccountCustomerStatustxt,"value");
}

public String fetchAccountStreet0lbl() {
	return ElementUtil.FetchTextBoxValuewithText(AccountStreet0lbl);
}

public String fetchAccountStreet0() {
	return ElementUtil.FetchTextBoxValuewithattribute(AccountStreet0txt,"value");
}

public String fetchAccountZip0lbl() {
	return ElementUtil.FetchTextBoxValuewithText(AccountZip0lbl);
}

public String fetchAccountZip0() {
	return ElementUtil.FetchTextBoxValuewithattribute(AccountZip0txt,"value");
}

public String fetchAccountJur0lbl() {
	return ElementUtil.FetchTextBoxValuewithText(AccountJur0lbl);
}

public String fetchAccountJur0() {
	return ElementUtil.FetchDropdownSelectedValue(AccountJur0dd);
}
public String fetchAccountCity0lbl() {
	return ElementUtil.FetchTextBoxValuewithText(AccountCity0lbl);
}

public String fetchAccountCity0() {
	return ElementUtil.FetchTextBoxValuewithattribute(AccountCity0txt,"value");
}

public String fetchAccountCounty0lbl() {
	return ElementUtil.FetchTextBoxValuewithText(AccountCounty0lbl);
}

public String fetchAccountCounty0() {
	return ElementUtil.FetchTextBoxValuewithattribute(AccountCounty0txt,"value");
}

public String fetchAccountCountry0lbl() {
	return ElementUtil.FetchTextBoxValuewithText(AccountCountry0lbl);
}

public String fetchAccountCountry0() {
	return ElementUtil.FetchTextBoxValuewithattribute(AccountCountry0txt,"value");
}

public void clickMailingAddress() {
	ElementUtil.clickElement(Accounttab2);
}

public String fetchAccountStreet1lbl() {
	return ElementUtil.FetchTextBoxValuewithText(AccountStreet1lbl);
}

public String fetchAccountStreet1() {
	return ElementUtil.FetchTextBoxValuewithattribute(AccountStreet1txt,"value");
}

public String fetchAccountZip1lbl() {
	return ElementUtil.FetchTextBoxValuewithText(AccountZip1lbl);
}

public String fetchAccountZip1() {
	return ElementUtil.FetchTextBoxValuewithattribute(AccountZip1txt,"value");
}

public String fetchAccountJur1lbl() {
	return ElementUtil.FetchTextBoxValuewithText(AccountJur1lbl);
}

public String fetchAccountJur1() {
	return ElementUtil.FetchDropdownSelectedValue(AccountJur1dd);
}
public String fetchAccountCity1lbl() {
	return ElementUtil.FetchTextBoxValuewithText(AccountCity1lbl);
}

public String fetchAccountCity1() {
	return ElementUtil.FetchTextBoxValuewithattribute(AccountCity1txt,"value");
}

public String fetchAccountCounty1lbl() {
	return ElementUtil.FetchTextBoxValuewithText(AccountCounty1lbl);
}

public String fetchAccountCounty1() {
	return ElementUtil.FetchTextBoxValuewithattribute(AccountCounty1txt,"value");
}

public String fetchAccountCountry1lbl() {
	return ElementUtil.FetchTextBoxValuewithText(AccountCountry1lbl);
}

public String fetchAccountCountry1() {
	return ElementUtil.FetchTextBoxValuewithattribute(AccountCountry1txt,"value");
}

public String fetchAccountAttentionTolbl() {
	return ElementUtil.FetchTextBoxValuewithText(AccountAttentionTolbl);
}

public String fetchAccountAttentionTo() {
	return ElementUtil.FetchTextBoxValuewithattribute(AccountAttentionTotxt,"value");
}

public String fetchAccountUSDOTNolbl() {
	return ElementUtil.FetchTextBoxValuewithText(AccountUSDOTNolbl);
}

public String fetchAccountUSDOTNo() {
	return ElementUtil.FetchTextBoxValuewithattribute(AccountUSDOTNotxt,"value");
}

public String fetchAccountTPIDlbl() {
	return ElementUtil.FetchTextBoxValuewithText(AccountTPIDlbl);
}
public String fetchAccountTPID() {
	return ElementUtil.FetchTextBoxValuewithattribute(AccountTPIDtxt,"value");
}

public String fetchAccountContactnamelbl() {
	return ElementUtil.FetchTextBoxValuewithText(AccountContactnamelbl);
}

public String fetchAccountContactname() {
	return ElementUtil.FetchTextBoxValuewithattribute(AccountContactnametxt,"value");
}

public String fetchAccountEmaillbl() {
	return ElementUtil.FetchTextBoxValuewithText(AccountEmaillbl);
}

public String fetchAccountEmail() {
	return ElementUtil.FetchTextBoxValuewithattribute(AccountEmailtxt,"value");
}

public String fetchAccountPrimaryPhonelbl() {
	return ElementUtil.FetchTextBoxValuewithText(AccountPrimaryPhonelbl);
}

public String fetchAccountPrimaryPhone() {
	return ElementUtil.FetchTextBoxValuewithattribute(AccountPrimaryPhonetxt,"value");
}


public String fetchAccountAlternatePhonelbl() {
	return ElementUtil.FetchTextBoxValuewithText(AccountAlternatePhonelbl);
}

public String fetchAccountAlternatePhone() {
	return ElementUtil.FetchTextBoxValuewithattribute(AccountAlternatePhonetxt,"value");
}
public String fetchAccountFaxNolbl() {
	return ElementUtil.FetchTextBoxValuewithText(AccountFaxNolbl);
}

public String fetchAccountFaxNo() {
	return ElementUtil.FetchTextBoxValuewithattribute(AccountFaxNotxt,"value");
}
public String fetchAccountEmailnotificationlbl() {
	return ElementUtil.FetchTextBoxValuewithText(AccountEmailnotificationlbl);
}

public String fetchAccountEmailnotification() {
	return ElementUtil.FetchTextBoxValuewithattribute(AccountEmailnotification,"checked");
}
public String fetchAccountFaxnotificationlbl() {
	return ElementUtil.FetchTextBoxValuewithText(AccountFaxnotificationlbl);
}

public String fetchAccountFaxnotification() {
	boolean boolstatus=false;
	if(ElementUtil.FetchTextBoxValuewithattribute(AccountFaxnotification,"checked")==null){
		boolstatus=false;
	}
	else {
		boolstatus=true;
	}
	return Boolean.toString(boolstatus);
}


//Validate messages

public String ValidateMessage() {
	ElementUtil.highlightElement(driver, Account_VerificationMessage);
	return ElementUtil.FetchTextBoxValuewithText(Account_VerificationMessage);
}

























































}

