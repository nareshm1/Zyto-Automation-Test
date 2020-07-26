package com.zyto.test.base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.zyto.test.pages.Signup_Options_page;

public class ZytoBaseTest {
	public WebDriver driver;

	public ZytoBase zytobase;
	public Signup_Options_page Signupoptionspage;
	public Properties prop;


	@BeforeMethod
	/**
	 * this method is used to initialize the WebDriver on the basis of browser
	 * 
	 * @param browser
	 * @return driver
	 */
	@Parameters("browser")
	
	  @BeforeTest
	  public void setUp(String browserName) throws InterruptedException{ 
	  zytobase = new ZytoBase();
	  prop = zytobase.init_prop();
	  prop.setProperty("browser", browserName); 
	  driver =zytobase.init_driver(prop); 
	  driver.wait(3000);
	  System.out.println("ZytoTest"); 
	  zytobase.EventFire();
	  //Signupoptionspage = new Signup_Options_page(driver);
	  System.out.println("basetest");
	  }
	 
	@AfterMethod
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
