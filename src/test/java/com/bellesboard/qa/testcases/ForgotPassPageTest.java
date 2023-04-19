package com.bellesboard.qa.testcases;

import org.testng.annotations.Test;

import com.bellesboard.qa.base.TestBase;
import com.bellesboard.qa.pages.HomePage;
import com.bellesboard.qa.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

public class ForgotPassPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;	
	WebDriver wait;	
	
	public ForgotPassPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();		
	}
		
	  	
	  @Test(priority = 1)
	  public void forgotPassPage() {
		  System.out.println("Forgot Password Page Test");
		
		  Assert.assertEquals(driver.getTitle(), "Login");
		  driver.findElement(By.id("forgot")).isDisplayed();
		  driver.findElement(By.id("forgot")).click(); //Click on Forgot Password link
					  
		  driver.findElement(By.id("email1")).isDisplayed();
		  driver.findElement(By.id("forgot_password_submit")).isDisplayed();
		  //driver.findElement(By.id("email1")).sendKeys("vikash2060t@gmail.com");
		  driver.findElement(By.id("email1")).sendKeys("rahul5@mailcatch.com");
		  driver.findElement(By.id("forgot_password_submit")).click();		  
		  driver.findElement(By.xpath("//*[@id=\"forgot_good\"]/div/div")).isDisplayed();	  
		  //driver.quit();
	  }
	  
	  @Test(priority = 2)
	  public void verifyEmail() {
		  loginPage = new LoginPage();
		  driver.get("http://mailcatch.com/en/disposable-email");
		  driver.findElement(By.xpath("//*[@id=\"mailboxform\"]/input[1]")).sendKeys("rahul5@mailcatch.com");
		  driver.findElement(By.xpath("//*[@id=\"mailboxform\"]/input[2]")).click();
		  driver.findElement(By.xpath("//a[contains(text(),'BellesBoard - Password Reset')]")).isDisplayed();
		  driver.findElement(By.xpath("//a[contains(text(),'BellesBoard - Password Reset')]")).click();
		 		  
		  driver.switchTo().frame("emailframe");
		 			  
		  String heading = driver.findElement(By.partialLinkText("https://app.bellesboard.com/index.cfm?p=login&fpwd=")).getText();
      		System.out.println(heading);
      		
      		driver.get(heading);
      	      		
      		String pass = RandomStringPwd();
      		System.out.println(pass);
      		
      		driver.findElement(By.id("NewPassword")).isDisplayed();
      		driver.findElement(By.id("NewPassword")).sendKeys(pass);
      		driver.findElement(By.id("NewPassword_submit")).click();
      		try {
			    Thread.sleep(1000);                 //1000 milliseconds is one second.
			} catch(InterruptedException ex) {
			    Thread.currentThread().interrupt();
			}
      		
  		  loginPage.login("rahul5@mailcatch.com", pass);
		  
	  }
	  /*
	  @Test(priority = 3)
	  public void checkNewLogin() {
		  loginPage = new LoginPage();
		  loginPage.login(prop.getProperty("ForgetPassUsername"), prop.getProperty("New Password"));
	  }*/
	  
	  //@AfterTest
	  @AfterMethod(alwaysRun = true)
	  public void tearDown() {
			driver.quit();
		}

}
