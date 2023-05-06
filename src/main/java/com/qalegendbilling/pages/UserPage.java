package com.qalegendbilling.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.qalegendbilling.utilities.TestHelperUtility;
import com.qalegendbilling.utilities.WaitUtility;

public class UserPage extends TestHelperUtility {
	public WebDriver driver;
	public UserPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	private final String _searchInput="//input[@class='form-control input-sm']";
	@FindBy(xpath =_searchInput)
	private WebElement searchInput;
	private final String _usersTable="users_table";
	@FindBy(id =_usersTable)
	private WebElement usersTable;
	private final String _searchErrormessage="//td[text()='No matching records found']";
	@FindBy(xpath =_searchErrormessage)
	private WebElement searchErrormessage;
	private final String _rowElements="//table[@id='users_table']//tr";
	@FindBy(xpath = _rowElements)
	private WebElement rowElements; 
	private final String _columnElements="//table[@id='users_table']//tr//td";
	@FindBy(xpath =_columnElements)
	private WebElement columnElements;
	private final String _addUserbutton="//a[@class='btn btn-block btn-primary']";
	@FindBy(xpath =_addUserbutton)
	private WebElement addUserbutton;
	private final String _addUsername="//td[@class='sorting_1']";
	@FindBy(xpath =_addUsername)
	private WebElement addUsername;
	private final String _editButton="//a[@class='btn btn-xs btn-primary']";
	@FindBy(xpath =_editButton)
	private WebElement editButton;
	private final String _deleteButton="//button[@class='btn btn-xs btn-danger delete_user_button']";
	@FindBy(xpath =_deleteButton)
	private WebElement deleteButton;
	private final String _deleteokAlert="//div[@class='swal-button-container']//button[text()='OK']";
	@FindBy(xpath =_deleteokAlert)
	private WebElement deleteokAlert;
	private final String _viewButton="//a[@class='btn btn-xs btn-info']";
	@FindBy(xpath =_viewButton)
	private WebElement viewButton;
	public String getuserpagetitle()
	{
		String title=page.getPageTitle(driver);
				return title;
	}
	public void searchuser(String email)
	{
	//page.enterText(searchInput, searchuser1);
		searchInput.click();
		searchInput.sendKeys(email);
	}
	public void pressenter() throws AWTException {
	Robot r = new Robot();
	r.keyPress(KeyEvent.VK_ENTER);
	r.keyRelease(KeyEvent.VK_ENTER);
	}
	public String errormessage() {
		String errMsg=page.getElementText(searchErrormessage);
		return errMsg;
		}
	public void getTableContent(String email) {
	        wait.setHardWait();
	        wait.waitForElementToBeVisible(driver, _rowElements, WaitUtility.LocatorType.Xpath);
	        List<ArrayList<String>> actGridData=table.get_Dynamic_TwoDimension_TablElemnts(rowElements,columnElements);
	for (int i = 0; i < actGridData.size(); i++) {
		System.out.println(actGridData.size());
	            if (actGridData.get(i).get(0).equals(email)) {
	                for (int j = 1; j < actGridData.get(i).size(); j++) {
	                    System.out.println(actGridData.get(i).get(j));
	                }
	            }
	        }

	    }

	public AddUserPage clickadduserbutton() {
		page.clickOnElement(addUserbutton);
		return new AddUserPage(driver);
	}
	public String addusername() {
		String newusername=page.getElementText(addUsername);
		return newusername;
	}
	public String addUserpageTitle() {
		String title=page.getPageTitle(driver);
		return title;
	}
	public EditUserPage clickoneditbutton() {
		page.clickOnElement(editButton);
		return new EditUserPage(driver);
	}
	public void clickondeletebutton() {
		page.clickOnElement(deleteButton);
	
}
	public void ScrolldownOfuserpage() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		//js.executeScript("arguments[0].scrollIntoView();", deleteButton);
}
	public void deleteconfirmalert() {
		page.clickOnElement(deleteokAlert);
	}
	public void clickviewbutton()
	{
		page.clickOnElement(viewButton);
	}
}