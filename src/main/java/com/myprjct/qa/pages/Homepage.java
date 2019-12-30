package com.myprjct.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myprjct.qa.base.BaseTest;

public class Homepage extends BaseTest {
	@FindBy(xpath="//td[contains(text(),'User: ram g')]")
	WebElement usernamelable;
	@FindBy(xpath="//*[@id=\"navmenu\"]/ul/li[4]/a")
	WebElement contactLink;
	@FindBy(xpath="//*[@id=\"navmenu\"]/ul/li[4]/ul/li[1]/a")
	WebElement newcontactLink;
	
	@FindBy(xpath="//*[@id=\"navmenu\"]/ul/li[5]/a")
	WebElement dealsLink;
	
	public Homepage()throws IOException {
		PageFactory.initElements(driver, this);
	}
	public String verifyHomepageTitle() {
		return driver.getTitle();
		
	}
	public boolean verifyCorrectUsername() {
		return usernamelable.isDisplayed();
		
	}
	public Contactspage clickOnContactLink() throws IOException {
		contactLink.click();
		return new Contactspage();
	}
	public Dealspage clickOnDealsLink() {
		dealsLink.click();
		return new Dealspage();
	}
	public void clickonNewContactLink() {
		Actions actions=new Actions(driver);
		actions.moveToElement(contactLink).build().perform();
		newcontactLink.click();
	}
	
	
	
	
}
