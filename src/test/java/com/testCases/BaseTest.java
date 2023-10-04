package com.testCases;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	public WebDriver driver;
	public Logger logger;
	@BeforeClass
	public void setUp() {
		System.setProperty("log4j2.xml","C:\\Users\\ctipuran\\eclipse-workspace\\MavenProject\\src\\test\\resources\\log4j2.xml");
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
	

}
