package com.cm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import cm.cm.qa.base.TestBase;

public class ContactPersonsPage extends TestBase{

	//Page Factory - OR
	@FindBy(xpath = "(//div[@class='mat-tab-label-content'][contains(text(),'Contact')])[1]")
	WebElement contactPersonsTab ;

	@FindBy(xpath = "//button[contains(text(),'ADD')]")
	public WebElement addButton ;

	@FindBy(xpath = "//mat-select[@placeholder='Function']")
	WebElement functionDropDown ;
	
	@FindBy(xpath = "(//i[contains(@class,'plus-circle')])[1]")
	WebElement functionDropDownPlusIcon ;
	
	@FindBy(xpath = "//input[@placeholder='Name']")
	WebElement addPopupNameField ;

	@FindBy(xpath = "//span[contains(@class,'mat-button') and contains(text(),'Save')]")
	WebElement addPopupSaveButton ;

	@FindBy(xpath = "//input[@placeholder='Person']")
	WebElement personField ;

	@FindBy(xpath = "//input[@placeholder='Email ID']")
	WebElement emailIDField ;

	@FindBy(xpath = "//input[@placeholder='Country']")
	WebElement countrySearchField ;

	@FindBy(xpath = "//input[@placeholder='Country Code']")
	WebElement countryCodeField ;

	@FindBy(xpath = "//input[@placeholder='Phone Number']")
	WebElement phoneNumberField ;

	@FindBy(xpath = "//button[@class='cm-btn' and contains(text(),'CANCEL')]")
	WebElement listingScreenCancelButton ;

	@FindBy(xpath = "//button[@class='cm-btn' and contains(text(),'SAVE')]")
	WebElement listingScreenSaveButton ;

	@FindBy(xpath = "//button[@class='cm-btn' and contains(text(),'Save')]")
	WebElement addScreenSaveButton ;

	@FindBy(xpath = "//button[@class='cm-btn' and contains(text(),'Cancel')]")
	WebElement addScreenCancelButton ;

	@FindBy(xpath = "//button[contains(@class,'accept')]")
	WebElement confirmationPopUpYesButton ;
	
	@FindBy(xpath = "//span[contains(@class,'mat-select-value')]")
	WebElement selectedDropDownOption;

	public ContactPersonsPage() {
		PageFactory.initElements(driver, this);
	}

	public ContactPersonsPage clickOnContactPersonsTab() {
		clickElement(contactPersonsTab);
		return this;
	}

	public ContactPersonsPage clickOnAddButton() {
		clickElement(addButton);
		return this;
	}

	public void selectFunction(String function) {
		selectDropDownOption(functionDropDown, function);
	}
	
	public ContactPersonsPage clickOnFunctionDropDownPlusIcon() {
		clickElement(functionDropDownPlusIcon);
		return this;
	}
	
	public ContactPersonsPage enterName(String name) {
		writeText(addPopupNameField, name);
		return this;
	}
	
	public ContactPersonsPage clickOnAddPopUpSaveButton() {
		clickElement(addPopupSaveButton);
		return this;
	}
	
	public void addNewFunction(String functionName) {
		clickOnFunctionDropDownPlusIcon();
		enterName(functionName);
		clickOnAddPopUpSaveButton();
	}	
	
	public String getSelectDropDownOption() {
		return selectedDropDownOption.getText();
	}

	public ContactPersonsPage enterPerson(String personName) {
		writeText(personField, personName);
		return this;
	}

	public ContactPersonsPage enterEmailID(String emailID) {
		writeText(emailIDField, emailID);
		return this;
	}

	public ContactPersonsPage selectCountry(String country) {
		writeText(countrySearchField, country);
		switch(country) {
		case "India":
			countrySearchField.sendKeys(Keys.ARROW_DOWN);
			countrySearchField.sendKeys(Keys.ARROW_DOWN);
			countrySearchField.sendKeys(Keys.ENTER);
			break ;
		case "United States":
			countrySearchField.sendKeys(Keys.ARROW_DOWN);
			countrySearchField.sendKeys(Keys.ENTER);
			break;
		case "Serbia":
			countrySearchField.sendKeys(Keys.ARROW_DOWN);
			countrySearchField.sendKeys(Keys.ENTER);
			break;
		}
		return this;
	}

	public ContactPersonsPage enterPhoneNumber(String phoneNumber) {
		writeText(phoneNumberField, phoneNumber);
		return this;
	}

	public ContactPersonsPage clickOnAddScreenSaveAndContinueButton() {
		clickElement(addScreenSaveButton);
		return this;
	}

	public ContactPersonsPage clickOnAddScreenCancelButton() {
		clickElement(addScreenCancelButton);
		return this;
	}

	public ContactPersonsPage clickOnListingScreenSaveAndContinueButton() {
		clickElement(listingScreenSaveButton);
		return this;
	}

	public ContactPersonsPage clickOnListingScreenCancelButton() {
		clickElement(listingScreenCancelButton);
		return this;
	}

	public ContactPersonsPage fillContactPersonForm(String function, String personName, String emailID, String country, String phoneNumber) {
		selectFunction(function);
		enterPerson(personName);
		enterEmailID(emailID);
		selectCountry(country);
		enterPhoneNumber(phoneNumber);
		return this;
	}

	public ContactPersonsPage clickOnEditIcon() {
		WebElement element = driver.findElement(By.xpath("//i[contains(@class,'pencil')]"));
		clickElement(element);
		return this ;
	}

	public ContactPersonsPage clickOnDeleteIcon() {
		WebElement element = driver.findElement(By.xpath("//i[contains(@class,'trash')]"));
		clickElement(element);
		return this ;
	}

	public ContactPersonsPage clickOnConfirmationPopUpYesButton() {
		clickElement(confirmationPopUpYesButton);
		return this;
	}

}
