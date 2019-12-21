package com.cm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.cm.qa.pages.ContractListPage;
import com.cm.qa.pages.DashboardPage;
import com.cm.qa.pages.DocSearchPage;
import com.cm.qa.pages.NotificationPage;
import com.cm.qa.pages.PasswordPage;
import com.cm.qa.pages.UsernamePage;
import com.cm.qa.utills.Utills;

import cm.cm.qa.base.TestBase;

public class DashboardPageTests extends TestBase{

	UsernamePage uName ;
	PasswordPage pwd ;
	Utills utills ;
	DashboardPage dashboard ;
	ContractListPage contractlist ;
	DocSearchPage docsearch ;
	NotificationPage notification ;

	public DashboardPageTests() {
		super() ;
	}

	@BeforeClass
	public void setUp() {
		initializeBrowser() ;
		uName = new UsernamePage() ;
		utills = new Utills() ;
		pwd = uName.navigateToPasswordPage(prop.getProperty("clientUser")) ;
		dashboard = pwd.login(prop.getProperty("clientUserPassword")) ;
	}

	@Test(priority = 10)
	public void verifyLandingPageTest() {
		Assert.assertEquals(dashboard.verifyDashboardPageHeading(), "Dashboard");
	}
	
	@Test(priority = 11)
	public void validateContractListLinkTest() {
		contractlist = dashboard.gotoContractListPage() ;
		Assert.assertEquals(contractlist.verifyContractListPageHeading(), "Contract List");
	}
	
	@Test(priority = 12)
	public void validateDocSearchLinkTest() {
		docsearch = dashboard.gotoDocSearchPage() ;
		Assert.assertEquals(docsearch.verifyDocSearchPageHeading(), "Doc Search");
	}
	
	@Test(priority = 13)
	public void validateNotificationLinkTest() {
		notification = dashboard.gotoNotificationPage() ;
		Assert.assertEquals(notification.verifyNotificationPageHeading(), "Notification");
	}	
	
	@AfterClass
	public void tearDown() {
		driver.close();
	}

}
