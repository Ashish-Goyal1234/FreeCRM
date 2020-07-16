
package com.crm.qa.util;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import java.util.UUID;
import javax.imageio.ImageIO;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase {

    public static long PAGE_Load_Timeout = 20;
    public static long Implicit_Wait     = 10;

    public static void takeScreenshotAtEndOfTest() {
        File scrFile = ((TakesScreenshot) browserDriver)
                .getScreenshotAs(OutputType.FILE);
        String currentDir = System.getProperty("user.dir");
        try {
            FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/"
                    + System.currentTimeMillis() + ".png"));
        } catch (IOException e) {
            Assert.fail("Failed to Capture Screenshot");
        }
    }
    
    
    /**
     * This method captures screenshots using Robot class
     * 
     * @param testMethodName
     * @param path
     * @return
     */
    public static String captureScreenshotWithRobot(String testMethodName,
            String path) {
        try {
            Robot robotClassObject = new Robot();
            Rectangle screenSize = new Rectangle(
                    Toolkit.getDefaultToolkit().getScreenSize());
            BufferedImage tmp = robotClassObject
                    .createScreenCapture(screenSize);

            path = new TestUtil().buildScreenshotFilePath(path,
                    testMethodName);
            File screenshotFile = new File(path);
            FileUtils.touch(screenshotFile);
            // To copy temp image in to permanent file
            ImageIO.write(tmp, "png", screenshotFile);
        } catch (Exception e) {
            CSLogger.fatal("Screenshot using Robot Failed :", e);
        }

        return path;
    }
    
    /**
     * this method helps to build file path required for screenshot
     * 
     * @param path
     * @param testMethodName
     * @return
     */
    private String buildScreenshotFilePath(String path, String testMethodName) {
        path = System.getProperty("user.dir") + "\\" + path + getCurrentDate()
                + "\\temp";
        String fileName = testMethodName + "_" + UUID.randomUUID() + ".png";
        return path + fileName;
    }
    
    /**
     * returns current date
     * 
     * @return
     */
    public String getCurrentDate() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }
    
    public void getDropDownValueUsingSelectMethod(WebElement parentElement, String ChildValue) {
        Select select = new Select(parentElement);
        select.selectByValue(ChildValue);
    }
    
    
    public void switchToWindow() {
       Set<String> handler =  browserDriver.getWindowHandles();   // to get all Window IDs.
       Iterator<String> it = handler.iterator();   // Used to switch to next window.
       String ParentWindowId = it.next();
       CSLogger.info("Switched to Parent Window  and Parent Window ID is :"+ ParentWindowId);
    }
    
    public void switchToFrame() {
        browserDriver.switchTo().frame("mainpanel");
    }
    
    
}