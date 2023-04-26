package com.qalegendbilling.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.qalegendbilling.utilities.TestHelperUtility;

public class UserPage extends TestHelperUtility {
	public WebDriver driver;
	public UserPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public String getuserpagetitle()
	{
		String title=page.getPageTitle(driver);
				return title;
	}
}
