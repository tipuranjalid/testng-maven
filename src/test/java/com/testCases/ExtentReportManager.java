package com.testCases;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager implements ITestListener{

	public ExtentSparkReporter sparkReporter; //UI of the report
	public ExtentReports extent; //Populate common info on the report
	public ExtentTest test; //creating TC entries and update status of the test methods 
	
	public void onStart(ITestContext context) {
		System.out.println(System.getProperty("user.dir"));
//		sparkReporter= new ExtentSparkReporter(System.getProperty("user.dir")+"/reports/myReport.html");
		sparkReporter= new ExtentSparkReporter("reports/myReport.html");
		sparkReporter.config().setDocumentTitle("Automation Report"); //Title of report
		sparkReporter.config().setReportName("Functional Testing"); //Name of the report
		sparkReporter.config().setTheme(Theme.STANDARD);
		
		extent= new ExtentReports();
		extent.attachReporter(sparkReporter);
		
		extent.setSystemInfo("Computer name", "Localhost");
		extent.setSystemInfo("Enviornment", "QA");
		extent.setSystemInfo("Tester name", "Tipura");
		extent.setSystemInfo("OS", "Windows10");
		extent.setSystemInfo("Browser name", "Chrome,firefox,Edge");	
		
		
	}
	public void onTestSuccess(ITestResult result) {
		test= extent.createTest(result.getName()); //this will create the new entry in the report
		test.log(Status.PASS, "Test case passed is....."+result.getName());
		
	}
	
	public void onTestFailure(ITestResult result) {
		test= extent.createTest(result.getName()); //this will create the new entry in the report
		test.log(Status.FAIL, "Test case failed is....."+result.getName());
		test.log(Status.FAIL, "Test case failed cause is....."+result.getThrowable());
		
	}
	public void onTestSkipped(ITestResult result) {
		test= extent.createTest(result.getName()); //this will create the new entry in the report
		test.log(Status.SKIP, "Test case skipped is....."+result.getName());
		
	}
	
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
		
	}
	
	
}
