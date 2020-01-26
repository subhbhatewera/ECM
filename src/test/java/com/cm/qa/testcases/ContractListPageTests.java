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

public class ContractListPageTests extends TestBase{
	
	Logger logger = LogManager.getLogger(ContractListPageTests.class.getName());

	@BeforeClass
	public void setUp() {
		initializeBrowser() ;
		uName = new UsernamePage() ;
		logger.info(browserName+" browser opened successfully");
		utills = new Utills() ;
		pwd = uName.navigateToPasswordPage(prop.getProperty("clientUser")) ;
		logger.info("Navigated to Password screen");
		dashboard = pwd.login(prop.getProperty("clientUserPassword")) ;
		logger.info("Logged into application");
		contractList = dashboard.gotoContractListPage() ;
	}

	@Test(priority = 14)
	public void validateAddContractButtonTest() {
		generalInformation = contractList.clickOnAddContractButton() ;
		logger.debug("Clicked on 'Add Contract button");
		Assert.assertEquals(generalInformation.verifyAddContractHeading(), "Add Contract");
		logger.info("Add-Edit Contract Form is displayed");
	}
	
	@Test(priority = 15, enabled = false)
	public void validateEditContractIconTest() {
		generalInformation = contractList.clickOnEditContractIcon("BancTec");
		Assert.assertEquals(generalInformation.verifyEditContractHeading(), "Edit Contract");
	}

	@AfterClass
	public void tearDown() {
		driver.close();
	}

}
