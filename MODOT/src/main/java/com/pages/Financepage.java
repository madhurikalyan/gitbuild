package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.qa.util.ElementUtil;


public class Financepage {
	
	public WebDriver driver;

	public Financepage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(xpath="//a[@title='Finance']") WebElement DashboardFinancetab;
	@FindBy(xpath="//a[@title='Post Payment']") WebElement Finance_postpayment;
	@FindBy(xpath="//input[@id='AccountNo']") WebElement PostPayment_Mceid;
	@FindBy(xpath="//input[@id='btnSearch']") WebElement PostPayment_Search;
	@FindBy(xpath="//a[@id='lnkGridSelectgvPostPayment']") WebElement PostPayment_Cartid;
	
	
	//installment payment
	
	
	@FindBy(xpath="//a[@title='Services']") WebElement Installment_Service;
	@FindBy(xpath="//a[@title='IRP']") WebElement Installment_IRP;
	@FindBy(xpath="//a[@title='Installment Payment']") WebElement Installment_instalpayment;
	@FindBy(xpath="//input[@id='AccountNo']") WebElement Installment_AccountNo;
	@FindBy(xpath="//input[@id='FleetNbr']") WebElement Installment_FleetNo;
	@FindBy(xpath="//input[@id='FltExpYear']") WebElement Installment_FleetYear;
	@FindBy(xpath="//a[@id='lnkGridSelectCustomerGrid']") WebElement Installment_Grid;
	@FindBy(xpath="//select[@id='paymentVos_0__PayType']") WebElement Installment_paytype;
	@FindBy(xpath="//input[@id='paymentVos_0__PaymentAmount']") WebElement Installment_paymentcash;
	@FindBy(xpath="//select[@id='outPutModelSelect']") WebElement Intallment_Pdf;
	
	
	
	
	
	
	
	
	
	
	
public void clickfinance() {
	ElementUtil.clickElement(DashboardFinancetab);
}
	public void clickpostpayment() {
		ElementUtil.clickElement(Finance_postpayment);
	}
	
	
	public void enterMCEid(String MCEIDvalue) {
		ElementUtil.clickElement(PostPayment_Mceid);
		ElementUtil.webEditTxtChange(PostPayment_Mceid,MCEIDvalue);
	}
	
	
	public void clicksearch() {
		ElementUtil.clickElement(PostPayment_Search);
	}
	
	public void clickoncartid() {
		ElementUtil.clickElement(PostPayment_Cartid);
	}
	public void clickservice() {
		ElementUtil.clickElement(Installment_Service);
	}
	public void clickIRP() {
		ElementUtil.clickElement(Installment_IRP);
	}
	public void clickinstallmentpayment() {
		ElementUtil.clickElement(Installment_instalpayment);
	}
	public void clickandenterAccountNo(String accountnovalue) {
		ElementUtil.webEditTxtChange(Installment_AccountNo,accountnovalue);
	}
	public void clickandenterfleet(String fleetnovalue) {
		ElementUtil.webEditTxtChange(Installment_FleetNo,fleetnovalue);
	}
	public void clickandenterfleetyear(String yearvalue) {
		ElementUtil.webEditTxtChange(Installment_FleetYear,yearvalue);
	}
	public void clickgrid() {
		ElementUtil.clickElement(Installment_Grid);
	}
	public void selectpaymenttype(String selectValue) {
		ElementUtil.selectFromDropdownByVisibleText(Installment_paytype, selectValue); //Cash,Check,Certified Check,E-check,Credit Card,Wire Transfer,EFT,Enterprise System Credit,IRP System Credit,IFTA System Credit,OPA System Credit,IFTA Bond
		//ElementUtil.selectFromDropdownByValue(Installment_paytype, selectValue);
		
	}
	public void entercashamount(String installmenttypevalue) {	
	ElementUtil.webEditTxtChange(Installment_paymentcash,installmenttypevalue);
	}
	public void clickreceipt(String selectValue) {
	ElementUtil.selectFromDropdownByValue(Intallment_Pdf, selectValue);
}
}