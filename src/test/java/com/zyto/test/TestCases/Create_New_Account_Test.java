
package com.zyto.test.TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.zyto.test.ConsoleColors.Console_Colors;
import com.zyto.test.Util_Pages.All_Pages;
import com.zyto.test.Util_Tests.All_Tests;
import com.zyto.test.base.ZytoBase;
import com.zyto.test.pages.Create_New_Account_Page;
import com.zyto.test.pages.Introduction_Page;
import com.zyto.test.pages.Signup_Options_page;
import com.zyto.test.util.java.ConstantKeywords;
import com.zyto.test.util.java.ElementLocatorUtils;
import com.zyto.test.util.java.JavascriptUtil;

public class Create_New_Account_Test extends ZytoBase {

	// Pages to Used //
	ZytoBase zytobase;
	Console_Colors concol;
	Introduction_Page intropage;
	ConstantKeywords ConstKeys;
	static ElementLocatorUtils el;
	JavascriptUtil jl;
	Create_New_Account_Page createnewaccountpage;
	Introduction_Page_Test intropagetest;
	Signup_Options_page Signuppage;

	public Create_New_Account_Test() {
		super();
	}

	// Init()
	@BeforeMethod
	public void SetUp() throws InterruptedException {
		zytobase = new ZytoBase();
		prop = zytobase.init_prop();
		driver = zytobase.init_driver(prop);
		// ZytoBase.EventFire();
		All_Pages allpages = new All_Pages(driver);
		allpages.EventFire();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		Thread.sleep(10000);
		long waitTime = 10;
		WebDriverWait wait = new WebDriverWait(driver, waitTime);
		System.out.println(
				concol.BLUE_BOLD_BRIGHT + "****USE CASE : Registration -----> Test Started****" + concol.RESET);
		Introduction_Page intropage = new Introduction_Page(driver);
		jl = new JavascriptUtil(driver);
		Introduction_Page_Test intropagetest = new Introduction_Page_Test();
		Signuppage = new Signup_Options_page(driver);

	}

	@Test
	public void Click_On_Create_button() throws InterruptedException {

		System.out.println(concol.BLUE_BOLD_BRIGHT + "****Clicking on Create New Account button****" + concol.RESET);
		Signuppage.Click_Signup_btn();
		Thread.sleep(5000);
		driver.navigate().back();
		

		System.out.println(concol.BLUE_BOLD_BRIGHT + "****Clicking on Sign in  button****" + concol.RESET);
		Thread.sleep(5000);
		Signuppage.Click_Sign_In_btn();
		Thread.sleep(5000);
		driver.navigate().back();

		System.out.println(concol.BLUE_BOLD_BRIGHT + "****Clicking on World icon ****" + concol.RESET);
		Thread.sleep(5000);
		Signuppage.Click_World_icon();

		// Check English Language
		Thread.sleep(5000);
		Signuppage.Select_Language();

		// Change Language
		Thread.sleep(3000);
		Signuppage.Change_Language();

		Thread.sleep(5000);
		Signuppage.Click_World_icon();

		// Click onCross icon
		 Thread.sleep(3000);
		Signuppage.Click_Cross_icon();

	}

	@AfterMethod
	public void EndTest() {
		System.out.println(concol.BLUE_BOLD_BRIGHT + "****Quitting the browser****" + concol.RESET);
		driver.quit();
	}

}
