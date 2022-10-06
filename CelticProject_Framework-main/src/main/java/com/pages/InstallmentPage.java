package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.util.ElementUtil;

public class InstallmentPage {

	
	public WebDriver driver;
	public InstallmentPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css="#contentMsg > div > ul > li:nth-child(1) > span") WebElement InstallmentPayment_Message1;
	@FindBy(css="#contentMsg > div > ul > li:nth-child(2) > span") WebElement InstallmentPayment_Message2;
	
	@FindBy(xpath="//a[@title='Installment Payment']") WebElement InstallmentPayment;
	@FindBy(xpath="//a[@id='lnkGridSelectCustomerGrid']") WebElement InstallmentPayment_Grid;

	
	public void ClickInstallmentPayment() {
		ElementUtil.clickElement(InstallmentPayment);
	}
	public void ClickGrid() {
		ElementUtil.clickElement(InstallmentPayment_Grid);
	}
	
public String ValidateMessage1() {
		ElementUtil.highlightElement(driver, InstallmentPayment_Message1);
		return ElementUtil.FetchTextBoxValuewithText(InstallmentPayment_Message1);
	}
	public String ValidateMessage2() {
		ElementUtil.highlightElement(driver, InstallmentPayment_Message2);
		return ElementUtil.FetchTextBoxValuewithText(InstallmentPayment_Message2);
		
	}

}
