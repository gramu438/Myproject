package com.myprjct.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.myprjct.qa.utilitys.TestUtils;
import com.myprjct.qa.utilitys.WebEventListener;

public class BaseTest {
	
	public static WebDriver driver;
	public static Properties prop;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	 
	public BaseTest() throws IOException {
		try {
			prop=new Properties();
			FileInputStream fip=new FileInputStream("D:\\ram\\Myproject\\src\\main\\java\\com\\myprjct\\qa\\configpro\\crmpageconfig.properties");
			prop.load(fip);
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	 public static void intialization() throws IOException {
		 String browsername=prop.getProperty("browser");
		 if(browsername.equals("chrome")) {
			 System.setProperty("WebDriver.chrome.driver", "D:\\ram\\Myproject\\Drivers\\chromedriver.exe");
			 driver=new ChromeDriver();
		 }else  if(browsername.equals("ff")) {
			 System.setProperty("WebDriver.gecko.driver", "D:\\ram\\Myproject\\Drivers\\geckodriver.exe");
			 driver=new FirefoxDriver();
		 }
		 else  if(browsername.equals("IE")) {
			 System.setProperty("WebDriver.IE.driver", "D:\\ram\\Myproject\\Drivers\\IEDriver.exe");
			 driver=new InternetExplorerDriver();
		 }
			
			e_driver = new EventFiringWebDriver(driver);
			// Now create object of EventListerHandler to register it with EventFiringWebDriver
			eventListener = new WebEventListener();
			e_driver.register(eventListener);
			driver = e_driver;
		 driver.manage().window().maximize();
		 driver.manage().deleteAllCookies();
		 driver.manage().timeouts().pageLoadTimeout(TestUtils.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		 driver.manage().timeouts().implicitlyWait(TestUtils.IMPLICTY_WAIT, TimeUnit.SECONDS);
		 driver.get(prop.getProperty("url"));
	}

}
