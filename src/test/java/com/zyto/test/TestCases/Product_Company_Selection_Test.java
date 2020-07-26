package com.zyto.test.TestCases;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.zyto.test.ConsoleColors.Console_Colors;
import com.zyto.test.UtilTestCases.RegistrationProcess;
import com.zyto.test.base.ZytoBase;
import com.zyto.test.pages.Introduction_Page;
import com.zyto.test.pages.Payment_Method_Page;
import com.zyto.test.pages.Product_Company_Selection_Page;
import com.zyto.test.pages.Signup_Options_page;
import com.zyto.test.pages.User_Agreement_Page;
import com.zyto.test.util.java.ConstantKeywords;
import com.zyto.test.util.java.ElementLocatorUtils;
import com.zyto.test.util.java.JavascriptUtil;

public class Product_Company_Selection_Test extends ZytoBase {

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
	Payment_Method_Page pmp;

	public Product_Company_Selection_Test() {
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
		pmp = new Payment_Method_Page(driver);

	}

	@Test(description = "To verify the “Select Product Company” drop down functionality")
	public void TC_043_To_Select_Product_Company() throws InterruptedException {
		rp.Reg_till_Pscp();
		Thread.sleep(5000);

		pcsp.Product_Company().selectByIndex(4);
		Thread.sleep(3000);

		if (pcsp.Product_Company().getFirstSelectedOption().equals(null)) {
			Assert.fail(concol.RED_BOLD_BRIGHT + "Unable to Select the option from product Company dropdown");
		} else {
			System.out.println(
					concol.CYAN_BOLD_BRIGHT + pcsp.Product_Company().getFirstSelectedOption().getText() + concol.RESET);
		}

	}

	@Test(description = "To verify that Continue button functionality --disablity")
	public void TC_044_Verify_Continue_button_disability() throws InterruptedException {
		rp.Reg_till_Pscp();
		Thread.sleep(5000);

		if (pcsp.Product_Company().getFirstSelectedOption().getText().equals("Select Product Company")) {
			if (pcsp.Continue_button().isEnabled()) {
				Assert.fail(
						concol.RED_BOLD_BRIGHT + "Continue button is enabled without option selection" + concol.RESET);
			} else {
				System.out.println(concol.CYAN_BOLD_BRIGHT + "Continue button is disabled" + concol.RESET);
			}
		} else {
			System.out.println(
					concol.RED_BOLD_BRIGHT + pcsp.Product_Company().getFirstSelectedOption().getText() + concol.RESET);
			Assert.fail(concol.RED_BOLD_BRIGHT + "Option is selected without any selection" + concol.RESET);
		}

	}
	
	@Test(description="To verify that Continue button functionality ")
	public void TC_045_Verify_Continue_button() throws InterruptedException {
		rp.Reg_till_Pscp();
		Thread.sleep(5000);
		
		pcsp.Product_Company().selectByIndex(4);
		Thread.sleep(5000);
		
		pcsp.Continue_button().click();
		Thread.sleep(5000);
		
		if(pmp.Billing_Address_PMP().isDisplayed()) {
			System.out.println(concol.CYAN_BOLD_BRIGHT + "Naviagted to Payment Method Page" + concol.RESET);
		}else {
			Assert.fail(concol.RED_BOLD_BRIGHT+"Unable to navigate to  Payment Method Page ");
		}
	}

	@AfterMethod
	public void EndTest() {
		System.out.println(concol.BLUE_BOLD_BRIGHT + "****Quitting the browser****" + concol.RESET);
		driver.quit();
	}

}
