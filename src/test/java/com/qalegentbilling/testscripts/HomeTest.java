package com.qalegentbilling.testscripts;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qalegendbilling.constants.ErrorMessages;
import com.qalegendbilling.pages.HomePage;
import com.qalegendbilling.pages.LoginPage;
import com.qalegendbilling.utilities.ExcelUtility;
import com.qalegentbilling.automationcore.Base;

public class HomeTest extends Base{
	HomePage home;
	LoginPage login;
	@Test(priority = 1, enabled = true, description = "TC001 verify Home Page Title", groups = { "smoke" })
	public void TC006_verifyHomePageTitle() {
		List<ArrayList<String>> data = ExcelUtility.excelDataReader("HomePage");
		List<ArrayList<String>> data1=ExcelUtility.excelDataReader("LoginPage");
		String expectedTitle = data.get(1).get(0);
		String username=data1.get(1).get(1);
		String password=data1.get(1).get(2);
		home=new HomePage(driver);
		login=new LoginPage(driver);
		login.enterusername(username);
		login.enterpassword(password);
		login.clickLoginButton();
		home.popupwindowhandle();
		String actualHomePagetitle = home.gethomepagetitle();
		Assert.assertEquals(expectedTitle, actualHomePagetitle, ErrorMessages.TITLE_FAILURE_MESSAGE);
}
	@Test(priority = 1, enabled = true, description = "TC001 verify signout button", groups = { "regression" })
	public void TC008_verifysignoutbutton() {
		List<ArrayList<String>> data=ExcelUtility.excelDataReader("LoginPage");
		String username=data.get(1).get(1);
		String password=data.get(1).get(2);
		home=new HomePage(driver);
		login=new LoginPage(driver);
		login.enterusername(username);
		login.enterpassword(password);
		login.clickLoginButton();
		home.popupwindowhandle();
		home.clickprofilebutton();
		home.clicksignoutbutton();
		}
	@Test(priority = 1, enabled = true, description = "TC001 verify user management button", groups = { "sanity" })
	public void TC009_verifyuserManagementbutton() {
		List<ArrayList<String>> data=ExcelUtility.excelDataReader("LoginPage");
		//List<ArrayList<String>>data1=ExcelUtility.excelDataReader("HomePage");
		String username=data.get(1).get(1);
		String password=data.get(1).get(2);
		//String user=data1.get(0).get(1);
		//String roles=data1.get(1).get(1);
		//String sales=data1.get(2).get(1);
		home=new HomePage(driver);
		login=new LoginPage(driver);
		login.enterusername(username);
		login.enterpassword(password);
		login.clickLoginButton();
		home.popupwindowhandle();
		home.clickusermanagementbutton();
		//boolean status=home.displayuserbutton();
		//boolean status1=home.displayrolesbutton();
		//boolean status2=home.displaysalesmanagementbutton();
		home.displayuserbutton();
		home.displayrolesbutton();
		home.displaysalesmanagementbutton();
		//Assert.assertTrue(status, ErrorMessages.SUBMENU_FAILURE_MESSAGE);
		//Assert.assertTrue(status1, ErrorMessages.SUBMENU_FAILURE_MESSAGE);
		//Assert.assertTrue(status2, ErrorMessages.SUBMENU_FAILURE_MESSAGE);
}
}