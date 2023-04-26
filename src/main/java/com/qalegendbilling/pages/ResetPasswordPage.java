package com.qalegendbilling.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qalegendbilling.utilities.RandomUtility;
import com.qalegendbilling.utilities.TestHelperUtility;

public class ResetPasswordPage extends TestHelperUtility {
	public WebDriver driver;
	public ResetPasswordPage(WebDriver driver){ //initializing pagefactory (constructor)
	this.driver=driver;
	PageFactory.initElements(driver,this);
	}
	private final String _resetemail="//input[@id='email']";
	@FindBy(xpath = _resetemail)
	private WebElement resetemail;
	private final String _setpassword="//button[@class='btn btn-primary']";
	@FindBy(xpath = _setpassword)
	private WebElement setpassword;
	private final String _errormessage="//span[@class='help-block']/strong";
	@FindBy(xpath =_errormessage)
	private WebElement errormessage;
	public void enteremail(String email){
		//String emailnew=RandomUtility.getRandomEmail();
		page.enterText(resetemail,email);
		
		
	}
	public ResetPasswordPage clickonsetpasswordlink() {
		page.clickOnElement(setpassword);
		return new ResetPasswordPage(driver);
	}
	public String errormessagetext() {
		String errormsg=page.getElementText(errormessage);
		return errormsg;
	}

	}


