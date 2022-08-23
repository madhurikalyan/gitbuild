package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.util.ElementUtil;

public class BillingTab {
	public WebDriver driver;
	public BillingTab(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="(//div[contains(@class,'box-title')]/h4)[1]") WebElement Billing_SupplementDetailsSubhdr;
	@FindBy(xpath="//label[@for='RegMonth']") WebElement Billing_RegisterMonthlbl;
	@FindBy(xpath="//input[@id='RegMonth']") WebElement Billing_RegisterMonthtxt;

	@FindBy(xpath="//label[@for='NoOfPowerVehicle']") WebElement Billing_NoOfVehiclesinSupplbl;
	@FindBy(xpath="//input[@id='NoOfPowerVehicle']") WebElement Billing_NoOfVehiclesinSupptxt;

	@FindBy(xpath="//label[@for='SupplementStatus']") WebElement Billing_SupplementStatuslbl;
	@FindBy(xpath="//input[@id='SupplementStatus']") WebElement Billing_SupplementStatustxt;

	@FindBy(xpath="//label[@for='EnterpriseEscrow']") WebElement Billing_EnterpriseSystemCreditlbl;
	@FindBy(xpath="//input[@id='EnterpriseEscrow']") WebElement Billing_EnterpriseSystemCredittxt;

	@FindBy(xpath="//label[@for='IRPEscrow']") WebElement Billing_IRPSystemCreditlbl;
	@FindBy(xpath="//input[@id='IRPEscrow']") WebElement Billing_IRPSystemCredittxt;

	@FindBy(xpath="//label[@for='RenewalFeeEffectiveDate']") WebElement Billing_RenewalFeeEffectiveDatelbl;
	@FindBy(xpath="//input[@id='RenewalFeeEffectiveDate']") WebElement Billing_RenewalFeeEffectiveDatedtPicker;

	@FindBy(xpath="//label[@for='InvoiceDate']") WebElement Billing_InvoiceDatelbl;
	@FindBy(xpath="//input[@id='InvoiceDate']") WebElement Billing_InvoiceDatelbldtPicker;

	@FindBy(xpath="//label[@for='ReceiptDate']") WebElement Billing_ApplicationReceiptDatelbl;
	@FindBy(xpath="//input[@id='ReceiptDate']") WebElement Billing_ApplicationReceiptDatedtPicker;

	@FindBy(xpath="//label[@for='PaymentDate']") WebElement Billing_PaymentDatelbl;
	@FindBy(xpath="//input[@id='PaymentDate']") WebElement Billing_PaymentDatedtPicker;
	
	@FindBy(xpath="//label[@for='ExchangeRate']") WebElement Billing_ExchangeRatelbl;
	@FindBy(xpath="//input[@id='ExchangeRate']") WebElement Billing_ExchangeRatetxt;

	@FindBy(xpath="(//div[contains(@class,'box-title')]/h4)[2]") WebElement Billing_FeeSubhdr;
	
	@FindBy(xpath="//label[@for='ManualAdjBaseJur']") WebElement Billing_ManualAdjBaseJurlbl;
	@FindBy(xpath="//input[@id='ManualAdjBaseJur']") WebElement Billing_ManualAdjBaseJurtxt;

	@FindBy(xpath="//label[@for='BatchBilling']") WebElement Billing_BatchBillinglbl;
	@FindBy(xpath="//input[@id='BatchBilling']") WebElement Billing_BatchBillingchk;
	
	@FindBy(xpath="//label[@for='Chk30daysTear']") WebElement Billing_TVRlbl;
	@FindBy(xpath="//input[@id='Chk30daysTear']") WebElement Billing_TVRchk;
	
	@FindBy(xpath="//label[@for='QuaterPayment']") WebElement Billing_InstallmentPlanlbl;
	@FindBy(xpath="//input[@id='QuaterPayment']") WebElement Billing_InstallmentPlanchk;
	
	@FindBy(xpath="//label[@for='IsUseOneTimeMailing']") WebElement Billing_IsUseOneTimeMailinglbl;
	@FindBy(xpath="//input[@id='IsUseOneTimeMailing']") WebElement Billing_IsUseOneTimeMailingchk;
	@FindBy(xpath="//label[@for='NoOfdaysTear']") WebElement Billing_TVRNoOfDayslbl;
	@FindBy(xpath="//input[@id='NoOfdaysTear']") WebElement Billing_TVRNoOfDaystxt;
	
	
	//select[@id='selectEDC']
	
@FindBy(xpath="(//div[contains(@class,'box-title')]/h4)[3]") WebElement Billing_DeliveryDetailsSubhdr;
	
	@FindBy(xpath="//label[@for='selectEDC']") WebElement Billing_ElectronicDeliveryTypelbl;
	@FindBy(xpath="//select[@id='selectEDC']") WebElement Billing_ElectronicDeliveryTypedd;

	@FindBy(xpath="//label[@for='selectedInvReport']") WebElement Billing_InvoiceReportTypelbl;
	@FindBy(xpath="//select[@id='selectedInvReport']") WebElement Billing_InvoiceReportTypedd;

	@FindBy(xpath="//input[@id='btnRecalculate']") WebElement Billing_ReCalculatebtn;
	
	//Validation screen
	@FindBy(xpath="//label[@for='selectEDC30daysTear']") WebElement Billing_TVRElectronicDeliveryTypelbl;
	@FindBy(xpath="//select[@id='selectEDC30daysTear']") WebElement Billing_TVRElectronicDeliveryTypedd;

	@FindBy(xpath="//input[@id='btnCancelBill']") WebElement BillingCancelBillbtn;
	@FindBy(xpath="//input[@id='Email']") WebElement Billing_EmailIDTxt;
	
	
	public void enterManualAdjBaseJur(String ManualAdjBaseJurValue) {
		ElementUtil.webEditTxtChange(Billing_ManualAdjBaseJurtxt, ManualAdjBaseJurValue);
	}
	public void clickTVR() {
		ElementUtil.webCheckON(Billing_BatchBillingchk);
	}
	public void clickBatchBilling() {
		ElementUtil.webCheckON(Billing_TVRchk);
	}
	public void clickInstallmentPlan() {
		ElementUtil.webCheckON(Billing_InstallmentPlanchk);
	}
	public void clickIsUseOneTimeMailingchk() {
		ElementUtil.webCheckON(Billing_IsUseOneTimeMailingchk);
	}
	public void enterTVRNofDays(String TVRNoOfDaysValue) {
		ElementUtil.webEditTxtChange(Billing_TVRNoOfDaystxt, TVRNoOfDaysValue);
	}
	public void selectElectronicDeliveryType(String ElectronicDeliveryTypeValue) {
		ElementUtil.selectFromDropdownByVisibleText(Billing_ElectronicDeliveryTypedd,ElectronicDeliveryTypeValue);
	}

	public void selectInvoiceReportType(String InvoiceReportTypeValue) {
		ElementUtil.selectFromDropdownByVisibleText(Billing_InvoiceReportTypedd,InvoiceReportTypeValue);
	}
public void clickReCalculate() {
	ElementUtil.clickElement(Billing_ReCalculatebtn);
}
public void selectTVRElectronicDeliveryType(String TVRElectronicDeliveryTypeValue) {
	ElementUtil.selectFromDropdownByVisibleText(Billing_TVRElectronicDeliveryTypedd,TVRElectronicDeliveryTypeValue);
}
public void clickCancelBill() {
	ElementUtil.clickElement(BillingCancelBillbtn);
}
public void enterEmailIDTxt(String EmailIDTxtValue) {
	ElementUtil.webEditTxtChange(Billing_EmailIDTxt, EmailIDTxtValue);
}
}
