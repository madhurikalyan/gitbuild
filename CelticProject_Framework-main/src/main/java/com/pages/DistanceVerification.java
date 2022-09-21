package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.util.ElementUtil;

public class DistanceVerification {
	public WebDriver driver;
	public DistanceVerification(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@id='AccountNo']//parent::div/preceding-sibling::div/span") WebElement DistanceNbrlbl;
	@FindBy(xpath="//input[@id='AccountNo']") WebElement DistanceNbr;
	
	@FindBy(xpath="//input[@id='MCECustomerID']//parent::div/preceding-sibling::div/span") WebElement AccountMCECustomerIDlbl;
	@FindBy(xpath="//input[@id='MCECustomerID']") WebElement AccountMCECustomerID;
	
	@FindBy(xpath="//input[@id='FleetNo']//parent::div/preceding-sibling::div/span") WebElement FleetNbrlbl;
	@FindBy(xpath="//input[@id='FleetNo']") WebElement FleetNbr;
	
	@FindBy(xpath="//input[@id='SupplementNo']//parent::div/preceding-sibling::div/span") WebElement DistanceSupplementNbrlbl;
	@FindBy(xpath="//input[@id='SupplementNo']") WebElement DistanceSupplementNbr;
	@FindBy(xpath="//input[@id='RegistrantName']//parent::div/preceding-sibling::div/span") WebElement DistanceLegalNamelbl;
	@FindBy(xpath="//input[@id='RegistrantName']") WebElement DistanceLegalName;
	
	@FindBy(xpath="//input[@id='DBAName']//parent::div/preceding-sibling::div/span") WebElement DistanceDBANamelbl;
	@FindBy(xpath="//input[@id='DBAName']") WebElement DistanceDBAName;
	
	@FindBy(xpath="//input[@id='CMVFleetType']//parent::div/preceding-sibling::div/span") WebElement DistanceFleetTypelbl;
	@FindBy(xpath="//input[@id='CMVFleetType']") WebElement DistanceFleetType;
	@FindBy(xpath="//input[@id='FleetEffDate']//parent::div/preceding-sibling::div/span") WebElement DistanceFleetEffectiveDatelbl;
	@FindBy(xpath="//input[@id='FleetEffDate']") WebElement DistanceFleetEffectiveDate;
	@FindBy(xpath="//input[@id='FltExpMonth']//parent::div/preceding-sibling::div/span") WebElement DistanceFleetExpiryMonthYearlbl;
	@FindBy(xpath="//input[@id='FltExpMonth']") WebElement DistanceFleetExpiryMonth;
	@FindBy(xpath="//input[@id='FltExpYear']") WebElement DistanceFleetExpiryyear;
	
	@FindBy(xpath="//input[@id='SupplementDesc']//parent::div/preceding-sibling::div/span") WebElement DistanceSupplementDesclbl;
	@FindBy(xpath="//input[@id='SupplementDesc']") WebElement DistanceSupplementDesc;
	
	//Distance Details
	@FindBy(xpath="//input[@id='ReportingPeriodFrom']//parent::div/preceding-sibling::div/span") WebElement DistanceReportingPeriodFromlbl;
	@FindBy(xpath="//input[@id='ReportingPeriodFrom']") WebElement DistanceReportingPeriodFrom;
	@FindBy(xpath="//input[@id='ReportingPeriodTo']//parent::div/preceding-sibling::div/span") WebElement DistanceReportingPeriodTolbl;
	@FindBy(xpath="//input[@id='ReportingPeriodTo']") WebElement DistanceReportingPeriodTo;
	@FindBy(xpath="//input[@id='UsdotNbr']//parent::div/preceding-sibling::div/span") WebElement DistanceUsdotNbrlbl;
	@FindBy(xpath="//input[@id='UsdotNbr']") WebElement DistanceUsdotNbr;
	@FindBy(xpath="//input[@id='EstimatedDistanceChart']//parent::div/preceding-sibling::div/span") WebElement DistanceEstimatedDistanceChartlbl;
	@FindBy(xpath="//input[@id='EstimatedDistanceChart']") WebElement DistanceEstimatedDistanceChart;
	@FindBy(xpath="//input[@id='OverrideContJur']//parent::div/preceding-sibling::div/span") WebElement DistanceOverrideContJurlbl;
	@FindBy(xpath="//input[@id='OverrideContJur']") WebElement DistanceOverrideContJurFrom;
	@FindBy(xpath="//input[@id='ActualDistanceGen']//parent::div/preceding-sibling::div/span") WebElement DistanceActualDistanceGenlbl;
	@FindBy(xpath="//input[@id='ActualDistanceGen']") WebElement DistanceActualDistanceGen;
	@FindBy(xpath="//input[@id='FirstYearEstimatedMileage']//parent::div/preceding-sibling::div/span") WebElement DistanceFirstYearEstimatedMileagelbl;
	@FindBy(xpath="//input[@id='FirstYearEstimatedMileage']") WebElement DistanceFirstYearEstimatedMileage;
	@FindBy(xpath="//input[@id='TotalFleetDistanceGen']//parent::div/preceding-sibling::div/span") WebElement DistanceTotalFleetDistanceGenlbl;
	@FindBy(xpath="//input[@id='TotalFleetDistanceGen']") WebElement DistanceTotalFleetDistanceGen;
	@FindBy(xpath="//input[@id='FRPMlgQuetion']//parent::div/preceding-sibling::div/span") WebElement DistanceFRPMlgQuetionlbl;
	@FindBy(xpath="//input[@id='FRPMlgQuetion']") WebElement DistanceFRPMlgQuetion;
	@FindBy(xpath="//input[@id='DistanceType']//parent::div/preceding-sibling::div/span") WebElement DistanceDistanceTypelbl;
	@FindBy(xpath="//input[@id='DistanceType']") WebElement DistanceDistanceType;
	@FindBy(xpath="//input[@id='ActualDistConfirmation']//parent::div/preceding-sibling::div/span") WebElement DistanceActualDistConfirmationlbl;
	@FindBy(xpath="//input[@id='ActualDistConfirmation']") WebElement DistanceActualDistConfirmation;
	
	@FindBy(xpath="//table[@id='dtlstJurisdiction']//tr/th[not(contains(@class,'hidden'))]") List<WebElement> DistanceJurisTableHeader; //take text
	@FindBy(xpath="//input[contains(@id,'MileageDataVMList') and contains(@id,'_JurCode')]/preceding-sibling::span") List<WebElement> Distance_Juris; //take text
	@FindBy(xpath="//input[contains(@id,'MileageDataVMList') and contains(@id,'_Mileage') and not (contains(@id,'Type'))]/preceding-sibling::span") List<WebElement> Distance_Distance;  //text
	@FindBy(xpath="//input[contains(@id,'MileageDataVMList') and contains(@id,'Percent')]/preceding-sibling::span") List<WebElement> Distance_percent; //text
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public ArrayList<String> FetchTableHeader() {
		ArrayList<String> Headers_Array = new ArrayList<String>();
		for(int i=0;i<DistanceJurisTableHeader.size();i++) {
			//System.out.print("check is"+ElementUtil.FetchTextBoxValuewithText(DistanceJurisTableHeader.get(i)));
			Headers_Array.add(ElementUtil.FetchTextBoxValuewithText(DistanceJurisTableHeader.get(i)));
			//Headers_Array.add(i,ElementUtil.FetchTextBoxValuewithText(DistanceJurisTableHeader.get(i)));
		//System.out.print("Array is"+Headers_Array);
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
			DistanceMiles_Array.add(ElementUtil.FetchTextBoxValuewithText(Distance_Distance.get(i)));
		}
		return DistanceMiles_Array;
	}
	public String fetchAccountnolbl() {
		return ElementUtil.FetchTextBoxValuewithText(DistanceNbrlbl);
	}

	public String fetchAccountno() {
		return ElementUtil.FetchTextBoxValuewithattribute(DistanceNbr,"value");
	}
	public String FleetNbrlbl() {
		return ElementUtil.FetchTextBoxValuewithText(FleetNbrlbl);
	}

	public String FleetNbr() {
		return ElementUtil.FetchTextBoxValuewithattribute(FleetNbr,"value");
	}

	public String DistanceSupplementNbrlbl() {
		return ElementUtil.FetchTextBoxValuewithText(DistanceSupplementNbrlbl);
	}

	public String DistanceSupplementNbr() {
		return ElementUtil.FetchTextBoxValuewithattribute(DistanceSupplementNbr,"value");
	}

	public String DistanceLegalNamelbl() {
		return ElementUtil.FetchTextBoxValuewithText(DistanceLegalNamelbl);
	}

	public String DistanceLegalName() {
		return ElementUtil.FetchTextBoxValuewithattribute(DistanceLegalName,"value");
	}
	public String DistanceDBANamelbl() {
		return ElementUtil.FetchTextBoxValuewithText(DistanceDBANamelbl);
	}

	public String DistanceDBAName() {
		return ElementUtil.FetchTextBoxValuewithattribute(DistanceDBAName,"value");
	}

	public String DistanceFleetEffectiveDatelbl() {
		return ElementUtil.FetchTextBoxValuewithText(DistanceFleetEffectiveDatelbl);
	}

	public String DistanceFleetEffectiveDate() {
		return ElementUtil.FetchTextBoxValuewithattribute(DistanceFleetEffectiveDate,"value");
	}

	public String DistanceFleetExpiryMonthYearlbl() {
		return ElementUtil.FetchTextBoxValuewithText(DistanceFleetExpiryMonthYearlbl);
	}

	public String DistanceFleetExpiryMonth() {
		return ElementUtil.FetchTextBoxValuewithattribute(DistanceFleetExpiryMonth,"value");
	}
	public String DistanceFleetExpiryyear() {
		return ElementUtil.FetchTextBoxValuewithattribute(DistanceFleetExpiryyear,"value");
	}
	public String DistanceSupplementDesclbl() {
		return ElementUtil.FetchTextBoxValuewithText(DistanceSupplementDesclbl);
	}

	public String DistanceSupplementDesc() {
		return ElementUtil.FetchTextBoxValuewithattribute(DistanceSupplementDesc,"value");
	}


	public String DistanceReportingPeriodFromlbl() {
		return ElementUtil.FetchTextBoxValuewithText(DistanceReportingPeriodFromlbl);
	}

	public String DistanceReportingPeriodFrom() {
		return ElementUtil.FetchTextBoxValuewithattribute(DistanceReportingPeriodFrom,"value");
	}
	public String DistanceReportingPeriodTolbl() {
		return ElementUtil.FetchTextBoxValuewithText(DistanceReportingPeriodTolbl);
	}

	public String DistanceReportingPeriodTo() {
		return ElementUtil.FetchTextBoxValuewithattribute(DistanceReportingPeriodTo,"value");
	}

	public String DistanceUsdotNbrlbl() {
		return ElementUtil.FetchTextBoxValuewithText(DistanceUsdotNbrlbl);
	}

	public String DistanceUsdotNbr() {
		return ElementUtil.FetchTextBoxValuewithattribute(DistanceUsdotNbr,"value");
	}

	public String DistanceEstimatedDistanceChartlbl() {
		return ElementUtil.FetchTextBoxValuewithText(DistanceEstimatedDistanceChartlbl);
	}

	public String DistanceEstimatedDistanceChart() {
		return ElementUtil.FetchTextBoxValuewithattribute(DistanceEstimatedDistanceChart,"value");
	}
	public String DistanceOverrideContJurlbl() {
		return ElementUtil.FetchTextBoxValuewithText(DistanceOverrideContJurlbl);
	}

	public String DistanceOverrideContJurFrom() {
		return ElementUtil.FetchTextBoxValuewithattribute(DistanceOverrideContJurFrom,"value");
	}

	public String DistanceActualDistanceGenlbl() {
		return ElementUtil.FetchTextBoxValuewithText(DistanceActualDistanceGenlbl);
	}

	public String DistanceActualDistanceGen() {
		return ElementUtil.FetchTextBoxValuewithattribute(DistanceActualDistanceGen,"value");
	}
	public String DistanceFirstYearEstimatedMileagelbl() {
		return ElementUtil.FetchTextBoxValuewithText(DistanceFirstYearEstimatedMileagelbl);
	}

	public String DistanceFirstYearEstimatedMileage() {
		return ElementUtil.FetchTextBoxValuewithattribute(DistanceFirstYearEstimatedMileage,"value");
	}
	public String DistanceTotalFleetDistanceGenlbl() {
		return ElementUtil.FetchTextBoxValuewithText(DistanceTotalFleetDistanceGenlbl);
	}

	public String DistanceTotalFleetDistanceGen() {
		return ElementUtil.FetchTextBoxValuewithattribute(DistanceTotalFleetDistanceGen,"value");
	}

	public String DistanceFRPMlgQuetionlbl() {
		return ElementUtil.FetchTextBoxValuewithText(DistanceFRPMlgQuetionlbl);
	}

	public String DistanceFRPMlgQuetion() {
		return ElementUtil.FetchTextBoxValuewithattribute(DistanceFRPMlgQuetion,"value");
	}

	public String DistanceDistanceTypelbl() {
		return ElementUtil.FetchTextBoxValuewithText(DistanceDistanceTypelbl);
	}

	public String DistanceDistanceType() {
		return ElementUtil.FetchTextBoxValuewithattribute(DistanceDistanceType,"value");
	}
	public String DistanceActualDistConfirmationlbl() {
		return ElementUtil.FetchTextBoxValuewithText(DistanceActualDistConfirmationlbl);
	}

	public String DistanceActualDistConfirmation() {
		return ElementUtil.FetchTextBoxValuewithattribute(DistanceActualDistConfirmation,"value");
	}










}
