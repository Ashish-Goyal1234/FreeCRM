package com.crm.qa.datadriven;

import org.testng.annotations.DataProvider;

import com.crm.qa.base.TestBase;

public class DataProviderPage extends TestBase {
	
	private String LoginSheetName				 = "Logintest";
	
	@DataProvider(name = "CredentailsTestData")
	public Object[][] getCredentailsTestData() {
		return DataDrivenScript.readSheetData(config.getExcelSheetPath("loginTestCases"), LoginSheetName);
	}
}
