package tests.practice;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AutomationExercisePage;
import utilities.ConfigReader;
import utilities.Driver;

public class AutomationExercise5 {

    /*
    1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Signup / Login' button
5. Verify 'New User Signup!' is visible
6. Enter name and already registered email address
7. Click 'Signup' button
8. Verify error 'Email Address already exist!' is visible
     */

    @Test
    public void test01(){
        Driver.getDriver().get(ConfigReader.getProperty("autoUrl"));
        SoftAssert softAssert=new SoftAssert();
        String expectedUrl= ConfigReader.getProperty("autoUrl");
        String actualUrl = Driver.getDriver().getCurrentUrl();

        softAssert.assertEquals(actualUrl,expectedUrl, "you are not at home page");

        AutomationExercisePage automationExercisePage=new AutomationExercisePage();
        automationExercisePage.signUpLinki.click();


    }



}
