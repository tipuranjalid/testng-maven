package com.test;


import static org.junit.Assert.assertEquals;

import org.testng.annotations.Test;

import com.firstMaven.ArthematicalOperations;

public class ArthematicalOperationsTest {
	@Test
	public void testAdd() {
		int a= 10;
		int b= 20;
		ArthematicalOperations AO= new ArthematicalOperations();
		int sum = AO.add(a, b);
		assertEquals(30, sum);
	}
	
}
