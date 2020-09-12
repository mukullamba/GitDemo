package com.rediff.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.rediff.qa.base.TestBase;
import com.rediff.qa.pages.HomePage;
import com.rediff.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	
	HomePage HP;
	LoginPage LP;
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		Initialize();
		HP = new HomePage();
		LP = HP.validateLoginPage();
	}
	
	@Test(priority=1)
	public void validateLoginPageTitleTest() {
	Assert.assertEquals(LP.validateLoginPageTitle(),"Rediffmail","Login Page title is not matched");	
	System.out.println("Login page title validated");
	}
	
	@Test(priority=2)
	public void validateLoginFormTest() {
	Assert.assertTrue(LP.validateLoginForm());	
	}
	
	@Test(priority=3)
	public void validateLoggedInPageTest() {
		LP.validatelogin(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertTrue(LP.validateLoggedInUser());
		HP=LP.validateNavigateRediffToHome();
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
