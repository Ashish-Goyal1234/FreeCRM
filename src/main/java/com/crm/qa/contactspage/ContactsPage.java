
package com.crm.qa.contactspage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.crm.qa.base.TestBase;
import com.crm.qa.util.CSLogger;

public class ContactsPage extends TestBase {

    public ContactsPage() {
        PageFactory.initElements(browserDriver, this);
        CSLogger.info("Initializing Page Factory for Contacts Page");
    }

    @FindBy(xpath = "//a[contains(text(),'New Contact')]")
    WebElement newContactsLink;
    
    @FindBy(xpath="//select[@name='title']")
    WebElement drpDownTitle;
    
    @FindBy(xpath = "//input[@id='first_name']")
    WebElement txtFirstName;

    @FindBy(xpath = "//input[@id='middle_initial']")
    WebElement txtMiddleName;

    @FindBy(xpath = "//input[@id='surname']")
    WebElement txtSurNAme;

    @FindBy(xpath = "//input[@name='nickname']")
    WebElement txtNickName;

    @FindBy(xpath = "//input[@name='client_lookup']")
    WebElement txtCompanyName;
    
    @FindBy(xpath="(//input[@value='Lookup'])[1]")
    WebElement btnCompanyLookup;

    @FindBy(xpath = "//input[@name='company_position']")
    WebElement txtPosition;

    @FindBy(xpath = "//input[@name='department']")
    WebElement txtDepartment;
    
    @FindBy(xpath="(//input[@value='Lookup'])[2]")
    WebElement btnSupervisorLookup;
    
    @FindBy(xpath="//input[@name='contact_lookup_sup']")
    WebElement txtSupervisor;
    
    @FindBy(xpath="//input[@id='search']")
    WebElement txtSearchInLookup;
    
    @FindBy(xpath="//form[@id='lookupSearchForm']//input[@class='button']")
    WebElement btnSearchInLookup;
    
    @FindBy(xpath="//form[@name='contactForm']//child::table//child::tbody//child::tr//child::td//input[@value='Save']")
    WebElement btnSave;
    
    /**
     * Getter for newContactsLink
     * 
     * @return WebElement
     */
    public WebElement getNewContactsLink() {
        return newContactsLink;
    }
    
    /*
     * Getter for Title drop down
     * 
     * @return Webelement
     */
    public WebElement getTitle() {
        return drpDownTitle;
    }

    /*
     * Getter for txtFirstName
     * 
     * @return Webelement
     */
    public WebElement getTextFirstName() {
        return txtFirstName;
    }

    /*
     * Getter for txtMiddleName
     * 
     * @return Webelement
     */
    public WebElement getTextMiddleName() {
        return txtMiddleName;
    }

    /*
     * Getter for txtSurName
     * 
     * @return Webelement
     */
    public WebElement getTextLastName() {
        return txtSurNAme;
    }

    /*
     * Getter for txtNickName
     * 
     * @return Webelement
     */
    public WebElement getTextNickName() {
        return txtNickName;
    }

    /*
     * Getter for txtCompanyName
     * 
     * @return Webelement
     */
    public WebElement getTextCompanyName() {
        return txtCompanyName;
    }

    /*
     * Getter for btnCompanyLookup
     * 
     * @return Webelement
     */
    public WebElement getbBtnCompanyLookup() {
        return btnCompanyLookup;
    }
    
    /*
     * Getter for txtPositionName
     * 
     * @return Webelement
     */
    public WebElement getTextPositionName() {
        return txtPosition;
    }
    
    /*
     * Getter for txtDepartmentName
     * 
     * @return Webelement
     */
    public WebElement getTextDepartmentName() {
        return txtDepartment;
    }
    
    /*
     * Getter methid for Button Lookup for supervisor
     * @ return Webelement
     */
    public WebElement getBtnSupervisorLookup() {
        return btnSupervisorLookup;
    }
    
    /*
     * Getter method for Textbox of Supervisor
     * @Return WebElement
     */
    public WebElement getTxtSupervisor() {
        return txtSupervisor;
    }
    
    /*
     * Getter method for Searchbox which is displayed in Lookup button.
     * @return WebElement
     */
    public WebElement getTxtSearchBoxInLookup() {
        return txtSearchInLookup;
    }
    
    /*
     * Getter Method for Search button which is displayed in Lookup button.
     * @return WebElement.
     */
    public WebElement getSearchBtnInLookup() {
        return btnSearchInLookup;
    }
    
    /*
     * Getter Method for save button.
     * @return webelement
     */
    public WebElement getBtnSaveContact() {
        return btnSave;
    }

    /**
     * This method perform click operation on the New Contacts Link.
     */
    public void clkContactsLink() {
        getNewContactsLink().click();
        CSLogger.info("Clicked on the New Contacts Link.");
    }
    
    /**
     * This method sets the provided Middle in the Middle name text field.
     * 
     * @param Middle name String value containing the Middle name
     */
    public void enterMiddleName(String middleName) {
        getTextMiddleName().sendKeys(middleName);
        CSLogger.info("Entered Middle Name : " + middleName);
    }

    
    /**
     * This method sets the provided Firstname in the First name text field.
     * 
     * @param First name String value containing the First name
     */
    public void enterFirstName(String firstName) {
        getTextFirstName().sendKeys(firstName);
        CSLogger.info("Entered First Name : " + firstName);
    }
    
    /**
     * This method sets the provided Last name in the Last name text field.
     * 
     * @param Last name String value containing the Last name
     */
    public void enterLastName(String lastName) {
        getTextLastName().sendKeys(lastName);
        CSLogger.info("Entered Last Name : " + lastName);
    }
    
    /**
     * This method sets the provided Nick name in the Nick name text field.
     * 
     * @param Nick name String value containing the Nick name
     */
    public void enterNickName(String nickName) {
        getTextNickName().sendKeys(nickName);
        CSLogger.info("Entered Nick Name : " + nickName);
    }
    
    /**
     * This method sets the provided Company name in the Company name text field.
     * 
     * @param company name String value containing the Comapany name
     */
    public void enterCompanyName(String companyName) {
        getTextCompanyName().sendKeys(companyName);
        CSLogger.info("Entered Company Name : " + companyName);
    }
    
    /**
     * This method clicks on Lookup button displayed in front of Company
     */
    public void clkCompanyLookup() {
        getbBtnCompanyLookup().click();
        CSLogger.info("Clicked on Lookup button displayed in front of comapany text field : ");
    }
    
    /**
     * This method sets the provided Position name in the Position name text field.
     * 
     * @param position name String value containing the Comapany name
     */
    public void enterPositionName(String positionName) {
        getTextPositionName().sendKeys(positionName);
        CSLogger.info("Entered position Name : " + positionName);
    }
    
    /**
     * This method sets the provided Department name in the Department name text field.
     * 
     * @param Department name String value containing the Department name
     */
    public void enterDepartmentName(String departmentName) {
        getTextDepartmentName().sendKeys(departmentName);
        CSLogger.info("Entered Department Name : " + departmentName);
    }
    
    
    /*
     * This method click on Lookup button which is displayed in front of Supervisor Text field.
     * 
     */
    public void clickBtnSupervisorLooup(){
        getBtnSupervisorLookup().click();
        CSLogger.info("Clicked on Lookup button displayed in front of Supervisor Text Field");
    }
    
    
    public void enterSearchElementInTxtSupervisor(String supervisorName) {
        getTxtSupervisor().sendKeys(supervisorName);
    }
    
    /*
     * This Method will enter text to search.
     * @Search string value contains Search characters.
     */
    public void enterSearchElementInLookupSearchBox(String search) {
        getTxtSearchBoxInLookup().sendKeys(search);
        CSLogger.info("Entered String to search ");
    }
    
    /*
     * This Method will click on Search button which is displayed in Lookup window
     */
    public void clkSearchBtnInLookup() {
        getSearchBtnInLookup().click();
        CSLogger.info("Clicked on Search Button Displayed in Lookup");
    }
    
    
    /*
     * This method will click on save button 
     */
    public void clkSaveButton() {
        getBtnSaveContact().click();
        CSLogger.info("Clicked on Save Button displayed in Contacts Information..!");
    }
    
    
    
    
}
