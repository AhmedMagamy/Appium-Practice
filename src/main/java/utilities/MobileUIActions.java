package utilities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static utilities.ReportsUtility.ExtentReport.fail;

public class MobileUIActions {

    private AppiumDriver driver;


    public MobileUIActions(AppiumDriver driver) {
        this.driver = driver;
    }

    public static MobileUIActions click(AppiumDriver driver, By elementLocator) {
        locatingElement(driver, elementLocator);
        try {
            Logger.logMessage("[UI Action] click on element [" + elementLocator + "]");
            driver.findElement(elementLocator).click();
        }
        catch (Exception e){
            Logger.logMessage(e.getMessage());
            fail(e.getMessage());
        }
        return new MobileUIActions(driver);
    }



    public static MobileUIActions type(AppiumDriver driver, By elementLocator, String text) {
        locatingElement(driver, elementLocator);
        try {
            Logger.logMessage("[UI Action] Clear and Type [" + text + "] on element [" + elementLocator + "]");
            //clear the text field
            driver.findElement(elementLocator).clear();
            //then type
            driver.findElement(elementLocator).sendKeys(text);
        } catch (Exception e) {
            Logger.logMessage(e.getMessage());
            fail(e.getMessage());
        }
        return new MobileUIActions(driver);
    }


    public static String getText(AppiumDriver driver, By elementLocator) {
        locatingElement(driver, elementLocator);
        String text = driver.findElement(elementLocator).getText();

        return text;
    }

    public static Boolean isElementDisplayed(AppiumDriver driver, By elementLocator) {
        locatingElement(driver, elementLocator);
        return driver.findElement(elementLocator).isDisplayed();
    }
    private static void locatingElement(AppiumDriver driver, By elementLocator) {
        // Check if element is visible
        try {
            // Wait for the element to be visible
            new WebDriverWait(driver,Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
          //Scroll to the mobile element >> to be implemented later

            // Check if the element is displayed
            if (!driver.findElement(elementLocator).isDisplayed()) {
                Logger.logMessage("The element [" + elementLocator.toString() + "] is not Displayed");
                fail("The element [" + elementLocator.toString() + "] is not Displayed");
            }
        } catch (TimeoutException toe) {
            Logger.logMessage(toe.getMessage());
            fail(toe.getMessage());
        } catch (Exception e) {
            Logger.logMessage(e.getMessage());
            fail(e.getMessage());
        }
    }
}
