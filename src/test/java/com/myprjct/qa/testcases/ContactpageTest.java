package com.myprjct.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.myprjct.qa.base.BaseTest;
import com.myprjct.qa.pages.Contactspage;
import com.myprjct.qa.pages.Dealspage;
import com.myprjct.qa.pages.Homepage;
import com.myprjct.qa.pages.Loginpage;
import com.myprjct.qa.utilitys.TestUtils;

public class ContactpageTest extends BaseTest {
	Loginpage loginpage;
	Homepage homepage;
	TestUtils testUtils;
	Contactspage contactspage;
	Dealspage dealspage;
	String sheetname="Contacts";

	public ContactpageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	@BeforeMethod
	public void setup() throws IOException {
		intialization();
		loginpage = new Loginpage();
		testUtils = new TestUtils();
		contactspage = new Contactspage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtils.switchtoframe();
		contactspage=homepage.clickOnContactLink();
	}
	@Test(priority=1)
	public void verifyContactPageLabel() {
		
		Assert.assertTrue(contactspage.verifyContactLable(),"contact label s missing on the page");
	
	}
	@Test(priority=2)
	public void selectSingleContactTest() {
		contactspage.selectContactByNames("jithu g");
	}
	@Test(priority=3)
	public void selectMultipleContactTest() {
		contactspage.selectContactByNames("jithu g");
		contactspage.selectContactByNames("veeru g");
	}
	@DataProvider
	public Object[][] getCrmTestData(){
		
		Object[][]data = testUtils.getTestData(sheetname);
		return data;
	}
	@Test(priority=4)
	public void validateCreateNewContact(String title,String ftName,String ltName,String position) {
		homepage.clickonNewContactLink();
		contactspage.createNewContact(title, ftName, ltName, position);

}
	
}	
	
	
	
	
	
