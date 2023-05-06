package com.qalegentbilling.common;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.qalegendbilling.pages.AddUserPage;
import com.qalegendbilling.pages.HomePage;
import com.qalegendbilling.pages.LoginPage;
import com.qalegendbilling.pages.UserPage;
import com.qalegendbilling.utilities.ExcelUtility;
import com.qalegendbilling.utilities.TestHelperUtility;
import com.qalegentbilling.automationcore.Base;

public class GeneralTest extends Base{
	WebDriver driver;
	public GeneralTest(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	HomePage home;
	LoginPage login;
	UserPage user;
	AddUserPage adduser;
	public void generaltestcode()
	{
	List<ArrayList<String>> data1=ExcelUtility.excelDataReader("LoginPage");
	String username=data1.get(1).get(1);
	String password=data1.get(1).get(2);
	login=new LoginPage(driver);
	home=new HomePage(driver);
	user=new UserPage(driver);
	adduser=new AddUserPage(driver);
	login.enterusername(username);
	login.enterpassword(password);
	login.clickLoginButton();
	home.popupwindowhandle();
}
}
