package com.testCases;

import org.testng.annotations.Test;

import com.pageObjects.LoginPage;
import com.pageObjects.MyInfoPage;

import utilities.DataProviders;

public class TC_002_MyInfoPageTest extends BaseTest {
	@Test(dataProvider = "loginData", dataProviderClass = DataProviders.class)
	void testMyInfoPage(String userN, String pswd, String exp) {
		logger.info("************* started TC_002_MyInfoPageTest test ***************");
		try {
			LoginPage lp = new LoginPage(driver);
			logger.info("***** Setting up login data in test2******");
			lp.setUserName(userN);
			lp.setPassword(pswd);
			logger.info("***** Clicking on login button in test2 ******");
			lp.loginClick();
			Thread.sleep(5000);
			MyInfoPage mip = new MyInfoPage(driver);
			mip.clickMyInfo();
			mip.setFirstName("Tipuranjali");
			mip.setLastName("Cheekati");
			mip.setEmployeeId("0045");
			mip.clickGender();
			mip.clickSmokerCheckBox();
			mip.clickSavebtn();
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("************* Finished TC_002_MyInfoPageTest test ***************");
	}
}
