package com.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.util.ElementUtil;
import com.qa.util.ExcelReader;

public class DistanceTabPage {
	
	public WebDriver driver;
	ExcelReader reader = new ExcelReader();
	public DistanceTabPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Distance Details
			@FindBy(xpath="(//div[contains(@class,'box-title')]/h4)[2]") WebElement DistanceDistanceDetailsSubhdr;
			
			@FindBy(xpath="//label[@for='ReportingPeriodFrom']") WebElement Distance_ReportingperiodFromlbl;
			@FindBy(xpath="//input[@id='ReportingPeriodFrom']") WebElement Distance_ReportingperiodFromtxt;
			
			@FindBy(xpath="//label[@for='ReportingPeriodTo']") WebElement Distance_ReportingperiodTolbl;
			@FindBy(xpath="//input[@id='ReportingPeriodTo']") WebElement Distance_ReportingperiodTotxt;
			
			@FindBy(xpath="//label[@for='UsdotNbr']") WebElement Distance_USDOTNolbl;
			@FindBy(xpath="//input[@id='UsdotNbr']") WebElement Distance_USDOTNoFromtxt;
			
			@FindBy(xpath="//label[@for='EstimatedDistanceChart']") WebElement Distance_VehicleDistanceChartlbl;
			@FindBy(xpath="//input[@id='EstimatedDistanceChart']") WebElement Distance_VehicleDistanceChartchk;
			
			@FindBy(xpath="//label[@for='OverrideContJur']") WebElement Distance_OverrideContJurlbl;
			@FindBy(xpath="//input[@id='OverrideContJur']") WebElement Distance_OverrideContJurchk;
			
			@FindBy(xpath="//label[@for='EstimatedDistance']") WebElement Distance_EstimatedDistancelbl;
			@FindBy(xpath="//input[@id='EstimatedDistance']") WebElement Distance_EstimatedDistancetxt;
			
			@FindBy(xpath="//label[@for='EstimatedDistanceGen']") WebElement Distance_EstimatedDistance1lbl;
			@FindBy(xpath="//input[@id='EstimatedDistanceGen']") WebElement Distance_EstimatedDistance1txt;
			
			@FindBy(xpath="//label[@for='ActualDistance']") WebElement Distance_ActualDistancelbl;
			@FindBy(xpath="//input[@id='ActualDistance']") WebElement Distance_ActualDistancetxt;
			
			@FindBy(xpath="//label[@for='ActualDistanceGen']") WebElement Distance_ActualDistance1lbl;
			@FindBy(xpath="//input[@id='ActualDistanceGen']") WebElement Distance_ActualDistance1txt;
			
			@FindBy(xpath="//label[@for='TotalFleetDistance']") WebElement Distance_TotalFleetDistancelbl;
			@FindBy(xpath="//input[@id='TotalFleetDistance']") WebElement Distance_TotalFleetDistancetxt;
			
			@FindBy(xpath="//label[@for='TotalFleetDistanceGen']") WebElement Distance_TotalFleetDistance1lbl;
			@FindBy(xpath="//input[@id='TotalFleetDistanceGen']") WebElement Distance_TotalFleetDistance1txt;
			
			@FindBy(xpath="//label[@for='FRPMlgQuetion']") WebElement Distance_ReportingPeriodQuestionlbl;
			@FindBy(xpath="//input[@id='FRPMlgQuetion']") List<WebElement> Distance_ReportingPeriodQuestionrd;
			
			@FindBy(xpath="//label[@for='DistanceType']") WebElement Distance_DistanceTypelbl;
			@FindBy(xpath="//select[@id='DistanceType']") WebElement Distance_DistanceTypedd;
			
			@FindBy(xpath="//label[@for='ActualDistConfirmation']") WebElement Distance_ActualDistanceQuestionlbl;
			@FindBy(xpath="//input[@id='ActualDistConfirmation']") WebElement Distance_ActualDistanceQuestionchk;
			
			@FindBy(xpath="//a[@id='showMapId']") WebElement Distance_showMaplnk;
			
			@FindBy(xpath="(//th[@class='leftAlign'])[1]") WebElement Distance_Jurisdictiontbl;
			@FindBy(xpath="(//th[@class='rightAlign'])[1]") WebElement Distance_Distancetbl;
			@FindBy(xpath="(//th[@scope='col'])[1]") WebElement Distance_percenttbl;
			
			@FindBy(xpath="//input[@id='MileageDataVMList_0__JurCode']//preceding-sibling::span") WebElement Distance_Juri0;
			@FindBy(xpath="//input[@id='MileageDataVMList_0__Mileage']") WebElement Distance_Juri0Value;
			@FindBy(xpath="//input[contains(@id,'MileageDataVMList')and contains(@id,'JurCode')]//preceding-sibling::span") List<WebElement> Distance_JurisList;
			@FindBy(xpath="//input[contains(@class,'rightAlign') and contains(@id,'MileageDataVMList')]")List<WebElement> Distance_DistanceJurisList;
			

public void selectYesOrNo(String selectvalue) {
	for(WebElement a:Distance_ReportingPeriodQuestionrd) {
		if(a.getAttribute("value").equalsIgnoreCase(selectvalue)) { //"Y" //"N"
			ElementUtil.clickElement(a);
			break;
		}
	}
}
public void enterMODistanceValue( String Juri,String DistanceValuedynamic) {
	for(int i=0;i<Distance_JurisList.size();i++) {
		if(Distance_JurisList.get(i).getText().equalsIgnoreCase(Juri)) { //"MO - MISSOURI"
			ElementUtil.webEditTxtChange(Distance_DistanceJurisList.get(i),DistanceValuedynamic);
			break;
		}
	}
}



























}
