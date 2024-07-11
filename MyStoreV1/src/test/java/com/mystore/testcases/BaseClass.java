package com.mystore.testcases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import com.mystore.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	ReadConfig readConfig= new ReadConfig();
	
	String url = readConfig.getBaseUrl();
	String browser = readConfig.getBrowser();
	long time = 2000;
	
	public static WebDriver driver;
	
	public static Logger logger;
	
	@BeforeClass
	public void setup() {
		
		//String browser ="chrome";
		switch(browser.toLowerCase()) {
		
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
			break;
					
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
			break;	
			
		default:
			driver=null;
			break;
		}
		
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
		logger= LogManager.getLogger("MystoreV1");	
		
		driver.get(url);
		driver.manage().window().maximize();
		logger.info("url Opened");
	}
	
/*	@AfterClass
	public void tearDown() {
		driver.close();
		driver.quit(); 
	} */
	
	public void captureScreenshots(WebDriver driver,String testName) throws IOException {
		
		TakesScreenshot screenshot = ((TakesScreenshot)driver);
		
		File src = screenshot.getScreenshotAs(OutputType.FILE);
		
		File dest = new File(System.getProperty("user.dir") + "//Screenshots//" + testName + ".png");
		
		//step3: copy image file to destination
		FileUtils.copyFile(src, dest);
		
	
}
}
