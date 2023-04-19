package com.bellesboard.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bellesboard.qa.base.TestBase;

public class LoginPage extends TestBase{

	//Page Factory
	@FindBy(name = "username")
	WebElement username;
	
	@FindBy(name = "password")
	WebElement password;
	
	@FindBy(name = "btnLogin")
	WebElement btnLogin;
	
	@FindBy(id = "forgot")
	WebElement forgot;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyTitle() {
		return driver.getTitle();
	}
	
	public void login(String un, String ps) {
		username.sendKeys(un);
		password.sendKeys(ps);
		btnLogin.click();
		try {
		    Thread.sleep(1000);                 //1000 milliseconds is one second.
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
		
	}
	
	
	
}
