package com.cm.qa.utills;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import cm.cm.qa.base.ActionClass;

public class Yopmail extends ActionClass{
	
	@FindBy(id = "login")
	WebElement emailField ;
	
	@FindBy(xpath = "//input[@value='Check Inbox']")
	WebElement checkInboxButton ;
	
	@FindBy(xpath = "(//span[contains(text(),'Login with OTP')])[1]")
	WebElement mailLink ;
	
	@FindBy(xpath = "//div//p[contains(text(),'Hi')]")
	WebElement otpEmailBodyLink ;
	
	public Yopmail() {
		PageFactory.initElements(driver, this);
	}
	
	public void openBrowser() {
		initializeBrowser();
	}
	
	public void login() {		
		emailField.sendKeys("automation.client.user@yopmail.com");
		checkInboxButton.click();
		sleep(3000);
		driver.switchTo().frame("ifinbox");
		mailLink.click();
		driver.switchTo().defaultContent();
		sleep(5000);
		driver.switchTo().frame("ifmail");
		otpEmailBodyLink.click();
		String OTP = otpEmailBodyLink.getText().replaceAll("[^0-9]", "") ;
		System.out.println(OTP);
		driver.close();
	}	
	
	public static void main(String[] args) {
		new Yopmail().openBrowser();
		new Yopmail().login();
	}

}
