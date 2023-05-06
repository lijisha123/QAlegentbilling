package com.qalegentbilling.testscripts;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.google.common.base.Objects;
import com.qalegendbilling.constants.ErrorMessages;
import com.qalegendbilling.constants.ExtendLogMessages;
import com.qalegendbilling.pages.HomePage;
import com.qalegendbilling.pages.LoginPage;
import com.qalegendbilling.pages.ResetPasswordPage;
import com.qalegendbilling.utilities.ExcelUtility;
import com.qalegendbilling.utilities.RandomUtility;
import com.qalegentbilling.automationcore.Base;
import com.qalegentbilling.common.GeneralTest;
import com.qalegentbilling.common.PageObjectsTest;
import com.qalegentbilling.listeners.TestListener;

public class LoginTest extends Base{
	LoginPage login;
	HomePage home;
	ResetPasswordPage reset;
	ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();
	@Test(priority = 1, enabled = true, description = "TC001 verify Login Page Title", groups = { "smoke" })
	public void TC001_verifyLoginPageTitle() {
		extentTest.get().assignCategory("smoke");
		//PageObjectsTest object=new PageObjectsTest(driver);
		//object.pageobjects();
		List<ArrayList<String>> data=ExcelUtility.excelDataReader("LoginPage");
		String exptitle=data.get(1).get(0);
		login=new LoginPage(driver);
		String actTitle=login.getloginpagetitle();
		extentTest.get().log(Status.PASS, ExtendLogMessages.LOGINPAGE_TITLE_RECEIVED);
		Assert.assertEquals(exptitle, actTitle,ErrorMessages.TITLE_FAILURE_MESSAGE);
		}
	@Test(priority = 1, enabled = true, description = "TC001 verify User Login With Valid Credentials", groups = { "sanity" })
	public void TC002_verifyUserLoginWithValidCredentials() throws InterruptedException {
		extentTest.get().assignCategory("sanity");
		GeneralTest general=new GeneralTest(driver);
		general.generaltestcode();
		extentTest.get().log(Status.PASS, ExtendLogMessages.LOGIN_SUCCESSFUL);
		}
	@Test(priority = 1, enabled = true, description = "TC003 verify User Login With Valid Credentials",dataProvider="InvalidUserCredentials",dataProviderClass =com.qalegentbilling.dataprovider.DataProvider.class, groups = { "sanity" })
	public void TC003_verifyerrormessageLoginWithinValidCredentials(String usrname,String pasword) {
		extentTest.get().assignCategory("sanity");
		List<ArrayList<String>> data=ExcelUtility.excelDataReader("LoginPage");
		String expectederrormessage=data.get(1).get(3);
		login=new LoginPage(driver);
		login.enterusername(usrname);
		login.enterpassword(pasword);
		login.clickLoginButton();
		String actualLoginmsg=login.geterrormessage();
		extentTest.get().log(Status.PASS, ExtendLogMessages.LOGIN_UNSUCCESSFUL);
		Assert.assertEquals(actualLoginmsg,expectederrormessage,ErrorMessages.LOGIN_FAILURE_MESSAGE);
		}
	@Test(priority = 1, enabled = true, description = "verify Remember me Check Box Click", groups = { "regression" })
	public void TC004_verifyRemembermeCheckBoxClick() {
		extentTest.get().assignCategory("regression");
		login=new LoginPage(driver);
		login.remembermebox();
		extentTest.get().log(Status.PASS, ExtendLogMessages.REMEMBERME_CLICK);
		}
	@Test(priority = 1, enabled = true, description = "verify Reset password Error message",groups = { "SANITY" })
	public void TC005_verifyResetpasswordErrormessage() {
		extentTest.get().assignCategory("SANITY");
		List<ArrayList<String>>data=ExcelUtility.excelDataReader("ResetPasswordPage");
		String expMsg=data.get(1).get(0);
		login=new LoginPage(driver);
		reset=new ResetPasswordPage(driver);
		login.clickonforgotpassword();
		String email=RandomUtility.getRandomEmail();
		reset.enteremail(email);
		reset.clickonsetpasswordlink();
		String actMsg=reset.errormessagetext();
		extentTest.get().log(Status.PASS, ExtendLogMessages.RESETPASSWORD_ERROR);
		Assert.assertEquals(actMsg, expMsg,ErrorMessages.EMAIL_FAILURE_MESSAGE);
		}
	}
