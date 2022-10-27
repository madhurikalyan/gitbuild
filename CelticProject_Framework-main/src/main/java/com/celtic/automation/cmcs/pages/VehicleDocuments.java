package com.celtic.automation.cmcs.pages;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.celtic.automation.cmcs.util.ElementUtil;

public class VehicleDocuments {
	
	public WebDriver driver;

	public VehicleDocuments(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(xpath="//a[@title='Vehicle Documents']") WebElement Dashboard_VehicleDocuments;
	@FindBy(xpath="//th[contains(@class,'Alignment')and not(contains(@class,'disabled')) and not(contains(@class,'hidden'))]") List<WebElement> Vehicle_TableHeader1;
	@FindBy(xpath="//th[contains(@class,'Alignment sorting_disabled') and contains(@class,'mw')]") List<WebElement> Vehicle_Tableheader2;
	@FindBy(xpath="//td[not(contains(@class,'hidden'))]//select[contains(@id,'DocStatInd') and not(contains(@disabled,'true'))]") List<WebElement> VehicleDocsdd;
	@FindBy(xpath="//tr[@role='row']//td[contains(@class,'Alignment')and not(contains(@class,'hidden'))]") List<WebElement> Vehicle_rowvalues;
	@FindBy(xpath="//select[@doctype='HVUTForm2290']") List<WebElement> Vehicle_HVUTFormdd;
	@FindBy(xpath="//select[@doctype='LeaseContract']") List<WebElement> Vehicle_LeaseContractdd;
	@FindBy(xpath="//select[@doctype='TitleDocument']") List<WebElement> Vehicle_TitleDocumentdd;
	@FindBy(xpath="//select[@doctype='PlateReturn']") List<WebElement> Vehicle_PlateReturndd;
	
	public void ClickVehicledocuments() throws InterruptedException {
		ElementUtil.highlightElement(driver, Dashboard_VehicleDocuments);
		ElementUtil.clickElementUsingActions(Dashboard_VehicleDocuments);
	//	ElementUtil.clickElement(Dashboard_VehicleDocuments);
		//ElementUtil.sleepTime(2000);
	}	
	public void SelectHVUT(String HVUTValue) {
		ElementUtil.waitUntilElementsVisible(Vehicle_HVUTFormdd);
		for(int i=0;i<Vehicle_HVUTFormdd.size();i++) {
			ElementUtil.selectFromDropdownByVisibleText(Vehicle_HVUTFormdd.get(i), HVUTValue);
		}	
	}
	public void SelectLeaseContract(String HVUTValue) {
		ElementUtil.waitUntilElementsVisible(Vehicle_LeaseContractdd);
		for(int i=0;i<Vehicle_LeaseContractdd.size();i++) {
			ElementUtil.selectFromDropdownByVisibleText(Vehicle_LeaseContractdd.get(i), HVUTValue);
		}	
	}
	public void SelectTitleDocument(String HVUTValue) {
		ElementUtil.waitUntilElementsVisible(Vehicle_TitleDocumentdd);
		for(int i=0;i<Vehicle_TitleDocumentdd.size();i++) {
			ElementUtil.selectFromDropdownByVisibleText(Vehicle_TitleDocumentdd.get(i), HVUTValue);
		}	
	}
	public void SelectPlateReturn(String HVUTValue) {
		ElementUtil.waitUntilElementsVisible(Vehicle_PlateReturndd);
		for(int i=0;i<Vehicle_PlateReturndd.size();i++) {
			ElementUtil.selectFromDropdownByVisibleText(Vehicle_PlateReturndd.get(i), HVUTValue);
		}	
	}
	
	
	//Fetch Values
	public ArrayList<String> FetchTableHeader1() {
		ElementUtil.waitUntilElementsVisible(Vehicle_TableHeader1);
		ArrayList<String> Headers1_Array = new ArrayList<String>();
		for(int i=0;i<Vehicle_TableHeader1.size();i++) {
			Headers1_Array.add(ElementUtil.FetchTextBoxValuewithText(Vehicle_TableHeader1.get(i)));
		}
		return Headers1_Array;
	}
	public ArrayList<String> FetchTableHeader2() {
		ElementUtil.waitUntilElementsVisible(Vehicle_Tableheader2);
		ArrayList<String> Headers2_Array = new ArrayList<String>();
		for(int i=0;i<Vehicle_Tableheader2.size();i++) {
			Headers2_Array.add(ElementUtil.FetchTextBoxValuewithText(Vehicle_Tableheader2.get(i)));
		}
		return Headers2_Array;
	}
	public ArrayList<String> FetchTable_Rows() {
		ElementUtil.waitUntilElementsVisible(Vehicle_rowvalues);
		ArrayList<String> Row_Array = new ArrayList<String>();
		for(int i=0;i<Vehicle_rowvalues.size();i++) {
			Row_Array.add(ElementUtil.FetchTextBoxValuewithText(Vehicle_rowvalues.get(i)));
		}
		return Row_Array;
	}

	/*public void SelectLease(String LeaseValue) {
		ElementUtil.selectFromDropdownByVisibleText(VehicleDocs_Lease, LeaseValue);
	}
	public void Selecttitledocs(String TitleValue) {
		ElementUtil.selectFromDropdownByVisibleText(VehicleDocs_titledocs, TitleValue);
	}
	public void Selectplatedocs(String Platedocs) {
		ElementUtil.selectFromDropdownByVisibleText(VehicleDocs_Platedocs, Platedocs);
	}
	
	public void SelectHVUT1(String HVUTValue1) {
		ElementUtil.selectFromDropdownByVisibleText(VehicleDocs_HVUT1, HVUTValue1);
	}
	public void SelectLease1(String LeaseValue1) {
		ElementUtil.selectFromDropdownByVisibleText(VehicleDocs_Lease1, LeaseValue1);
	}
	public void Selecttitledocs1(String TitleValue1) {
		ElementUtil.selectFromDropdownByVisibleText(VehicleDocs_titledocs1, TitleValue1);
	}
	public void Selectplatedocs1(String Platedocs1) {
		ElementUtil.selectFromDropdownByVisibleText(VehicleDocs_Platedocs1, Platedocs1);
	}
	*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
