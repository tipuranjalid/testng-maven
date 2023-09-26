package com.testCases;

import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;

import com.pageObjects.MyInfoPage;

public class TC_002_MyInfoPage extends BaseTest {
	@Test
	void testMyInfoPage() {
		try {
		MyInfoPage mip=new MyInfoPage(driver);
		mip.clickMyInfo();
		mip.setFirstName("Tipuranjali");
		mip.setLastName("Cheekati");
		mip.setEmployeeId("0045");
		mip.clickGender();
		mip.clickSmokerCheckBox();
		mip.clickSavebtn();
		}catch(Exception e) {
			Assertions.fail();
		}
	}
}
