package com.qalegendbilling.pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qalegendbilling.utilities.ExcelUtility;
import com.qalegendbilling.utilities.TestHelperUtility;

public class HomePage extends TestHelperUtility {
	public WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	private final String _endtourButton="//button[@class='btn btn-default btn-sm']";
	@FindBy(xpath =_endtourButton)
	private WebElement endtourButton;
	private final String _profileButton="//span[text()='efg pqr']";
	@FindBy(xpath =_profileButton)
	private WebElement profileButton;
	private final String _signoutButton="//a[text()='Sign Out']";
	@FindBy(xpath =_signoutButton)
	private WebElement signoutButton;
	private final String _usermanagementButton="//span[text()='User Management']";
	@FindBy(xpath =_usermanagementButton)
	private WebElement usermanagementButton;
	private final String _userButton="/html/body/div[2]/aside/section/ul/li[2]/ul/li[1]/a";
	@FindBy(xpath =_userButton)
	private WebElement userButton;
	private final String _rolesButton="/html/body/div[2]/aside/section/ul/li[2]/ul/li[2]/a";
	@FindBy(xpath =_rolesButton)
	private WebElement rolesButton;
	private final String _salescommission="/html/body/div[2]/aside/section/ul/li[2]/ul/li[3]/a";
	@FindBy(xpath =_salescommission)
	private WebElement salescommission;
	
	
	
	public void popupwindowhandle()
{
	endtourButton.click();
}
	public String gethomepagetitle()
	{
		String title=page.getPageTitle(driver);
		return title;
	}
	public void clickprofilebutton()
	{
		page.clickOnElement(profileButton);
	}
	public LoginPage clicksignoutbutton()
	{
		page.clickOnElement(signoutButton);
		return new LoginPage(driver);
	}
	public void clickusermanagementbutton()
	{
		page.clickOnElement(usermanagementButton);
	}
	public boolean displayuserbutton()
	{
		//String user1=page.getElementText(userButton);
		boolean status= userButton.isDisplayed();
		return status;
	
	}
	public boolean displayrolesbutton()
	{
		//String roles1=page.getElementText(rolesButton);
		boolean status1= rolesButton.isDisplayed();
		return status1;
		
	}
	public boolean displaysalesmanagementbutton()
	{
		//String sales1=page.getElementText(salescommission);
		boolean status2= salescommission.isDisplayed();
		return status2;
	}
	public UserPage clickuserbutton() {
		page.clickOnElement(userButton);
		return new UserPage(driver);
		
	}
}
