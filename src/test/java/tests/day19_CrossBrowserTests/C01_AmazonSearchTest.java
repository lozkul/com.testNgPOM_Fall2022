package tests.day19_CrossBrowserTests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.ReusableMethods;
import utilities.TestBaseCross;

public class C01_AmazonSearchTest extends TestBaseCross {

    @Test
    public void test01(){

        driver.get(ConfigReader.getProperty("amazonUrl"));

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella" + Keys.ENTER);

        String actualSonucYaisi=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']")).getText();
        String expectedKelime="Nutella";
        Assert.assertTrue(actualSonucYaisi.contains(expectedKelime));
        ReusableMethods.bekle(10);
    }



}
