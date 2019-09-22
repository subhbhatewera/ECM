package com.cm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cm.qa.pages.PasswordPage;
import com.cm.qa.pages.UsernamePage;
import com.cm.qa.utills.Utills;

import cm.cm.qa.base.TestBase;

public class UsernamePageTests extends TestBase {
	
	UsernamePage uName ;
	PasswordPage pwd ;
	Utills utills ;
	
	
	public UsernamePageTests() {
		super() ;
	}
	
	@BeforeMethod
	public void setUp() {
		initializeBrowser() ;
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
		uName.clickNextButton() ;
		Assert.assertEquals(utills.readErrorMessage(), "Must input username or email!\n" + "Error") ;
	}
	
	@Test(priority = 3)
	public void validUsernameTest() {
		pwd = uName.navigateToPasswordPage(prop.getProperty("clientUser")) ;
		Assert.assertTrue(pwd.validateCMImage()) ;
	}
	
	@Test(priority = 4)
	public void verifyFooterText() {
		String footerText = uName.getFooterText() ;
		Assert.assertEquals(footerText, prop.getProperty("footerText"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}