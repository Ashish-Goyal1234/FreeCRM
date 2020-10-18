
package com.crm.qa.calender;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.crm.qa.base.TestBase;
import com.crm.qa.calenderpage.CalenderPage;
import com.crm.qa.datadriven.DataProviderPage;
import com.crm.qa.util.CSLogger;
import com.crm.qa.util.TestUtil;

public class CreateEventByCalenderTest extends TestBase {

    CalenderPage  calenderpage;
    TestUtil      testutil;
    WebDriverWait waiForReload;

    @BeforeTest
    public void initialization() {
        calenderpage = new CalenderPage();
        testutil = new TestUtil();
        waiForReload = new WebDriverWait(browserDriver, 60);
    }

    @Test(dataProvider = "createTaskInCalender",dataProviderClass = DataProviderPage.class)
    public void createEvent(String month, String year, String date, String eventTitle)  {
        try{
        calenderpage.clkCalenderPane();
        testutil.getDropDownValueUsingSelectMethod(calenderpage.getMonthDropdownFromCalender(), month);
        testutil.getDropDownValueUsingSelectMethod(calenderpage.getYearDropDownFromCalendar(), year);
      
        List<WebElement> dates = calenderpage.getAllDatesInCalendar();
           int allDates =  dates.size();
           for(int i = 0; i<allDates; i++){
               String actualdate = dates.get(i).getText();
               if(actualdate.equalsIgnoreCase(date)){
                   dates.get(i).click();
                   break;
               }
           }
            CSLogger.info("Clicked on Date : " + date);
            calenderpage.clkOnTimeInCalendor();
            eventInformation(eventTitle);
            calenderpage.clkAddBtnInEventInformation();
            calenderpage.clkSaveButtonInEventInformation();
        }catch(Exception e){
            CSLogger.debug("Failed to create Event" + e);
            Assert.fail("Failed to create event"+ e);
        }
    }
    
    
    private void eventInformation(String title) throws InterruptedException {
        calenderpage.enterTitleInTxtBoxOfEventInformationForm(title);
        calenderpage.clkFromDateSelectorIcon();
       WebElement SelectDateWindowFrom =  calenderpage.getSelectDateWindow();
      
       
       List<WebElement> fromDatesList = SelectDateWindowFrom.findElements(By.cssSelector(".day"));
       int totalFromDates = fromDatesList.size();
       for(int i=0; i<totalFromDates;i++){
           String actualFromDate = fromDatesList.get(i).getText();
           if(actualFromDate.equals("5")){
               fromDatesList.get(i).click();
               break;
           }
       }
       
       List<WebElement> toDatesList = SelectDateWindowFrom.findElements(By.cssSelector(".day"));
       int totalToDates = toDatesList.size();
       for(int j=0;j<totalToDates;j++){
          String actualToDates =  toDatesList.get(j).getText();
          if(actualToDates.equalsIgnoreCase("25")){
              toDatesList.get(j).click();
          }
       }
    }
 }
