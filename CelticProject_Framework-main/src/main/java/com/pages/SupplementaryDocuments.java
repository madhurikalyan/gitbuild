package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.util.ElementUtil;

public class SupplementaryDocuments {
	
	public WebDriver driver;

	public SupplementaryDocuments(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
    @FindBy(xpath="//label[@for='AccountNo']") WebElement SupplementDocuments_AccountNolbl;
	@FindBy(xpath="//input[@id='AccountNo']") WebElement SupplementDocuments_AccountNo;
	@FindBy(xpath="//label[@for='LegalName']") WebElement SupplementDocuments_LegalNamelbl;
	@FindBy(xpath="//input[@id='LegalName']") WebElement SupplementDocuments_LegalName;
	@FindBy(xpath="//label[@for='DBA']") WebElement SupplementDocuments_DBAlbl;
	@FindBy(xpath="//input[@id='DBA']") WebElement SupplementDocuments_DBA;
	@FindBy(xpath="//label[@for='FleetNo']") WebElement SupplementDocuments_FleetNolbl;
	@FindBy(xpath="//input[@id='FleetNo']") WebElement SupplementDocuments_FleetNo;
	@FindBy(xpath="//label[@for='FltExpMonthYear']") WebElement SupplementDocuments_FltExpMonthYearlbl;
	@FindBy(xpath="//input[@id='FltExpMonthYear']") WebElement SupplementDocuments_FltExpMonthYear;
	@FindBy(xpath="//label[@for='SupplementNo']") WebElement SupplementDocuments_SupplementNolbl;
	@FindBy(xpath="//input[@id='SupplementNo']") WebElement SupplementDocuments_SupplementNo;
	@FindBy(xpath="//label[@for='FleetType']") WebElement SupplementDocuments_FleetTypelbl;
	@FindBy(xpath="//input[@id='FleetType']") WebElement SupplementDocuments_FleetType;
	@FindBy(xpath="//label[@for='SuppType']") WebElement SupplementDocuments_TransactionTypelbl;
	@FindBy(xpath="//input[@id='SuppType']") WebElement SupplementDocuments_TransactionType;
	@FindBy(xpath="//label[@for='USDot']") WebElement SupplementDocuments_USDotlbl;
	@FindBy(xpath="//input[@id='USDot']") WebElement SupplementDocuments_USDot;
	
	@FindBy(xpath="//label[@for='IRPRequirementsForm_DocStatInd']") WebElement SupplementDocuments_IRPRequirementlbl;
	@FindBy(xpath="//select[@id='IRPRequirementsForm_DocStatInd']") WebElement SupplementDocuments_IRPRequirement;
	@FindBy(xpath="//label[@for='StatementOfUnderstanding_DocStatInd']") WebElement SupplementDocuments_Statementofunderstandinglbl;;
	@FindBy(xpath="//select[@id='StatementOfUnderstanding_DocStatInd']") WebElement SupplementDocuments_Statementofunderstanding;
	@FindBy(xpath="//label[@for='InstallmentAgreement_DocStatInd']") WebElement SupplementDocuments_InstallmentAgreementlbl;
	@FindBy(xpath="//select[@id='InstallmentAgreement_DocStatInd']") WebElement SupplementDocuments_InstallmentAgreement;
	@FindBy(xpath="//label[@for='PowerOfAttony_DocStatInd']") WebElement SupplementDocuments_Powerofattonylbl;
	@FindBy(xpath="//select[@id='PowerOfAttony_DocStatInd']") WebElement SupplementDocuments_Powerofattony;
	

	
	//Fetch Values
	public String FetchAccountNolbl() {
		return ElementUtil.FetchTextBoxValuewithText(SupplementDocuments_AccountNolbl);
	}

	public String FetchAccountNo() {
		return ElementUtil.FetchDropdownSelectedValue(SupplementDocuments_AccountNo);
	}
	public String FetchLegalNamelbl() {
		return ElementUtil.FetchTextBoxValuewithText(SupplementDocuments_LegalNamelbl);
	}

	public String FetchLegalName() {
		return ElementUtil.FetchDropdownSelectedValue(SupplementDocuments_LegalName);
	}

	public String FetchDBAlbl() {
		return ElementUtil.FetchTextBoxValuewithText(SupplementDocuments_DBAlbl);
	}

	public String FetchDBA() {
		return ElementUtil.FetchTextBoxValuewithattribute(SupplementDocuments_DBA,"value");
	}
	public String FetchFleetNolbl() {
		return ElementUtil.FetchTextBoxValuewithText(SupplementDocuments_FleetNolbl);
	}

	public String FetchFleetNo() {
		return ElementUtil.FetchTextBoxValuewithattribute(SupplementDocuments_FleetNo,"value");
	}
	public String FetchExpMonthYearlbl() {
		return ElementUtil.FetchTextBoxValuewithText(SupplementDocuments_FltExpMonthYearlbl);
	}

	public String FetchExpMonthYear() {
		return ElementUtil.FetchTextBoxValuewithattribute(SupplementDocuments_FltExpMonthYearlbl,"value");
	}
	public String FetchSupplementNolbl() {
		return ElementUtil.FetchTextBoxValuewithText(SupplementDocuments_SupplementNolbl);
	}

	public String FetchSupplementNo() {
		return ElementUtil.FetchTextBoxValuewithattribute(SupplementDocuments_SupplementNolbl,"value");
	}

	public String FetchFleetTypelbl() {
		return ElementUtil.FetchTextBoxValuewithText(SupplementDocuments_FleetTypelbl);
	}

	public String FetchFleetType() {
		return ElementUtil.FetchTextBoxValuewithattribute(SupplementDocuments_FleetType,"value");
	}

	public String FetchTransactionTypelbl() {
		return ElementUtil.FetchTextBoxValuewithText(SupplementDocuments_TransactionTypelbl);
	}

	public String FetchTransactionType() {
		return ElementUtil.FetchTextBoxValuewithattribute(SupplementDocuments_TransactionTypelbl,"value");
	}

public String FetchUSDOTlbl() {
	return ElementUtil.FetchTextBoxValuewithText(SupplementDocuments_USDotlbl);
}

public String FetchUSDOT() {
	return ElementUtil.FetchTextBoxValuewithattribute(SupplementDocuments_USDot,"value");
}

public String SupplementDocuments_StatementOfUnderstandinglbl() {
	return ElementUtil.FetchTextBoxValuewithText(SupplementDocuments_Statementofunderstandinglbl);
}
public String SupplementDocuments_StatementOfUnderstanding() {
	return ElementUtil.FetchDropdownSelectedValue(SupplementDocuments_Statementofunderstanding);
}

public String SupplementDocuments_InstallmentAgreementlbl() {
	return ElementUtil.FetchTextBoxValuewithText(SupplementDocuments_InstallmentAgreementlbl);
}
public String SupplementDocuments_InstallmentAgreement() {
	return ElementUtil.FetchDropdownSelectedValue(SupplementDocuments_InstallmentAgreement);
}
public String SupplementDocuments_PowerOfAttorneylbl() {
	return ElementUtil.FetchTextBoxValuewithText(SupplementDocuments_Powerofattonylbl);
}
public String SupplementDocuments_PowerOfAttorney() {
	return ElementUtil.FetchDropdownSelectedValue(SupplementDocuments_Powerofattony);
}

	
	public void EnterAccountNo(String AccountNo) {
		ElementUtil.webEditTxtChange(SupplementDocuments_AccountNo, AccountNo);
	}
	public void SelectIRPRequirements(String IRP) {
		ElementUtil.selectFromDropdownByVisibleText(SupplementDocuments_IRPRequirement, IRP);
	}
	
	public void Selectstatmentdoccs(String Statementunderstanding) {
		ElementUtil.selectFromDropdownByVisibleText(SupplementDocuments_Statementofunderstanding, Statementunderstanding);
		
	}
	public void SelectInstallmentdocs(String Installment) {
		ElementUtil.selectFromDropdownByVisibleText(SupplementDocuments_InstallmentAgreement, Installment);
	}
	public void SelectPowerofattony(String PowerofAttony) {
	ElementUtil.selectFromDropdownByVisibleText(SupplementDocuments_Powerofattony, PowerofAttony);
}
}