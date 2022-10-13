package com.pages;

import java.util.ArrayList;
import java.util.List;

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
	
	@FindBy(css="#contentMsg > div > ul > li > span") WebElement Billing_Validationmessage;
	@FindBy(css="#contentMsg > div > ul > li:nth-child(1) > span") WebElement Billing_Validationmessage2;
	@FindBy(css="#contentMsg > div > ul > li:nth-child(2) > span") WebElement Billing_Validationmessage3;
	
	
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
	@FindBy(xpath="//input[@id='InvoiceDate']") WebElement Billing_InvoiceDatedtPicker;

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
	@FindBy(xpath="//th[contains(@class,'sorting_disabled')and not( contains(@class,'hidden'))]") List<WebElement> Billing_GridHeaders;
	@FindBy(xpath="//input[contains(@id,'FeeDetailRows_')and contains(@id,'_FeeDescription')]") List<WebElement> Billing_FeeType;
	@FindBy(xpath="//input[contains(@id,'FeeDetailRows_')and contains(@id,'_FeeAmount')]") List<WebElement> Billing_FeeAmount;
	
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
	
	@FindBy(xpath="//a[@role='button' and contains(text(),'Manual')]") WebElement Billing_ManualAdjReasonCollapse;
	@FindBy(xpath="//textarea[@id='editComment_CommentTxtcommentsVM2']") WebElement Billing_ManualAdjReasonCommentstxt;
	@FindBy(xpath="//input[@id='editComment_DelAllowedcommentsVM2']") WebElement Billing_ManualAdjReasonDeleteAllowedchk;
	@FindBy(xpath="//input[@id='addUpdateCommentBtncommentsVM2']") WebElement Billing_ManualAdjReasonAddorUpdateCommentbtn;
	@FindBy(xpath="//input[@id='refreshCommentBtncommentsVM2']") WebElement Billing_ManualAdjReasonClearCommentbtn;
	
	@FindBy(xpath="//select[@id='FeeDetailRows_8__WaiverReasonsSelect']") WebElement Billing_BicentennialFeedd;
	@FindBy(xpath="//select[@id='FeeDetailRows_9__WaiverReasonsSelect']") WebElement Billing_GradeCrossingFeedd;
	@FindBy(xpath="//select[@id='FeeDetailRows_10__WaiverReasonsSelect']") WebElement Billing_ReplacementPlateFeedd;
	@FindBy(xpath="//select[@id='FeeDetailRows_11__WaiverReasonsSelect']") WebElement Billing_SecondPlateFeedd;
	@FindBy(xpath="//select[@id='FeeDetailRows_12__WaiverReasonsSelect']") WebElement Billing_LateFilingPenaltydd;
	@FindBy(xpath="//select[@id='FeeDetailRows_13__WaiverReasonsSelect']") WebElement Billing_LatePayPenaltydd;
	@FindBy(xpath="//select[@id='FeeDetailRows_14__WaiverReasonsSelect']") WebElement Billing_TransferFeedd;
	@FindBy(xpath="//select[@id='FeeDetailRows_15__WaiverReasonsSelect']") WebElement Billing_TransferRevenueFeedd;
	
	@FindBy(xpath="//a[@role='button' and contains(text(),'Fee')]") WebElement Billing_FeeOverrideReasonCollapse;
	@FindBy(xpath="//textarea[@id='editComment_CommentTxtcommentsVM3']") WebElement Billing_FeeOverrideReasonCommentstxt;
	@FindBy(xpath="//input[@id='editComment_DelAllowedcommentsVM3']") WebElement Billing_FeeOverrideReasonDeleteAllowedchk;
	@FindBy(xpath="//input[@id='addUpdateCommentBtncommentsVM3']") WebElement Billing_FeeOverrideReasonAddorUpdateCommentbtn;
	@FindBy(xpath="//input[@id='refreshCommentBtncommentsVM3']") WebElement Billing_FeeOverrideReasonClearCommentbtn;
	
	///Reinstatement
	@FindBy(xpath="//a[@id='BillingBtn']") WebElement Billing_billingtab;
	@FindBy(xpath="//input[@id='ReceiptDate']") WebElement Billing_AppREceiptDatedtpicker;
	@FindBy(xpath="//h3[contains(@class,'pull-left')]") WebElement Billing_subhdr;
	
	
	
	
	public void enterManualAdjBaseJur(String ManualAdjBaseJurValue) {
		ElementUtil.webEditTxtChange(Billing_ManualAdjBaseJurtxt, ManualAdjBaseJurValue);
	}
	public void clickBatchBilling() {
		ElementUtil.webCheckON(Billing_BatchBillingchk);
	}
	
	public void clickTVR() {
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
public void clickReCalculate() throws InterruptedException {
	ElementUtil.clickElement(Billing_ReCalculatebtn);
	
	//ElementUtil.sleepTime(1000);
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
public void expandManualAdjReason() throws Exception {
	
	if(ElementUtil.FetchTextBoxValuewithattribute(Billing_ManualAdjReasonCollapse,"aria-expanded").equalsIgnoreCase("false")) {
		ElementUtil.clickElement(Billing_ManualAdjReasonCollapse);
		}
}
public void enterManualAdjReasonComments(String ManualadjreasonCommentsValue) {
	ElementUtil.webEditTxtChange(Billing_ManualAdjReasonCommentstxt, ManualadjreasonCommentsValue);
}
public void clickManualAdjReasonDeleteAllowed() {
	ElementUtil.webCheckON(Billing_ManualAdjReasonDeleteAllowedchk);
}
public void  clickManualAdjReasonAddorUpdateComments() {
	ElementUtil.clickElement(Billing_ManualAdjReasonAddorUpdateCommentbtn);
}
public void  clickManualAdjReasonclearComments() {
	ElementUtil.clickElement(Billing_ManualAdjReasonClearCommentbtn);
}
public void selectBicentennialFee(String BicentennialFeeValue) {
	ElementUtil.selectFromDropdownByVisibleText(Billing_BicentennialFeedd,BicentennialFeeValue);
}
public void selectGradeCrossingFee(String GradeCrossingFeeValue) {
	ElementUtil.selectFromDropdownByVisibleText(Billing_GradeCrossingFeedd,GradeCrossingFeeValue);
}
public void selectReplacementPlateFee(String ReplacementPlateFeeValue) {
	ElementUtil.selectFromDropdownByVisibleText(Billing_ReplacementPlateFeedd,ReplacementPlateFeeValue);
}
public void selectSecondPlateFee(String SecondPlateFeeValue) {
	ElementUtil.selectFromDropdownByVisibleText(Billing_SecondPlateFeedd,SecondPlateFeeValue);
}
public void selectLateFilingPenalty(String LateFilingPenaltyValue) {
	ElementUtil.selectFromDropdownByVisibleText(Billing_LateFilingPenaltydd,LateFilingPenaltyValue);
}
public void selectLatePayPenalty(String LatePayPenaltyValue) {
	ElementUtil.selectFromDropdownByVisibleText(Billing_LatePayPenaltydd,LatePayPenaltyValue);
}
public void selectTransferFee(String TransferFeeValue) {
	ElementUtil.selectFromDropdownByVisibleText(Billing_TransferFeedd,TransferFeeValue);
}
public void selectTransferRevenueFee(String TransferRevenueFeeValue) {
	ElementUtil.selectFromDropdownByVisibleText(Billing_TransferRevenueFeedd,TransferRevenueFeeValue);
}
public void expandFeeOverrideReason() {
	ElementUtil.clickElement(Billing_FeeOverrideReasonCollapse);
}
public void enterFeeOverrideReasonComments(String ManualadjreasonCommentsValue) {
	ElementUtil.webEditTxtChange(Billing_FeeOverrideReasonCommentstxt, ManualadjreasonCommentsValue);
}
public void clickFeeOverrideReasonDeleteAllowed() {
	ElementUtil.webCheckON(Billing_FeeOverrideReasonDeleteAllowedchk);

}
public void  clickFeeOverrideReasonAddorUpdateComments() {
	ElementUtil.clickElement(Billing_FeeOverrideReasonAddorUpdateCommentbtn);
}

public void  clickFeeOverrideReasonclearComments() {
	ElementUtil.clickElement(Billing_FeeOverrideReasonClearCommentbtn);
}

public void validateBillingtab(String textmsg) {
	Boolean a=Billing_billingtab.getText().contains(textmsg);
	if(a==true) {
		assert true;
	}
	else {
		assert false;
	}
}
public String ValidateMessage() {
	ElementUtil.clickElement(Billing_Validationmessage);
	ElementUtil.highlightElement(driver, Billing_Validationmessage);
	return ElementUtil.FetchTextBoxValuewithText(Billing_Validationmessage);
}

public String ValidateMessage2() {
	ElementUtil.highlightElement(driver, Billing_Validationmessage2);
	return ElementUtil.FetchTextBoxValuewithText(Billing_Validationmessage2);
}
public String ValidateMessage3() {
	ElementUtil.highlightElement(driver, Billing_Validationmessage3);
	return ElementUtil.FetchTextBoxValuewithText(Billing_Validationmessage3);
}

///Reinstatement
public void enterreceiptdate(String previousdate) {
	if(Billing_AppREceiptDatedtpicker.getAttribute("value").isEmpty()) {
		ElementUtil.clickElement(Billing_AppREceiptDatedtpicker);
	ElementUtil.webEditTxt(Billing_AppREceiptDatedtpicker,previousdate); }
}
public void validatesubhdr(String hdrvalue) {
	if(Billing_subhdr.getText().contains(hdrvalue))
		assert true;
}
//Fetch Values

public String fetchRegisterMonthlbl() {
	return ElementUtil.FetchTextBoxValuewithText(Billing_RegisterMonthlbl);
}

public String fetchRegisterMonth() {
	return ElementUtil.FetchTextBoxValuewithattribute(Billing_RegisterMonthtxt,"value");
}
public String fetchNoOfVehiclesinSupplbl() {
	return ElementUtil.FetchTextBoxValuewithText(Billing_NoOfVehiclesinSupplbl);
}

public String fetchNoOfVehiclesinSupp() {
	return ElementUtil.FetchTextBoxValuewithattribute(Billing_NoOfVehiclesinSupptxt,"value");
}

public String fetchSupplementStatuslbl() {
	return ElementUtil.FetchTextBoxValuewithText(Billing_SupplementStatuslbl);
}

public String fetchSupplementStatus() {
	return ElementUtil.FetchTextBoxValuewithattribute(Billing_SupplementStatustxt,"value");
}

public String fetchEnterpriseSystemCreditlbl() {
	return ElementUtil.FetchTextBoxValuewithText(Billing_EnterpriseSystemCreditlbl);
}

public String fetchEnterpriseSystemCredit() {
	return ElementUtil.FetchTextBoxValuewithattribute(Billing_EnterpriseSystemCredittxt,"value");
}

public String fetchIRPSystemCreditlbl() {
	return ElementUtil.FetchTextBoxValuewithText(Billing_IRPSystemCreditlbl);
}

public String fetchIRPSystemCredit() {
	return ElementUtil.FetchTextBoxValuewithattribute(Billing_IRPSystemCredittxt,"value");
}

public String fetchRenewalFeeEffectiveDatelbl() {
	return ElementUtil.FetchTextBoxValuewithText(Billing_RenewalFeeEffectiveDatelbl);
}

public String fetchRenewalFeeEffectiveDate() {
	return ElementUtil.FetchTextBoxValuewithattribute(Billing_RenewalFeeEffectiveDatedtPicker,"value");
}

public String fetchInvoiceDatelbl() {
	return ElementUtil.FetchTextBoxValuewithText(Billing_InvoiceDatelbl);
}

public String fetchInvoiceDate() {
	return ElementUtil.FetchTextBoxValuewithattribute(Billing_InvoiceDatedtPicker,"value");
}

public String fetchApplicationReceiptDatelbl() {
	return ElementUtil.FetchTextBoxValuewithText(Billing_ApplicationReceiptDatelbl);
}

public String fetchApplicationReceiptDate() {
	return ElementUtil.FetchTextBoxValuewithattribute(Billing_ApplicationReceiptDatedtPicker,"value");
}

public String fetchPaymentDatelbl() {
	return ElementUtil.FetchTextBoxValuewithText(Billing_PaymentDatelbl);
}

public String fetchPaymentDate() {
	return ElementUtil.FetchTextBoxValuewithattribute(Billing_PaymentDatedtPicker,"value");
}
public String fetchExchangeRatelbl() {
	return ElementUtil.FetchTextBoxValuewithText(Billing_ExchangeRatelbl);
}

public String fetchExchangeRate() {
	return ElementUtil.FetchTextBoxValuewithattribute(Billing_ExchangeRatetxt,"value");
}
public String fetchManualAdjBaseJurlbl() {
	return ElementUtil.FetchTextBoxValuewithText(Billing_ManualAdjBaseJurlbl);
}

public String fetchManualAdjBaseJur() {
	return ElementUtil.FetchTextBoxValuewithattribute(Billing_ManualAdjBaseJurtxt,"value");
}

public String fetchBilling_BatchBillinglbl() {
	return ElementUtil.FetchTextBoxValuewithText(Billing_BatchBillinglbl);
}

public String fetchBilling_BatchBilling() {
	boolean boolstatus=false;
	if(ElementUtil.FetchTextBoxValuewithattribute(Billing_BatchBillingchk,"checked")==null){
		boolstatus=false;
	}
	else {
		boolstatus=true;
	}
	return Boolean.toString(boolstatus);
}

public String fetchBilling_TVRlbl() {
	return ElementUtil.FetchTextBoxValuewithText(Billing_TVRlbl);
}

public String fetchBilling_TVR() {
	boolean boolstatus=false;
	if(ElementUtil.FetchTextBoxValuewithattribute(Billing_TVRchk,"checked")==null){
		boolstatus=false;
	}
	else {
		boolstatus=true;
	}
	return Boolean.toString(boolstatus);
}

public String fetchBilling_IsUseOneTimeMailinglbl() {
	return ElementUtil.FetchTextBoxValuewithText(Billing_IsUseOneTimeMailinglbl);
}

public String fetchBilling_IsUseOneTimeMailing() {
	boolean boolstatus=false;
	if(ElementUtil.FetchTextBoxValuewithattribute(Billing_IsUseOneTimeMailingchk,"checked")==null){
		boolstatus=false;
	}
	else {
		boolstatus=true;
	}
	return Boolean.toString(boolstatus);
}

public String fetchBilling_InstallmentPlanlbl() {
	return ElementUtil.FetchTextBoxValuewithText(Billing_InstallmentPlanlbl);
}

public String fetchBilling_InstallmentPlan() {
	boolean boolstatus=false;
	if(ElementUtil.FetchTextBoxValuewithattribute(Billing_InstallmentPlanchk,"checked")==null){
		boolstatus=false;
	}
	else {
		boolstatus=true;
	}
	return Boolean.toString(boolstatus);
}

public String fetchBilling_TVRNoOfDayslbl() {
	return ElementUtil.FetchTextBoxValuewithText(Billing_TVRNoOfDayslbl);
}

public String fetchBilling_TVRNoOfDays() {
	return ElementUtil.FetchTextBoxValuewithattribute(Billing_TVRNoOfDaystxt,"value");
}

public ArrayList<String> FetchTable_Headers() {
	ArrayList<String> Headers_array = new ArrayList<String>();
	for(int i=0;i<Billing_GridHeaders.size();i++) {
		Headers_array.add(ElementUtil.FetchTextBoxValuewithText(Billing_GridHeaders.get(i)));
	}
	return Headers_array;
}

public ArrayList<String> FetchTable_FeeType() {
	ArrayList<String> FeeType_Array = new ArrayList<String>();
	for(int i=0;i<Billing_FeeType.size();i++) {
		FeeType_Array.add(ElementUtil.FetchTextBoxValuewithattribute(Billing_FeeType.get(i),"value"));
	}
	return FeeType_Array;
}
	public ArrayList<String> FetchTable_FeeAmount() {
		ArrayList<String> FeeAmount_Array = new ArrayList<String>();
		for(int i=0;i<Billing_FeeAmount.size();i++) {
			FeeAmount_Array.add(ElementUtil.FetchTextBoxValuewithattribute(Billing_FeeAmount.get(i),"value"));
		}
		return FeeAmount_Array;
}
public String fetchElectronicDeliveryTypelbl() {
	return ElementUtil.FetchTextBoxValuewithText(Billing_ElectronicDeliveryTypelbl);
}
public String fetchElectronicDeliveryType() {
	return ElementUtil.FetchDropdownSelectedValue(Billing_ElectronicDeliveryTypedd);
}
public String fetchBilling_Email() {
	return ElementUtil.FetchTextBoxValuewithattribute(Billing_EmailIDTxt,"value");
}
public String FetchInvoiceReportTypelbl() {
	return ElementUtil.FetchTextBoxValuewithText(Billing_InvoiceReportTypelbl);
}
public String fetchBilling_InvoiceReportType() {
	return ElementUtil.FetchDropdownSelectedValue(Billing_InvoiceReportTypedd);
}

}