package com.qalegentbilling.testscripts;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.qalegendbilling.constants.ErrorMessages;
import com.qalegendbilling.pages.HomePage;
import com.qalegendbilling.pages.LoginPage;
import com.qalegendbilling.pages.ResetPasswordPage;
import com.qalegendbilling.utilities.ExcelUtility;
import com.qalegendbilling.utilities.RandomUtility;
import com.qalegentbilling.automationcore.Base;

public class LoginTest extends Base{
	LoginPage login;
	HomePage home;
	ResetPasswordPage reset;
	@Test(priority = 1, enabled = true, description = "TC001 verify Login Page Title", groups = { "smoke" })
	public void TC001_verifyLoginPageTitle() {
		List<ArrayList<String>> data=ExcelUtility.excelDataReader("LoginPage");
		String exptitle=data.get(1).get(0);
		login=new LoginPage(driver);
		String actTitle=login.getloginpagetitle();
		Assert.assertEquals(exptitle, actTitle,ErrorMessages.TITLE_FAILURE_MESSAGE);
		}
	@Test(priority = 1, enabled = true, description = "TC001 verify User Login With Valid Credentials", groups = { "sanity" })
	public void TC002_verifyUserLoginWithValidCredentials() throws InterruptedException {
		List<ArrayList<String>> data=ExcelUtility.excelDataReader("LoginPage");
		String username1=data.get(1).get(1);
		String password1=data.get(1).get(2);
		login=new LoginPage(driver);
		login.enterusername(username1);
		login.enterpassword(password1);
		home=login.clickLoginButton();
		Thread.sleep(2000);
		home.popupwindowhandle();
		}
	@Test(priority = 1, enabled = true, description = "TC003 verify User Login With Valid Credentials",dataProvider="InvalidUserCredentials",dataProviderClass =com.qalegentbilling.dataprovider.DataProvider.class, groups = { "sanity" })
	public void TC003_verifyerrormessageLoginWithinValidCredentials(String usrname,String pasword) 
	{List<ArrayList<String>> data=ExcelUtility.excelDataReader("LoginPage");
		String expectederrormessage=data.get(1).get(3);
		login=new LoginPage(driver);
		login.enterusername(usrname);
		login.enterpassword(pasword);
		login.clickLoginButton();
		String actualLoginmsg=login.geterrormessage();
		Assert.assertEquals(actualLoginmsg,expectederrormessage,ErrorMessages.LOGIN_FAILURE_MESSAGE);
		}
	@Test(priority = 1, enabled = true, description = "verify Remember me Check Box Click", groups = { "regression" })
	public void TC004_verifyRemembermeCheckBoxClick() {
		login=new LoginPage(driver);
		login.remembermebox();
		}
	@Test(priority = 1, enabled = true, description = "verify Reset password Error message")
	public void TC005_verifyResetpasswordErrormessage() {
		List<ArrayList<String>>data=ExcelUtility.excelDataReader("ResetPasswordPage");
		String expMsg=data.get(1).get(0);
		login=new LoginPage(driver);
		reset=new ResetPasswordPage(driver);
		login.clickonforgotpassword();
		String email=RandomUtility.getRandomEmail();
		reset.enteremail(email);
		reset.clickonsetpasswordlink();
		String actMsg=reset.errormessagetext();
		Assert.assertEquals(actMsg, expMsg,ErrorMessages.EMAIL_FAILURE_MESSAGE);
		}
	}
