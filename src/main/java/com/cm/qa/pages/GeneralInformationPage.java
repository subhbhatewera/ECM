package com.cm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import cm.cm.qa.base.TestBase;

public class GeneralInformationPage extends TestBase {

	//Page Factory - OR
	@FindBy(xpath = "//div[@class='heading' and contains(text(),'Add Contract')]")
	WebElement addContractHeading ;

	@FindBy(xpath = "//div[@class='heading' and contains(text(),'Edit Contract')]")
	WebElement editContractHeading ;

	@FindBy(xpath = "//div[@class='mat-tab-label-content'][contains(text(),'General Information')]")
	WebElement generalInformationTab ;

	@FindBy(xpath = "//mat-select[@placeholder='Category']")
	WebElement categoryDropDown ;

	@FindBy(xpath = "(//i[contains(@class,'plus-circle')])[1]")
	WebElement categoryDropDownPlusIcon ;

	@FindBy(xpath = "//input[@placeholder='Name']")
	WebElement addPopupNameField ;

	@FindBy(xpath = "//span[contains(text(),'Save')]")
	WebElement addPopupSaveButton ;

	@FindBy(xpath = "//span[contains(text(),'Cancel')]")
	WebElement addPopupCancelButton ;	

	@FindBy(xpath = "//mat-select[@placeholder='Sub Category']")
	WebElement subCategoryDropDown ;

	@FindBy(xpath = "(//i[contains(@class,'plus-circle')])[2]")
	WebElement subCategoryDropDownPlusIcon ;

	@FindBy(xpath = "//mat-select[@placeholder='Business Partner']")
	WebElement businessPartnerDropDown ;

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
	WebElement legalEntityDropDown ;

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
		clickElement(categoryDropDownPlusIcon);
	}

	public void enterName(String name) {
		writeText(addPopupNameField, name);	
	}

	public void clickAddPopupCancelButton() {
		clickElement(addPopupCancelButton);
	}

	public void clickAddPopupSaveButton() {
		clickElement(addPopupSaveButton);	
	}

	public void addNewCategory(String categoryName) {
		openAddCategoryPopup();
		enterName(categoryName);
		clickAddPopupSaveButton();
	}

	public void selectSubCategory(String subCategory) {
		selectDropDownOption(subCategoryDropDown, subCategory);
	}

	public void openAddSubCategoryPopup() {
		clickElement(subCategoryDropDownPlusIcon);
	}

	public void addNewSubCategory(String subCategoryName) {
		openAddSubCategoryPopup();
		enterName(subCategoryName);
		clickAddPopupSaveButton();
	}

	public void selectBusinessPartner(String businessPartner) {
		selectDropDownOption(businessPartnerDropDown, businessPartner);
	}

	public void openAddBusinessPartnerPopup() {
		clickElement(businessPartnerDropDownPlusIcon);
	}

	public void addNewBusinessPartner(String businessPartnerName) {
		openAddBusinessPartnerPopup();
		enterName(businessPartnerName);
		clickAddPopupSaveButton();
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
		clickElement(legalEntityDropDownPlusIcon);
	}

	public void addNewLegalEntity(String legalEntityName) {
		openAddLegalEntityPopup();
		enterName(legalEntityName);
		clickAddPopupSaveButton();
	}

	public void clickOnCancelButton() {
		clickElement(generalInformationCancelButton);
	}

	public void clickOnSaveAndContinueButton() {
		clickElement(generalInformationSaveAndContinueButton);
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
