package com.qalegentbilling.testscripts;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qalegendbilling.constants.ErrorMessages;
import com.qalegendbilling.pages.AddUserPage;
import com.qalegendbilling.pages.EditUserPage;
import com.qalegendbilling.pages.HomePage;
import com.qalegendbilling.pages.LoginPage;
import com.qalegendbilling.pages.RolesPage;
import com.qalegendbilling.pages.UserPage;
import com.qalegendbilling.utilities.ExcelUtility;
import com.qalegentbilling.automationcore.Base;
import com.qalegentbilling.automationcore.GeneralTest;

public class RoleTest extends Base{
	HomePage home;
	LoginPage login;
	UserPage user;
	AddUserPage adduser;
	EditUserPage edit;
	RolesPage roles;
	@Test(priority = 1, enabled = true, description = "TC001 verify roles page title")
	public void TC022_verifyRolespagetitle() throws InterruptedException{
		List<ArrayList<String>>data1=ExcelUtility.excelDataReader("RolesPage");
		String expTitle=data1.get(1).get(0);
		GeneralTest general=new GeneralTest(driver);
		home=new HomePage(driver);
		login=new LoginPage(driver);
		user=new UserPage(driver);
		roles=new RolesPage(driver);
		general.generaltestcode();
		home.clickusermanagementbutton();
		Thread.sleep(2000);
		home.clickonrolesbutton();
		String actTitle=roles.getrolespagetitle();
		Assert.assertEquals(actTitle, expTitle,ErrorMessages.TITLE_FAILURE_MESSAGE);
		}
}
