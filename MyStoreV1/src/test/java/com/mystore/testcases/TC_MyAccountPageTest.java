package com.mystore.testcases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mystore.pageobject.accountCreationDetails;
import com.mystore.pageobject.indexPage;
import com.mystore.pageobject.myAccount;
import com.mystore.pageobject.registeredUserAccount;

public class TC_MyAccountPageTest extends BaseClass {
	
	@Test(enabled=false)
	public void verifyRegistrationAndLogin() {
		// LaunchBrowser
		
		indexPage pg =new indexPage(driver);
		pg.clickOnSignIn();
		logger.info("Clicked on SignIn Button");
		
		myAccount myAccpg = new myAccount(driver);
		myAccpg.enterCreateEmailAddress("rathodk1205@gmail.com");
		logger.info("entered email");
		myAccpg.clickSubmit();
		logger.info("Clicked on submit  Button");
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		accountCreationDetails accCreationPg = new accountCreationDetails(driver);
		
		accCreationPg.selectTitleMr();
		logger.info("title mr is selected");
		accCreationPg.enterCustomerFirstName("Krushna");
		logger.info("entered first name");
		accCreationPg.enterCustomersLastName("rathod");
		logger.info("entered last name");
		accCreationPg.enterPassword("Krushna@123");
		logger.info("entered password");
		accCreationPg.Register();
		logger.info("clicked on register button");
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		registeredUserAccount registeredUserAcc = new registeredUserAccount(driver);
		String username = registeredUserAcc.getUserName();
		
		Assert.assertEquals("Krushna rathod", username); 
		logger.info("verified username");
		
		
		
	}
	@Test
	public void verifyLogin() throws IOException {
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		indexPage pg =new indexPage(driver);
		pg.clickOnSignIn();
		logger.info("Clicked on SignIn Button");
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		myAccount myAccpg = new myAccount(driver);
		myAccpg.enterLoginEmailAddress("rathodk1205@gmail.com");
		logger.info("emtered email address");
		myAccpg.enterLoginPassword("Krushna@123");
		logger.info("entered password");
		myAccpg.clickLogin();
		logger.info("Clicked on Login Button");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		registeredUserAccount registeredUserAcc = new registeredUserAccount(driver);
		String userName = registeredUserAcc.getUserName();
		
		if(userName.equals("Krushna Rathod") ) {
			logger.info("Verify login --passed");
			
			Assert.assertTrue(true);
			
		} else {
			logger.info("Verify login --failed");
			captureScreenshots(driver,"verifyLogin");
			Assert.assertTrue(false);
		}
		
	}

}
