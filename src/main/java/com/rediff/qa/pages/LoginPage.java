package com.rediff.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.rediff.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	//PageFactory
	@FindBy(xpath="//form[@name='loginform']")
	WebElement LoginForm;
	
	@FindBy(name="login")
	WebElement username;
	
	@FindBy(name="passwd")
	WebElement password;
	
	@FindBy(xpath="//input[@title='Sign in']")
	WebElement submit;
	
	@FindBy(xpath="//*[text()='Create a new account']")
	WebElement LoginSignUp;
	
	@FindBy(xpath="//cite[@class='rd_usr_log']/a")
	WebElement LoggedInUser; 
	
	@FindBy(xpath="//a[text()='rediff.com']")
	WebElement LinkToHome;
	
	//Initialising pagefacroty
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Features/Methods
	
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public void validatelogin(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		submit.click();
	}
	
	public Boolean validateLoginForm() {
		return LoginForm.isDisplayed();
	}
	
	public Boolean validateLoggedInUser() {
		System.out.println(LoggedInUser.getText());
		return LoggedInUser.getText().contains("MUKUL");
	}
	
	public HomePage validateNavigateRediffToHome() {
		LinkToHome.click();
		return new HomePage();
	}
	
}
