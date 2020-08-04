package com.zyto.test.TestCases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.zyto.test.ConsoleColors.Console_Colors;
import com.zyto.test.ReportListeners.ExtentReportListener;
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

public class Payment_Method_Test extends ZytoBase{
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
	ExtentReportListener ext;

	public Payment_Method_Test() {
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
		ext = new ExtentReportListener();
		concol = new Console_Colors();

	}

	@SuppressWarnings("static-access")
	@Test(description = "To verify the “billing page “ address field functionality")
	public void TC_046_Verify_billing_address() throws InterruptedException {
		rp.Reg_till_pmp();
		Thread.sleep(5000);

		if (!pmp.Billing_Address_PMP().getAttribute("value").equals(null)
				&& !pmp.City_PMP().getAttribute("value").equals(null)
				&& !pmp.Country_PMP().getFirstSelectedOption().equals("Select Country")
				&& !pmp.State_PMP().getFirstSelectedOption().equals("Select State/Province")
				&& !pmp.Postal_Code_PMP().getAttribute("value").equals(null)) {

			System.out.println(concol.CYAN_BOLD_BRIGHT + "All Billing address fields are pre-filled" + concol.RESET);
		} else {
			System.out.println(pmp.Billing_Address_PMP().getAttribute("value") + "--"
					+ pmp.City_PMP().getAttribute("value") + "--" + pmp.Country_PMP().getFirstSelectedOption().getText()
					+ "--" + pmp.State_PMP().getFirstSelectedOption().getText() + "--"
					+ pmp.Postal_Code_PMP().getAttribute("value"));
			Assert.fail(concol.RED_BOLD_BRIGHT + "Billing address is not pre-filled" + concol.RESET);
		}

	}

	@SuppressWarnings("static-access")
	@Test(description = "To verify the Billing information fields")
	public void TC_047_Verify_mandate_fields() throws InterruptedException {
		rp.Reg_till_pmp();
		Thread.sleep(5000);

		pmp.Billing_Address_PMP().clear();
		Thread.sleep(2000);
		pmp.City_PMP().clear();
		Thread.sleep(2000);
		pmp.Country_PMP().selectByIndex(0);
		Thread.sleep(2000);
		pmp.State_PMP().selectByIndex(0);
		Thread.sleep(2000);
		pmp.Postal_Code_PMP().clear();
		Thread.sleep(2000);

		pmp.Continue_button().click();

		List<WebElement> error = driver.findElements(By.xpath("//div[@class='text-danger ng-star-inserted']"));

		if (error.size() != 0) {
			for (WebElement er : error) {
				System.out.println(Console_Colors.RED_BOLD_BRIGHT + er.getText() + concol.RESET);
			}
		} else {
			Assert.fail(Console_Colors.RED_BOLD_BRIGHT + "Error message is  not  displayed for invalid details"
					+ concol.RESET);
		}
	}

	@SuppressWarnings("static-access")
	@Test(description = "To verify the Billing information fields with invalid details")
	public void TC_048_Verify_fields_with_invalid_details() throws InterruptedException {
		rp.Reg_till_pmp();
		Thread.sleep(5000);

		pmp.Billing_Address_PMP().clear();
		Thread.sleep(2000);
		pmp.City_PMP().clear();
		Thread.sleep(2000);
		pmp.Country_PMP().selectByIndex(0);
		Thread.sleep(2000);
		pmp.State_PMP().selectByIndex(0);
		Thread.sleep(2000);
		pmp.Postal_Code_PMP().clear();
		Thread.sleep(2000);

		pmp.Billing_Address_PMP().sendKeys("          ");
		Thread.sleep(2000);
		pmp.City_PMP().sendKeys("          ");
		Thread.sleep(2000);
		pmp.Postal_Code_PMP().sendKeys("          ");
		Thread.sleep(2000);
		pmp.Postal_Code_PMP().sendKeys(Keys.TAB);
		Thread.sleep(10000);

		pmp.Continue_button().click();

		List<WebElement> error = driver.findElements(By.xpath("//div[@class='text-danger ng-star-inserted']"));
		
		if (error.size() != 0) {
			for (WebElement er : error) {
				System.out.println(Console_Colors.RED_BOLD_BRIGHT + er.getText() + concol.RESET);
			}
		} else {
			Assert.fail(Console_Colors.RED_BOLD_BRIGHT + "Error message is  not  displayed for invalid details"
					+ concol.RESET);
		}
	}
	
	@SuppressWarnings("static-access")
	@Test(description="To To Verify without filling the data in Billing information fields")
    public void TC_049_Verify_Billing_Address_field() throws InterruptedException {
		rp.Reg_till_pmp();
		Thread.sleep(5000);
		
		pmp.Billing_Address_PMP().clear();
		pmp.Postal_Code_PMP().click();
		Thread.sleep(2000);
		pmp.City_PMP().clear();
		pmp.Postal_Code_PMP().click();
		Thread.sleep(2000);
	
		List<WebElement> error = driver.findElements(By.xpath("//div[@class='text-danger ng-star-inserted']"));
		
		if (error.size() != 0) {
			for (WebElement er : error) {
				System.out.println(Console_Colors.RED_BOLD_BRIGHT + er.getText() + concol.RESET);
			}
		} else {
			Assert.fail(Console_Colors.RED_BOLD_BRIGHT + "Error message is  not  displayed for invalid details"
					+ concol.RESET);
		}
	}
	
	@SuppressWarnings("static-access")
	@Test(description="To Verify without filling the data in State/province fields")
    public void TC_050_Verify_State_Province_field(ITestResult result) throws InterruptedException {
		rp.Reg_till_pmp();
		Thread.sleep(5000);
		
		pmp.State_PMP().selectByIndex(0);
		pmp.Postal_Code_PMP().click();
		Thread.sleep(2000);
		pmp.Country_PMP().selectByIndex(0);
		Thread.sleep(2000);
		pmp.Postal_Code_PMP().click();
	
		
		List<WebElement> error = driver.findElements(By.xpath("//div[@class='text-danger ng-star-inserted']"));
		
		if (error.size() != 0) {
			for (WebElement er : error) {
				System.out.println(Console_Colors.RED_BOLD_BRIGHT + er.getText() + concol.RESET);
			}
		} else {
			
			Assert.fail(Console_Colors.RED_BOLD_BRIGHT + "Error message is  not  displayed for invalid details"
					+ concol.RESET);
		}
	}
		
	
	@AfterMethod
	public void EndTest() {
		System.out.println(concol.BLUE_BOLD_BRIGHT + "****Quitting the browser****" + concol.RESET);
		driver.quit();
	}

	
}
