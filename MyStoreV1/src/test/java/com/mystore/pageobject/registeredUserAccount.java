package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class registeredUserAccount {
WebDriver ldriver;
	
	//create constructor
	public registeredUserAccount(WebDriver rdriver) {
		ldriver =rdriver;
		
		PageFactory.initElements(rdriver, this);
	}
	
	//identify webelement
	@FindBy(xpath = "//a[@title='View my customer account']") //user name after registration
	WebElement userName;
	
	public String getUserName() {
		String text= userName.getText();
		return text;
	}

}
