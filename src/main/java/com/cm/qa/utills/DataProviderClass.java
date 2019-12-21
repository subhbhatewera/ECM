package com.cm.qa.utills;

import org.testng.annotations.DataProvider;

import cm.cm.qa.base.TestBase;

public class DataProviderClass extends TestBase{

	String projectPath = System.getProperty("user.dir");

	@DataProvider(name="category")
	public Object[][] getCategories() {
		Object data[][] = readDataFromFile(projectPath+"/src/main/java/com/cm/qa/testdata/ECMTestData - General Information.xlsx", "Category");
		return data ;
	}

	@DataProvider(name="subCategory")
	public Object[][] getSubCategories() {
		Object data[][] = readDataFromFile(projectPath+"/src/main/java/com/cm/qa/testdata/ECMTestData - General Information.xlsx", "SubCategory");
		return data ;
	}

	@DataProvider(name="businessPartner")
	public Object[][] getBusinessPartners() {
		Object data[][] = readDataFromFile(projectPath+"/src/main/java/com/cm/qa/testdata/ECMTestData - General Information.xlsx", "BusinessPartner");
		return data ;
	}

	@DataProvider(name="legalEntity")
	public Object[][] getLegalEntities() {
		Object data[][] = readDataFromFile(projectPath+"/src/main/java/com/cm/qa/testdata/ECMTestData - General Information.xlsx", "Legal Entity");
		return data ;
	}

	@DataProvider(name="generalInformation")
	public Object[][] getGeneralInformationData() {
		Object data[][] = readDataFromFile(projectPath+"/src/main/java/com/cm/qa/testdata/ECMTestData - General Information.xlsx", "GeneralInformation");
		return data ;
	}

	@DataProvider(name="termData")
	public Object[][] getTermData() {
		Object data[][] = readDataFromFile(projectPath+"/src/main/java/com/cm/qa/testdata/ECMTestData - Term.xlsx", "Term");
		return data ;
	}

	@DataProvider(name="generalTerms")
	public Object[][] getGeneralTermsData() {
		Object data[][] = readDataFromFile(projectPath+"/src/main/java/com/cm/qa/testdata/ECMTestData - Commercials.xlsx", "GeneralTerms");
		return data ;
	}

	@DataProvider(name="uom")
	public Object[][] getUOM() {
		Object data[][] = readDataFromFile(projectPath+"/src/main/java/com/cm/qa/testdata/ECMTestData - Commercials.xlsx", "UOM");
		return data ;
	}

	@DataProvider(name="linkedOpportunity")
	public Object[][] getLinkedOpportunity() {
		Object data[][] = readDataFromFile(projectPath+"/src/main/java/com/cm/qa/testdata/ECMTestData - Commercials.xlsx", "LinkedOpportunity");
		return data ;
	}

	@DataProvider(name="service")
	public Object[][] getService() {
		Object data[][] = readDataFromFile(projectPath+"/src/main/java/com/cm/qa/testdata/ECMTestData - Commercials.xlsx", "Service");
		return data ;
	}

	@DataProvider(name="subService")
	public Object[][] getSubService() {
		Object data[][] = readDataFromFile(projectPath+"/src/main/java/com/cm/qa/testdata/ECMTestData - Commercials.xlsx", "SubService");
		return data ;
	}

	@DataProvider(name="project")
	public Object[][] getProject() {
		Object data[][] = readDataFromFile(projectPath+"/src/main/java/com/cm/qa/testdata/ECMTestData - Commercials.xlsx", "Project");
		return data ;
	}

	@DataProvider(name="transactionRateStandard")
	public Object[][] getTransactionRateStandardData() {
		Object data[][] = readDataFromFile(projectPath+"/src/main/java/com/cm/qa/testdata/ECMTestData - Commercials.xlsx", "TransactionRateStandard");
		return data ;
	}

	@DataProvider(name="transactionRateVolume")
	public Object[][] getTransactionRateVolumeData() {
		Object data[][] = readDataFromFile(projectPath+"/src/main/java/com/cm/qa/testdata/ECMTestData - Commercials.xlsx", "TransactionRateVolume");
		return data ;
	}

	@DataProvider(name="timeAndMaterialModel")
	public Object[][] getTimeAndMaterialModelData() {
		Object data[][] = readDataFromFile(projectPath+"/src/main/java/com/cm/qa/testdata/ECMTestData - Commercials.xlsx", "TimeAndMaterialModel");
		return data ;
	}

	@DataProvider(name="fixedFee")
	public Object[][] getFixedFeeData() {
		Object data[][] = readDataFromFile(projectPath+"/src/main/java/com/cm/qa/testdata/ECMTestData - Commercials.xlsx", "FixedFee");
		return data ;
	}

	@DataProvider(name="minimumBilling")
	public Object[][] getMinimumBillingData() {
		Object data[][] = readDataFromFile(projectPath+"/src/main/java/com/cm/qa/testdata/ECMTestData - Commercials.xlsx", "MinimumBilling");
		return data ;
	}

	@DataProvider(name="editCommercials")
	public Object[][] getContractTitle() {
		Object data[][] = readDataFromFile(projectPath+"/src/main/java/com/cm/qa/testdata/ECMTestData - Commercials.xlsx", "ContractTitle");
		return data ;
	}

	@DataProvider(name="cola")
	public Object[][] getCOLAData() {
		Object data[][] = readDataFromFile(projectPath+"/src/main/java/com/cm/qa/testdata/ECMTestData - Other Commercials.xlsx", "COLA");
		return data ;
	}

	@DataProvider(name="incentive")
	public Object[][] getIncentiveData() {
		Object data[][] = readDataFromFile(projectPath+"/src/main/java/com/cm/qa/testdata/ECMTestData - Other Commercials.xlsx", "Incentive");
		return data ;
	}

	@DataProvider(name="penalty")
	public Object[][] getPenaltyData() {
		Object data[][] = readDataFromFile(projectPath+"/src/main/java/com/cm/qa/testdata/ECMTestData - Other Commercials.xlsx", "Penalty");
		return data ;
	}

	@DataProvider(name="earlyPaymentDiscount")
	public Object[][] getEarlyPaymentDiscountData() {
		Object data[][] = readDataFromFile(projectPath+"/src/main/java/com/cm/qa/testdata/ECMTestData - Other Commercials.xlsx", "EarlyPaymentDiscount");
		return data ;
	}

	@DataProvider(name="latePaymentFee")
	public Object[][] getLatePaymentFeeData() {
		Object data[][] = readDataFromFile(projectPath+"/src/main/java/com/cm/qa/testdata/ECMTestData - Other Commercials.xlsx", "LatePaymentFee");
		return data ;
	}

	@DataProvider(name="termination")
	public Object[][] getTerminationData() {
		Object data[][] = readDataFromFile(projectPath+"/src/main/java/com/cm/qa/testdata/ECMTestData - Other Commercials.xlsx", "Termination");
		return data ;
	}

	@DataProvider(name="limitationofLiability")
	public Object[][] getLimitationofLiabilityData() {
		Object data[][] = readDataFromFile(projectPath+"/src/main/java/com/cm/qa/testdata/ECMTestData - Other Commercials.xlsx", "LimitationofLiability");
		return data ;
	}

	@DataProvider(name="tat")
	public Object[][] getTATData() {
		Object data[][] = readDataFromFile(projectPath+"/src/main/java/com/cm/qa/testdata/ECMTestData - SLA.xlsx", "TAT");
		return data ;
	}

	@DataProvider(name="quality")
	public Object[][] getQualityData() {
		Object data[][] = readDataFromFile(projectPath+"/src/main/java/com/cm/qa/testdata/ECMTestData - SLA.xlsx", "Quality");
		return data ;
	}

	@DataProvider(name="upTime")
	public Object[][] getUptimeData() {
		Object data[][] = readDataFromFile(projectPath+"/src/main/java/com/cm/qa/testdata/ECMTestData - SLA.xlsx", "Uptime");
		return data ;
	}

	@DataProvider(name="addContactPerson")
	public Object[][] getAddContactPersonData() {
		Object data[][] = readDataFromFile(projectPath+"/src/main/java/com/cm/qa/testdata/ECMTestData - Contact Persons.xlsx", "AddContactPersons");
		return data ;
	}

	@DataProvider(name="editContactPerson")
	public Object[][] getEditContactPersonData() {
		Object data[][] = readDataFromFile(projectPath+"/src/main/java/com/cm/qa/testdata/ECMTestData - Contact Persons.xlsx", "EditContactPersons");
		return data ;
	}

	@DataProvider(name="contractTitleContactPerson")
	public Object[][] getContractTitleForContactPersons() {
		Object data[][] = readDataFromFile(projectPath+"/src/main/java/com/cm/qa/testdata/ECMTestData - Contact Persons.xlsx", "ContractTitle");
		return data ;
	}

	@DataProvider(name="contactPersonInvalidData")
	public Object[][] getContactPersonInvalidData() {
		Object data[][] = readDataFromFile(projectPath+"/src/main/java/com/cm/qa/testdata/ECMTestData - Contact Persons.xlsx", "InvalidData");
		return data ;
	}

	@DataProvider(name="function")
	public Object[][] getFunction() {
		Object data[][] = readDataFromFile(projectPath+"/src/main/java/com/cm/qa/testdata/ECMTestData - Contact Persons.xlsx", "Function");
		return data ;
	}

	@DataProvider(name="userName")
	public Object[][] getUserName() {
		Object data[][] = readDataFromFile(projectPath+"/src/main/java/com/cm/qa/testdata/ECMTestData - Profile.xlsx", "Username");
		return data ;
	}

	@DataProvider(name="invalidName")
	public Object[][] getInvalidName() {
		Object data[][] = readDataFromFile(projectPath+"/src/main/java/com/cm/qa/testdata/ECMTestData - Profile.xlsx", "InvalidName");
		return data ;
	}

	@DataProvider(name="addNotification")
	public Object[][] getAddNotificationData() {
		Object data[][] = readDataFromFile(projectPath+"/src/main/java/com/cm/qa/testdata/ECMTestData - Notification.xlsx", "AddNotification");
		return data ;
	}
	
	@DataProvider(name="editNotification")
	public Object[][] getEditNotificationData() {
		Object data[][] = readDataFromFile(projectPath+"/src/main/java/com/cm/qa/testdata/ECMTestData - Notification.xlsx", "EditNotification");
		return data ;
	}
	
	@DataProvider(name="deleteNotification")
	public Object[][] getDeleteNotificationData() {
		Object data[][] = readDataFromFile(projectPath+"/src/main/java/com/cm/qa/testdata/ECMTestData - Notification.xlsx", "DeleteNotification");
		return data ;
	}

	@DataProvider(name="DocumentsData")
	public Object[][] getDocumentsTabData() {
		Object data[][] = readDataFromFile(projectPath+"/src/main/java/com/cm/qa/testdata/ECMTestData - Documents.xlsx", "Document");
		return data ;
	}

	@DataProvider(name="contractTitleData")
	public Object[][] getContractTitle1() {
		Object data[][] = readDataFromFile(projectPath+"/src/main/java/com/cm/qa/testdata/ECMTestData.xlsx", "ContractTitle");
		return data ;
	}

	public Object[][] readDataFromFile(String filePath, String sheetName){

		ExcelReader read = new ExcelReader(filePath, sheetName) ;

		int rowCount = read.rowCount() ;
		int columnCount  = read.columnCount();

		Object data[][] = new Object[rowCount-1][columnCount] ;	

		for(int i = 1 ; i < rowCount ; i++) {
			for(int j=0 ; j < columnCount ; j++) {
				data[i-1][j] = read.getCellData(i, j);
			}
		}
		return data ;
	}
}
