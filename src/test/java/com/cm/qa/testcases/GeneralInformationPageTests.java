package com.cm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cm.qa.pages.UsernamePage;
import com.cm.qa.utills.DataProviderClass;
import com.cm.qa.utills.Utills;

import cm.cm.qa.base.ActionClass;


public class GeneralInformationPageTests extends ActionClass{	

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
		sleep(7000);
	}
	
	@BeforeMethod
	public void openGeneralInformationForm() {
		contractList = dashboard.gotoContractListPage() ;
		generalInformation = contractList.clickOnAddContractButton() ;		
	}

	@Test(priority = 16, dataProvider = "category", dataProviderClass = DataProviderClass.class)
	public void addNewCategoryTest(String categoryName) {		
		generalInformation.addNewCategory(categoryName);
		Assert.assertEquals(utills.readSuccessMessage(), "Category successfully added\n"+"Operation Complete");
	}

	@Test(priority = 17)
	public void blankCategoryNameTest() {
		generalInformation.addNewCategory("");
		Assert.assertEquals(utills.readFieldErrorMessage(), "Name is required");
		generalInformation.clickOnAddPopupCancelButton();
		
	}

	@Test(priority = 18)
	public void duplicateCategoryNameTest() {
		String categoryName = getDropDownValue(generalInformation.categoryDropDown) ;
		generalInformation.addNewCategory(categoryName);
		generalInformation.clickOnAddPopupCancelButton();
		Assert.assertEquals(utills.readErrorMessage(),"Error: Category named " +categoryName+ " already exists!\n"+"Error");
	}

	@Test(priority = 19, dataProvider = "subCategory", dataProviderClass = DataProviderClass.class)
	public void addNewSubCategoryTest(String categoryName, String subCategoryName ) {
		generalInformation.selectCategory(categoryName);
		generalInformation.addNewSubCategory(subCategoryName);
		Assert.assertEquals(utills.readSuccessMessage(), "Sub Category successfully added for Category\n"+"Operation Complete");
	}

	@Test(priority = 20)
	public void blankSubCategoryNamesTest() {
		generalInformation.selectCategory("Customer");
		generalInformation.addNewSubCategory("");		
		Assert.assertEquals(utills.readFieldErrorMessage(), "Name is required");
		generalInformation.clickOnAddPopupCancelButton();
	}

	@Test(priority = 21)
	public void duplicateSubCategoryNameTest() {
		generalInformation.selectCategory("Customer");
		String subCategoryName = getDropDownValue(generalInformation.subCategoryDropDown);
		generalInformation.addNewSubCategory(subCategoryName);
		generalInformation.clickOnAddPopupCancelButton();
		Assert.assertEquals(utills.readErrorMessage(), "Error: Sub Category named "+subCategoryName+ " already exists!\n"+"Error");
	}

	@Test(priority = 22, dataProvider = "businessPartner", dataProviderClass = DataProviderClass.class)
	public void addNewBusinessPartnerTest(String businessPartnerName) {
		generalInformation.addNewBusinessPartner(businessPartnerName);
		Assert.assertEquals(utills.readSuccessMessage(), "Business partner successfully added\n"+"Operation Complete");
	}

	@Test(priority = 23)
	public void blankBusinessPartnerNameTest() {
		generalInformation.addNewBusinessPartner("");		
		Assert.assertEquals(utills.readFieldErrorMessage(), "Name is required");
		generalInformation.clickOnAddPopupCancelButton();
	}

	@Test(priority = 24)
	public void duplicateBusinessPartnerNameTest() {
		String businessPartnerName = getDropDownValue(generalInformation.businessPartnerDropDown) ;
		generalInformation.addNewBusinessPartner(businessPartnerName);
		generalInformation.clickOnAddPopupCancelButton();
		Assert.assertEquals(utills.readErrorMessage(), "Error: Business Partner named "+businessPartnerName+" already exists!\n"+"Error");
	}
	
	@Test(priority = 25, dataProvider = "legalEntity", dataProviderClass = DataProviderClass.class)
	public void addNewLegalEntityTest(String legalEntityName) {
		generalInformation.addNewLegalEntity(legalEntityName);
		Assert.assertEquals(utills.readSuccessMessage(), "Legal entity successfully added\n"+"Operation Complete");
	}

	@Test(priority = 26)
	public void blankLegalEntityNameTest() {
		generalInformation.addNewLegalEntity("");	
		Assert.assertEquals(utills.readFieldErrorMessage(), "Name is required");
		generalInformation.clickOnAddPopupCancelButton();
	}

	@Test(priority = 27)
	public void duplicateLegalEntityNameTest() {
		String legalEntityName = getDropDownValue(generalInformation.legalEntityDropDown);
		generalInformation.addNewLegalEntity(legalEntityName);
		generalInformation.clickOnAddPopupCancelButton();
		Assert.assertEquals(utills.readErrorMessage(), "Error: Legal Entity named "+legalEntityName+" already exists!\n"+"Error");
	}

	@Test(priority = 30, dataProvider = "generalInformation", dataProviderClass = DataProviderClass.class)
	public void addGeneralInformationTest(String Category, String SubCategory, String BusinessPartner, String ContractTitle, 
			String Location, String Currency, String ContractValue, String LegalEntity) {
		generalInformation.fillGeneralInformationForm(Category, SubCategory, BusinessPartner, ContractTitle, Location, Currency, ContractValue, LegalEntity) 
		.clickOnSaveAndContinueButton();
		Assert.assertEquals(utills.readSuccessMessage(), "General Information successfully added\n"+"Operation Complete");
	}

	@AfterClass
	public void tearDown() {
		driver.close();
	}
}
