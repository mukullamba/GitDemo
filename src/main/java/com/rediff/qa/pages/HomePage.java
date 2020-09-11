package com.rediff.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.rediff.qa.base.TestBase;

public class HomePage extends TestBase{
	
	//PageFactory or OR
	@FindBy(xpath="//a[@class='mailicon']")
	WebElement RediffMailIcon;
	
	@FindBy(xpath="//a[@class='moneyicon relative']")
	WebElement MoneyIcon;
	
	@FindBy(xpath="//a[@title='Online Shopping']")
	WebElement ShoppingIcon;
	
	@FindBy(xpath="//a[text()='Sign in']")
	WebElement SignIn;
	
	@FindBy(xpath="//a[text()='Create Account']")
	WebElement HomeSignUp;
	
	@FindBy(xpath="//span[@class='hmsprite logo']")
	WebElement RediffLogo;
	
	@FindBy(xpath="//span[@id='nseindex']")
	WebElement NSEIndenx;
	
	//Initializing the page factory
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	//Features/Methods
	public String validateHomePageTitle() {
		return driver.getTitle();
	}

	public Boolean validateLogo() {
		return RediffLogo.isDisplayed();
	}
	
	public LoginPage validateLoginPage() {
		SignIn.click();
		return new LoginPage();
	}
	
	public ShoppingPage validateShoppingPage() {
		ShoppingIcon.click();
		return new ShoppingPage();
	}
	
	public String validateNSE() {
		return NSEIndenx.getText();
	}
}

