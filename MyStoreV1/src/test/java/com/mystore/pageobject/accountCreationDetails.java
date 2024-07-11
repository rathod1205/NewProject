package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class accountCreationDetails {
	
	WebDriver ldriver;
	
	//create constructor
	public accountCreationDetails(WebDriver rdriver) {
		ldriver =rdriver;
		
		PageFactory.initElements(rdriver, this);
	}
	
	//identify webelement
	@FindBy(id = "id_gender1") //title mrs
	WebElement titleMr;
	
	
	@FindBy(id = "customer_firstname")
	WebElement custFirstName;
	
	@FindBy(id="customer_lastname")
	WebElement custLastName;
	
	@FindBy(id="passwd")
	WebElement password;
	
	@FindBy(id="submitAccount")
	WebElement registerAccount;
	
	//actions
	
	public void selectTitleMr() {
		titleMr.click();
		
	}
	public void enterCustomerFirstName(String fname) {
		custFirstName.sendKeys(fname);
	}
	
	public void enterCustomersLastName(String lname) {
		custLastName.sendKeys(lname);
	}
	
	public void enterPassword(String pass) {
		password.sendKeys(pass);
	}
	
	public void Register() {
		registerAccount.click();
	}

}
