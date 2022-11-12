package tests.day18_testNgReports_parallelTests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.util.List;

public class C03_RaporluTestOlusturma extends TestBaseRapor {

    @Test
    public void test01(){
        extentTest=extentReports.createTest("Dropdown Testi", "Dropdown'da istenen element olduğunu test etme");


        // amazon anasayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        extentTest.info("amazon anasayfaya gidildi");
        // arama kutusunun yanindaki dropdown menuyu locate edin
        // dropdown menudeki tum options listesini olusturup
        AmazonPage amazonPage=new AmazonPage();
        Select select=new Select(amazonPage.dropdownMenu);
        extentTest.info("dropdown menu locate edildi");
        List<WebElement> optionsElementList= select.getOptions();

        // menude Electronics basligi oldugunu test edin



        List<String> optionsStringListesi= ReusableMethods.getElementsText(optionsElementList);
        extentTest.info("dropdown menudeki tum optionlar bir list olarak kaydedildi");

        Assert.assertTrue(optionsStringListesi.contains(ConfigReader.getProperty("dropdownArananOption")));
        extentTest.pass("dropdown menude aranan kelime olduğu test edildi");
        Driver.closeDriver();
    }


}
