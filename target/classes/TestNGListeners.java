package resources;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import cm.cm.qa.base.ActionClass;

public class TestNGListeners extends ActionClass implements ITestListener {

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestSuccess(ITestResult result) {
		System.out.println(result.getName() + " is passed");

	}

	public void onTestFailure(ITestResult result) {
		System.out.println(result.getName() + " is failed");
		TakesScreenshot scr = (TakesScreenshot) driver;
		File sourceFile = scr.getScreenshotAs(OutputType.FILE);
		File destinationFile = new File(
				projectpath + "/test-output/screenshots/" + result.getName() + "screenshots.png");
		try {
			FileUtils.copyFile(sourceFile, destinationFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {
		System.out.println(context.getName() + " are started");

	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub

	}

}
