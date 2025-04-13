package utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UtilsHelper {
	
	private WebDriverWait wait;
	private WebDriver driver;
	
	public UtilsHelper(WebDriver driver, int timeout) {		
		this.driver = driver;		
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));		
	}
	
	
//	public WebElement waitElementToBeVisible(By locator) {		
//		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));		
//	}
	
	public WebElement waitElementToBeLocated(By locator) {
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
    public void selectByVisibleText(By locator, String text) {
        WebElement dropdown = waitElementToBeLocated(locator);
        Select select = new Select(dropdown);
        select.selectByVisibleText(text);
    }
    
//    public void selectByIndex(By locator, int index) {
//        WebElement dropdown = waitElementToBeLocated(locator);
//        Select select = new Select(dropdown);
//        select.selectByIndex(index);
//    }
	
//    public void selectByValue(By locator, String value) {
//        WebElement dropdown = waitElementToBeLocated(locator);
//        Select select = new Select(dropdown);
//        select.selectByValue(value);
//    }

}
