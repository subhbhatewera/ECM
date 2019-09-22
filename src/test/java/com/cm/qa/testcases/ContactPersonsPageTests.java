package com.cm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cm.qa.pages.ContactPersonsPage;
import com.cm.qa.pages.ContractListPage;
import com.cm.qa.pages.DashboardPage;
import com.cm.qa.pages.GeneralInformationPage;
import com.cm.qa.pages.PasswordPage;
import com.cm.qa.pages.UsernamePage;
import com.cm.qa.utills.DataProviderClass;
import com.cm.qa.utills.Utills;

import cm.cm.qa.base.TestBase;

public class ContactPersonsPageTests extends TestBase{

	UsernamePage uName ;
	PasswordPage pwd ;
	Utills utills ;
	DashboardPage dashboard ;
	ContractListPage contractList ;
	GeneralInformationPage generalInformation ;
	ContactPersonsPage contactPersons ;

	public ContactPersonsPageTests() {
		super() ;
	}

	@BeforeMethod
	public void setUp() {
		initializeBrowser() ;
		uName = new UsernamePage() ;
		utills = new Utills() ;
		contactPersons = new ContactPersonsPage();
		pwd = uName.navigateToPasswordPage(prop.getProperty("clientUser")) ;
		dashboard = pwd.login(prop.getProperty("clientUserPassword")) ;
		contractList = dashboard.gotoContractListPage() ;
	}

	@Test(priority = 91, dataProvider = "contactPersonInvalidData", dataProviderClass = DataProviderClass.class)
	public void verifyInvalidPersonNameTest(String contractTitle, String person, String email, String country, String phoneNumber) {
		generalInformation = contractList.clickOnEditContractIcon(contractTitle);
		contactPersons.clickOnContactPersonsTab()
		.clickOnAddButton()
		.enterPerson(person);
		contactPersons.clickOnAddScreenSaveAndContinueButton();
		Assert.assertEquals(utills.readFieldErrorMessage(), "Incorrect data, Alphanumeric values with only Special characters _ and ' are allowed");		
	}	

	@Test(priority = 92, dataProvider = "contactPersonInvalidData", dataProviderClass = DataProviderClass.class)
	public void verifyInvalidEmailTest(String contractTitle, String person, String email, String country, String phoneNumber) {
		generalInformation = contractList.clickOnEditContractIcon(contractTitle);
		contactPersons.clickOnContactPersonsTab()
		.clickOnAddButton()
		.enterEmailID(email);
		contactPersons.clickOnAddScreenSaveAndContinueButton();
		Assert.assertEquals(utills.readFieldErrorMessage(), "Please enter a valid email id.");	
	}

	@Test(priority = 93, dataProvider = "contactPersonInvalidData", dataProviderClass = DataProviderClass.class)
	public void verifyInvalidPhoneNumberTest(String contractTitle, String person, String email, String country, String phoneNumber) {
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
		generalInformation = contractList.clickOnEditContractIcon(contractTitle);
		contactPersons.clickOnContactPersonsTab()
		.clickOnAddButton()
		.addNewFunction(functionName);
		Assert.assertEquals(utills.readSuccessMessage(), "Function successfully created\n"+"Operation Success");
		Assert.assertEquals(contactPersons.getSelectDropDownOption(), functionName);

	}

	@Test(priority = 95, dataProvider = "contractTitleContactPerson", dataProviderClass = DataProviderClass.class)
	public void duplicateFunctionNameTest(String contractTitle) {
		generalInformation = contractList.clickOnEditContractIcon(contractTitle);
		contactPersons.clickOnContactPersonsTab()
		.clickOnAddButton()
		.addNewFunction("CRM");
		Assert.assertEquals(utills.readErrorMessage(), "CREATE: Error, Function with name CRM already exists!\n"+"Operation Success");
	}
	
	@Test(priority = 96, dataProvider = "contractTitleContactPerson", dataProviderClass = DataProviderClass.class)
	public void blankFunctionNameTest(String contractTitle) {
		generalInformation = contractList.clickOnEditContractIcon(contractTitle);
		contactPersons.clickOnContactPersonsTab()
		.clickOnAddButton()
		.addNewFunction("");
		Assert.assertEquals(utills.readFieldErrorMessage(), "Name is required");
	}

	@Test(priority = 97, dataProvider = "addContactPerson", dataProviderClass = DataProviderClass.class)
	public void addContactPersonsTest(String contractTitle, String function, String person, String emailID, String country, String phoneNumber) {
		generalInformation = contractList.clickOnEditContractIcon(contractTitle);
		contactPersons.clickOnContactPersonsTab()
		.clickOnAddButton()
		.fillContactPersonForm(function, person, emailID, country, phoneNumber)
		.clickOnAddScreenSaveAndContinueButton();
		Assert.assertEquals(utills.readSuccessMessage(), "Contact person successfully added\n"+"Operation Success");
		contactPersons.clickOnListingScreenSaveAndContinueButton();
		Assert.assertEquals(utills.readSuccessMessage(), "Contact Persons successfully saved\n"+"Operation Success");		
	}

	@Test(priority = 98, dataProvider = "editContactPerson", dataProviderClass = DataProviderClass.class)
	public void editContactPersonTest(String contractTitle, String function, String person, String emailID, String country, String phoneNumber) {
		generalInformation = contractList.clickOnEditContractIcon(contractTitle);
		contactPersons.clickOnContactPersonsTab()
		.clickOnEditIcon()
		.fillContactPersonForm(function, person, emailID, country, phoneNumber)
		.clickOnAddScreenSaveAndContinueButton();
		Assert.assertEquals(utills.readSuccessMessage(), "Contact person successfully updated\n"+"Operation Success");
		contactPersons.clickOnListingScreenSaveAndContinueButton();
		Assert.assertEquals(utills.readSuccessMessage(), "Contact Persons successfully saved\n"+"Operation Success");		
	}

	@Test(priority = 99, dataProvider = "contractTitleContactPerson", dataProviderClass = DataProviderClass.class)
	public void deleteContactPersonTest(String contractTitle) {
		generalInformation = contractList.clickOnEditContractIcon(contractTitle);
		contactPersons.clickOnContactPersonsTab()
		.clickOnDeleteIcon()
		.clickOnConfirmationPopUpYesButton();
		Assert.assertEquals(utills.readSuccessMessage(), "Contact Person successfully deleted\n"+"Operation Success");		
	}	

	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
