package com.qalegendbilling.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.qalegendbilling.utilities.TestHelperUtility;

public class EditRolePage extends TestHelperUtility {
	public WebDriver driver;
	public EditRolePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		}
	String exptitle="Edit Role - QAlegend";
	public String geteditrolestitle() {
		String title=page.getPageTitle(driver);
		return title;
		}
	public String exptitle() {
		return exptitle;
	}
	
}

