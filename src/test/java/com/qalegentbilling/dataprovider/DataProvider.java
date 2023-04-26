package com.qalegentbilling.dataprovider;

import com.qalegendbilling.utilities.ExcelUtility;
public class DataProvider {
	ExcelUtility excel=new ExcelUtility();
    @org.testng.annotations.DataProvider(name="InvalidUserCredentials")
	public Object[][] InvalidUserCredentialsToLogin(){
        Object[][] data=excel.dataProviderRead("LoginPageDataProvider");
        return data;
    }

}
