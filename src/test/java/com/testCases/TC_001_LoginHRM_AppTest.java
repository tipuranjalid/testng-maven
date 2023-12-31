package com.testCases;



import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.pageObjects.LoginPage;

import utilities.DataProviders;
//@Listeners(com.testCases.ExtentReportManager.class)
public class TC_001_LoginHRM_AppTest extends BaseTest {
	@Test(dataProvider = "loginData", dataProviderClass = DataProviders.class)
	void testLoginPage(String userN, String pswd, String exp) {
		
		logger.info("***** Started TC_001_LoginHRM_AppTest ****** ");
		LoginPage lp = new LoginPage(driver);
		try {
			logger.info("***** Setting up login data******");
			lp.setUserName(userN);
			lp.setPassword(pswd);
			logger.info("***** Clicking on login button ******");
			lp.loginClick();
			boolean ProPicStatus = lp.cnfmProfilePic();
			System.out.println(ProPicStatus);
			System.out.println(exp);
			logger.info("***** Validating expected results******");
			if (exp.equals("Valid")) {
				if (ProPicStatus == true) {
					lp.logout();
					Assert.assertTrue(true);
				}else {
					Assert.assertTrue(false);

				} 

				}

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("***** Test Failed******");
			Assert.fail();
		}
		logger.info("***** Finished TC_001_LoginHRM_AppTest ******");
	}

}
