package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchHotelpage {

	
	
	private WebDriver driver;
	@FindBy(id="location") WebElement Location;
	@FindBy(id="hotels") WebElement Hotels;
	@FindBy(id="room_type") WebElement Roomtype;

	@FindBy(id="room_nos") WebElement Norooms;
	@FindBy(id="datepick_in") WebElement Checkindate;
	@FindBy(id="datepick_out") WebElement CheckOutdate;

	@FindBy(id="adult_room") WebElement Adultno;
	@FindBy(id="child_room") WebElement Childrenperno;
	@FindBy(id="Submit") WebElement Search;

	@FindBy(id="radiobutton_0") WebElement Select;
	@FindBy(id="continue") WebElement cont;
	
	public SearchHotelpage(WebDriver driver) {
	this.driver = driver;	
	PageFactory.initElements(driver, this);
}
	

public String getsearchhotel() {
	return driver.getTitle();
	}
public void fillContactUsForm(String lction, String Hotel, String RoomTyp, String NoofRooms, String CheckIndate,
		String CheckOutDate, String Aultsperroom, String Childrenperroom) {
	Location.sendKeys(lction);
	Hotels.sendKeys(Hotel);
	Roomtype.sendKeys(RoomTyp);
	Norooms.sendKeys(NoofRooms);
	Checkindate.sendKeys(CheckIndate);
	CheckOutdate.sendKeys(CheckOutDate);
	Adultno.sendKeys(Aultsperroom);
	Childrenperno.sendKeys(Childrenperroom);
	}

        public void clickOnSearch(){
        	Search.click();
}
        
        public void clickonsearch() {
        	Select.click();
    	}
    	
    	public void clickoncontinue() {
    		cont.click();
    	}
}
