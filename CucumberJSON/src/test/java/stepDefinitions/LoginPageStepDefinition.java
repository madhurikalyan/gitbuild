package stepDefinitions;


import java.util.HashMap;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.LoginPage;
import util.JSONUtils;

public class LoginPageStepDefinition {
	
	public WebDriver driver;
	private static String title;
	public LoginPage loginPageObj;
	
	static HashMap<String, String> beneficiarytestData;
	static HashMap<String, String> ProfiletestData;
	static HashMap<String, String> TaskCreationtestData;
	static HashMap<String, String> LinkBenPettestData;
	JSONUtils jsobj =new JSONUtils();
	
	
	@Given("user is on login page")
	public void user_is_on_login_page() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
		WebDriverManager.chromedriver().setup();
		driver =new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com");
		loginPageObj= new LoginPage(driver);
		beneficiarytestData=JSONUtils.getNestedTestDataInMap("Beneficiary");
		System.out.println(beneficiarytestData);
		ProfiletestData=JSONUtils.getNestedTestDataInMap("Profile");
		System.out.println(ProfiletestData);
		TaskCreationtestData=JSONUtils.getNestedTestDataInMap("TaskCreation");
		System.out.println(TaskCreationtestData);
		LinkBenPettestData=JSONUtils.getNestedTestDataInMap("Link Ben & Pet");
		System.out.println(LinkBenPettestData);
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
		System.out.println("title is :"+beneficiarytestData.get("Title"));
		Assert.assertTrue(title.contains(beneficiarytestData.get("Title")));
	}
	@When("user enter username {string}")
	public void user_enter_username(String username) {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Username is :"+beneficiarytestData.get("Userid"));
		loginPageObj.enterUserName(beneficiarytestData.get("Userid"));
	}
	@When("user enter password {string}")
	public void user_enter_password(String password) {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Password is :"+beneficiarytestData.get("Password"));
		loginPageObj.enterPassword(beneficiarytestData.get("Password"));
	}
	@When("user click on login button")
	public void user_click_on_login_button() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
		loginPageObj.clickOnLogin();
		 String linkBeneUserID = "Ben_" +123456;
		 
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
