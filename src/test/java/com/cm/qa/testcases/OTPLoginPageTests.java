package com.cm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cm.qa.pages.DashboardPage;
import com.cm.qa.pages.OTPLoginPage;
import com.cm.qa.pages.PasswordPage;
import com.cm.qa.pages.UsernamePage;
import com.cm.qa.utills.Utills;

import cm.cm.qa.base.TestBase;

public class OTPLoginPageTests extends TestBase{

	UsernamePage uName ;
	PasswordPage pwd ;
	Utills utills ;
	OTPLoginPage otp ;
	DashboardPage dashboard ;

	public OTPLoginPageTests() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initializeBrowser() ;
		uName = new UsernamePage() ;
		utills = new Utills() ;
		pwd = uName.navigateToPasswordPage(prop.getProperty("clientUser")) ;
		otp = pwd.clickOTPLoginLink() ;
	}


	@Test(priority = 1)
	public void emptyOTPTest(){
		otp.clickSubmitButton();
		Assert.assertEquals(utills.readErrorMessage(), "Please enter OTP");
	}

	@Test(priority = 2)
	public void invalidOTPTest() {
		otp.enterWrongOTP();
		otp.clickSubmitButton();
		Assert.assertEquals(utills.readErrorMessage(), "Wrong credentials, try again.\n" + "Wrong credentials");
	}


	@Test(priority = 3)
	public void validOTPTest() {
		dashboard = otp.OTPLogin(prop.getProperty("outlookUsername"), prop.getProperty("outlookPassword"));
		Assert.assertEquals(dashboard.verifyDashboardPageHeading(), "Dashboard");
	}	

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
