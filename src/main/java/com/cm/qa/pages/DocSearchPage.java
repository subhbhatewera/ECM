package com.cm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import cm.cm.qa.base.TestBase;

public class DocSearchPage extends TestBase {

	//Page Factory - OR
	@FindBy(xpath = "//div[@class='heading' and contains(text(),'Doc Search')]")
	WebElement docSearchPageHeading ;

	public DocSearchPage () {
		PageFactory.initElements(driver, this);
	}

	public String verifyDocSearchPageHeading() {
		customVisibleWait(docSearchPageHeading) ;
		return docSearchPageHeading.getText() ;
	}

}
