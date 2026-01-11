package com.pageobjectmodel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Base_Class;
import com.interfaceelements.CheckoutPageInterfaceElements;
import com.interfaceelements.SearchPageInterfaceElements;

public class CheckoutPage extends Base_Class implements CheckoutPageInterfaceElements{
	
	@FindBy(id = checkout_id)
	private WebElement checkout;
	
	@FindBy(xpath = order_xpath)
	private WebElement order;

	
	public CheckoutPage() {
		PageFactory.initElements(driver, this);
	}
	
public void checkoutProduct() {
	
	clickOnElememt(checkout);
	takeScreenshot(checkout_id);
	setImplicitWait(10);
	clickOnElememt(order);
}
}

