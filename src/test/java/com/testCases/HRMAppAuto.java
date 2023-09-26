package com.testCases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HRMAppAuto {
	WebDriver driver;

	@BeforeMethod
	void webDriverLaunch() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		System.out.println("Before method executed...");
	}

	@Test(priority = 1, dataProvider = "loginData1")
	void login(String userName, String password) {

		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(userName);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		String title = driver.getTitle();
		System.out.println(title);
		String actualTitle = "OrangeHRM";
		Assert.assertEquals(title, actualTitle);

	}

	@AfterMethod
	void close() {
		driver.close();
		System.out.println("After method.....");
	}

	@DataProvider(name = "loginData1")
	String[][] loginData() {
		String[][] data = { 
				{ "Admin1", "admin12348" ,"OrangeHRM"},
				{ "Admin", "admin123","OrangeHRM" },
				{ "Admin1", "admin123","OrangeHRM" } 
				};
		return data;
	}
}
