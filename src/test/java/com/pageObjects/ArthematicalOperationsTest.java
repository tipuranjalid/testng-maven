package com.pageObjects;


import static org.junit.Assert.assertEquals;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.firstMaven.ArthematicalOperations;

import junit.framework.Assert;

public class ArthematicalOperationsTest {
		
	@Test(dataProvider="addData")
	public void testAdd(int a, int b) {		
		ArthematicalOperations AO= new ArthematicalOperations();
		int sum = AO.add(a, b);
		if(sum==30) {
			assertEquals(30, sum);
		}else {
			assertEquals(70, sum);
		}
		
	}
	@DataProvider(name="addData")
	Object[][] data() {
			
		Object[][] inputData= {{10,20},{30,40}};		
		return inputData;
	}
	
}
