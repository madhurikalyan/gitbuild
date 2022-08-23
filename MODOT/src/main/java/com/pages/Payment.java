package com.pages;

import java.util.List;

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
	
	@FindBy(xpath="//input[@id='AccountNo']") WebElement Payment_MCECustomerIdtxt;
	@FindBy(xpath="//label[@for='AccountNo']") WebElement Payment_MCECustomerIdlbl;
	@FindBy(xpath="//input[@id='invoiceNbr']") WebElement Payment_invoiceNbrtxt;
	@FindBy(xpath="//label[@for='invoiceNbr']") WebElement Payment_invoiceNbrlbl;
	@FindBy(xpath="//input[@id='invDateFrom']") WebElement Payment_invoiceDateFromIdtxt;
	@FindBy(xpath="//label[@for='invDateFrom']") WebElement Payment_invoiceDateFromIdlbl;
	@FindBy(xpath="//input[@id='invDateTo']") WebElement Payment_invoiceDateTotxt;
	@FindBy(xpath="//label[@for='invDateTo']") WebElement Payment_invoiceDateTolbl;

	@FindBy(xpath="//input[@id='cartId']") WebElement Payment_cartIdtxt;
	@FindBy(xpath="//label[@for='cartId']") WebElement Payment_cartIdlbl;
	@FindBy(xpath="//input[@id='legalName']") WebElement Payment_legalNameIdtxt;
	@FindBy(xpath="//label[@for='legalName']") WebElement Payment_legalNameIdlbl;
	@FindBy(xpath="//input[@id='allTransaction']") WebElement Payment_allTransactiontxt;
	@FindBy(xpath="//label[@for='allTransaction']") WebElement Payment_allTransactionlbl;
	
	
	@FindBy(xpath="//input[@id='btnbtnSrch']") WebElement Payment_btnSearch;
	@FindBy(xpath="(//div[contains(@class,'box-title')]/h4)[1]") WebElement Payment_SearchForTransactionSubhdr;  //SearchForTransaction, Payment
	@FindBy(xpath="(//div[contains(@class,'box-title')]/h4)[2]") WebElement Payment_SelectedTransactionSubhdr; //SelectedTransaction, payment Details
	@FindBy(xpath="(//div[contains(@class,'box-title')]/h4)[3]") WebElement Payment_ElectronicDeliveryTypeSubhdr;
	
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
	
	@FindBy(xpath="//input[@name='totalInvoiceAmountUSD']") WebElement Payment_TotalInvoiceAmountUSDValue;
	@FindBy(xpath="//select[@id='paymentVos_0__PayType']") WebElement Payment_PaymentTypegriddd;
	@FindBy(xpath="//input[contains(@id,'paymentVos') and contains(@id,'PaymentAmount')]") WebElement Payment_PaymentAmountgridtxt;
	@FindBy(xpath="//input[contains(@id,'paymentVos') and contains(@id,'PaymentNo')]") WebElement Payment_PaymentNumbergridtxt;
	
	
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
	
	@FindBy(xpath="//input[@id='btnbtnTransactionSection']")WebElement TransactionSelectionbtn;
	
	public String FetchTotalAmount() {
		String TotalAmountValue=Payment_TotalInvoiceAmountUSDValue.getAttribute("value").toString();
		return TotalAmountValue;
	}
	
	public void clickPayNow() {
	ElementUtil.clickElement(Payment_Paybtn);
}

public void selectPaymentType(String PaymentTypeValue) {
	ElementUtil.selectFromDropdownByVisibleText(Payment_PaymentTypegriddd, PaymentTypeValue); //Cash,Check,Certified Check,E-check,Credit Card,Wire Transfer,EFT,Enterprise System Credit,IRP System Credit,IFTA System Credit,OPA System Credit,IFTA Bond
}

public void enterPaymentAmount(String PaymentAmountValue) {
	ElementUtil.webEditTxt(Payment_PaymentAmountgridtxt, PaymentAmountValue);
}
public void enterPaymentNumber(String PaymentNumberValue) {
	ElementUtil.webEditTxt(Payment_PaymentNumbergridtxt, PaymentNumberValue);
}

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



















}





