package com.pages;



import java.io.IOException;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.qa.util.ElementUtil;
import com.qa.util.ExcelReader;


public class AddressPage {
	
	ExcelReader reader = new ExcelReader();
	public WebDriver driver;
	public AddressPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(id="nav-signin-tooltip")
	private WebElement loginBtn;

	/*
@FindBy(xpath="")
private List<WebElement> addressList;
*/
@FindBy(id="ap_email")
private WebElement email;
@FindBy(id="continue")
private WebElement cont;
@FindBy (id="ap_password")
private WebElement password;
@FindBy (id="signInSubmit")
private WebElement sigin;
@FindBy (id="nav-link-accountList")
private WebElement accountandlist;
@FindBy (xpath="//*[text()='Your addresses']")
private WebElement youraddress;
@FindBy (id="ya-myab-plus-address-icon")
private WebElement addaddress;
@FindBy (id="address-ui-widgets-enterAddressFullName")
private WebElement validatefullname;
@FindBy (id="address-ui-widgets-enterAddressPhoneNumber")
private WebElement validatePhonenumber;
@FindBy (id="address-ui-widgets-enterAddressLine1")
private WebElement validateAddressline;
@FindBy (id="address-ui-widgets-enterAddressCity")
private WebElement validateCity;
@FindBy (id="address-ui-widgets-form-submit-button")
private WebElement validateState;
@FindBy (id="address-ui-widgets-enterAddressStateOrRegion")
private WebElement saveaddress;
@FindBy (id="address-ui-widgets-enterAddressFullName")
private WebElement fullname;
@FindBy (id="address-ui-widgets-enterAddressPhoneNumber")
private WebElement phonenumber;
@FindBy (id="address-ui-widgets-enterAddressLine1")
private WebElement addressline;
@FindBy (id="address-ui-widgets-enterAddressCity")
private WebElement city;
@FindBy (id="address-ui-widgets-enterAddressStateOrRegion-dropdown-nativeId")
private WebElement state;
@FindBy (id="address-ui-widgets-enterAddressPostalCode")
private WebElement Zipcode;
@FindBy (id="address-ui-widgets-form-submit-button")
private WebElement addresssave;

@FindBy(xpath="//div[contains(text(),'Please enter an address.')]")
private WebElement addressErrorMsgLbl;


@FindBy(xpath="//div[text()='Please enter a city name.']")
private WebElement cityErrorMsgLbl;

@FindBy(xpath="//div[text()='Please enter a state, region, or province.']")
private WebElement stateErrorMsgLbl;

@FindBy(xpath="//div[text()='Please enter a ZIP or postal code.']")
private WebElement zipCodeErrorMsgLbl;
@FindBy(xpath="//span[text()='Add address']/preceding-sibling::input")
private WebElement addAddressBtn;

public void clickOnAddAddressButton() {
	ElementUtil.clickElement(addAddressBtn);
}


public void isAddressErrorMsgDisplayed() {
	
	Assert.assertTrue( ElementUtil.isPresentAndDisplayed(addressErrorMsgLbl));
}


public void isCityErrorMsgDisplayed() {
	
	Assert.assertTrue( ElementUtil.isPresentAndDisplayed(cityErrorMsgLbl));
}


public void isStateErrorMsgDisplayed() {
	
	Assert.assertTrue( ElementUtil.isPresentAndDisplayed(stateErrorMsgLbl));
}


public void isZipCodeErrorMsgDisplayed() {
	
	Assert.assertTrue( ElementUtil.isPresentAndDisplayed(zipCodeErrorMsgLbl));
}



	public void clickonlogin() {
		ElementUtil.clickElement(loginBtn);
	//	loginBtn.click();
	}

	public void enterUserId(String userid) {
		ElementUtil.webEditTxtChange(email, userid);
		//email.sendKeys(Email);
	}

	public void clickoncontinue() {
		ElementUtil.clickElement(cont);
		//cont.click();
	}
/*
	public void enterpassword() {
		ElementUtil.webEditTxtChange(password, ConfigReader.readpswrd());
		//password.sendKeys(Password);
	}
	*/
	
	public void enterpassword(String pwd) {
		ElementUtil.webEditTxtChange(password, pwd);
		//password.sendKeys(Password);
	}


	public void clickOnSigin() {
		ElementUtil.clickElement(sigin);
		//sigin.click();
	}

	public void clickonaaccountandlist() {
		ElementUtil.clickElement(accountandlist);
		//accountandlist.click();
	}

	public void clickonyouraddress() {
		ElementUtil.clickElement(youraddress);
		//youraddress.click();
	}

	public void clickonaddaddress() {
		ElementUtil.clickElement(addaddress);
		//addaddress.click();
    }
	
	public void validatefullname() throws IOException {
		ElementUtil.clickElement(validatefullname);
		//validatefullname.click();
		
	}
	public void validatephonenumber() throws IOException {
		ElementUtil.clickElement(validatePhonenumber);	
	//	validatePhonenumber.click();
	}
	public void validateAddress() throws IOException {
		ElementUtil.clickElement(		validateAddressline);
	//	validateAddressline.click();
		
	}
	public void validatecity() throws IOException {
		ElementUtil.clickElement(validateCity);
	//	validateCity.click();
	}
	
	public void validatestate() {
		ElementUtil.clickElement(validateState);
	//	validateState.click();
		ElementUtil.webEditTxtChange(validateState, "lowa");
		//validateState.sendKeys("lowa");
	}
	
	
	public void saveaddress() {
		ElementUtil.clickElement(saveaddress);
		//saveaddress.click();
	}
	public void enterfullname() throws IOException {
		ElementUtil.webEditTxtChange(fullname, ExcelReader.readExcel(1, 0));
		//fullname.clear();
	//	fullname.sendKeys(ExcelReader.readExcel(1, 0));

	}
		public void enterphonenumber() throws IOException {
			ElementUtil.webEditTxtChange(phonenumber, ExcelReader.readExcel(1, 1));
		//	phonenumber.clear();
		//	phonenumber.sendKeys(ExcelReader.readExcel(1, 1));
		}
			
					
		public void enteraddressline() throws IOException {
			ElementUtil.webEditTxtChange(addressline, ExcelReader.readExcel(1, 2));
			//addressline.clear();
			//addressline.sendKeys(ExcelReader.readExcel(1, 2));
			
		}
		
		public void entercity() throws IOException {
			ElementUtil.webEditTxtChange(city, ExcelReader.readExcel(1, 3));
			//city.clear();
			//city.sendKeys(ExcelReader.readExcel(1, 3));
		
		}
		
		public void enterstate() throws IOException {
			ElementUtil.webEditTxt(state, ExcelReader.readExcel(1, 4));
			//state.sendKeys(ExcelReader.readExcel(1, 4));
		}
		
		public void enterzipcode() throws IOException {
			ElementUtil.webEditTxtChange(Zipcode, ExcelReader.readExcel(1, 5));
		//	Zipcode.clear();
			//Zipcode.sendKeys(ExcelReader.readExcel(1, 5));
		}
		
		public void addresssave() {
			ElementUtil.clickElement(addresssave);
			//addresssave.click();
		}
		
}

