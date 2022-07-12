package pageObjects;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class Screenshotc {
	//System.setProperty("webdriver.chrome.driver", "c:\\chromedriver.exe");
	@Test
	public void screen() throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver  = new ChromeDriver();	
		driver.get("http://demo.guru99.com/test/guru99home/");
		driver.manage().window().maximize();
				
		Screenshot ScreenshotA = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
	
		ImageIO.write(ScreenshotA.getImage(), "jpg", new File("D:\\ElementScreenshot.jpg"));
			
			}

}
