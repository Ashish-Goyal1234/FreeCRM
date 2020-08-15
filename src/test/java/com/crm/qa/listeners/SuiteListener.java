/*
 * Copyright (c) 2019, Contentserv. All rights reserved.
 * Contentserv PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.crm.qa.listeners;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.testng.ISuite;
import com.crm.qa.listeners.adapters.SuiteAdapter;
import com.crm.qa.util.ApplicationConfiguration1;
import com.crm.qa.util.BrowserFactory;
import com.crm.qa.util.CSLogger;
import com.relevantcodes.extentreports.ExtentReports;

/**
 * TestNG Test Listener class extending the Adapter class.
 * 
 * @author CSAutomation Team
 *
 */
public class SuiteListener extends SuiteAdapter {

    private ExtentReports extentReportInstance;

    /**
     * This method is invoked before the SuiteRunner starts.
     */
    @Override
    public void onStart(ISuite suite) {
        performStartupActivities(suite);
    }

    /**
     * This method perform activities necessary before starting the test.
     * 
     * @param suite Suite Instance.
     */
    private void performStartupActivities(ISuite suite) {
        ApplicationConfiguration1 config = readConfigurationFile(suite);
        loadBrowserDriverInstance(suite, config);
        String filePath = config.getextentReportsPath();
        filePath += new SimpleDateFormat("yyyy-MM-dd hh-mm-ss-ms")
                .format(new Date());
        extentReportInstance = new ExtentReports(filePath + "//reports.html");
        suite.setAttribute("extentReport", extentReportInstance);
    }

    /**
     * This method reads the properties file.
     * 
     * @param suite Suite Instance.
     * @return config ApplicationConfiguration Instance.
     */
    private ApplicationConfiguration1 readConfigurationFile(ISuite suite) {
        ApplicationConfiguration1 config = new ApplicationConfiguration1();
        config.loadConfigurations();
        suite.setAttribute("configurations", config);
        return config;
    }

    /**
     * This method initiates the browser driver loading process.
     * 
     * @param suite Suite Instance
     * @param config ApplicationConfiguration Instance
     */
    private void loadBrowserDriverInstance(ISuite suite,
            ApplicationConfiguration1 config) {
        BrowserFactory browserFactory = new BrowserFactory();
       WebDriver webDriverInstance = browserFactory.getBrowser(
                config.getBrowserName(), config.getBrowserVersion());
        setTimeouts(config, webDriverInstance.manage());
        webDriverInstance.manage().window().maximize();
        suite.setAttribute("driverForBrowser", webDriverInstance);
    }

    /**
     * This method sets the various time-outs for browser.
     * 
     * @param config ApplicationConfiguration Instance
     * @param optionsInstance Options Instance
     */
    private void setTimeouts(ApplicationConfiguration1 config,
            Options optionsInstance) {
        setImplicitTimeOutForBrowser(config, optionsInstance);
        setPageLoadTimeOutForBrowser(config, optionsInstance);
        setScriptTimeOutForBrowser(config, optionsInstance);
        CSLogger.info("Initialized Timeout settings.");
    }

    /**
     * This method sets the implicit time-out for browser.
     * 
     * @param config ApplicationConfiguration Instance
     * @param optionsInstance Options Instance
     */
    private void setImplicitTimeOutForBrowser(ApplicationConfiguration1 config,
            Options optionsInstance) {
        optionsInstance.timeouts().implicitlyWait(config.getImplicitTimeout(),
                TimeUnit.SECONDS);
    }

    /**
     * This method sets the pageload time-out for browser.
     * 
     * @param config ApplicationConfiguration Instance
     * @param optionsInstance Options Instance
     */
    private void setPageLoadTimeOutForBrowser(ApplicationConfiguration1 config,
            Options optionsInstance) {
        optionsInstance.timeouts().pageLoadTimeout(config.getPageLoadTimeout(),
                TimeUnit.SECONDS);
    }

    /**
     * This method sets the script time-out for browser.
     * 
     * @param config ApplicationConfiguration Instance
     * @param optionsInstance Options Instance
     */
    private void setScriptTimeOutForBrowser(ApplicationConfiguration1 config,
            Options optionsInstance) {
        optionsInstance.timeouts().setScriptTimeout(config.getScriptTimeout(),
                TimeUnit.SECONDS);
    }

    /**
     * This method is invoked after the SuiteRunner has run all the test suites.
     */
    @Override
    public void onFinish(ISuite suite) {
        closeBrowserDriver(suite);
        performCleanupActivities(suite);
    }

    /**
     * This method closes browser driver.
     * 
     * @param suite Suite Instance
     */
    private void closeBrowserDriver(ISuite suite) {
        WebDriver webDriverInstance = (WebDriver) suite
                .getAttribute("driverForBrowser");
        webDriverInstance.quit();
        CSLogger.info("Closed Browser window.");
    }

    /**
     * This method removes ApplicationConfiguration Instance from test context.
     * 
     * @param suite Suite Instance
     */
    private void performCleanupActivities(ISuite suite) {
        extentReportInstance.flush();
        suite.removeAttribute("driverForBrowser");
        suite.removeAttribute("configurations");
    }

}