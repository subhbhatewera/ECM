package com.cm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import com.cm.qa.pages.DashboardPage;

import com.cm.qa.pages.PasswordPage;
import com.cm.qa.pages.ProfilePage;
import com.cm.qa.pages.UsernamePage;
import com.cm.qa.utills.DataProviderClass;
import com.cm.qa.utills.Utills;

import cm.cm.qa.base.TestBase;

public class ProfilePageTests extends TestBase{

	UsernamePage uName ;
	PasswordPage pwd ;
	Utills utills ;
	DashboardPage dashboard ;
	ProfilePage profile;

	public ProfilePageTests() {
		super() ;
	}

	@BeforeMethod
	public void setUp() {
		initializeBrowser() ;
		uName = new UsernamePage() ;
		utills = new Utills() ;
		pwd = uName.navigateToPasswordPage(prop.getProperty("clientUser")) ;
		dashboard = pwd.login(prop.getProperty("clientUserPassword")) ;
		profile = dashboard.gotoProfilePage();
	}

	@Test(priority = 101)
	public void updateProfilePicture() {
		profile.changeProfilePicture("C:\\Users\\subhash.bhatewera\\Pictures\\n.jpg");
		//	profile.changeProfilePicture("C:\\Users\\subhash.bhatewera\\Desktop\\forgot-bg.png");
		Assert.assertEquals(utills.readSuccessMessage(), "User profile updated successfully");

	}

	@Test(priority = 102)
	public void blankFirstNameTest() {
		profile.clickOnEditButton()
		.enterFirstName("")
		.clickOnUpdateButton();
		Assert.assertEquals(utills.readFieldErrorMessage(), "First Name is required");
	}

	@Test(priority = 103)
	public void blankLastNameTest() {
		profile.clickOnEditButton()
		.enterLastName("")
		.clickOnUpdateButton();
		Assert.assertEquals(utills.readFieldErrorMessage(), "Last Name is required");
	}

	@Test(priority = 104, dataProvider = "invalidName", dataProviderClass = DataProviderClass.class)
	public void invalidFirstNameTest(String name) {
		profile.clickOnEditButton()
		.enterFirstName(name)
		.clickOnUpdateButton();
		Assert.assertEquals(utills.readFieldErrorMessage(), "Incorrect data, Alphanumeric values with only Special characters _ ' and spaces are allowed");
	}

	@Test(priority = 105, dataProvider = "invalidName", dataProviderClass = DataProviderClass.class)
	public void invalidLastNameTest(String name) {
		profile.clickOnEditButton()
		.enterLastName(name)
		.clickOnUpdateButton();
		Assert.assertEquals(utills.readFieldErrorMessage(), "Incorrect data, Alphanumeric values with only Special characters _ ' and spaces are allowed");
	}	

	@Test(priority = 106, dataProvider = "userName", dataProviderClass = DataProviderClass.class)
	public void updateUserNameTest(String firstName, String lastName) {
		profile.clickOnEditButton()
		.updateUserName(firstName, lastName);
		Assert.assertEquals(utills.readSuccessMessage(), "User profile updated successfully");
		Assert.assertEquals(profile.getUserName(firstName +" "+lastName), firstName +" "+lastName);
	}	

	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
