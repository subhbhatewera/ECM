package com.cm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import cm.cm.qa.base.ActionClass;

public class ProfilePage extends ActionClass{

	//PageFactory - OR

	@FindBy(xpath = "//label[@class='camera-icon']")
	WebElement cameraIcon ;

	@FindBy(xpath = "//button[@id='editButton']")
	WebElement editButton ;

	@FindBy(xpath = "//input[@placeholder='First Name']")
	public WebElement firstNameField ;

	@FindBy(xpath = "//input[@placeholder='Last Name']")
	public WebElement lastNameField ;

	@FindBy(css = "[id='updateButton']")
	WebElement updateButton ;
	
	@FindBy(css = "[id='cancel']")
	WebElement cancelButton ;

	public ProfilePage() {
		PageFactory.initElements(driver, this);
	}

	public ProfilePage changeProfilePicture() {
		clickElement(cameraIcon);
		System.out.println(projectpath+"\\src\\main\\java\\resources\\profilepicture.jpg");
		uploadFile(projectpath+"\\src\\main\\java\\resources\\profilepicture.jpg");
		return this ;
	}

	public ProfilePage clickOnEditButton() {
		clickElementUsingJS(editButton);
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
	
	public ProfilePage clickOnCancelButton() {
		clickElementUsingJS(cancelButton);
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
