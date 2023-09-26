package com.testCases;

import java.time.Duration;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class ParallelTestingXML extends BaseTest{
	

	

	@Test(priority = 1,dataProvider="dp")
	void login(String userName, String password) {
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(userName);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}

	@Test(priority = 2)
	void logoTest() {
		try {
		boolean status = driver.findElement(By.xpath("//img[@alt='profile picture']")).isDisplayed();
		Assertions.assertEquals(status, true);
		}catch(Exception e) {
			Assertions.fail();
		}
	}

	@Test(priority = 3)
	void titleTest() {
		Assertions.assertEquals(driver.getTitle(), "OrangeHRM");
	}
//	@Test(priority=4)
	void testLeaveInMenu() {
		driver.findElement(By.xpath("//*[text()='Leave']")).click();
		driver.findElement(By.xpath("//*[contains(text(),'From Date')]/ancestor::div[1]/following-sibling::div//input")).sendKeys("2023-01-01");
		driver.findElement(By.xpath("//*[contains(text(),'To Date')]/ancestor::div[1]/following-sibling::div//input")).sendKeys("2023-12-31");
		driver.findElement(By.xpath("//*[contains(text(),'Status')]/parent::div//following-sibling::div//*[@class='oxd-select-text-input']")).click();
		driver.findElement(By.xpath("//*[@type='submit']")).click();
		boolean records=driver.findElement(By.xpath("//*[@class=\"oxd-text oxd-text--span\"]")).isDisplayed();
		Assertions.assertEquals(records, true);
	}
	@Test(priority=5)
	void textMyInfo() throws Exception {
		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		driver.findElement(By.xpath("//*[text()='My Info']")).click();
		WebElement firstNameEle = driver.findElement(By.xpath("//input[@name='firstName']"));
		wait.until(ExpectedConditions.elementToBeClickable(firstNameEle));
		
//		firstNameEle.clear();
		System.out.println("Text in first Name"+firstNameEle.getText());
		String name = firstNameEle.getAttribute("value");
		System.out.println(name);
		String bcksps = "";
		for(int i  =0;i<name.length();i++) {
			bcksps+=Keys.BACK_SPACE;
		}
		System.out.println(bcksps);
		driver.findElement(By.xpath("//input[@name='lastName']")).clear();
		Thread.sleep(Duration.ofSeconds(10));
		firstNameEle.click();
		firstNameEle.sendKeys(bcksps);
		firstNameEle.sendKeys("hhaaaaaaaaaaaaaaaaaaaa");
		driver.findElement(By.xpath("//input[@name='lastName']")).clear();
		driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys("Cheekati");
		driver.findElement(By.xpath("//*[text()='Employee Id']/ancestor::div[1]/following-sibling::div/input")).clear();
		driver.findElement(By.xpath("//*[text()='Employee Id']/ancestor::div[1]/following-sibling::div/input")).sendKeys("0045");
		driver.findElement(By.xpath("//*[text()='Marital Status']/ancestor::div[1]/following-sibling::div//*[@class='oxd-select-text-input']")).click();
		driver.findElement(By.xpath("//*[text()='Single']")).click();
		//div[*/*[text()='Employee Id']]//input
		driver.findElement(By.xpath("//div[*/*[text()=\"Female\"]]//input")).click();
		driver.findElement(By.xpath("//div[*/*[text()=\"Smoker\"]]//input")).click();
		driver.findElement(By.xpath("//div[*[@type='submit']]//button")).click();
		
	}
	
	

	
	@DataProvider(name="dp")
	Object[][] loginData() {
		Object[][] data= {
				{"Admin","admin123"},				
		};
		return data;
	}
}
