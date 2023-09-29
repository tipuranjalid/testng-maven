package com.testCases;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ExcelUtility;

public class DataDrivenTest {
	WebDriver driver;

	@BeforeClass
	void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.cit.com/cit-bank/resources/calculators/certificate-of-deposit-calculator");
		driver.manage().window().maximize();
	}

	@Test
	void CD_CalcTest() throws IOException {
		String file = System.getProperty("user.dir") + "\\TestData\\FDCalcTestData.xlsx";
		ExcelUtility xl=new ExcelUtility(file);
		int rowCount = xl.getRow(file, "Sheet1");

		for (int i = 0; i <= rowCount; i++) {
			// read data from excel
			String IDA = xl.getCellData(file, "Sheet1", i, 0);
			String length = xl.getCellData(file, "Sheet1", i, 1);
			String IR = xl.getCellData(file, "Sheet1", i, 2);
			String compound = xl.getCellData(file, "Sheet1", i, 3);
			String total = xl.getCellData(file, "Sheet1", i, 4);

			// pass data to application

			WebElement IntiDep = driver.findElement(By.xpath("//*[@id='mat-input-0']"));
			IntiDep.clear();
			IntiDep.sendKeys(IDA);
			WebElement months = driver.findElement(By.xpath("//*[@id='mat-input-1']"));
			months.clear();
			months.sendKeys(length);
			WebElement intrest=driver.findElement(By.xpath("//*[@id='mat-input-2']"));
			intrest.clear();
			intrest.sendKeys(IR);
			driver.findElement(By.xpath("//*[@id='mat-select-0']")).click();
			driver.findElement(By.xpath("//*[@id='mat-select-value-1']//*[text()='Compounded Monthly']")).click();
			driver.findElement(By.xpath("//*[text()=' Let's run the numbers ']")).click();

			// validate data
			String ActualValue = driver.findElement(By.xpath("//*[@id='displayTotalValue']")).getText();
			if (total == ActualValue) {
				System.out.println("Test Passed");
				ExcelUtility.setCellData(file, "Sheet1", i, 7, "Passed");
				ExcelUtility.fillGreenColour(file, "Sheet1", i, 7);
			} else {
				System.out.println("Test Failed");
				ExcelUtility.setCellData(file, "Sheet1", i, 7, "Failed");
				ExcelUtility.fillRedColour(file, "Sheet1", i, 7);
			}
		}
	}

	@AfterClass
	void tearDown() {
		driver.close();
	}

}
