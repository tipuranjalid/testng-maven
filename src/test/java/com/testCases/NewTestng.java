package com.testCases;

import org.junit.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

public class NewTestng {
  @Test(priority=1)
  public void test1() {
	  System.out.println("test1");
	  Assert.assertEquals(1, 1);
  }
  @Test(priority=2)
  public void test2() {
	  System.out.println("test2");
	  Assert.assertEquals("A", "B");
	  
  }
  @Test(priority=3,dependsOnMethods= {"test2"})
  public void test3() {
	  System.out.println("test3");
	  Assert.assertEquals(1, 1);
  }
}
