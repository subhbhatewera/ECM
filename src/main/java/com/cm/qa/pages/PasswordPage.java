package com.cm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import cm.cm.qa.base.TestBase;

public class PasswordPage extends TestBase{

	// Page Factory - OR
	@FindBy(xpath = "//img[@title='Logo']")
	WebElement logoImage ;	

	@FindBy(xpath = "//*[@id='userIconAndName']")
	WebElement userNameLabel ; 

	@FindBy(id = "inputPassword")
	WebElement passwordField ;

	@FindBy(xpath = "//span[contains(text(),'Login')]")
	WebElement loginButton ;

	@FindBy(xpath = "//p[contains(text(),'OTP LOGIN')]")
	WebElement otpLoginLink ;

	@FindBy(xpath = "//p[contains(text(),'FORGOT PASSWORD')]")
	WebElement forgotPasswordLink ;
	
	@FindBy(xpath = "//p[@class='ng-tns-c2-0']")
	WebElement footerText ;	

	// Initializing of page objects
	public PasswordPage() {
		PageFactory.initElements(driver, this);
	}

	//Actions
	public boolean validateCMImage() {
		return logoImage.isDisplayed() ;
	}

	public String validateUsernameLabel() {
		customVisibleWait(userNameLabel);
		return userNameLabel.getText() ;
	}
	
	public void enterPassword(String pwd) {
		passwordField.sendKeys(pwd);
	}
	
	public void clickLoginButton() {
		loginButton.click();
	}
	
	public OTPLoginPage clickOTPLoginLink() {
		customClickableWait(otpLoginLink);
		otpLoginLink.click() ;
		return new OTPLoginPage() ;
	}
	
	public void clickForgotPasswordLink() {
		forgotPasswordLink.click();
	}
	
	public DashboardPage login(String pwd) {
		enterPassword(pwd) ;
		clickLoginButton() ;
		return new DashboardPage() ;
	}
	
	public String getFooterText() {
		customVisibleWait(footerText);
		return footerText.getText() ;
	}

}
