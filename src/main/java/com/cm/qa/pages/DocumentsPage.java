package com.cm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cm.qa.utills.Calendar;

import cm.cm.qa.base.ActionClass;

public class DocumentsPage extends ActionClass {

	Calendar calendar = new Calendar();

	//Page Factory - OR	
	@FindBy(xpath = "(//div[@class='mat-tab-label-content'][contains(text(),'Document')])[1]")
	WebElement documentsTab ;

	@FindBy(xpath = "//button[contains(text(),'Add Document')]")
	WebElement addDocumentButton ;

	@FindBy(xpath = "//input[@formcontrolname='inputDocumentTitle']")
	WebElement docTitleField ;

	@FindBy(xpath = "//mat-select[@placeholder='Contract Type']")
	WebElement contractTypeDropDown ;

	@FindBy(xpath = "//input[@placeholder='Start Date']")
	WebElement startDateField ;

	@FindBy(xpath = "//input[@placeholder='Signed Date']")
	WebElement signedDateField ;

	@FindBy(xpath = "//mat-select[@placeholder='Status']")
	WebElement statusDropDown ;

	@FindBy(xpath = "//input[@placeholder='Attachments']")
	WebElement attachmentsField ;

	@FindBy(xpath = "(//button[@class='cm-btn' and @id='cancel'])[2]")
	WebElement popUpCancelButton ;

	@FindBy(xpath = "//button[contains(text(),'Save')]")
	WebElement popUpSaveButton ;

	@FindBy(xpath = "(//button[@class='cm-btn' and @id='cancel'])[1]")
	WebElement cancelButton ;

	@FindBy(xpath = "//button[contains(text(),'Submit')]")
	WebElement submitButton ;	

	public DocumentsPage() {
		PageFactory.initElements(driver, this);
	}	
	
	public DocumentsPage clickOnDocumentsTab() {
		clickElement(documentsTab);
		return this;
	}

	public DocumentsPage clickOnAddDocumentButton() {
		clickElement(addDocumentButton);
		return this;
	}
	
	public DocumentsPage enterDocTitle(String docTitle) {
		sleep(500);
		writeText(docTitleField, docTitle);
		return this;
	}
	
	public DocumentsPage selectContractType(String contractType) {
		selectDropDownOption(contractTypeDropDown, contractType);
		return this;
	}

	public DocumentsPage enterStartDate(String uploadDate) {
		calendar.selectDate(startDateField, uploadDate);
		return this;
	}

	public DocumentsPage enterSignedDate(String signedDate) {
		calendar.selectDate(signedDateField, signedDate);
		return this;
	}

	public DocumentsPage selectStatus(String status) {
		selectDropDownOption(statusDropDown, status);
		return this;
	}

	public void selectAttachment(String imagePath) {
		clickElement(attachmentsField);
		uploadFile(imagePath);
	//	setReadOnlyFalse(attachmentsField);
	//	writeText(attachmentsField, imagePath);
	}
	
	public DocumentsPage clickOnSaveButton() {		
		clickElement(popUpSaveButton);
		return this;
	}
	
	public DocumentsPage clickOnSubmitButton() {
		sleep(2000);
		submitButton.click();
		return this ;
	}

	public DocumentsPage fillDocumentForm(String docTitle, String contractType, String startDate, String signedDate, String status, String imagePath) {
		enterDocTitle(docTitle);
		selectContractType(contractType);
		enterStartDate(startDate);
		enterSignedDate(signedDate);
		selectStatus(status);
		selectAttachment(imagePath);
		return this;
	}

}
