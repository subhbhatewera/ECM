package com.cm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.cm.qa.pages.OtherCommercialTermsPage;
import com.cm.qa.pages.UsernamePage;
import com.cm.qa.utills.DataProviderClass;
import com.cm.qa.utills.Utills;

import cm.cm.qa.base.ActionClass;

public class OtherCommercialTermsPageTests extends ActionClass{

	public OtherCommercialTermsPageTests() {
		super() ;
	}

	@BeforeClass
	public void setUp() {
		initializeBrowser() ;
		uName = new UsernamePage() ;
		utills = new Utills() ;
		otherCommercials = new OtherCommercialTermsPage() ;
		pwd = uName.navigateToPasswordPage(prop.getProperty("clientUser")) ;
		dashboard = pwd.login(prop.getProperty("clientUserPassword")) ;
		sleep(7000);		
	}

	@Test(priority = 71, dataProvider = "cola", dataProviderClass = DataProviderClass.class)
	public void addCOLATest(String contractTitle, String clause, String type, String indexType, String applicableFrom, String revisionFrequency, 
			String noticePeriodValue, String noticePeriodDuration, String percentage, String status, String referenceNo,
			String relatedReferenceNo, String reminder) {
		contractList = dashboard.gotoContractListPage() ;
		generalInformation = contractList.clickOnEditContractIcon(contractTitle);
		otherCommercials.clickOnOtherCommercialTermsTab()
		.clickOnCOLATab()
		.fillCOLAForm(clause, type, indexType, applicableFrom, revisionFrequency, noticePeriodValue, noticePeriodDuration, percentage, 
				status, referenceNo,relatedReferenceNo, reminder)
		.clickOnSaveAndContinueButton();
		Assert.assertEquals(utills.readSuccessMessage(), "COLA successfully updated\n"+"Operation Complete");
	}	

	@Test(priority = 72, dataProvider = "incentive", dataProviderClass = DataProviderClass.class)
	public void addIncentiveTest(String contractTitle, String clause, String referenceNo, String percentage, String type, String dateFrom, 
			String dateTo, String status, String noticePeriodValue, String noticePeriodDuration, String reminder) {
		contractList = dashboard.gotoContractListPage() ;
		generalInformation = contractList.clickOnEditContractIcon(contractTitle);
		otherCommercials.clickOnOtherCommercialTermsTab()
		.clickOnIncentiveTab()
		.fillIncentiveForm(clause, referenceNo, percentage, type, dateFrom, dateTo, status, noticePeriodValue, noticePeriodDuration, reminder)
		.clickOnSaveAndContinueButton();
		Assert.assertEquals(utills.readSuccessMessage(), "Incentive successfully updated\n"+"Operation Complete");
	}

	@Test(priority = 73, dataProvider = "penalty", dataProviderClass = DataProviderClass.class)
	public void addPenaltyTest(String contractTitle, String clause, String referenceNo, String relatedReferenceNo, String percentage, String type,
			String dateFrom, String dateTo, String status, String reminder) {
		contractList = dashboard.gotoContractListPage() ;
		generalInformation = contractList.clickOnEditContractIcon(contractTitle);
		otherCommercials.clickOnOtherCommercialTermsTab()
		.clickOnPenaltyTab()
		.fillPenaltyForm(clause, referenceNo, relatedReferenceNo, percentage, type, dateFrom, dateTo, status, reminder)
		.clickOnSaveAndContinueButton();
		Assert.assertEquals(utills.readSuccessMessage(), "Penalty successfully updated\n"+"Operation Complete");
	}		

	@Test(priority = 74, dataProvider = "earlyPaymentDiscount", dataProviderClass = DataProviderClass.class)
	public void addEarlyPaymentDiscountTest(String contractTitle, String clause, String referenceNo, String relatedReferenceNo, String percentage, String value,
			String billingCycle, String dateFrom, String dateTo, String status, String reminder) {
		contractList = dashboard.gotoContractListPage() ;
		generalInformation = contractList.clickOnEditContractIcon(contractTitle);
		otherCommercials.clickOnOtherCommercialTermsTab()
		.clickOnEarlyPaymentDiscountTab()
		.fillEarlyPaymentDiscountForm(clause, referenceNo, relatedReferenceNo, percentage, value, billingCycle,dateFrom, dateTo, status, reminder)
		.clickOnSaveAndContinueButton();
		Assert.assertEquals(utills.readSuccessMessage(), "Early Payment Discount successfully updated\n"+"Operation Complete");
	}

	@Test(priority = 75, dataProvider = "latePaymentFee", dataProviderClass = DataProviderClass.class)
	public void addLatePaymentFeeTest(String contractTitle, String clause, String referenceNo, String relatedReferenceNo, String invoiceDate, String noticePeriodValue,
			String noticePeriodDuration, String currency, String penaltyValue, String status, String reminder) {
		contractList = dashboard.gotoContractListPage() ;
		generalInformation = contractList.clickOnEditContractIcon(contractTitle);
		otherCommercials.clickOnOtherCommercialTermsTab()
		.clickOnLatePaymentFeeTab()
		.fillLatePaymentFeeForm(clause, referenceNo, relatedReferenceNo, invoiceDate, noticePeriodValue, noticePeriodDuration, currency, penaltyValue, status, reminder)
		.clickOnSaveAndContinueButton();
		Assert.assertEquals(utills.readSuccessMessage(), "Late Payment Fee successfully updated\n"+"Operation Complete");
	}

	@Test(priority = 76, dataProvider = "termination", dataProviderClass = DataProviderClass.class)
	public void addTerminationTest(String contractTitle, String clause, String type, String noticePeriodValue, String noticePeriodDuration, String term,
			String status, String referenceNo, String dateFrom, String dateTo, String currency, String value, String reminder) {
		contractList = dashboard.gotoContractListPage() ;
		generalInformation = contractList.clickOnEditContractIcon(contractTitle);
		otherCommercials.clickOnOtherCommercialTermsTab()
		.clickOnTerminationTab()
		.fillTerminationForm(clause, type, noticePeriodValue, noticePeriodDuration, term, status, referenceNo, dateFrom, dateTo, currency, value, reminder)
		.clickOnSaveAndContinueButton();
		Assert.assertEquals(utills.readSuccessMessage(), "Termination successfully updated\n"+"Operation Complete");
	}

	@Test(priority = 77, dataProvider = "limitationofLiability", dataProviderClass = DataProviderClass.class)
	public void addLimitationOfLiabilityTest(String contractTitle, String clause, String type, String currency, String value, String referenceNo) {
		contractList = dashboard.gotoContractListPage() ;
		generalInformation = contractList.clickOnEditContractIcon(contractTitle);
		otherCommercials.clickOnOtherCommercialTermsTab()
		.clickOnLimitationOfLiabilityTab()
		.fillLimitationOfLiabilityForm(clause, type, currency, value, referenceNo)
		.clickOnSaveAndContinueButton();
		Assert.assertEquals(utills.readSuccessMessage(), "Limitation of Liability successfully updated\n"+"Operation Complete");
	}	

	@AfterClass
	public void tearDown() {
		driver.close();
	}

}
