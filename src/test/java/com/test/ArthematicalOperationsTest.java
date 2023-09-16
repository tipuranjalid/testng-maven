package com.test;


import static org.junit.Assert.assertEquals;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.firstMaven.ArthematicalOperations;

public class ArthematicalOperationsTest {
		
	@Test(dataProvider="addData")
	public void testAdd(int a, int b) {		
		ArthematicalOperations AO= new ArthematicalOperations();
		int sum = AO.add(a, b);
		assertEquals(30, sum);
	}
	@DataProvider(name="addData")
	public Object[] data() {
		Object[] testData= new Object[2];
		testData[0]=10;
		testData[1]=20;

		return testData;
		
	}
	
}
