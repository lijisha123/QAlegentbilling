package com.qalegendbilling.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qalegendbilling.utilities.TestHelperUtility;

public class EditUserPage extends TestHelperUtility {
	public WebDriver driver;

	public EditUserPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	private final String _lastname = "//input[@id='last_name']";
	@FindBy(xpath = _lastname)
	private WebElement lastname;
 public String edituserpagetitle() {
	 String title=page.getPageTitle(driver);
	 return title;
 }
 public void edituser(String lname) {
		page.enterText(lastname,lname);
		
}
 
}