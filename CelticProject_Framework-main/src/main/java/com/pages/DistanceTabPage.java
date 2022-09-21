package com.pages;

import java.util.ArrayList;
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
			
			@FindBy(xpath="//input[@id='FRPMlgQuetion' and @value='Y']") WebElement Distance_QuestionYes;
			@FindBy(xpath="//input[@id='FRPMlgQuetion' and @value='N']") WebElement Distance_QuestionNo;
			
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
			
//Reinstatement Distance Tab
			@FindBy(xpath="//a[@id='MileageBtn']") WebElement Distance_distanceTab;
			@FindBy(xpath="//h3[@class='float-left']") WebElement Distance_Reinstatesubhdr;
			
			//Distance Grid
			@FindBy(xpath="//table[@id='dtlstJurisdiction']//tr/th[not(contains(@class,'hidden'))]") List<WebElement> DistanceJurisTableHeader; //take text
			@FindBy(xpath="//input[contains(@id,'MileageDataVMList') and contains(@id,'_JurCode')]/preceding-sibling::span") List<WebElement> Distance_Juris; //take text
			@FindBy(xpath="//input[contains(@id,'MileageDataVMList') and contains(@id,'_Mileage') and not (contains(@id,'Type'))]") List<WebElement> Distance_Distance;  //text
			@FindBy(xpath="//input[contains(@id,'MileageDataVMList') and contains(@id,'Percent')]/preceding-sibling::span") List<WebElement> Distance_percent; //text
					
			
			
			
public void selectYesOrNo(String selectvalue) {
	ElementUtil.waitUntilElementsVisible(Distance_ReportingPeriodQuestionrd);
	for(WebElement a:Distance_ReportingPeriodQuestionrd) {
		if(a.getAttribute("value").equalsIgnoreCase(selectvalue)) { //"Y" //"N"
			ElementUtil.clickElement(a);
			break;
		}
	}
}
public void enterMODistanceValue( String Juri,String DistanceValuedynamic) {
	ElementUtil.waitUntilElementsVisible(Distance_JurisList);
	for(int i=0;i<Distance_JurisList.size();i++) {
		Boolean valuexists=ElementUtil.validateTextbox(Distance_DistanceJurisList.get(i));
		if(Distance_JurisList.get(i).getText().equalsIgnoreCase(Juri) && valuexists==false) { //"MO - MISSOURI"
			ElementUtil.webEditTxtChange(Distance_DistanceJurisList.get(i),DistanceValuedynamic);
			break;
		}
	}
}
public void enterEstimatedDistance(String EstimatedDistanceValue) {
	ElementUtil.webEditTxtChange(Distance_EstimatedDistancetxt,EstimatedDistanceValue);
}

//Reinstatement
public void validateDistancetab(String textmsg) {
	Boolean a=Distance_distanceTab.getText().contains(textmsg);
	if(a==true) {
		System.out.println("true");
		assert true;
	}
	else {
		System.out.println("false");
		assert false;
	}
}

public void validatesubhdr(String hdrvalue) {
	if(Distance_Reinstatesubhdr.getText().contains(hdrvalue))
		assert true;
}






//Fetch Details
public String DistanceReportingPeriodFromlbl() {
	return ElementUtil.FetchTextBoxValuewithText(Distance_ReportingperiodFromlbl);
}

public String DistanceReportingPeriodFrom() {
	return ElementUtil.FetchTextBoxValuewithattribute(Distance_ReportingperiodFromtxt,"value");
}
public String DistanceReportingPeriodTolbl() {
	return ElementUtil.FetchTextBoxValuewithText(Distance_ReportingperiodTolbl);
}

public String DistanceReportingPeriodTo() {
	return ElementUtil.FetchTextBoxValuewithattribute(Distance_ReportingperiodTotxt,"value");
}

public String DistanceUsdotNbrlbl() {
	return ElementUtil.FetchTextBoxValuewithText(Distance_USDOTNolbl);
}

public String DistanceUsdotNbr() {
	return ElementUtil.FetchTextBoxValuewithattribute(Distance_USDOTNoFromtxt,"value");
}

public String DistanceEstimatedDistanceChartlbl() {
	return ElementUtil.FetchTextBoxValuewithText(Distance_VehicleDistanceChartlbl);
}

public String DistanceEstimatedDistanceChart() {
	return ElementUtil.FetchTextBoxValuewithattribute(Distance_VehicleDistanceChartchk,"checked");
}
public String DistanceOverrideContJurlbl() {
	return ElementUtil.FetchTextBoxValuewithText(Distance_OverrideContJurlbl);
}

public String DistanceOverrideContJur() {
	return ElementUtil.FetchTextBoxValuewithattribute(Distance_OverrideContJurchk,"checked");
}

public String DistanceEstimatedDistancelbl() {
	return ElementUtil.FetchTextBoxValuewithText(Distance_EstimatedDistancelbl);
}

public String DistanceEstimatedDistance() {
	return ElementUtil.FetchTextBoxValuewithattribute(Distance_EstimatedDistancetxt,"value");
}

public String DistanceActualDistancelbl() {
	return ElementUtil.FetchTextBoxValuewithText(Distance_ActualDistancelbl);
}

public String DistanceActualDistance() {
	return ElementUtil.FetchTextBoxValuewithattribute(Distance_ActualDistancetxt,"value");
}

public String DistanceTotalFleetDistancelbl() {
	return ElementUtil.FetchTextBoxValuewithText(Distance_TotalFleetDistancelbl);
}

public String DistanceTotalFleetDistance() {
	return ElementUtil.FetchTextBoxValuewithattribute(Distance_TotalFleetDistancetxt,"value");
}

public String DistanceFRPMlgQuetionlbl() {
	return ElementUtil.FetchTextBoxValuewithText(Distance_ReportingPeriodQuestionlbl);
}

public String DistanceFRPMlgQuetion() {
	String value;
	if(!(ElementUtil.FetchTextBoxValuewithattribute(Distance_QuestionYes,"checked").isEmpty())) {
		value=ElementUtil.FetchTextBoxValuewithattribute(Distance_QuestionYes,"value"); }
	else {
		value=ElementUtil.FetchTextBoxValuewithattribute(Distance_QuestionNo,"value"); }
	return value;
}
public String DistanceDistanceTypelbl() {
	return ElementUtil.FetchTextBoxValuewithText(Distance_DistanceTypelbl);
}

public String DistanceDistanceType() {
	return ElementUtil.FetchTextBoxValuewithattribute(Distance_DistanceTypedd,"value");
}
public String DistanceActualDistConfirmationlbl() {
	return ElementUtil.FetchTextBoxValuewithText(Distance_ActualDistanceQuestionlbl);
}

public String DistanceActualDistConfirmation() {
	return ElementUtil.FetchTextBoxValuewithattribute(Distance_ActualDistanceQuestionchk,"value");
}

public ArrayList<String> FetchTableHeader() {
	ArrayList<String> Headers_Array = new ArrayList<String>();
	for(int i=0;i<DistanceJurisTableHeader.size();i++) {
		Headers_Array.add(ElementUtil.FetchTextBoxValuewithText(DistanceJurisTableHeader.get(i)));
	}
	return Headers_Array;
}
public ArrayList<String> FetchTable_Juris() {
	ArrayList<String> Juris_Array = new ArrayList<String>();
	for(int i=0;i<Distance_Juris.size();i++) {
		Juris_Array.add(ElementUtil.FetchTextBoxValuewithText(Distance_Juris.get(i)));
	}
	return Juris_Array;
}
public ArrayList<String> FetchTable_Percent() {
	ArrayList<String> Percent_Array = new ArrayList<String>();
	for(int i=0;i<Distance_percent.size();i++) {
		Percent_Array.add(ElementUtil.FetchTextBoxValuewithText(Distance_percent.get(i)));
	}
	return Percent_Array;
}
public ArrayList<String> FetchTable_DistanceMiles() {
	ArrayList<String> DistanceMiles_Array = new ArrayList<String>();
	for(int i=0;i<Distance_Distance.size();i++) {
		DistanceMiles_Array.add(ElementUtil.FetchTextBoxValuewithattribute(Distance_Distance.get(i),"value"));
	}
	return DistanceMiles_Array;
}













}
