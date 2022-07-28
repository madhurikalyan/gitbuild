package parallel;


import io.cucumber.java.en.When;
import org.testng.Assert;

import com.pages.HomePage;
import com.pages.LoginPageA;
import com.qa.factory.Driver_Factory;

public class CartSteps {
    
   	private LoginPageA loginPageA = new LoginPageA(Driver_Factory.getDriver());
	private HomePage homePage = new HomePage(Driver_Factory.getDriver());
	
    @When("Go to cart page without authorizations")
    public void goToCartPageWithoutAuthorizations() {
        homePage.clickCartButton();
        Assert.assertTrue(loginPageA.emailLoginPageIsDisplayed());
    }
}
