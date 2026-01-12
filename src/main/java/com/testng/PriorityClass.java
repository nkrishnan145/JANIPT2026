package com.testng;
import org.testng.annotations.Test;

public class PriorityClass {

    @Test(priority = -1)
    private void loginPage() {
        System.out.println("LOGIN PAGE");
    }

    @Test(priority = 0)
    private void searchPage() {
        System.out.println("SEARCH PAGE");
    }

    @Test(priority = 1)
    private void addtoCartPage() {
        System.out.println("ADDTOCART PAGE");
    }
}