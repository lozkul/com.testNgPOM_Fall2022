package tests.day15_pageObjectModel;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.Driver;

public class C04_PagesKullanimi {
    //amazon anasayfaya gidin
    //3 test metodu oluşturun
    //Nutella, Java, Bicycle için arama yapın
    //sonuçların arama yaptığımız kelimeleri içerip içermediğini test edin

    AmazonPage amazonPage = new AmazonPage();

    @Test
    public void test01() {
        Driver.getDriver().get("https://www.amazon.com");


        amazonPage.aramaKutusu.sendKeys("Nutella" + Keys.ENTER);
        String actualSonucYazisi = amazonPage.aramaSonucElementi.getText();
        String expectedKelime = "Nutella";

        Assert.assertTrue(actualSonucYazisi.contains(expectedKelime));

    }

    @Test(dependsOnMethods = "test01")
    public void test02() {

        amazonPage.aramaKutusu.clear();
        amazonPage.aramaKutusu.sendKeys("Java" + Keys.ENTER);
        String actualSonucYazisi = amazonPage.aramaSonucElementi.getText();
        String expectedKelime = "Java";

        Assert.assertTrue(actualSonucYazisi.contains(expectedKelime));
    }

    @Test(dependsOnMethods = "test02")
    public void test03() {

        amazonPage.aramaKutusu.clear();
        amazonPage.aramaKutusu.sendKeys("Bicycle" + Keys.ENTER);
        String actualSonucYazisi = amazonPage.aramaSonucElementi.getText();
        String expectedKelime = "Bicycle";

        Assert.assertTrue(actualSonucYazisi.contains(expectedKelime));

        Driver.closeDriver();
    }
}
