package com.cm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.cm.qa.pages.UsernamePage;
import com.cm.qa.utills.DataProviderClass;
import com.cm.qa.utills.Utills;

import cm.cm.qa.base.ActionClass;

public class NotificationPageTests extends ActionClass{

	public NotificationPageTests() {
		super() ;
	}

	@BeforeClass
	public void setUp() {
		initializeBrowser() ;
		uName = new UsernamePage() ;
		utills = new Utills() ;
		pwd = uName.navigateToPasswordPage(prop.getProperty("clientUser")) ;
		dashboard = pwd.login(prop.getProperty("clientUserPassword")) ;	
		sleep(5000);
	}
	
	@BeforeMethod
	public void gotoNotificationPage() {
		notification = dashboard.gotoNotificationPage();
	}

	@Test(priority = 101, dataProvider = "addNotification", dataProviderClass = DataProviderClass.class)
	public void addSimpleNotificationTest(String title, String businesspartner, String type, String date, String linkedContractInformation,
			String description, String reminder, String noticePeriodValue, String noticePeriodDuration, String reminderStartDate,
			String reminderEndDate, String notificationStatus, String users, String alternateEmail, String sendCopyToEmail, 
			String reminderFrequency) {
		notification.clickOnAddButton()
		.fillNotificationForm(title, businesspartner, type, date, linkedContractInformation, description,
				reminder, noticePeriodValue, noticePeriodDuration, reminderStartDate, reminderEndDate, 
				notificationStatus, users, alternateEmail, sendCopyToEmail, reminderFrequency)
		.clickOnSaveButton();
		Assert.assertEquals(utills.readSuccessMessage(), "Notification successfully added\n"+"Operation Complete");
	}

	@Test(priority = 82, enabled = false, dataProvider = "editNotification", dataProviderClass = DataProviderClass.class)
	public void editSimpleNotificationTest(String title, String newTitle, String businesspartner, String type, String date, String linkedContractInformation,
			String description, String reminder, String noticePeriodValue, String noticePeriodDuration, String reminderStartDate,
			String reminderEndDate, String notificationStatus, String users, String alternateEmail, String sendCopyToEmail, 
			String reminderFrequency) {
		notification.clickOnEditIcon(title)
		.fillNotificationForm(newTitle, businesspartner, type, date, linkedContractInformation, description,
				reminder, noticePeriodValue, noticePeriodDuration, reminderStartDate, reminderEndDate, 
				notificationStatus, users, alternateEmail, sendCopyToEmail, reminderFrequency)
		.clickOnSaveButton();
		Assert.assertEquals(utills.readSuccessMessage(), "Notification successfully updated\n"+"Operation Complete");
	}

	@Test(priority = 84, enabled = false, dataProvider = "deleteNotification", dataProviderClass = DataProviderClass.class)
	public void deleteNotificationTest(String title) {
		notification.clickOnDeleteIcon(title)
		.clickOnConfirmationPopUpYesButton();
		Assert.assertEquals(utills.readSuccessMessage(), "Notification successfully deleted!\n"+"Operation Complete");
	}

	@AfterClass
	public void tearDown() {
		driver.close();
	}

}
