package com.myprjct.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.myprjct.qa.base.BaseTest;
import com.myprjct.qa.pages.Contactspage;
import com.myprjct.qa.pages.Dealspage;
import com.myprjct.qa.pages.Homepage;
import com.myprjct.qa.pages.Loginpage;
import com.myprjct.qa.utilitys.TestUtils;

public class HomepageTest extends BaseTest {
	Loginpage loginpage;
	Homepage homepage;
	TestUtils testUtils;
	Contactspage contactspage;
	Dealspage dealspage;

	public HomepageTest() throws IOException {
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
	}
	@Test(priority=1)
	public void verifyHomepageTitleTest() {
		String homepagetitle = homepage.verifyHomepageTitle();
		Assert.assertEquals(homepagetitle, "CRMPRO","home page title is not matched");
	}
	@Test(priority=2)
	public void verifyUsernameTest() {
		testUtils.switchtoframe();
		Assert.assertTrue(homepage.verifyCorrectUsername());
		
	}
	@Test(priority=3)
	public void verifyContactLinkTest() throws IOException {
		testUtils.switchtoframe();
		contactspage=homepage.clickOnContactLink();
	}
	@Test(priority=3)
	public void verifyDealsLinkTest() {
		testUtils.switchtoframe();
		 dealspage = homepage.clickOnDealsLink();
	}
	

}
