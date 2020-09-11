package com.rediff.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.rediff.qa.base.TestBase;

public class ShoppingPage extends TestBase{

	//pagefactory
	@FindBy(xpath="//img[@class='shsprite shoptoplogo']")
	WebElement ShoppingPageLogo;
	
	@FindBy(xpath="//input[@id='srchword']")
	WebElement Searchbar;
	
	@FindBy(xpath="//input[@value='Search']")
	WebElement SearchButton;
	
	@FindBy(xpath="//div[@class='floatL f14 mtop2']")
	WebElement ResultCount;
	
	public ShoppingPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateShoppingPageTitle() {
		return driver.getTitle(); 
	}
	
	public boolean validateShoppingLogo() {
		return ShoppingPageLogo.isDisplayed();
	}
	
	public void validateSearch(String item, String value) throws InterruptedException {
		Searchbar.sendKeys(item);
		SearchButton.click();
		Select select = new Select(driver.findElement(By.xpath("//select[@name='sorting']")));
		select.selectByValue(""+item+""+value+"");
		Thread.sleep(2000);
		String ItemCount = ResultCount.getText();
		System.out.println("The search found "+ItemCount);
	}
	
}
