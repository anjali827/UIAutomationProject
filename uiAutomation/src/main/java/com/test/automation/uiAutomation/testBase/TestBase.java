package com.test.automation.uiAutomation.testBase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.test.automation.uiAutomation.excelReader.Excel_Reader;

public class TestBase {

	public WebDriver driver;
	String url = "http://automationpractice.com/index.php";
	String browser = "firefox";
	//String browser = "chrome";
	Excel_Reader excel;
	
	public void init(){
		selectBrowser(browser);
		getUrl(url);
		}
	
	public void selectBrowser(String browser) {
		if (browser.equals("firefox")) {
				//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
				driver = new FirefoxDriver();
			} 
		else if(browser.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver" , System.getProperty("user.dir")+ "/drivers/chromedriver.exe" );
			driver = new ChromeDriver();
		}
		}	
	
	public void getUrl(String url){
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}
	
	public String[][] getData(String excelName, String sheetName){ 
	       String path = System.getProperty("user.dir") + "/src/main/java/com/test/automation/uiAutomation/data/TestData.xlsx";
	       excel = new Excel_Reader(path);
	       String[][] data = excel.getDataFromSheet(sheetName, excelName);
					return data;
				}
}
