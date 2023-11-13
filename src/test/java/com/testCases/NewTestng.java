package com.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.pageObjects.LoginPage;

public class NewTestng extends BaseTest {

	@Test
	public void test1() {
		try {
		LoginPage loginPg= new LoginPage(driver);
		loginPg.setUserName("Admin");
		loginPg.setPassword("admin123");
		loginPg.loginClick();
		boolean ProPicStatus = loginPg.cnfmProfilePic();
		System.out.println(ProPicStatus);
		String exp="Valid";
		System.out.println(exp);
		logger.info("***** Validating expected results******");
		if (exp.equals("Valid")) {
			if (ProPicStatus == true) {
				loginPg.logout();
				Assert.assertTrue(true);
			}else {
				Assert.assertTrue(false);
			}
		} 
		
		if(exp.equals("Invalid")) {
			if (ProPicStatus == true) {
				loginPg.logout();
				Assert.assertTrue(false);
			}else {
				Assert.assertTrue(true);
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
//  @Test(priority=2)
//  public void test2() {
//	  System.out.println("test2");
//	  Assert.assertNotEquals("A", "B");
//	  
//  }
//  @Test(priority=3,dependsOnMethods= {"test2"})
//  public void test3() {
//	  System.out.println("test3");
//	  Assert.assertEquals(1, 1);
//  }

