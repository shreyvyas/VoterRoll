package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.UtilsHelper;

public class VoterRollPage {
	
	private WebDriver driver;                                     //private access specifier so outside of the class it cannot be accessed/modified
	private UtilsHelper UtilsHelper;
	
	public VoterRollPage(WebDriver driver) {                       //initializes the WebDriver when an object of this class is created
		this.driver = driver;
		this.UtilsHelper = new UtilsHelper(driver, 20);
	}
	
	
	//locators for WebElements on the VoterRoll Page, we will use "By" so dynamic elements can be handled properly
	
	private By districtName = By.id("ctl00_ContentPlaceHolder1_ddlDist");
	private By assemblyConstituency = By.id("ctl00_ContentPlaceHolder1_ddlAC");
	private By getPollingStation = By.id("ctl00_ContentPlaceHolder1_btnlogin");
	private By table = By.id("ctl00_ContentPlaceHolder1_GridView1");
	//private By pollingStationName = By.xpath("//tr/td[2]"); 
	private String finalRollLinkXpath = "//tr[td[2][text()='%s']]/td[4]/a[contains(text(), 'Final Roll')]"; //dynamic xpath
	
	// Action methods to interact with the above elements
	
	public void selectDistrictNameDropDown(String input1) {		
		UtilsHelper.selectByVisibleText(districtName, input1);		
	}
	
	public void selectAssemblyConstituency(String input2) {		
		UtilsHelper.selectByVisibleText(assemblyConstituency, input2);		
	}
	
	public void clickOnPollingStation() {		
		UtilsHelper.waitElementToBeLocated(getPollingStation).click();		
	}
	
	public boolean isTableDisplayed() {
		
		WebElement tableData = UtilsHelper.waitElementToBeLocated(table);
		boolean result = tableData.isDisplayed();
		return result;
	}
	
	public boolean clickOnFinalRollLink(String input3) {
		
		try {
			String finalXpath = String.format(finalRollLinkXpath, input3);
			WebElement finalRollLink = UtilsHelper.waitElementToBeLocated(By.xpath(finalXpath));
			boolean result = finalRollLink.isEnabled();
			finalRollLink.click();
			return result;
		}
		catch(Exception e) {
			System.out.println("Final Roll link not found for polling station: " + input3);
			return false;
		}
		
	}
		

	
	

}
