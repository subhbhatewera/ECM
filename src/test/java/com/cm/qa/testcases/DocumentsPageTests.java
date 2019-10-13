package com.cm.qa.testcases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import com.cm.qa.pages.ContractListPage;
import com.cm.qa.pages.DashboardPage;
import com.cm.qa.pages.DocumentsPage;
import com.cm.qa.pages.PasswordPage;
import com.cm.qa.pages.UsernamePage;
import com.cm.qa.utills.DataProviderClass;
import com.cm.qa.utills.Utills;

import cm.cm.qa.base.TestBase;

public class DocumentsPageTests extends TestBase{

	UsernamePage uName ;
	PasswordPage pwd ;
	Utills utills ;
	DashboardPage dashboard ;
	ContractListPage contractList ;
	DocumentsPage document ;

	public DocumentsPageTests() {
		super() ;
	}

	@BeforeClass
	public void setUp() {
		initializeBrowser() ;
		uName = new UsernamePage() ;
		utills = new Utills() ;
		document = new DocumentsPage();
		pwd = uName.navigateToPasswordPage(prop.getProperty("clientUser")) ;
		dashboard = pwd.login(prop.getProperty("clientUserPassword")) ;		
	}

	@Test(dataProvider = "DocumentsData", dataProviderClass = DataProviderClass.class)
	public void addDocument(String contractTitle, String contractType, String uploadDate, String signedDate, 
			String status, String imagePath ) {
		contractList = dashboard.gotoContractListPage() ;
		contractList.clickOnEditContractIcon(contractTitle);
		document.clickOnDocumentsTab()
		.clickOnAddDocumentButton()
		.fillDocumentForm(contractType, uploadDate, signedDate, status, imagePath) ;
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
