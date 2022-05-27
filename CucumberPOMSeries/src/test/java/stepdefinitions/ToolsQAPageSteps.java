package stepdefinitions;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.pages.ToolsQaPage;
import com.qa.factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class ToolsQAPageSteps {
	
	private ToolsQaPage toolPage = new ToolsQaPage(DriverFactory.getDriver());
	
	@Given("user is on Home page")
	public void user_is_on_home_page() {
		DriverFactory.getDriver()
		.get("https://www.seleniumeasy.com/selenium-tutorials/waits-and-timeout-selenium-4");
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(),Duration.ofSeconds(100));
		wait.until(ExpectedConditions.titleIs("Waits and Timeout in Selenium 4 | Selenium Easy"));
	}

	@Then("Home link should be displayed")
	public void home_link_should_be_displayed() throws IOException {
		Assert.assertTrue(toolPage.isHomeLinkExist());
		File scrFile = ((TakesScreenshot)DriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
		 FileUtils.copyFile(scrFile, new File("D:\\WorkSpace\\Selenium\\CucumberPOMSeries\\Screenshots\\abc.png"));
	}

}
