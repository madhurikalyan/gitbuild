package com.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.util.ElementUtil;
import com.qa.util.ExcelReader;

public class WgtGroup {
	
	
	public WebDriver driver;
	ExcelReader reader = new ExcelReader();
	public WgtGroup(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="(//div[contains(@class,'box-title')]/h4)[2]") WebElement WeightGroupListsubhdr;
	
	@FindBy(xpath="//th[contains(@class,'sorting_disabled')  and contains(text(),'No')]") WebElement Weight_WeightGroupNotbl;
	@FindBy(xpath="//th[contains(@class,'sorting_disabled')  and contains(text(),'Type')]") WebElement Weight_WeightGroupTypetbl;
	@FindBy(xpath="//th[contains(@class,'sorting_disabled')  and contains(text(),'Base')]") WebElement Weight_BaseJurisdictionWeighttbl;
	@FindBy(xpath="//th[contains(@class,'sorting_disabled')  and contains(text(),'Gross')]") WebElement Weight_MaxGrossWeighttbl;
	@FindBy(xpath="//th[contains(@class,'sorting_disabled')  and contains(text(),'Different')]") WebElement Weight_JurWithDIfferentWeightstbl;
	
	@FindBy(xpath="//input[@id='btnAddWeightGroup']") WebElement Weight_AddWeightGroupbtn;
	@FindBy(xpath="(//td[contains(@class,'leftAlign')])[2]") WebElement JurWithWeight;
	
	
	@FindBy(xpath="//table[@id='WgtGrpSelectGrid']/tbody//tr") List<WebElement> Weight_NoofRows;
	
	
	
	
	public void clickAddWeightGroup() {
		if(ElementUtil.isPresentAndDisplayed(Weight_AddWeightGroupbtn)) {
		ElementUtil.clickElement(Weight_AddWeightGroupbtn);
		}
	}
	
	public String fetchJurwithdiffWeights() {
		return ElementUtil.FetchTextBoxValuewithText(JurWithWeight);
	}
	
	public String[] validateJurisWeightsedited() {
		 String[] JurisList	=fetchJurwithdiffWeights().split("[,]", 0);
		return JurisList;
	}
	
	
	
	
	
	
	
}
