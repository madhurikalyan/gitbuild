package com.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.qa.util.ElementUtil;

public class FleetPage {
	public WebDriver driver;
	
	@FindBy(xpath="//h3[@class='float-left']") WebElement FleetLeftHeader;  //Fleet
	@FindBy(xpath="//h3[@class='float-right']") WebElement FleetRightHeader; //Renew Fleet
	@FindBy(xpath="//div[contains(@class,'box-title')]/h4") WebElement FleetSubHeader; //Supplement
	
	//labels
	@FindBy(xpath="//label[@for='AccountNo']") WebElement FleetAccountNoLbl; 
	@FindBy(xpath="//label[@for='Can']") WebElement FleetMCECustomerNoLbl;
	@FindBy(xpath="//label[@for='FleetNbr']") WebElement FleetfltNoLbl;
	@FindBy(xpath="//label[@for='FltExpYear']") WebElement FleetfltExpYearLbl;
	
	
	@FindBy(xpath="//input[@id='AccountNo']") WebElement FleetAccountNOtxt;
	@FindBy(xpath="//input[@id='Can']") WebElement FleetMCECustomerIDtxt;
	@FindBy(xpath="//input[@id='FleetNbr']") WebElement FleetFleetNotxt;
	@FindBy(xpath="//input[@id='FltExpYear']") WebElement FleetfltExpYeartxt;
	
	@FindBy(xpath="//input[@id='btnProceed']") WebElement FleetProceedbtn;
	@FindBy(xpath="//input[@id='btnRefresh']") WebElement FleetPRefreshtn;
	@FindBy(xpath="//input[@id='btnQuit']") WebElement FleetQuitbtn;
	@FindBy(xpath="//button[@id='btnHelp']") WebElement FleetHelpbtn;
	
	@FindBy(xpath="//input[@id='FleetNo']") WebElement Supplement_FleetNo;
	@FindBy(xpath="//input[@id='FleetExpYear']") WebElement Supplement_FleetExpirationYear;
	
	@FindBy(xpath="//th[contains(@aria-label,'Account No')]") WebElement FleetGridAccountNohdr;
	@FindBy(xpath="//th[contains(@aria-label,'MCE')]") WebElement FleetGridMCECustomerNohdr;
	@FindBy(xpath="//th[contains(@aria-label,'Fleet') and contains(@aria-label,'No')]") WebElement FleetGridFleetNohdr;
	@FindBy(xpath="//th[contains(@aria-label,'Fleet') and contains(@aria-label,'Month')]") WebElement FleetGridFleetExpMonthhdr;
	@FindBy(xpath="//th[contains(@aria-label,'Fleet') and contains(@aria-label,'Year')]") WebElement FleetGridFleetExpYearhdr;
	@FindBy(xpath="//th[contains(@aria-label,'Fleet') and contains(@aria-label,'Type')]") WebElement FleetGridFleetTypehdr;
	@FindBy(xpath="//th[contains(@aria-label,'Fleet') and contains(@aria-label,'Status')]") WebElement FleetGridFleetStatushdr;
	@FindBy(xpath="(//a[@id='lnkGridSelectCustomerGrid'])[last()]") WebElement FleetGridlastHandimg;
	
	
	@FindBy(xpath="//a[@id='lnkGridSelectCustomerGrid']") WebElement FleetGridFirstHandimg;
	//Reinstatement
	@FindBy(xpath="//input[@id='LastInactiveDate']") WebElement Fleet_LastInactiveDate;
	@FindBy(xpath="//a[contains(@class,'nav-fast')]") WebElement Fleet_MonthYearhhdr;
	@FindBy(xpath="//a[contains(@class,'nav-prev')]") WebElement Fleet_Previouslnk;
	@FindBy(xpath="//a[contains(@class,'nav-nex')]") WebElement Fleet_Nextlnk;
	
	public FleetPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	public void enterAccountNo(String AccountNoValue) throws IOException {
		ElementUtil.webEditTxtChange(FleetAccountNOtxt,AccountNoValue);
	}
	public void enterFleetNo(String FleetNoValue) throws IOException {
		ElementUtil.webEditTxtChange(FleetFleetNotxt,FleetNoValue);
	}
	public void enterFleetyear(String FleetyearValue) throws IOException {
		ElementUtil.webEditTxtChange(FleetfltExpYeartxt, FleetyearValue);
	}
	public void enterFleetNo_Supplement(String FleetNoValue) throws IOException {
		ElementUtil.webEditTxtChange(Supplement_FleetNo,FleetNoValue);
	}
	public void enterFleetyear_Supplement(String FleetyearValue) throws IOException {
		ElementUtil.webEditTxtChange(Supplement_FleetExpirationYear, FleetyearValue);
	}
	public void clickproceedbtn() {
		ElementUtil.clickElement(FleetProceedbtn);
	}
	
	public void gridpresence() {
		if(ElementUtil.isPresentAndDisplayed(FleetGridAccountNohdr)) {
			if(ElementUtil.isPresentAndDisplayed(FleetGridlastHandimg)) {
				ElementUtil.clickElement(FleetGridlastHandimg);
			}
		}
	}
public void clickFirstHandimg() {
	ElementUtil.clickElement(FleetGridFirstHandimg);
}
	
//Reinstatement
public void enterlastinactivedays(String inactivedatevalue) {
	ElementUtil.clickElement(Fleet_LastInactiveDate);
	ElementUtil.webEditTxt(Fleet_LastInactiveDate, inactivedatevalue);
}	
public void clickcalendarheader() {
	ElementUtil.clickElement(Fleet_MonthYearhhdr);
}
public void clickpreviouslnk() {
	ElementUtil.clickElement(Fleet_Previouslnk);
}
public void clicknextlnk() {
	ElementUtil.clickElement(Fleet_Nextlnk);
}


}
