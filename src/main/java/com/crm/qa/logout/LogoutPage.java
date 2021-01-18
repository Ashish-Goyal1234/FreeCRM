package com.crm.qa.logout;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.crm.qa.base.TestBase;

public class LogoutPage extends TestBase{
        
    LogoutPage(){
        PageFactory.initElements(browserDriver, this);
    }
    
    @FindBy(className=".topnavlink")
    private List<WebElement> logout;
    
    public List<WebElement> getLogoutBtn() {
        return logout;
    }
    
    
    public void clkLogout() throws InterruptedException{
        Thread.sleep(2000);
        browserDriver.switchTo().frame("mainpanel");
        getLogoutBtn().get(2).click();
    }
}
