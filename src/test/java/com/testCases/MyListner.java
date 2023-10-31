package com.testCases;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

//ITestListner---- Interface
//TestListnerAdapter---- Class

public  class MyListner implements ITestListener {
	
	public void onTestStart(ITestResult result) {
		System.out.println("on test start....");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("on test success....");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("on test fail....");
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("on test skip....");
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}
	
//	public void onTestStart(ITestResult result) {
//		System.out.println("On test start.....");
//	}
//	public void onTestFailure(ITestResult result) {
//		System.out.println("On test fail.....");
//	}
//	public void onTestSuccess(ITestResult result) {
//		System.out.println("On test success.....");
//	}
//	public void onTestSkiped(ITestResult result) {
//		System.out.println("On test skipped.....");
//	}
//	public void onFinish(ITestContext context) {
//		System.out.println("On test finish.....");
//	}
//	@Override
//	public void onTestSkipped(ITestResult result) {
//		// TODO Auto-generated method stub
//		
//	}
//	@Override
//	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
//		// TODO Auto-generated method stub
//		
//	}
//	@Override
//	public void onStart(ITestContext context) {
//		// TODO Auto-generated method stub
//		
//	}
	

}
