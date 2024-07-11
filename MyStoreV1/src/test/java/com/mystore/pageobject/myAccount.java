package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class myAccount {


	// create object of webdriver 
	WebDriver ldriver;
	
	//create constructor
	public myAccount(WebDriver rdriver) {
		ldriver =rdriver;
		
		PageFactory.initElements(rdriver, this);
	}
	
	//identify webelement
		@FindBy(name = "email_create")
		WebElement createEmailId;
		
		@FindBy(id="SubmitCreate")
		WebElement submitCreate;
		
		@FindBy(id = "email")
		WebElement email;
		
		@FindBy(id="passwd")
		WebElement pwd;
		
		@FindBy(name="SubmitLogin")
		WebElement loginBtn;
		
		//Identify action on webElement
		public void enterCreateEmailAddress(String emailAdd) {
			createEmailId.sendKeys(emailAdd);
		}
		
		public void clickSubmit() {
			submitCreate.click();
		}
		
		public void enterLoginEmailAddress(String loginEmailAdd) {
			email.sendKeys(loginEmailAdd);
		}
		
		public void enterLoginPassword(String passwd) {
			pwd.sendKeys(passwd);
			
		}
		
		public void clickLogin() {
			loginBtn.click();
		}
		
		
		

}
