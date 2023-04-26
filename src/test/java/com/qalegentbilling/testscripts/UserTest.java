package com.qalegentbilling.testscripts;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qalegendbilling.constants.ErrorMessages;
import com.qalegendbilling.pages.HomePage;
import com.qalegendbilling.pages.LoginPage;
import com.qalegendbilling.pages.UserPage;
import com.qalegendbilling.utilities.ExcelUtility;
import com.qalegentbilling.automationcore.Base;

public class UserTest extends Base{
	HomePage home;
	LoginPage login;
	UserPage user;
	@Test(priority = 1, enabled = true, description = "TC001 verify user Page Title", groups = { "regression" })
	public void TC010_verifyUserPageTitle() {
		List<ArrayList<String>> data = ExcelUtility.excelDataReader("UserPage");
		List<ArrayList<String>> data1=ExcelUtility.excelDataReader("LoginPage");
		String expectedTitle = data.get(1).get(0);
		String username=data1.get(1).get(1);
		String password=data1.get(1).get(2);
		login=new LoginPage(driver);
		home=new HomePage(driver);
		user=new UserPage(driver);
		login.enterusername(username);
		login.enterpassword(password);
		login.clickLoginButton();
		home.popupwindowhandle();
		home.clickusermanagementbutton();
		home.clickuserbutton();
		String actualuserPagetitle =user.getuserpagetitle();
		Assert.assertEquals(expectedTitle, actualuserPagetitle, ErrorMessages.TITLE_FAILURE_MESSAGE);
}
	@Test(priority = 1, enabled = true, description = "TC001 verify user search with valid data")
	public void TC010_verifyUserSearchWithValidData() {
		List<ArrayList<String>> data1=ExcelUtility.excelDataReader("LoginPage");
		String username=data1.get(1).get(1);
		String password=data1.get(1).get(2);
		login=new LoginPage(driver);
		home=new HomePage(driver);
		user=new UserPage(driver);
		login.enterusername(username);
		login.enterpassword(password);
		login.clickLoginButton();
		home.popupwindowhandle();
		home.clickusermanagementbutton();
		home.clickuserbutton();
		
		}
}
