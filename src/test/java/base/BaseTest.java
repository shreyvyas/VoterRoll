package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.ConfigReader;

public class BaseTest {
	
	protected WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		
		String browser = ConfigReader.getProperty("browser").toLowerCase();
		
		switch (browser) {
		
		case "chrome":			
			ChromeOptions option = new ChromeOptions();
			option.addArguments("--start-maximized");
			driver = new ChromeDriver(option);
		    break;
		    
		case "firefox":
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			break;																//we can add case for safari and edge as well.
			
		default:
			throw new IllegalArgumentException("Invalid Browser: " +browser);
		}
		
		driver.get(ConfigReader.getProperty("url"));							//url from config.properties file
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));		
		
	}
	
	@AfterMethod
	public void quitDriver() {
		driver.quit();
	}

}
