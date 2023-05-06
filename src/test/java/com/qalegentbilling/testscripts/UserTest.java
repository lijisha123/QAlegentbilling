package com.qalegentbilling.testscripts;

import java.awt.AWTException;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qalegendbilling.constants.ErrorMessages;
import com.qalegendbilling.pages.HomePage;
import com.qalegendbilling.pages.LoginPage;
import com.qalegendbilling.pages.UserPage;
import com.qalegendbilling.utilities.ExcelUtility;
import com.qalegendbilling.utilities.RandomUtility;
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
	public void TC011_verifyUserSearchWithValidData() throws AWTException{
		List<ArrayList<String>> data1=ExcelUtility.excelDataReader("LoginPage");
		List<ArrayList<String>> data=ExcelUtility.excelDataReader("UserPage");
		String username=data1.get(1).get(1);
		String password=data1.get(1).get(2);
		String searchemail=data.get(1).get(1);
		login=new LoginPage(driver);
		home=new HomePage(driver);
		user=new UserPage(driver);
		login.enterusername(username);
		login.enterpassword(password);
		login.clickLoginButton();
		home.popupwindowhandle();
		home.clickusermanagementbutton();
		home.clickuserbutton();
		user.searchuser(searchemail);
		user.getTableContent(searchemail);
		user.pressenter();
		}
	@Test(priority = 1, enabled = true, description = "TC001 verify user search with invalid data")
	public void TC012_verifyUserSearchWithInValidData() throws AWTException, InterruptedException{
		List<ArrayList<String>> data1=ExcelUtility.excelDataReader("LoginPage");
		List<ArrayList<String>> data=ExcelUtility.excelDataReader("UserPage");
		String username=data1.get(1).get(1);
		String password=data1.get(1).get(2);
		String searchemail=RandomUtility.getRandomEmail();
		String expErrmsg=data.get(1).get(2);
		login=new LoginPage(driver);
		home=new HomePage(driver);
		user=new UserPage(driver);
		login.enterusername(username);
		login.enterpassword(password);
		login.clickLoginButton();
		home.popupwindowhandle();
		home.clickusermanagementbutton();
		home.clickuserbutton();
		user.searchuser(searchemail);
		Thread.sleep(3000);
		//user.pressenter()
		String actErrmsg=user.errormessage();
		Assert.assertEquals(actErrmsg,expErrmsg,ErrorMessages.USER_FAILURE_MESSAGE);
		}
	}

