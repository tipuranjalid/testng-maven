package com.testCases;

import org.junit.jupiter.api.Assertions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.pageObjects.LoginPage;

public class TC_001_LoginHRM_App extends BaseTest {
	@Test(dataProvider="dp")
	void testLoginPage(String userN,String pswd) {
		LoginPage lp = new LoginPage(driver);
		try {
		lp.setUserName(userN);
		lp.setPassword(pswd);
		lp.loginClick();
		boolean ProPicStatus=lp.cnfmProfilePic();
		Assertions.assertEquals(ProPicStatus, true);
		}catch(Exception e) {
			Assertions.fail();
		}
	}
	
	@DataProvider(name="dp")
	Object[][] dataProvider() {
		Object[][] data= {{"Admin","admin123"},{"Admin1","admin123"}};
		return data;
	}

}
