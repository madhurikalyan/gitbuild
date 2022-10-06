package AppHooks;


import java.io.File;
import java.io.IOException;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import com.qa.factory.Driver_Factory;
import com.qa.util.ConfigReader;
import com.qa.util.Generic_Functions;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Application_Hooks {

private Driver_Factory driverFactory;
private WebDriver driver;
Properties prop;
private ConfigReader config =new ConfigReader();

public static Scenario scenario;


@Before()
public void launchBrowser(Scenario scenario) {
driverFactory = new Driver_Factory();
try {
driver = driverFactory.init_driver(config.readBrowser());
} catch (IOException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}


}
@AfterStep
public void as(Scenario scenario) throws Exception
{

scenario.attach(Generic_Functions.getByteScreenshot(), "image/png", "anyname");
}


@After(order = 0)
public void quitBrowser() {
driver.quit();
}




@After(order = 1)
public void tearDown(Scenario scenario) throws Exception {

if (scenario.isFailed()) {
// take screenshot:
String screenshotName = scenario.getName().replaceAll(" ", "_");
byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
scenario.attach(sourcePath, "image/png", screenshotName);

TakesScreenshot ts = (TakesScreenshot)driver;
File source=ts.getScreenshotAs(OutputType.FILE);
FileUtils.copyFile(source, new File(config.readFailedScreenshotFile(),screenshotName+".png"));

}
}

}
