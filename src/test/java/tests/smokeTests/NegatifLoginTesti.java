package tests.smokeTests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.MyCoursedemyPage;
import utilities.ConfigReader;
import utilities.Driver;

public class NegatifLoginTesti {
    // Mycoursedemy anasayfasina gidin
// login linkine basin
// uc farkli test method'u ile yanlis bilgilerle giris yapilamadigini test edin
// 1- yanlis kullanici adi, gecerli password
// 2- gecerli kullanici adi, yanlis password
// 3- yanlis kullanici adi, yanlis password
// Login butonuna basarak login olmaya calisin
// Basarili olarak giris yapilamadigini test edin



    MyCoursedemyPage myCoursedemyPage=new MyCoursedemyPage();

    @BeforeClass
    public void setup(){
    Driver.getDriver().get(ConfigReader.getProperty("myUrl"));
        myCoursedemyPage.cookies.click();
        myCoursedemyPage.loginLinki.click();
    }
    @Test(priority = 1)
    public void yanlisKullaniciTesti(){
    myCoursedemyPage.emailKutusu.sendKeys(ConfigReader.getProperty("myYanlisEmail"));
    myCoursedemyPage.passwordKutusu.sendKeys(ConfigReader.getProperty("myGecerliPassword"));
    myCoursedemyPage.loginButonu.click();
    Assert.assertTrue(myCoursedemyPage.loginLinki.isEnabled());
    }
    @Test(priority = 2)
    public void yanlisPasswordTesti(){
    myCoursedemyPage.emailKutusu.sendKeys(ConfigReader.getProperty("myGecerliEmail"));
    myCoursedemyPage.passwordKutusu.sendKeys(ConfigReader.getProperty("myYanlisPassword"));
    myCoursedemyPage.loginButonu.click();
    Assert.assertTrue(myCoursedemyPage.loginLinki.isEnabled());
    }
    @Test(priority = 3)
    public void yanlisEmailVePasswordTesti(){
    myCoursedemyPage.emailKutusu.sendKeys(ConfigReader.getProperty("myYanlisEmail"));
    myCoursedemyPage.passwordKutusu.sendKeys(ConfigReader.getProperty("myYanlisPassword"));
    myCoursedemyPage.loginButonu.click();
    Assert.assertTrue(myCoursedemyPage.loginLinki.isEnabled());
    }

    @AfterClass
    public void teardown(){
        Driver.closeDriver();
    }


}
