package com.runnerpackage;

import java.awt.AWTException;
import com.base.Base_Class;
import com.pageobjectmanager.PageObjectManager;



public class TestRunner extends Base_Class {
    public static void main(String[] args) throws AWTException, InterruptedException {
    	
        launchBrowser(PageObjectManager.getPageObjectManager().getFileReader().getDataProperty("browser"));
        launchUrl(PageObjectManager.getPageObjectManager().getFileReader().getDataProperty("url"));
        PageObjectManager.getPageObjectManager().getLoginPage().validLogin();
        PageObjectManager.getPageObjectManager().getSearchPage().searchProduct();
        PageObjectManager.getPageObjectManager().getCheckOut().checkoutProduct();
        PageObjectManager.getPageObjectManager().getAddress().placeOrder();

    }
}



