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

public class DashboardPageTests extends TestBase{

	Logger logger = LogManager.getLogger(DashboardPageTests.class.getName());

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
	}

	@Test(priority = 10)
	public void verifyLandingPageTest() {
		Assert.assertEquals(dashboard.verifyDashboardPageHeading(), "Dashboard");
		logger.info("Verified landing page");
	}
	
	@Test(priority = 11)
	public void validateContractListLinkTest() {
		contractList = dashboard.gotoContractListPage() ;
		Assert.assertEquals(contractList.verifyContractListPageHeading(), "Contract List");
		logger.info("Navigate to Contract List screen");
	}
	
	@Test(priority = 12)
	public void validateDocSearchLinkTest() {
		docSearch = dashboard.gotoDocSearchPage() ;
		Assert.assertEquals(docSearch.verifyDocSearchPageHeading(), "Doc Search");
		logger.info("Navigate to Doc Search screen");
	}
	
	@Test(priority = 13)
	public void validateNotificationLinkTest() {
		notification = dashboard.gotoNotificationPage() ;
		Assert.assertEquals(notification.verifyNotificationPageHeading(), "Notification");
		logger.info("Navigate to Notification screen");
	}	
	
	@AfterClass
	public void tearDown() {
		driver.close();
	}

}
