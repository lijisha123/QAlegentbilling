package com.qalegendbilling.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qalegendbilling.utilities.TestHelperUtility;
import com.qalegendbilling.utilities.WaitUtility;
import com.qalegendbilling.utilities.pageUtility;

public class RolesPage extends TestHelperUtility{
	public WebDriver driver;
	public RolesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		}
	private final String _addRolesButton="//div[@class='box-tools']//i[@class='fa fa-plus']";
	@FindBy(xpath =_addRolesButton)
	private WebElement addRolesButton;
	private final String _editRolesButton="//a[@class='btn btn-xs btn-primary']";
	@FindBy(xpath =_editRolesButton)
	private WebElement editRolesButton;
	public final String _searchField="//input[@class='form-control input-sm']";

	@FindBy(xpath=_searchField)

	private WebElement searchField;

	public final String _deleteRoleButton="//tr[@class='even']//button[@class='btn btn-xs btn-danger delete_role_button']";

	@FindBy(xpath=_deleteRoleButton)

	private WebElement deleteRoleButton;

	public final String _popupButton="//button[text()='OK']";

	@FindBy(xpath=_popupButton)

	private WebElement popupButton;
	
public String getrolespagetitle() {
	String title=page.getPageTitle(driver);
	return title;
}
public AddRolesPage clickonaddrolesbutton() {
	page.clickOnElement(addRolesButton);
	return new AddRolesPage(driver);
}
public EditRolePage cliEditRolebutton() {
	wait.setHardWait();
	wait.waitForElementToBeVisible(driver,_editRolesButton,WaitUtility.LocatorType.Xpath);
	page.clickOnElement(editRolesButton);
	return new EditRolePage(driver);
}
String role="approver";
public void deleteroles() {
	wait.setHardWait();
	wait.waitForElementToBeVisible(driver,_editRolesButton,WaitUtility.LocatorType.Xpath);
	page.clickOnElement(searchField);
	page.enterText(searchField, role);
	page.clickOnElement(deleteRoleButton);
	page.clickOnElement(popupButton);
}
}
