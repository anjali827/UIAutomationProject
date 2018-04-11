package com.test.automation.uiAutomation.uiActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;
	public String women = "Women";
	public String dresses = "Dresses";
	 		
	@FindBy(xpath = ".//*[@id='header']/div[2]/div/div/nav/div[1]/a")
	WebElement SignIn;
	
	@FindBy(xpath = ".//*[@id='email']")
	WebElement loginEmailAddress;
	
	@FindBy(xpath = ".//*[@id='passwd']")
	WebElement loginPassword;
	
	@FindBy(id = "SubmitLogin")
	WebElement submitButton;
	
	@FindBy(xpath = ".//*[@id='center_column']/div[1]/ol/li")
	WebElement authenticationFailed;
	
	@FindBy(xpath = ".//*[@id='email_create']")
	WebElement enterEmail;
	
	@FindBy(id = "SubmitCreate")
	WebElement createAccountBtn;
	
	@FindBy(xpath = ".//*[@id='account-creation_form']/div[1]/h3")
	WebElement nextStepRegistration;
	
	@FindBy(xpath = ".//*[@id='header']/div[2]/div/div/nav/div[2]/a")
	WebElement signOut;
		
	public HomePage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this); //initElement initialize all WebsElements mentioned above
	}
	
	public void loginToApplication(String emailAddress, String password){
		SignIn.click();
		loginEmailAddress.sendKeys(emailAddress);
		loginPassword.sendKeys(password);
		submitButton.click();			
	}
	
	public String getInvalidLoginText(){
		return authenticationFailed.getText();
	} 
	
	public void verifyRegistration(String emailAddress){
		SignIn.click();
		enterEmail.sendKeys(emailAddress);
		createAccountBtn.click();
		}
	
	public boolean verifyLogOutDisplay(){
		signOut.isDisplayed();
		return true;
	}
	
	public String getNextStepText(){
		return nextStepRegistration.getText();
	}
	
	public void logOutOfApplication(){
		signOut.click();
	}
	
	public void clickOnNavigationMenu(String menuname){
		driver.findElement(By.xpath("//a[contains(text(), '"+menuname+"')]")).click();
	}
	
}
