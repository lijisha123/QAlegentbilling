package com.qalegendbilling.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qalegendbilling.utilities.TestHelperUtility;

public class AddRolesPage extends TestHelperUtility {
	public WebDriver driver;
	public AddRolesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		}
	private final String _roleNameField="name";
	@FindBy(id=_roleNameField)
	private WebElement roleNameField;
	private final String _saveButton="//button[@class='btn btn-primary pull-right']";
	@FindBy(xpath=_saveButton)
	private WebElement saveButton;
	private final String _selectallUser = "//ins[@class='iCheck-helper'][1]";
	@FindBy(xpath = _selectallUser)
	private WebElement selectallUser;
	public String getaddrolespagetitle() {
		String title=page.getPageTitle(driver);
		return title;
	}
	String rolename="approver level 1";
	public void clickoncheckbox() {
		page.enterText(roleNameField, rolename);
		selectallUser.isSelected();
	}
	public void clicksavebutton() {
		page.clickOnElement(saveButton);
	}
	
}
