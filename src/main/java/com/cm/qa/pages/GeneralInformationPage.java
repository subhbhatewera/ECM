package com.cm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import cm.cm.qa.base.ActionClass;

public class GeneralInformationPage extends ActionClass {

	//Page Factory - OR
	@FindBy(xpath = "(//*[text()='Add Contract'])[3]")
	WebElement addContractHeading ;

	@FindBy(xpath = "//div[@class='heading' and contains(text(),'Edit Contract')]")
	WebElement editContractHeading ;

	@FindBy(xpath = "//div[@class='mat-tab-label-content'][contains(text(),'General Information')]")
	WebElement generalInformationTab ;

	@FindBy(xpath = "//mat-select[@placeholder='Category']")
	public	WebElement categoryDropDown ;

	@FindBy(xpath = "(//i[contains(@class,'plus-circle')])[1]")
	WebElement categoryDropDownPlusIcon ;

	@FindBy(xpath = "//input[@placeholder='Name']")
	WebElement addPopupNameField ;

	@FindBy(xpath = "//span[contains(@class,'mat-button') and contains(text(),'Save')]")
	WebElement addPopupSaveButton ;

	@FindBy(xpath = "//span[contains(text(),'Cancel')]")
	WebElement addPopupCancelButton ;	

	@FindBy(xpath = "//mat-select[@placeholder='Sub Category']")
	public WebElement subCategoryDropDown ;

	@FindBy(xpath = "(//i[contains(@class,'plus-circle')])[2]")
	WebElement subCategoryDropDownPlusIcon ;

	@FindBy(xpath = "//mat-select[@placeholder='Business Partner']")
	public WebElement businessPartnerDropDown ;

	@FindBy(xpath = "(//i[contains(@class,'plus-circle')])[3]")
	WebElement businessPartnerDropDownPlusIcon ;

	@FindBy(xpath = "//input[@placeholder='Contract Title']")
	WebElement contractTitleField ;

	@FindBy(xpath = "//input[@placeholder='Location']")
	WebElement locationField ;

	@FindBy(xpath = "//mat-select[@formcontrolname='currencyType']")
	WebElement currencyDropDown ;

	@FindBy(xpath = "//input[@placeholder='Contract Value']")
	WebElement contractValueField ;

	@FindBy(xpath = "//mat-select[@placeholder='Legal Entity']")
	public WebElement legalEntityDropDown ;
	
	@FindBy(xpath = "(//i[contains(@class,'plus-circle')])[4]")
	WebElement legalEntityDropDownPlusIcon ;

	@FindBy(xpath="//button[contains(text(),'Cancel')]")
	WebElement generalInformationCancelButton ;

	@FindBy(xpath="//button[contains(text(),'Save')]")
	WebElement generalInformationSaveAndContinueButton ;

	public GeneralInformationPage () {
		PageFactory.initElements(driver, this);
	}

	public String verifyAddContractHeading() {
		customVisibleWait(addContractHeading) ;
		return addContractHeading.getText() ; 
	}

	public String verifyEditContractHeading() {
		customVisibleWait(editContractHeading) ;
		return editContractHeading.getText() ; 
	}

	public void selectCategory(String category) {
		selectDropDownOption(categoryDropDown, category);
	}

	public void openAddCategoryPopup() {
		sleep(2000);
		clickElementUsingJS(categoryDropDownPlusIcon);
	}

	public void enterName(String name) {
		writeText(addPopupNameField, name);	
	}	

	public void clickOnAddPopupSaveButton() {
		clickElement(addPopupSaveButton);		
	}
	
	public void clickOnAddPopupCancelButton() {
		sleep(1000);
		customClickableWait(addPopupCancelButton);
		clickElement(addPopupCancelButton);
	}

	public void addNewCategory(String categoryName) {
		openAddCategoryPopup();
		sleep(1000);
		enterName(categoryName);
		sleep(1000);
		clickOnAddPopupSaveButton();
	}

	public void selectSubCategory(String subCategory) {
		selectDropDownOption(subCategoryDropDown, subCategory);
	}

	public void openAddSubCategoryPopup() {
		clickElementUsingJS(subCategoryDropDownPlusIcon);
	}

	public void addNewSubCategory(String subCategoryName) {
		openAddSubCategoryPopup();
		sleep(1000);
		enterName(subCategoryName);
		sleep(1000);
		clickOnAddPopupSaveButton();
	}

	public void selectBusinessPartner(String businessPartner) {
		selectDropDownOption(businessPartnerDropDown, businessPartner);
	}

	public void openAddBusinessPartnerPopup() {
		clickElementUsingJS(businessPartnerDropDownPlusIcon);
	}

	public void addNewBusinessPartner(String businessPartnerName) {
		openAddBusinessPartnerPopup();
		sleep(1000);
		enterName(businessPartnerName);
		sleep(1000);
		clickOnAddPopupSaveButton();
	}
	
	public void enterContractTitle(String contractTitle) {
		writeText(contractTitleField, contractTitle);
	}

	public void enterLocation(String location) {
		selectLocation(locationField, location);
	}
	
	public GeneralInformationPage enterInvalidLocation(String location) {
		writeText(locationField, location);
		return this;
	}

	public GeneralInformationPage selectCurrency(String currency) {
		selectDropDownOption(currencyDropDown, currency);
		return this;
	}

	public GeneralInformationPage enterContractValue(String contractValue) {
		writeText(contractValueField, contractValue);
		return this;
	}

	public void selectLegalEntity(String legalEntity) {
		selectDropDownOption(legalEntityDropDown, legalEntity);
	}
	
	public void openAddLegalEntityPopup() {
		clickElementUsingJS(legalEntityDropDownPlusIcon);
	}

	public void addNewLegalEntity(String legalEntityName) {
		openAddLegalEntityPopup();
		sleep(1000);
		enterName(legalEntityName);
		sleep(1000);
		clickOnAddPopupSaveButton();
	}

	public void clickOnCancelButton() {
		clickElement(generalInformationCancelButton);
	}

	public GeneralInformationPage clickOnSaveAndContinueButton() {
		clickElement(generalInformationSaveAndContinueButton);
		return this;
	}

	public GeneralInformationPage fillGeneralInformationForm(String category, String subCategory, String businessPartner, String contractTitle, 
			String location, String currency, String contractValue, String legalEntity) {
		selectCategory(category);
		selectSubCategory(subCategory);
		selectBusinessPartner(businessPartner);
		enterContractTitle(contractTitle);
		enterLocation(location);
		selectCurrency(currency);
		enterContractValue(contractValue);
		selectLegalEntity(legalEntity);
		return this;
	}

}
