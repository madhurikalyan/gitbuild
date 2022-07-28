package utility;


import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	public static WebDriver driver;
	
	ExtentReports report;
	public static ExtentTest test;
	ExtentTest extentTest;
   
	@BeforeClass
	public void setup() throws InterruptedException {

	//	System.setProperty("webdriver.chrome.driver",
		//		"C:\\Users\\HP\\eclipse-workspace\\Amazon_Testing_Framework\\Driver\\chromedriver.exe");
WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		report = Extentfactory.getInstance();
		test = report.startTest("Amazon Page");
		driver.manage().window().maximize();
		Thread.sleep(1000);
		test.log(LogStatus.INFO, "Browser Maximized");
		driver.get("https://www.amazon.in/");
		Thread.sleep(1000);
		test.log(LogStatus.INFO, "Web Application opened");
	}

	
	@AfterClass
	public void teardown() {
		driver.quit();
		report.endTest(test);
		report.flush();
	}
}
