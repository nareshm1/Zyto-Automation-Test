package com.zyto.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.zyto.test.ConsoleColors.Console_Colors;
import com.zyto.test.base.ZytoBase;
import com.zyto.test.util.java.ElementLocatorUtils;
import com.zyto.test.util.java.JavascriptUtil;

public class Payment_Method_Page extends ZytoBase {

	/***********************************
	 ******* PAYMENT METHOD PAGE*********
	 ***********************************/

	/******** Billing Address *************/
	// Address line 1
	@FindBy(xpath = "//input[@id='BAddress']")
	static WebElement Address_Line;

	// City Field
	@FindBy(xpath = "//input[@id='City']")
	static WebElement City;

	// Country droddown
	@FindBy(xpath = "//select[@id='country']")
	static WebElement Country;

	// State droddown
	@FindBy(xpath = "//select[@id='state']")
	static WebElement State;

	// Post Code
	@FindBy(xpath = "//input[@id='PostalCode']")
	static WebElement Postal_Code;

	/*** Card Details *****/
	// Name on the Card
	@FindBy(xpath = "//input[@id='NameCard']")
	static WebElement Name_Card;

	// Card Number
	@FindBy(xpath = "//input[@id='CardNumber']")
	static WebElement Card_number;

	// Expire Date
	@FindBy(xpath = "//input[@id='ExpireDate']")
	static WebElement Expiry_Date;

	// CVV
	@FindBy(xpath = "//input[@id='CVV']")
	static WebElement CVV;

	// Continue button
	@FindBy(xpath = "//button[contains(text(),'Continue')]")
	static WebElement Continue_button;
	
	/************** PAGES TO BE USED ****************/

	public static Console_Colors colcon;
	public WebDriver driver;
	static ElementLocatorUtils el;
	public static JavascriptUtil jl;

	/************** Initialize page elements ***********/

	public Payment_Method_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		System.out.println(colcon.BLUE_BOLD_BRIGHT + "Iam on --> Payment Method Page" + colcon.RESET);
	}
	

	/***** Passing WebElements **********/

	public static WebElement Billing_Address_PMP() {
		return Address_Line;
	}

	public static WebElement City_PMP() {
		return City;
	}

	public static WebElement Country_DD_PMP() {
		return Country;
	}

	public static WebElement State_DD_PMP() {
		return State;
	}

	public static WebElement Postal_Code_PMP() {
		return Postal_Code;
	}

	public static WebElement Name_On_Card_PMP() {
		return Name_Card;
	}

	public static WebElement Card_Number_PMP() {
		return Card_number;
	}

	public static WebElement Expiry_PMP() {
		return Expiry_Date;
	}

	public static WebElement CVV_PMP() {
		return CVV;
	}
	
	public static WebElement Continue_button() {
		return Continue_button;
	}

	/*** Actions to be performed ********/

	public static Select Country_PMP() {
		Select country = new Select(Country);
		return country;
	}
	
	public static Select State_PMP() {
		Select state =  new Select(State);
		return state;
	}
}
