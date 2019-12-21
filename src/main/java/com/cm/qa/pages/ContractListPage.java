package com.cm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import cm.cm.qa.base.ActionClass;

public class ContractListPage extends ActionClass{

	//Page Factory - OR	
	@FindBy(xpath = "(//*[text()='Contract List'])[2]")
	WebElement contractListPageHeading ;

	@FindBy(xpath = "(//button[text()=' Add Contract '])[2]")
	WebElement addContractButton ;
	
	@FindBy(xpath = "(//input[@placeholder='Search'])[2]")
	WebElement globalSearchField ;

	public ContractListPage() {
		PageFactory.initElements(driver, this) ;
	//	PageFactory.initElements(new AjaxElementLocatorFactory(driver, 15), this);
	}

	public String verifyContractListPageHeading() {
		customClickableWait(contractListPageHeading);
		return contractListPageHeading.getText() ;
	}

	public GeneralInformationPage clickOnAddContractButton() {
		//customClickableWait(addContractButton) ;
		addContractButton.click() ;
		return new GeneralInformationPage() ;
	}
	
	public ContractListPage serachContract(String contractTitle) {
		writeText(globalSearchField, contractTitle);
		return this;
	}
	
	public GeneralInformationPage clickOnEditContractIcon(String contractTitle) {
		serachContract(contractTitle);
		WebElement element = driver.findElement(By.xpath("(//i[contains(@mattooltip,'Edit')])[1]"));
		sleep(2000);
		clickElement(element);
		return new GeneralInformationPage() ;
	}

}
