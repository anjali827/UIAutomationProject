package com.test.automation.uiAutomation.homePage;

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
		String[][] testRecord = getData("TestData.xlsx", "loginData");
		return testRecord;
	}
	
	
	@BeforeClass
	public void setup(){
		init();
	}
	
	@Test(dataProvider = "loginData")
	public void testLogin(String emailAddress, String password, String runmode){
		homepage = new HomePage(driver);
		homepage.loginToApplication(emailAddress, password);
		homepage.logOutOfApplication();
	}
		
	@AfterTest
	public void endTest(){
		driver.close();
	}
}
