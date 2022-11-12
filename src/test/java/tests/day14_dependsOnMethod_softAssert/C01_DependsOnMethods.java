package tests.day14_dependsOnMethod_softAssert;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;
import utilities.TestBaseClass;

public class C01_DependsOnMethods extends TestBaseClass {

// Uc test method'u olusturun
// 1. testin ismi amazon testi olsun,
//    amazon anasayfasina gidip, amazona gittigimizi test edin
// 2. testin ismi nutella testi olsun
//    nutella icin arama yapip, sonuclarin nutella icerdigini test edin
// 3. testin ismi arama sonuc testi olsun
//    sonuc sayisinin 100'den fazla oldugunu test edin

 /*
      DependsOnMethods="BagliOlunanTestAdi"
      iki test method'unu birbirine baglar
      Bu sekilde bagli olunan test failed olursa,
      bagli olan test ignore edilir, hic calismaz
     */

    @Test(priority = 10)
    public void amazonTesti(){

        driver.get("https://www.amazon.com");
        String expectedURL = "amazon.com";
        String actualURL = driver.getCurrentUrl();
        Assert.assertTrue(actualURL.contains(expectedURL));


    }
    @Test(priority = 11,dependsOnMethods = "amazonTesti")
    public void nutellaTesti(){
        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);
        WebElement sonucYaziElementi = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String expectedKelime="Nutella";
        String actualSonucYazisi=sonucYaziElementi.getText();
        Assert.assertTrue(actualSonucYazisi.contains(expectedKelime));


    }
    @Test(priority = 12,dependsOnMethods = "nutellaTesti")
    public void aramaSonucTesti(){

        WebElement sonucYaziElementi = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String actualSonucYazisi=sonucYaziElementi.getText();
        int indexOf = actualSonucYazisi.indexOf("of");
        int indexresults= actualSonucYazisi.indexOf("result");
        String sonucSayisiStr= actualSonucYazisi.substring(indexOf+3,indexresults-1);
        Integer sonucSayisiInt=Integer.parseInt(sonucSayisiStr);
        Integer expectedMinSonucSayisi=100;
        Assert.assertTrue(sonucSayisiInt>expectedMinSonucSayisi);

    }




}
