package com.qalegentbilling.testscripts;

import java.awt.Desktop.Action;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qalegendbilling.constants.ErrorMessages;
import com.qalegendbilling.pages.AddUserPage;
import com.qalegendbilling.pages.HomePage;
import com.qalegendbilling.pages.LoginPage;
import com.qalegendbilling.pages.UserPage;
import com.qalegendbilling.utilities.ExcelUtility;
import com.qalegendbilling.utilities.RandomUtility;
import com.qalegentbilling.automationcore.Base;
import com.qalegentbilling.automationcore.GeneralTest;

public class AddTest extends Base{
	HomePage home;
	LoginPage login;
	UserPage user;
	AddUserPage adduser;
	
	@Test(priority = 1, enabled = true, description = "TC001 verify user search with valid data")
	public void TC013_verifyerrorMsginAdduser(){
		List<ArrayList<String>> data1=ExcelUtility.excelDataReader("LoginPage");
		List<ArrayList<String>> data=ExcelUtility.excelDataReader("AddUserPage");
		String username=data1.get(1).get(1);
		String password=data1.get(1).get(2);
		String experrMessage=data.get(1).get(0);
		login=new LoginPage(driver);
		home=new HomePage(driver);
		user=new UserPage(driver);
		adduser=new AddUserPage(driver);
		login.enterusername(username);
		login.enterpassword(password);
		login.clickLoginButton();
		home.popupwindowhandle();
		home.clickusermanagementbutton();
		home.clickuserbutton();
		user.clickadduserbutton();
		adduser.scrolldown();
		adduser.clicksavebutton();
		String actErrMsg=adduser.validation(experrMessage);
		Assert.assertEquals(actErrMsg,experrMessage,ErrorMessages.USER_FAILURE_MESSAGE);
		}
	@Test(priority = 1, enabled = true, description = "TC001 verify user search with valid data")
	public void TC014_verifyNewuserlogin() throws InterruptedException{
		List<ArrayList<String>>data=ExcelUtility.excelDataReader("AddUserPage");
		String sname=data.get(1).get(1);
		String fname=data.get(1).get(2);
		String lname=data.get(1).get(3);
		String useremail=RandomUtility.getRandomEmail();
		String password1=data.get(1).get(5);
		String newuname=data.get(1).get(6);
		GeneralTest general=new GeneralTest(driver);
		home=new HomePage(driver);
		login=new LoginPage(driver);
		user=new UserPage(driver);
		adduser=new AddUserPage(driver);
		general.generaltestcode();
		home.clickusermanagementbutton();
		home.clickuserbutton();
		user.clickadduserbutton();
		adduser.addnewuser(fname, lname, useremail, password1, sname);
		adduser.clicksavebutton();
		Thread.sleep(5000);
		user.searchuser(useremail);
		Thread.sleep(3000);
		user.addusername();
		home.clickprofilebutton();
		home.clicksignoutbutton();
		//String newuname=user.addusername();
	    login.enternewusername(newuname);
		login.enterpassword(password1);
		login.clickLoginButton();
		home.popupwindowhandle();
		}
	@Test(priority = 1, enabled = true, description = "TC001 verify user search with valid data")
	public void TC015_verifyAdduserpageTitle(){
		List<ArrayList<String>>data=ExcelUtility.excelDataReader("AddUserPage");
		String expTitle=data.get(1).get(7);
		GeneralTest general=new GeneralTest(driver);
		home=new HomePage(driver);
		login=new LoginPage(driver);
		user=new UserPage(driver);
		adduser=new AddUserPage(driver);
		general.generaltestcode();
		home.clickusermanagementbutton();
		home.clickuserbutton();
		user.clickadduserbutton();
		String actTitle=user.addUserpageTitle();
		Assert.assertEquals(actTitle,expTitle,ErrorMessages.TITLE_FAILURE_MESSAGE);
	}
	@Test(priority = 1, enabled = true, description = "TC001 verify user search with valid data")
	public void TC016_verifyNewuserlogin(){
		List<ArrayList<String>>data=ExcelUtility.excelDataReader("AddUserPage");
		String sname=data.get(1).get(1);
		String fname=data.get(1).get(2);
		String lname=data.get(1).get(3);
		String useremail=RandomUtility.getRandomEmail();
		String password1=data.get(1).get(5);
		String newuname=data.get(1).get(6);
		GeneralTest general=new GeneralTest(driver);
		home=new HomePage(driver);
		login=new LoginPage(driver);
		user=new UserPage(driver);
		adduser=new AddUserPage(driver);
		general.generaltestcode();
		home.clickusermanagementbutton();
		home.clickuserbutton();
		user.clickadduserbutton();
		adduser.addnewuser(fname, lname, useremail, password1, sname);
		adduser.clicksavebutton();
	}
	}