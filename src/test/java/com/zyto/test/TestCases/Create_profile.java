package com.zyto.test.TestCases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.zyto.test.ConsoleColors.Console_Colors;
import com.zyto.test.UtilTestCases.RegistrationProcess;
import com.zyto.test.Util_Pages.All_Pages;
import com.zyto.test.base.ZytoBase;
import com.zyto.test.pages.Create_New_Account_Page;
import com.zyto.test.pages.Introduction_Page;
import com.zyto.test.pages.Login_Page;
import com.zyto.test.pages.Signup_Options_page;
import com.zyto.test.util.java.ConstantKeywords;
import com.zyto.test.util.java.ElementLocatorUtils;
import com.zyto.test.util.java.JavascriptUtil;

public class Create_profile extends ZytoBase {
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
	All_Pages allpages;

	RegistrationProcess rp;

	public Create_profile() {
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
		System.out.println(concol.BLUE_BOLD_BRIGHT
				+ "****USE CASE : Registration With Passwords -----> Test Started****" + concol.RESET);
		intropage = new Introduction_Page(driver);
		jl = new JavascriptUtil(driver);
		intropagetest = new Introduction_Page_Test();
		loginpage = new Login_Page(driver);
		createnewaccountpage = new Create_New_Account_Page(driver);
		Signuppage = new Signup_Options_page(driver);
		allpages = new All_Pages(driver);
		rp = new RegistrationProcess(driver);

	}

	@Test(description = "To verify the First and Last Name fields ")
	public void TC_010_Verify_First_Last_Name_fields() throws InterruptedException {
		
		

		Thread.sleep(10000);
		Signuppage.Click_Signup_btn();
		Thread.sleep(10000);

		String regex = "/^[a-zA-Z0-9- ]*$/";

		createnewaccountpage.FirstName().sendKeys(allpages.randomSpecial(12));
		createnewaccountpage.LastName().sendKeys((allpages.randomSpecial(12)));

		String fieldText1 = createnewaccountpage.FirstName().getAttribute("value");
		String fieldText2 = createnewaccountpage.LastName().getAttribute("value");

		if ((fieldText1.matches("[" + regex + "]+")) && (fieldText2.matches("[" + regex + "]+"))) {
			System.out.println("Valid Input: " + fieldText1);
			System.out.println("Valid Input: " + fieldText2);
		} else {
			System.out.println("Valid Input: " + fieldText1);
			System.out.println("Valid Input: " + fieldText2);
		}
	}

	@Test(description = "To verify the email address field validation")
	public void TC_011_Email_Address_Validation() throws InterruptedException {
		Thread.sleep(10000);
		Signuppage.Click_Signup_btn();
		Thread.sleep(10000);

		createnewaccountpage.Email().sendKeys("UserTest" + System.currentTimeMillis() + "@gmail.com");
		Thread.sleep(2000);

		List<WebElement> error = driver.findElements(By.xpath("//div[@class='text-danger ng-star-inserted']"));

		if (error.size() != 0) {
			Assert.fail(concol.RED_BOLD_BRIGHT + "Error message is displayed for valid email" + concol.RESET);
		}
	}

	@Test(description = "To verify the email address field validation with existing email address")
	public void TC_012_Existing_Email_Address_Validation() throws InterruptedException {
		Thread.sleep(10000);
		Signuppage.Click_Signup_btn();
		Thread.sleep(10000);

		createnewaccountpage.Email().sendKeys(prop.getProperty("username"));
		Thread.sleep(5000);
		createnewaccountpage.Email().sendKeys(Keys.TAB);

		WebElement error = driver.findElement(By.xpath("//div[@class='text-danger ng-star-inserted']"));
		if (error.isDisplayed()) {
			System.out.println(concol.CYAN_BOLD_BRIGHT + error.getText() + concol.RESET);
		} else {
			Assert.fail(concol.RED_BOLD_BRIGHT + "Error message is not displayed for valid email" + concol.RESET);
		}

	}

	@Test(description = "To Verify the filed validation with invalid emails")
	public void TC_013_Invalid_Emails_Validation() throws InterruptedException {
		Thread.sleep(10000);
		Signuppage.Click_Signup_btn();
		Thread.sleep(10000);
		String[] input = { "testAtgamil.com", "test@gmailcom", "test@gmail", "@gmail" };
		for (int i = 0; i < input.length; i++) {
			createnewaccountpage.Email().sendKeys(input[i]);

			Thread.sleep(5000);
			createnewaccountpage.Email().sendKeys(Keys.TAB);

			WebElement error = driver.findElement(By.xpath("//div[@class='text-danger ng-star-inserted']"));

			if (error.isDisplayed()) {
				System.out.println(concol.CYAN_BOLD_BRIGHT + error.getText() + concol.RESET);
			} else {
				Assert.fail(concol.RED_BOLD_BRIGHT + "Error message is not displayed for invalid email" + concol.RESET);
			}

			createnewaccountpage.Email().clear();
			Thread.sleep(3000);

			driver.navigate().refresh();
			Thread.sleep(5000);
		}
	}

	@Test(description = "To verify the password field")
	public void TC_014_Verify_Password_field() throws InterruptedException {
		Thread.sleep(10000);
		Signuppage.Click_Signup_btn();
		Thread.sleep(10000);

		createnewaccountpage.CreatePassword().sendKeys("Rajesh_123");
		Thread.sleep(5000);
		createnewaccountpage.CreatePassword().sendKeys(Keys.TAB);

		List<WebElement> error = driver.findElements(By.xpath("//div[@class='text-danger ng-star-inserted']"));

		if (error.size() != 0) {
			Assert.fail(concol.RED_BOLD_BRIGHT + "Error message is  displayed for valid password" + concol.RESET);
		}
	}

	@Test(description = "To Verify create password field char limit ")
	public void TC_015_Verify_Password_field() throws InterruptedException {
		Thread.sleep(10000);
		Signuppage.Click_Signup_btn();
		Thread.sleep(10000);

		createnewaccountpage.CreatePassword().sendKeys("Raj_123");
		Thread.sleep(5000);
		createnewaccountpage.CreatePassword().sendKeys(Keys.TAB);

		WebElement error = driver.findElement(By.xpath("//div[@class='text-danger ng-star-inserted']"));

		if (error.isDisplayed()) {
			System.out.println(concol.CYAN_BOLD_BRIGHT + error.getText() + concol.RESET);
		} else {
			Assert.fail(concol.RED_BOLD_BRIGHT + "Error message is  displayed for valid password" + concol.RESET);
		}
	}

	@Test(description = "To verify  if Password  and Confirm Password matches")
	public void TC_016_Verify_Password_fields_match() throws InterruptedException {
		Thread.sleep(10000);
		Signuppage.Click_Signup_btn();
		Thread.sleep(10000);

		createnewaccountpage.CreatePassword().sendKeys("Rajesh_123");
		Thread.sleep(5000);
		createnewaccountpage.CreatePassword().sendKeys(Keys.TAB);

		createnewaccountpage.ConfirmPassword().sendKeys("Rajesh_123");
		Thread.sleep(5000);
		createnewaccountpage.ConfirmPassword().sendKeys(Keys.TAB);

		List<WebElement> error = driver.findElements(By.xpath("//div[@class='text-danger ng-star-inserted']"));

		if (error.size() != 0) {
			Assert.fail(concol.RED_BOLD_BRIGHT + "Error message is  displayed for valid password" + concol.RESET);
		}

	}

	@Test(description = "To verify the error message for mismatch of passwords")
	public void TC_017_Verify_Miscmatch_of_Passwords() throws InterruptedException {
		Thread.sleep(10000);
		Signuppage.Click_Signup_btn();
		Thread.sleep(10000);

		createnewaccountpage.CreatePassword().sendKeys("Rajesh_123");
		Thread.sleep(5000);
		createnewaccountpage.CreatePassword().sendKeys(Keys.TAB);

		createnewaccountpage.ConfirmPassword().sendKeys("Rajesh_576");
		Thread.sleep(5000);
		createnewaccountpage.ConfirmPassword().sendKeys(Keys.TAB);

		WebElement error = driver.findElement(By.xpath("//div[@class='text-danger ng-star-inserted']"));

		if (error.isDisplayed()) {
			System.out.println(concol.CYAN_BOLD_BRIGHT + error.getText() + concol.RESET);
		} else {
			Assert.fail(concol.RED_BOLD_BRIGHT + "Error message is  not displayed for invalid password" + concol.RESET);
		}
	}

	@Test(description = "Verify with Valid Phone number")
	public void TC_018_Verify__Phone_Number_field() throws InterruptedException {
		Thread.sleep(10000);

		Signuppage.Click_Signup_btn();
		Thread.sleep(10000);

		createnewaccountpage.Country_Code_dropdown().click();
		Thread.sleep(5000);
		createnewaccountpage.Country_Name_dropdown().sendKeys("India");
		Thread.sleep(5000);

		for (WebElement e : createnewaccountpage.Country_Name_In_Dropdown()) {
			if (e.getText().startsWith("India")) {
				System.out.println(e.getText());
				e.click();
			}
		}

		Thread.sleep(5000);
		createnewaccountpage.PhoneNumber().sendKeys("7416516727");
		Thread.sleep(5000);
		createnewaccountpage.PhoneNumber().sendKeys(Keys.TAB);

		List<WebElement> error = driver.findElements(By.xpath("//div[@class='text-danger ng-star-inserted']"));

		if (error.size() != 0) {
			for (WebElement er : error) {
				System.out.println(concol.RED_BOLD_BRIGHT + er.getText() + concol.RESET);
			}
			Assert.fail(concol.RED_BOLD_BRIGHT + "Error message is   displayed for valid phone number" + concol.RESET);
		}

	}

	@Test(description = "Verify with InValid Phone number")
	public void TC_019_Verify__Error_In_Phone_Number_field() throws InterruptedException {
		Thread.sleep(10000);

		Signuppage.Click_Signup_btn();
		Thread.sleep(10000);

		createnewaccountpage.Country_Code_dropdown().click();
		Thread.sleep(5000);
		createnewaccountpage.Country_Name_dropdown().sendKeys("United");
		Thread.sleep(5000);

		for (WebElement e : createnewaccountpage.Country_Name_In_Dropdown()) {
			if (e.getText().startsWith("United Kingdom")) {
				System.out.println(e.getText());
				e.click();
			}
		}

		Thread.sleep(5000);
		createnewaccountpage.PhoneNumber().sendKeys("1111111115");
		Thread.sleep(5000);
		createnewaccountpage.PhoneNumber().sendKeys(Keys.TAB);

		List<WebElement> error = driver.findElements(By.xpath("//div[@class='text-danger ng-star-inserted']"));

		if (error.size() != 0) {
			for (WebElement er : error) {
				System.out.println(concol.RED_BOLD_BRIGHT + er.getText() + concol.RESET);
			}
		}else {
			Assert.fail(
					concol.RED_BOLD_BRIGHT + "Error message is  not  displayed for invalid phone number" + concol.RESET);
		}

	}

	@Test(description = "Verify with InValid Phone number")
	public void TC_020_Verify__Error_In_Phone_Number_field() throws InterruptedException {
		Thread.sleep(10000);

		Signuppage.Click_Signup_btn();
		Thread.sleep(10000);

		createnewaccountpage.Country_Code_dropdown().click();
		Thread.sleep(5000);
		createnewaccountpage.Country_Name_dropdown().sendKeys("United");
		Thread.sleep(5000);

		for (WebElement e : createnewaccountpage.Country_Name_In_Dropdown()) {
			if (e.getText().startsWith("United States")) {
				System.out.println(e.getText());
				e.click();
			}
		}

		Thread.sleep(5000);
		createnewaccountpage.PhoneNumber().sendKeys("123456");
		Thread.sleep(5000);
		createnewaccountpage.PhoneNumber().sendKeys(Keys.TAB);

		List<WebElement> error = driver.findElements(By.xpath("//div[@class='text-danger ng-star-inserted']"));

		if (error.size() != 0) {
			for (WebElement er : error) {
				System.out.println(concol.RED_BOLD_BRIGHT + er.getText() + concol.RESET);
			}
		}else {
			Assert.fail(
					concol.RED_BOLD_BRIGHT + "Error message is not displayed for invalid phone number" + concol.RESET);
		}

	}

	@Test(description = " Enter the DOB fields as mandatory")
	public void TC_021_Validate_Mandatory_DOB_Fields() throws InterruptedException {
		Thread.sleep(10000);

		Signuppage.Click_Signup_btn();
		Thread.sleep(10000);

		rp.Enter_Details_in_Reg_Form();
		Thread.sleep(5000);

		createnewaccountpage.Month_DOB_Select().selectByIndex(0);
		createnewaccountpage.Date_DOB_Select().selectByIndex(0);
		createnewaccountpage.Year_DOB_Select().selectByIndex(0);
		Thread.sleep(5000);

		createnewaccountpage.Continue().click();

		List<WebElement> error = driver.findElements(By.xpath("//div[@class='text-danger ng-star-inserted']"));

		if (error.size() != 0) {
			for (WebElement er : error) {
				System.out.println(concol.RED_BOLD_BRIGHT + er.getText() + concol.RESET);
			}
		} else {
			Assert.fail(concol.RED_BOLD_BRIGHT + "Error message is not  displayed for invalid DOB" + concol.RESET);

		}
	}

	@Test(description = " Enter the DOB fields as mandatory")
	public void TC_022_Validate_Mandatory_DOB_Fields_With_Valid_Date() throws InterruptedException {
		Thread.sleep(10000);

		Signuppage.Click_Signup_btn();
		Thread.sleep(10000);

		createnewaccountpage.Month_DOB_Select().selectByIndex(4);
		createnewaccountpage.Date_DOB_Select().selectByIndex(5);
		createnewaccountpage.Year_DOB_Select().selectByVisibleText("1994");
		;
		Thread.sleep(5000);

		List<WebElement> error = driver.findElements(By.xpath("//div[@class='text-danger ng-star-inserted']"));

		if (error.size() != 0) {
			for (WebElement er : error) {
				System.out.println(concol.RED_BOLD_BRIGHT + er.getText() + concol.RESET);
			}
			Assert.fail(concol.RED_BOLD_BRIGHT + "Error message is  displayed for valid DOB" + concol.RESET);
		}

	}

	@Test(description = " Enter the DOB fields as mandatory")
	public void TC_023_Validate_Age_in_Registration() throws InterruptedException {
		Thread.sleep(10000);

		Signuppage.Click_Signup_btn();
		Thread.sleep(10000);

		rp.Enter_Details_in_Reg_Form();
		Thread.sleep(5000);

		createnewaccountpage.Month_DOB_Select().selectByIndex(4);
		createnewaccountpage.Date_DOB_Select().selectByIndex(5);
		createnewaccountpage.Year_DOB_Select().selectByVisibleText("2003");
		;
		Thread.sleep(5000);

		createnewaccountpage.Continue().click();

		List<WebElement> error = driver.findElements(By.xpath("//div[@class='text-danger ng-star-inserted']"));

		if (error.size() != 0) {
			for (WebElement er : error) {
				System.out.println(concol.RED_BOLD_BRIGHT + er.getText() + concol.RESET);
			}
		} else {
			Assert.fail(concol.RED_BOLD_BRIGHT + "Error message is not  displayed for invalid DOB" + concol.RESET);

		}

	}

	@Test(description = "Validate the Gender drodpown as mandate")
	public void TC_024_Validate_Gender_As_Mandatory_Fields() throws InterruptedException {
		Thread.sleep(10000);

		Signuppage.Click_Signup_btn();
		Thread.sleep(10000);

		rp.Enter_Details_in_Reg_Form();
		Thread.sleep(5000);

		createnewaccountpage.Gender_DD().selectByIndex(0);
		Thread.sleep(3000);

		createnewaccountpage.Continue().click();

		List<WebElement> error = driver.findElements(By.xpath("//div[@class='text-danger ng-star-inserted']"));

		if (error.size() != 0) {
			for (WebElement er : error) {
				System.out.println(concol.RED_BOLD_BRIGHT + er.getText() + concol.RESET);
			}
		} else {
			Assert.fail(concol.RED_BOLD_BRIGHT + "Error message is not  displayed for Not entering Gender details"
					+ concol.RESET);

		}

	}

	@Test(description = "Validate the Gender drodpown as mandate")
	public void TC_025_Validate_Gender_Field() throws InterruptedException {
		Thread.sleep(10000);

		Signuppage.Click_Signup_btn();
		Thread.sleep(10000);

		createnewaccountpage.Gender_DD().selectByIndex(1);
		Thread.sleep(3000);

		createnewaccountpage.Address1().click();

		List<WebElement> error = driver.findElements(By.xpath("//div[@class='text-danger ng-star-inserted']"));

		if (error.size() != 0) {
			for (WebElement er : error) {
				System.out.println(concol.RED_BOLD_BRIGHT + er.getText() + concol.RESET);
			}

			Assert.fail(
					concol.RED_BOLD_BRIGHT + "Error message is  displayed for valid  Gender details" + concol.RESET);

		}

	}

	@Test(description = "To validate the Address fields as mandate")
	public void TC_026_Validate_Address_Fields() throws InterruptedException {
		Thread.sleep(10000);

		Signuppage.Click_Signup_btn();
		Thread.sleep(10000);

		createnewaccountpage.FirstName().click();
		createnewaccountpage.FirstName().sendKeys("First" + System.currentTimeMillis());
		createnewaccountpage.LastName().sendKeys("Last" + System.currentTimeMillis());
		createnewaccountpage.Email().sendKeys("UserTest" + System.currentTimeMillis() + "@test.com");
		createnewaccountpage.CreatePassword().sendKeys("Test@1234");
		createnewaccountpage.ConfirmPassword().sendKeys("Test@1234");
		createnewaccountpage.PhoneNumber().sendKeys("2015551403");

		Select DD_Month = new Select(createnewaccountpage.Month_DOB());
		DD_Month.selectByIndex(3);

		Select DD_Day = new Select(createnewaccountpage.Date_DOB());
		DD_Day.selectByIndex(10);

		Select DD_Year = new Select(createnewaccountpage.Year_DOB());
		DD_Year.selectByVisibleText("1994");

		Thread.sleep(2000);

		zytobase.scrollTo(createnewaccountpage.Gender());

		Thread.sleep(3000);

		Select DD_Gender = new Select(createnewaccountpage.Gender());
		DD_Gender.selectByVisibleText("Male");

		createnewaccountpage.Address2().sendKeys("Address2");

		Select DD_State = new Select(createnewaccountpage.State());
		DD_State.selectByIndex(4);

		createnewaccountpage.PostCode().sendKeys("789456123");

		Thread.sleep(3000);

		createnewaccountpage.Continue().click();
		Thread.sleep(3000);

		List<WebElement> error = driver.findElements(By.xpath("//div[@class='text-danger ng-star-inserted']"));

		if (error.size() != 0) {
			for (WebElement er : error) {
				System.out.println(Console_Colors.RED_BOLD_BRIGHT + er.getText() + concol.RESET);
			}
		} else {
			Assert.fail(Console_Colors.RED_BOLD_BRIGHT
					+ "Error message is  not  displayed for not entering address details" + concol.RESET);
		}

	}

	@Test(description = "To Validate Address fields giving invalid data")
	public void TC_027_Verify_Address_Fields_With_invalid_Data() throws InterruptedException {
		Thread.sleep(10000);

		Signup_Options_page.Click_Signup_btn();
		Thread.sleep(10000);

		createnewaccountpage.FirstName().click();
		createnewaccountpage.FirstName().sendKeys("First" + System.currentTimeMillis());
		createnewaccountpage.LastName().sendKeys("Last" + System.currentTimeMillis());
		createnewaccountpage.Email().sendKeys("UserTest" + System.currentTimeMillis() + "@test.com");
		createnewaccountpage.CreatePassword().sendKeys("Test@1234");
		createnewaccountpage.ConfirmPassword().sendKeys("Test@1234");
		createnewaccountpage.PhoneNumber().sendKeys("2015551403");

		Select DD_Month = new Select(createnewaccountpage.Month_DOB());
		DD_Month.selectByIndex(3);

		Select DD_Day = new Select(createnewaccountpage.Date_DOB());
		DD_Day.selectByIndex(10);

		Select DD_Year = new Select(createnewaccountpage.Year_DOB());
		DD_Year.selectByVisibleText("1994");

		Thread.sleep(2000);

		zytobase.scrollTo(createnewaccountpage.Gender());

		Thread.sleep(3000);

		Select DD_Gender = new Select(createnewaccountpage.Gender());
		DD_Gender.selectByVisibleText("Male");

		createnewaccountpage.Address1().sendKeys("                         ");
		createnewaccountpage.Address2().sendKeys("                         ");
		createnewaccountpage.City().sendKeys("                         ");

		Select DD_State = new Select(createnewaccountpage.State());
		DD_State.selectByIndex(4);

		createnewaccountpage.PostCode().sendKeys("789456123");

		Thread.sleep(3000);

		createnewaccountpage.Continue().click();
		Thread.sleep(3000);

		List<WebElement> error = driver.findElements(By.xpath("//div[@class='text-danger ng-star-inserted']"));

		if (error.size() != 0) {
			for (WebElement er : error) {
				System.out.println(Console_Colors.RED_BOLD_BRIGHT + er.getText() + concol.RESET);
			}
		} else {
			Assert.fail(Console_Colors.RED_BOLD_BRIGHT
					+ "Error message is  not  displayed for invalid   address details" + concol.RESET);
		}

	}

	@Test(description = " To Validate the Mailing address fields with empty data")
	public void TC_028_Validate_Address_Fields_With_Empty_Data() throws InterruptedException {
		Thread.sleep(10000);

		Signuppage.Click_Signup_btn();
		Thread.sleep(10000);

		createnewaccountpage.FirstName().click();
		createnewaccountpage.FirstName().sendKeys("First" + System.currentTimeMillis());
		createnewaccountpage.LastName().sendKeys("Last" + System.currentTimeMillis());
		createnewaccountpage.Email().sendKeys("UserTest" + System.currentTimeMillis() + "@test.com");
		createnewaccountpage.CreatePassword().sendKeys("Test@1234");
		createnewaccountpage.ConfirmPassword().sendKeys("Test@1234");
		createnewaccountpage.PhoneNumber().sendKeys("2015551403");

		Select DD_Month = new Select(createnewaccountpage.Month_DOB());
		DD_Month.selectByIndex(3);

		Select DD_Day = new Select(createnewaccountpage.Date_DOB());
		DD_Day.selectByIndex(10);

		Select DD_Year = new Select(createnewaccountpage.Year_DOB());
		DD_Year.selectByVisibleText("1994");

		Thread.sleep(2000);

		zytobase.scrollTo(createnewaccountpage.Gender());

		Thread.sleep(3000);

		Select DD_Gender = new Select(createnewaccountpage.Gender());
		DD_Gender.selectByVisibleText("Male");

		Select DD_State = new Select(createnewaccountpage.State());
		DD_State.selectByIndex(4);

		createnewaccountpage.PostCode().sendKeys("789456123");

		Thread.sleep(3000);

		createnewaccountpage.Continue().click();
		Thread.sleep(3000);

		List<WebElement> error = driver.findElements(By.xpath("//div[@class='text-danger ng-star-inserted']"));

		if (error.size() != 0) {
			for (WebElement er : error) {
				System.out.println(Console_Colors.RED_BOLD_BRIGHT + er.getText() + concol.RESET);
			}
		} else {
			Assert.fail(Console_Colors.RED_BOLD_BRIGHT
					+ "Error message is  not  displayed for not entering address details" + concol.RESET);
		}

	}

	@Test(description = "To Validate Country Field")
	public void TC_029_Verify_Country_Field() throws InterruptedException {
		Thread.sleep(10000);

		Signuppage.Click_Signup_btn();
		Thread.sleep(10000);

		rp.Enter_Details_in_Reg_Form();
		Thread.sleep(5000);

		createnewaccountpage.Country_DD().selectByIndex(0);
		Thread.sleep(3000);

		createnewaccountpage.Continue().click();

		List<WebElement> error = driver.findElements(By.xpath("//div[@class='text-danger ng-star-inserted']"));

		if (error.size() != 0) {
			for (WebElement er : error) {
				System.out.println(Console_Colors.RED_BOLD_BRIGHT + er.getText() + concol.RESET);
			}
		} else {
			Assert.fail(Console_Colors.RED_BOLD_BRIGHT
					+ "Error message is  not  displayed for not entering Country details" + concol.RESET);
		}

	}

	@Test(description = "To Validate State/province  field as mandate")
	public void TC_030_Validate_State_Province_As_Mandate_Fields() throws InterruptedException {
		Thread.sleep(10000);

		Signuppage.Click_Signup_btn();
		Thread.sleep(10000);

		rp.Enter_Details_in_Reg_Form();
		Thread.sleep(5000);

		createnewaccountpage.State_DD().selectByIndex(0);
		Thread.sleep(3000);

		List<WebElement> error = driver.findElements(By.xpath("//div[@class='text-danger ng-star-inserted']"));

		if (error.size() != 0) {
			for (WebElement er : error) {
				System.out.println(Console_Colors.RED_BOLD_BRIGHT + er.getText() + concol.RESET);
			}
		} else {
			Assert.fail(Console_Colors.RED_BOLD_BRIGHT
					+ "Error message is  not  displayed for not entering Country details" + concol.RESET);
		}

	}

	@Test(description = "To Validate State/province  field as mandate")
	public void TC_031_Validate_State_Province_Fields() throws InterruptedException {
		Thread.sleep(10000);

		Signuppage.Click_Signup_btn();
		Thread.sleep(10000);

		createnewaccountpage.Country_DD().selectByVisibleText("India");
		Thread.sleep(3000);
		createnewaccountpage.State_DD().selectByVisibleText("Andhra Pradesh");
		Thread.sleep(3000);

		List<WebElement> error = driver.findElements(By.xpath("//div[@class='text-danger ng-star-inserted']"));

		if (error.size() != 0) {
			for (WebElement er : error) {
				System.out.println(Console_Colors.RED_BOLD_BRIGHT + er.getText() + concol.RESET);
				Assert.fail(Console_Colors.RED_BOLD_BRIGHT
						+ "Error message is  not  displayed for not entering Country details" + concol.RESET);
			}
		}
	}

	@Test(description = "To Validate Post Code field as mandate")
	public void TC_032_Validate_Post_Code_Field() throws InterruptedException {
		Thread.sleep(10000);

		Signuppage.Click_Signup_btn();
		Thread.sleep(10000);

		createnewaccountpage.FirstName().click();
		createnewaccountpage.FirstName().sendKeys("First" + System.currentTimeMillis());
		createnewaccountpage.LastName().sendKeys("Last" + System.currentTimeMillis());
		createnewaccountpage.Email().sendKeys("UserTest" + System.currentTimeMillis() + "@test.com");
		createnewaccountpage.CreatePassword().sendKeys("Test@1234");
		createnewaccountpage.ConfirmPassword().sendKeys("Test@1234");
		createnewaccountpage.PhoneNumber().sendKeys("2015551403");

		Select DD_Month = new Select(createnewaccountpage.Month_DOB());
		DD_Month.selectByIndex(3);

		Select DD_Day = new Select(createnewaccountpage.Date_DOB());
		DD_Day.selectByIndex(10);

		Select DD_Year = new Select(createnewaccountpage.Year_DOB());
		DD_Year.selectByVisibleText("1994");

		Thread.sleep(2000);

		zytobase.scrollTo(createnewaccountpage.Gender());

		Thread.sleep(3000);

		Select DD_Gender = new Select(createnewaccountpage.Gender());
		DD_Gender.selectByVisibleText("Male");

		createnewaccountpage.Address1().sendKeys("Address1");
		createnewaccountpage.Address2().sendKeys("Address1");
		createnewaccountpage.City().sendKeys("City");

		Select DD_State = new Select(createnewaccountpage.State());
		DD_State.selectByIndex(4);

		createnewaccountpage.Continue().click();
		Thread.sleep(3000);

		List<WebElement> error = driver.findElements(By.xpath("//div[@class='text-danger ng-star-inserted']"));

		if (error.size() != 0) {
			for (WebElement er : error) {
				System.out.println(Console_Colors.RED_BOLD_BRIGHT + er.getText() + concol.RESET);
			}
		} else {
			Assert.fail(Console_Colors.RED_BOLD_BRIGHT
					+ "Error message is  not  displayed for not entering post code details" + concol.RESET);
		}

	}

	@Test(description = "To Validate Continue button", testName = "TC_033_Validate Continue Button")
	public void TC_033_Validate_Continue_Button() throws InterruptedException {
		Thread.sleep(5000);

		rp.Registration();
		Thread.sleep(3000);

		List<WebElement> error = driver.findElements(By.xpath("//div[@class='text-danger ng-star-inserted']"));

		if (error.size() != 0) {
			for (WebElement er : error) {
				System.out.println(Console_Colors.RED_BOLD_BRIGHT + er.getText() + concol.RESET);
				Assert.fail(Console_Colors.RED_BOLD_BRIGHT + "Error message is  displayed for valid details"
						+ concol.RESET);
			}
		}
	}

	@Test(description = "To Validate Continue button and  errors")
	public void TC_034_Validate_Errors_On_Clicking_Continue_button() throws InterruptedException {
		Thread.sleep(10000);

		Signuppage.Click_Signup_btn();
		Thread.sleep(10000);

		createnewaccountpage.Continue().click();
		Thread.sleep(5000);

		List<WebElement> error = driver.findElements(By.xpath("//div[@class='text-danger ng-star-inserted']"));

		if (error.size() != 0) {
			for (WebElement er : error) {
				System.out.println(Console_Colors.RED_BOLD_BRIGHT + er.getText() + concol.RESET);
			}
		} else {
			Assert.fail(
					Console_Colors.RED_BOLD_BRIGHT + "Error message is not  displayed for empty fields" + concol.RESET);
		}
	}

	@Test(description = "To validate continue button after clearing errors")
	public void TC_035_Validate_clearing_Errors() throws InterruptedException {
		Thread.sleep(10000);

		Signuppage.Click_Signup_btn();
		Thread.sleep(10000);

		createnewaccountpage.Continue().click();
		Thread.sleep(5000);

		List<WebElement> error = driver.findElements(By.xpath("//div[@class='text-danger ng-star-inserted']"));

		if (error.size() != 0) {
			for (WebElement er : error) {
				System.out.println(Console_Colors.RED_BOLD_BRIGHT + er.getText() + concol.RESET);
			}
		} else {
			Assert.fail(
					Console_Colors.RED_BOLD_BRIGHT + "Error message is not  displayed for empty fields" + concol.RESET);
		}

		rp.Enter_Details_in_Reg_Form();
		Thread.sleep(3000);

		createnewaccountpage.Continue().click();
		Thread.sleep(3000);

		if (driver.findElement(By.xpath("//h2[contains(text(),'User Agreement')]")).isDisplayed()) {
			System.out.println(Console_Colors.CYAN_BOLD_BRIGHT + "Iam on User Agreement Page" + concol.RESET);
		} else {
			for (WebElement er : error) {
				System.out.println(Console_Colors.RED_BOLD_BRIGHT + er.getText() + concol.RESET);
				Assert.fail(
						Console_Colors.RED_BOLD_BRIGHT + "Error message is  displayed for valid fields" + concol.RESET);
			}
		}

	}
	
	@Test(description="To Verify all the fields with invalid data")
	public void TC_036_Verify_fields_with_Invalid_Data() throws InterruptedException {
		Thread.sleep(10000);

		Signuppage.Click_Signup_btn();
		Thread.sleep(10000);

		createnewaccountpage.FirstName().click();
		createnewaccountpage.FirstName().sendKeys("                 ");
		createnewaccountpage.LastName().sendKeys("                 ");
		createnewaccountpage.Email().sendKeys("                 ");
		createnewaccountpage.CreatePassword().sendKeys("                 ");
		createnewaccountpage.ConfirmPassword().sendKeys("                 ");
		createnewaccountpage.PhoneNumber().sendKeys("                 ");

		Select DD_Month = new Select(createnewaccountpage.Month_DOB());
		DD_Month.selectByIndex(0);

		Select DD_Day = new Select(createnewaccountpage.Date_DOB());
		DD_Day.selectByIndex(0);

		Select DD_Year = new Select(createnewaccountpage.Year_DOB());
		DD_Year.selectByIndex(0);;

		Thread.sleep(2000);

		zytobase.scrollTo(createnewaccountpage.Gender());

		Thread.sleep(3000);

		Select DD_Gender = new Select(createnewaccountpage.Gender());
		DD_Gender.selectByIndex(0);;

		createnewaccountpage.Address1().sendKeys("                 ");
		createnewaccountpage.Address2().sendKeys("                 ");
		createnewaccountpage.City().sendKeys("                 ");

		Select DD_State = new Select(createnewaccountpage.State());
		DD_State.selectByIndex(0);

		createnewaccountpage.Continue().click();
		Thread.sleep(3000);

		List<WebElement> error = driver.findElements(By.xpath("//div[@class='text-danger ng-star-inserted']"));

		if (error.size() != 0) {
			for (WebElement er : error) {
				System.out.println(Console_Colors.RED_BOLD_BRIGHT + er.getText() + concol.RESET);
			}
		} else {
			Assert.fail(Console_Colors.RED_BOLD_BRIGHT
					+ "Error message is  not  displayed for invalid details" + concol.RESET);
		}

	}

	@AfterMethod
	public void EndTest() {
		System.out.println(concol.BLUE_BOLD_BRIGHT + "****Quitting the browser****" + concol.RESET);
		driver.quit();
	}

}
