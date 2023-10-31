package com.testCases;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	public static WebDriver driver;
	public Logger logger;
	
	@BeforeClass
	public void setUp() {
		System.setProperty("log4j2.configurationFile","./log4j2.xml");
		logger= LogManager.getRootLogger();
		logger.info("**************");
		System.out.println("i am in base");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		
	}
	@AfterClass
	public void tearDown() {
		driver.close();
	}
	
//	public String captureScreeen(String tname) throws IOException {
//		String timeStamp= new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
//		TakesScreenshot ts= (TakesScreenshot) driver;
//		File source = ts.getScreenshotAs(OutputType.FILE);
//		System.out.println(System.getProperty("user.dir"));
//		String destination= System.getProperty("user.dir")+"\\Screenshots"+tname+"-"+timeStamp+".png";
//		try {
//		FileUtils.copyFile(source, new File(destination));
//		}catch(Exception e) {
//			e.getMessage();
//			e.printStackTrace();
//		}
//		
//		return destination;
//		
//	}
	

}
