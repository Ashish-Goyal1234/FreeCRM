package com.crm.qa.test.contactspage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.crm.qa.base.TestBase;
import com.crm.qa.contactspage.ContactsPage;
import com.crm.qa.datadriven.DataProviderPage;
import com.crm.qa.util.CSLogger;

public class DeleteContactsTest extends TestBase{
    ContactsPage contactspage;
    WebDriverWait waitForreload;

    @BeforeMethod
    public void initialization() {
        contactspage = new ContactsPage();
        waitForreload = new WebDriverWait(browserDriver, 60);
    }
    
    
    @Test(dataProvider = "DeleteContactsDetailsTestData", dataProviderClass = DataProviderPage.class)
    public void testDeleteContacts(String companyName) {
        try{
            deleteContacts(false,companyName );
            deleteContacts(true,companyName );
        }catch(Exception e){
            CSLogger.info("Failed to Delete Contacts" + e);
            Assert.fail("Failed to create Contacts"+ e);
        }
    }
    
    private void deleteContacts(boolean value, String companyName) {
        waitForreload.until(ExpectedConditions.elementToBeClickable(contactspage.getContactsPane()));
        contactspage.clkContactsPane();
        contactspage.enterCompanyNameToSearch(companyName);
        contactspage.clkSearchBtnInAdvanceSearch();
        contactspage.checkSelectAllCheckBox();
        contactspage.selectDeletedCheckedOption();
        contactspage.clkDoBtn();
        if(value==true){
            browserDriver.switchTo().alert().accept();
            CSLogger.info("Clicked on Ok Button of alert to delete Record");
            verifyContactsDeleted(companyName);
        }else{
            browserDriver.switchTo().alert().dismiss();
            CSLogger.info("Clicked on Cancel Button of alert to delete record");
        }
    }
    
    
    private void verifyContactsDeleted(String companyName) {
        waitForreload.until(ExpectedConditions.elementToBeClickable(contactspage.getContactsPane()));
        contactspage.clkContactsPane();
        contactspage.enterCompanyNameToSearch(companyName);
        contactspage.clkSearchBtnInAdvanceSearch();
        WebElement name = browserDriver.findElement(By.cssSelector("a[_name*='A_test']"));
        if(name.isDisplayed()) {
            CSLogger.debug("WebElement is not deleted");
            Assert.fail("Webelemnt not deleted");
        }else{
            CSLogger.info("WebElement is deleted successfully");
        }
    }
    
}
