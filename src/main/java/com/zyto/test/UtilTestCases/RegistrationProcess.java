package com.zyto.test.UtilTestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.zyto.test.ConsoleColors.Console_Colors;
import com.zyto.test.base.ZytoBase;
import com.zyto.test.pages.Create_New_Account_Page;
import com.zyto.test.pages.Product_Company_Selection_Page;
import com.zyto.test.pages.Signup_Options_page;
import com.zyto.test.pages.User_Agreement_Page;
import com.zyto.test.util.java.JavascriptUtil;

public class RegistrationProcess extends ZytoBase {

	// Pages to Used //
	static ZytoBase zytobase;
	static Console_Colors concol;
	static Signup_Options_page Signuppage;
	JavascriptUtil jl;
	static Create_New_Account_Page registration;
	static User_Agreement_Page uap;
	static Product_Company_Selection_Page pcsp;
	

	public RegistrationProcess(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		Signuppage = new Signup_Options_page(driver);
		registration = new Create_New_Account_Page(driver);
		 uap =  new User_Agreement_Page(driver);
		 concol = new Console_Colors();
		 pcsp= new Product_Company_Selection_Page(driver);
		
		//super();
	}

	// Init()
	
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
		//System.out.println(concol.BLUE_BOLD_BRIGHT + "****Create New Account Test Started****" + concol.RESET);
		

	}

	
	public static void Registration() throws InterruptedException {
		Signuppage.Click_Signup_btn();
		Thread.sleep(3000);

		registration.FirstName().sendKeys("First" + System.currentTimeMillis());
		registration.LastName().sendKeys("Last" + System.currentTimeMillis());
		registration.Email().sendKeys("UserTest" + System.currentTimeMillis() + "@test.com");
		registration.CreatePassword().sendKeys("Test@1234");
		registration.ConfirmPassword().sendKeys("Test@1234");
		registration.PhoneNumber().sendKeys("2015551403");

		Select DD_Month = new Select(registration.Month_DOB());
		DD_Month.selectByIndex(3);

		Select DD_Day = new Select(registration.Date_DOB());
		DD_Day.selectByIndex(10);

		Select DD_Year = new Select(registration.Year_DOB());
		DD_Year.selectByVisibleText("1994");
		
		Thread.sleep(2000);
		
		zytobase.scrollTo(registration.Gender());
		
		Thread.sleep(3000);

		Select DD_Gender = new Select(registration.Gender());
		DD_Gender.selectByVisibleText("Male");

		registration.Address1().sendKeys("Addressline1");
		registration.Address2().sendKeys("Address2");
		registration.City().sendKeys("NewYork");

		Select DD_State = new Select(registration.State());
		DD_State.selectByIndex(4);

		registration.PostCode().sendKeys("789456123");

		registration.Continue().click();

		Thread.sleep(3000);

	}
	

	public void Enter_Details_in_Reg_Form() throws InterruptedException {
		
           
		Thread.sleep(5000);
		registration.FirstName().click();
		registration.FirstName().sendKeys("First" + System.currentTimeMillis());
		registration.LastName().sendKeys("Last" + System.currentTimeMillis());
		registration.Email().sendKeys("UserTest" + System.currentTimeMillis() + "@test.com");
		registration.CreatePassword().sendKeys("Test@1234");
		registration.ConfirmPassword().sendKeys("Test@1234");
		registration.PhoneNumber().sendKeys("2015551403");

		Select DD_Month = new Select(registration.Month_DOB());
		DD_Month.selectByIndex(3);

		Select DD_Day = new Select(registration.Date_DOB());
		DD_Day.selectByIndex(10);

		Select DD_Year = new Select(registration.Year_DOB());
		DD_Year.selectByVisibleText("1994");
		
		Thread.sleep(2000);
		
		zytobase.scrollTo(registration.Gender());
		
		Thread.sleep(3000);

		Select DD_Gender = new Select(registration.Gender());
		DD_Gender.selectByVisibleText("Male");

		registration.Address1().sendKeys("Addressline1");
		registration.Address2().sendKeys("Address2");
		registration.City().sendKeys("NewYork");

		Select DD_State = new Select(registration.State());
		DD_State.selectByIndex(4);

		registration.PostCode().sendKeys("789456123");

		
		Thread.sleep(3000);

	}
	
	public static void Reg_till_Pscp() throws InterruptedException {
		Thread.sleep(10000);

		Registration();
		Thread.sleep(15000);

		driver.switchTo().frame(0);
        Thread.sleep(5000);
	
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
		Thread.sleep(10000);


		uap.Continue_button_UAGP().click();
		Thread.sleep(5000);
		
	}

	public static void Reg_till_pmp() throws InterruptedException {
		Reg_till_Pscp();
		Thread.sleep(5000);
		
		pcsp.Product_Company().selectByIndex(4);
		Thread.sleep(5000);
		
		pcsp.Continue_button().click();
		Thread.sleep(5000);
	}
	
	
	@AfterMethod
	public void EndTest() {
		System.out.println(concol.BLUE_BOLD_BRIGHT + "****Quitting the browser****" + concol.RESET);
		driver.quit();
	}

}
