package com.crm.qa.calenderpage;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.crm.qa.base.TestBase;
import com.crm.qa.util.CSLogger;

public class CalenderPage extends TestBase{
    public CalenderPage(){
        PageFactory.initElements(browserDriver, this);
    }
    
    @FindBy(css = "a[title*='Calendar']")
    private WebElement calenderPane;
    
    @FindBy(name = "slctMonth")
    private WebElement monthDrpDwnFrmCalendar;
    
    @FindBy(name = "slctYear")
    private WebElement yearDrpDwnFrmCalendar;
    
    @FindBy(css = ".calendarcell")
    private List <WebElement> listOfAlldates;
    
    @FindBy(xpath="//a[@name = '08:00AM']//parent::td[@class='journalrowtime']//following-sibling::td[@class='journalrowempty']")
    private WebElement selectTimeInCalendor;
    
    @FindBy(name = "title")
    private WebElement titleTxtBoxInEventInformation;
    
    @FindBy(xpath="(//img[@title='Date selector'])[1]")
    private WebElement fromDateSelector;
    
    @FindBy(xpath="(//img[@title='Date selector'])[2]")
    private WebElement ToDateSelector;
    
    @FindBy(xpath="//div[@class='calendar']//table//tbody")
    private WebElement selectDateWindow;
    
    @FindBy(css = "[value='==ADD==>']")
    private WebElement addBtnInEventInformation;
    
    @FindBy(xpath = "(//td[@valign='top' and@ align='center']//input[@type='submit' and @value='Save'])[1]")
    private WebElement saveBtnInEventInformation;
    
    
    public WebElement  getCalenderPane(){
        return calenderPane;
    }
    
    public void clkCalenderPane() {
        browserDriver.switchTo().frame("mainpanel");
        getCalenderPane().click();
        CSLogger.info("Clicked on Calender Pane");
    }
    
    
    public WebElement getMonthDropdownFromCalender() {
       return  monthDrpDwnFrmCalendar;
    }
    
    public WebElement getYearDropDownFromCalendar() {
        return yearDrpDwnFrmCalendar;
    }
    
    public List<WebElement> getAllDatesInCalendar() {
        return listOfAlldates;
    }
    
    public void clkOnTimeInCalendor(){
        selectTimeInCalendor.click();
        CSLogger.info("Clicked on 8:00 AM--This is HardCoded need to drill down");
    }
    
    public WebElement getTitleTxtBoxInEventInformationForm() {
        return titleTxtBoxInEventInformation;
    }
    
    
    public void enterTitleInTxtBoxOfEventInformationForm(String title) {
        titleTxtBoxInEventInformation.sendKeys(title);
        CSLogger.info("Entered title in Event Information form");
    }
    
    public void clkFromDateSelectorIcon() {
        fromDateSelector.click();
    }
    
    public void clkToDateSelectorIcon() {
        ToDateSelector.click();
    }
   
    public WebElement getSelectDateWindow() {
        return selectDateWindow;
    }
    
    public void clkAddBtnInEventInformation() {
        addBtnInEventInformation.click();
    }
    
    public void clkSaveButtonInEventInformation() {
        saveBtnInEventInformation.click();
    }
}
