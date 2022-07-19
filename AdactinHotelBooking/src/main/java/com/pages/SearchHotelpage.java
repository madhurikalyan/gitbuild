package com.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.util.ElementUtil;

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
	ElementUtil.webEditTxt(Location, lction,Duration.ofSeconds(100));
	ElementUtil.webEditTxt(Hotels, Hotel,Duration.ofSeconds(100));
	ElementUtil.webEditTxt(Roomtype, RoomTyp,Duration.ofSeconds(100));
	ElementUtil.webEditTxt(Norooms, NoofRooms,Duration.ofSeconds(100));
	ElementUtil.webEditTxt(Checkindate, CheckIndate,Duration.ofSeconds(100));
	ElementUtil.webEditTxt(CheckOutdate, CheckOutDate,Duration.ofSeconds(100));
	ElementUtil.webEditTxt(Adultno, Aultsperroom,Duration.ofSeconds(100));
	ElementUtil.webEditTxt(Childrenperno, Childrenperroom,Duration.ofSeconds(100));
	/*Location.sendKeys(lction);
	Hotels.sendKeys(Hotel);
	Roomtype.sendKeys(RoomTyp);
	Norooms.sendKeys(NoofRooms);
	Checkindate.sendKeys(CheckIndate);
	CheckOutdate.sendKeys(CheckOutDate);
	Adultno.sendKeys(Aultsperroom);
	Childrenperno.sendKeys(Childrenperroom);*/
	}

        public void clickOnSearch(){
        	ElementUtil.clickElement(Search, Duration.ofSeconds(100));
        	//Search.click();
}

        public void clickonsearch() {
        	ElementUtil.clickElement(Select, Duration.ofSeconds(100));
        	//Select.click();
    	}

    	public void clickoncontinue() {
    		ElementUtil.clickElement(cont, Duration.ofSeconds(100));
    		//cont.click();
    	}
}
