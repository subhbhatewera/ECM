package com.cm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import cm.cm.qa.base.ActionClass;

public class UsernamePage extends ActionClass {

	// Page Factory - OR
	@FindBy(xpath = "//img[@title='Logo']")
	WebElement logoImage ;	

	@FindBy(xpath = "//input[@name='username']")
	WebElement userNameField ;

	@FindBy(xpath = "//button[contains(@class,'loginBtn')]")
	WebElement nextButton ;
	
	@FindBy(xpath = "//p[@class='ng-tns-c2-0']")
	WebElement footerText ;	

	// Initializing page objects
	public UsernamePage() {
		PageFactory.initElements(driver, this);
	}

	// Actions
	public boolean validateCMImage() {
		return logoImage.isDisplayed() ;
	}

	public void enterUsername(String userName) {
		userNameField.sendKeys(userName);
	}

	public void clickNextButton() {
		nextButton.click();
	}
	
	public PasswordPage navigateToPasswordPage(String userName) {
		enterUsername(userName) ;
		clickNextButton() ;
		return new PasswordPage() ;
	}
	
	public String getFooterText() {
		customVisibleWait(footerText);
		return footerText.getText() ;
	}

}
