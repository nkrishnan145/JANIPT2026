package com.pageobjectmanager;

import com.pageobjectmodel.AddressPage;
import com.pageobjectmodel.CheckoutPage;
import com.pageobjectmodel.LoginPage;
import com.pageobjectmodel.SearchPage;
import com.utility.FileReaderManager;

public class PageObjectManager {
	
	private LoginPage loginPage;
    private FileReaderManager fileReader;
    private static PageObjectManager pageObjectManager;
    private SearchPage searchPage;
    private CheckoutPage checkoutpage;
    private AddressPage addresspage;

    public LoginPage getLoginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage();
        }
        return loginPage;
    }

    public FileReaderManager getFileReader() {
        if (fileReader == null) {
            fileReader = new FileReaderManager();
        }
        return fileReader;
    }


    public SearchPage getSearchPage() {
        if (searchPage == null) {
            searchPage = new SearchPage();
        }
        return searchPage;
    }
    
    public CheckoutPage getCheckOut() {
    	
    	if (checkoutpage == null) {
			checkoutpage = new CheckoutPage();
		}
		return checkoutpage;
    	
    }
    
    public AddressPage getAddress() {
    	if (addresspage == null) {
			addresspage = new AddressPage();
		}
		return addresspage;
    }

    public static PageObjectManager getPageObjectManager() {
    	if (pageObjectManager == null) {
    		pageObjectManager = new PageObjectManager();
    	}
    	return pageObjectManager;
    }
}
