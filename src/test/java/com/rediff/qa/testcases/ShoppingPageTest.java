package com.rediff.qa.testcases;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.rediff.qa.base.TestBase;
import com.rediff.qa.pages.HomePage;
import com.rediff.qa.pages.LoginPage;
import com.rediff.qa.pages.ShoppingPage;
import com.rediff.qa.util.TestUtil;

public class ShoppingPageTest extends TestBase {
	
	HomePage HP;
	LoginPage LP;
	ShoppingPage SP;
	String sheetname = "Search";  
	TestUtil TU;
			
	public ShoppingPageTest() {
		super();
	}
	

	@BeforeMethod
	public void setup(ITestResult result) {
		Initialize();
		HP = new HomePage();
		LP = HP.validateLoginPage();
		LP.validatelogin(prop.getProperty("username"), prop.getProperty("password"));
		LP.validateNavigateRediffToHome();
		SP = HP.validateShoppingPage();
		TU = new TestUtil();
	}
	
	@Test
	public void validateShoppingTitleTest() {
		Assert.assertEquals(SP.validateShoppingPageTitle(),"Online Shopping Site India: Shop Online At Best Store | Buy Mobiles, T-Shirts, Power Banks - Rediff Shopping");
		}
	
	@Test(enabled=false)
	public void validateShoppingLogoTest() {
		Assert.assertTrue(SP.validateShoppingLogo());
		
	}
	
	@DataProvider
	public Object[][] getTestData() {
		Object data[][] = TU.getTestData(sheetname);
		return data;
	}
	
	@Test(dataProvider = "getTestData",enabled=false)
	public void validateSearchTest(String item, String value) throws InterruptedException {
		SP.validateSearch(item, value);
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
		
	}
}
