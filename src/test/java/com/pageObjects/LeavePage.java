package com.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LeavePage extends BasePage {

	public LeavePage(WebDriver driver) {
		super(driver);
	}
	//Elements
	@FindBy(xpath="//*[text()='Leave']")
	WebElement leave;
	
	//Action methods
	public void clickLeave() {
		leave.click();
	}
	
}
