package com.celtic.automation.cmcs.pages;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.celtic.automation.cmcs.util.ElementUtil;

public class WgtGroup {
	
	
	public WebDriver driver;
	public WgtGroup(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css = "#contentMsg > div > ul > li > span") WebElement Weight_Verificationmsg;
	
	@FindBy(xpath="(//div[contains(@class,'box-title')]/h4)[2]") WebElement WeightGroupListsubhdr;
	
	@FindBy(xpath="//th[contains(@class,'sorting_disabled')  and contains(text(),'No')]") WebElement Weight_WeightGroupNotbl;
	@FindBy(xpath="//th[contains(@class,'sorting_disabled')  and contains(text(),'Type')]") WebElement Weight_WeightGroupTypetbl;
	@FindBy(xpath="//th[contains(@class,'sorting_disabled')  and contains(text(),'Base')]") WebElement Weight_BaseJurisdictionWeighttbl;
	@FindBy(xpath="//th[contains(@class,'sorting_disabled')  and contains(text(),'Gross')]") WebElement Weight_MaxGrossWeighttbl;
	@FindBy(xpath="//th[contains(@class,'sorting_disabled')  and contains(text(),'Different')]") WebElement Weight_JurWithDIfferentWeightstbl;
	
	@FindBy(xpath="//input[@id='btnAddWeightGroup']") WebElement Weight_AddWeightGroupbtn;
	@FindBy(xpath="(//td[contains(@class,'leftAlign')])[2]") WebElement JurWithWeight;
	
	@FindBy(xpath="(//a[@id='lnkGridSelectWgtGrpSelectGrid'])[1]") WebElement FleetGridFirstHandimg;
	
@FindBy(xpath="//table[@id='WgtGrpSelectGrid']/tbody//tr") List<WebElement> Weight_NoofRows;
	
	
	@FindBy(xpath="//tr[@role='row']/th[not (contains(@class,'hidden'))]") List<WebElement> Weight_TableHeader;
	@FindBy(xpath="//tr[@role='row']/td[not (contains(@class,'hidden'))]") List<WebElement> Weight_TableRows;
	
	public void clickHandimg() {
		if(ElementUtil.isPresentAndDisplayed(FleetGridFirstHandimg)) {
			ElementUtil.clickElement(FleetGridFirstHandimg);
			}	
	}
	
	public void clickAddWeightGroup() {
		if(ElementUtil.isPresentAndDisplayed(Weight_AddWeightGroupbtn)) {
		ElementUtil.clickElement(Weight_AddWeightGroupbtn);
		}
	}
	
	public String fetchJurwithdiffWeights() {
		return ElementUtil.FetchTextBoxValuewithText(JurWithWeight);
	}
	
	public String[] validateJurisWeightsedited() {
		return fetchJurwithdiffWeights().split("[,]", 0);
	}
	
	
	public ArrayList<String> FetchTableHeader() {
		ElementUtil.waitUntilElementsVisible(Weight_TableHeader);
		ArrayList<String>Headers_Array =new ArrayList<String>();
		for(int i=0;i<Weight_TableHeader.size();i++) {
			Headers_Array.add(ElementUtil.FetchTextBoxValuewithText(Weight_TableHeader.get(i)));
		}
		return Headers_Array;
	}
	
	public ArrayList<String> FetchTableRowData() {
		ElementUtil.waitUntilElementsVisible(Weight_TableRows);
		ArrayList<String>RowData_Array =new ArrayList<String>();
		for(int i=0;i<Weight_TableRows.size();i++) {
			RowData_Array.add(ElementUtil.FetchTextBoxValuewithText(Weight_TableRows.get(i)));
		}
		return RowData_Array;
	}
	
public String WeightValidatemessage() {
		ElementUtil.highlightElement(driver, Weight_Verificationmsg);
		return ElementUtil.FetchTextBoxValuewithText(Weight_Verificationmsg);
	}	
	
}
