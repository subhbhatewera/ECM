package com.cm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.cm.qa.pages.ContractListPage;
import com.cm.qa.pages.DashboardPage;
import com.cm.qa.pages.GeneralInformationPage;
import com.cm.qa.pages.PasswordPage;
import com.cm.qa.pages.SLAPage;
import com.cm.qa.pages.UsernamePage;
import com.cm.qa.utills.DataProviderClass;
import com.cm.qa.utills.Utills;

import cm.cm.qa.base.TestBase;

public class SLAPageTests extends TestBase{

	UsernamePage uName ;
	PasswordPage pwd ;
	Utills utills ;
	DashboardPage dashboard ;
	ContractListPage contractList ;
	GeneralInformationPage generalInformation ;
	SLAPage sla ;

	public SLAPageTests() {
		super() ;
	}

	@BeforeClass
	public void setUp() {
		initializeBrowser() ;
		uName = new UsernamePage() ;
		utills = new Utills() ;
		sla = new SLAPage();
		pwd = uName.navigateToPasswordPage(prop.getProperty("clientUser")) ;
		dashboard = pwd.login(prop.getProperty("clientUserPassword")) ;
	}

	@Test(priority = 81, dataProvider = "tat", dataProviderClass = DataProviderClass.class)
	public void addTATTest(String contractTitle, String clause, String referenceNo, String relatedReferenceNo, String status, 
			String currency, String performancePay, String type, String hours, String reminder) {
		contractList = dashboard.gotoContractListPage() ;
		generalInformation = contractList.clickOnEditContractIcon(contractTitle);
		sla.clickOnSLATab()
		.fillTATForm(clause, referenceNo, relatedReferenceNo, status, currency,performancePay, type, hours, reminder)
		.clickOnSaveAndContinueButton();
		Assert.assertEquals(utills.readSuccessMessage(), "Contract successfully updated\n"+"Operation Success");
	}

	@Test(priority = 82, dataProvider = "quality", dataProviderClass = DataProviderClass.class)
	public void addQualityTest(String contractTitle, String clause, String referenceNo, String relatedReferenceNo, String status, 
			String preShipment, String CAL, String dateReported, String CQR, String type, String currency, String performancePay, String reminder) {
		contractList = dashboard.gotoContractListPage() ;
		generalInformation = contractList.clickOnEditContractIcon(contractTitle);
		sla.clickOnSLATab()
		.clickOnQualityab()
		.fillQualityForm(clause, referenceNo, relatedReferenceNo, status, preShipment, CAL, dateReported, CQR, type, currency, performancePay, reminder)
		.clickOnSaveAndContinueButton();
		Assert.assertEquals(utills.readSuccessMessage(), "Contract successfully updated\n"+"Operation Success");
	}

	@Test(priority = 83, dataProvider = "upTime", dataProviderClass = DataProviderClass.class)
	public void addUptimeTest(String contractTitle, String clause, String referenceNo, String relatedReferenceNo, String status, 
			String uptimeHours, String type, String currency, String performancePay, String reminder) {
		contractList = dashboard.gotoContractListPage() ;
		generalInformation = contractList.clickOnEditContractIcon(contractTitle);
		sla.clickOnSLATab()
		.clickOnUptimeTab()
		.fillUptimeForm(clause, referenceNo, relatedReferenceNo, status, uptimeHours, type, currency, performancePay, reminder)
		.clickOnSaveAndContinueButton();
		Assert.assertEquals(utills.readSuccessMessage(), "Contract successfully updated\n"+"Operation Success");
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
