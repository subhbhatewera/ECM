package com.cm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import cm.cm.qa.base.TestBase;

public class ContractListPage extends TestBase{

	//Page Factory - OR	
	@FindBy(xpath = "//div[@class='heading' and contains(text(),'Contract List')]")
	WebElement contractListPageHeading ;

	@FindBy(xpath = "//button[@class='cm-btn']")
	WebElement addContractButton ;
	
	@FindBy(xpath = "//input[@placeholder='Search']")
	WebElement globalSearchField ;

	public ContractListPage() {
		PageFactory.initElements(driver, this) ;
	}

	public String verifyContractListPageHeading() {
		customVisibleWait(contractListPageHeading);
		return contractListPageHeading.getText() ;
	}

	public GeneralInformationPage clickOnAddContractButton() {
		customClickableWait(addContractButton) ;
		addContractButton.click() ;
		return new GeneralInformationPage() ;
	}
	
	public ContractListPage serachContract(String contractTitle) {
		writeText(globalSearchField, contractTitle);
		return this;
	}
	
	public GeneralInformationPage clickOnEditContractIcon(String contractTitle) {
		serachContract(contractTitle);
		WebElement element = driver.findElement(By.xpath("(//span[contains(@title,'"+contractTitle+"')]//following::i[contains(@class,'pencil')])[1]"));
		customClickableWait(element) ;
		element.click() ;
		return new GeneralInformationPage() ;
	}

}
