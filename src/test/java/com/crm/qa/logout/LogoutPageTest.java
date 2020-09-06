package com.crm.qa.logout;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.crm.qa.login.LoginPage;
import com.crm.qa.util.CSLogger;

public class LogoutPageTest {
    
    public LogoutPage logout;
    public LoginPage login;

    @BeforeMethod
    public void Initialization() {
        logout = new LogoutPage();
        login = new LoginPage();
    }
    
    
    @Test(priority=1)
    public void testLogout() {
        logout.clkLogout();
        CSLogger.info("Clicked On Logout Button");
    }
    
    
    @Test(priority=2)
    public void verifyLogout() {
       if(login.getBtnLoginButton().isDisplayed()){
           CSLogger.info("Successfully Logged out of the page");
       }else{
           Assert.fail("Logout Unsuccessful");
           CSLogger.info("Unable to perform logout...!");
       }
    }
    
}
