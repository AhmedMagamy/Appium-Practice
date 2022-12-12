package Screens;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import utilities.MobileUIActions;

public class TasksAndroid {

    private AppiumDriver driver ;

    @AndroidFindBy(accessibility = "")

    By plusBtn =  AppiumBy.accessibilityId("plus.circle");
    By anyTimeBtn =  AppiumBy.accessibilityId("Anytime");

    By saveBtn = AppiumBy.accessibilityId("Save");
    By taskTitleTxtField= AppiumBy.xpath("//XCUIElementTypeApplication[@name=\"DailyCheck\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField");
    By taskDescTxtField= AppiumBy.xpath("//XCUIElementTypeApplication[@name=\"DailyCheck\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField");


    public TasksAndroid(AppiumDriver driver) {
        this.driver = driver;
    }

    public void clickOnAddNewTask(){
        MobileUIActions.click(driver,plusBtn);
    }
    public void clickAnyTime(){
        MobileUIActions.click(driver,anyTimeBtn);
    }

    public void fillTaskTitle(String txt){
        MobileUIActions.type(driver,taskTitleTxtField,txt);
    }
    public void fillTaskDesc(String txt){
        MobileUIActions.type(driver,taskDescTxtField,txt);
    }
    public void clickSave(){
        MobileUIActions.click(driver,saveBtn);
    }

}

