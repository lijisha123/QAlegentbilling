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
import com.qalegendbilling.pages.UserPage;
import com.qalegendbilling.utilities.ExcelUtility;
import com.qalegendbilling.utilities.RandomUtility;
import com.qalegentbilling.automationcore.Base;
import com.qalegentbilling.common.GeneralTest;

public class EditUserTest extends Base{
	HomePage home;
	LoginPage login;
	UserPage user;
	AddUserPage adduser;
	EditUserPage edit;
	@Test(priority = 1, enabled = true, description = "TC001 verify user search with valid data")
	public void TC017_verifyEditusertitle() throws InterruptedException{
		List<ArrayList<String>> data=ExcelUtility.excelDataReader("UserPage");
		List<ArrayList<String>>data1=ExcelUtility.excelDataReader("EditUserPage");
		String searchemail=data.get(1).get(1);
		String expTitle=data1.get(1).get(0);
		GeneralTest general=new GeneralTest(driver);
		home=new HomePage(driver);
		login=new LoginPage(driver);
		user=new UserPage(driver);
		adduser=new AddUserPage(driver);
		edit=new EditUserPage(driver);
		general.generaltestcode();
		home.clickusermanagementbutton();
		home.clickuserbutton();
		user.searchuser(searchemail);
		Thread.sleep(2000);
		user.clickoneditbutton();
		String actTitle=edit.edituserpagetitle();
		Assert.assertEquals(actTitle,expTitle,ErrorMessages.TITLE_FAILURE_MESSAGE);
}
	@Test(priority = 1, enabled = true, description = "TC001 verify user search with valid data")
	public void TC018_verifyEdituserpage() throws InterruptedException{
		List<ArrayList<String>> data=ExcelUtility.excelDataReader("UserPage");
		String searchemail=data.get(1).get(1);
		GeneralTest general=new GeneralTest(driver);
		String lname=RandomUtility.getlName();
		home=new HomePage(driver);
		login=new LoginPage(driver);
		user=new UserPage(driver);
		adduser=new AddUserPage(driver);
		edit=new EditUserPage(driver);
		general.generaltestcode();
		home.clickusermanagementbutton();
		home.clickuserbutton();
		user.searchuser(searchemail);
		Thread.sleep(2000);
		user.clickoneditbutton();
		edit.edituser(lname);
		adduser.clicksavebutton();
		}
	@Test(priority = 1, enabled = true, description = "TC001 verify user search with valid data")
	public void TC019_verifyDeleteuser() throws InterruptedException{
		List<ArrayList<String>> data=ExcelUtility.excelDataReader("UserPage");
		String searchemail=data.get(1).get(1);
		GeneralTest general=new GeneralTest(driver);
		String lname=RandomUtility.getlName();
		home=new HomePage(driver);
		login=new LoginPage(driver);
		user=new UserPage(driver);
		adduser=new AddUserPage(driver);
		edit=new EditUserPage(driver);
		general.generaltestcode();
		home.clickusermanagementbutton();
		home.clickuserbutton();
		user.searchuser(searchemail);
		Thread.sleep(2000);
		//user.ScrolldownOfuserpage();
		//Thread.sleep(5000);
		user.clickondeletebutton();
		user.deleteconfirmalert();
		}
	
	
}
