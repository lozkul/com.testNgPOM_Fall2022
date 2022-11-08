package tests.day15_pageObjectModel;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.Driver;

public class C03_PagesKullanimi {

    //amazon anasayfaya gidin
    //nutella için arama yapın
    //sonuçların nutella içerdiğini test edin

    @Test
    public void tets01(){
        Driver.getDriver().get("https://www.amazon.com");
        AmazonPage amazonPage=new AmazonPage();

        amazonPage.aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);
        String actualSonucYazisi=amazonPage.aramaSonucElementi.getText();
        String expectedKelime="Nutella";

        Assert.assertTrue(actualSonucYazisi.contains(expectedKelime));

        Driver.closeDriver();

    }

}
