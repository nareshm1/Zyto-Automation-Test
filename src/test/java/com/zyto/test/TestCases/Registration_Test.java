package com.zyto.test.TestCases;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
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

public class Registration_Test extends ZytoBase {
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

	public Registration_Test() {
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
				concol.BLUE_BOLD_BRIGHT + "****USE CASE : Registration -----> Test Started****" + concol.RESET);
		intropage = new Introduction_Page(driver);
		jl = new JavascriptUtil(driver);
		intropagetest = new Introduction_Page_Test();
		loginpage = new Login_Page(driver);
		createnewaccountpage = new Create_New_Account_Page(driver);
		Signuppage = new Signup_Options_page(driver);

	}

	@Test(description = "To verify the Sign Up to Use ZYTO Insights Pro introduction page Quote details", testName = "Verify Introduction Page and Quote details")
	public void TC_001_Verify_introduction_Page() throws InterruptedException {
		driver.get(prop.getProperty("url"));
		intropagetest.Intro_Page_Test();
	}

	@Test(description = "To verify the “Continue” button functionality on Introduction page ")
	public void TC_002_Verify_continue_button_on_introdution_page() throws InterruptedException {
		driver.get(prop.getProperty("url"));
		intropage.Click_Continue_button();
	}

	@Test(description = "To verify the continue button functionality if already logged in with an insight user account")
	public void TC_003_Verify_navigation_for_Logged_in_User() throws InterruptedException {
		Signuppage.Click_Sign_In_btn();
		Thread.sleep(10000);

		// Enter Email and password ,then click sigin button
		loginpage.LoginEmail().click();
		Thread.sleep(2000);
		loginpage.Login_Email_Input(prop.getProperty("username"));
		Thread.sleep(2000);
		loginpage.LoginPassword().click();
		loginpage.Login_Password_Input(prop.getProperty("password"));

		loginpage.Sigin_button_Click();
		Thread.sleep(10000);

	}

	@Test(description = "To verify the “Create New Account” button functionality on Signup options page.")
	public void TC_004_Verify_Create_New_Account_button() throws InterruptedException {
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

	
	@Test(description="To verify the “Sign in “ button functionality on Signup options page.")
	public void TC_005_Verify_Singin_button() throws InterruptedException {
		driver.get(prop.getProperty("url2"));
		Thread.sleep(5000);

		intropage.scrollTo(intropage.intropage_continuebutton());
		Thread.sleep(10000);
		
		intropage.Click_Continue_button();
		Thread.sleep(10000);
		
		Signuppage.Click_Sign_In_btn();
		Thread.sleep(10000);
		
		Assert.assertTrue(loginpage.LoginEmail().isDisplayed());
	}
	

	@AfterMethod
	public void EndTest() {
		System.out.println(concol.BLUE_BOLD_BRIGHT + "****Quitting the browser****" + concol.RESET);
		driver.quit();
	}

}
