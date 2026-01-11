package com.testng;

import org.testng.annotations.Test;

import com.base.Base_Class;

import org.testng.annotations.Ignore;

public class CrossBrowserTesting extends Base_Class {

    @Test(enabled = false)
    public void firefoxBrowser() {
        launchBrowser("firefox");
        launchUrl("https://www.google.com/");
        System.out.println("BROWSER ID : " + Thread.currentThread().getId());
        browserTerminated();
    }

    @Test
    public void chromeBrowser() {
        launchBrowser("chrome");
        launchUrl("https://www.google.com/");
        System.out.println("BROWSER ID : " + Thread.currentThread().getId());
        browserTerminated();
    }

    @Ignore
    @Test
    public void edgeBrowser() {
        launchBrowser("edge");
        launchUrl("https://www.google.com/");
        System.out.println("BROWSER ID : " + Thread.currentThread().getId());
        browserTerminated();
    }
}