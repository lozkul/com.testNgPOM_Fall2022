package tests.day18_testNgReports_parallelTests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.MyCoursedemyPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class C04_SmokeTestRaporlu extends TestBaseRapor {




    MyCoursedemyPage myCoursedemyPage=new MyCoursedemyPage();

    @BeforeMethod
    public void setup(){
        Driver.getDriver().get(ConfigReader.getProperty("myUrl"));
        ReusableMethods.bekle(3);

    }
    @Test
    public void yanlisKullaniciTesti(){
        myCoursedemyPage.cookies.click();
        myCoursedemyPage.loginLinki.click();
        extentTest=extentReports.createTest("yanlis kullaici adi", "yanlis kullaici adi ile giriş yapılamaz");
        myCoursedemyPage.emailKutusu.sendKeys(ConfigReader.getProperty("myYanlisEmail"));
        extentTest.info("kullanıcı adı olarak yanlış email yazıldı");
        myCoursedemyPage.passwordKutusu.sendKeys(ConfigReader.getProperty("myGecerliPassword"));
        extentTest.info("password olarak geçerli password yazıldı");
        myCoursedemyPage.loginButonu.click();
        extentTest.info("login butonuna basıldı");
        Assert.assertTrue(myCoursedemyPage.loginLinki.isEnabled());
        extentTest.pass("giriş yapılamadığı test edildi");
    }
    @Test
    public void yanlisPasswordTesti(){
        myCoursedemyPage.cookies.click();
        myCoursedemyPage.loginLinki.click();
        extentTest=extentReports.createTest("yanlis password", "yanlis password ile giriş yapılamaz");
        myCoursedemyPage.emailKutusu.sendKeys(ConfigReader.getProperty("myGecerliEmail"));
        extentTest.info("kullanıcı adı olarak geçerli email yazıldı");
        myCoursedemyPage.passwordKutusu.sendKeys(ConfigReader.getProperty("myYanlisPassword"));
        extentTest.info("password olarak yanlış password yazıldı");
        myCoursedemyPage.loginButonu.click();
        extentTest.info("login butonuna basıldı");
        Assert.assertTrue(myCoursedemyPage.loginLinki.isEnabled());
        extentTest.pass("giriş yapılamadığı test edildi");
    }
    @Test(priority = 3)
    public void yanlisEmailVePasswordTesti(){
        myCoursedemyPage.cookies.click();
        myCoursedemyPage.loginLinki.click();
        extentTest=extentReports.createTest("yanlis email ve password", "yanlis email ve password ile giriş yapılamaz");
        myCoursedemyPage.emailKutusu.sendKeys(ConfigReader.getProperty("myYanlisEmail"));
        extentTest.info("kullanıcı adı olarak yanlış email yazıldı");
        myCoursedemyPage.passwordKutusu.sendKeys(ConfigReader.getProperty("myYanlisPassword"));
        extentTest.info("password olarak yanlış password yazıldı");
        myCoursedemyPage.loginButonu.click();
        extentTest.info("login butonuna basıldı");
        Assert.assertTrue(myCoursedemyPage.loginLinki.isEnabled());
        extentTest.pass("giriş yapılamadığı test edildi");
    }

    @AfterClass
    public void teardown(){
        Driver.closeDriver();
    }




}
