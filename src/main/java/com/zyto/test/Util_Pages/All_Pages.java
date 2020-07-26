package com.zyto.test.Util_Pages;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.zyto.test.ConsoleColors.Console_Colors;
import com.zyto.test.base.ZytoBase;
import com.zyto.test.base.ZytoBaseTest;
import com.zyto.test.pages.Create_New_Account_Page;
import com.zyto.test.pages.Introduction_Page;
import com.zyto.test.pages.Login_Page;
import com.zyto.test.pages.Signup_Options_page;
import com.zyto.test.util.java.ConstantKeywords;
import com.zyto.test.util.java.ElementLocatorUtils;
import com.zyto.test.util.java.ExcelImporterUtil;
import com.zyto.test.util.java.JavascriptUtil;
import com.zyto.test.util.java.Test_Utilities_File;
import com.zyto.test.util.java.WebEventListener;

public class All_Pages extends ZytoBase {

	/**
	 * Instead of declaring all the pages in each individual pages and tests below
	 * methods can be called
	 *****/

	/**** WebDriver Declaration ****/
	public static WebDriver driver;

	/*** Base Pages ***/
	public static ZytoBase zytobase;
	public static ZytoBaseTest zytobasetest;

	/**** Pages Declaration *********/
	public static Create_New_Account_Page createaccountpage;
	public static Introduction_Page intropage;
	public static Login_Page loginpage;
	public static Signup_Options_page singuppage;

	/*** Util pages declaration ***/
	public static ElementLocatorUtils el;
	public static JavascriptUtil jl;
	public static Console_Colors colcon;
	public static ConstantKeywords constkeys;
	public static Test_Utilities_File testutils;
	public static ExcelImporterUtil excel;
	public static EventFiringWebDriver e_driver;

	

	public All_Pages(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		System.out.println(colcon.BLUE_BOLD_BRIGHT + "Signup Options Page Test Started" + colcon.RESET);
	}

	public static void Initializer() throws InterruptedException {
		zytobase = new ZytoBase();
		prop = zytobase.init_prop();
		driver = zytobase.init_driver(prop);
		EventFire();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		Thread.sleep(10000);
		long waitTime = 10;
		WebDriverWait wait = new WebDriverWait(driver, waitTime);
		
	}

	public static void All_Pages_Call() {
		createaccountpage = new Create_New_Account_Page(driver);
		intropage = new Introduction_Page(driver);
		loginpage = new Login_Page(driver);
		singuppage = new Signup_Options_page(driver);
		
	}
	
	public static void EventFire() {
		// Initializing EventFiringWebDriver using Firefox WebDriver instance
		  e_driver = new EventFiringWebDriver(driver);

		// Now create object of EventListerHandler to register it with
		// EventFiringWebDriver
		WebEventListener eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
	}
	
	public String randomSpecial(int count)
	{
	    String characters = "~`!@#$%^&*()-_=+[{]}\\|;:\'\",<.>/?ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
	    String generatedString = RandomStringUtils.random(count, characters);
	    return generatedString;
	}

}
