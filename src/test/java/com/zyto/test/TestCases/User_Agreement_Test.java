package com.zyto.test.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.zyto.test.ConsoleColors.Console_Colors;
import com.zyto.test.UtilTestCases.RegistrationProcess;
import com.zyto.test.base.ZytoBase;
import com.zyto.test.pages.Introduction_Page;
import com.zyto.test.pages.Product_Company_Selection_Page;
import com.zyto.test.pages.Signup_Options_page;
import com.zyto.test.pages.User_Agreement_Page;
import com.zyto.test.util.java.ConstantKeywords;
import com.zyto.test.util.java.ElementLocatorUtils;
import com.zyto.test.util.java.JavascriptUtil;

public class User_Agreement_Test extends ZytoBase {
	// Pages to Used //
	ZytoBase zytobase;
	Console_Colors concol;
	Introduction_Page intropage;
	ConstantKeywords ConstKeys;
	static ElementLocatorUtils el;
	JavascriptUtil jl;
	User_Agreement_Page uap;
	RegistrationProcess rp;
	Signup_Options_page signuppage;
	Product_Company_Selection_Page pcsp;

	public User_Agreement_Test() {
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
		intropage = new Introduction_Page(driver);
		jl = new JavascriptUtil(driver);
		uap = new User_Agreement_Page(driver);
		rp = new RegistrationProcess(driver);
		signuppage = new Signup_Options_page(driver);
		pcsp = new Product_Company_Selection_Page(driver);

	}

	@Test(description = "To Check first and last are pre-filled ")
	public void TC_037_Verify_first_last_name_fields_are_Prefilled() throws InterruptedException {
		Thread.sleep(10000);

		rp.Registration();
		Thread.sleep(15000);

		driver.switchTo().frame(0);

		if (uap.FirstName_UAGP().getAttribute("value").equals(null)
				&& uap.LastName_UAGP().getAttribute("value").equals(null)) {
			Assert.fail(concol.RED_BOLD_BRIGHT + "First and Name fields are not pre-filled" + concol.RESET);
		} else {
			System.out.println(concol.CYAN_BOLD_BRIGHT + "First Name = " + uap.FirstName_UAGP().getAttribute("value")
					+ "\n" + "Last Name = " + uap.LastName_UAGP().getAttribute("value") + concol.RESET);
		}

	}

	@Test(description = "To Check Email field is pre-filled ")
	public void TC_038_Verify_Email_field_is_Prefilled() throws InterruptedException {
		Thread.sleep(10000);

		rp.Registration();
		Thread.sleep(15000);

		driver.switchTo().frame(0);

		if (uap.Email_UAGP().getAttribute("value").equals(null)) {
			Assert.fail(concol.RED_BOLD_BRIGHT + "Email field is not pre-filled" + concol.RESET);
		} else {
			System.out.println(
					concol.CYAN_BOLD_BRIGHT + "Email = " + uap.Email_UAGP().getAttribute("value") + concol.RESET);
		}

	}

	@Test(description = "To verify clicking on Continue button")
	public void TC_039_Verify_Continue_button() throws InterruptedException {
		Thread.sleep(10000);

		rp.Registration();
		Thread.sleep(15000);

		driver.switchTo().frame(0);

		uap.Continue_button_UAGP().click();
		Thread.sleep(5000);

		if (uap.Next_button_UAGP().isDisplayed()) {
			System.out.println(concol.CYAN_BOLD_BRIGHT + "Naviagated to User content" + concol.RESET);
		} else {
			Assert.fail(concol.RED_BOLD_BRIGHT + "Continue button is not working as expected" + concol.RESET);

		}

	}

	@Test(description = "To verify the Signature accept function on panda doc page.")
	public void TC_040_Verify_Singature_Accept_function() throws InterruptedException {
		Thread.sleep(10000);

		rp.Registration();
		Thread.sleep(15000);

		driver.switchTo().frame(0);

		uap.Continue_button_UAGP().click();
		Thread.sleep(5000);

		uap.Next_button_UAGP().click();
		Thread.sleep(5000);

		if (uap.Draw_Tab_UAGP().isDisplayed()) {
			System.out.println(concol.CYAN_BOLD_BRIGHT + "Naviagated to signature overlay" + concol.RESET);
		} else {
			Assert.fail(concol.RED_BOLD_BRIGHT + "Signature popup is not displayed" + concol.RESET);
		}

		Thread.sleep(3000);

		uap.Accept_n_Sign_UAGP().click();
		Thread.sleep(5000);

		if (uap.Signature_View_UAGP().isDisplayed()) {
			System.out.println(concol.CYAN_BOLD_BRIGHT + "Singature selected is displayed" + concol.RESET);
		} else {
			Assert.fail(concol.RED_BOLD_BRIGHT + "Signature is not saved in document" + concol.RESET);
		}

	}
	
	@Test(description = "To verify the “Finalize Document “ button functionality")
	public void TC_041_Verify_Finalize_Document_function() throws InterruptedException {
		Thread.sleep(10000);

		rp.Registration();
		Thread.sleep(15000);

		driver.switchTo().frame(0);

		uap.Continue_button_UAGP().click();
		Thread.sleep(5000);

		uap.Next_button_UAGP().click();
		Thread.sleep(5000);

		if (uap.Draw_Tab_UAGP().isDisplayed()) {
			System.out.println(concol.CYAN_BOLD_BRIGHT + "Naviagated to signature overlay" + concol.RESET);
		} else {
			Assert.fail(concol.RED_BOLD_BRIGHT + "Signature popup is not displayed" + concol.RESET);
		}

		Thread.sleep(3000);

		uap.Accept_n_Sign_UAGP().click();
		Thread.sleep(5000);

		uap.Finalize_Doc_UAGP().click();
		Thread.sleep(5000);

		if (uap.Continue_button_UAGP().isDisplayed()) {
			System.out.println(concol.CYAN_BOLD_BRIGHT + "Thank you message is displayed" + concol.RESET);
		} else {
			Assert.fail(concol.RED_BOLD_BRIGHT + "Unable to Finalize document" + concol.RESET);
		}

	}
	
	@Test(description = "To verify the “Continue” button functionality on User Agreement page")
	public void TC_042_Verify_Continue_To_next_Page() throws InterruptedException {
		Thread.sleep(10000);

		rp.Registration();
		Thread.sleep(15000);

		driver.switchTo().frame(0);

		uap.Continue_button_UAGP().click();
		Thread.sleep(5000);

		uap.Next_button_UAGP().click();
		Thread.sleep(5000);

		if (uap.Draw_Tab_UAGP().isDisplayed()) {
			System.out.println(concol.CYAN_BOLD_BRIGHT + "Naviagated to signature overlay" + concol.RESET);
		} else {
			Assert.fail(concol.RED_BOLD_BRIGHT + "Signature popup is not displayed" + concol.RESET);
		}

		Thread.sleep(3000);

		uap.Accept_n_Sign_UAGP().click();
		Thread.sleep(5000);

		uap.Finalize_Doc_UAGP().click();
		Thread.sleep(5000);

		uap.Continue_button_UAGP().click();
		Thread.sleep(5000);
		if (pcsp.Product_Comapny_DD().isDisplayed()) {
			System.out.println(concol.CYAN_BOLD_BRIGHT + "Naviagated to Product Company Selection page" + concol.RESET);
		} else {
			Assert.fail(concol.RED_BOLD_BRIGHT + "Unable to Naviagate to Product Company Selection page" + concol.RESET);
		}

	}

	@AfterMethod
	public void EndTest() {
		System.out.println(concol.BLUE_BOLD_BRIGHT + "****Quitting the browser****" + concol.RESET);
		driver.quit();
	}

}
