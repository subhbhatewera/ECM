package com.cm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cm.qa.pages.CommercialsPage;
import com.cm.qa.pages.UsernamePage;
import com.cm.qa.utills.DataProviderClass;
import com.cm.qa.utills.Utills;

import cm.cm.qa.base.ActionClass;

public class CommercialsPageTests extends ActionClass{

	public CommercialsPageTests() {
		super() ;
	}

	@BeforeClass
	public void setUp() {
		initializeBrowser() ;
		uName = new UsernamePage() ;
		utills = new Utills() ;
		commercials = new CommercialsPage();
		pwd = uName.navigateToPasswordPage(prop.getProperty("clientUser")) ;
		dashboard = pwd.login(prop.getProperty("clientUserPassword")) ;	
		sleep(7000);
	}
	
	@BeforeMethod
	public void openGeneralInformationForm() {
		contractList = dashboard.gotoContractListPage() ;	
	}

	@Test(priority = 41, enabled = true, dataProvider = "generalTerms", dataProviderClass = DataProviderClass.class)
	public void addGeneralTermsTest(String contractTitle, String billingFrequency, String creditPeriodValue, String creditPeriodDuration, String billingStartDate, String billingEndDate, String billingCurrency, String clause) {
		generalInformation = contractList.clickOnEditContractIcon(contractTitle);
		commercials.clickOnCommercialsTab()
		.fillGeneralTermsForm(billingFrequency, creditPeriodValue, creditPeriodDuration, billingStartDate, billingEndDate, billingCurrency, clause)
		.clickOnListingScreenSaveButton();
		Assert.assertEquals(utills.readSuccessMessage(), "General Terms successfully updated\n"+"Operation Complete");
	}

	@Test(priority = 42, enabled = true, dataProvider = "uom", dataProviderClass = DataProviderClass.class)
	public void addUOMTest(String contractTitle, String uomName) {
		generalInformation = contractList.clickOnEditContractIcon(contractTitle);
		commercials.clickOnCommercialsTab()
		.clickOnTransactionRateStandardTab()
		.clickOnAddButton()
		.addUOM(uomName);
		Assert.assertEquals(utills.readSuccessMessage(), "UOM successfully added\n"+"Operation Complete");
		Assert.assertEquals(commercials.getSelectDropDownOption(), uomName);
	}

	@Test(priority = 43, enabled = true, dataProvider = "linkedOpportunity", dataProviderClass = DataProviderClass.class)
	public void addLinkedOpportunityTest(String contractTitle, String linkedOpportunityName) {
		generalInformation = contractList.clickOnEditContractIcon(contractTitle);
		commercials.clickOnCommercialsTab()
		.clickOnTransactionRateStandardTab()
		.clickOnAddButton()
		.addLinkedOpportunity(linkedOpportunityName);
		Assert.assertEquals(utills.readSuccessMessage(), "Linked Opportunity successfully added\n"+"Operation Complete");
		Assert.assertEquals(commercials.getSelectDropDownOption(), linkedOpportunityName);
	}

	@Test(priority = 44, enabled = true, dataProvider = "service", dataProviderClass = DataProviderClass.class)
	public void addServiceTest(String contractTitle, String serviceName) {
		generalInformation = contractList.clickOnEditContractIcon(contractTitle);
		commercials.clickOnCommercialsTab()
		.clickOnTransactionRateStandardTab()
		.clickOnAddButton()
		.addService(serviceName);
		Assert.assertEquals(utills.readSuccessMessage(), "Service successfully added\n"+"Operation Complete");
		Assert.assertEquals(commercials.getSelectDropDownOption(), serviceName);
	}

	@Test(priority = 45, enabled = true, dataProvider = "subService", dataProviderClass = DataProviderClass.class)
	public void addSubServiceTest(String contractTitle, String subServiceName) {
		generalInformation = contractList.clickOnEditContractIcon(contractTitle);
		commercials.clickOnCommercialsTab()
		.clickOnTransactionRateStandardTab()
		.clickOnAddButton()
		.addSubService(subServiceName);
		Assert.assertEquals(utills.readSuccessMessage(), "Sub service successfully added\n"+"Operation Complete");
		Assert.assertEquals(commercials.getSelectDropDownOption(), subServiceName);
	}

	@Test(priority = 46, enabled = true, dataProvider = "project", dataProviderClass = DataProviderClass.class)
	public void addProjectTest(String contractTitle, String projectName) {
		generalInformation = contractList.clickOnEditContractIcon(contractTitle);
		commercials.clickOnCommercialsTab()
		.clickOnTransactionRateStandardTab()
		.clickOnAddButton()
		.addProject(projectName);
		Assert.assertEquals(utills.readSuccessMessage(), "Project successfully added\n"+"Operation Complete");
		Assert.assertEquals(commercials.getSelectDropDownOption(), projectName);
	}	

	@Test(priority = 47, enabled = true, dataProvider = "transactionRateStandard", dataProviderClass = DataProviderClass.class)
	public void addTransactionRateStandardTest(String contractTitle, String lineItem, String currency, String rate, String UOM, String effectiveStartDate, String effectiveEndDate, String referenceNo,
			String relatedReferenceNo, String platformsApplicable, String service, String subService, String location) {
		generalInformation = contractList.clickOnEditContractIcon(contractTitle);
		commercials.clickOnCommercialsTab()
		.clickOnTransactionRateStandardTab()
		.clickOnAddButton()
		.fillTransactionRateStandardForm(lineItem, currency, rate, UOM, effectiveStartDate, effectiveEndDate, referenceNo, relatedReferenceNo, platformsApplicable, service, subService, location)
		.clickOnAddScreenSaveButton();
		Assert.assertEquals(utills.readSuccessMessage(), "Transaction Rate Standard successfully added\n"+"Operation Complete");
		commercials.clickOnListingScreenSaveButton();
		Assert.assertEquals(utills.readSuccessMessage(), "Transaction Rate Standard successfully updated\n"+"Operation Complete");	
	}


	@Test(priority = 48, enabled = true, dataProvider = "transactionRateVolume", dataProviderClass = DataProviderClass.class)
	public void addTransactionRateVolumeTest(String contractTitle, String lineItem, String tierType, String volumeSplit, String volumeGroupName, String lowerTier, String upperTier, String rate, String applicableFactor, String UOM, 
			String effectiveStartDate, String effectiveEndDate, String referenceNo,	String relatedReferenceNo, String platformsApplicable, String service, String subService, String location) {
		generalInformation = contractList.clickOnEditContractIcon(contractTitle);
		commercials.clickOnCommercialsTab()
		.clickOnTransactionRateVolumeTab()
		.clickOnAddButton()
		.fillTransactionRateVolumeForm(lineItem, tierType, volumeSplit, volumeGroupName, lowerTier, upperTier, rate, applicableFactor, UOM, effectiveStartDate, effectiveEndDate, referenceNo, relatedReferenceNo, platformsApplicable, service, subService, location)
		.clickOnAddScreenSaveButton();
		Assert.assertEquals(utills.readSuccessMessage(), "Transaction Rate Volume successfully added\n"+"Operation Complete");
		commercials.clickOnListingScreenSaveButton();
		Assert.assertEquals(utills.readSuccessMessage(), "Transaction Rate Volume updated\n"+"Operation Complete");	
	}


	@Test(priority = 49, enabled = true, dataProvider = "timeAndMaterialModel", dataProviderClass = DataProviderClass.class)
	public void addTimeAndMaterialModelTest(String contractTitle, String description, String tableDescription, String effectiveDate, String rate, String tableUOM, String quantity, String effectiveStartDate, String effectiveEndDate, 
			String referenceNo,	String relatedReferenceNo, String platformsApplicable, String service, String subService, String location) {
		generalInformation = contractList.clickOnEditContractIcon(contractTitle);
		commercials.clickOnCommercialsTab()
		.clickOnTimeAndmaterialModelTab()
		.clickOnAddButton()
		.fillTimeAndMaterialModelForm(description, tableDescription, effectiveDate, rate, tableUOM, quantity, effectiveStartDate, effectiveEndDate, referenceNo, relatedReferenceNo, platformsApplicable, service, subService, location)
		.clickOnAddScreenSaveButton();
		Assert.assertEquals(utills.readSuccessMessage(), "Time and Material successfully added\n"+"Operation Complete");
		commercials.clickOnListingScreenSaveButton();
		Assert.assertEquals(utills.readSuccessMessage(), "Time and Material updated\n"+"Operation Complete");	
	}

	@Test(priority = 50, enabled = true, dataProvider = "fixedFee", dataProviderClass = DataProviderClass.class)
	public void addFixedFeeTest(String contractTitle, String lineItem, String currency, String rate, String UOM, String advanceBilling, String effectiveStartDate, String effectiveEndDate, 
			String applicablePeriod, String referenceNo, String relatedReferenceNo, String platformsApplicable, String service, String subService, String location) {
		generalInformation = contractList.clickOnEditContractIcon(contractTitle);
		commercials.clickOnCommercialsTab()
		.clickOnFixedFeeTab()
		.clickOnAddButton()
		.fillFixedFeeForm(lineItem, currency, rate, UOM, advanceBilling, effectiveStartDate, effectiveEndDate, applicablePeriod,referenceNo, relatedReferenceNo, platformsApplicable, service, subService, location)
		.clickOnAddScreenSaveButton();
		Assert.assertEquals(utills.readSuccessMessage(), "Fixed Fee successfully added\n"+"Operation Complete");
		commercials.clickOnListingScreenSaveButton();
		Assert.assertEquals(utills.readSuccessMessage(), "Fixed Fee successfully updated\n"+"Operation Complete");	
	}

	@Test(priority = 51, enabled = true, dataProvider = "minimumBilling", dataProviderClass = DataProviderClass.class)
	public void addMinimumBillingTest(String contractTitle, String lineItem, String type, String currency, String rate, String quantity, String UOM, String effectiveStartDate, String effectiveEndDate, 
			String applicablePeriod, String referenceNo, String relatedReferenceNo, String platformsApplicable, String service, String subService, String location) {
		generalInformation = contractList.clickOnEditContractIcon(contractTitle);
		commercials.clickOnCommercialsTab()
		.clickOnMinimumBillingTab()
		.clickOnAddButton()
		.fillMinimumBillingForm(lineItem, type, currency, rate, quantity, UOM, effectiveStartDate, effectiveEndDate, applicablePeriod,referenceNo, relatedReferenceNo, platformsApplicable, service, subService, location)
		.clickOnAddScreenSaveButton();
		Assert.assertEquals(utills.readSuccessMessage(), "Minimum Billing successfully added\n"+"Operation Complete");
		commercials.clickOnListingScreenSaveButton();
		Assert.assertEquals(utills.readSuccessMessage(), "Minimum Billing updated\n"+"Operation Complete");	
	}

	@Test(priority = 52, enabled = true, dataProvider = "editCommercials", dataProviderClass = DataProviderClass.class)
	public void editTransactionRateStandardTest(String contractTitle) {
		generalInformation = contractList.clickOnEditContractIcon(contractTitle);
		commercials.clickOnCommercialsTab()
		.clickOnTransactionRateStandardTab()
		.clickOnEditIcon("Standard")
		.enterLineItem("Edit Standard")
		.enterRate("200")
		.selectUOM("Contract")
		.clickOnAddScreenSaveButton();
		Assert.assertEquals(utills.readSuccessMessage(), "Transaction Rate Standard successfully updated\n"+"Operation Complete");
		commercials.clickOnListingScreenSaveButton();
		Assert.assertEquals(utills.readSuccessMessage(), "Transaction Rate Standard successfully updated\n"+"Operation Complete");
	}

	@Test(priority = 53, enabled = true, dataProvider = "editCommercials", dataProviderClass = DataProviderClass.class)
	public void copyTransactionRateStandardTest(String contractTitle) {
		generalInformation = contractList.clickOnEditContractIcon(contractTitle);
		commercials.clickOnCommercialsTab()
		.clickOnTransactionRateStandardTab()
		.clickOnCopyIcon("Edit Standard");
		Assert.assertEquals(utills.readSuccessMessage(), "Transaction Rate Standard copied\n"+"Operation Complete");		
	}

	@Test(priority = 54, enabled = true, dataProvider = "editCommercials", dataProviderClass = DataProviderClass.class)
	public void deleteTransactionRateStandardTest(String contractTitle) {
		generalInformation = contractList.clickOnEditContractIcon(contractTitle);
		commercials.clickOnCommercialsTab()
		.clickOnTransactionRateStandardTab()
		.clickOnDeleteIcon("Edit Standard")
		.clickOnConfirmationPopUpYesButton();
		Assert.assertEquals(utills.readSuccessMessage(), "Transaction Rate Standard successfully deleted\n"+"Operation Complete");
	}

	@Test(priority = 55, enabled = true, dataProvider = "editCommercials", dataProviderClass = DataProviderClass.class)
	public void editTransactionRateVolumeTest(String contractTitle) {
		generalInformation = contractList.clickOnEditContractIcon(contractTitle);
		commercials.clickOnCommercialsTab()
		.clickOnTransactionRateVolumeTab()
		.clickOnEditIcon("Volume")
		.enterLineItem("Edit Volume")
		.selectTierType("Group", "", "Exela")
		.clickOnActionColumnEditIcon()
		.enterLowerTier("10")
		.enterUpperTier("20")
		.enterTableRate("50")
		.selectApplicableFactor("Flat")
		.clickOnActionColumnEditIcon()
		.clickOnAddScreenSaveButton();
		Assert.assertEquals(utills.readSuccessMessage(), "Transaction Rate Volume successfully updated\n"+"Operation Complete");
		commercials.clickOnListingScreenSaveButton();
		Assert.assertEquals(utills.readSuccessMessage(), "Transaction Rate Volume updated\n"+"Operation Complete");	
	}

	@Test(priority = 56, enabled = true, dataProvider = "editCommercials", dataProviderClass = DataProviderClass.class)
	public void copyTransactionRateVolumeTest(String contractTitle) {
		generalInformation = contractList.clickOnEditContractIcon(contractTitle);
		commercials.clickOnCommercialsTab()
		.clickOnTransactionRateVolumeTab()
		.clickOnCopyIcon("Edit Volume");
		Assert.assertEquals(utills.readSuccessMessage(), "Transaction Rate Volume copied\n"+"Operation Complete");		
	}

	@Test(priority = 57, enabled = true, dataProvider = "editCommercials", dataProviderClass = DataProviderClass.class)
	public void deleteTransactionRateVolumeTest(String contractTitle) {
		generalInformation = contractList.clickOnEditContractIcon(contractTitle);
		commercials.clickOnCommercialsTab()
		.clickOnTransactionRateVolumeTab()
		.clickOnDeleteIcon("Edit Volume")
		.clickOnConfirmationPopUpYesButton();
		Assert.assertEquals(utills.readSuccessMessage(), "Transaction Rate Volume successfully deleted\n"+"Operation Complete");
	}

	@Test(priority = 58, enabled = true, dataProvider = "editCommercials", dataProviderClass = DataProviderClass.class)
	public void editTimeAndMaterialModelTest(String contractTitle) {
		generalInformation = contractList.clickOnEditContractIcon(contractTitle);
		commercials.clickOnCommercialsTab()
		.clickOnTimeAndmaterialModelTab()
		.clickOnEditIcon("Time and Material Model")
		.enterDescription("Edit Time and Material Model")
		.clickOnActionColumnEditIcon()
		.enterTableDescription("20%")
		.enterEffectiveDate("01/2/2019")
		.enterTableRate("250")
		.selectTableUOM("Contract")
		.enterTableQuantity("20")
		.clickOnActionColumnEditIcon()
		.clickOnAddScreenSaveButton();
		Assert.assertEquals(utills.readSuccessMessage(), "Time and Material successfully updated\n"+"Operation Complete");
		commercials.clickOnListingScreenSaveButton();
		Assert.assertEquals(utills.readSuccessMessage(), "Time and Material updated\n"+"Operation Complete");	
	}

	@Test(priority = 59, enabled = true, dataProvider = "editCommercials", dataProviderClass = DataProviderClass.class)
	public void copyTimeAndMaterialModelTest(String contractTitle) {
		generalInformation = contractList.clickOnEditContractIcon(contractTitle);
		commercials.clickOnCommercialsTab()
		.clickOnTimeAndmaterialModelTab()
		.clickOnCopyIcon("Edit Time and Material Model");
		Assert.assertEquals(utills.readSuccessMessage(), "Time and Material copied\n"+"Operation Complete");		
	}

	@Test(priority = 60, enabled = true, dataProvider = "editCommercials", dataProviderClass = DataProviderClass.class)
	public void deleteTimeAndMaterialModelTest(String contractTitle) {
		generalInformation = contractList.clickOnEditContractIcon(contractTitle);
		commercials.clickOnCommercialsTab()
		.clickOnTimeAndmaterialModelTab()
		.clickOnDeleteIcon("Edit Time and Material Model")
		.clickOnConfirmationPopUpYesButton();
		Assert.assertEquals(utills.readSuccessMessage(), "Time and Material successfully deleted\n"+"Operation Complete");
	}

	@Test(priority = 61, enabled = true, dataProvider = "editCommercials", dataProviderClass = DataProviderClass.class)
	public void editFixedFeeTest(String contractTitle) {
		generalInformation = contractList.clickOnEditContractIcon(contractTitle);
		commercials.clickOnCommercialsTab()
		.clickOnFixedFeeTab()
		.clickOnEditIcon("Fixed Fee")
		.enterLineItem("Edit Fixed Fee")
		.enterRate("500")
		.selectUOM("Contract")
		.clickOnAddScreenSaveButton();
		Assert.assertEquals(utills.readSuccessMessage(), "Fixed Fee successfully updated\n"+"Operation Complete");
		commercials.clickOnListingScreenSaveButton();
		Assert.assertEquals(utills.readSuccessMessage(), "Fixed Fee updated\n"+"Operation Complete");	
	}

	@Test(priority = 62, enabled = true, dataProvider = "editCommercials", dataProviderClass = DataProviderClass.class)
	public void copyFixedFeeTest(String contractTitle) {
		generalInformation = contractList.clickOnEditContractIcon(contractTitle);
		commercials.clickOnCommercialsTab()
		.clickOnFixedFeeTab()
		.clickOnCopyIcon("Edit Fixed Fee");
		Assert.assertEquals(utills.readSuccessMessage(), "Fixed Fee copied\n"+"Operation Complete");		
	}

	@Test(priority = 63, enabled = true, dataProvider = "editCommercials", dataProviderClass = DataProviderClass.class)
	public void deleteFixedFeeTest(String contractTitle) {
		generalInformation = contractList.clickOnEditContractIcon(contractTitle);
		commercials.clickOnCommercialsTab()
		.clickOnFixedFeeTab()
		.clickOnDeleteIcon("Edit Fixed Fee")
		.clickOnConfirmationPopUpYesButton();
		Assert.assertEquals(utills.readSuccessMessage(), "Fixed Fee successfully deleted\n"+"Operation Complete");
	}

	@Test(priority = 64, enabled = true, dataProvider = "editCommercials", dataProviderClass = DataProviderClass.class)
	public void editMinimumBillingTest(String contractTitle) {
		generalInformation = contractList.clickOnEditContractIcon(contractTitle);
		commercials.clickOnCommercialsTab()
		.clickOnMinimumBillingTab()
		.clickOnEditIcon("Minimum Billing")
		.enterLineItem("Edit Minimum Billing")
		.selectType("Volume", "", "", "500")
		.selectUOM("Contract")
		.clickOnAddScreenSaveButton();
		Assert.assertEquals(utills.readSuccessMessage(), "Minimum Billing successfully updated\n"+"Operation Complete");
		commercials.clickOnListingScreenSaveButton();
		Assert.assertEquals(utills.readSuccessMessage(), "Minimum Billing updated\n"+"Operation Complete");	
	}

	@Test(priority = 65, enabled = true, dataProvider = "editCommercials", dataProviderClass = DataProviderClass.class)
	public void copyMinimumBillingTest(String contractTitle) {
		generalInformation = contractList.clickOnEditContractIcon(contractTitle);
		commercials.clickOnCommercialsTab()
		.clickOnMinimumBillingTab()
		.clickOnCopyIcon("Edit Minimum Billing");
		Assert.assertEquals(utills.readSuccessMessage(), "Minimum Billing copied\n"+"Operation Complete");		
	}

	@Test(priority = 66, enabled = true, dataProvider = "editCommercials", dataProviderClass = DataProviderClass.class)
	public void deleteMinimumBillingTest(String contractTitle) {
		generalInformation = contractList.clickOnEditContractIcon(contractTitle);
		commercials.clickOnCommercialsTab()
		.clickOnMinimumBillingTab()
		.clickOnDeleteIcon("Edit Minimum Billing")
		.clickOnConfirmationPopUpYesButton();
		Assert.assertEquals(utills.readSuccessMessage(), "Minimum Billing successfully deleted\n"+"Operation Complete");
	}

	@AfterClass
	public void tearDown() {
		driver.close();
	}

}
