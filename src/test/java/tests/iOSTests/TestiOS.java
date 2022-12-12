package tests.iOSTests;

import Screens.DailyTasksScreen;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;
import tests.utilities.TestngListener;
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
        dailyTasksScreen.fillTaskTitle("First Automated Task");
        dailyTasksScreen.fillTaskDesc("First Automated Task Desc");
        dailyTasksScreen.clickSave();
    }









    @BeforeMethod
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "iOS");
        capabilities.setCapability("platformVersion", "14.4");
        capabilities.setCapability("deviceName", "iPhone 12 Pro");
        capabilities.setCapability("app",
                System.getProperty("user.dir") + "/apps/DailyCheck.zip");
        driver = new AppiumDriver(new URL("http://localhost:4723/wd/hub"), capabilities);
    }

    @AfterMethod
    public void tearDown() throws MalformedURLException {
     //  driver.quit();
    }





}
