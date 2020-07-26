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

public class Product_Company_Selection_Page extends ZytoBase {

	/***********************************
	 ******* PRODUCT COMPANY SELECTION PAGE*********
	 ***********************************/
	 // Dropdown to select the Product company
	@FindBy(xpath = "//select[@id='proCompany']")
	static WebElement Product_Company;
	
	//Continue button
	@FindBy(xpath="//button[contains(text(),'Continue')]")
	static WebElement Continue_button;
	
	
	/****Passing WebElements******/
	public static WebElement Product_Comapny_DD() {
		return Product_Company;
	}
	
	public static WebElement Continue_button() {
			return Continue_button;
	}
	

	/************** PAGES TO BE USED ****************/

	public static Console_Colors colcon;
	public WebDriver driver;
	static ElementLocatorUtils el;
	public static JavascriptUtil jl;

	/************** Initialize page elements ***********/

	public Product_Company_Selection_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		System.out.println(colcon.BLUE_BOLD_BRIGHT + "I am on ----> Product Company Selection Page " + colcon.RESET);
	}
	
	/****Actions To be performed*********/
	public static Select Product_Company() {
		Select ProCompany =  new Select(Product_Company);
		return ProCompany;
	}
}
