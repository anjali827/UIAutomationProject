package com.test.automation.uiAutomation.testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import org.apache.log4j.PropertyConfigurator;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.test.automation.uiAutomation.excelReader.Excel_Reader;

public class TestBase {

	public static WebDriver driver;
	Excel_Reader excel;
	public Properties OR = new Properties();
	public static final Logger log = Logger.getLogger(TestBase.class.getName());
	
	public void init() throws IOException {
		loadData();
		String log4jconfpath = "log4j.properties";
		PropertyConfigurator.configure(log4jconfpath);
		selectBrowser(OR.getProperty("browser"));
		getUrl(OR.getProperty("url"));
	}

	public void loadData() throws IOException {
		File file = new File(
				System.getProperty("user.dir")
						+ "/src/main/java/com/test/automation/uiAutomation/config/config.properties");
		FileInputStream f = new FileInputStream(file);
		OR.load(f);
	}

	public void selectBrowser(String browser) {
		if (browser.equals("firefox")) {
			// System.setProperty("webdriver.chrome.driver",
			// System.getProperty("user.dir") + "/drivers/chromedriver.exe");
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") 
							+ "/drivers/chromedriver.exe");
			driver = new ChromeDriver();
		}
	}

	public void getUrl(String url) {
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}

	public String[][] getData(String excelName, String sheetName) {
		String path = System.getProperty("user.dir")
				+ "/src/main/java/com/test/automation/uiAutomation/data/SeleniumAutomationData.xlsx";
		excel = new Excel_Reader(path);
		String[][] data = excel.getDataFromSheet(sheetName, excelName);
		return data;
	}

	public void waitForElement(WebDriver driver, int timeOutInSeconds,
			WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void getScreenshot(String name) throws IOException{
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_mm_yy_hh_mm_ss");
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath()+"/src/main/java/com/test/automation/uiAutomation/screenshot/";
		File destiFile = new File((String)reportDirectory + name + "_"+ formater.format(calendar.getTime()) + ".png");
		FileUtils.copyFile(scrFile, destiFile);
		Reporter.log("<a href='" + destiFile.getAbsolutePath() + "'> <img src='" + destiFile.getAbsolutePath() + "' height='100' width='100'/> </a>");
	}

	public void closeBrowser() {
		driver.quit();
	}
}
