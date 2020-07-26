package com.zyto.test.TestCases;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.zyto.test.ConsoleColors.Console_Colors;
import com.zyto.test.base.ZytoBase;
import com.zyto.test.pages.Introduction_Page;
import com.zyto.test.pages.Signup_Options_page;
import com.zyto.test.util.java.ConstantKeywords;
import com.zyto.test.util.java.ElementLocatorUtils;
import com.zyto.test.util.java.JavascriptUtil;

public class Introduction_Page_Test extends ZytoBase {

	// Pages to Used //
	ZytoBase zytobase;
	Console_Colors concol;
	Introduction_Page intropage;
	ConstantKeywords ConstKeys;
	static ElementLocatorUtils el;
	JavascriptUtil jl;

	public Introduction_Page_Test() {
		super();
	}

	// Init()
	@BeforeMethod
	public void SetUp() throws InterruptedException {
		zytobase = new ZytoBase();
		prop = zytobase.init_prop();
		driver = zytobase.init_driver(prop);
		zytobase.EventFire();
		driver.get(prop.getProperty("url2"));
		driver.manage().window().maximize();
		Thread.sleep(10000);
		long waitTime = 10;
		WebDriverWait wait = new WebDriverWait(driver, waitTime);
		System.out.println(concol.BLUE_BOLD_BRIGHT + "****I am on Introduction Page to Test****" + concol.RESET);
		intropage = new Introduction_Page(driver);
		jl =  new  JavascriptUtil(driver);

	}

	@Test
	public void Intro_Page_Test() throws InterruptedException {

		// Validating content on page Thread.sleep(5000);
		Assert.assertFalse(intropage.Validate_Content().isEmpty());
		Thread.sleep(3000);

		Thread.sleep(5000);
		// Clicking on the continue
		intropage.Click_Continue_button();
		Thread.sleep(3000);

		// Validate the landing page
		//Assert.assertEquals(driver.getCurrentUrl(), prop.getProperty("url"));

	}

	@AfterMethod
	public void EndTest() {
		System.out.println(concol.BLUE_BOLD_BRIGHT + "****Quitting the browser****" + concol.RESET);
		driver.quit();
	}

}
