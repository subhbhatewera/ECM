package com.cm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.cm.qa.pages.UsernamePage;
import com.cm.qa.utills.Utills;

import cm.cm.qa.base.ActionClass;

public class PasswordPageTests extends ActionClass{

	public PasswordPageTests() {
		super() ;
	}

	@BeforeClass
	public void setUp() {
		initializeBrowser() ;
		uName = new UsernamePage() ;
		utills = new Utills() ;
		pwd = uName.navigateToPasswordPage(prop.getProperty("clientUser")) ;
	}

	@Test(priority = 5)
	public void verifyUsernameLabelTest() {
		Assert.assertEquals(pwd.validateUsernameLabel(), prop.getProperty("clientUser"));
	}

	@Test(priority = 6)
	public void blankPasswordTest() {
		pwd.login("") ;
		Assert.assertEquals(utills.readErrorMessage(), "Must Enter Password!\n" + "Password not entered") ;		
	}

	@Test(priority = 7)
	public void invalidPasswordTest() {
		sleep(3000);
		pwd.login("wrong password");
		Assert.assertEquals(utills.readErrorMessage(), "Invalid Username/Password\n" + 
				"Error") ;
	}

	@Test(priority = 9)
	public void validPasswordTest() {
		dashboard = pwd.login(prop.getProperty("clientUserPassword")) ;		
		Assert.assertEquals(dashboard.verifyDashboardPageHeading(), "Dashboard");
	}

	@Test(priority = 8)
	public void verifyFooterTextTest() {
		Assert.assertEquals(pwd.getFooterText(), prop.getProperty("footerText"));
	}

	@AfterClass
	public void tearDown() {
		driver.close();
	}

}
