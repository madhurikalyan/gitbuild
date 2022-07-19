package AppHooks;


import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.qa.factory.Driver_Factory;
import com.qa.util.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import testrunner.MyTestRunner_Class;

public class Application_Hooks {

	private Driver_Factory driverFactory;
	private WebDriver driver;
	Properties prop;

	public static Scenario scenario;


	@Before()
	public void launchBrowser(Scenario scenario) {
			driverFactory = new Driver_Factory();
		try {

			driver = driverFactory.init_driver(ConfigReader.readBrowser());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
	/*@AfterStep
	public void as(Scenario scenario) throws Exception
	{

	    scenario.attach(Generic_Functions.takeFullPageScreenShotAsByte(), "image/png", "screenshots");
	}*/


		@After(order = 0)
	public void quitBrowser() {
		driver.quit();
	}




	@After(order = 1)
	public void tearDown(Scenario scenario) {
	
		if (scenario.isFailed()) {
			// take screenshot:
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcePath, "image/png", screenshotName);
		}
		}

	}