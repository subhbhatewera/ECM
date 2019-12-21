package com.cm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cm.qa.utills.Calendar;

import cm.cm.qa.base.ActionClass;

public class OtherCommercialTermsPage extends ActionClass{

	Calendar calendar = new Calendar(); 

	//Page Factory - OR	
	@FindBy(xpath = "(//div[@class='mat-tab-label-content'][contains(text(),'Other Commercial')])[1]")
	WebElement otherCommercialTermsTab ;

	@FindBy(xpath = "(//div[@class='mat-tab-label-content'][contains(text(),'COLA')])[1]")
	WebElement colaTab ;

	@FindBy(xpath = "(//div[@class='mat-tab-label-content'][contains(text(),'Incentive')])[1]")
	WebElement incentiveTab ;

	@FindBy(xpath = "(//div[@class='mat-tab-label-content'][contains(text(),'Penalty')])[1]")
	WebElement penaltyTab ;

	@FindBy(xpath = "(//div[@class='mat-tab-label-content'][contains(text(),'Early Payment')])[1]")
	WebElement earlyPaymentDiscountTab ;

	@FindBy(xpath = "(//div[@class='mat-tab-label-content'][contains(text(),'Late Payment')])[1]")
	WebElement latePaymentFeeTab ;

	@FindBy(xpath = "(//div[@class='mat-tab-label-content'][contains(text(),'Termination')])[1]")
	WebElement terminationTab ;

	@FindBy(xpath = "(//div[@class='mat-tab-label-content'][contains(text(),'Limitation')])[1]")
	WebElement limitationOfLiabilityTab ;

	@FindBy(xpath = "//textarea[@placeholder='Clause']")
	WebElement clauseField ;

	@FindBy(xpath = "//input[@placeholder='Type']")
	WebElement typeField ;

	@FindBy(xpath = "//input[@placeholder='Index Type']")
	WebElement indexTypeField ;

	@FindBy(xpath = "//input[@placeholder='Applicable From']")
	WebElement applicableFromField ;

	@FindBy(xpath = "//mat-select[@placeholder='Revision Frequency']")
	WebElement revisionFrequencyDropDown ;

	@FindBy(xpath = "//input[@placeholder='Notice Period']")
	WebElement noticePeriodField ;

	@FindBy(xpath = "//mat-select[contains(@formcontrolname,'Period')]")
	WebElement noticePeriodDurationDropDown ;

	@FindBy(xpath = "//input[@placeholder='Percentage']")
	WebElement percentageField ;

	@FindBy(xpath = "//mat-select[@placeholder='Status']")
	WebElement statusDropDown ;

	@FindBy(xpath = "//input[@placeholder='Reference No.']")
	WebElement referenceNoField ;

	@FindBy(xpath = "//input[@placeholder='Related Reference No.']")
	WebElement relatedReferenceNoField ;

	@FindBy(xpath = "//div[@class='mat-checkbox-inner-container']")
	WebElement checkBox ;

	@FindBy(xpath = "//button[contains(@class,'cm-btn') and contains(text(),'Save')]")
	WebElement cancelButton ;

	@FindBy(xpath = "//button[contains(@class,'cm-btn') and contains(text(),'Save')]")
	WebElement saveAndContinueButton ;	

	@FindBy(xpath = "//input[@placeholder='Date From']")
	WebElement dateFromField ;

	@FindBy(xpath = "//input[@placeholder='Date To']")
	WebElement dateToField ;

	@FindBy(xpath = "//mat-select[@placeholder='Type']")
	WebElement typeDropDown ;

	@FindBy(xpath = "//mat-select[contains(@formcontrolname,'currency')]")
	WebElement currencyDropDown ;	

	@FindBy(xpath = "//input[@placeholder='Value']")
	WebElement valueField ;

	@FindBy(xpath = "//input[@placeholder='Billing Cycle']")
	WebElement billingCycleField ;

	@FindBy(xpath = "//input[@placeholder='Invoice Date']")
	WebElement invoiceDateField ;

	@FindBy(xpath = "//input[@placeholder='Penalty Value']")
	WebElement penaltyValueField ;

	@FindBy(xpath = "//mat-select[@placeholder='Term']")
	WebElement termDropDown ;

	@FindBy(xpath = "//mat-select[@formcontrolname='selectedTimePeriod']")
	WebElement timePeriodDropDown ;

	public OtherCommercialTermsPage() {
		PageFactory.initElements(driver, this);
	}

	public OtherCommercialTermsPage clickOnOtherCommercialTermsTab() {
		clickElement(otherCommercialTermsTab);
		return this ;
	}

	public OtherCommercialTermsPage clickOnCOLATab() {
		sleep(1000);
		clickElement(colaTab);
		return this ;
	}

	public void enterClause(String clause) {
		sleep(1000);
		writeText(clauseField, clause);
	}

	public void enterType(String type) {
		writeText(typeField, type);
	}

	public void enterIndexType(String indexType) {
		writeText(indexTypeField, indexType);
	}

	public void enterApplicableFromDate(String applicableFromDate) {
		calendar.selectDate(applicableFromField, applicableFromDate);
	}

	public void selectRevisionFrequency(String revisionFrequency) {
		selectDropDownOption(revisionFrequencyDropDown, revisionFrequency);
	}

	public void enterNoticePeriod(String noticePeriodValue) {
		writeText(noticePeriodField, noticePeriodValue);
	}

	public void selectNoticePeriodDuration(String noticePeriodDuration) {
		selectDropDownOption(noticePeriodDurationDropDown, noticePeriodDuration);
	}

	public void enterPercentage(String percentageValue) {
		writeText(percentageField, percentageValue);
	}

	public void selectStatus(String status) {
		selectDropDownOption(statusDropDown, status);
	}

	public void enterReferenceNo(String referenceNo) {
		writeText(referenceNoField, referenceNo);
	}

	public void enterRelatedReferenceNo(String relatedReferenceNo) {
		writeText(relatedReferenceNoField, relatedReferenceNo);
	}

	public void selectCheckBox(String checkBoxChoice) {
		if(checkBoxChoice.equalsIgnoreCase("Yes")) {
			clickElement(checkBox);
		}
	}	

	public OtherCommercialTermsPage fillCOLAForm(String clause, String type, String indexType, String applicableFromDate, String revisionFrequency,
			String noticePeriodValue, String noticePeriodDuration, String percentageValue, String status, String referenceNo,
			String relatedReferenceNo, String checkBoxChoice) {
		enterClause(clause);
		enterType(type);
		enterIndexType(indexType);
		enterApplicableFromDate(applicableFromDate);
		selectRevisionFrequency(revisionFrequency);
		enterNoticePeriod(noticePeriodValue);
		selectNoticePeriodDuration(noticePeriodDuration);
		enterPercentage(percentageValue);
		selectStatus(status);
		enterReferenceNo(referenceNo);
		enterRelatedReferenceNo(relatedReferenceNo);
		selectCheckBox(checkBoxChoice);
		return this ;
	}

	public OtherCommercialTermsPage clickOnSaveAndContinueButton() {
		scrollIntoView(saveAndContinueButton);
		clickElement(saveAndContinueButton);
		return this;
	}

	public OtherCommercialTermsPage clickOnIncentiveTab() {
		sleep(1000);
		clickElement(incentiveTab);
		return this;
	}

	public void enterDateFrom(String dateFrom) {
		calendar.selectDate(dateFromField, dateFrom);
	}

	public void enterDateTo(String dateTo) {
		calendar.selectDate(dateToField, dateTo);
	}

	public OtherCommercialTermsPage fillIncentiveForm(String clause, String referenceNo, String percentageValue, String type, String dateFrom, 
			String dateTo, String status, String noticePeriodValue, String noticePeriodDuration, String checkBoxChoice) {
		enterClause(clause);
		enterReferenceNo(referenceNo);
		enterPercentage(percentageValue);
		enterType(type);
		enterDateFrom(dateFrom);
		enterDateTo(dateTo);
		selectStatus(status);
		enterNoticePeriod(noticePeriodValue);
		selectNoticePeriodDuration(noticePeriodDuration);
		selectCheckBox(checkBoxChoice);
		return this;
	}

	public OtherCommercialTermsPage clickOnPenaltyTab() {
		sleep(1000);
		clickElement(penaltyTab);
		return this;
	}

	public void selectType(String type) {
		selectDropDownOption(typeDropDown, type);
	}

	public void selectRadioButton(String radioButtonChoice) {
		WebElement element = driver.findElement(By.xpath("//div[contains(text(),'"+radioButtonChoice+"')]"));
		element.click();
	}

	public OtherCommercialTermsPage fillPenaltyForm(String clause, String referenceNo, String relatedReferenceNo, String percentageValue, String type, 
			String dateFrom, String dateTo, String status, String radioButtonChoice) {
		enterClause(clause);
		enterReferenceNo(referenceNo);
		enterRelatedReferenceNo(relatedReferenceNo);
		enterPercentage(percentageValue);
		selectType(type);
		enterDateFrom(dateFrom);
		enterDateTo(dateTo);
		selectStatus(status);
		selectRadioButton(radioButtonChoice);
		return this;
	}

	public OtherCommercialTermsPage clickOnEarlyPaymentDiscountTab() {
		sleep(1000);
		clickElement(earlyPaymentDiscountTab);
		return this;
	}

	public void enterValue(String value) {
		writeText(valueField, value);
	}

	public void enterBillingCycle(String billingCycleDate) {
		calendar.selectDate(billingCycleField, billingCycleDate);
	}

	public OtherCommercialTermsPage fillEarlyPaymentDiscountForm(String clause, String referenceNo, String relatedReferenceNo, String percentageValue, 
			String value, String billingCycleDate, String dateFrom, String dateTo, String status, String radioButtonChoice ) {
		enterClause(clause);
		enterReferenceNo(referenceNo);
		enterRelatedReferenceNo(relatedReferenceNo);
		enterPercentage(percentageValue);
		enterValue(value);
		enterBillingCycle(billingCycleDate);
		enterDateFrom(dateFrom);
		enterDateTo(dateTo);
		selectStatus(status);
		selectRadioButton(radioButtonChoice);
		return this;
	}

	public OtherCommercialTermsPage clickOnLatePaymentFeeTab() {
		sleep(1000);
		clickElement(latePaymentFeeTab);
		return this;
	}

	public void enterInvoiceDate(String invoiceDate) {
		calendar.selectDate(invoiceDateField, invoiceDate);
	}

	public void selectCurrency(String currency) {
		selectDropDownOption(currencyDropDown, currency);
	}

	public void enterPenaltyValue(String penaltyValue) {
		writeText(penaltyValueField, penaltyValue);
	}

	public OtherCommercialTermsPage fillLatePaymentFeeForm(String clause, String referenceNo, String relatedReferenceNo, String invoiceDate, 
			String noticePeriodValue, String noticePeriodDuration, String currency, String penaltyValue, String status, String radioButtonChoice ) {
		enterClause(clause);
		enterReferenceNo(referenceNo);
		enterRelatedReferenceNo(relatedReferenceNo);
		enterInvoiceDate(invoiceDate);
		enterNoticePeriod(noticePeriodValue);
		selectNoticePeriodDuration(noticePeriodDuration);
		selectCurrency(currency);
		enterPenaltyValue(penaltyValue);
		selectStatus(status);
		selectRadioButton(radioButtonChoice);
		return this;
	}

	public OtherCommercialTermsPage clickOnTerminationTab() {
		sleep(1000);
		clickElement(terminationTab);
		return this;
	}

	public void selectTerm(String term) {
		selectDropDownOption(termDropDown, term);
	}

	public OtherCommercialTermsPage fillTerminationForm(String clause, String type, String noticePeriodValue, String noticePeriodDuration, String term, String status,
			String referenceNo, String dateFrom, String dateTo, String currency, String value, String checkBoxChoice) {
		enterClause(clause);
		enterType(type);
		enterNoticePeriod(noticePeriodValue);
		selectNoticePeriodDuration(noticePeriodDuration);
		selectTerm(term);
		selectStatus(status);
		enterReferenceNo(referenceNo);
		enterDateFrom(dateFrom);
		enterDateTo(dateTo);
		selectCurrency(currency);
		enterValue(value);
		selectCheckBox(checkBoxChoice);
		return this;
	}

	public OtherCommercialTermsPage clickOnLimitationOfLiabilityTab() {
		sleep(1000);
		clickElement(limitationOfLiabilityTab);
		return this;
	}

	public OtherCommercialTermsPage fillLimitationOfLiabilityForm(String clause, String type, String currency, String value, String referenceNo) {
		enterClause(clause);
		enterType(type);
		selectCurrency(currency);
		enterValue(value);
		enterReferenceNo(referenceNo);
		return this;
	}
}
