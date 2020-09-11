package com.rediff.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.rediff.qa.util.TestUtil;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream("C:\\Users\\mlamba\\eclipse-workspace-framework\\POMRediffTest\\src\\main\\java\\com\\rediff\\qa\\config\\config.properties");
			prop.load(fis);
			
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void Initialize() {
		
		String browserName = prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\mlamba\\Documents\\Test Automation\\chromedriver.exe");
			driver = new ChromeDriver();
	}	else if(browserName.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\mlamba\\Documents\\Test Automation\\geckodriver.exe");
			driver = new FirefoxDriver();
	}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_Load_Timeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.Implicit_Wait, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
	}
	
	public void getScreenshot(String testcasename) throws IOException {
		TakesScreenshot TS = (TakesScreenshot) driver;
		File source = TS.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"\\screens\\"+testcasename+".png";
		FileUtils.copyFile(source,new File(destinationFile));
		
	}
}