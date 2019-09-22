package com.cm.qa.utills;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import cm.cm.qa.base.TestBase;

public class Outlook extends TestBase{
	
	JavascriptExecutor js ;

	// Page Factory - OR	
	@FindBy(id = "username")
	WebElement outlookUserNameField ;

	@FindBy(id = "password")
	WebElement outlookPasswordField ;

	@FindBy(xpath = "//div[@class='signinbutton']")
	WebElement outlookSignInButton ;

	@FindBy(xpath = "//span[@title='CM App']")
	WebElement cmAppFolder ;

	@FindBy(xpath = "(//span[contains(text(),'Login with OTP')])[1]")
	WebElement otpEmailLink ;

	@FindBy(xpath = "(//span[contains(text(),'Forgot Password')])[1]")
	WebElement forgotPasswordEmailLink ;

	@FindBy(xpath = "//div//p[contains(text(),'Hi')]")
	WebElement otpEmailBodyLink ;

	@FindBy(xpath = "//div//p[contains(text(),'Your')]")
	WebElement passwordEmailBodyLink ;

	public Outlook () {
		PageFactory.initElements(driver,  this);
	}
	
	public void goToOutlookHomepage() {
		js = (JavascriptExecutor)driver ;
		js.executeScript("window.open('https://mail.exelaonline.com/owa')") ;
	}

	public String readOTP(String uName, String pwd) {
		// Login to Outlook 
		outlookUserNameField.sendKeys(uName);
		outlookPasswordField.sendKeys(pwd);
		outlookSignInButton.click();

		//Open the OTP Email
		cmAppFolder.click();
		customClickableWait(otpEmailLink);
		otpEmailLink.click();

		//Fetch OTP from the Email
		customVisibleWait(otpEmailBodyLink);
		String OTP = otpEmailBodyLink.getText().replaceAll("[^0-9]", "") ;
		return OTP ;
	}


}
