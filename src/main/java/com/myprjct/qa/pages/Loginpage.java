package com.myprjct.qa.pages;



import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myprjct.qa.base.BaseTest;

public class Loginpage extends BaseTest {

// page factories
	@FindBy(name="username")
	WebElement username;
	@FindBy(name="password")
	WebElement password;
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginbtn;
	@FindBy(xpath="//*[contains(text(),'Sign Up')]")
	WebElement signupbtn;
	@FindBy(xpath="//*[contains(@class,'navbar-brand')]/img")
	WebElement crmlogo;
	
	//driver initialize base class
	public Loginpage()throws IOException {
		PageFactory.initElements(driver, this);
		
	}
	 
	public String validateTitlePage() {
		return driver.getTitle();
	}
	public boolean validateCRMImage() {
		return crmlogo.isDisplayed();
	}
	public Homepage login(String un,String pswrd) throws IOException  {
		username.sendKeys(un);
		password.sendKeys(pswrd);
		//loginbtn.click();
    	JavascriptExecutor js = (JavascriptExecutor)driver;
    	js.executeScript("arguments[0].click();", loginbtn);
		return new Homepage();
	}
	
}
