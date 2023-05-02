package com.qalegendbilling.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qalegendbilling.utilities.TestHelperUtility;
import com.qalegendbilling.utilities.pageUtility;

public class AddUserPage extends TestHelperUtility{
	public WebDriver driver;

	public AddUserPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	private final String _saveButton = "//button[@id='submit_user_button']";
	@FindBy(xpath = _saveButton)
	private WebElement saveButton;
	private final String _firstNamevalidation = "//label[@id='first_name-error']";
	@FindBy(xpath = _firstNamevalidation)
	private WebElement firstNamevalidation;
	private final String _emailvalidation = "//label[@id='email-error']";
	@FindBy(xpath = _emailvalidation)
	private WebElement emailvalidation;
	private final String _passwordvalidation = "//label[@id='password-error']";
	@FindBy(xpath = _passwordvalidation)
	private WebElement passwordvalidation;
	private final String _confirmpasswordvalidation = "//label[@id='confirm_password-error']";
	@FindBy(xpath = _confirmpasswordvalidation)
	private WebElement confirmpasswordvalidation;
	private final String _surname = "//input[@id='surname']";
	@FindBy(xpath = _surname)
	private WebElement surname;
	private final String _firstname = "//input[@id='first_name']";
	@FindBy(xpath = _firstname)
	private WebElement firstname;
	private final String _lastname = "//input[@id='last_name']";
	@FindBy(xpath = _lastname)
	private WebElement lastname;
	private final String _email = "//input[@id='email']";
	@FindBy(xpath = _email)
	private WebElement email;
	private final String _password = "//input[@id='password']";
	@FindBy(xpath = _password)
	private WebElement password;
	private final String _confirmpassword = "//input[@id='confirm_password']";
	@FindBy(xpath = _confirmpassword)
	private WebElement confirmpassword;
	
	public void clicksavebutton() {
		page.clickOnElement(saveButton);
}
	public String validation(String errMsg) {
		page.getElementText(firstNamevalidation);
		page.getElementText(emailvalidation);
		page.getElementText(passwordvalidation);
		page.getElementText(confirmpasswordvalidation);
		return errMsg;
		}
	public void scrolldown() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
	}
	public void addnewuser(String fname,String lname,String useremail,String password1,String sname) {
	page.enterText(surname,sname);
	page.enterText(firstname,fname);
	page.enterText(lastname,lname);
	page.enterText(email,useremail);
	page.enterText(password,password1);
	page.enterText(confirmpassword,password1);
	}
	
}