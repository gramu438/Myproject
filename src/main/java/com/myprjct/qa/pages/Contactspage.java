package com.myprjct.qa.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.myprjct.qa.base.BaseTest;

public class Contactspage extends BaseTest {
	

	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement contactlable;
	@FindBy(name="title")
	WebElement title;
	@FindBy(id="first_name")
	WebElement first_name;
	@FindBy(id="surname")
	WebElement last_name;
	@FindBy(id="company_position")
	WebElement positions;
	@FindBy(xpath="//*[@id='contactForm']//table//td/input[@type='submit'][1]")
	WebElement savebtn;
	
	public Contactspage() throws IOException {
		PageFactory.initElements(driver, this);
	}
	public boolean verifyContactLable() {
		return contactlable.isDisplayed();
		
	}
	public void selectContactByNames(String name) {
		driver.findElement
		(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']"
				+ "//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();;
		
	}
	public void createNewContact(String title,String ftName,String ltName,String position) {
		Select select=new Select(driver.findElement(By.name(title)));
		first_name.sendKeys(ftName);
		last_name.sendKeys(ltName);
		positions.sendKeys(position);
		savebtn.click();
	}
	
}
