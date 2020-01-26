package com.cm.qa.testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.cm.qa.pages.UsernamePage;
import com.cm.qa.utills.DataProviderClass;
import com.cm.qa.utills.Utills;

import cm.cm.qa.base.TestBase;

public class ProfilePageTests extends TestBase{
	
	Logger logger = LogManager.getLogger(ProfilePageTests.class.getName());

	@BeforeClass
	public void setUp() {
		initializeBrowser() ;
		logger.info(browserName+" browser opened successfully");
		uName = new UsernamePage() ;
		utills = new Utills() ;
		pwd = uName.navigateToPasswordPage(prop.getProperty("clientUser")) ;
		logger.info("Navigated to Password screen");
		dashboard = pwd.login(prop.getProperty("clientUserPassword")) ;
		logger.info("Logged into application");
		profile = dashboard.gotoProfilePage();
		logger.info("Navigated to Profile screen");
	}

	@Test(priority = 101)
	public void updateProfilePicture() {
		profile.changeProfilePicture();
		Assert.assertEquals(utills.readSuccessMessage(), "Profile Image updated\n" + "Operation Complete");
		logger.info("Profile picture chages successfully");

	}	

	@Test(priority = 104, dataProvider = "invalidName", dataProviderClass = DataProviderClass.class)
	public void invalidFirstNameTest(String name) {
		profile.clickOnEditButton();
		logger.debug("Clicked on Edit button");
		profile.enterFirstName(name);
		logger.debug("Entered First name");
		profile.clickOnUpdateButton();
		logger.debug("Clicked on Update button");
		Assert.assertEquals(utills.readFieldErrorMessage(), "Incorrect data, Alphanumeric values with only Special characters _ ' and spaces are allowed");
		logger.info("Validated validation for invalid first name");
		profile.clickOnCancelButton();
		logger.debug("Clicked on Cancel button");
	}

	@Test(priority = 105, dataProvider = "invalidName", dataProviderClass = DataProviderClass.class)
	public void invalidLastNameTest(String name) {
		profile.clickOnEditButton();
		logger.debug("Clicked on Edit button");
		profile.enterLastName(name);
		logger.debug("Entered Last name");
		profile.clickOnUpdateButton();
		logger.debug("Clicked on Update button");
		Assert.assertEquals(utills.readFieldErrorMessage(), "Incorrect data, Alphanumeric values with only Special characters _ ' and spaces are allowed");
		logger.info("Validated validation for invalid  Last name");
		profile.clickOnCancelButton();
		logger.debug("Clicked on Cancel button");
	}	

	@Test(priority = 106, dataProvider = "userName", dataProviderClass = DataProviderClass.class)
	public void updateUserNameTest(String firstName, String lastName) {
		profile.clickOnEditButton();
		logger.debug("Clicked on Edit button");
		profile.updateUserName(firstName, lastName);
		Assert.assertEquals(utills.readSuccessMessage(), "User Profile Updated Successfully\n" + "Operation Complete");
		logger.info("Updated Username");
		Assert.assertEquals(profile.getUserName(firstName +" "+lastName), firstName +" "+lastName);
		logger.info("Validated correct username is displayed after updating username");
	}	

	@AfterClass
	public void tearDown() {
		driver.close();
	}

}
