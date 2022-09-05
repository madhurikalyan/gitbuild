package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.util.ElementUtil;

import junit.framework.Assert;

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


@FindBy(xpath="//a[@title='Supplement Continuance']") WebElement Supplement_Cont;
@FindBy(xpath="//div[@id='contentMsg']//span") WebElement Addtocart_Msg;
@FindBy(xpath="//a[@id='cartRef']") WebElement VerifyAddtocart;
@FindBy(xpath="//select[contains(@id,'PayType')]") WebElement PaymentType;
@FindBy(xpath="//input[contains(@id,'PaymentAmount')and contains(@id,'paymentVos')]") WebElement PaymentAmount;
@FindBy(xpath="//input[@id='Add']") WebElement PaymentAdd;
@FindBy(xpath="//select[@id='paymentVos_1__PayType']") WebElement PaymentAmountchecktype;
@FindBy(xpath="//input[@id='paymentVos_1__PaymentAmount']") WebElement PaymentAmountCheque;
@FindBy(xpath="//input[@id='paymentVos_2__DeleteChk']") WebElement Checkboxdelete;
@FindBy(xpath="//input[@id='Delete']") WebElement Deletecheckbox;
@FindBy(xpath="//select[@id='outPutModelSelect']") WebElement PaymentReceipt;
@FindBy(xpath="//input[@id='paymentVos_1__PaymentNo']") WebElement Paymentcheckno;


public void clickPayNow() {
	ElementUtil.clickElement(Payment_PayNowbtn);
}
public void clickAddtoCart() {
	ElementUtil.clickElement(Payment_AddToCartbtn);
}	
public void clickpaymentadd() {
	ElementUtil.clickElement(PaymentAdd);
}
/*public void clickandenteraccno(String accountnovalue) {
ElementUtil.clickElement(Accountno);
ElementUtil.webEditTxtChange(Accountno,accountnovalue);
}*/
public void clicksupplcont() {
	ElementUtil.clickElement(Supplement_Cont);
}
@SuppressWarnings("deprecation")
public void validatemessage(String TransactionexistMeesage) {
	
	ElementUtil.highlightElement(driver, Addtocart_Msg);
	Assert.assertEquals(Addtocart_Msg.getText(),TransactionexistMeesage);
}
public void clickverifyaddtocart() {
	ElementUtil.clickElement(VerifyAddtocart);
}
/*public void clickpay() {
	ElementUtil.clickElement(Payment_Pay);
}*/
/*public void clickpaymenttype(String selectValue) {
	ElementUtil.selectFromDropdownByValue(PaymentType, selectValue);
}
public void enterpaymentamount(String amountcashvalue) {
	ElementUtil.webEditTxtChange(PaymentAmountCash,amountcashvalue);
}
public void clickpaymenttypecheque(String selectValue) {
	ElementUtil.selectFromDropdownByValue(PaymentAmountchecktype, selectValue);
}
public void enterpaymentamount2(String PaymentAmountChequevalue) {
	ElementUtil.webEditTxtChange(PaymentAmountCheque,PaymentAmountChequevalue);
	
}
public void entercheckno(String paymentchequenovalue) {
	ElementUtil.webEditTxtChange(Paymentcheckno,paymentchequenovalue);
}
public void clickcheckbox() {
	ElementUtil.clickElement(Checkboxdelete);
}
public void clickdeletecheckbox() {
	ElementUtil.clickElement(Deletecheckbox);
}
public void clickpaymentreceipt(String selectValue) {
	ElementUtil.selectFromDropdownByValue(PaymentReceipt, selectValue);
}
*/
}
