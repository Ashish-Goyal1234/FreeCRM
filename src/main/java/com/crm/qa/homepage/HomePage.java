
package com.crm.qa.homepage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.crm.qa.base.TestBase;
import com.crm.qa.util.CSLogger;

public class HomePage extends TestBase {

    public HomePage() {
        PageFactory.initElements(browserDriver, this);
        CSLogger.info("Initializing Home  page, Page Factory Elements");
    }

    @FindBy(xpath = "//a[contains(text(),'Logout')]")
    private WebElement btnLogout;
    
    @FindBy(xpath="//a[contains(text(),'Home')]")
    private WebElement homeLink;
    
    @FindBy(xpath="//a[contains(text(),'Calendar')]")
    private WebElement calenderLink;
    
    @FindBy(xpath="//a[contains(text(),'Companies')]")
    private WebElement companiesLink;
    
    @FindBy(xpath="//a[contains(text(),'Contacts')]")
    private WebElement contactsLink;
    
    @FindBy(xpath="//a[contains(text(),'Deals')]")
    private WebElement dealsLink;
    
    @FindBy(xpath="//a[contains(text(),'Tasks')]")
    private WebElement taskLink;
    
    @FindBy(xpath="//a[contains(text(),'Cases')]")
    private WebElement casesLink;
    
    @FindBy(xpath="//body/table/tbody/tr/td[@class='headertable']/div[@class='noprint']/div[@id='navmenu']/ul[@class='mlddm']/li[8]/a[1]")
   private WebElement callsLink; 
    
    @FindBy(xpath="//body/table/tbody/tr/td[@class='headertable']/div[@class='noprint']/div[@id='navmenu']/ul[@class='mlddm']/li[9]/a[1]")
    private WebElement emailLink;
    
    @FindBy(xpath="//body/table/tbody/tr/td[@class='headertable']/div[@class='noprint']/div[@id='navmenu']/ul[@class='mlddm']/li[10]/a[1]")
    private WebElement text_smsLink;
    
    @FindBy(xpath="//body/table/tbody/tr/td[@class='headertable']/div[@class='noprint']/div[@id='navmenu']/ul[@class='mlddm']/li[11]/a[1]")
    private WebElement printLink;
    
    @FindBy(xpath="//body/table/tbody/tr/td[@class='headertable']/div[@class='noprint']/div[@id='navmenu']/ul[@class='mlddm']/li[11]/a[1]")
    private WebElement campaignLink;
    
    @FindBy(xpath="//a[contains(text(),'Docs')]")
    private WebElement docsLink;
    
    @FindBy(xpath="//a[contains(text(),'Forms')]")
    private WebElement formsLink;
    
    @FindBy(xpath="//a[contains(text(),'Reports')]")
    private WebElement reportsLink;
    

        /**
         * Getter for btnLogout
         * 
         * @return WebElement
         */
        public WebElement getBtnLogout() {
            return btnLogout;
        }
        
        /**
         * Getter for calender link
         * 
         * @return WebElement calenderLink
         */
        public WebElement getCalenderLink() {
            return calenderLink;
        }
        
        /**
         * Getter for comapnies link
         * 
         * @return WebElement companiesLink
         */
        public WebElement getCompaniesLink() {
            return companiesLink;
        }
        
        /**
         * Getter for home Link
         * 
         * @return WebElement homeLink
         */
        public WebElement getHomeLink() {
            return homeLink;
        }
        
        /**
         * Getter for contacts Link
         * 
         * @return WebElement contactsLink
         */
        public WebElement getContactsLink() {
            return contactsLink;
        }
        
        /**
         * Getter for Deals Link
         * 
         * @return WebElement dealsLink
         */
        public WebElement getDealsLink() {
            return dealsLink;
        }
           
        /**
         * Getter for Tasks Link
         * 
         * @return WebElement taskLink
         */
        public WebElement getTasksLink() {
            return taskLink;
        }
        
        /**
         * Getter for Cases Link
         * 
         * @return WebElement casesLink
         */
        public WebElement getCasesLink() {
            return casesLink;
        }
        
        /**
         * Getter for Calls Link
         * 
         * @return WebElement callsLink
         */
        public WebElement getCallsLink() {
            return callsLink;
        }
        
        /**
         * Getter for email Link
         * 
         * @return WebElement emailLink
         */
        public WebElement getEmailLink() {
            return emailLink;
        }
        
        /**
         * Getter for Test/SMS Link
         * 
         * @return WebElement emailLink
         */
        public WebElement getText_SMSLink() {
            return text_smsLink;
        }
        
        /**
         * Getter for Print Link
         * 
         * @return WebElement printLink
         */
        public WebElement getPrintLink() {
            return printLink;
        }
        
        /**
         * Getter for campaigns Link
         * 
         * @return WebElement campaignsLink
         */
        public WebElement getCampaignLink() {
            return campaignLink;
        }
        
        /**
         * Getter for Docs Link
         * 
         * @return WebElement docsLink
         */
        public WebElement getDocsLink() {
            return docsLink;
        }
        
        /**
         * Getter for Forms Link
         * 
         * @return WebElement formsLink
         */
        public WebElement getFormsLink() {
            return formsLink;
        }
        
        /**
         * Getter for Reports Link
         * 
         * @return WebElement reportsLink
         */
        public WebElement getReportsLink() {
            return reportsLink;
        }
        
        
        /**
         * This method perform click operation on the Home Link.
         */
        public void clkHomeLink() {
            getHomeLink().click();
            CSLogger.info("Clicked on the Home button.");
        }
        
        /**
         * This method perform click operation on the Calender Link.
         */
        public void clkCalenderLink() {
            getCalenderLink().click();
            CSLogger.info("Clicked on the Calender button.");
        }
        
        /**
         * This method perform click operation on the companies Link.
         */
        public void clkCompaniesLink() {
            getCompaniesLink().click();
            CSLogger.info("Clicked on the companies button.");
        }
        
        /**
         * This method perform click operation on the contacts Link.
         */
        public void clkContactsLink() {
            getContactsLink().click();
            CSLogger.info("Clicked on the contacts button.");
        }
        
        /**
         * This method perform click operation on the Deals Link.
         */
        public void clkDealsLink() {
            getDealsLink().click();
            CSLogger.info("Clicked on the Deals button.");
        }
        
        /**
         * This method perform click operation on the Tasks Link.
         */
        public void clkTasksLink() {
            getTasksLink().click();
            CSLogger.info("Clicked on the Tasks button.");
        }
        
        /**
         * This method perform click operation on the Cases Link.
         */
        public void clkCasesLink() {
            getCasesLink().click();
            CSLogger.info("Clicked on the Cases button.");
        }
        
        /**
         * This method perform click operation on the Calls Link.
         */
        public void clkCallsLink() {
            getCallsLink().click();
            CSLogger.info("Clicked on the Calls button.");
        }
        
        /**
         * This method perform click operation on the Email Link.
         */
        public void clkEmailLink() {
            getEmailLink().click();
            CSLogger.info("Clicked on the Email button.");
        }
        
        /**
         * This method perform click operation on the Text/Sms Link.
         */
        public void clkText_SmsLink() {
            getText_SMSLink().click();
            CSLogger.info("Clicked on the Text/SMS button.");
        }
        
        /**
         * This method perform click operation on the Print Link.
         */
        public void clkPrintLink() {
            getPrintLink().click();
            CSLogger.info("Clicked on the Print button.");
        }
        
        /**
         * This method perform click operation on the Campaigns Link.
         */
        public void clkCampaignsLink() {
            getCampaignLink().click();
            CSLogger.info("Clicked on the Campaigns button.");
        }
        
        /**
         * This method perform click operation on the Docs Link.
         */
        public void clkDocsLink() {
            getDocsLink().click();
            CSLogger.info("Clicked on the Docs button.");
        }
        
        /**
         * This method perform click operation on the Forms Link.
         */
        public void clkFormsLink() {
            getFormsLink().click();
            CSLogger.info("Clicked on the Forms button.");
        }
        
        /**
         * This method perform click operation on the Reports Link.
         */
        public void clkReportsLink() {
            getReportsLink().click();
            CSLogger.info("Clicked on the Reports button.");
        }
        
        
        
        
        
        
        /**
         * This method perform click operation on the submit button.
         */
        public void clkLogoutButton() {
            getBtnLogout().click();
            CSLogger.info("Clicked on the Logout button.");
            
        }
}