package com.cm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.cm.qa.pages.ContactPersonsPage;
import com.cm.qa.pages.UsernamePage;
import com.cm.qa.utills.DataProviderClass;
import com.cm.qa.utills.Utills;

import cm.cm.qa.base.ActionClass;

public class ContactPersonsPageTests extends ActionClass{

	public ContactPersonsPageTests() {
		super() ;
	}

	@BeforeClass
	public void setUp() {
		initializeBrowser() ;
		uName = new UsernamePage() ;
		utills = new Utills() ;
		contactPersons = new ContactPersonsPage();
		pwd = uName.navigateToPasswordPage(prop.getProperty("clientUser")) ;
		dashboard = pwd.login(prop.getProperty("clientUserPassword")) ;	
		sleep(5000);
	}

	@Test(priority = 91, dataProvider = "contactPersonInvalidData", dataProviderClass = DataProviderClass.class)
	public void verifyInvalidPersonNameTest(String contractTitle, String person, String email, String country, String phoneNumber) {
		contractList = dashboard.gotoContractListPage() ;
		generalInformation = contractList.clickOnEditContractIcon(contractTitle);
		contactPersons.clickOnContactPersonsTab()
		.clickOnAddButton()
		.enterPerson(person);
		contactPersons.clickOnAddScreenSaveAndContinueButton();
		Assert.assertEquals(utills.readFieldErrorMessage(), "Incorrect data, Alphanumeric values with only Special characters _ and ' are allowed");		
	}	

	@Test(priority = 92, dataProvider = "contactPersonInvalidData", dataProviderClass = DataProviderClass.class)
	public void verifyInvalidEmailTest(String contractTitle, String person, String email, String country, String phoneNumber) {
		contractList = dashboard.gotoContractListPage() ;
		generalInformation = contractList.clickOnEditContractIcon(contractTitle);
		contactPersons.clickOnContactPersonsTab()
		.clickOnAddButton()
		.enterEmailID(email);
		contactPersons.clickOnAddScreenSaveAndContinueButton();
		Assert.assertEquals(utills.readFieldErrorMessage(), "Please enter a valid email id.");
	}

	@Test(priority = 93, dataProvider = "contactPersonInvalidData", dataProviderClass = DataProviderClass.class)
	public void verifyInvalidPhoneNumberTest(String contractTitle, String person, String email, String country, String phoneNumber) {
		contractList = dashboard.gotoContractListPage() ;
		generalInformation = contractList.clickOnEditContractIcon(contractTitle);
		contactPersons.clickOnContactPersonsTab()
		.clickOnAddButton()
		.selectCountry(country);
		contactPersons.enterPhoneNumber(phoneNumber);
		contactPersons.clickOnAddScreenSaveAndContinueButton();
		Assert.assertEquals(utills.readFieldErrorMessage(), "Phone number is not valid");
	}

	@Test(priority = 94, dataProvider = "function", dataProviderClass = DataProviderClass.class)
	public void addNewFunctionTest(String contractTitle, String functionName) {
		contractList = dashboard.gotoContractListPage() ;
		generalInformation = contractList.clickOnEditContractIcon(contractTitle);
		contactPersons.clickOnContactPersonsTab()
		.clickOnAddButton()
		.addNewFunction(functionName);
		Assert.assertEquals(utills.readSuccessMessage(), "Function successfully added\n"+"Operation Complete");
		Assert.assertEquals(contactPersons.getSelectedDropDownOption(), functionName);

	}

	@Test(priority = 95, dataProvider = "contractTitleContactPerson", dataProviderClass = DataProviderClass.class)
	public void duplicateFunctionNameTest(String contractTitle) {
		contractList = dashboard.gotoContractListPage() ;
		generalInformation = contractList.clickOnEditContractIcon(contractTitle);
		contactPersons.clickOnContactPersonsTab()
		.clickOnAddButton()
		.addNewFunction("CRM");
		Assert.assertEquals(utills.readErrorMessage(), "Error: Function named CRM already exists!\n"+"Error");
		contactPersons.clickOnAddPopUpCancelButton();
	}
	
	@Test(priority = 96, dataProvider = "contractTitleContactPerson", dataProviderClass = DataProviderClass.class)
	public void blankFunctionNameTest(String contractTitle) {
		contractList = dashboard.gotoContractListPage() ;
		generalInformation = contractList.clickOnEditContractIcon(contractTitle);
		contactPersons.clickOnContactPersonsTab()
		.clickOnAddButton()
		.addNewFunction("");
		Assert.assertEquals(utills.readFieldErrorMessage(), "Name is required");
		contactPersons.clickOnAddPopUpCancelButton();
	}

	@Test(priority = 97, dataProvider = "addContactPerson", dataProviderClass = DataProviderClass.class)
	public void addContactPersonsTest(String contractTitle, String function, String person, String emailID, String country, String phoneNumber) {
		contractList = dashboard.gotoContractListPage() ;
		generalInformation = contractList.clickOnEditContractIcon(contractTitle);
		contactPersons.clickOnContactPersonsTab()
		.clickOnAddButton()
		.fillContactPersonForm(function, person, emailID, country, phoneNumber)
		.clickOnAddScreenSaveAndContinueButton();
		Assert.assertEquals(utills.readSuccessMessage(), "Contact person successfully added\n"+"Operation Complete");
		contactPersons.clickOnListingScreenSaveAndContinueButton();
		Assert.assertEquals(utills.readSuccessMessage(), "Contact Persons successfully updated\n"+"Operation Complete");		
	}

	@Test(priority = 98, dataProvider = "editContactPerson", dataProviderClass = DataProviderClass.class)
	public void editContactPersonTest(String contractTitle, String function, String person, String emailID, String country, String phoneNumber) {
		contractList = dashboard.gotoContractListPage() ;
		generalInformation = contractList.clickOnEditContractIcon(contractTitle);
		contactPersons.clickOnContactPersonsTab()
		.clickOnEditIcon()
		.fillContactPersonForm(function, person, emailID, country, phoneNumber)
		.clickOnAddScreenSaveAndContinueButton();
		Assert.assertEquals(utills.readSuccessMessage(), "Contact person successfully updated\n"+"Operation Complete");
		contactPersons.clickOnListingScreenSaveAndContinueButton();
		Assert.assertEquals(utills.readSuccessMessage(), "Contact Persons successfully updated\n"+"Operation Complete");		
	}

	@Test(priority = 99, dataProvider = "contractTitleContactPerson", dataProviderClass = DataProviderClass.class)
	public void deleteContactPersonTest(String contractTitle) {
		contractList = dashboard.gotoContractListPage() ;
		generalInformation = contractList.clickOnEditContractIcon(contractTitle);
		contactPersons.clickOnContactPersonsTab()
		.clickOnDeleteIcon()
		.clickOnConfirmationPopUpYesButton();
		Assert.assertEquals(utills.readSuccessMessage(), "Contact Person successfully deleted\n"+"Operation Complete");		
	}	

	@AfterClass
	public void tearDown() {
		driver.close();
	}

}
