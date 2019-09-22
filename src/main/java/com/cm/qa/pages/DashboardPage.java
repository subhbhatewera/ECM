package com.cm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import cm.cm.qa.base.TestBase;

public class DashboardPage extends TestBase{

	//Page Factory - OR	
	@FindBy(xpath = "//div[@class='heading' and contains(text(),'Dashboard')]")
	public WebElement dashboardHeading ;

	@FindBy(xpath = "//a[@ng-reflect-message='Dashboard']")
	WebElement dashboardLink ;
	
	@FindBy(xpath = "//button[contains(@class,'mat-icon')]")
	WebElement toggleIcon ;
	
	@FindBy(xpath = "(//div[contains(@class,'mat-list')])[4]")
	WebElement contractsLink ;

	@FindBy(xpath = "//a[@ng-reflect-router-link='contract-list']")
	WebElement contractsListLink ;

	@FindBy(xpath = "//a[@ng-reflect-router-link='doc-search']")
	WebElement docSearchLink ;

	@FindBy(xpath = "//a[@ng-reflect-message='Notification']")
	WebElement notificationLink ;

	@FindBy(xpath = "//div[contains(@class,'logged-user')]")
	WebElement userNavigationMenu ;

	@FindBy(xpath = "//a[contains(text(),'Profile')]")
	WebElement profileLink ;

	@FindBy(xpath = "//a[contains(text(),'Change Password')]")
	WebElement changePasswordLink ;

	@FindBy(xpath = "//a[contains(text(),'Logout')]")
	WebElement logOutLink ;

	public DashboardPage() {
		PageFactory.initElements(driver, this);
	}

	public String verifyDashboardPageHeading() {
		customVisibleWait(dashboardHeading) ;
		return dashboardHeading.getText() ;
	}

	public ContractListPage clickOnContractListLink() {
		customVisibleWait(toggleIcon) ;
		clickElement(toggleIcon);
		clickElement(contractsLink);
		clickElement(contractsListLink);
		return new ContractListPage() ;
	}
	
	public ContractListPage gotoContractListPage() {
		clickOnContractListLink() ;
		return new ContractListPage() ;
	}

	public DocSearchPage clickOnDosSearchLink() {
		customVisibleWait(docSearchLink) ;
		docSearchLink.click() ;
		return new DocSearchPage() ;
	}
	
	public DocSearchPage gotoDocSearchPage() {
		clickOnDosSearchLink() ;
		return new DocSearchPage() ;
	}

	public NotificationPage gotoNotificationPage() {
		customVisibleWait(notificationLink) ;
		notificationLink.click() ;
		return new NotificationPage() ;
	}

	public void openUserNavigationMenu() {
		customVisibleWait(userNavigationMenu);
		userNavigationMenu.click();
	}

	public ProfilePage gotoProfilePage() {
		openUserNavigationMenu();
		profileLink.click() ;
		return new ProfilePage() ;
	}

	public ChangePasswordPage clickOnChangePasswordLink() {
		openUserNavigationMenu();
		changePasswordLink.click() ;
		return new ChangePasswordPage() ;
	}

	public UsernamePage clickOnLogOutLink() {
		openUserNavigationMenu();
		logOutLink.click() ;
		return new UsernamePage() ;
	}

}
