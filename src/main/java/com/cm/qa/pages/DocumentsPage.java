package com.cm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cm.qa.utills.Calendar;

import cm.cm.qa.base.TestBase;

public class DocumentsPage extends TestBase {

	Calendar calendar = new Calendar();

	//Page Factory - OR	
	@FindBy(xpath = "(//div[@class='mat-tab-label-content'][contains(text(),'Document')])[1]")
	WebElement documentsTab ;

	@FindBy(xpath = "//button[contains(text(),'Add Document')]")
	WebElement addDocumentButton ;

	@FindBy(xpath = "//input[@formcontrolname='inputDocumentTitle']")
	WebElement docNameField ;

	@FindBy(xpath = "//mat-select[@placeholder='Contract Type']")
	WebElement contractTypeDropDown ;

	@FindBy(xpath = "//input[@placeholder='Upload Date']")
	WebElement uploadDateField ;

	@FindBy(xpath = "//input[@placeholder='Signed Date']")
	WebElement signedDateField ;

	@FindBy(xpath = "//mat-select[@placeholder='Status']")
	WebElement statusDropDown ;

	@FindBy(xpath = "//input[@placeholder='Attachments']")
	WebElement attachmentsField ;

	@FindBy(id = "(//button[@class='cm-btn' and @id='cancel'])[2]")
	WebElement popUpCancelButton ;

	@FindBy(id = "(//button[@class='cm-btn' and contains(@id,'save')])[2]")
	WebElement popUpSaveButton ;

	@FindBy(id = "(//button[@class='cm-btn' and @id='cancel'])[1]")
	WebElement cancelButton ;

	@FindBy(id = "(//button[@class='cm-btn' and contains(@id,'save')])[1]")
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
	
	public DocumentsPage selectContractType(String contractType) {
		selectDropDownOption(contractTypeDropDown, contractType);
		return this;
	}

	public DocumentsPage enterUploadDate(String uploadDate) {
		calendar.selectDateNew(uploadDateField, uploadDate);
		return this;
	}

	public DocumentsPage enterSignedDate(String signedDate) {
		calendar.selectDateNew(signedDateField, signedDate);
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

	public DocumentsPage fillDocumentForm(String contractType, String uploadDate, String signedDate, String status, String imagePath) {
		selectContractType(contractType);
		enterUploadDate(uploadDate);
		enterSignedDate(signedDate);
		selectStatus(status);
		selectAttachment(imagePath);
		return this;
	}

}
