
package com.crm.qa.listeners.adapters;

import org.testng.ISuite;
import org.testng.ISuiteListener;

/**
 * This is an Abstract class which act as an Adapter class for Suite Listener.
 * 
 * @author CSAutomation Team
 *
 */
public abstract class SuiteAdapter implements ISuiteListener {

    /**
     * This method is invoked before the SuiteRunner starts.
     */
    public void onStart(ISuite suite) {
        /*
         * This method will be given defination in future as and when required.
         */
    }

    /**
     * This method is invoked after the SuiteRunner has run all the test suites.
     */
    public void onFinish(ISuite suite) {
        /*
         * This method will be given defination in future as and when required.
         */
    }

}
