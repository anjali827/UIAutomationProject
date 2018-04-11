package com.test.automation.uiAutomation.customListener;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.test.automation.uiAutomation.testBase.TestBase;

public class Listener extends TestBase implements ITestListener   {

	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult result) {
		if(!result.isSuccess()){
			Calendar calendar = Calendar.getInstance();
			SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
			String methodname = result.getName();
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			try{
				String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath() + "/src/main/java/com/test/automation/uiAutomation/screenshot/FailureScreenshots/";
			File destiFile = new File((String)reportDirectory + methodname + "_" +
					formater.format(calendar.getTime()) + ".png");
			FileUtils.copyFile(scrFile, destiFile);
			Reporter.log("<a href = '" + destiFile.getAbsolutePath() + "'><img src ='"+ destiFile.getAbsolutePath() + "' height = '100px' width = '100px'/></a> ");
			}
			catch(IOException e){
				e.printStackTrace();
			}
		}
		
	}

	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

}
