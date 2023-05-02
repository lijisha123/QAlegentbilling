package com.qalegendbilling.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.qalegendbilling.utilities.TestHelperUtility;

public class AddRolesPage extends TestHelperUtility {
	public WebDriver driver;
	public AddRolesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		}
	public String getaddrolespagetitle() {
		String title=page.getPageTitle(driver);
		return title;
	}
}
