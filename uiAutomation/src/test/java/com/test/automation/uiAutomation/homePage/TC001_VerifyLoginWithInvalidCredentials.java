package com.test.automation.uiAutomation.homePage;

/*import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;*/
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.test.automation.uiAutomation.testBase.TestBase;
import com.test.automation.uiAutomation.uiActions.HomePage;

public class TC001_VerifyLoginWithInvalidCredentials extends TestBase {
	 
	//WebDriver driver; --initialization done in TestBase class
	HomePage homepage;
	
	@BeforeTest
	public void setup(){
		/*driver = new FirefoxDriver();
		driver.get("http://automationpractice.com/index.php");*/ 
		init(); //TestBase method 
	}
	@Test
	public void verifyLoginWithInvalidCredentials(){
		/*driver.findElement(By.xpath(".//*[@id='header']/div[2]/div/div/nav/div[1]/a")).click();
		driver.findElement(By.xpath(".//*[@id='email']")).sendKeys("test@gmail.com");
		driver.findElement(By.xpath(".//*[@id='passwd']")).sendKeys("test123");
		driver.findElement(By.id("SubmitLogin")).click();
		//Assert.assertEquals(driver.findElement(By.xpath(".//*[@id='center_column']/div[1]/ol/li")).getText(), "Authentication failed.");*/
		homepage = new HomePage(driver);
		homepage.loginToApplication("test@gmail.com", "password123");
		Assert.assertEquals(homepage.getInvalidLoginText(), "Authentication failed.");
	}
	@AfterClass
	public void endTest(){
		driver.close();
	}
	
}
