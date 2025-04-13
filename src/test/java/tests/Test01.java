package tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.VoterRollPage;
import utils.TestData;

@Listeners(base.TestListener.class)
public class Test01 extends BaseTest{
	
	
	
	@Test(description="Test to Downlaod Voter Roll", priority=1, dataProvider="dataprovider", dataProviderClass= TestData.class)
	public void getPollingStation(String districtName, String assemblyConstituency, String pollingStationName) {
		
		VoterRollPage page = new VoterRollPage(driver);
		
		page.selectDistrictNameDropDown(districtName);
		
		page.selectAssemblyConstituency(assemblyConstituency);
		
		page.clickOnPollingStation();
		
		Assert.assertTrue(page.isTableDisplayed());
		
		Assert.assertTrue(page.clickOnFinalRollLink(pollingStationName));
		
	}

}
