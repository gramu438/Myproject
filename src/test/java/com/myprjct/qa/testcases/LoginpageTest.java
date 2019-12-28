package com.myprjct.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.myprjct.qa.base.BaseTest;
import com.myprjct.qa.pages.Homepage;
import com.myprjct.qa.pages.Loginpage;

public class LoginpageTest  extends BaseTest {
	
	Loginpage  loginpage;
	Homepage  homepage;
	
	public LoginpageTest() throws IOException {
		super();
	
	}
	
	@BeforeMethod
	public void setup() throws IOException {
		intialization();
		loginpage=new Loginpage();
	}
	@Test(priority=1)
	public void loginPageTitleTest() {
		String title = loginpage.validateTitlePage();
		Assert.assertEquals(title, "CRMPRO  - CRM software for customer relationship management, sales, and support.");
	}
	@Test(priority=2)
	public void crmlogImgTest() {
		boolean flag = loginpage.validateCRMImage();
		Assert.assertTrue(flag);
	}
	@Test(priority=3)
	public void loginTest() throws IOException {
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}




