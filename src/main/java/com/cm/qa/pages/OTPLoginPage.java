package com.cm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.cm.qa.utills.Outlook;
import com.cm.qa.utills.Utills;

import cm.cm.qa.base.TestBase;

public class OTPLoginPage extends TestBase {
	
	Utills utills; 
	Outlook outlook ;
	
	@FindBy(xpath = "//span[@class='mat-button-wrapper' and contains(text(),'Submit')]")
	WebElement submitButton ;
	
	public OTPLoginPage () {
		PageFactory.initElements(driver,  this);
	}
	
	public void clickSubmitButton() {
		customVisibleWait(submitButton);
		submitButton.click();
	}
	
	public DashboardPage OTPLogin(String uName, String pwd) {
		utills = new Utills() ;
		outlook = new Outlook() ;
		outlook.goToOutlookHomepage();
		String mainWidow = driver.getWindowHandle() ;
		utills.swichToNewTab();
		String OTP = outlook.readOTP(uName, pwd);
		driver.switchTo().window(mainWidow) ;		
		for(int i = 0 ; i < OTP.length() ; i++) {
			String digit = String.valueOf(OTP.charAt(i)) ;
			WebElement element = driver.findElement(By.xpath("//input[@formcontrolname='digitFormControlName"+(i+1)+"']"));
			element.sendKeys(digit);
		}
		clickSubmitButton();
		return new DashboardPage() ;
	}
	
	public void enterWrongOTP() {
		for(int i = 0 ; i < 6 ; i++) {
			WebElement element = driver.findElement(By.xpath("//input[@formcontrolname='digitFormControlName"+(i+1)+"']"));
			customVisibleWait(element);
			element.sendKeys("0");
		}
	}
	

}
