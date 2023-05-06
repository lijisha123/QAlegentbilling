package com.qalegentbilling.testscripts;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import com.qalegendbilling.pages.AddUserPage;
import com.qalegendbilling.pages.EditUserPage;
import com.qalegendbilling.pages.HomePage;
import com.qalegendbilling.pages.LoginPage;
import com.qalegendbilling.pages.UserPage;
import com.qalegendbilling.pages.ViewUserPage;
import com.qalegendbilling.utilities.ExcelUtility;
import com.qalegendbilling.utilities.RandomUtility;
import com.qalegentbilling.automationcore.Base;
import com.qalegentbilling.common.GeneralTest;

public class ViewUserTest extends Base{
	HomePage home;
	LoginPage login;
	UserPage user;
	AddUserPage adduser;
	EditUserPage edit;
	ViewUserPage view;
	
@Test(priority = 1, enabled = true, description = "TC001 verify view details")
	public void TC020_verifyviewDetails() throws InterruptedException{
		List<ArrayList<String>> data=ExcelUtility.excelDataReader("UserPage");
		String searchemail=data.get(1).get(1);
		GeneralTest general=new GeneralTest(driver);
		String lname=RandomUtility.getlName();
		home=new HomePage(driver);
		login=new LoginPage(driver);
		user=new UserPage(driver);
		adduser=new AddUserPage(driver);
		edit=new EditUserPage(driver);
		view=new ViewUserPage(driver);
		general.generaltestcode();
		home.clickusermanagementbutton();
		home.clickuserbutton();
		user.searchuser(searchemail);
		Thread.sleep(2000);
		user.clickviewbutton();
		view.userdetailsdisplay();
		}

}