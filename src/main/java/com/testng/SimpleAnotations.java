package com.testng;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

public class SimpleAnotations {

    @BeforeSuite
    public void propertySetting() {
        System.out.println("PROPERTY SETTING");
    }

    @BeforeTest
    public void browserLaunch() {
        System.out.println("BROWSER LAUNCH");
    }

    @BeforeClass
    public void urlLaunch() {
        System.out.println("URL LAUNCH");
    }

    @BeforeMethod
    public void login() {
        System.out.println("LOGIN");
    }

    @Test
    public void men() {
        System.out.println("MEN");        
    }
    
    @Test
    public void women() {
        System.out.println("WOMEN");
    }

    @Test
    public void kids() {
        System.out.println("KIDS");
    }

    @AfterMethod
    public void logout() {
        System.out.println("LOGOUT");
    }

    @AfterClass
    public void screenshot() {
        System.out.println("SCREEN SHORT");
    }

    @AfterTest
    public void browserClose() {
        System.out.println("BROWSER CLOSE");
    }

    @AfterSuite
    public void terminateBrowser() {
        System.out.println("TERMINATE BROWSER");
    }
}

