package com.qalegentbilling.testscripts;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.qalegendbilling.constants.ErrorMessages;
import com.qalegendbilling.constants.ExtendLogMessages;
import com.qalegendbilling.pages.AddRolesPage;
import com.qalegendbilling.pages.AddUserPage;
import com.qalegendbilling.pages.EditUserPage;
import com.qalegendbilling.pages.HomePage;
import com.qalegendbilling.pages.LoginPage;
import com.qalegendbilling.pages.RolesPage;
import com.qalegendbilling.pages.UserPage;
import com.qalegendbilling.utilities.ExcelUtility;
import com.qalegentbilling.automationcore.Base;
import com.qalegentbilling.common.GeneralTest;
import com.qalegentbilling.common.PageObjectsTest;
import com.qalegentbilling.listeners.TestListener;

public class AddRolesTest extends Base {
	HomePage home;
	LoginPage login;
	UserPage user;
	AddUserPage adduser;
	EditUserPage edit;
	RolesPage roles;
	AddRolesPage add;
	ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();
	@Test(priority = 1, enabled = true, description = "TC001  verify add Roles page title", groups = { "smoke" })
	public void TC021_verifyAddRolespagetitle() throws InterruptedException{
		extentTest.get().assignCategory("smoke");
		List<ArrayList<String>>data=ExcelUtility.excelDataReader("AddRoles");
		String expTitle=data.get(1).get(0);
		GeneralTest general=new GeneralTest(driver);
		home=new HomePage(driver);
		user=new UserPage(driver);
		roles=new RolesPage(driver);
		add=new AddRolesPage(driver);
		general.generaltestcode();
		home.clickusermanagementbutton();
		Thread.sleep(2000);
		home.clickonrolesbutton();
		roles.clickonaddrolesbutton();
		add.getaddrolespagetitle();
		String actTitle=roles.getrolespagetitle();
		extentTest.get().log(Status.PASS, ExtendLogMessages.ROLESPAGE_TITLE_RECEIVED);
		Assert.assertEquals(actTitle, expTitle,ErrorMessages.TITLE_FAILURE_MESSAGE);
		}
	@Test(priority = 1, enabled = true, description = "TC001  verify user can add Roles", groups = { "sanity" })
	public void TC023_verifyUserCanAddRoles() throws InterruptedException{
		extentTest.get().assignCategory("sanity");
		GeneralTest general=new GeneralTest(driver);
		login=new LoginPage(driver);
		home=new HomePage(driver);
		user=new UserPage(driver);
		roles=new RolesPage(driver);
		add=new AddRolesPage(driver);
		general.generaltestcode();
		home.clickusermanagementbutton();
		Thread.sleep(2000);
		home.clickonrolesbutton();
		roles.clickonaddrolesbutton();
		add.clickoncheckbox();
		add.clicksavebutton();
		extentTest.get().log(Status.PASS, ExtendLogMessages.ADD_ROLES);
		}
}
