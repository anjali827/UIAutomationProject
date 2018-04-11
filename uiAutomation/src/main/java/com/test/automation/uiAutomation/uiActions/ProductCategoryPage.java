package com.test.automation.uiAutomation.uiActions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.test.automation.uiAutomation.testBase.TestBase;


public class ProductCategoryPage extends TestBase {
	WebDriver driver;
		
	public ProductCategoryPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnExpandIcon(){
		driver.findElement(By.xpath(".//*[@id='categories_block_left']/div/ul/li[1]/span")).click();
	}
	
	public void clickOnMenuItem(){
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,250)", "");
		waitForElement(driver, 80,  driver.findElement(By.xpath(".//*[@id='categories_block_left']/div/ul/li[1]/ul/li[2]/a")));
		driver.findElement(By.xpath(".//*[@id='categories_block_left']/div/ul/li[1]/ul/li[2]/a")).click();
	}
	

}
