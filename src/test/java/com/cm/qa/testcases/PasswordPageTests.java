package com.cm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.cm.qa.pages.DashboardPage;
import com.cm.qa.pages.PasswordPage;
import com.cm.qa.pages.UsernamePage;
import com.cm.qa.utills.Utills;

import cm.cm.qa.base.TestBase;

public class PasswordPageTests extends TestBase{

	UsernamePage uName ;
	PasswordPage pwd ;
	Utills utills ;
	DashboardPage dashboard ;

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
		Assert.assertEquals(utills.readErrorMessage(), "Must input password!\n" + "Error") ;		
	}

	@Test(priority = 7)
	public void invalidPasswordTest() {
		pwd.login("wrong password");
		Assert.assertEquals(utills.readErrorMessage(), "Invalid username/password or your account has been blocked\n" + 
				"Wrong credentials") ;
	}
	
	@Test(priority = 8)
	public void verifyFooterTextTest() {
		Assert.assertEquals(pwd.getFooterText(), prop.getProperty("footerText"));
	}

	@Test(priority = 9)
	public void validPasswordTest() {
		dashboard = pwd.login(prop.getProperty("clientUserPassword")) ;
		Assert.assertEquals(dashboard.verifyDashboardPageHeading(), "Dashboard");
	}	

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
