package com.qalegentbilling.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.qalegendbilling.pages.AddRolesPage;
import com.qalegendbilling.pages.AddUserPage;
import com.qalegendbilling.pages.EditRolePage;
import com.qalegendbilling.pages.EditUserPage;
import com.qalegendbilling.pages.HomePage;
import com.qalegendbilling.pages.LoginPage;
import com.qalegendbilling.pages.RolesPage;
import com.qalegendbilling.pages.UserPage;
import com.qalegentbilling.automationcore.Base;

public class PageObjectsTest extends Base {
	public WebDriver driver;
	public PageObjectsTest(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		}
	HomePage home;
	LoginPage login;
	UserPage user;
	AddUserPage adduser;
	EditUserPage edit;
	RolesPage roles;
	AddRolesPage add;
	EditRolePage editRole;
	public void pageobjects() {
		login=new LoginPage(driver);
		home=new HomePage(driver);
		user=new UserPage(driver);
		roles=new RolesPage(driver);
		add=new AddRolesPage(driver);
		editRole=new EditRolePage(driver);
		}
}
