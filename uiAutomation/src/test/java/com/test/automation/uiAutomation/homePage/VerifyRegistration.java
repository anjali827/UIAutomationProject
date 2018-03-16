package com.test.automation.uiAutomation.homePage;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.test.automation.uiAutomation.testBase.TestBase;
import com.test.automation.uiAutomation.uiActions.HomePage;

public class VerifyRegistration extends TestBase{
		
	HomePage homepage;
	
	
	@BeforeClass
	public void setUp(){
		init();
	}
	
	@Test
	public void verifyRegistration(){
		homepage = new HomePage(driver);
		homepage.verifyRegistration("t1@y1.com");
		Assert.assertEquals(homepage.getNextStepText(), "YOUR PERSONAL INFORMATION");
	}
	
	@AfterClass
	public void endTest(){
		driver.close();
	}
}
