package com.cm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cm.qa.pages.TermPage;
import com.cm.qa.pages.UsernamePage;
import com.cm.qa.utills.DataProviderClass;
import com.cm.qa.utills.Utills;

import cm.cm.qa.base.ActionClass;

public class TermPageTests extends ActionClass{
	
	public TermPageTests() {
		super() ;
	}

	@BeforeClass()
	public void setUp() {
		initializeBrowser() ;
		uName = new UsernamePage() ;
		utills = new Utills() ;
		term = new TermPage() ;
		pwd = uName.navigateToPasswordPage(prop.getProperty("clientUser")) ;
		dashboard = pwd.login(prop.getProperty("clientUserPassword")) ;	
		sleep(7000);
	}
	
	@BeforeMethod
	public void openTermForm() {
		contractList = dashboard.gotoContractListPage() ;
	}

	@Test(priority = 31, dataProvider = "termData", dataProviderClass = DataProviderClass.class)
	public void addTermTest(String ContractTitle, String ContractType, String StartDate, String SignedDate, String EndDate,
			String RenewalType, String NoticePeriodForRenewal, String NoticePeriodDuration,
			String GracePeriod, String GracePeriodDuration, String Description) {
		generalInformation = contractList.clickOnEditContractIcon(ContractTitle);
		term.clickTermTab()
		.fillTermForm(ContractType, StartDate, SignedDate, EndDate, RenewalType, NoticePeriodForRenewal, 
				NoticePeriodDuration, GracePeriod, GracePeriodDuration, Description)
		.clickOnSaveAndContinueButton();
		if(ContractType.equalsIgnoreCase("Fixed Period")) {
			Assert.assertEquals(utills.readSuccessMessage(), "Fixed Period successfully updated\n"+"Operation Complete");	
		}
		else if(ContractType.equalsIgnoreCase("Fixed Period Without Renewal")) {
			Assert.assertEquals(utills.readSuccessMessage(), "Fixed Period Without Renewal successfully updated\n"+"Operation Complete");
		}
		else if(ContractType.equalsIgnoreCase("Open Ended")) {
			Assert.assertEquals(utills.readSuccessMessage(), "Open Ended Contracts successfully updated\n"+"Operation Complete");
		}
		
	}

	@AfterClass
	public void tearDown() {
		driver.close();
	}

}
