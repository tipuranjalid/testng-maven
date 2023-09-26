package com.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyInfoPage extends BasePage {
	public MyInfoPage(WebDriver driver) {
		super(driver);
	}
	
	//Elements
	@FindBy(xpath="//*[text()='My Info']")
	WebElement myInfo;
	
	@FindBy(xpath="//input[@name='firstName']")
	WebElement firstName;
	
	@FindBy(xpath="//input[@name='lastName']")
	WebElement lastName;
	
	@FindBy(xpath="//div[*/*[text()='Employee Id']]//input")
	WebElement EmpId;
	
	@FindBy(xpath="//div[*/*[text()=\"Female\"]]//input")
	WebElement gender;
	
	@FindBy(xpath="//div[*/*[text()=\"Smoker\"]]//input")
	WebElement smokerCheck;
	
	@FindBy(xpath="//div[*[@type='submit']]//button")
	WebElement savebtn;
	
	//Action methods
	public void clickMyInfo() {
		myInfo.click();
	}
	
	public void setFirstName(String firstN) {
		firstName.sendKeys(firstN);
	}
	
	public void setLastName(String lastN) {
		lastName.sendKeys(lastN);
	}
	
	public void setEmployeeId(String eId) {
		EmpId.sendKeys(eId);
	}
	
	public void clickGender() {
		gender.click();
	}
	
	public void clickSmokerCheckBox() {
		smokerCheck.click();
	}
	
	public void clickSavebtn() {
		savebtn.click();
	}
	

}
