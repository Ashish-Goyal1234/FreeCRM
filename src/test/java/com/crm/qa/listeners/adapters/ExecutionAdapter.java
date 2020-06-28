
package com.crm.qa.listeners.adapters;

import org.testng.IExecutionListener;

/**
 * This is an Abstract class which act as an Adapter class for Execution
 * Listener.
 * 
 * @author CSAutomation Team
 *
 */
public abstract class ExecutionAdapter implements IExecutionListener {

    /**
     * Invoked before the TestNG run starts.
     */
    public void onExecutionStart() {

    }

    /**
     * Invoked once all the suites have been run.
     */
    public void onExecutionFinish() {

    }

}
