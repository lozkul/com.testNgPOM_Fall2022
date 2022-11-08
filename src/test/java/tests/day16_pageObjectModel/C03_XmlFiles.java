package tests.day16_pageObjectModel;

import org.testng.annotations.Test;

public class C03_XmlFiles {
    @Test
    public void test06(){
        System.out.println("test 6 çalıştı");
    }

    @Test(groups = "smoke")
    public void test07(){
        System.out.println("test 7 çalıştı");
    } @Test(groups = "regression")
    public void test08(){
        System.out.println("test 8 çalıştı");
    } @Test
    public void test09(){
        System.out.println("test 9 çalıştı");
    } @Test
    public void test10(){
        System.out.println("test 10 çalıştı");
    }
}
