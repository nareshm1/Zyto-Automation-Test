package com.zyto.test.TestCases;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.zyto.test.ConsoleColors.Console_Colors;
import com.zyto.test.base.ZytoBase;
import com.zyto.test.pages.Create_New_Account_Page;
import com.zyto.test.pages.Introduction_Page;
import com.zyto.test.pages.Login_Page;
import com.zyto.test.pages.Signup_Options_page;
import com.zyto.test.util.java.ConstantKeywords;
import com.zyto.test.util.java.ElementLocatorUtils;
import com.zyto.test.util.java.JavascriptUtil;

public class Registrations_With_Passwords extends ZytoBase {
	// Pages to Used //
	ZytoBase zytobase;
	Console_Colors concol;
	Introduction_Page intropage;
	ConstantKeywords ConstKeys;
	static ElementLocatorUtils el;
	JavascriptUtil jl;
	Introduction_Page_Test intropagetest;
	Login_Page loginpage;
	Create_New_Account_Page createnewaccountpage;
	Signup_Options_page Signuppage;

	public Registrations_With_Passwords() {
		super();
	}

	// Init()
	@BeforeMethod
	public void SetUp() throws InterruptedException {
		zytobase = new ZytoBase();
		prop = zytobase.init_prop();
		driver = zytobase.init_driver(prop);
		zytobase.EventFire();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		Thread.sleep(10000);
		long waitTime = 10;
		WebDriverWait wait = new WebDriverWait(driver, waitTime);
		System.out.println(
				concol.BLUE_BOLD_BRIGHT + "****USE CASE : Registration With Passwords -----> Test Started****" + concol.RESET);
		intropage = new Introduction_Page(driver);
		jl = new JavascriptUtil(driver);
		intropagetest = new Introduction_Page_Test();
		loginpage = new Login_Page(driver);
		createnewaccountpage = new Create_New_Account_Page(driver);
		Signuppage = new Signup_Options_page(driver);

	}

	@Test(description ="Verify that the user should be navigating to the “Create Profile” page, when clicks on the “Create New Account page.")
	public void TC_006_Verify_Registration_with_Password() throws InterruptedException {
		
		driver.get(prop.getProperty("url2"));
		Thread.sleep(5000);

		intropage.scrollTo(intropage.intropage_continuebutton());
		Thread.sleep(3000);
		
		intropage.Click_Continue_button();
		Thread.sleep(5000);
		
		Signuppage.Click_Signup_btn();
		Thread.sleep(3000);
		
		Assert.assertTrue(createnewaccountpage.FirstName().isDisplayed());
	}
	
	@Test(description="Verify that the user should be navigating to the Account home page if already logged in with an insight user account")
	public void TC_007_Verify_Registration_For_Logged_In_User() {
		
	}
}
