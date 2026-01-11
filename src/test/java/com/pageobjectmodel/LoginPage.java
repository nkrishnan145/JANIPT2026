package com.pageobjectmodel;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.base.Base_Class;
import com.interfaceelements.LoginPageInterfaceElements;
import com.pageobjectmanager.PageObjectManager;

public class LoginPage extends Base_Class implements LoginPageInterfaceElements {

    @FindBy(xpath = login_xpath)
    private WebElement login;

    @FindBy(id = userName_id)
    private WebElement username;

    @FindBy(id = passWord_id)
    private WebElement password;

    @FindBy(xpath = signin_xpath)
    private WebElement signin;

    @FindBy(xpath = title_xpath)
    private WebElement title;

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

	public void validLogin() throws InterruptedException {
		clickOnElememt(login);
		setExplicitWait(username, 10, "visibility");
		passInput(username, PageObjectManager.getPageObjectManager().getFileReader().getDataProperty("username"));
		passInput(password, PageObjectManager.getPageObjectManager().getFileReader().getDataProperty("password"));
		setExplicitWait(signin, 30, "click");
		clickOnElememt(signin);
		setExplicitWait(title, 30, "visibility");
		getText(title);
		setExplicitWait(title, 30, "visibility");
		takeScreenshot(title_xpath);
		
	}
	

}
