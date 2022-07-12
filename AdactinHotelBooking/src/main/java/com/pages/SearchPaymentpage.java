package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPaymentpage {
	
	
	private WebDriver driver;
	@FindBy(id="first_name") WebElement fname;
	@FindBy(id="last_name") WebElement lname;
	@FindBy(id="address") WebElement Billaddrs;
	@FindBy(id="cc_num") WebElement credcarno;
	@FindBy(id="cc_type") WebElement crecartyp;
	@FindBy(id="cc_exp_month") WebElement exmonth;
	@FindBy(id="cc_exp_year") WebElement exyr;
	@FindBy(id="cc_cvv") WebElement cvno;
	@FindBy(id="book_now") WebElement Bookbutton;
	@FindBy(xpath="//*[text()='Logout']") WebElement logout;
	
	public SearchPaymentpage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void enterfirstname(String firstname) {
		fname.sendKeys(firstname);
	}
	
	public void enterlastname(String Lastname)  {
		lname.sendKeys(Lastname);
	}
	
	public void enterbillingaddress(String Address)   {
		Billaddrs.sendKeys(Address);
	}
	
	
	public void entercreditcardnumber(String cardno)  {
		credcarno.sendKeys(cardno);
	}
	
	public void enterctreditcardtype(String cardtype)  {
		crecartyp.sendKeys(cardtype);		
	}
	
	
	public void enterexpirydatemonth(String expmonth)  {
		exmonth.sendKeys(expmonth);
	}
	
	public void enterexpirydateyear(String expyear)  {
		exyr.sendKeys(expyear);
		}
	
	public void entercvvnumber(String cvnum)   {
		cvno.sendKeys(cvnum);
		}
	
    public void clickbutton()  {
    	Bookbutton.click();
    }
    
    public void clickonlogout() {
    	logout.click();
    }

}
