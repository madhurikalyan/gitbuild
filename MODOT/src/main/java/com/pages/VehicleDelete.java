package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.util.ElementUtil;

public class VehicleDelete {
	public WebDriver driver;
	public VehicleDelete(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="(//div[contains(@class,'box-title')]/h4)[1]") WebElement AmendVehicle_SupplementDetailsSubHdr;
	@FindBy(xpath="//label[@for='NoOfDeletedVehicle']") WebElement DeleteVehicle_DeletedVehiclelbl;
	@FindBy(xpath="//input[@id='NoOfDeletedVehicle']") WebElement DeleteVehicle_DeletedVehicletxt;
	
	
	@FindBy(xpath="(//div[contains(@class,'box-title')]/h4)[2]") WebElement AmendVehicle_VehicleSearchSubHdr;
	@FindBy(xpath="//label[@for='UnitNbr']") WebElement DeleteVehicle_UnitNumberlbl;
	@FindBy(xpath="//input[@id='UnitNbr']") WebElement DeleteVehicle_UnitNumbertxt;
	
	@FindBy(xpath="//label[@for='VIN']") WebElement DeleteVehicle_VINlbl;
	@FindBy(xpath="//input[@id='VIN']") WebElement DeleteVehicle_VINtxt;
	
	@FindBy(xpath="//label[@for='PlateNbr']") WebElement DeleteVehicle_PlateNbrlbl;
	@FindBy(xpath="//input[@id='PlateNbr']") WebElement DeleteVehicle_PlateNbrtxt;
	@FindBy(xpath="//input[@id='btnFind']") WebElement DeleteVehicle_Searchbtn;
	
	@FindBy(xpath="(//div[contains(@class,'box-title')]/h4)[3]") WebElement AmendVehicle_ListOfActiveVehicleSubHdr;
	
	@FindBy(xpath="//th[@aria-label='Select']") WebElement DeleteVehicle_Selecttbl;
	@FindBy(xpath="//th[contains(@aria-label,'Unit')]") WebElement DeleteVehicle_Unittbl;
	@FindBy(xpath="//th[contains(@aria-label,'VIN')]") WebElement DeleteVehicle_VINtbl;
	@FindBy(xpath="//th[contains(@aria-label,'Plate No')]") WebElement DeleteVehicle_PlateNotbl;
	@FindBy(xpath="//th[contains(@aria-label,'Plate Status')]") WebElement DeleteVehicle_PlateStatustbl;
	@FindBy(xpath="//th[contains(@aria-label,'Inactive')]") WebElement DeleteVehicle_InactiveDatetbl;
	@FindBy(xpath="//th[contains(@aria-label,'Returned')]") WebElement DeleteVehicle_PlateReturnedDocumenttbl;
	@FindBy(xpath="//th[contains(@aria-label,'Affidavit')]") WebElement DeleteVehicle_AffidavitDocumenttbl;
	@FindBy(xpath="//th[contains(@aria-label,'Comment')]") WebElement DeleteVehicle_Commenttbl;
	@FindBy(xpath="//th[contains(@aria-label,'Waive')]") WebElement DeleteVehicle_WaiveBasejurisdictionCredittbl;
	
	
	@FindBy(xpath="//input[contains(@id,'DeletedVehicleVMList') and  contains(@id,'SelectFlag')]")List<WebElement> DeleteVehicle_CheckboxList;
	@FindBy(xpath="//select[contains(@id,'DeletedVehicleVMList') and  contains(@id,'PlateStatusFlag')]") List<WebElement> DeleteVehicle_StatusPlateList;
	@FindBy(xpath="//input[contains(@name,'DeleteDate')]") List<WebElement> DeleteVehicle_InactiveDateList;
	@FindBy(xpath="//select[contains(@id,'PlateReturnDocumentFlag')]") List<WebElement> DeleteVehicle_PlateReturnedDocumentList;
	@FindBy(xpath="//select[contains(@id,'AffidavitDoc')]") List<WebElement> DeleteVehicle_AffidavitDocList;
	@FindBy(xpath="//textarea[contains(@id,'Comment')]") List<WebElement> DeleteVehicle_CommentList;
	
	@FindBy(xpath="//input[@id='btnVehicleList']") WebElement DeleteVehicle_VehicleListbtn;
	@FindBy(xpath="//table[@id='DeleteVehicleGrid']/tbody/tr") List<WebElement> DeleteVehicle_RowinTable;
	@FindBy(xpath="//td[contains(@class,'leftAlign')]") List<WebElement> DeleteCellsinaRow;
	
	//Fetch the Row Number based on the Unit Value
	@SuppressWarnings("null")
	public  int selectRowinaTable(String Unitvalue) {
		int i;
		int j;
		//int[] arr = null;
		for(i=0;i<DeleteVehicle_RowinTable.size();i++) {
			List<WebElement>cellvalueineachrow=DeleteVehicle_RowinTable.get(i).findElements(By.xpath("//td[contains(@class,'leftAlign')]"));
			for(j=0;j<cellvalueineachrow.size();j++) {
				if(cellvalueineachrow.get(j).getText().equalsIgnoreCase(Unitvalue)) {
					break;
				}
				//arr[0]=i;
				//arr[1]=j;
			}

		}
		return i;
	}
	
	public void ClickCheckBoxFromGrid( int i) {
		ElementUtil.clickElement(DeleteVehicle_CheckboxList.get(i));
	}
	
	public void selectPlateStatus( int i,String PlateStatusValue) {
		ElementUtil.selectFromDropdownByVisibleText(DeleteVehicle_StatusPlateList.get(i),PlateStatusValue);
	}
	public void selectPlateReturnedDocument( int i,String PlateReturnedDocumentValue) {
		ElementUtil.selectFromDropdownByVisibleText(DeleteVehicle_PlateReturnedDocumentList.get(i),PlateReturnedDocumentValue);
	}
	public void selectAffidavitDocument( int i,String AffidavitDocumentValue) {
		ElementUtil.selectFromDropdownByVisibleText(DeleteVehicle_AffidavitDocList.get(i),AffidavitDocumentValue);
	}
	
	public void entercomments(int i, String commentsValue) {
		ElementUtil.webEditTxt(DeleteVehicle_CommentList.get(i), commentsValue);
	}
	
	public void clickVehicleList() {
		ElementUtil.clickElement(DeleteVehicle_VehicleListbtn);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
