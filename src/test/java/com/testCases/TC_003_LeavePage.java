package com.testCases;

import org.testng.annotations.Test;

import com.pageObjects.LeavePage;

public class TC_003_LeavePage extends BaseTest {
	@Test
	void testLeavePage() {
		LeavePage lp = new LeavePage(driver);
		lp.clickLeave();
	}
	
	
}
