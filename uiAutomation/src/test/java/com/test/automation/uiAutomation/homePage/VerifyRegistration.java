package com.test.automation.uiAutomation.homePage;

import java.io.IOException;
import java.util.logging.Logger;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.test.automation.uiAutomation.testBase.TestBase;
import com.test.automation.uiAutomation.uiActions.HomePage;

public class VerifyRegistration extends TestBase{
		
	HomePage homepage;
	static Logger log = Logger.getLogger(VerifyRegistration.class.getName());
	
	
	@BeforeClass
	public void setUp() throws IOException{
		init();
	}
	
	@Test
	public void verifyRegistration(){
		log.info("verifying registration using valid email address");
		homepage = new HomePage(driver);
		homepage.verifyRegistration("t1@y1.com");
		Assert.assertEquals(homepage.getNextStepText(), "YOUR PERSONAL INFORMATION");
	}
	
	@AfterClass
	public void endTest(){
		driver.close();
	}
}
