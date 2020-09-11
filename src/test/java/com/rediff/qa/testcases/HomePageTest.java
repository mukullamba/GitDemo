package com.rediff.qa.testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.rediff.qa.ExtentReportListener.ExtentReportListener;
import com.rediff.qa.base.TestBase;
import com.rediff.qa.pages.HomePage;
import com.rediff.qa.pages.LoginPage;
import com.rediff.qa.util.TestUtil;
import com.sun.tools.sjavac.Log;

public class HomePageTest extends TestBase{
	
	HomePage HP;
	LoginPage LP;
	TestUtil TU;
	Logger log;
		
	public HomePageTest() {
		super();
	}
	
	
	@BeforeMethod
	public void setup(ITestResult result) {
		Initialize();
		log = LogManager.getLogger(result.getMethod().getMethodName());
		HP = new HomePage();	
		TU = new TestUtil();
	}
	
	//test cases should be independent - separate
	//before each test case, launch the browser
	//after each test case, close the browser
	@Test(priority=1)
	public void validateHomeTitleTest() {
		String title = HP.validateHomePageTitle();
		System.out.println(title);
		log.debug("Title validated");
		Assert.assertEquals(title,"Rediff.com: News | Rediffmail | Stock Quotes | Shopping");
		
	}
	
	@Test(priority=2, enabled=false)
	public void validateHomePageLogoTest() {
		Assert.assertTrue(HP.validateLogo());
		
	}
	
	@Test(priority=3, enabled=false)
	public void validateHomeToLoginPageTest() {
		LP = HP.validateLoginPage();
		
		
	}
	
	@Test(priority=4, enabled=false) 
	public void validateNSETest() {
		TU.switchToFrame("moneyiframe");
		System.out.println("The NSE index is at "+HP.validateNSE());
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
