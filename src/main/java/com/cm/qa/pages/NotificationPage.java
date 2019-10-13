package com.cm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cm.qa.utills.Calendar;

import cm.cm.qa.base.TestBase;

public class NotificationPage extends TestBase {

	Calendar calendar = new Calendar();

	//Page Factory - OR
	@FindBy(xpath = "//div[@class='heading' and contains(text(),'Notification')]")
	WebElement notificationPageHeading ;

	@FindBy(xpath = "//button[contains(@class,'cm-btn') and contains(text(),'Add')]")
	WebElement addButton ;

	@FindBy(xpath = "//input[@placeholder='Title']")
	WebElement titleField ;

	@FindBy(xpath = "//mat-select[@placeholder='Business Partner']")
	WebElement businessPartnerDropDown ;

	@FindBy(xpath = "//mat-select[@placeholder='Type']")
	WebElement typeDropDown ;

	@FindBy(xpath = "//input[@placeholder='Date']")
	WebElement dateField ;

	@FindBy(xpath = "//mat-select[@placeholder='Linked Contract Information']")
	WebElement linkedContractInformationDropDown ;

	@FindBy(xpath = "//textarea[@placeholder='Description']")
	WebElement descriptionField ;

	@FindBy(xpath = "//input[@placeholder='Notice Period']")
	WebElement noticePeriodField ;

	@FindBy(xpath = "//mat-select[@formcontrolname='noticePeriodType']")
	WebElement noticePeriodDurationDropDown ;

	@FindBy(xpath = "//input[@placeholder='Reminder Start Date']")
	WebElement reminderStartDateField ;

	@FindBy(xpath = "//input[@placeholder='Reminder End Date']")
	WebElement reminderEndDateField ;

	@FindBy(xpath = "//mat-select[@placeholder='Select Users']")
	WebElement selectUsersDropDown ;

	@FindBy(xpath = "//input[@placeholder='Add Email Address']")
	WebElement alternateEmailField ;

	@FindBy(xpath = "//input[@placeholder='Send Copy To']")
	WebElement sendCopyToField ;

	@FindBy(xpath = "//i[contains(@class,'plus-circle')]")
	WebElement plusIcon ;	

	@FindBy(xpath = "//button[contains(@class,'cm-btn') and contains(text(),'Cancel')]")
	WebElement cancelButton ;

	@FindBy(xpath = "//button[contains(@class,'cm-btn') and contains(text(),'Save')]")
	WebElement saveButton ;

	@FindBy(xpath = "//button[contains(@class,'accept')]")
	WebElement confirmationPopUpYesButton ;

	public NotificationPage () {
		PageFactory.initElements(driver, this);
	}

	public String verifyNotificationPageHeading() {
		customVisibleWait(notificationPageHeading);
		return notificationPageHeading.getText() ;
	}

	public NotificationPage clickOnAddButton() {
		clickElement(addButton);
		return this ;
	}

	public void enterTitle(String title) {
		writeText(titleField, title);
	}

	public void selectBusinessPartner(String businessPartner) {
		selectDropDownOption(businessPartnerDropDown, businessPartner);
	}

	public void selectType(String type) {
		selectDropDownOption(typeDropDown, type);
	}

	public void enterDate(String date) {
		calendar.selectDateNew(dateField, date);
	}

	public void selectLinkedContractInformation(String linkedContractInformation) {
		selectDropDownOption(linkedContractInformationDropDown, linkedContractInformation);
	}

	public void enterDescription(String description) {
		writeText(descriptionField, description);
	}

	public NotificationPage fillGeneralInformationForm(String title, String businessPartner, String type, String date, String linkedContractInformation, String description) {
		enterTitle(title);
		selectBusinessPartner(businessPartner);
		selectType(type);
		enterDate(date);
		selectLinkedContractInformation(linkedContractInformation);
		enterDescription(description);
		return this ;
	}

	public NotificationPage fillNotificationForm(String title, String businessPartner, String type, String date, String linkedContractInformation, String description,
			String reminder, String noticePeriodValue, String noticePeriodDuration, 
			String reminderStartDate, String reminderEndDate, String reminderType, String userName, String alternateEmail,
			String sendCopyToEmail, String reminderFrequency) {
		fillGeneralInformationForm(title, businessPartner, type, date, linkedContractInformation, description);
		if(reminder.equalsIgnoreCase("Yes")) {
			fillReminderForm(reminder, noticePeriodValue, noticePeriodDuration, reminderStartDate, reminderEndDate, reminderType, userName, alternateEmail, sendCopyToEmail, reminderFrequency);
		}
		return this;
	}

	public NotificationPage clickOnSaveButton() {
		scrollIntoView(saveButton);
		clickElement(saveButton);
		return this ;
	}

	public String verifyNotificationUnderListingTable(String notificationTitle) {
		WebElement element =driver.findElement(By.xpath("//span[@title='"+notificationTitle+"']"));
		customVisibleWait(element);
		return element.getText() ;
	}

	public void selectRadioButton(String radioButtonChoice) {
		WebElement element = driver.findElement(By.xpath("//div[text()='"+radioButtonChoice+"']"));
		clickElement(element);
	}

	public void enterNoticePeriod(String noticePeriodValue) {
		writeText(noticePeriodField, noticePeriodValue);
	}

	public void selectNoticePeriodDuration(String noticePeriodDuration) {
		selectDropDownOption(noticePeriodDurationDropDown, noticePeriodDuration);
	}

	public void enterReminderStartDate(String reminderStartDate) {
		calendar.selectDateNew(reminderStartDateField, reminderStartDate);
	}

	public void enterReminderEndDate(String reminderEndDate) {
		calendar.selectDateNew(reminderEndDateField, reminderEndDate);
	}

	public void selectReminderType(String reminderType) {		
		String xpathValue = reminderType.toUpperCase();
		WebElement element = driver.findElement(By.xpath("//mat-radio-button[@value='"+xpathValue+"']"));
		clickElement(element);
	}

	public void selectUser(String userName) {
		selectDropDownOption(selectUsersDropDown, userName);
		selectUsersDropDown.sendKeys(Keys.TAB);
	}

	public void enterAlternateEmail(String alternateEmail) {
		scrollIntoView(alternateEmailField);
		writeText(alternateEmailField, alternateEmail);
	}

	public void enterSendCopyToEmail(String sendCopyToEmail) {
		writeText(sendCopyToField, sendCopyToEmail);
		clickElement(plusIcon);		
	}

	public void selectEmailReminderFrequency(String reminderFrequency) {
		WebElement element = driver.findElement(By.xpath("//div[text()='"+reminderFrequency+"']"));
		clickElement(element);
	}

	public NotificationPage fillReminderForm(String radioButtonChoice, String noticePeriodValue, String noticePeriodDuration, 
			String reminderStartDate, String reminderEndDate, String reminderType, String userName, String alternateEmail,
			String sendCopyToEmail, String reminderFrequency) {
		selectRadioButton(radioButtonChoice);
		enterNoticePeriod(noticePeriodValue);
		selectNoticePeriodDuration(noticePeriodDuration);
		enterReminderStartDate(reminderStartDate);
		enterReminderEndDate(reminderEndDate);
		selectReminderType(reminderType);
		selectUser(userName);
		enterAlternateEmail(alternateEmail);
		enterSendCopyToEmail(sendCopyToEmail);
		selectEmailReminderFrequency(reminderFrequency);
		return this;
	}

	public NotificationPage clickOnEditIcon(String eventName) {
		WebElement element = driver.findElement(By.xpath("(//span[contains(@title,'"+eventName+"')]//following::i[contains(@class,'pencil')])[1]"));
		clickElement(element);
		return this ;
	}

	public NotificationPage clickOnDeleteIcon(String eventName) {
		WebElement element = driver.findElement(By.xpath("(//span[contains(@title,'"+eventName+"')]//following::i[contains(@class,'trash')])[1]"));
		clickElement(element);
		return this ;
	}

	public NotificationPage clickOnConfirmationPopUpYesButton() {
		clickElement(confirmationPopUpYesButton);
		return this;
	}

}
