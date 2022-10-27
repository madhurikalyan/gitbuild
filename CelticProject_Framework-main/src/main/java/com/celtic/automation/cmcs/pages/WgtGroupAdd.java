package com.celtic.automation.cmcs.pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.celtic.automation.cmcs.util.ElementUtil;

public class WgtGroupAdd {

	public WebDriver driver;
	public WgtGroupAdd(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//div[contains(@class,'box-title')]/h4)[1]") WebElement AddWgtGroup_SupplementDetailsSubHdr;
	@FindBy(xpath="//label[@for='WgtGroupType']") WebElement AddWgtGroup_WeightGroupTypelbl;
	@FindBy(xpath="//select[@id='WgtGroupType']") WebElement AddWgtGroup_WeightGroupTypedd;
	
	@FindBy(xpath="//label[@for='WgtGroupNo']") WebElement AddWgtGroup_WeightGroupNolbl;
	@FindBy(xpath="//input[@id='WgtGroupNo']") WebElement AddWgtGroup_WeightGroupNotxt;
	
	@FindBy(xpath="//label[@for='MaxGrossWeight']") WebElement AddWgtGroup_MaxGrossWeightlbl;
	@FindBy(xpath="//select[@id='MaxGrossWeight']") WebElement AddWgtGroup_MaxGrossWeightdd;
	
	@FindBy(xpath="//label[@for='WgtGroupNoOld']") WebElement AddWgtGroup_CopyFromWeightlbl;
	@FindBy(xpath="//input[@id='WgtGroupNoOld']") WebElement AddWgtGroup_CopyFromWeighttxt;
	@FindBy(xpath="//input[@id='btnCopyFrom']") WebElement AddWgtGroup_CopyFrombtn;
	
	
	
	@FindBy(xpath="(//div[contains(@class,'box-title')]/h4)[2]") WebElement AddWgtGroup_ListOfJurandWeightSubHdr;
@FindBy(xpath="//input[contains(@id,'WeightList') and contains(@id,'WeightQ')]") List<WebElement> AddWgtGroup_Weighttxt;
	
	
	@FindBy(xpath="//input[@id='btnGoToWeightGroupSelection']") WebElement AddWgtGroup_GoToWeightGroupSelectionbtn;
	@FindBy(xpath="//input[@id='btnDeleteWeightGroup']") WebElement AddWgtGroup_DeleteWeightGroupbtn;
	@FindBy(xpath="//input[contains(@id,'Juris')]/preceding-sibling::span") List<WebElement> EditWgtGroup_JurisList;
	@FindBy(xpath="//input[contains(@id,'WeightQ')]") List<WebElement> EditWgtGroup_Weighttxt;
	
	
	
	public void selectWeightGroupType(String WeightGroupTypeValue) {
		ElementUtil.selectFromDropdownByVisibleText(AddWgtGroup_WeightGroupTypedd, WeightGroupTypeValue);  //B - BUS  P - POWER UNIT T - TRAILER
	
	}
	
	
	public void enterWeightGroupNo(String WeightGroupNoValue) {
		ElementUtil.webEditTxtChange(AddWgtGroup_WeightGroupNotxt, WeightGroupNoValue);
	}
	public void selectMaxGrossWeight(String MaxGrossWeightValue) {
		ElementUtil.selectFromDropdownByVisibleText(AddWgtGroup_MaxGrossWeightdd, MaxGrossWeightValue);  //B - BUS  P - POWER UNIT T - TRAILER
	}
	
	
	public void clickGoToWeightGroupSelection() {
		ElementUtil.clickElement(AddWgtGroup_GoToWeightGroupSelectionbtn);
	}
	public void clickDeleteWeightGroup() {
		ElementUtil.clickElement(AddWgtGroup_DeleteWeightGroupbtn);
	}
	
	
	public void enterWeight_JuriValue( String Juri) {
		ElementUtil.waitUntilElementsVisible(EditWgtGroup_JurisList);
		int GrossWeightint =Integer.valueOf(FetchMaxGrossWeight());
		
		//MO,AL,AR,AZ,CA,CO,CT,DC
		for(int i=0;i<EditWgtGroup_JurisList.size();i++) {
			if(ElementUtil.FetchTextBoxValuewithText(EditWgtGroup_JurisList.get(i)).equalsIgnoreCase(Juri)) { //"MO - MISSOURI"
				ElementUtil.webEditTxtChange(EditWgtGroup_Weighttxt.get(i),String.valueOf(GrossWeightint-1));
				break;
			}
		}
	}
	public void enterAllWeightValue(String DistanceValuedynamic) {
		ElementUtil.waitUntilElementsVisible(EditWgtGroup_Weighttxt);
		for(int i=0;i<EditWgtGroup_Weighttxt.size();i++) {
				ElementUtil.webEditTxtChange(EditWgtGroup_Weighttxt.get(i),DistanceValuedynamic);
		}
	}
		public String FetchMaxGrossWeight() {
			String GrossWeight=	ElementUtil.FetchDropdownSelectedValue(AddWgtGroup_MaxGrossWeightdd);
		return GrossWeight;	
		}
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

