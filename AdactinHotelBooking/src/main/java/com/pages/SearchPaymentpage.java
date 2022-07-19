package com.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.util.ElementUtil;

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
		ElementUtil.webEditTxtChange(fname, firstname);
		//fname.sendKeys(firstname);
	}

	public void enterlastname(String Lastname)  {
		ElementUtil.webEditTxtChange(lname, Lastname);
		//lname.sendKeys(Lastname);
	}

	public void enterbillingaddress(String Address)   {
		ElementUtil.webEditTxtChange(Billaddrs, Address);
		//Billaddrs.sendKeys(Address);
	}


	public void entercreditcardnumber(String cardno)  {
		ElementUtil.webEditTxtChange(credcarno,cardno);
	//	credcarno.sendKeys(cardno);
	}

	public void enterctreditcardtype(String cardtype)  {
		ElementUtil.webEditTxt(crecartyp, cardtype, Duration.ofSeconds(100));
		//crecartyp.sendKeys(cardtype);
	}


	public void enterexpirydatemonth(String expmonth)  {
		ElementUtil.webEditTxt(exmonth, expmonth, Duration.ofSeconds(100));
		//exmonth.sendKeys(expmonth);
	}

	public void enterexpirydateyear(String expyear)  {
		ElementUtil.webEditTxt(exyr, expyear, Duration.ofSeconds(100));
		//exyr.sendKeys(expyear);
		}

	public void entercvvnumber(String cvnum)   {
		ElementUtil.webEditTxtChange(cvno, cvnum);
		//cvno.sendKeys(cvnum);
		}

    public void clickbutton()  {
    	ElementUtil.clickElement(Bookbutton, Duration.ofSeconds(100));
    	//Bookbutton.click();
    }

    public void clickonlogout() {
    	ElementUtil.clickElement(logout, Duration.ofSeconds(100));
    	//logout.click();
    }

}

