package com.crm.qa.homePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.crm.qa.base.TestBase;
import com.crm.qa.util.CSLogger;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase{
    
    private TestUtil testUtil;

    @BeforeClass
    public void Initialization() {
        testUtil = new TestUtil();
    }
    
    @Test(priority=1)
    private void veriyHomePageTitleTest (){
        String title = browserDriver.getTitle();
        String Actual_Title = "CRMPRO";
        if(title.contentEquals(Actual_Title)) {
            CSLogger.info("Title is Matching...!");
        }else{
            CSLogger.info("Title is not matching");
            Assert.fail("Title is not matching");
        }
    }
    
    @Test(priority=2)
    private void verifyUsernameTest() {
        testUtil.switchToFrame();
        CSLogger.info("Switched to MainFrame");
        WebElement username = browserDriver.findElement(By.xpath("//td[contains(text(),'User: Demo User')]"));
        if(username.isDisplayed()){
            CSLogger.info("Username is Correct....!");
        }else{
            CSLogger.info("Invalid username..!");
            Assert.fail("Invalid Username...!");
        }
    }
    
  /*  @Test(priority=3)
    public void testHomePage(){
        homePage.clkContactsLink();
        CSLogger.info("clicked on contacts Page");
    }
    */
}
