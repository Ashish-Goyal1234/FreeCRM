
package com.crm.qa.homePage;

import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.crm.qa.base.TestBase;
import com.crm.qa.contactspage.ContactsPage;
import com.crm.qa.datadriven.DataProviderPage;
import com.crm.qa.homepage.HomePage;
import com.crm.qa.util.CSLogger;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {

    public HomePage     homePage;
    public ContactsPage contactsPage;
    public TestUtil     testUtil;

    @BeforeMethod
    public void Initialization() {
        homePage = new HomePage();
        contactsPage = new ContactsPage();
        testUtil = new TestUtil();
    }

    @Test(dataProvider = "NewContactsDetailsTestData",dataProviderClass = DataProviderPage.class)
    public void testCreateContacts(String title, String firstName,
            String middleName, String lastName, String nickName,
            String companyName, String position, String departmentName, String SearchSupervisor, String SupervisorName) {
        try {
            Actions action = new Actions(browserDriver);
            action.moveToElement(homePage.getContactsLink()).build().perform();
            contactsPage.clkContactsLink();
            CSLogger.info("Clicked on New Contacts link");
            addContactDetails(title, firstName, middleName, lastName, nickName,
                    companyName, position, departmentName,SearchSupervisor, SupervisorName);
        } catch (Exception e) {
            Assert.fail("Failed to create Contacts" + e);
            CSLogger.debug("Failed to Create Contacts" + e);
        }
    }

    private void addContactDetails(String title, String firstName,
            String middleName, String lastName, String nickName,
            String companyName, String position, String departmentName,String SearchSupervisor, String SupervisorName){
        testUtil.getDropDownValueUsingSelectMethod(contactsPage.getTitle(),
                title);
        contactsPage.enterFirstName(firstName);
        CSLogger.info("Entered first name in contacts page");
        contactsPage.enterMiddleName(middleName);
        CSLogger.info("Entered middle name in contacts page");
        contactsPage.enterLastName(lastName);
        CSLogger.info("Entered last name in contacts page");
        contactsPage.enterNickName(nickName);
        CSLogger.info("Entered Nick name in contacts page");
        contactsPage.clkCompanyLookup();
        selectCompanyFromLookup(companyName);
        contactsPage.enterPositionName(position);
        CSLogger.info("Entered Position in contacts page");
        contactsPage.enterDepartmentName(departmentName);
        CSLogger.info("Entered department in contacts page");
        contactsPage.clickBtnSupervisorLooup();
        selectSupervisorFromLookup(SearchSupervisor, SupervisorName);
    }
    
    private void selectCompanyFromLookup(String CompanyName) {
        Set<String> handler = browserDriver.getWindowHandles(); // Used to get all Window Ids.
        Iterator <String> it = handler.iterator(); // Used to Move to next Window.
        String ParentWindow = it.next();  // Switching to parent window.
        CSLogger.info("Parent Window Id" +ParentWindow );
        String childWindow = it.next();  // Switching to child window.
        CSLogger.info("Child Window Id :" +childWindow );
        browserDriver.switchTo().window(childWindow);
        CSLogger.info("Title of the Company Lookup Window" + browserDriver.getTitle());
        contactsPage.enterSearchElementInLookupSearchBox(CompanyName);
        contactsPage.clkSearchBtnInLookup();
        browserDriver.findElement(By.xpath("//a[contains(text(),'" + CompanyName + "')]")).click();
        browserDriver.switchTo().window(ParentWindow);
        testUtil.switchToFrame();
    }
    
    private void selectSupervisorFromLookup(String SearchSupervisor, String SupervisorName) {
        Set<String> handler = browserDriver.getWindowHandles();
        Iterator<String> it = handler.iterator();
        String parentWindowID = it.next();
        CSLogger.info("Displaying Parent Window id" + parentWindowID);
        String childWindowID = it.next();
        CSLogger.info("Displaying Child Window ID" +childWindowID );
        browserDriver.switchTo().window(childWindowID);   // Switching to child window
        CSLogger.info("Title to the Supervisor Lookup window" + browserDriver.getTitle());
        contactsPage.enterSearchElementInLookupSearchBox(SearchSupervisor);
        contactsPage.clkSearchBtnInLookup();
        browserDriver.findElement(By.xpath("//input[@type='button' and @value='X']")).click();
        browserDriver.switchTo().window(parentWindowID);
        testUtil.switchToFrame();
        
        
    }
}
