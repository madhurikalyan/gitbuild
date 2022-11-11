package com.celtic.automation.cmcs.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.celtic.automation.cmcs.util.ElementUtil;

public class Reinstatement {
	public WebDriver driver;
	public Reinstatement(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
/*	@FindBy(xpath="//span[text()='Account No.']") WebElement AccountNumberlbl;
	@FindBy(xpath="//input[@id='AccountNo']") WebElement AccountNumber;
	@FindBy(xpath="//span[text()='Fleet No.']") WebElement FleetNumberlbl;
	@FindBy(xpath="//input[@id='FleetNo']") WebElement FleetNumber;
	@FindBy(xpath="//span[text()='Fleet No.']") WebElement FleetNumberlbl;
	@FindBy(xpath="//input[@id='SupplementNo']") WebElement SupplementNo;
	@FindBy(xpath="//span[text()='Fleet No.']") WebElement FleetNumberlbl;
	@FindBy(xpath="//input[@id='RegistrantName']") WebElement RegistrantName;
	@FindBy(xpath="//span[text()='Fleet No.']") WebElement FleetNumberlbl;
	@FindBy(xpath="//input[@id='DBAName']") WebElement DBAName;*/

	@FindBy(xpath="//span[text()='Reporting Period From']") WebElement ReportingPeriodFromlbl;
	@FindBy(xpath="//input[@id='ReportingPeriodFrom']") WebElement ReportingPeriodFrom;
	@FindBy(xpath="//span[text()='Reporting Period To']") WebElement ReportingPeriodTolbl;
	@FindBy(xpath="//input[@id='ReportingPeriodTo']") WebElement ReportingPeriodTo;
	@FindBy(xpath="//span[text()='USDOT No.']") WebElement UsdotNbrlbl;
	@FindBy(xpath="//input[@id='UsdotNbr']") WebElement UsdotNbr;
	@FindBy(xpath="//span[text()='Avg. Per Vehicle Distance Chart']") WebElement EstimatedDistanceChartlbl;
	@FindBy(xpath="//input[@id='EstimatedDistanceChart']") WebElement EstimatedDistanceChart;
	@FindBy(xpath="//span[text()='Override Contiguous Jur.']") WebElement OverrideContJurlbl;
	@FindBy(xpath="//input[@id='OverrideContJur']") WebElement OverrideContJur;
	
	@FindBy(xpath="//span[text()='Actual Distance']") WebElement ActualDistanceGenlbl;
	@FindBy(xpath="//input[@id='ActualDistanceGen']") WebElement ActualDistanceGen;
	@FindBy(xpath="//span[text()='Estimated Distance']") WebElement FirstYearEstimatedMileagelbl;
	@FindBy(xpath="//input[@id='FirstYearEstimatedMileage']") WebElement FirstYearEstimatedMileage;
	@FindBy(xpath="//span[text()='Total Fleet Distance']") WebElement TotalFleetDistanceGenlbl;
	@FindBy(xpath="//input[@id='TotalFleetDistanceGen']") WebElement TotalFleetDistanceGen;
	@FindBy(xpath="//span[text()='Do you have actual distance for the reporting period?']") WebElement FRPMlgQuetionlbl;
	@FindBy(xpath="//input[@id='FRPMlgQuetion']") WebElement FRPMlgQuetion;
	@FindBy(xpath="//span[text()='Distance Type']") WebElement DistanceTypelbl;
	@FindBy(xpath="//input[@id='DistanceType']") WebElement DistanceType;
	@FindBy(xpath="//span[text()='We certify that the actual distance submitted is accurate']") WebElement ActualDistConfirmationlbl;
	@FindBy(xpath="//input[@id='ActualDistConfirmation']") WebElement ActualDistConfirmation;
	//Fetch Details
		public String distanceReportingPeriodFromlbl() {
			return ElementUtil.FetchTextBoxValuewithText(ReportingPeriodFromlbl);
		}

		public String distanceReportingPeriodFrom() {
			return ElementUtil.FetchTextBoxValuewithattributedisabled(ReportingPeriodFrom,"value");
		}
		public String distanceReportingPeriodTolbl() {
			return ElementUtil.FetchTextBoxValuewithText(ReportingPeriodTolbl);
		}

		public String distanceReportingPeriodTo() {
			return ElementUtil.FetchTextBoxValuewithattributedisabled(ReportingPeriodTo,"value");
		}

		public String distanceUsdotNbrlbl() {
			return ElementUtil.FetchTextBoxValuewithText(UsdotNbrlbl);
		}

		public String distanceUsdotNbr() {
			return ElementUtil.FetchTextBoxValuewithattributedisabled(UsdotNbr,"value");
		}

		public String distanceEstimatedDistanceChartlbl() {
			return ElementUtil.FetchTextBoxValuewithText(EstimatedDistanceChartlbl);
		}

		public String distanceEstimatedDistanceChart() {
			return ElementUtil.FetchTextBoxValuewithattributedisabled(EstimatedDistanceChart,"value");
		}
		public String distanceOverrideContJurlbl() {
			return ElementUtil.FetchTextBoxValuewithText(OverrideContJurlbl);
		}

		public String distanceOverrideContJur() {
			return ElementUtil.FetchTextBoxValuewithattributedisabled(OverrideContJur,"value"); 
			}

		public String distanceActualDistancelbl() {
			return ElementUtil.FetchTextBoxValuewithText(ActualDistanceGenlbl);
		}

		public String distanceActualDistance() {
			return ElementUtil.FetchTextBoxValuewithattributedisabled(ActualDistanceGen,"value");
		}

		public String distanceEstimatedDistancelbl() {
			return ElementUtil.FetchTextBoxValuewithText(FirstYearEstimatedMileagelbl);
		}

		public String distanceEstimatedDistance() {
			return ElementUtil.FetchTextBoxValuewithattributedisabled(FirstYearEstimatedMileage,"value");
		}

		public String distanceTotalFleetDistancelbl() {
			return ElementUtil.FetchTextBoxValuewithText(TotalFleetDistanceGenlbl);
		}

		public String distanceTotalFleetDistance() {
			return ElementUtil.FetchTextBoxValuewithattributedisabled(TotalFleetDistanceGen,"value");
		}

		public String distanceFRPMlgQuetionlbl() {
			return ElementUtil.FetchTextBoxValuewithText(FRPMlgQuetionlbl);
		}

		public String distanceFRPMlgQuetion() {
			return ElementUtil.FetchTextBoxValuewithattributedisabled(FRPMlgQuetion,"value");
			}
		public String distanceDistanceTypelbl() {
			return ElementUtil.FetchTextBoxValuewithText(DistanceTypelbl);
		}

		public String distanceDistanceType() {
			return ElementUtil.FetchTextBoxValuewithattributedisabled(DistanceType,"value");
		}
		public String distanceActualDistConfirmationlbl() {
			return ElementUtil.FetchTextBoxValuewithText(ActualDistConfirmationlbl);
		}

		public String distanceActualDistConfirmation() {
			return ElementUtil.FetchTextBoxValuewithattributedisabled(ActualDistConfirmation,"value");
		}


	
}
