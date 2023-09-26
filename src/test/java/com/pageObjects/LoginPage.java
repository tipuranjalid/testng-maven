package com.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);	// Super keyword is used to invoke parent class constructor	
	}
	
	//Elements
	@FindBy(xpath="//input[@name='username']")
	WebElement UserName;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement password;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement loginBtn;
	
	@FindBy(xpath="//img[@alt='profile picture']")
	WebElement profilePic;
	
	
	//Action methods
	public void setUserName(String usrNme) {
		UserName.sendKeys(usrNme);		
	}
	
	public void setPassword(String pswd) {
		password.sendKeys(pswd);
	}
	
	public void loginClick() {
		loginBtn.click();
	}
	
	public boolean cnfmProfilePic() {
		return profilePic.isDisplayed();		
	}
	
	

}
