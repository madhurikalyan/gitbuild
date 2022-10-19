package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.qa.util.ElementUtil;


public class PaymentTab {
	public WebDriver driver;
	public PaymentTab(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="#contentMsg > div > ul > li:nth-child(1) > span") WebElement Payment_Validationmessage1;
	@FindBy(css="#contentMsg > div > ul > li:nth-child(2) > span") WebElement Payment_Validationmessage2;
	@FindBy(css="#contentMsg > div > ul > li:nth-child(3) > span") WebElement Payment_Validationmessage3;
	@FindBy(css="#contentMsg > div > ul > li > span") WebElement Payment_Validationmessage4;
	@FindBy(css="#contentMsg > div > ul > li > span") WebElement Supplement_Validationmessage5;
	
	
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

@FindBy(xpath="//select[@id='paymentVos_0__PayType']") WebElement Payment_Method;
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
@FindBy(xpath="//input[@id='paymentVos_0__PaymentAmount']") WebElement Payment_Amount;

@FindBy(xpath="//th[contains(@class,'sorting_disabled')and not( contains(@class,'hidden'))]") List<WebElement> Billing_GridHeaders;
@FindBy(xpath="//th[contains(@class,'sorting_disabled')and contains(text(),'Type')]") WebElement Billing_GridFeeType;
@FindBy(xpath="//input[contains(@id,'FeeDetailRows_')and contains(@id,'_FeeDescription')]") List<WebElement> Billing_FeeType;
@FindBy(xpath="//th[contains(@class,'sorting_disabled')and contains(text(),'Amt')]") WebElement Billing_GridFeeAmount;
@FindBy(xpath="//input[contains(@id,'FeeDetailRows_')and contains(@id,'_FeeAmount')]") List<WebElement> Billing_FeeAmount;

public void clickPayNow() throws InterruptedException {
	ElementUtil.scrollIntoView(Payment_PayNowbtn);
	ElementUtil.clickElement(Payment_PayNowbtn);
	//ElementUtil.sleepTime(2000);
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
public void validatemessage(String TransactionexistMeesage) {
	ElementUtil.highlightElement(driver, Addtocart_Msg);
	Assert.assertEquals(Addtocart_Msg.getText(), TransactionexistMeesage);
}
public void clickverifyaddtocart() {
	ElementUtil.clickElement(VerifyAddtocart);
}

public void Selectpaymentmethod(String Methodtype) {
	ElementUtil.webEditTxtChange(Payment_Method, Methodtype);
}
public void enterpaymentamount(String PaymentAmount1) {
	ElementUtil.webEditTxtChange(Payment_Amount, PaymentAmount1);
}
//Fetch Values
public String FetchEnterpriseSystemCreditlbl() {
	return ElementUtil.FetchTextBoxValuewithText(Payment_EnterpriseSystemCreditlbl);
}
public String FetchEnterpriseSystemCredit() {
	return ElementUtil.FetchTextBoxValuewithattribute(Payment_EnterpriseSystemCredittxt,"value");
}
public String FetchIRPSystemCreditlbl() {
	return ElementUtil.FetchTextBoxValuewithText(Payment_IRPSystemCreditlbl);
}
public String FetchIRPSystemCredit() {
	return ElementUtil.FetchTextBoxValuewithattribute(Payment_IRPSystemCredittxt,"value");
}
public String FetchInvoiceDatelbl() {
	return ElementUtil.FetchTextBoxValuewithText(Payment_InvoiceDatelbl);
}
public String FetchInvoiceDate() {
	return ElementUtil.FetchTextBoxValuewithattribute(Payment_InvoiceDatedtPicker,"value");
}
public String FetchInvoiceNumberlbl() {
	return ElementUtil.FetchTextBoxValuewithText(Payment_InvoiceNumberlbl);
}
public String FetchInvoiceNumber() {
	return ElementUtil.FetchTextBoxValuewithattribute(Payment_InvoiceNumbertxt,"value");
}
public String FetchPaymentReciptDatelbl() {
	return ElementUtil.FetchTextBoxValuewithText(Payment_PaymentReciptDatelbl);
}
public String FetchPaymentReciptDate() {
	return ElementUtil.FetchTextBoxValuewithattribute(Payment_PaymentReciptDatedtPicker,"value");
}
public String FetchManualAdjBaseJurlbl() {
	return ElementUtil.FetchTextBoxValuewithText(Payment_ManualAdjBaseJurlbl);
}
public String FetchManualAdjBaseJur() {
	return ElementUtil.FetchTextBoxValuewithattribute(Payment__ManualAdjBaseJurtxt,"value");
}
public String FetchBatchCredentiallbl() {
	return ElementUtil.FetchTextBoxValuewithText(Payment_BatchCredentiallbl);
}
public String FetchBatchCredential() {
	return ElementUtil.FetchTextBoxValuewithattribute(Payment_BatchCredentialchk,"value");
}
public String FetchWireTransferFeelbl() {
	return ElementUtil.FetchTextBoxValuewithText(Payment_WireTransferFeelbl);
}
public String FetchWireTransferFee() {
	return ElementUtil.FetchTextBoxValuewithattribute(Payment_WireTransferFeechk,"value");
}
public ArrayList<String> FetchTable_Headers() {
	ArrayList<String> Headers_array = new ArrayList<String>();
	for(int i=0;i<Billing_GridHeaders.size();i++) {
		Headers_array.add(ElementUtil.FetchTextBoxValuewithText(Billing_GridHeaders.get(i)));
	}
	return Headers_array;
}
public String FetchHeaderFeeType() {
	return ElementUtil.FetchTextBoxValuewithText(Billing_GridFeeType);
}

public ArrayList<String> FetchTable_FeeType() {
	ArrayList<String> FeeType_Array = new ArrayList<String>();
	for(int i=0;i<Billing_FeeType.size();i++) {
		FeeType_Array.add(ElementUtil.FetchTextBoxValuewithattributedisabled(Billing_FeeType.get(i),"value"));
	}
	return FeeType_Array;
}
public String FetchHeaderFeeAmount() {
	return ElementUtil.FetchTextBoxValuewithText(Billing_GridFeeAmount);
}

public ArrayList<String> FetchTable_FeeAmount() {
	ArrayList<String> FeeAmount_Array = new ArrayList<String>();
	for(int i=0;i<Billing_FeeAmount.size();i++) {
		FeeAmount_Array.add(ElementUtil.FetchTextBoxValuewithattributedisabled(Billing_FeeAmount.get(i),"value"));
	}
	return FeeAmount_Array;
}


public String FetchElectronicDeliveryTypelbl() {
	return ElementUtil.FetchTextBoxValuewithText(Payment_ElectronicDeliveryTypelbl);
}
public String FetchElectronicDeliveryType() {
	return ElementUtil.FetchDropdownSelectedValue(Payment_ElectronicDeliveryTypedd);
}

}
