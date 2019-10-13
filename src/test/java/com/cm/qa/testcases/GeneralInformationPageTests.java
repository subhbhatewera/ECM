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

	@BeforeClass
	public void setUp() {
		initializeBrowser() ;
		uName = new UsernamePage() ;
		utills = new Utills() ;
		pwd = uName.navigateToPasswordPage(prop.getProperty("clientUser")) ;
		dashboard = pwd.login(prop.getProperty("clientUserPassword")) ;	
	}

	@Test(priority = 16, dataProvider = "category", dataProviderClass = DataProviderClass.class, enabled = false)
	public void addNewCategoryTest(String categoryName) {
		contractList = dashboard.gotoContractListPage() ;
		generalInformation = contractList.clickOnAddContractButton() ;		
		generalInformation.addNewCategory(categoryName);
		Assert.assertEquals(utills.readSuccessMessage(), "Category successfully update\n"+"Operation Success");
	}

	@Test(priority = 17)
	public void blankCategoryNameTest() {
		contractList = dashboard.gotoContractListPage() ;
		generalInformation = contractList.clickOnAddContractButton() ;		
		generalInformation.addNewCategory("");
		Assert.assertEquals(utills.readFieldErrorMessage(), "Name is required");
	}

	@Test(priority = 18)
	public void duplicateCategoryNameTest() {
		contractList = dashboard.gotoContractListPage() ;
		generalInformation = contractList.clickOnAddContractButton() ;		
		generalInformation.addNewCategory("Customer");
		Assert.assertEquals(utills.readErrorMessage(),"CREATE: Error, Category with name Customer already exists!\n"+"Error");
	}

	@Test(priority = 19, dataProvider = "subCategory", dataProviderClass = DataProviderClass.class)
	public void addNewSubCategoryTest(String categoryName, String subCategoryName ) {
		contractList = dashboard.gotoContractListPage() ;
		generalInformation = contractList.clickOnAddContractButton() ;		
		generalInformation.selectCategory(categoryName);
		generalInformation.addNewSubCategory(subCategoryName);
		Assert.assertEquals(utills.readSuccessMessage(), "Sub Category successfully created for Category\n"+"Operation Success");
	}

	@Test(priority = 20)
	public void blankSubCategoryNamesTest() {
		contractList = dashboard.gotoContractListPage() ;
		generalInformation = contractList.clickOnAddContractButton() ;		
		generalInformation.selectCategory("Customer");
		generalInformation.addNewSubCategory("");
		Assert.assertEquals(utills.readFieldErrorMessage(), "Name is required");
	}

	@Test(priority = 21)
	public void duplicateSubCategoryNameTest() {
		contractList = dashboard.gotoContractListPage() ;
		generalInformation = contractList.clickOnAddContractButton() ;		
		generalInformation.selectCategory("Customer");
		generalInformation.addNewSubCategory("Finance");
		Assert.assertEquals(utills.readErrorMessage(), "CREATE: Error, Sub Category with name Finance already exists!\n"+"Error");
	}

	@Test(priority = 22, dataProvider = "businessPartner", dataProviderClass = DataProviderClass.class)
	public void addNewBusinessPartnerTest(String businessPartnerName) {
		contractList = dashboard.gotoContractListPage() ;
		generalInformation = contractList.clickOnAddContractButton() ;		
		generalInformation.addNewBusinessPartner(businessPartnerName);
		Assert.assertEquals(utills.readSuccessMessage(), "Business partner successfully update\n"+"Operation Success");
	}

	@Test(priority = 23)
	public void blankBusinessPartnerNameTest() {
		contractList = dashboard.gotoContractListPage() ;
		generalInformation = contractList.clickOnAddContractButton() ;		
		generalInformation.addNewBusinessPartner("");
		Assert.assertEquals(utills.readFieldErrorMessage(), "Name is required");
	}

	@Test(priority = 24)
	public void duplicateBusinessPartnerNameTest() {
		contractList = dashboard.gotoContractListPage() ;
		generalInformation = contractList.clickOnAddContractButton() ;		
		generalInformation.addNewBusinessPartner("UGH");
		Assert.assertEquals(utills.readErrorMessage(), "CREATE: Error, Business partner with name UGH already exists!\n"+"Error");
	}

	@Test(priority = 27, dataProvider = "legalEntity", dataProviderClass = DataProviderClass.class)
	public void addNewLegalEntityTest(String legalEntityName) {
		contractList = dashboard.gotoContractListPage() ;
		generalInformation = contractList.clickOnAddContractButton() ;		
		generalInformation.addNewLegalEntity(legalEntityName);
		Assert.assertEquals(utills.readSuccessMessage(), "Legal entity successfully update\n"+"Operation Success");
	}

	@Test(priority = 28)
	public void blankLegalEntityNameTest() {
		contractList = dashboard.gotoContractListPage() ;
		generalInformation = contractList.clickOnAddContractButton() ;		
		generalInformation.addNewBusinessPartner("");
		Assert.assertEquals(utills.readFieldErrorMessage(), "Name is required");
	}

	@Test(priority = 29)
	public void duplicateLegalEntityNameTest() {
		contractList = dashboard.gotoContractListPage() ;
		generalInformation = contractList.clickOnAddContractButton() ;		
		generalInformation.addNewLegalEntity("NA");
		Assert.assertEquals(utills.readErrorMessage(), "CREATE: Error, Legal Entity with name NA already exists!\n"+"Error");
	}

	@Test(priority = 30, dataProvider = "generalInformation", dataProviderClass = DataProviderClass.class)
	public void addGeneralInformationTest(String Category, String SubCategory, String BusinessPartner, String ContractTitle, 
			String Location, String Currency, String ContractValue, String LegalEntity) {
		contractList = dashboard.gotoContractListPage() ;
		generalInformation = contractList.clickOnAddContractButton() ;		
		generalInformation.fillGeneralInformationForm(Category, SubCategory, BusinessPartner, ContractTitle, Location, Currency, ContractValue, LegalEntity) 
		.clickOnSaveAndContinueButton();
		Assert.assertEquals(utills.readSuccessMessage(), "Contract successfully added\n"+"Operation Success");
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
