package parallel;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;

import com.pages.HomePage;
import com.qa.factory.Driver_Factory;
import com.qa.util.ConfigReader;

public class HomeSteps {

   
  
	private HomePage homePage = new HomePage(Driver_Factory.getDriver());
   
    @Given("Home page without authorizations")
    public void homePageWithoutAuthorizations() {
    	Driver_Factory.getDriver().get(ConfigReader.readLoginURL());
        Assert.assertTrue(homePage.defaultHomePageIsDisplayed());
    }

    @Given("Login form in login page")
    public void goToLoginPage() {
        Assert.assertTrue(homePage.defaultHomePageIsDisplayed());
        homePage.clickLoginButton();
    }

    @Then("This is for invalid locators")
    public void thisIsForInvalidLocators() {
        homePage.getInvalidLocators();
    }
}
