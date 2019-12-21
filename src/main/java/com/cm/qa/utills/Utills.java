package com.cm.qa.utills;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import cm.cm.qa.base.ActionClass;

public class Utills extends ActionClass{

	@FindBy(xpath = "//div[contains(@class,'toast-success')]")
	WebElement successToaster ; 

	@FindBy(xpath = "//div[contains(@class,'toast-error')]")
	WebElement errorToaster ; 

	@FindBy(xpath = "//div[contains(@class,'toast-info')]")
	WebElement infoToaster ; 

	@FindBy(xpath = "//mat-error[contains(@class,'mat-error')]")
	WebElement fieldError ; 

	public Utills() {
		PageFactory.initElements(driver, this);
	}

	public String readSuccessMessage() {
		customVisibleWait(successToaster) ;
		String successMessage = successToaster.getText() ;
		clickElement(successToaster);
		return successMessage ;
	}	

	public String readErrorMessage() {
		customVisibleWait(errorToaster) ;
		String errorMessage = errorToaster.getText() ;
		clickElement(errorToaster);
		return errorMessage ;
	}

	public String readInfoMessage() {
		customVisibleWait(infoToaster) ;
		String infoMessage = infoToaster.getText() ;
		clickElement(errorToaster);
		return infoMessage ;
	}

	public String readFieldErrorMessage() {
		customVisibleWait(fieldError) ;
		scrollIntoView(fieldError);
		String errorMessage = fieldError.getText() ;
		return errorMessage ;
	}

	public void swichToNewTab() {
		String mainWondow = driver.getWindowHandle() ;
		Set<String> set = driver.getWindowHandles() ;
		Iterator<String> itr = set.iterator() ;
		while(itr.hasNext()) {
			String childWindow = itr.next() ;
			if(!mainWondow.equals(childWindow)) {
				driver.switchTo().window(childWindow) ;
			}
		}
	}
}
