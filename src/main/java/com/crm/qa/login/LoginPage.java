package com.crm.qa.login;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.crm.qa.base.TestBase;
import com.crm.qa.util.CSLogger;

public class LoginPage extends TestBase {
    
    public LoginPage() {
        /*  driver is comming from Base class and this means current class objects means 
            all the above WebElement variables will be initialized with this drivers*/
           
            PageFactory.initElements(browserDriver, this); 
            CSLogger.info("Initialized Login page POM elements.");
        }

    //PageFactory or Object repository
    
        @FindBy(xpath ="//a[contains(text(),'Home')]")
        private WebElement homeLink;
        
        @FindBy(xpath="//a[contains(text(),'Sign Up')]")
        private WebElement signUpLink;
        
        @FindBy(xpath="//a[contains(text(),'Pricing')]")
        private WebElement pricingLink;
        
        @FindBy(xpath="//a[contains(text(),'Features')]")
        private WebElement featuresLink;
        
        @FindBy(xpath="//a[contains(text(),'Customers')]")
        private WebElement customersLink;
        
        @FindBy(xpath="//a[contains(text(),'Contact')]")
        private WebElement contactsLink;
        
        @FindBy(name = "username")
        private WebElement txtUsername;

        @FindBy(name = "password")
        private WebElement txtPassword;
        
        @FindBy(xpath="//input[@type='submit']")
        private WebElement btnSubmit;
        
        @FindBy(xpath="(//img[contains(@class,'img-responsive')])[1]")
        private WebElement imgCrmProLogo;

        
        /**
         * This method returns the instance of Home
         * 
         * @return btnHome
         */
        public WebElement getHomeLink() {
            return homeLink;
        }
        
        /**
         * This method returns the instance of Sign Up
         * 
         * @return btnHome
         */
        public WebElement getSignUpLink() {
            return signUpLink;
        }
        
        /**
         * This method returns the instance of pricing
         * 
         * @return btnHome
         */
        public WebElement getPricing() {
            return pricingLink;
        }
        
        /**
         * This method returns the instance of Features
         * 
         * @return btnHome
         */
        public WebElement getFeaturesLink() {
            return featuresLink;
        }
        
        /**
         * This method returns the instance of Customers
         * 
         * @return btnCustomers
         */
        public WebElement getCustomersLink() {
            return customersLink;
        }
        
        /**
         * This method returns the instance of Contacts
         * 
         * @return btnCustomers
         */
        public WebElement getContactsLink() {
            return contactsLink;
        }
        
        /**
         * Getter for txtUsername
         * 
         * @return WebElement txtUsername
         */
        public WebElement getTxtUsername() {
            return txtUsername;
        }
        
        /**
         * Getter for txtPassword
         * 
         * @return WebElement txtPassword
         */
        public WebElement getTxtPassword() {
            return txtPassword;
        }
        
        /**
         * Getter for btnLoginButton
         * 
         * @return WebElement
         */
        public WebElement getBtnLoginButton() {
            return btnSubmit;
        }

     
        /**
         * This method sets the provided username in the username text field.
         * 
         * @param username String value containing the username
         */
        public void enterUsername(String username) {
            getTxtUsername().sendKeys(username);
            CSLogger.info("Entered username " + username);
        }
        
        /**
         * This method sets the provided password in the password text field.
         * 
         * @param password String value containing the password
         */
        public void enterPassword(String password) {
            getTxtPassword().sendKeys(password);
            CSLogger.info("Entered password " + password);
        }
        
        /**
         * This method perform click operation on the submit button.
         */
        public void clkSubmitButton() {
            getBtnLoginButton().click();
            CSLogger.info("Clicked on the submit button.");
            
        }
        
        
        
        
      
}