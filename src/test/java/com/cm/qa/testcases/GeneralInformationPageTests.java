package com.cm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cm.qa.pages.ContractListPage;
import com.cm.qa.pages.DashboardPage;
import com.cm.qa.pages.GeneralInformationPage;
import com.cm.qa.pages.PasswordPage;
import com.cm.qa.pages.UsernamePage;
import com.cm.qa.utills.DataProviderClass;
import com.cm.qa.utills.Utills;

import cm.cm.qa.base.TestBase;

public class GeneralInformationPageTests extends TestBase{

	UsernamePage uName ;
	PasswordPage pwd ;
	Utills utills ;
	DashboardPage dashboard ;
	ContractListPage contractList ;
	GeneralInformationPage generalInformation ;

	public GeneralInformationPageTests() {
		super() ;
	}

	@BeforeMethod
	public void setUp() {
		initializeBrowser() ;
		uName = new UsernamePage() ;
		utills = new Utills() ;
		pwd = uName.navigateToPasswordPage(prop.getProperty("clientUser")) ;
		dashboard = pwd.login(prop.getProperty("clientUserPassword")) ;
		contractList = dashboard.gotoContractListPage() ;
		generalInformation = contractList.clickOnAddContractButton() ;		
	}

	@Test(priority = 16, dataProvider = "category", dataProviderClass = DataProviderClass.class, enabled = false)
	public void addNewCategoryTest(String categoryName) {
		generalInformation.addNewCategory(categoryName);
		Assert.assertEquals(utills.readSuccessMessage(), "Category successfully update\n"+"Operation Success");
	}

	@Test(priority = 17)
	public void blankCategoryNameTest() {
		generalInformation.addNewCategory("");
		Assert.assertEquals(utills.readFieldErrorMessage(), "Name is required");
	}

	@Test(priority = 18)
	public void duplicateCategoryNameTest() {
		generalInformation.addNewCategory("Customer");
		Assert.assertEquals(utills.readErrorMessage(),"CREATE: Error, Category with name Customer already exists!\n"+"Error");
	}

	@Test(priority = 19, dataProvider = "subCategory", dataProviderClass = DataProviderClass.class)
	public void addNewSubCategoryTest(String categoryName, String subCategoryName ) {
		generalInformation.selectCategory(categoryName);
		generalInformation.addNewSubCategory(subCategoryName);
		Assert.assertEquals(utills.readSuccessMessage(), "Sub Category successfully created for Category\n"+"Operation Success");
	}

	@Test(priority = 20)
	public void blankSubCategoryNamesTest() {
		generalInformation.selectCategory("Customer");
		generalInformation.addNewSubCategory("");
		Assert.assertEquals(utills.readFieldErrorMessage(), "Name is required");
	}

	@Test(priority = 21)
	public void duplicateSubCategoryNameTest() {
		generalInformation.selectCategory("Customer");
		generalInformation.addNewSubCategory("Finance");
		Assert.assertEquals(utills.readErrorMessage(), "CREATE: Error, Sub Category with name Finance already exists!\n"+"Error");
	}

	@Test(priority = 22, dataProvider = "businessPartner", dataProviderClass = DataProviderClass.class)
	public void addNewBusinessPartnerTest(String businessPartnerName) {
		generalInformation.addNewBusinessPartner(businessPartnerName);
		Assert.assertEquals(utills.readSuccessMessage(), "Business partner successfully update\n"+"Operation Success");
	}

	@Test(priority = 23)
	public void blankBusinessPartnerNameTest() {
		generalInformation.addNewBusinessPartner("");
		Assert.assertEquals(utills.readFieldErrorMessage(), "Name is required");
	}

	@Test(priority = 24)
	public void duplicateBusinessPartnerNameTest() {
		generalInformation.addNewBusinessPartner("UGH");
		Assert.assertEquals(utills.readErrorMessage(), "CREATE: Error, Business partner with name UGH already exists!\n"+"Error");
	}

	@Test(priority = 25)
	public void invalidLocationTest() {
		generalInformation.enterInvalidLocation("Pune")
		.clickOnSaveAndContinueButton();
		Assert.assertEquals(utills.readFieldErrorMessage(), "You need to select location from select menu");
	}

	@Test(priority = 26)
	public void invalidContractValueTest() {
		generalInformation.selectCurrency("$")
		.enterContractValue("Ten")
		.clickOnSaveAndContinueButton();
		Assert.assertEquals(utills.readFieldErrorMessage(), "Enter numeric value");
	}

	@Test(priority = 27, dataProvider = "legalEntity", dataProviderClass = DataProviderClass.class)
	public void addNewLegalEntityTest(String legalEntityName) {
		generalInformation.addNewLegalEntity(legalEntityName);
		Assert.assertEquals(utills.readSuccessMessage(), "Legal entity successfully update\n"+"Operation Success");
	}

	@Test(priority = 28)
	public void blankLegalEntityNameTest() {
		generalInformation.addNewBusinessPartner("");
		Assert.assertEquals(utills.readFieldErrorMessage(), "Name is required");
	}

	@Test(priority = 29)
	public void duplicateLegalEntityNameTest() {
		generalInformation.addNewLegalEntity("NA");
		Assert.assertEquals(utills.readErrorMessage(), "CREATE: Error, Legal Entity with name NA already exists!\n"+"Error");
	}

	@Test(priority = 30, dataProvider = "generalInformation", dataProviderClass = DataProviderClass.class)
	public void addGeneralInformationTest(String Category, String SubCategory, String BusinessPartner, String ContractTitle, 
			String Location, String Currency, String ContractValue, String LegalEntity) {
		generalInformation.fillGeneralInformationForm(Category, SubCategory, BusinessPartner, ContractTitle, Location, Currency, ContractValue, LegalEntity) 
		.clickOnSaveAndContinueButton();
		Assert.assertEquals(utills.readSuccessMessage(), "Contract successfully added\n"+"Operation Success");
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
