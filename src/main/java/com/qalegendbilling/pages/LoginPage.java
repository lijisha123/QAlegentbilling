package com.qalegendbilling.pages;

import java.util.Iterator;
import java.util.Set;

import javax.management.loading.PrivateClassLoader;

import org.apache.xmlbeans.impl.xb.xmlschema.IdAttribute;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v105.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.yaml.snakeyaml.events.Event.ID;

import com.qalegendbilling.utilities.TestHelperUtility;
import com.qalegendbilling.utilities.pageUtility;

public class LoginPage extends TestHelperUtility{
	public WebDriver driver;
	public LoginPage(WebDriver driver){ //initializing pagefactory (constructor)
	this.driver=driver;
	PageFactory.initElements(driver,this);
	}
	private final String _username="username";
	@FindBy(id=_username)
	private WebElement username;
	private final String _password="password";
	@FindBy(id=_password)
	private WebElement password;
	private final String _loginButton="//button[@class='btn btn-primary']";
	@FindBy(xpath =_loginButton)
	private WebElement loginButton;
	private final String _errorMessage="//strong[text()='These credentials do not match our records.']";
	@FindBy(xpath =_errorMessage)
	private WebElement errorMessage;
	private final String _remembermecheckBox="//input[@name='remember']";
	@FindBy(xpath =_remembermecheckBox)
	private WebElement remembermecheckBox;
	private final String _forgotPassword="//a[@class='btn btn-link']";
	@FindBy(xpath =_forgotPassword)
	private WebElement forgotPassword;
	
	
	public String getloginpagetitle()
	{
		String title=page.getPageTitle(driver);
		return title;
}
	public void enterusername(String usrname) {
		page.enterText(username,usrname);
		}
	public void enterpassword(String pasword) {
		page.enterText(password,pasword);
		}
	public HomePage clickLoginButton() {
		page.clickOnElement(loginButton);
		return new HomePage(driver);
	}
	public String geterrormessage() {
		String message=page.getElementText(errorMessage);
		return message;
	}
	public void remembermebox() {
		boolean statusBeforeclick = remembermecheckBox.isSelected();
		page.clickOnElement(remembermecheckBox);
		}
	public ResetPasswordPage clickonforgotpassword() {
		page.clickOnElement(forgotPassword);
		return new ResetPasswordPage(driver);
		}
}

	



	
		
