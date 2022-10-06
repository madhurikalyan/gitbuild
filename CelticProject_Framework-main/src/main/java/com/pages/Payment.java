package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.util.ElementUtil;

public class Payment {
	public WebDriver driver;
	public Payment(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css="#contentMsg > div.alert.alert-danger.notification > ul > li > span") WebElement Payment_ValidationMessage1;
	@FindBy(css="#contentMsg > div.alert.alert-info.notification > ul > li:nth-child(1) > span") WebElement Payment_ValidationMessage2;
	@FindBy(css="#contentMsg > div.alert.alert-info.notification > ul > li:nth-child(2) > span") WebElement Payment_ValidationMessage3;
	@FindBy(css="#contentMsg > div.alert.alert-info.notification > ul > li:nth-child(3) > span") WebElement Payment_ValidationMessage4;
	
	
	@FindBy(xpath="//div[@class='alert alert-danger notification']") List<WebElement> validationMessage;
	@FindBy(xpath="//input[@id='AccountNo']") WebElement Payment_MCECustomerIdtxt;
	@FindBy(xpath="//label[@for='AccountNo']") WebElement Payment_MCECustomerIdlbl;
	@FindBy(xpath="//input[@id='legalName']") WebElement Payment_legalNametxt;
	@FindBy(xpath="//label[@for='legalName']") WebElement Payment_legalNamelbl;
	@FindBy(xpath="//input[@id='DBAName']") WebElement Payment_DBANametxt;
	@FindBy(xpath="//label[@for='DBAName']") WebElement Payment_DBANamelbl;
	@FindBy(xpath="//input[@id='EntEsc']") WebElement Payment_EnterpriseSystemCredittxt;
	@FindBy(xpath="//label[@for='EntEsc']") WebElement Payment_EnterpriseSystemCreditlbl;
	@FindBy(xpath="//input[@id='IrpEsc']") WebElement Payment_IRPSystemCredittxt;
	@FindBy(xpath="//label[@for='IrpEsc']") WebElement Payment_IRPSystemCreditlbl;
	@FindBy(xpath="//input[@id='IftaEsc']") WebElement Payment_IftaSystemCredittxt;
	@FindBy(xpath="//label[@for='IftaEsc']") WebElement Payment_IftaSystemCreditlbl;
	@FindBy(xpath="//input[@id='OPAEsc']") WebElement Payment_OpaSystemCredittxt;
	@FindBy(xpath="//label[@for='OPAEsc']") WebElement Payment_OpaSystemCreditlbl;
	
	@FindBy(xpath="//table[@id='gvTransactionDetail']//tr[1]/th") List<WebElement> Payment_tableHeaderRow;
    @FindBy(xpath="//table[@id='gvTransactionDetail']/tbody/tr/td/span") List<WebElement> Payment_InvoiceRow;
	@FindBy(xpath="//strong[contains(text(),'Total')]") WebElement Payment_TotalAmountDuelbl;
    @FindBy(xpath="//input[@name='totalInvoiceAmountUSD']") WebElement Payment_TotalInvoiceAmount;
    
    
    @FindBy(xpath="//input[@id='invoiceNbr']") WebElement Payment_invoiceNbrtxt;
	@FindBy(xpath="//label[@for='invoiceNbr']") WebElement Payment_invoiceNbrlbl;
	@FindBy(xpath="//input[@id='invDateFrom']") WebElement Payment_invoiceDateFromIdtxt;
	@FindBy(xpath="//label[@for='invDateFrom']") WebElement Payment_invoiceDateFromIdlbl;
	@FindBy(xpath="//input[@id='invDateTo']") WebElement Payment_invoiceDateTotxt;
	@FindBy(xpath="//label[@for='invDateTo']") WebElement Payment_invoiceDateTolbl;

	@FindBy(xpath="//input[@id='cartId']") WebElement Payment_cartIdtxt;
	@FindBy(xpath="//label[@for='cartId']") WebElement Payment_cartIdlbl;
	@FindBy(xpath="//input[@id='allTransaction']") WebElement Payment_allTransactiontxt;
	@FindBy(xpath="//label[@for='allTransaction']") WebElement Payment_allTransactionlbl;
	
	
	@FindBy(xpath="//input[@id='btnbtnSrch']") WebElement Payment_btnSearch;
	@FindBy(xpath="(//div[contains(@class,'box-title')]/h4)[1]") WebElement Payment_SearchForTransactionSubhdr;  //SearchForTransaction, Payment
	@FindBy(xpath="(//div[contains(@class,'box-title')]/h4)[2]") WebElement Payment_SelectedTransactionSubhdr; //SelectedTransaction, payment Details
	@FindBy(xpath="(//div[contains(@class,'box-title')]/h4)[3]") WebElement Payment_ElectronicDeliveryTypeSubhdr;
	@FindBy(xpath="//select[@id='ElectronicDeliveryType']") WebElement Payment_ElectronicDeliveryTypedd;
	@FindBy(xpath="//input[@id='payerName']") WebElement Payment_payerNametxt;
	@FindBy(xpath="//label[@for='payerName']") WebElement Payment_payerNamelbl;
	@FindBy(xpath="//input[@id='payerAccountNo']") WebElement Payment_payerAccountNotxt;
	@FindBy(xpath="//label[@for='payerAccountNo']") WebElement Payment_payerAccountNolbl;
	@FindBy(xpath="//input[@id='recieptDate']") WebElement Payment_recieptDatetxt;
	@FindBy(xpath="//label[@for='recieptDate']") WebElement Payment_recieptDatelbl;
	
	@FindBy(xpath="//input[@id='btnRemove']") WebElement Payment_Removebtn;
	@FindBy(xpath="//input[@id='btnPay']") WebElement Payment_Paybtn;
	@FindBy(xpath="//input[@id='btnSaveQuit']") WebElement Payment_SaveQuitbtn;

	@FindBy(xpath="//th[contains(@aria-label,'Remove')]") WebElement Payment_Removetbl;
	@FindBy(xpath="//th[contains(@aria-label,'MCE')]") WebElement Payment_MCECustomerIdtbl;
	@FindBy(xpath="//th[contains(@aria-label,'Legal')]") WebElement Payment_LegalNametbl;
	@FindBy(xpath="//th[contains(@aria-label,'Invoice No')]") WebElement Payment_InvoiceNotbl;
	@FindBy(xpath="//th[contains(@aria-label,'Date')]") WebElement Payment_InvoiceDatetbl;
	@FindBy(xpath="//th[contains(@aria-label,'Transaction')]") WebElement Payment_TransactionTypetbl;
	@FindBy(xpath="//th[contains(@aria-label,'Priority')]") WebElement Payment_Prioritytbl;
	@FindBy(xpath="//th[contains(@aria-label,'Amount')]") WebElement Payment_AmountDuestbl;
	@FindBy(xpath="//input[contains(@id,'totalAmountUSD')]") WebElement Payment_TotalAmountUSDtbl;

	@FindBy(xpath="//input[@id='payerCustAccountNo']") WebElement Payment_PayerMCECustomerIdtxt;
	@FindBy(xpath="//label[@for='payerCustAccountNo']") WebElement Payment_PayerMCECustomerIdlbl;
	
	
	@FindBy(xpath="//input[@name='totalInvoiceAmountUSD']") WebElement Payment_TotalInvoiceAmountUSDValue;
//	@FindBy(xpath="//select[contains(@id,'PayType') and contains(@id,'"+i+"')]") List<WebElement> Payment_PaymentTypegriddd;
	//@FindBy(xpath="//input[contains(@id,'paymentVos') and contains(@id,'PaymentAmount')]") List<WebElement> Payment_PaymentAmountgridtxt;
	//@FindBy(xpath="//input[contains(@id,'paymentVos') and contains(@id,'PaymentNo')]") List<WebElement> Payment_PaymentNumbergridtxt;
	
	
	@FindBy(xpath="//input[@id='Delete']") WebElement Deletebtn;
	@FindBy(xpath="//input[@id='Add']") WebElement Addbtn;
	@FindBy(xpath="//input[@id='btnCashDrawerCCUSD']") WebElement CreditCardbtn;
	@FindBy(xpath="//input[@id='btnCashDrawerECheckUSD']") WebElement ECheckbtn;
	@FindBy(xpath="//h3[@class='red']") WebElement RedNote;
	@FindBy(xpath="//input[@id='forOverPayment']") List<WebElement> ForOverPaymentrdList;
	
	
	@FindBy(xpath="//input[@id='totalAmount']") WebElement Payment_totalAmounttxt;
	@FindBy(xpath="//label[@for='totalAmount']") WebElement Payment_totalAmountlbl;
	@FindBy(xpath="//input[@id='remainingBalance']") WebElement Payment_remainingBalancetxt;
	@FindBy(xpath="//label[@for='remainingBalance']") WebElement Payment_remainingBalancelbl;
	@FindBy(xpath="//input[@id='changeAmount']") WebElement Payment_changeAmounttxt;
	@FindBy(xpath="//label[@for='changeAmount']") WebElement Payment_changeAmountlbl;
	@FindBy(xpath="//input[@id='overPaymentAmount']") WebElement Payment_overPaymentAmounttxt;
	@FindBy(xpath="//label[@for='overPaymentAmount']") WebElement Payment_overPaymentAmountlbl;
	@FindBy(xpath="//input[@id='netAmountPaid']") WebElement Payment_netAmountPaidtxt;
	@FindBy(xpath="//label[@for='netAmountPaid']") WebElement Payment_netAmountPaidlbl;
	
	@FindBy(xpath="//label[@for='outPutModelSelect']") WebElement Payment_PaymentReceiptlbl;
	@FindBy(xpath="//select[@id='outPutModelSelect']") WebElement Payment_PaymentReceiptdd;
	@FindBy(xpath="//input[@id='remainingBalance']") WebElement Payment_RemainingBalancetxt;
	@FindBy(xpath="//input[@id='btnbtnTransactionSection']")WebElement TransactionSelectionbtn;
	
	public void selectElectronicDeliverytype(String electronicdeliverytypevalue) {
		ElementUtil.selectFromDropdownByVisibleText(Payment_ElectronicDeliveryTypedd, electronicdeliverytypevalue);
	}
	public String FetchTotalAmount() {
		String TotalAmountValue=Payment_TotalInvoiceAmountUSDValue.getAttribute("value").toString();
		return TotalAmountValue;
	}
	public String FetchRemainingBalance() {
		String TotalRemainingBalance=Payment_RemainingBalancetxt.getAttribute("value").toString();
		return TotalRemainingBalance;
	}
	public void clickPayNow() {
	ElementUtil.clickElement(Payment_Paybtn);
}
public void check(int i) {
	WebElement Payment_PaymentType=driver.findElement(By.xpath("//select[contains(@id,'PayType') and contains(@id,'"+i+"')]"));
	System.out.println("id1 is:"+Payment_PaymentType.getAttribute("id")); //paymentVos_0__PayType
	
}
public void selectPaymentType(int i,String PaymentTypeValue) {
	WebElement Payment_PaymentType=driver.findElement(By.xpath("//select[contains(@id,'PayType') and contains(@id,'"+i+"')]"));
	ElementUtil.waitUntilElementClickable(Payment_PaymentType);
	ElementUtil.selectFromDropdownByVisibleText(Payment_PaymentType, PaymentTypeValue); //Cash,Check,Certified Check,E-check,Credit Card,Wire Transfer,EFT,Enterprise System Credit,IRP System Credit,IFTA System Credit,OPA System Credit,IFTA Bond
}
public void enterpaymentNoBasedonType(int i,String ExcelpassedValue,String PaymentNumberValue) {
	WebElement Payment_PaymentNumbertxt=driver.findElement(By.xpath("//input[contains(@id,'paymentVos') and contains(@id,'PaymentNo')and contains(@id,'"+i+"')]"));
	ElementUtil.waitUntilElementVisible(Payment_PaymentNumbertxt);
	if(ExcelpassedValue.equalsIgnoreCase("Check")) {
		ElementUtil.webEditTxt(Payment_PaymentNumbertxt, PaymentNumberValue);
	}
	else if(ExcelpassedValue.equalsIgnoreCase("Certified Check")){
		ElementUtil.webEditTxt(Payment_PaymentNumbertxt, PaymentNumberValue);
	}
	else if(ExcelpassedValue.equalsIgnoreCase("Wire Transfer")){
		ElementUtil.webEditTxt(Payment_PaymentNumbertxt, PaymentNumberValue);
	}
	else if(ExcelpassedValue.equalsIgnoreCase("EFT")){
		ElementUtil.webEditTxt(Payment_PaymentNumbertxt, PaymentNumberValue);
	}
	else if(ExcelpassedValue.equalsIgnoreCase("Enterprise System Credit")){
		ElementUtil.webEditTxt(Payment_PaymentNumbertxt, PaymentNumberValue);
	}
}

public void enterPaymentAmountBasedonType(int i,String ExcelpassedValue,String PaymentAmountValue) {
	WebElement Payment_PaymentType=driver.findElement(By.xpath("//select[contains(@id,'PayType') and contains(@id,'"+i+"')]"));
	WebElement Payment_PaymentAmount=driver.findElement(By.xpath("//input[contains(@id,'paymentVos') and contains(@id,'PaymentAmount') and contains(@id,'"+i+"')]"));
	ElementUtil.waitUntilElementVisible(Payment_PaymentAmount);
	if(ExcelpassedValue.equalsIgnoreCase("Cash")) {
		ElementUtil.webEditTxt(Payment_PaymentAmount, PaymentAmountValue);
	}
	else if(ExcelpassedValue.equalsIgnoreCase("Check")){
		ElementUtil.webEditTxt(Payment_PaymentAmount, PaymentAmountValue);
	}
	else if(ExcelpassedValue.equalsIgnoreCase("Certified Check")){
		ElementUtil.webEditTxt(Payment_PaymentAmount, PaymentAmountValue);
	}
	else if(ExcelpassedValue.equalsIgnoreCase("Wire Transfer")){
		ElementUtil.webEditTxt(Payment_PaymentAmount, PaymentAmountValue);
	}
	else if(ExcelpassedValue.equalsIgnoreCase("EFT")){
		ElementUtil.webEditTxt(Payment_PaymentAmount, PaymentAmountValue);
	}
	else if(ExcelpassedValue.equalsIgnoreCase("Enterprise System Credit")){
		ElementUtil.webEditTxt(Payment_PaymentAmount, PaymentAmountValue);
	}
	else if(ExcelpassedValue.equalsIgnoreCase("IRP System Credit")){
		ElementUtil.webEditTxt(Payment_PaymentAmount, PaymentAmountValue);
	}
	else if(ExcelpassedValue.equalsIgnoreCase("IFTA System Credit")){
		ElementUtil.webEditTxt(Payment_PaymentAmount, PaymentAmountValue);
	}
	else if(ExcelpassedValue.equalsIgnoreCase("OPA System Credit")){
		ElementUtil.webEditTxt(Payment_PaymentAmount, PaymentAmountValue);
	}
	else if(ExcelpassedValue.equalsIgnoreCase("IFTA Bond")){
		ElementUtil.webEditTxt(Payment_PaymentAmount, PaymentAmountValue);
	}
}
public void validatemsg(String msgvalue) {
	for(WebElement eachmsg:validationMessage) {
		if(eachmsg.getText().contains(msgvalue))
			assert true;
	}
}
	//ElementUtil.highlightElement(driver, validationMessage);
public void clickDelete() {
	ElementUtil.clickElement(Deletebtn);
}
public void clickAdd() {
	ElementUtil.clickElement(Addbtn);
}
public void clickCreditCard() {
	ElementUtil.clickElement(CreditCardbtn);
}
public void clickECheck() {
	ElementUtil.clickElement(ECheckbtn);
}

public void selectOverPaymentRadioButton(String PaymentRdValue) {
	for(WebElement rd:ForOverPaymentrdList) {
		if(rd.getAttribute("value").equalsIgnoreCase(PaymentRdValue)) {
			ElementUtil.clickElement(rd);
		}
	}
}

public void selectPaymentReceipt(String PaymentReceiptddValue) {
	ElementUtil.selectFromDropdownByVisibleText(Payment_PaymentReceiptdd, PaymentReceiptddValue); //D - PDF,E - EMAIL,F - FAX,P - PRINT
}

//Fetch Values
public String FetchMCECustomerIdlbl() {
	return ElementUtil.FetchTextBoxValuewithText(Payment_PayerMCECustomerIdlbl);
}
public String FetchMCECustomerId() {
	return ElementUtil.FetchTextBoxValuewithattribute(Payment_PayerMCECustomerIdtxt,"value");
}
public String FetchlegalNamelbl() {
	return ElementUtil.FetchTextBoxValuewithText(Payment_legalNamelbl);
}
public String FetchlegalName() {
	return ElementUtil.FetchTextBoxValuewithattribute(Payment_legalNametxt,"value");
}
public String FetchInvoiceDatelbl() {
	return ElementUtil.FetchTextBoxValuewithText(Payment_DBANamelbl);
}
public String FetchInvoiceDate() {
	return ElementUtil.FetchTextBoxValuewithattribute(Payment_DBANametxt,"value");
}
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
public String FetchIftaSystemCreditlbl() {
	return ElementUtil.FetchTextBoxValuewithText(Payment_IftaSystemCreditlbl);
}
public String FetchIftaSystemCredit() {
	return ElementUtil.FetchTextBoxValuewithattribute(Payment_IftaSystemCredittxt,"value");
}
public String FetchOpaSystemCreditlbl() {
	return ElementUtil.FetchTextBoxValuewithText(Payment_OpaSystemCreditlbl);
}
public String FetchOpaSystemCredit() {
	return ElementUtil.FetchTextBoxValuewithattribute(Payment_OpaSystemCredittxt,"value");
}
public ArrayList<String> FetchTable_Headers() {
	ArrayList<String> Headers_array = new ArrayList<String>();
	for(int i=0;i<Payment_tableHeaderRow.size();i++) {
		Headers_array.add(ElementUtil.FetchTextBoxValuewithText(Payment_tableHeaderRow.get(i)));
	}
	return Headers_array;
}

public ArrayList<String> FetchTable_InvoiceDetails() {
	ArrayList<String> Invoice_array = new ArrayList<String>();
	for(int i=0;i<Payment_InvoiceRow.size();i++) {
		Invoice_array.add(ElementUtil.FetchTextBoxValuewithText(Payment_InvoiceRow.get(i)));
	}
	return Invoice_array;
}

public String FetchTotalAmountDuelbl() {
	return ElementUtil.FetchTextBoxValuewithText(Payment_TotalAmountDuelbl);
}
public String FetchTotalAmountDue() {
	return ElementUtil.FetchTextBoxValuewithattribute(Payment_TotalInvoiceAmount,"value");
}


public String ValidateMessage1() {
	
	ElementUtil.highlightElement(driver, Payment_ValidationMessage1);
	return ElementUtil.FetchTextBoxValuewithText(Payment_ValidationMessage1);
}
public String ValidateMessage2() {
	ElementUtil.highlightElement(driver, Payment_ValidationMessage2);
	return ElementUtil.FetchTextBoxValuewithText(Payment_ValidationMessage2);
}

public String ValidateMessage3() {
	ElementUtil.highlightElement(driver, Payment_ValidationMessage3);
	return ElementUtil.FetchTextBoxValuewithText(Payment_ValidationMessage3);
}
public String ValidateMessage4() {
	ElementUtil.highlightElement(driver, Payment_ValidationMessage4);
	return ElementUtil.FetchTextBoxValuewithText(Payment_ValidationMessage4);
}






}





