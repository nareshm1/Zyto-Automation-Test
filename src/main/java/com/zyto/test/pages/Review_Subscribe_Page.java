package com.zyto.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.zyto.test.ConsoleColors.Console_Colors;
import com.zyto.test.base.ZytoBase;
import com.zyto.test.util.java.ElementLocatorUtils;
import com.zyto.test.util.java.JavascriptUtil;

public class Review_Subscribe_Page extends ZytoBase {

	/***********************************
	 ******* REVIEW and SUBSCRIBE PAGE*********
	 ***********************************/
	// Edit button on card details
	@FindBy(xpath = "//a[@class='body-link-u font-16 p-absolute-right']")
	static WebElement Edit_button;

	// Card details
	@FindBy(xpath = "//div[@class='pl-3 pt-2 pb-1 font-16']//p[@class='mb-0'][1]//b")
	static WebElement Card_details;

	// Expiry details
	@FindBy(xpath = "//div[@class='pl-3 pt-2 pb-1 font-16']//p[@class='mb-0'][2]//b")
	static WebElement Expiry_details;

	// Zyto Insights Price
	@FindBy(xpath = "//tr[@class='border-bottom ng-star-inserted'][1]//td[2]")
	static WebElement Zyto_Insights;

	// Zyto Insights Price
	@FindBy(xpath = "//tr[@class='border-bottom ng-star-inserted'][2]//td[2]")
	static WebElement Zyto_Insights_Pro;

	// Sub total
	@FindBy(xpath = "//td[@class='text-right ng-star-inserted']//span")
	static WebElement Sub_Total;

	// Total
	@FindBy(xpath = "//td[@class='text-right']//span")
	static WebElement Total;

	// Tax code
	@FindBy(xpath = "//div[@class='ng-star-inserted']//p[1]")
	static WebElement Tax_code;

	// Customer Tax Id
	@FindBy(xpath = "//div[@class='ng-star-inserted']//p[2]")
	static WebElement Cust_Tax_Id;

	// Zyto Tax Id
	@FindBy(xpath = "//div[@class='ng-star-inserted']//p[3]")
	static WebElement Zyto_Tax_Id;

	// VAT amount
	@FindBy(xpath = "//div[@class='ng-star-inserted']//p[4]")
	static WebElement VAT_Amount;

	// Exchange rate
	@FindBy(xpath = "//div[@class='ng-star-inserted']//p[4]")
	static WebElement Exchange_rate;

	// Subscribe button
	@FindBy(xpath = "//button[contains(text(),'Subscribe')]")
	static WebElement Subscribe_button;
	
	/************** PAGES TO BE USED ****************/

	public static Console_Colors colcon;
	public WebDriver driver;
	static ElementLocatorUtils el;
	public static JavascriptUtil jl;

	/************** Initialize page elements ***********/

	public Review_Subscribe_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		System.out.println(colcon.BLUE_BOLD_BRIGHT + "I am on ----> Review and Subscribe Page" + colcon.RESET);
	}

	/***** Passing WebElements ********/
	public static WebElement Edit_button_RSP() {
		return Edit_button;
	}

	public static WebElement Card_details_RSP() {
		return Card_details;
	}

	public static WebElement Expiry_details_RSP() {
		return Expiry_details;
	}

	public static WebElement Zyto_Insights_RSP() {
		return Zyto_Insights;
	}
	
	public static WebElement Zyto_Insights_Pro_RSP() {
		return Zyto_Insights_Pro;
	}
	
	public static WebElement Subtotal_RSP() {
		return Sub_Total;
	}
	
	public static WebElement Total_RSP() {
		return Total;
	}
	
	public static WebElement Tax_code_RSP() {
		return Tax_code;
	}
	
	public static WebElement Customer_VAT_RSP() {
		return Cust_Tax_Id;
	}
	
	public static WebElement Zyto_VAT_RSP() {
		return Zyto_Tax_Id;
	}
	
	public static WebElement VAT_Amount_RSP() {
		return VAT_Amount;
	}
	
	public static WebElement Exchange_Rate_RSP() {
		return Exchange_rate;
	}
	
	public static WebElement Subscribe_button_RSP() {
		return Subscribe_button;
	}
	

}
