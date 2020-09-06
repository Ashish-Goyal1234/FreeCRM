package com.crm.qa.logout;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.crm.qa.base.TestBase;

public class LogoutPage extends TestBase{
        
    LogoutPage(){
        PageFactory.initElements(browserDriver, this);
    }
    
    @FindBy(xpath="//a[@class='topnavlink'] /i[@class='fa fa-sign-out icon-2x']")
    private WebElement logout;
    
    public WebElement getLogoutBtn() {
        return logout;
    }
    
    
    public void clkLogout(){
        getLogoutBtn().click();
    }
    
    
    
}
