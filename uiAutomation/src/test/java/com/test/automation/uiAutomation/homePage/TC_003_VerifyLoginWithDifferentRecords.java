package com.test.automation.uiAutomation.homePage;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.test.automation.uiAutomation.testBase.TestBase;
import com.test.automation.uiAutomation.uiActions.HomePage;

public class TC_003_VerifyLoginWithDifferentRecords extends TestBase{
	
	HomePage homepage;

	@DataProvider(name = "loginData")	
	public String[][] getTestData(){
		String[][] testRecord = getData("SeleniumAutomationData.xlsx", "loginData");
		return testRecord;
	}
	
	
	@BeforeClass
	public void setup() throws IOException{
		init();
		homepage = new HomePage(driver);
	}
	
	@Test(dataProvider = "loginData")
	public void testLogin(String emailAddress, String password, String runmode) throws IOException{
		homepage = new HomePage(driver);
		homepage.loginToApplication(emailAddress, password);
		boolean status = homepage.verifyLogOutDisplay();
		if(status = true){
			homepage.logOutOfApplication();	
		}
		Assert.assertEquals(status, true);
		getScreenshot("verifyLoginWithDifferentRecords");
	}
		
	@AfterTest
	public void endTest(){
		driver.close();
	}
}
