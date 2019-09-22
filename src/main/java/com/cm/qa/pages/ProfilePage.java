package com.cm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import cm.cm.qa.base.TestBase;

public class ProfilePage extends TestBase{

	//PageFactory - OR

	@FindBy(xpath = "//label[@class='camera-icon']")
	WebElement cameraIcon ;

	@FindBy(xpath = "//button[text()='Edit']")
	WebElement editButton ;

	@FindBy(xpath = "//input[@placeholder='First Name']")
	WebElement firstNameField ;

	@FindBy(xpath = "//input[@placeholder='Last Name']")
	WebElement lastNameField ;

	@FindBy(xpath = "//button[text()='Update']")
	WebElement updateButton ;

	public ProfilePage() {
		PageFactory.initElements(driver, this);
	}

	public ProfilePage changeProfilePicture(String imagePath) {
		clickElement(cameraIcon);
		uploadFile(imagePath);
		return this ;
	}

	public ProfilePage clickOnEditButton() {
		clickElement(editButton);
		return this;
	}

	public ProfilePage enterFirstName(String firstName) {
		writeText(firstNameField, firstName);
		return this;
	}

	public ProfilePage enterLastName(String lastName) {
		writeText(lastNameField, lastName);
		return this;
	}

	public ProfilePage clickOnUpdateButton() {
		clickElement(updateButton);
		return this;
	}
	
	public ProfilePage updateUserName(String firstName, String lastName) {
		enterFirstName(firstName);
		enterLastName(lastName);
		clickOnUpdateButton();
		return this;	
	}

	public String getUserName(String userName) {
		WebElement element = driver.findElement(By.xpath("//span[text()='"+userName+"']"));
		return element.getText();
	}

}
