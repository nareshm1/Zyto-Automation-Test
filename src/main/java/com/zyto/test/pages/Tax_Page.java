package com.zyto.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.zyto.test.ConsoleColors.Console_Colors;
import com.zyto.test.base.ZytoBase;
import com.zyto.test.util.java.ElementLocatorUtils;
import com.zyto.test.util.java.JavascriptUtil;

public class Tax_Page extends ZytoBase {

	/*************************************
	 ************ TAX/VAT PAGE*************
	 *************************************/

	// Tax field
	@FindBy(xpath = "//input[@id='vatID']")
	static WebElement Tax_field;
	

	/************** PAGES TO BE USED ****************/

	public static Console_Colors colcon;
	public WebDriver driver;
	static ElementLocatorUtils el;
	public static JavascriptUtil jl;

	/************** Initialize page elements ***********/

	public Tax_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		System.out.println(colcon.BLUE_BOLD_BRIGHT + "I am on ------> Tax Page" + colcon.RESET);
	}

	/**** Passing WebElements ************/
	public static WebElement Tax__TP() {
		return Tax_field;
	}
}
