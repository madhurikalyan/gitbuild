package parallel;

import java.io.IOException;

import com.pages.AddressPage;
import com.qa.factory.Driver_Factory;
import com.qa.util.ConfigReader;
import com.qa.util.ExcelReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AdressStepDefinitionNew {
	
	private AddressPage addingaddress = new AddressPage(Driver_Factory.getDriver());

	ExcelReader reader = new ExcelReader();

	@Given("user login the application")
	public void user_login_the_application() {

		Driver_Factory.getDriver().get(ConfigReader.readLoginURL());

		addingaddress.clickonlogin();
		addingaddress.enterUserId(ConfigReader.readuserid());
		addingaddress.clickoncontinue();
		addingaddress.enterpassword(ConfigReader.readpswrd());
		addingaddress.clickOnSigin();
	}

	@Given("user bypassing the mandate fields of the address to place the order")
	public void user_bypassing_the_mandate_fields_of_the_address_to_place_the_order() throws IOException {

		addingaddress.clickonaaccountandlist();
		addingaddress.clickonyouraddress();
		addingaddress.clickonaddaddress();

		addingaddress.validatefullname();
		addingaddress.validatephonenumber();
		addingaddress.validateAddress();
		addingaddress.validatecity();
		addingaddress.validatestate();
		addingaddress.saveaddress();

	}

	@Then("User Adding the current address")
	public void user_adding_the_current_address() throws IOException, InterruptedException {

		addingaddress.enterfullname();
		addingaddress.enterphonenumber();
		addingaddress.enteraddressline();
		addingaddress.entercity();
		Thread.sleep(2000);
		addingaddress.enterstate();
		addingaddress.enterzipcode();

	}

	@Given("user navigates Account page")
	public void user_navigates_account_page() {
		addingaddress.clickonaaccountandlist();
		

	}
	@Then("user should be on account page")
	public void user_should_be_on_account_page() {
	    
	}
	@When("user click on your address")
	public void user_click_on_your_address() {
		addingaddress.clickonyouraddress();
		}
	@Then("user should be your address page")
	public void user_should_be_your_address_page() {
		

	}   
	@When("user clicks on add address button")
	public void user_clicks_on_add_address_button() {
		addingaddress.clickonaddaddress();
	}
	@When("user clicks on add address button on new address page")
	public void clickOnAddAddressButton() {
		addingaddress.clickOnAddAddressButton();
	}
	
	
	
	
	@Then("user should be on add new address page")
	public void user_should_be_on_add_new_address_page() {
		}
	@Then("user should see error messages for mandatory fileds")
	public void user_should_see_error_messages_for_mandatory_fileds() throws InterruptedException {
		Thread.sleep(1000);
		addingaddress.isAddressErrorMsgDisplayed();
		addingaddress.isCityErrorMsgDisplayed();
		addingaddress.isStateErrorMsgDisplayed();
		addingaddress.isZipCodeErrorMsgDisplayed();
		
		//remaining validation
		//
		
	}
	@When("user enters data for address")
	public void user_enters_data_for_address() throws IOException, InterruptedException {
		addingaddress.enterfullname();
		addingaddress.enterphonenumber();
		addingaddress.enteraddressline();
		addingaddress.entercity();
		Thread.sleep(2000);
		addingaddress.enterstate();
		addingaddress.enterzipcode();
		Thread.sleep(2000);
		addingaddress.addresssave();
		Thread.sleep(2000);

	}

}


