package tests.day14_dependsOnMethod_softAssert;

import org.testng.annotations.Test;

public class C02_DependsOnMethods {
    /*
          iki test method'u dependsOnMethods ile birbirine baglandiysa
          sadece baglanan method'u calistirmak isterseniz,
          dependsOnmethods ozelligi tanimli oldugundan once
          bagli olunan method'u calistirir,
          o test passed olursa bagli olan test'i de calistirir.

          Ancak bagli olan testler ikiden fazla ise
          2.testten sonraki test method'larini calistirmak isterseniz
          "no tests found" uyari verir ve hic bir testi calistirmaz
         */
    @Test
    public void test01(){
        System.out.println("1. test çalıştı");
    }
    @Test(dependsOnMethods = "test01")
    public void test02(){
        System.out.println("2. test çalıştı");
    }
    @Test(dependsOnMethods = "test02")
    public void test03(){
        System.out.println("3. test çalıştı");
    }


}
