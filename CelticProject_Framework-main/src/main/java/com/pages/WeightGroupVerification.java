package com.pages;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.qa.util.ElementUtil;

public class WeightGroupVerification {
	public WebDriver driver;
	public WeightGroupVerification(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//table[@id='WgtGrpSelectGrid']/tbody//tr") List<WebElement> Weight_NoofRows;
	
	
	@FindBy(xpath="//tr[@role='row']/th[not (contains(@class,'hidden'))]") List<WebElement> Weight_TableHeader;
	@FindBy(xpath="//tr[@role='row']/td[not (contains(@class,'hidden'))]") List<WebElement> Weight_TableRows;
	
	
	public ArrayList<String> FetchTableHeader() {
		ArrayList<String>Headers_Array =new ArrayList<String>();
		for(int i=0;i<Weight_TableHeader.size();i++) {
			Headers_Array.add(ElementUtil.FetchTextBoxValuewithText(Weight_TableHeader.get(i)));
		}
		return Headers_Array;
	}
	
	public ArrayList<String> FetchTableRowData() {
		ArrayList<String>RowData_Array =new ArrayList<String>();
		for(int i=0;i<Weight_TableRows.size();i++) {
			RowData_Array.add(ElementUtil.FetchTextBoxValuewithText(Weight_TableRows.get(i)));
		}
		return RowData_Array;
	}
	
}
