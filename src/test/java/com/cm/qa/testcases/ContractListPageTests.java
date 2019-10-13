package com.cm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.cm.qa.pages.ContractListPage;
import com.cm.qa.pages.DashboardPage;
import com.cm.qa.pages.GeneralInformationPage;
import com.cm.qa.pages.PasswordPage;
import com.cm.qa.pages.UsernamePage;
import com.cm.qa.utills.Utills;

import cm.cm.qa.base.TestBase;

public class ContractListPageTests extends TestBase{

	UsernamePage uName ;
	PasswordPage pwd ;
	Utills utills ;
	DashboardPage dashboard ;
	ContractListPage contractList ;
	GeneralInformationPage generalInformation ;

	public ContractListPageTests() {
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

	@Test(priority = 14)
	public void validateAddContractButtonTest() {
		contractList = dashboard.gotoContractListPage() ;
		generalInformation = contractList.clickOnAddContractButton() ;
		Assert.assertEquals(generalInformation.verifyAddContractHeading(), "Add Contract");
	}

	@Test(priority = 15, enabled = false)
	public void validateEditContractIconTest() {
		contractList = dashboard.gotoContractListPage() ;
		generalInformation = contractList.clickOnEditContractIcon("BancTec");
		Assert.assertEquals(generalInformation.verifyEditContractHeading(), "Edit Contract");
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
