package com.pageObjects;

import org.apache.commons.lang3.RandomStringUtils;

public class HomePage {
	
	public String randomString() {
		String generatedRanString= RandomStringUtils.randomAlphabetic(5);
		return generatedRanString;
	}
	
	public String randomNumber() {
		String genRanNum= RandomStringUtils.randomNumeric(10);
		return genRanNum;
	}
	
	

}
