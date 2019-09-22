package com.cm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cm.qa.utills.Calendar;

import cm.cm.qa.base.TestBase;

public class TermPage extends TestBase{

	Calendar calendar  = new Calendar();

	//Page Factory - OR
	@FindBy(xpath = "(//div[@class='mat-tab-label-content'][contains(text(),'Term')])[1]")
	WebElement termTab ;

	@FindBy(xpath = "(//div[@class='mat-tab-label-content'][contains(text(),'Fixed Period')])[1]")
	WebElement fixedPeriodTab ;

	@FindBy(xpath = "(//div[@class='mat-tab-label-content'][contains(text(),'Fixed Period Without')])[1]")
	WebElement fixedPeriodWithoutRenewalTab ;

	@FindBy(xpath = "(//div[@class='mat-tab-label-content'][contains(text(),'Open Ended')])[1]")
	WebElement openEndedContractsTab ;

	@FindBy(xpath = "//input[@placeholder='Start Date']")
	WebElement startDateField ;

	@FindBy(xpath = "//input[@placeholder='End Date']")
	WebElement endDateField ;

	@FindBy(xpath = "//input[@placeholder='Contract Term']")
	WebElement contractTermField ;

	@FindBy(xpath = "//mat-select[@formcontrolname='contractTermType']")
	WebElement termDurationDropDown ;

	@FindBy(xpath = "//input[@placeholder='Signed Date']")
	WebElement signedDateField ;

	@FindBy(xpath = "//mat-select[@placeholder='Renewal Type']")
	WebElement renewalTypeDropDown ;

	@FindBy(xpath = "//input[@placeholder='Notice Period for Renewal']")
	WebElement noticePeriodField ;

	@FindBy(xpath = "//mat-select[@formcontrolname='noticePeriodType']")
	WebElement noticePeriodDurationDropDown ;

	@FindBy(xpath = "//input[@placeholder='Grace Period']")
	WebElement gracePeriodField ;

	@FindBy(xpath = "//mat-select[@formcontrolname='gracePeriodType']")
	WebElement gracePeriodDurationDropDown ;

	@FindBy(xpath = "//textarea[@placeholder='Description']")
	WebElement descriptionBox ;

	@FindBy(id="cancel")
	WebElement termCancelButton ;

	@FindBy(id="saveAndContinueContractButton")
	WebElement termSaveAndContinueButton ;

	public TermPage() {
		PageFactory.initElements(driver, this);
	}

	public TermPage clickTermTab() {
		clickElement(termTab);
		return this ;
	}

	public TermPage clickFixedPeriodTab() {
		clickElement(fixedPeriodTab);
		return this ;
	}

	public TermPage clickFixedPeriodWithoutRenewalTab() {
		clickElement(fixedPeriodWithoutRenewalTab);
		return this ;
	}

	public TermPage clickOpenEndedContractsTab() {
		clickElement(openEndedContractsTab);
		return this ;
	}

	public void enterStartDate(String startDate) {
		calendar.selectDateNew(startDateField, startDate);
	}	

	public void enterEndDate(String endDate) {
		calendar.selectDateNew(endDateField, endDate);
	}

	public void enterContractTerm(String contractTermValue) {
		writeText(contractTermField, contractTermValue);
	}

	public void selectContractTermDuration(String contractTermDuration) {
		selectDropDownOption(termDurationDropDown, contractTermDuration);
	}

	public void enterSignedDate(String signedDate) {
		calendar.selectDateNew(signedDateField, signedDate);
	}

	public void selectRenewalType(String renewalType) {
		selectDropDownOption(renewalTypeDropDown, renewalType);
	}

	public void enterNoticePeriod(String noticePeriodValue) {
		writeText(noticePeriodField, noticePeriodValue);
	}

	public void selectNoticePeriodDuration(String noticePeriodDuration) {
		selectDropDownOption(noticePeriodDurationDropDown, noticePeriodDuration);
	}

	public void enterGracePeriod(String gracePeriodValue) {
		writeText(gracePeriodField, gracePeriodValue);
	}

	public void selectGracePeriodDuration(String gracePeriodDuration) {
		selectDropDownOption(gracePeriodDurationDropDown, gracePeriodDuration);
	}	

	public void enterDescription(String description) {
		writeText(descriptionBox, description);
	}

	public void clickOnCancelButton() {
		clickElement(termCancelButton);
	}

	public void clickOnSaveAndContinueButton() {
		clickElement(termSaveAndContinueButton);
	}

	public TermPage fillFixedPeriodForm(String startDate, String endDate, String contractTermValue, String contractTermDuration,
			String signedDate, String renewalType, String noticePeriodValue, String noticePeriodDuration, String gracePeriodValue, String gracePeriodDuration,
			String description) {
		clickFixedPeriodTab();
		enterStartDate(startDate);
		enterEndDate(endDate);
		enterContractTerm(contractTermValue);
		selectContractTermDuration(contractTermDuration);
		enterSignedDate(signedDate);
		selectRenewalType(renewalType);
		enterNoticePeriod(noticePeriodValue);
		selectNoticePeriodDuration(noticePeriodDuration);
		enterGracePeriod(gracePeriodValue);
		selectGracePeriodDuration(gracePeriodDuration);
		enterDescription(description);
		return this;
	}

	public TermPage fillFixedPeriodWithoutRenewalForm(String startDate, String endDate, String contractTermValue, String contractTermDuration,
			String signedDate, String gracePeriodValue, String gracePeriodDuration,	String description) {
		clickFixedPeriodWithoutRenewalTab();
		enterStartDate(startDate);
		enterEndDate(endDate);
		enterContractTerm(contractTermValue);
		selectContractTermDuration(contractTermDuration);
		enterSignedDate(signedDate);
		enterGracePeriod(gracePeriodValue);
		selectGracePeriodDuration(gracePeriodDuration);
		enterDescription(description);
		return this ;
	}

	public TermPage fillOpenEndedContractsForm(String startDate, String signedDate, String description) {
		clickOpenEndedContractsTab();
		enterStartDate(startDate);
		enterSignedDate(signedDate);
		enterDescription(description);
		return this;
	}	

	public TermPage selectTermType(String termType) {
		if(termType.equalsIgnoreCase("Fixed Period")) {
			clickFixedPeriodTab();
		}
		else if(termType.equalsIgnoreCase("Fixed Period Without Renewal")) {
			clickFixedPeriodWithoutRenewalTab();
		}
		else if(termType.equalsIgnoreCase("Open Ended")) {
			clickOpenEndedContractsTab();
		}
		return this;
	}

	public TermPage fillTermForm(String termType, String startDate, String signedDate, String endDate, String contractTermValue,
			String contractTermDuration, String renewalType, String noticePeriodValue, String noticePeriodDuration, String gracePeriodValue,
			String gracePeriodDuration, String description) {
		if(termType.equalsIgnoreCase("Fixed Period")) {
			clickFixedPeriodTab();
			enterStartDate(startDate);
			enterSignedDate(signedDate);
			enterEndDate(endDate);
			enterContractTerm(contractTermValue);
			selectContractTermDuration(contractTermDuration);
			selectRenewalType(renewalType);
			enterNoticePeriod(noticePeriodValue);
			selectNoticePeriodDuration(noticePeriodDuration);
			enterGracePeriod(gracePeriodValue);
			selectGracePeriodDuration(gracePeriodDuration);
			enterDescription(description);
		}
		else if(termType.equalsIgnoreCase("Fixed Period Without Renewal")) {
			clickFixedPeriodWithoutRenewalTab();
			enterStartDate(startDate);
			enterSignedDate(signedDate);
			enterEndDate(endDate);
			enterContractTerm(contractTermValue);
			selectContractTermDuration(contractTermDuration);
			enterGracePeriod(gracePeriodValue);
			selectGracePeriodDuration(gracePeriodDuration);
			enterDescription(description);
		}
		else if(termType.equalsIgnoreCase("Open Ended")) {
			clickOpenEndedContractsTab();
			enterStartDate(startDate);
			enterSignedDate(signedDate);
			enterDescription(description);
		}
		return this;
	}
}
