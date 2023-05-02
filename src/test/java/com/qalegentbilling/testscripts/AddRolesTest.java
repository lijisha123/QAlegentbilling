package com.qalegentbilling.testscripts;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qalegendbilling.constants.ErrorMessages;
import com.qalegendbilling.pages.AddRolesPage;
import com.qalegendbilling.pages.AddUserPage;
import com.qalegendbilling.pages.EditUserPage;
import com.qalegendbilling.pages.HomePage;
import com.qalegendbilling.pages.LoginPage;
import com.qalegendbilling.pages.RolesPage;
import com.qalegendbilling.pages.UserPage;
import com.qalegendbilling.utilities.ExcelUtility;
import com.qalegentbilling.automationcore.Base;
import com.qalegentbilling.automationcore.GeneralTest;

public class AddRolesTest extends Base {
	HomePage home;
	LoginPage login;
	UserPage user;
	AddUserPage adduser;
	EditUserPage edit;
	RolesPage roles;
	AddRolesPage add;
	@Test(priority = 1, enabled = true, description = "TC001 verify user search with valid data")
	public void TC021_verifyRolespagetitle() throws InterruptedException{
		List<ArrayList<String>>data=ExcelUtility.excelDataReader("AddRolesPage");
		String expTitle=data.get(1).get(0);
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
		add.getaddrolespagetitle();
		String actTitle=roles.getrolespagetitle();
		Assert.assertEquals(actTitle, expTitle,ErrorMessages.TITLE_FAILURE_MESSAGE);
		}

}
