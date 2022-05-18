package stepDefinitions;

import java.util.HashMap;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.LoginPage;
import util.JSONUtils;

public class LoginPageStepDefinition {
	
	private static String title;
	LoginPage loginPageObj= new LoginPage();
	public WebDriver driver;
	static HashMap<String, String> beneficiarytestData;
	static HashMap<String, String> ProfiletestData;
	static HashMap<String, String> TaskCreationtestData;
	static HashMap<String, String> LinkBenPettestData;
	JSONUtils jsobj =new JSONUtils();
	
	
	@Given("user is on login page")
	public void user_is_on_login_page() {
	    // Write code here that turns the phrase above into concrete actions
		WebDriverManager.chromedriver().setup();
		driver =new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com");
		
		beneficiarytestData=JSONUtils.getNestedTestDataInMap("Beneficiary");
		ProfiletestData=JSONUtils.getNestedTestDataInMap("Profile");
		TaskCreationtestData=JSONUtils.getNestedTestDataInMap("TaskCreation");
		LinkBenPettestData=JSONUtils.getNestedTestDataInMap("Link Ben & Pet");
	}

	//Some other steps were also undefined:

	@When("user gets the title of the page")
	public void user_gets_the_title_of_the_page() {
	    // Write code here that turns the phrase above into concrete actions
		title=loginPageObj.getLoginPageTitle();
		System.out.println("Page title is: " + title);
	}
	@Then("page title should be {string}")
	public void page_title_should_be(String expectedTitleName) {
	    // Write code here that turns the phrase above into concrete actions
		Assert.assertTrue(title.contains(beneficiarytestData.get("Title")));
	}
	@When("user enter username {string}")
	public void user_enter_username(String username) {
	    // Write code here that turns the phrase above into concrete actions
		loginPageObj.enterUserName(beneficiarytestData.get("Userid"));
	}
	@When("user enter password {string}")
	public void user_enter_password(String password) {
	    // Write code here that turns the phrase above into concrete actions
		loginPageObj.enterPassword(beneficiarytestData.get("Password"));
	}
	@When("user click on login button")
	public void user_click_on_login_button() {
	    // Write code here that turns the phrase above into concrete actions
		loginPageObj.clickOnLogin();
		 String linkBeneUserID = "Ben_" +1234;
		 
		 //updating into profile object
		 ProfiletestData.put("Ben_UserID",beneficiarytestData.get("Userid"));
		 ProfiletestData.put("FirstName",beneficiarytestData.get("Firstname"));
		 ProfiletestData.put("LastName",beneficiarytestData.get("Lastname"));
		 
		 //updating into TaskCreation object
		 TaskCreationtestData.put("BenefName", beneficiarytestData.get("Firstname"));
		 TaskCreationtestData.put("Benelname", beneficiarytestData.get("Lastname"));
		 
		 //updating into Link Ben & Pet object
		LinkBenPettestData.put("Existing Ben login ID", beneficiarytestData.get("Userid"));
		LinkBenPettestData.put("Ben User ID", linkBeneUserID);
		LinkBenPettestData.put("Ben Mail", beneficiarytestData.get("Mail"));
		
		JSONUtils.writing("Profile",ProfiletestData );
		JSONUtils.writing("Link Ben & Pet",LinkBenPettestData );
		JSONUtils.writing("TaskCreation",TaskCreationtestData );
		
	}


}
