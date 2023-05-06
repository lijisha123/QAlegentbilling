package com.qalegentbilling.testscripts;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qalegendbilling.constants.ErrorMessages;
import com.qalegendbilling.pages.AddRolesPage;
import com.qalegendbilling.pages.AddUserPage;
import com.qalegendbilling.pages.EditRolePage;
import com.qalegendbilling.pages.EditUserPage;
import com.qalegendbilling.pages.HomePage;
import com.qalegendbilling.pages.LoginPage;
import com.qalegendbilling.pages.RolesPage;
import com.qalegendbilling.pages.UserPage;
import com.qalegendbilling.utilities.ExcelUtility;
import com.qalegentbilling.automationcore.Base;
import com.qalegentbilling.common.GeneralTest;

public class EditRoleTest extends Base{
	HomePage home;
	LoginPage login;
	UserPage user;
	AddUserPage adduser;
	EditUserPage edit;
	RolesPage roles;
	AddRolesPage add;
	EditRolePage editRole;
	@Test(priority = 1, enabled = true, description = "TC001  verify user can add Roles")
	public void TC023_verifyUserCanAddRoles() throws InterruptedException{
		GeneralTest general=new GeneralTest(driver);
		login=new LoginPage(driver);
		home=new HomePage(driver);
		user=new UserPage(driver);
		roles=new RolesPage(driver);
		add=new AddRolesPage(driver);
		editRole=new EditRolePage(driver);
		general.generaltestcode();
		home.clickusermanagementbutton();
		Thread.sleep(2000);
		home.clickonrolesbutton();
		roles.cliEditRolebutton();
		String expTitle=editRole.exptitle();
		String actTitle=editRole.geteditrolestitle();
		Assert.assertEquals(actTitle,expTitle,ErrorMessages.TITLE_FAILURE_MESSAGE);
		}

}
