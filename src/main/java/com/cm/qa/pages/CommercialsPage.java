package com.cm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cm.qa.utills.Calendar;

import cm.cm.qa.base.ActionClass;

public class CommercialsPage extends ActionClass{

	Calendar calendar  = new Calendar();

	//Page Factory - OR
	@FindBy(xpath = "(//div[@class='mat-tab-label-content'][contains(text(),'Commercials')])[1]")
	WebElement commercialsTab ;

	@FindBy(xpath = "(//div[@class='mat-tab-label-content'][contains(text(),'General Terms')])[1]")
	WebElement generalTermsTab ;

	@FindBy(xpath = "(//div[@class='mat-tab-label-content'][contains(text(),'Standard')])[1]")
	WebElement transactionRateStandardTab ;

	@FindBy(xpath = "(//div[@class='mat-tab-label-content'][contains(text(),'Volume')])[1]")
	WebElement transactionRateVolumeTab ;

	@FindBy(xpath = "(//div[@class='mat-tab-label-content'][contains(text(),'Time')])[1]")
	WebElement timeAndMaterialModelTab ;

	@FindBy(xpath = "(//div[@class='mat-tab-label-content'][contains(text(),'Fixed')])[1]")
	WebElement fixedFeeTab ;

	@FindBy(xpath = "(//div[@class='mat-tab-label-content'][contains(text(),'Minimum')])[1]")
	WebElement minimumBillingTab ;

	@FindBy(xpath = "//mat-select[@placeholder='Billing Frequency']")
	WebElement billingFrequencyDropDown ;

	@FindBy(xpath = "//input[@placeholder='Credit Period']")
	WebElement creditPeriodField ;

	@FindBy(xpath = "//mat-select[@formcontrolname='creditPeriodType']")
	WebElement creditPeriodDurationDropDown ;

	@FindBy(xpath = "//input[@placeholder='Billing Start Date']")
	WebElement billingStartDateField ;

	@FindBy(xpath = "//input[@placeholder='Billing End Date']")
	WebElement billingEndDateField ;

	@FindBy(xpath = "//mat-select[@placeholder='Billing Currency']")
	WebElement billingCurrencyDropDown ;

	@FindBy(xpath = "//textarea[@placeholder='Clause']")
	WebElement clauseField ;

	@FindBy(id = "(//button[@id='cancel'])[1]")
	WebElement listingScreenCancelButton ;

	@FindBy(xpath = "(//button[contains(text(),'Save')])[1]")
	WebElement listingScreenSaveButton ;	

	@FindBy(xpath = "//button[contains(text(),'Add')]")
	WebElement addButton ;

	@FindBy(xpath = "//input[@placeholder='Line Item']")
	WebElement lineItemField ;

	@FindBy(xpath = "//mat-select[contains(@formcontrolname,'currency')]")
	WebElement currencyDropDown ;

	@FindBy(xpath = "//input[@placeholder='Rate']")
	WebElement rateField ;

	@FindBy(xpath = "//mat-select[@placeholder='UOM']")
	WebElement uomDropDown ;

	@FindBy(xpath = "(//i[contains(@class,'plus-circle')])[1]")
	WebElement uomDropDownPlusIcon ;

	@FindBy(xpath = "//input[@placeholder='Name']")
	WebElement addPopupNameField ;

	@FindBy(xpath = "//span[contains(@class,'mat-button') and contains(text(),'Save')]")
	WebElement addPopupSaveButton ;

	@FindBy(xpath = "//input[@placeholder='Effective Start Date']")
	WebElement effectiveStartDateField ;

	@FindBy(xpath = "//input[@placeholder='Effective End Date']")
	WebElement effectiveEndDateField ;

	@FindBy(xpath = "(//input[contains(@placeholder,'Reference No')])[1]")
	WebElement referenceNoField ;

	@FindBy(xpath = "//input[contains(@placeholder,'Related Ref')]")
	WebElement relatedReferenceNoField ;

	@FindBy(xpath = "//mat-select[@placeholder='Linked Opportunity']")
	WebElement linkedOpportunityDropDown ;

	@FindBy(xpath = "(//i[contains(@class,'plus-circle')])[2]")
	WebElement linkedOpportunityDropDownPlusIcon ;

	@FindBy(xpath = "//mat-select[@placeholder='Related Doc']")
	WebElement relatedDocDropDown ;

	@FindBy(xpath = "//input[@placeholder='Platforms Applicable']")
	WebElement platformsApplicableField ;

	@FindBy(xpath = "//mat-select[@placeholder='Service']")
	WebElement serviceDropDown ;

	@FindBy(xpath = "(//i[contains(@class,'plus-circle')])[3]")
	WebElement serviceDropDownPlusIcon ;

	@FindBy(xpath = "//mat-select[@placeholder='Sub Service']")
	WebElement subServiceDropDown ;

	@FindBy(xpath = "(//i[contains(@class,'plus-circle')])[4]")
	WebElement subServiceDropDownPlusIcon ;

	@FindBy(xpath = "//mat-select[@placeholder='Project']")
	WebElement projectDropDown ;

	@FindBy(xpath = "(//i[contains(@class,'plus-circle')])[5]")
	WebElement projectDropDownPlusIcon ;

	@FindBy(xpath = "//mat-select[@placeholder='Sub Project']")
	WebElement subProjectDropDown ;

	@FindBy(xpath = "//input[@placeholder='Location']")
	WebElement locationField ;

	@FindBy(xpath = "(//button[@class='cm-btn' and contains(text(),'Cancel')])[2]")
	WebElement addScreenCancelButton ;

	@FindBy(xpath = "(//button[contains(text(),'Save')])[2]")
	WebElement addScreenSaveButton ;

	@FindBy(xpath = "//mat-select[@placeholder='Tier Type']")
	WebElement tierTypeDropDown ;

	@FindBy(xpath = "//mat-select[@placeholder='Volume Split']")
	WebElement volumeSplitDropDown ;

	@FindBy(xpath = "//input[@placeholder='Volume Group Name']")
	WebElement volumeGroupNameField ;

	@FindBy(xpath = "(//input[@formcontrolname='lower_tier'])[1]")
	WebElement lowerTierField ;	

	@FindBy(xpath = "(//input[@formcontrolname='lower_tier'])[1]")
	WebElement lowerTierAdditionalField ;	

	@FindBy(xpath = "//input[@formcontrolname='upper_tier']")
	WebElement upperTierField ;	

	@FindBy(xpath = "(//input[@formcontrolname='rate'])[1]")
	WebElement tableRateField ;	

	@FindBy(xpath = "(//mat-select[@formcontrolname='applicable_factor'])[1]")
	WebElement applicableFactorDropDown ;

	@FindBy(xpath = "//i[@class='fas fa-plus']")
	WebElement actionColumnPlusIcon ;

	@FindBy(xpath = "(//i[@ng-reflect-klass='fas'])[1]")
	WebElement actionColumnEditIcon ;

	@FindBy(xpath = "//textarea[@placeholder='Description']")
	WebElement descriptionField ;

	@FindBy(xpath = "(//input[@formcontrolname='description_table'])[1]")
	WebElement tableDescriptionField ;

	@FindBy(xpath = "(//input[@formcontrolname='effective_date'])[1]")
	WebElement effectiveDateField ;

	@FindBy(xpath = "//mat-select[@formcontrolname='uom']")
	WebElement tableUOMDropDown ;

	@FindBy(xpath = "(//input[@formcontrolname='quantity'])[1]")
	WebElement tableQuantityField ;

	@FindBy(xpath = "(//input[@formcontrolname='description_table'])[2]")
	WebElement tableDescriptionAdditionalField ;

	@FindBy(xpath = "//mat-select[@placeholder='Advance Billing']")
	WebElement advanceBillingDropDown ;

	@FindBy(xpath = "//mat-select[@placeholder='Applicable Period']")
	WebElement applicablePeriodDropDown ;

	@FindBy(xpath = "//mat-select[@placeholder='Type']")
	WebElement typeDropDown ;

	@FindBy(xpath = "//input[@placeholder='Quantity']")
	WebElement quantityField ;

	@FindBy(xpath = "(//i[@mattooltip='Edit'])[1]")
	WebElement editIcon ;

	@FindBy(xpath = "(//i[@mattooltip='Copy'])[1]")
	WebElement copyIcon ;

	@FindBy(xpath = "(//i[@mattooltip='Delete'])[1]")
	WebElement deleteIcon ;

	@FindBy(xpath = "//button[contains(@class,'cm-btn cancel')]")
	WebElement confirmationPopUpCancelButton ;

	@FindBy(xpath = "//button[contains(@class,'cm-btn accept')]")
	WebElement confirmationPopUpYesButton;

	@FindBy(xpath = "//span[contains(@class,'mat-select-value')]")
	WebElement selectedDropDownOption;

	//Constructor
	public CommercialsPage() {
		PageFactory.initElements(driver, this);
	}

	public CommercialsPage clickOnCommercialsTab() {
		clickElement(commercialsTab);
		return this;
	}

	public CommercialsPage clickOnGeneralTermsTab() {
		clickElement(generalTermsTab);
		return this;
	}

	public void selectBillingFrequency(String billingFrequency) {
		selectDropDownOption(billingFrequencyDropDown, billingFrequency);
	}

	public void enterCreditPeriodValue(String creditPeriodValue) {
		writeText(creditPeriodField, creditPeriodValue);
	}

	public void selectCreditPeriodDuration(String creditPeriodDuration) {
		selectDropDownOption(creditPeriodDurationDropDown, creditPeriodDuration);
	}

	public void enterBillingStartDate(String billingStartDate) {
		calendar.selectDate(billingStartDateField, billingStartDate);
	}

	public void enterBillingEndDate(String billingEndDate) {
		calendar.selectDate(billingEndDateField, billingEndDate);
	}

	public void selectBillingCurrency(String billingCurrency) {
		selectDropDownOption(billingCurrencyDropDown, billingCurrency);
	}

	public void enterClause(String clause) {
		writeText(clauseField, clause);
	}

	public CommercialsPage clickOnListingScreenSaveButton() {
		clickElement(listingScreenSaveButton);
		return this;
	}

	public CommercialsPage fillGeneralTermsForm(String billingFrequency, String creditPeriodValue, String creditPeriodDuration, String billingStartDate,
			String billingEndDate, String billingCurrency, String clause) {
		selectBillingFrequency(billingFrequency);
		enterCreditPeriodValue(creditPeriodValue);
		selectCreditPeriodDuration(creditPeriodDuration);
		enterBillingStartDate(billingStartDate);
		enterBillingEndDate(billingEndDate);
		selectBillingCurrency(billingCurrency);
		enterClause(clause);
		return this;
	}

	public CommercialsPage clickOnTransactionRateStandardTab() {
		clickElement(transactionRateStandardTab);
		return this;
	}

	public CommercialsPage clickOnAddButton() {
		clickElement(addButton);
		return this;
	}

	public CommercialsPage enterLineItem(String lineItem) {
		writeText(lineItemField, lineItem);
		return this;
	}

	public CommercialsPage selectCurrency(String currency) {
		selectDropDownOption(currencyDropDown, currency);
		return this;
	}

	public CommercialsPage enterRate(String rate) {
		writeText(rateField, rate);
		return this;
	}

	public CommercialsPage selectUOM(String uomOption) {
		selectDropDownOption(uomDropDown, uomOption);
		return this;
	}

	public CommercialsPage clickUOMPlusIcon() {
		clickElementUsingJS(uomDropDownPlusIcon);
		return this ;
	}

	public CommercialsPage enterName(String name) {
		writeText(addPopupNameField, name);
		return this;
	}

	public CommercialsPage addUOM(String uomName) {
		clickUOMPlusIcon();
		sleep(500);
		enterName(uomName);
		sleep(500);
		clickElement(addPopupSaveButton);
		return this;
	}

	public String getSelectDropDownOption() {
		return selectedDropDownOption.getText();
	}

	public void enterEffectiveStartDate(String effStartDate) {
		calendar.selectDate(effectiveStartDateField, effStartDate);
	}

	public void enterEffectiveEndDate(String effEndDate) {
		calendar.selectDate(effectiveEndDateField, effEndDate);
	}

	public void enterReferenceNo(String referenceNo) {
		writeText(referenceNoField, referenceNo);
	}

	public void enterRelatedReferenceNo(String relatedReferenceNo) {
		writeText(relatedReferenceNoField, relatedReferenceNo);
	}

	public CommercialsPage clickLinkedOpportunityPlusIcon() {
		clickElementUsingJS(linkedOpportunityDropDownPlusIcon);
		return this ;
	}

	public CommercialsPage addLinkedOpportunity(String linkedOpportunityName) {
		clickLinkedOpportunityPlusIcon();
		sleep(500);
		enterName(linkedOpportunityName);
		sleep(500);
		clickElement(addPopupSaveButton);
		return this;
	}

	public void enterPlatformsApplicable(String plarformsApplicable) {
		scrollIntoView(platformsApplicableField);
		writeText(platformsApplicableField, plarformsApplicable);
	}

	public void selectService(String service) {
		selectDropDownOption(serviceDropDown, service);
	}

	public CommercialsPage clickServicePlusIcon() {
		scrollIntoView(platformsApplicableField);
		clickElementUsingJS(serviceDropDownPlusIcon);
		return this ;
	}

	public CommercialsPage addService(String serviceName) {
		clickServicePlusIcon();
		sleep(500);
		enterName(serviceName);
		sleep(500);
		clickElement(addPopupSaveButton);
		return this;
	}

	public void selectSubService(String subService) {
		selectDropDownOption(subServiceDropDown, subService);
	}

	public CommercialsPage clickSubServicePlusIcon() {
		scrollIntoView(platformsApplicableField);
		clickElementUsingJS(subServiceDropDownPlusIcon);
		return this ;
	}

	public CommercialsPage addSubService(String subServiceName) {
		clickSubServicePlusIcon();
		sleep(500);
		enterName(subServiceName);
		sleep(500);
		clickElement(addPopupSaveButton);
		return this;
	}

	public CommercialsPage clickProjectPlusIcon() {
		scrollIntoView(platformsApplicableField);
		clickElementUsingJS(projectDropDownPlusIcon);
		return this ;
	}

	public CommercialsPage addProject(String projectName) {
		clickProjectPlusIcon();
		sleep(500);
		enterName(projectName);
		sleep(500);
		clickElement(addPopupSaveButton);
		return this;
	}

	public void selectLocation(String location) {
		selectLocation(locationField, location);
	}

	public CommercialsPage fillTransactionRateStandardForm(String lineItem, String currency, String rate, String uomOption, String effStartDate,
			String  effEndDate, String referenceNo, String relatedReferenceNo, String plarformsApplicable, String service, String subService, String location) {
		enterLineItem(lineItem);
		selectCurrency(currency);
		enterRate(rate);
		selectUOM(uomOption);
		enterEffectiveStartDate(effStartDate);
		enterEffectiveEndDate(effEndDate);
		enterReferenceNo(referenceNo);
		enterRelatedReferenceNo(relatedReferenceNo);
		enterPlatformsApplicable(plarformsApplicable);
		selectService(service);
		selectSubService(subService);
		selectLocation(location);
		return this;
	}

	public CommercialsPage clickAddScreenCancelButton() {
		clickElement(addScreenCancelButton);
		return this;
	}

	public CommercialsPage clickOnAddScreenSaveButton() {
		scrollIntoView(addScreenSaveButton);
		sleep(100);
		clickElement(addScreenSaveButton);
		return this;
	}

	public CommercialsPage clickOnEditIcon(String lineItemName) {
		WebElement element = driver.findElement(By.xpath("//span[contains(@title,'"+lineItemName+"')]//following::i[contains(@class,'pencil')]"));
		sleep(1000);
		clickElement(element);
		return this ;
	}

	public CommercialsPage clickOnDeleteIcon(String lineItemName) {
		WebElement element = driver.findElement(By.xpath("(//span[contains(@title,'"+lineItemName+"')]//following::i[contains(@class,'trash')])[1]"));
		clickElement(element);
		return this ;
	}

	public CommercialsPage clickOnCopyIcon(String lineItemName) {
		WebElement element = driver.findElement(By.xpath("(//span[contains(@title,'"+lineItemName+"')]//following::i[contains(@class,'fa-files')])[1]"));
		clickElement(element);
		return this ;
	}

	public CommercialsPage clickOnConfirmationPopUpYesButton() {
		clickElement(confirmationPopUpYesButton);
		return this;
	}

	public CommercialsPage clickOnTransactionRateVolumeTab() {
		clickElement(transactionRateVolumeTab);
		return this;
	}

	public CommercialsPage selectTierType(String tierType, String volumeSplit, String volumeGroupName) {
		selectDropDownOption(tierTypeDropDown, tierType);
		if(tierType.equalsIgnoreCase("Simple")) {
			selectDropDownOption(volumeSplitDropDown, volumeSplit);
		}
		else if(tierType.equalsIgnoreCase("Group")) {
			writeText(volumeGroupNameField, volumeGroupName);
		}
		return this;
	}

	public CommercialsPage enterLowerTier(String lowerTierValue) {
		writeText(lowerTierField, lowerTierValue);
		return this;
	}

	public void scrollIntoLowerTierAdditionalField() {
		scrollIntoView(lowerTierAdditionalField);
	}

	public CommercialsPage enterUpperTier(String upperTierValue) {
		writeText(upperTierField, upperTierValue);
		return this;
	}

	public CommercialsPage enterTableRate(String rateValue) {
		writeText(tableRateField, rateValue);
		return this;
	}

	public CommercialsPage selectApplicableFactor(String applicableFactor) {
		selectDropDownOption(applicableFactorDropDown, applicableFactor);
		return this;
	}

	public CommercialsPage clickOnActionColumnPlusIcon() {
		clickElement(actionColumnPlusIcon);
		return this;
	}

	public CommercialsPage clickOnActionColumnEditIcon() {
		clickElement(actionColumnEditIcon);
		return this;
	}

	public CommercialsPage fillTransactionRateVolumeForm(String lineItem, String tierType, String volumeSplit, String volumeGroupName, 
			String lowerTierValue, String upperTierValue, String rateValue, String applicableFactor, String uomOption, 
			String effStartDate, String  effEndDate, String referenceNo, String relatedReferenceNo, String plarformsApplicable, String service, String subService, String location) {
		enterLineItem(lineItem);
		selectTierType(tierType, volumeSplit, volumeGroupName);
		enterLowerTier(lowerTierValue);
		enterUpperTier(upperTierValue);
		enterTableRate(rateValue);
		selectApplicableFactor(applicableFactor);
		clickOnActionColumnPlusIcon();
		scrollIntoLowerTierAdditionalField();
		selectUOM(uomOption);
		enterEffectiveStartDate(effStartDate);
		enterEffectiveEndDate(effEndDate);
		enterReferenceNo(referenceNo);
		enterRelatedReferenceNo(relatedReferenceNo);
		enterPlatformsApplicable(plarformsApplicable);
		selectService(service);
		selectSubService(subService);
		selectLocation(location);
		return this;
	}

	public CommercialsPage clickOnTimeAndmaterialModelTab() {
		clickElement(timeAndMaterialModelTab);
		return this;
	}

	public CommercialsPage enterDescription(String description) {
		writeText(descriptionField, description);
		return this;
	}

	public CommercialsPage enterTableDescription(String tableDescription) {
		writeText(tableDescriptionField, tableDescription);
		return this;
	}

	public CommercialsPage enterEffectiveDate(String effDate) {
		calendar.selectDate(effectiveDateField, effDate);
		return this;
	}

	public CommercialsPage selectTableUOM(String tableUOM) {
		selectDropDownOption(tableUOMDropDown, tableUOM);
		return this;
	}

	public CommercialsPage enterTableQuantity(String quantity) {
		writeText(tableQuantityField, quantity);
		return this;
	}

	public void scrollIntoTableDescriptioAdditionalField() {
		scrollIntoView(tableDescriptionAdditionalField);
	}

	public CommercialsPage fillTimeAndMaterialModelForm(String description, String tableDescription, String effDate, String rateValue,
			String tableUOM, String quantity, String effStartDate, String  effEndDate, String referenceNo, String relatedReferenceNo,
			String plarformsApplicable, String service, String subService, String location) {
		enterDescription(description);
		enterTableDescription(tableDescription);
		enterEffectiveDate(effDate);
		enterTableRate(rateValue);
		selectTableUOM(tableUOM);
		enterTableQuantity(quantity);
		clickOnActionColumnPlusIcon();
		scrollIntoTableDescriptioAdditionalField();
		enterEffectiveStartDate(effStartDate);
		enterEffectiveEndDate(effEndDate);
		enterReferenceNo(referenceNo);
		enterRelatedReferenceNo(relatedReferenceNo);
		enterPlatformsApplicable(plarformsApplicable);
		selectService(service);
		selectSubService(subService);
		selectLocation(location);
		return this;
	}

	public CommercialsPage clickOnFixedFeeTab() {
		clickElement(fixedFeeTab);
		return this;
	}

	public void selectAdvancedBilling(String advancedBilling, String effStartDate, String effEndDate) {
		selectDropDownOption(advanceBillingDropDown, advancedBilling);
		if(advancedBilling.contentEquals("Yes")) {
			enterEffectiveStartDate(effStartDate);
			enterEffectiveEndDate(effEndDate);
		}
	}

	public void selectApplicablePeriod(String applicablePeriod) {
		selectDropDownOption(applicablePeriodDropDown, applicablePeriod);
	}

	public CommercialsPage fillFixedFeeForm(String lineItem, String currency, String rate, String uomOption, String advancedBilling, 
			String effStartDate, String  effEndDate, String applicablePeriod, String referenceNo, String relatedReferenceNo, String plarformsApplicable, 
			String service, String subService, String location) {
		enterLineItem(lineItem);
		selectCurrency(currency);
		enterRate(rate);
		selectUOM(uomOption);
		selectAdvancedBilling(advancedBilling, effStartDate, effEndDate);
		selectApplicablePeriod(applicablePeriod);
		enterReferenceNo(referenceNo);
		enterRelatedReferenceNo(relatedReferenceNo);
		enterPlatformsApplicable(plarformsApplicable);
		selectService(service);
		selectSubService(subService);
		selectLocation(location);
		return this;
	}

	public CommercialsPage clickOnMinimumBillingTab() {
		clickElement(minimumBillingTab);
		return this;
	}

	public CommercialsPage selectType(String type, String currency, String rate, String quantity) {
		selectDropDownOption(typeDropDown, type);
		if(type.equalsIgnoreCase("Value")) {
			selectCurrency(currency);
			enterRate(rate);
		}
		else if(type.equalsIgnoreCase("Volume")) {
			writeText(quantityField, quantity);
		}
		return this;
	}

	public CommercialsPage fillMinimumBillingForm(String lineItem, String type,String currency, String rate, String quantity, String uomOption, 
			String effStartDate, String  effEndDate, String applicablePeriod, String referenceNo, String relatedReferenceNo,
			String plarformsApplicable, String service, String subService, String location) {
		enterLineItem(lineItem);
		selectType(type, currency, rate, quantity);
		selectUOM(uomOption);
		enterEffectiveStartDate(effStartDate);
		enterEffectiveEndDate(effEndDate);
		selectApplicablePeriod(applicablePeriod);
		enterReferenceNo(referenceNo);
		enterRelatedReferenceNo(relatedReferenceNo);
		enterPlatformsApplicable(plarformsApplicable);
		selectService(service);
		selectSubService(subService);
		selectLocation(location);
		return this;
	}

}
