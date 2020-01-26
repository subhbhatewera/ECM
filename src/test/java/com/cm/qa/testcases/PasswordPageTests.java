package com.cm.qa.testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.cm.qa.pages.UsernamePage;
import com.cm.qa.utills.Utills;

import cm.cm.qa.base.ActionClass;

public class PasswordPageTests extends ActionClass{
	
	Logger logger = LogManager.getLogger(PasswordPageTests.class.getName());

	@BeforeClass
	public void setUp() {
		initializeBrowser() ;
		logger.info(browserName+" browser opened successfully");
		uName = new UsernamePage() ;
		utills = new Utills() ;
		pwd = uName.navigateToPasswordPage(prop.getProperty("clientUser")) ;
		logger.info("Navigated to password page");
	}

	@Test(priority = 5)
	public void verifyUsernameLabelTest() {
		Assert.assertEquals(pwd.validateUsernameLabel(), prop.getProperty("clientUser"));
		logger.info("Verified correct username test");
	}

	@Test(priority = 6)
	public void blankPasswordTest() {
		pwd.login("") ;
		Assert.assertEquals(utills.readErrorMessage(), "Must Enter Password!\n" + "Password not entered") ;		
		logger.info("Validated validation for blank password");
	}

	@Test(priority = 7)
	public void invalidPasswordTest() {
		sleep(3000);
		pwd.login("wrong password");
		Assert.assertEquals(utills.readErrorMessage(), "Invalid Username/Password\n" + 
				"Error") ;
		logger.info("Validated validation for invalid password");
	}

	@Test(priority = 9)
	public void validPasswordTest() {
		dashboard = pwd.login(prop.getProperty("clientUserPassword")) ;		
		Assert.assertEquals(dashboard.verifyDashboardPageHeading(), "Dashboard");
		logger.info("Validated Login Functionality");
	}

	@Test(priority = 8)
	public void verifyPasswordScreenFooterTextTest() {
		Assert.assertEquals(pwd.getFooterText(), prop.getProperty("footerText"));
		logger.info("Validated Footer Text");
	}

	@AfterClass
	public void tearDown() {
		driver.close();
	}

}
