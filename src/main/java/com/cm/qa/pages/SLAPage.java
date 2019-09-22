package com.cm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cm.qa.utills.Calendar;

import cm.cm.qa.base.TestBase;

public class SLAPage extends TestBase{

	Calendar calendar = new Calendar();

	//Page Factory - OR
	@FindBy(xpath = "(//div[@class='mat-tab-label-content'][contains(text(),'SLA')])[1]")
	WebElement SLATab ;

	@FindBy(xpath = "(//div[@class='mat-tab-label-content'][contains(text(),'TAT')])[1]")
	WebElement TATTab ;

	@FindBy(xpath = "(//div[@class='mat-tab-label-content'][contains(text(),'Quality')])[1]")
	WebElement qualityTab ;

	@FindBy(xpath = "(//div[@class='mat-tab-label-content'][contains(text(),'Uptime')])[1]")
	WebElement uptimeTab ;

	@FindBy(xpath = "//textarea[@placeholder='Clause']")
	WebElement clauseField ;

	@FindBy(xpath = "//input[@placeholder='Reference No.']")
	WebElement referenceNoField ;

	@FindBy(xpath = "//input[@placeholder='Related Reference No.']")
	WebElement relatedReferenceNoField ;

	@FindBy(xpath = "//mat-select[@placeholder='Status']")
	WebElement statusDropDown ;

	@FindBy(xpath = "//mat-select[@formcontrolname='currency']")
	WebElement currencyDropDown ;

	@FindBy(xpath = "//input[@placeholder='Performance Pay']")
	WebElement performancePayField ;

	@FindBy(xpath = "//mat-select[@placeholder='Type']")
	WebElement typeDropDown ;

	@FindBy(xpath = "//input[@placeholder='Hours']")
	WebElement hoursField ;

	@FindBy(xpath = "//button[contains(@class,'cm-btn') and contains(text(),'Cancel')]")
	WebElement cancelButton ;

	@FindBy(xpath = "//button[contains(@class,'cm-btn') and contains(text(),'Save')]")
	WebElement saveAndContinueButton ;

	@FindBy(xpath = "//input[@placeholder='Pre Shipment']")
	WebElement preShipmentField ;

	@FindBy(xpath = "//input[@placeholder='CAL']")
	WebElement CALField ;

	@FindBy(xpath = "//input[@placeholder='Date Reported']")
	WebElement dateReportedField ;

	@FindBy(xpath = "//input[@placeholder='CQR']")
	WebElement CQRField ;

	@FindBy(xpath = "//input[@placeholder='Type']")
	WebElement typeField ;

	@FindBy(xpath = "//input[@placeholder='Uptime Hours']")
	WebElement uptimeHoursField ;	

	public SLAPage() {
		PageFactory.initElements(driver, this);
	}

	public SLAPage clickOnSLATab() {
		clickElement(SLATab);
		return this;
	}

	public SLAPage clickOnTATTab() {
		clickElement(TATTab);
		return this;
	}

	public SLAPage clickOnQualityab() {
		clickElement(qualityTab);
		return this;
	}

	public SLAPage clickOnUptimeTab() {
		clickElement(uptimeTab);
		return this;
	}

	public void enterClause(String clause) {
		writeText(clauseField, clause);
	}

	public void enterReferenceNo(String referenceNo) {
		writeText(referenceNoField, referenceNo);
	}

	public void enterRelatedReferenceNo(String relatedReferenceNo) {
		writeText(relatedReferenceNoField, relatedReferenceNo);
	}

	public void selectStatus(String status) {
		selectDropDownOption(statusDropDown, status);
	}

	public void selectCurrency(String currency) {
		selectDropDownOption(currencyDropDown, currency);
	}

	public void enterPerformancePay(String performancePayValue) {
		writeText(performancePayField, performancePayValue);
	}

	public void selectType(String type) {
		selectDropDownOption(typeDropDown, type);
	}

	public void enterHours(String hoursValue) {
		writeText(hoursField, hoursValue);
	}

	public void selectRadioButton(String radioButtonChoice) {
		WebElement element = driver.findElement(By.xpath("//div[contains(text(),'"+radioButtonChoice+"')]"));
		element.click();
	}

	public SLAPage clickOnCancelButton() {
		clickElement(cancelButton);
		return this;
	}

	public SLAPage clickOnSaveAndContinueButton() {
		clickElement(saveAndContinueButton);
		return this;
	}	

	public SLAPage fillTATForm(String clause, String referenceNo, String relatedReferenceNo, String status, String currency,
			String performancePayValue, String type, String hoursValue, String radioButtonChoice) {
		enterClause(clause);
		enterReferenceNo(referenceNo);
		enterRelatedReferenceNo(relatedReferenceNo);
		selectStatus(status);
		selectCurrency(currency);
		enterPerformancePay(performancePayValue);
		selectType(type);
		enterHours(hoursValue);
		selectRadioButton(radioButtonChoice);
		return this;
	}

	public void enterPreShipment(String preShipmentValue) {
		writeText(preShipmentField, preShipmentValue);
	}

	public void enterCALValue(String CALValue) {
		writeText(CALField, CALValue);
	}

	public void enterDateReported(String dateReported) {
		calendar.selectDateNew(dateReportedField, dateReported);
	}

	public void enterCQRValue(String CQRValue) {
		writeText(CQRField, CQRValue);
	}

	public void entertype(String type) {
		writeText(typeField, type);
	}

	public SLAPage fillQualityForm(String clause, String referenceNo, String relatedReferenceNo, String status, String preShipmentValue,
			String CALValue, String dateReported, String CQRValue, String type, String currency, String performancePayValue, String radioButtonChoice) {
		enterClause(clause);
		enterReferenceNo(referenceNo);
		enterRelatedReferenceNo(relatedReferenceNo);
		selectStatus(status);
		enterPreShipment(preShipmentValue);
		enterCALValue(CALValue);
		enterDateReported(dateReported);
		enterCQRValue(CQRValue);
		entertype(type);
		selectCurrency(currency);
		enterPerformancePay(performancePayValue);
		selectRadioButton(radioButtonChoice);
		return this;
	}

	public void enterUptimeHours(String uptimeHours) {
		writeText(uptimeHoursField, uptimeHours);
	}

	public SLAPage fillUptimeForm(String clause, String referenceNo, String relatedReferenceNo, String status, String uptimeHours,
			String type, String currency, String performancePayValue, String radioButtonChoice) {
		enterClause(clause);
		enterReferenceNo(referenceNo);
		enterRelatedReferenceNo(relatedReferenceNo);
		selectStatus(status);
		enterUptimeHours(uptimeHours);
		entertype(type);
		selectCurrency(currency);
		enterPerformancePay(performancePayValue);
		selectRadioButton(radioButtonChoice);
		return this;
	}
}
