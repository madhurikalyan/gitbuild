package com.qa.util;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.qa.factory.Driver_Factory;

/*import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;*/

public class Generic_Functions extends Driver_Factory{

	
	
/*	public static byte[] takeScreenShotAsByte() throws IOException {
        return takeFullPageScreenShotAsByte();
    }*/
		
	
		
	/*public static byte[]takeFullPageScreenShotAsByte() throws IOException{
        Screenshot fpScreenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(100))
                .takeScreenshot(getDriver());

        BufferedImage originalImage = fpScreenshot.getImage();

        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            ImageIO.write(originalImage, "png", baos);
            baos.flush();
            return baos.toByteArray();
        }
    }*/
	public static void takeFullPageScreenShot(WebDriver driver) throws IOException {

	    JavascriptExecutor jsExec = (JavascriptExecutor)driver;

	    jsExec.executeScript("window.scrollTo(0, 0);"); //Scroll To Top

	    Long innerHeight = (Long) jsExec.executeScript("return window.innerHeight;");
	    Long scroll = innerHeight;

	    Long scrollHeight = (Long) jsExec.executeScript("return document.body.scrollHeight;"); 

	    scrollHeight = scrollHeight + scroll;

	    do{

	        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	       
	        //Unique File Name For Each Screenshot
	        File destination = new File("E://screenshots//"+String.join("_", 
	       LocalDateTime.now().toString().split("[^A-Za-z0-9]"))+".jpg");

	        FileUtils.copyFile(screenshot, destination);
	       
	        jsExec.executeScript("window.scrollTo(0, "+innerHeight+");");

	        innerHeight = innerHeight + scroll;

	    }while(scrollHeight >= innerHeight);
		
	}
}
