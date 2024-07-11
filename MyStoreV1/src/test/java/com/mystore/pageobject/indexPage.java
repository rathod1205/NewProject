package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class indexPage {

	// create object of webdriver 
	WebDriver ldriver;
	
	//create constructor
	public indexPage(WebDriver rdriver) {
		ldriver =rdriver;
		
		PageFactory.initElements(rdriver, this);
	}
	
	//identify webelement
	@FindBy(linkText = "Sign in")
	WebElement signIn;
	
	
	//identify action
	public void clickOnSignIn() {
		signIn.click();
	}
}
