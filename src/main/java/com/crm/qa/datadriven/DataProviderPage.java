package com.crm.qa.datadriven;

import org.testng.annotations.DataProvider;

import com.crm.qa.base.TestBase;

public class DataProviderPage extends TestBase {
	
	private String LoginSheetName				               = "Logintest";
	private String contactsDetailsSheetName                           = "NewContactsDetailstest";
	private String deleteContactsSheetName                            = "DeleteContacts";
	private String createTaskSheetName                                    = "createTask";
	
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
	
	@DataProvider(name="createTaskInCalender")
        public Object[][] getcreateTaskInCalenderTestData() {
            return DataDrivenScript.readSheetData(config.getExcelSheetPath("calendarTestCases"), createTaskSheetName);
        }
	
}
