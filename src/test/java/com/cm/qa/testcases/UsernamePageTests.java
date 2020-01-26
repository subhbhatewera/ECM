package com.cm.qa.testcases;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.cm.qa.pages.UsernamePage;
import com.cm.qa.utills.Utills;

import cm.cm.qa.base.TestBase;

public class UsernamePageTests extends TestBase {
	
	Logger logger = LogManager.getLogger(UsernamePageTests.class.getName());
	
	@BeforeClass
	public void setUp() {
		initializeBrowser() ;
		logger.info(browserName+" browser opened successfully");
		uName = new UsernamePage() ;
		utills = new Utills() ;
	}
	
	@Test(priority = 1)
	public void usernameScreenCMLogoImageTest() {
		boolean flag = uName.validateCMImage() ;
		Assert.assertTrue(flag);
	}
	
	@Test(priority = 2)
	public void blankUsernameTest() {
		uName.enterUsername("") ;
		logger.debug("Entered Username");
		uName.clickNextButton() ;
		logger.debug("Clicked on Next button");
		Assert.assertEquals(utills.readErrorMessage(), "Must Enter User Name\n" + "User name not entered") ;
	}
	
	@Test(priority = 4)
	public void validUsernameTest() {
		pwd = uName.navigateToPasswordPage(prop.getProperty("clientUser")) ;
		logger.debug("Clicked on Next button");
		Assert.assertTrue(pwd.validateCMImage()) ;
	}
	
	@Test(priority = 3)
	public void verifyUserNameScreenFooterText() {
		String footerText = uName.getFooterText() ;
		Assert.assertEquals(footerText, prop.getProperty("footerText"));
	}
	
	@AfterClass
	public void tearDown() {
		driver.close();
	}

}
