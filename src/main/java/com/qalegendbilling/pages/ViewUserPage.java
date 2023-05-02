package com.qalegendbilling.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qalegendbilling.utilities.TestHelperUtility;

public class ViewUserPage extends TestHelperUtility{
	public WebDriver driver;
	public ViewUserPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	private final String _viewEmail="/html/body/div[2]/div[1]/section[2]/div/div/div/div[2]/p[1]";
	@FindBy(xpath =_viewEmail)
	private WebElement viewEmail;
	private final String _username="/html/body/div[2]/div[1]/section[2]/div/div/div/div[2]/p[1]";
	@FindBy(xpath =_username)
	private WebElement username;
	private final String _userdetails="//section[@class='content']//div[@class='row']";
	@FindBy(xpath =_userdetails)
	private WebElement userdetails;
	
	public void userdetailsdisplay() {
	  userdetails.isDisplayed();
	}
	
	
	

}
