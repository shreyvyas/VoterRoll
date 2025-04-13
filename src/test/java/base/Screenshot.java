package base;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import utils.Constants;

public class Screenshot {
	
	protected WebDriver driver;
	
	public void takeScreenshot(String testName) {
		
		String fileName = UUID.randomUUID() + "_" + testName + ".png";
		
		TakesScreenshot scrShot = ((TakesScreenshot) driver);
		File source = scrShot.getScreenshotAs(OutputType.FILE);
		File destination = new File(Constants.screenshots + fileName);
		
		try {
			FileUtils.copyFile(source, destination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
