package com.cm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.cm.qa.pages.ContractListPage;
import com.cm.qa.pages.DashboardPage;
import com.cm.qa.pages.GeneralInformationPage;
import com.cm.qa.pages.PasswordPage;
import com.cm.qa.pages.TermPage;
import com.cm.qa.pages.UsernamePage;
import com.cm.qa.utills.DataProviderClass;
import com.cm.qa.utills.Utills;

import cm.cm.qa.base.TestBase;

public class TermPageTests extends TestBase{

	UsernamePage uName ;
	PasswordPage pwd ;
	Utills utills ;
	DashboardPage dashboard ;
	ContractListPage contractList ;
	GeneralInformationPage generalInformation ;
	TermPage term ;

	public TermPageTests() {
		super() ;
	}

	@BeforeClass
	public void setUp() {
		initializeBrowser() ;
		uName = new UsernamePage() ;
		utills = new Utills() ;
		term = new TermPage() ;
		pwd = uName.navigateToPasswordPage(prop.getProperty("clientUser")) ;
		dashboard = pwd.login(prop.getProperty("clientUserPassword")) ;
	}

	@Test(priority = 31, dataProvider = "termData", dataProviderClass = DataProviderClass.class)
	public void addTermTest(String ContractTitle, String ContractType, String StartDate, String SignedDate, String EndDate,
			String ContractTermValue, String TermDuration, String RenewalType, String NoticePeriodForRenewal, String NoticePeriodDuration,
			String GracePeriod, String GracePeriodDuration, String Description) {
		contractList = dashboard.gotoContractListPage() ;
		generalInformation = contractList.clickOnEditContractIcon(ContractTitle);
		term.clickTermTab()
		.fillTermForm(ContractType, StartDate, SignedDate, EndDate, ContractTermValue, TermDuration, RenewalType, NoticePeriodForRenewal, 
				NoticePeriodDuration, GracePeriod, GracePeriodDuration, Description)
		.clickOnSaveAndContinueButton();
		Assert.assertEquals(utills.readSuccessMessage(), "Contract successfully updated\n"+"Operation Success");
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
