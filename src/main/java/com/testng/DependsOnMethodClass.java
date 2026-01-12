package com.testng;
import org.testng.annotations.Test;

public class DependsOnMethodClass {

    @Test(expectedExceptions = ArithmeticException.class)
    private void loginPage() {
        int i = 10;
        System.out.println(i / 0);
        System.out.println("LOGIN PAGE");
    }

    @Test
    private void searchPage() {
        System.out.println("SEARCH PAGE");
    }

    @Test(dependsOnMethods = {"loginPage", "searchPage"})
    private void addtoCartPage() {
        System.out.println("ADDTOCART PAGE");
    }
}