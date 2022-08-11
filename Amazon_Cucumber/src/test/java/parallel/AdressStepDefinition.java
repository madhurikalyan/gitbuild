package parallel;
import java.io.IOException;
import com.pages.AddressPage;
import com.qa.factory.Driver_Factory;
import com.qa.util.ConfigReader;
import com.qa.util.ExcelReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AdressStepDefinition {
		private AddressPage addingaddress = new AddressPage(Driver_Factory.getDriver());

		ExcelReader reader = new ExcelReader();

		@Given("user login the application")
		public void user_login_the_application() {

			Driver_Factory.getDriver().get(ConfigReader.readLoginURL());

			addingaddress.clickonlogin();
			addingaddress.enteruserid();
			addingaddress.clickoncontinue();
			addingaddress.enterpassword();
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
	
	}