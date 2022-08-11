package parallel;

	import java.io.IOException;
import com.pages.LoginPage;
import com.qa.factory.Driver_Factory;
	import io.cucumber.java.en.Given;
	import io.cucumber.java.en.Then;
	import io.cucumber.java.en.When;

	public class LoginStepDefinition {

		private LoginPage loginPage = new LoginPage(Driver_Factory.getDriver());

		//public WebDriver driver;


		@Given("user is on login page")
		public void user_is_on_login_page() {

			Driver_Factory.getDriver().get("https://www.amazon.in/");

			loginPage.clickonsigin();
		}

		@When("user enter Username")
		public void user_enter_username() throws IOException {

			loginPage.enterUserName();
			loginPage.clickoncontinue();

		}

		@When("user enter Password")
		public void user_enter_password() throws InterruptedException {
			loginPage.enterPassword();

		}

		@When("user click on SiginButton")
		public void user_click_on_sigin_button() {
			loginPage.clickOnLogin();
		}

		@Then("user change the Country")
		public void user_change_the_country() throws InterruptedException {
			Thread.sleep(2000);
			loginPage.clickoncountrytab();
			
		}
		

	@Then("as a user validate the menu tabs")
	public void as_a_user_validate_the_menu_tabs() {
		//loginPage.validateonalldepartment();	
	}


	@Then("as a user validate All category dropdown")
	public void as_a_user_validate_all_category_dropdown() {
		//loginPage.validatemenutab();
	}

					
		}

