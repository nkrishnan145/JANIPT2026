package com.pageobjectmodel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Base_Class;
import com.interfaceelements.AddressPageInterfaceElements;
import com.pageobjectmanager.PageObjectManager;

public class AddressPage extends Base_Class implements AddressPageInterfaceElements{
	
	@FindBy(xpath = name_xpath)
	private WebElement name;
	
	@FindBy(xpath = country_xpath)
	private WebElement country;
	
	@FindBy(xpath = city_xpath)
	private WebElement city;
	
	@FindBy(xpath = card_xpath)
	private WebElement card;
	
	@FindBy(xpath = month_xpath)
	private WebElement month;
	
	@FindBy(xpath = year_xpath)
	private WebElement year;
	
	@FindBy(xpath = purchase_xpath)
	private WebElement purchase;
	
	@FindBy(xpath = confirmation_xpath)
	private WebElement confirmation;
	
	public AddressPage() {
        PageFactory.initElements(driver, this);
    }
	
	public void placeOrder() throws InterruptedException{
		
		setExplicitWait(name, 10, "visibility");
		passInput(name, PageObjectManager.getPageObjectManager().getFileReader().getDataProperty("name"));
		passInput(country, PageObjectManager.getPageObjectManager().getFileReader().getDataProperty("country"));
		passInput(city, PageObjectManager.getPageObjectManager().getFileReader().getDataProperty("city"));
		setExplicitWait(name, 10, "visibility");
		passInput(card, PageObjectManager.getPageObjectManager().getFileReader().getDataProperty("card"));
		passInput(month, PageObjectManager.getPageObjectManager().getFileReader().getDataProperty("month"));
		passInput(year, PageObjectManager.getPageObjectManager().getFileReader().getDataProperty("year"));
		clickOnElememt(purchase);
		takeScreenshot(purchase_xpath);
		getText(confirmation);
	}

}
