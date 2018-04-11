package com.test.automation.uiAutomation.addToCart;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.test.automation.uiAutomation.testBase.TestBase;
import com.test.automation.uiAutomation.uiActions.HomePage;
import com.test.automation.uiAutomation.uiActions.ProductCategoryPage;
import com.test.automation.uiAutomation.uiActions.ProductsPage;


public class TC001_VerifyAddToCart extends TestBase{
		
	HomePage homepage;
	ProductCategoryPage pcp;
	ProductsPage pp;
	
	@BeforeClass
	public void setUp() throws IOException{
		init();
	}
	
	@Test
	public void verifyAddToCart(){
		homepage = new HomePage(driver);
		pcp = new ProductCategoryPage(driver);
		pp = new ProductsPage(driver);
		
		homepage.clickOnNavigationMenu(homepage.women);
		pcp.clickOnExpandIcon();
		pcp.clickOnMenuItem();
		pp.clickOnProduct();
		
	}
	
	@AfterClass
	public void endTest(){
		closeBrowser();
	}
	
}
