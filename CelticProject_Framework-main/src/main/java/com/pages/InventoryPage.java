package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.qa.util.ElementUtil;

public class InventoryPage {

	public WebDriver driver;
	public InventoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//a[@title='Operations']") WebElement DashboardOperation;
	
	@FindBy(xpath="//a[text()='Inventory']") WebElement DashboardInventory;
	
	@FindBy(xpath="//a[text()='Status Inquiry']") WebElement Inventory_StatusInventory;
	
	@FindBy(xpath="//select[@class='cancel valid']") WebElement Inventory_type;
	
	@FindBy(xpath="//select[@id='SelectedInventoryType']") WebElement Inventory_Newintype;
	
	@FindBy(id="SelectedInventorySubType") WebElement Inventory_Subtype;
	
@FindBy(xpath="//*[text()='No data available in table']") WebElement Inventory_validatemsg;
	
@FindBy(xpath="//a[text()='New Inventory']") WebElement Inventory_newinventory;
	
	@FindBy(id="FromNo") WebElement Invemtory_fromNo;
	
	@FindBy(id="NoOfIneventoriesToOrder") WebElement Inventory_Quantity;
	
	@FindBy(id="ProdExpYYYY") WebElement Inventory_year;
	
	@FindBy(xpath="//div[contains(@class,'alert-info')]") WebElement Inventory_addedmsg;
	
	@FindBy(xpath="//a[@title='Assign Inventory']") WebElement Inventory_AssignInventorylnk;
	
public void clickoperation() {
	ElementUtil.clickElement(DashboardOperation);
}
public void clickAssignInventory() {
	ElementUtil.clickElement(Inventory_AssignInventorylnk);
}
public void clickoninventory() {
	ElementUtil.clickElement(DashboardInventory);

}
public void clickoninventorystatus() {
	ElementUtil.clickElement(Inventory_StatusInventory);


}
public void selectinventorytype(String selectValue) {
	ElementUtil.selectFromDropdownByValue(Inventory_type, selectValue);


}
public void selectinventorysubtype(String selectValue) {
ElementUtil.selectFromDropdownByValue(Inventory_Subtype, selectValue);

}
public void validateinventorymsg() {
	ElementUtil.highlightElement(driver, Inventory_validatemsg);
}
public void clicknewinventory() {
	ElementUtil.clickElement(Inventory_newinventory);
}
public void selectnewinventorytype(String selectValue) {
	ElementUtil.selectFromDropdownByValue(Inventory_Newintype, selectValue);
}
public void selectnewsubinventorytype(String selectValue) {
	ElementUtil.selectFromDropdownByValue(Inventory_Subtype, selectValue);
}
public void enterfromno(String fromnoValue) {
	ElementUtil.webEditTxtChange(Invemtory_fromNo,fromnoValue);
}
public void enterquantity(String quantityvalue) {
	ElementUtil.webEditTxtChange(Inventory_Quantity,quantityvalue);
}
public void enteryear(String yearvalue) {
	ElementUtil.webEditTxtChange(Inventory_year,yearvalue);
}
public void validateaddedmsg(String msgvalue) {
ElementUtil.highlightElement(driver, Inventory_addedmsg);
if(Inventory_addedmsg.getText().contains(msgvalue))
	assert true;
}
}