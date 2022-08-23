package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.util.ElementUtil;

public class PaymentTab {
	public WebDriver driver;
	public PaymentTab(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="(//div[contains(@class,'box-title')]/h4)[1]") WebElement Payment_SupplementDetailsSubhdr;
	
	@FindBy(xpath="//label[@for='IRPEscrow']") WebElement Payment_IRPSystemCreditlbl;;
	@FindBy(xpath="//input[@id='IRPEscrow']") WebElement Payment_IRPSystemCredittxt;

	@FindBy(xpath="//label[@for='EnterpriseEscrow']") WebElement Payment_EnterpriseSystemCreditlbl;;
	@FindBy(xpath="//input[@id='EnterpriseEscrow']") WebElement Payment_EnterpriseSystemCredittxt;

	@FindBy(xpath="//label[@for='InvoiceDate']") WebElement Payment_InvoiceDatelbl;;
	@FindBy(xpath="//input[@id='InvoiceDate']") WebElement Payment_InvoiceDatedtPicker;
	@FindBy(xpath="//label[@for='invoiceNbr']") WebElement Payment_InvoiceNumberlbl;;
	@FindBy(xpath="//input[@id='invoiceNbr']") WebElement Payment_InvoiceNumbertxt;
	@FindBy(xpath="//label[@for='ReceiptDate']") WebElement Payment_PaymentReciptDatelbl;;
	@FindBy(xpath="//input[@id='ReceiptDate']") WebElement Payment_PaymentReciptDatedtPicker;
	
	@FindBy(xpath="//label[@for='ManualAdjBaseJur']") WebElement Payment_ManualAdjBaseJurlbl;
	@FindBy(xpath="//input[@id='ManualAdjBaseJur']") WebElement Payment__ManualAdjBaseJurtxt;
	@FindBy(xpath="//label[@for='BatchCredential']") WebElement Payment_BatchCredentiallbl;
	@FindBy(xpath="//input[@id='BatchCredential']") WebElement Payment_BatchCredentialchk;;
	@FindBy(xpath="//label[@for='WireTransferFee']") WebElement Payment_WireTransferFeelbl;
	@FindBy(xpath="//input[@id='WireTransferFee']") WebElement Payment_WireTransferFeechk;
@FindBy(xpath="(//div[contains(@class,'box-title')]/h4)[3]") WebElement Payment_CabCardDeliveryTypeSubhdr;

@FindBy(xpath="//label[@for='ElectronicDeliveryType']") WebElement Payment_ElectronicDeliveryTypelbl;
@FindBy(xpath="//select[@id='ElectronicDeliveryType']") WebElement Payment_ElectronicDeliveryTypedd;

@FindBy(xpath="//a[contains(text(),'Show')]") WebElement Payment_ShowHandLoglnk;
@FindBy(xpath="//a[contains(text(),'Invoice')]") WebElement Payment_ViewInvoiceReportlnk;
@FindBy(xpath="//a[contains(text(),'TVR')]") WebElement Payment_ViewTVRLnk;

@FindBy(xpath="//input[@id='btnPayNow']") WebElement Payment_PayNowbtn; 
@FindBy(xpath="//input[@id='btnAddToCart']") WebElement Payment_AddToCartbtn;


public void clickPayNow() {
	ElementUtil.clickElement(Payment_PayNowbtn);
}
public void clickAddtoCart() {
	ElementUtil.clickElement(Payment_AddToCartbtn);
}	
}
