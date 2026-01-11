package com.pageobjectmodel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Base_Class;
import com.interfaceelements.SearchPageInterfaceElements;

public class SearchPage extends Base_Class implements SearchPageInterfaceElements{

	@FindBy(linkText = laptop_linkText)
    private WebElement laptop;
	
	@FindBy(xpath = sony_xpath)
	private WebElement sony;
	
	@FindBy(xpath = cart_xpath)
	private WebElement cart;

	public SearchPage() {
		 PageFactory.initElements(driver, this);
	}

public void searchProduct() throws InterruptedException {

	clickOnElememt(laptop);
	clickOnElememt(sony);
	setExplicitWait(cart, 10, "click");
	clickOnElememt(cart);
	setExplicitWait(null, 10,"alert");
	handleAlert("accept", null);
}


}
