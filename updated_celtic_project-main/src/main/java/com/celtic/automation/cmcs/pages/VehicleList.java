package com.celtic.automation.cmcs.pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.celtic.automation.cmcs.util.ElementUtil;

public class VehicleList {
	public WebDriver driver;
	public VehicleList(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	@FindBy(xpath="//table[@id='gvVehicleList']/tbody/tr") List<WebElement> VehicleList;


	public String fetchRequiredUnitNumber(String serviceType){
		String unitNumberTextValue=null;
		System.out.println("Total Rows size is"+VehicleList.size());
		for(int i=1;i<=VehicleList.size();i++){
			WebElement rowvalues=driver.findElement(By.xpath("//table[@id='gvVehicleList']/tbody/tr["+i+"]/td[5]"));
		//	for(int j=1;j<=rowvalues.size();j++) {
				System.out.println("fetchRequiredUnitNumber"+ElementUtil.FetchTextBoxValuewithText(rowvalues));
				String rowvalue=ElementUtil.FetchTextBoxValuewithText(rowvalues);
				if(rowvalue.contains(serviceType)) {
					//WebElement selectRow=driver.findElement(By.xpath("//table[@id='gvVehicleList']/tbody/tr["+i+"]/td[1]/a"));
					WebElement unitNumber=driver.findElement(By.xpath("//table[@id='gvVehicleList']/tbody/tr["+i+"]/td[2]"));
					System.out.println("Unit Number to cancel"+ElementUtil.FetchTextBoxValuewithText(unitNumber));
					unitNumberTextValue=ElementUtil.FetchTextBoxValuewithText(unitNumber).trim();
					//ElementUtil.clickElement(selectRow);
				}
			//}
		}
		return unitNumberTextValue;
	}



}
