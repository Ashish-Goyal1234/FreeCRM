
package com.crm.qa.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ISuite;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import com.crm.qa.datadriven.DataDrivenScript;
import com.crm.qa.util.ApplicationConfiguration1;
import com.crm.qa.util.CSLogger;

/**
 * This is the abstract class which will act as root class for every test class,
 * providing needed resources.
 * 
 * @author CSAutomation Team
 *
 */
public abstract class TestBase {

    public static WebDriver                 browserDriver;
    public static ApplicationConfiguration1 config;
    public static DataDrivenScript          DrivenScript;
    public WebDriverWait                       waitForReload;

    /**
     * This method perform operations required before the test begins.
     * 
     * @param context Context Instance
     */
    @BeforeClass
    public void preProcessor(ITestContext context) {
        ISuite suite = context.getSuite();
        browserDriver = (WebDriver) suite.getAttribute("driverForBrowser");
        DrivenScript = new DataDrivenScript();
        waitForReload = new WebDriverWait(browserDriver, 180);
        config = (ApplicationConfiguration1) suite
                .getAttribute("configurations");
        CSLogger.setClass(this);
        CSLogger.startTestCase(this.getClass().getSimpleName());
    }

    @AfterClass
    public void postProcessor() {
        CSLogger.endTestCase(this.getClass().getSimpleName());
    }

    /**
     * Returns the webdriver instance.
     * 
     * @return browserDriver instance
     */
    public WebDriver getBrowserDriver() {
        return browserDriver;
    }

    /**
     * Returns the ApplicationConfiguration Instance.
     * 
     * @return config ApplicationConfiguration
     */
    public ApplicationConfiguration1 getConfig() {
        return config;
    }

    /**
     * This is returns the data driven class to read the data from the xlsx file
     * 
     * @return object of data driven
     */

    public DataDrivenScript getExcelDataDriven() {
        return DrivenScript;
    }

}
