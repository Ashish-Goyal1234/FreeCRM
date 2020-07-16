package com.crm.qa.datadriven;

import org.testng.annotations.DataProvider;

import com.crm.qa.base.TestBase;

public class DataProviderPage extends TestBase {
	
	private String LoginSheetName				 = "Logintest";
	private String contactsDetailsSheetName                           = "NewContactsDetailstest";
	
	@DataProvider(name = "CredentailsTestData")
	public Object[][] getCredentailsTestData() {
		return DataDrivenScript.readSheetData(config.getExcelSheetPath("loginTestCases"), LoginSheetName);
	}
	
	@DataProvider(name = "NewContactsDetailsTestData")
        public Object[][] getNewContactsDetailsTestData() {
                return DataDrivenScript.readSheetData(config.getExcelSheetPath("contactsTestCases"), contactsDetailsSheetName);
        }
}
