
package com.crm.qa.loginPage;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.crm.qa.base.TestBase;
import com.crm.qa.datadriven.DataProviderPage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.CSLogger;

public class LoginPageTest extends TestBase {

    private LoginPage loginPage;

    @BeforeMethod
    public void initializeResource() {
        loginPage = new LoginPage();
    }

    /*
     * @Test public void loginPageTitle() { String title =
     * loginpage.validateLoginPageTitle(); Assert.assertEquals(title,
     * "CRMPRO - CRM software for customer relationship management, sales, and support."
     * ); }
     */
    /*
     * @Test public void crmLogoImageTest(){ boolean flag =
     * loginpage.validateCRMImage(); Assert.assertTrue(flag); }
     */
@Test(priority=1)
    public void verifyElementPresent() {
        browserDriver.get(config.getUrl());
        browserDriver.navigate().refresh();
        int elementCount = 0;
        elementCount += (loginPage.getHomeLink() == null ? 0 : 1);
        elementCount += (loginPage.getSignUpLink() == null ? 0 : 1);
        elementCount += (loginPage.getPricing() == null ? 0 : 1);
        elementCount += (loginPage.getFeaturesLink() == null ? 0 : 1);
        elementCount += (loginPage.getCustomersLink() == null ? 0 : 1);
        elementCount += (loginPage.getContactsLink() == null ? 0 : 1);
        elementCount += (loginPage.getBtnLoginButton() == null ? 0 : 1);
        if (elementCount != 7) {
            Assert.fail("Elements are not present...!");
            CSLogger.error("Login elements are not present.");
        }
        CSLogger.info("Login elements are present.");
    }

    @Test(
            dependsOnMethods = { "verifyElementPresent" },
            dataProvider = "CredentailsTestData",
            dataProviderClass = DataProviderPage.class)
    private void testLogin(String username, String password) throws InterruptedException {
        loginPage.getTxtUsername().sendKeys(username);
        loginPage.getTxtPassword().sendKeys(password);
        loginPage.clkSubmitButton();
        CSLogger.info("Clicked on Login Button");
    }

/*    @AfterMethod
    public void tearDown() {
        browserDriver.quit()
    };*/
}
