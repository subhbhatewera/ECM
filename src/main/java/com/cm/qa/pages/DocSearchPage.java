package com.cm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import cm.cm.qa.base.ActionClass;

public class DocSearchPage extends ActionClass {

	//Page Factory - OR
	@FindBy(xpath = "(//div[@class='heading' and contains(text(),'Doc Search')])[2]")
	WebElement docSearchPageHeading ;

	public DocSearchPage () {
		PageFactory.initElements(driver, this);
	}

	public String verifyDocSearchPageHeading() {
		customClickableWait(docSearchPageHeading) ;
		return docSearchPageHeading.getText() ;
	}

}
