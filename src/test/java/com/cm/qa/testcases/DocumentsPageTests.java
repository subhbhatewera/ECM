package com.cm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import com.cm.qa.pages.DocumentsPage;
import com.cm.qa.pages.UsernamePage;
import com.cm.qa.utills.DataProviderClass;
import com.cm.qa.utills.Utills;

import cm.cm.qa.base.ActionClass;


public class DocumentsPageTests extends ActionClass{	

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
		sleep(5000);
	}
	
	@BeforeMethod
	public void openDocumentsForm() {
		contractList = dashboard.gotoContractListPage() ;		
	}

	@Test(priority = 100, dataProvider = "DocumentsData", dataProviderClass = DataProviderClass.class)
	public void addDocument(String contractTitle, String docTitle, String contractType, String uploadDate, String signedDate, 
			String status, String imagePath ) {
		contractList.clickOnEditContractIcon(contractTitle);
		document.clickOnDocumentsTab()
		.clickOnAddDocumentButton()
		.fillDocumentForm(docTitle, contractType, uploadDate, signedDate, status, imagePath) 
		.clickOnSaveButton();
		Assert.assertEquals(utills.readSuccessMessage(), "Document successfully added\n"+"Operation Complete");
		document.clickOnSubmitButton();
		Assert.assertEquals(utills.readSuccessMessage(), "Contract successfully updated\n"+"Operation Complete");
	}

	@AfterClass
	public void tearDown() {
		driver.close();
	}

}
