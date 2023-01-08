package tests.iOSTests;

import Screens.DailyTasksScreen;
import com.aventstack.extentreports.App;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;
import utilities.AppiumUtils;
import utilities.TestngListener;

import java.net.MalformedURLException;
import java.net.URL;


@Listeners(TestngListener.class)
public class TestiOS   {
    public AppiumDriver driver;
    private DailyTasksScreen dailyTasksScreen ;


    @Test
    public void createAnyTimeTaskAndVerifyCreatedSuccessfully() {
        dailyTasksScreen =  new DailyTasksScreen(driver);
        dailyTasksScreen.clickOnAddNewTask();
        dailyTasksScreen.clickAnyTime();
        dailyTasksScreen.fillTaskTitle("First Automated Task 1");
        dailyTasksScreen.fillTaskDesc("First Automated Task Desc");
    }









    @BeforeMethod
    public void setUp() throws MalformedURLException {
        AppiumUtils.startAppiumServer("127.0.0.1",4723);
      //  AppiumUtils.stopServer();
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "iOS");
        capabilities.setCapability("platformVersion", "16.0");
        capabilities.setCapability("deviceName", "iPhone 14 Pro");
        capabilities.setCapability("automationName", "XCUITest");
        capabilities.setCapability("app",
                System.getProperty("user.dir") + "/apps/DailyCheck.zip");
       // driver = new AppiumDriver(new URL("http://localhost:4723/wd/hub"), capabilities);
        driver = new AppiumDriver(new URL("http://localhost:4723"), capabilities);

    }




/*
    @BeforeMethod
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "iOS");
        capabilities.setCapability("platformVersion", "15.6.1");
        capabilities.setCapability("deviceName", "iPhone");
        capabilities.setCapability("udid", "00008020-0016515E21E2002E");
        capabilities.setCapability("app",
                System.getProperty("user.dir") + "/apps/DailyCheck.zip");
        driver = new AppiumDriver(new URL("http://localhost:4723/wd/hub"), capabilities);
    }


 */



    @AfterMethod
    public void tearDown() throws MalformedURLException {
        AppiumUtils.stopServer();
     //  driver.quit();
    }





}
