package com.crm.qa.datadriven;

import org.testng.annotations.DataProvider;

import com.crm.qa.base.TestBase;

public class DataProviderPage extends TestBase {
	
	private String LoginSheetName				 = "Logintest";
	private String contactsDetailsSheetName                           = "NewContactsDetailstest";
	private String deleteContactsSheetName                 = "DeleteContacts";
	
	@DataProvider(name = "CredentailsTestData")
	public Object[][] getCredentailsTestData() {
		return DataDrivenScript.readSheetData(config.getExcelSheetPath("loginTestCases"), LoginSheetName);
	}
	
	@DataProvider(name = "NewContactsDetailsTestData")
        public Object[][] getNewContactsDetailsTestData() {
                return DataDrivenScript.readSheetData(config.getExcelSheetPath("contactsTestCases"), contactsDetailsSheetName);
        }
	
	@DataProvider(name="DeleteContactsDetailsTestData")
	public Object[][] getDeleteContactsDetailsTestData() {
	    return DataDrivenScript.readSheetData(config.getExcelSheetPath("contactsTestCases"), deleteContactsSheetName);
	}
}
