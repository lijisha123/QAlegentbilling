package com.qalegentbilling.testscripts;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.qalegendbilling.constants.ErrorMessages;
import com.qalegendbilling.constants.ExtendLogMessages;
import com.qalegendbilling.pages.HomePage;
import com.qalegendbilling.pages.LoginPage;
import com.qalegendbilling.utilities.ExcelUtility;
import com.qalegentbilling.automationcore.Base;
import com.qalegentbilling.common.GeneralTest;
import com.qalegentbilling.listeners.TestListener;

public class HomeTest extends Base{
	HomePage home;
	LoginPage login;
	ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();
	@Test(priority = 1, enabled = true, description = "TC001 verify Home Page Title", groups = { "smoke" })
	public void TC006_verifyHomePageTitle() {
		extentTest.get().assignCategory("smoke");
		List<ArrayList<String>> data = ExcelUtility.excelDataReader("HomePage");
		String expectedTitle = data.get(1).get(0);
		GeneralTest general=new GeneralTest(driver);
		general.generaltestcode(); 
		String actualHomePagetitle = home.gethomepagetitle();
		extentTest.get().log(Status.PASS, ExtendLogMessages.HOMEPAGE_TITLE_RECEIVED);
		Assert.assertEquals(expectedTitle, actualHomePagetitle, ErrorMessages.TITLE_FAILURE_MESSAGE);
}
	@Test(priority = 1, enabled = true, description = "TC001 verify signout button", groups = { "regression" })
	public void TC008_verifysignoutbutton() {
		extentTest.get().assignCategory("regression");
		GeneralTest general=new GeneralTest(driver);
		general.generaltestcode(); 
		home.clickprofilebutton();
		home.clicksignoutbutton();
		extentTest.get().log(Status.PASS, ExtendLogMessages.SIGNOUT_FAILED);
		}
	@Test(priority = 1, enabled = true, description = "TC001 verify user management button", groups = { "sanity" })
	public void TC009_verifyuserManagementbutton() {
		extentTest.get().assignCategory("sanity");
		GeneralTest general=new GeneralTest(driver);
		general.generaltestcode();
		home=new HomePage(driver);
		home.clickusermanagementbutton();
		home.displayuserbutton();
		home.displayrolesbutton();
		home.displaysalesmanagementbutton();
		extentTest.get().log(Status.PASS, ExtendLogMessages.USER_MAMAGEMENT);
}}
		//List<ArrayList<String>>data1=ExcelUtility.excelDataReader("HomePage");
		//String user=data1.get(0).get(1);
		//String roles=data1.get(1).get(1);
		//String sales=data1.get(2).get(1);
		
		//boolean status=home.displayuserbutton();
		//boolean status1=home.displayrolesbutton();
		//boolean status2=home.displaysalesmanagementbutton();
		
		//Assert.assertTrue(status, ErrorMessages.SUBMENU_FAILURE_MESSAGE);
		//Assert.assertTrue(status1, ErrorMessages.SUBMENU_FAILURE_MESSAGE);
		//Assert.assertTrue(status2, ErrorMessages.SUBMENU_FAILURE_MESSAGE);
