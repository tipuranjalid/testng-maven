package com.testCases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TakeScreenShots {

	
		public static WebDriver driver;

		public static void main(String[] args) throws IOException {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\ctipuran\\eclipse-workspace\\SeleniumProject\\Drivers\\chromedriver-win64\\chromedriver.exe");
			
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
			driver.manage().window().maximize();
			
			
			//capture full screen shot
			TakesScreenshot ts= (TakesScreenshot) driver;
			
			File src=ts.getScreenshotAs(OutputType.FILE);
			File trg = new File("C:\\Users\\ctipuran\\eclipse-workspace\\MavenProject\\Screenshots\\fullPage.png");
			System.out.println("i am copying src to target");
			FileUtils.copyFile(src, trg);
			System.out.println("completed");
			

		}

	}


