package parallel;

import java.io.IOException;
import org.testng.Assert;
import com.pages.Loginpage;
import com.qa.factory.Driver_Factory;
import com.qa.util.ConfigReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStep_Definition {

	private Loginpage loginPage = new Loginpage(Driver_Factory.getDriver());

	
	@Given("user is on login page")
public void user_is_on_login_page() {
		Driver_Factory.getDriver().get(ConfigReader.readLoginURL());
}


@Then("forgot your password link should be displayed")
public void forgot_your_password_link_should_be_displayed() {
    Assert.assertTrue(loginPage.isForgotPwdLinkExist());

}


@When("user enter Username")
public void user_enter_username() throws IOException {
	loginPage.enterUserName(ConfigReader.readuserid());
}

@When("user enter Password")
public void user_enter_password() {

	loginPage.enterPassword(ConfigReader.readpswrd());
}

@When("user click on login button")
public void user_click_on_login_button() {
	loginPage.clickOnLogin();

}




}
