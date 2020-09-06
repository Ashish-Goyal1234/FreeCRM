
package com.crm.qa.loginpage;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.crm.qa.base.TestBase;
import com.crm.qa.datadriven.DataProviderPage;
import com.crm.qa.homepage.HomePage;
import com.crm.qa.login.LoginPage;
import com.crm.qa.util.CSLogger;

public class LoginPageTest extends TestBase {

    private LoginPage loginPage;
    private HomePage homePage;

    @BeforeMethod
    public void initializeResource() {
        loginPage = new LoginPage();
        homePage= new HomePage();
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
    public void verifyElementPresentTest() {
        browserDriver.get(config.getUrl());
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

        @Test(priority=2)
        public void verifyPageTitleOfLoginPageTest() {
            String title = browserDriver.getTitle();
            String Actual_title = "CRMPRO - CRM software for customer relationship management, sales, and support.";
            if(Actual_title.contentEquals(title)){
                CSLogger.info("Vaid Title");
            }else{
                CSLogger.info("Invalid Title");
                Assert.fail("Invalid Title");
            }
        }

    @Test(priority=3,
            dependsOnMethods = { "verifyElementPresentTest" },
            dataProvider = "CredentailsTestData",
            dataProviderClass = DataProviderPage.class)
    private void testLogin(String username, String password) {
        try{
         Thread.sleep(2000);
        waitForReload.until(ExpectedConditions.elementToBeClickable( loginPage.getTxtUsername()));
        loginPage.getTxtUsername().sendKeys(username);
        CSLogger.info("Entered Username");
        waitForReload.until(ExpectedConditions.elementToBeClickable(loginPage.getTxtPassword()));
        loginPage.getTxtPassword().sendKeys(password);
        CSLogger.info("Entered Password");
        loginPage.clkSubmitButton();
        CSLogger.info("Clicked on Submit Button");
        
        /*WebElement homePageButton =homePage.getBtnLogout();
        
        if(homePageButton.isDisplayed()){
            CSLogger.info("User Entered Valid Credential...! : "+ username +password);
        }else{
            CSLogger.info("User Entered Invalid Creadentials :"+ username +password);
        } */
    }
        catch(Exception e){
            CSLogger.debug("Failed to Login");
        }
    }
}
/*    @AfterMethod
    public void tearDown() {
        browserDriver.quit()
    };*/

