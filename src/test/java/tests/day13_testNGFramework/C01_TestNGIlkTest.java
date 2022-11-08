package tests.day13_testNGFramework;


import org.testng.annotations.Test;
import utilities.TestBase;

public class C01_TestNGIlkTest extends TestBase {
    @Test(priority = 10)
    public void ilkTest(){

        driver.get("https://www.amazon.com");
    }
    @Test(priority = 11)
    public void ikinciTest(){

        driver.get("https://www.Youtube.com");
    }
    @Test(priority = 12)
    public void ucuncuTest(){

        driver.get("https://www.wisequarter.com");
    }

}

