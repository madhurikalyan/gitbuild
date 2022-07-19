package parallel;

import java.io.IOException;

import org.json.simple.parser.ParseException;

import com.pages.SearchPaymentpage;
import com.qa.factory.Driver_Factory;
import com.qa.util.ConfigReader;
import com.qa.util.ElementUtil;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchPaymentStep_Definition {

	private  SearchPaymentpage searchpaymentmethod =  new SearchPaymentpage(Driver_Factory.getDriver());

	@Given("user navigate to Payment method process")
	public void user_navigate_to_payment_method_process() {
		Driver_Factory.getDriver().get(ConfigReader.readBookHotelURL());
	}

	@When("user enter first name")
	public void user_enter_first_name() throws IOException, ParseException {
		String fstname= ElementUtil.getvalueFromJSONObject("First Name");
		System.out.println("First Name: "+fstname);
		searchpaymentmethod.enterfirstname(fstname);
	}
	@When("user enter last name")
	public void user_enter_last_name() throws IOException, ParseException {
		String lstname= ElementUtil.getvalueFromJSONObject("Last Name");
		System.out.println("Last Name: "+lstname);
		searchpaymentmethod.enterlastname(lstname);
			}

	@Then("user enter billing address")
	public void user_enter_billing_address() throws IOException, ParseException {
		String Billadd=ElementUtil.getvalueFromJSONObject("Billing Address");
		System.out.println("Billing Address"+Billadd);
		searchpaymentmethod.enterbillingaddress(Billadd);
		}
	@Then("user enter Credit card no")
	public void user_enter_credit_card_no() throws IOException, ParseException {
		String CreditcardNumber=ElementUtil.getvalueFromJSONObject("CreditCardNumber");
		searchpaymentmethod.entercreditcardnumber(CreditcardNumber);

	}
	@Then("user enter Credit card type")
	public void user_enter_credit_card_type() throws IOException, ParseException {
		String CreditCardType=ElementUtil.getvalueFromJSONObject("CreditCardType");
		searchpaymentmethod.enterctreditcardtype(CreditCardType);


	}
	@Then("user enter expiry data")
	public void user_enter_expiry_data() throws IOException, ParseException {
		String expmonth=ElementUtil.getvalueFromJSONObject("expmonth");
		searchpaymentmethod.enterexpirydatemonth(expmonth);

	}
	@Then("user enter expriy data")
	public void user_enter_expriy_data() throws IOException, ParseException {
		String expyear=ElementUtil.getvalueFromJSONObject("expyear");
		searchpaymentmethod.enterexpirydateyear(expyear);

	}
	@Then("user enter Cvv number")
	public void user_enter_cvv_number() throws IOException, ParseException {
		String cvnum=ElementUtil.getvalueFromJSONObject("cvnum");
		searchpaymentmethod.entercvvnumber(cvnum);
	}
	@Then("user click on Book now tab")
	public void user_click_on_book_now_tab() {
		searchpaymentmethod.clickbutton();
	}

	@Then("user click on logout")
	public void user_click_on_logout() {
		searchpaymentmethod.clickonlogout();
	}


}