package com.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.util.ElementUtil;
import com.qa.util.ExcelReader;

public class FleetPage {
	public WebDriver driver;
	ExcelReader reader = new ExcelReader();
	
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
	
	
	
	@FindBy(xpath="//th[contains(@aria-label,'Account No')]") WebElement FleetGridAccountNohdr;
	@FindBy(xpath="//th[contains(@aria-label,'MCE')]") WebElement FleetGridMCECustomerNohdr;
	@FindBy(xpath="//th[contains(@aria-label,'Fleet') and contains(@aria-label,'No')]") WebElement FleetGridFleetNohdr;
	@FindBy(xpath="//th[contains(@aria-label,'Fleet') and contains(@aria-label,'Month')]") WebElement FleetGridFleetExpMonthhdr;
	@FindBy(xpath="//th[contains(@aria-label,'Fleet') and contains(@aria-label,'Year')]") WebElement FleetGridFleetExpYearhdr;
	@FindBy(xpath="//th[contains(@aria-label,'Fleet') and contains(@aria-label,'Type')]") WebElement FleetGridFleetTypehdr;
	@FindBy(xpath="//th[contains(@aria-label,'Fleet') and contains(@aria-label,'Status')]") WebElement FleetGridFleetStatushdr;
	@FindBy(xpath="(//a[@id='lnkGridSelectCustomerGrid'])[last()]") WebElement FleetGridlastHandimg;
	
	
	
	
	
	
	public FleetPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void validatetitle() {
		if(driver.getTitle().equalsIgnoreCase("Supplement Search -  IRP")) {
			assert true;
			System.out.println("Current screen is Supplement Search -  IRP");
		}
		else {
			assert false;
			System.out.println("Current screen is not Supplement Search -  IRP");
		}
	}
	
	public void enterAccountNo() throws IOException {
		ElementUtil.webEditTxtChange(FleetAccountNOtxt, ExcelReader.readExcel(1, 0));
	}
	public void enterFleetNo() throws IOException {
		ElementUtil.webEditTxtChange(FleetFleetNotxt, ExcelReader.readExcel(1, 1));
	}
	public void enterFleetyear() throws IOException {
		ElementUtil.webEditTxtChange(FleetfltExpYeartxt, ExcelReader.readExcel(1, 2));
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
	
	
	
	
	
}
