package com.zyto.test.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.zyto.test.ConsoleColors.Console_Colors;
import com.zyto.test.base.ZytoBase;
import com.zyto.test.util.java.ElementLocatorUtils;
import com.zyto.test.util.java.JavascriptUtil;

public class User_Agreement_Page extends ZytoBase {

	/******************************************
	 ************ USER AGREEMENT PAGE************
	 *******************************************/
	// First Name
	@FindBy(xpath = "//input[@id='first_name']")
	static WebElement FirstName;

	// Last Name
	@FindBy(xpath = "//input[@id='last_name']")
	static WebElement LastName;

	// Email
	@FindBy(xpath = "//input[@id='email']")
	static WebElement Email;

	// Continue button
	@FindBy(xpath = "//button[contains(text(),'Continue')]")
	static WebElement Continue_button;

	// Next button
	@FindBy(xpath = "//button[contains(text(),'Next')]")
	static WebElement Next_button;

	// Click to sign on document
	@FindBy(xpath = "//span[contains(text(),'Click to sign')]")
	static WebElement Click_To_Sign;

	// Draw tab
	@FindBy(xpath = "//button[contains(text(),'Draw')]")
	static WebElement Draw_Tab;

	// Canvas to Draw
	@FindBy(xpath = "//canvas[@class='draw-signature__canvas draw-signature__canvas--sized']")
	static WebElement Canvas_To_Draw;

	// Clearing the canvas
	@FindBy(xpath = "//button//span[contains(text(),'Clear')]")
	static WebElement Clear_Canvas;

	// Type tab
	@FindBy(xpath = "//button[contains(text(),'Type')]")
	static WebElement Type_Tab;

	// Signature Text
	@FindBy(xpath = "//input[@ng-model='signatureModel.text']")
	static WebElement Sign_Text;

	// List of Sign models
	@FindBy(xpath = "//ul[@class='clearfix']//li")
	static WebElement Sign_Models;
	
	//Select model
	@FindBy(xpath="//button[@class='btn sig-type__font-preview tk-madre-script sig-type__font-preview--RED']")
	static WebElement Sign_Model2;

	// Sign color - black
	@FindBy(xpath = "//button[contains(text(),'Black')]")
	static WebElement Black_Color;

	// Sign color - Blue
	@FindBy(xpath = "//button[contains(text(),'Blue')]")
	static WebElement Blue_Color;

	// Sign color - Red
	@FindBy(xpath = "//button[contains(text(),'Red')]")
	static WebElement Red_Color;

	// Accept and Sign button
	@FindBy(xpath = "//span[@data-key='common::buttons::accept_and_sign']")
	static WebElement Accept_and_Sign;

	// SingnatureView on page
	@FindBy(xpath = "//div[@class='signature-view ng-isolate-scope']")
	static WebElement Signature_View;

	// My Signature tab
	@FindBy(xpath = "//button[contains(text(),'My signature')]")
	static WebElement My_Sign_Tab;

	// Signature
	@FindBy(xpath = "//div[@class='a--center']")
	static WebElement Signature;

	// Finalize document button
	@FindBy(xpath = "//span[contains(text(),'Finalize document')]")
	static WebElement Finalize_Document;

	// Thank you text on popup
	@FindBy(xpath = "//h3[contains(text(),'Thank you!')]")
	static WebElement Thank_You_Text;

	// Download document button
	@FindBy(xpath = "//a[@class='btn btn-primary btn-lg dialog-tpl-done__action m--bottom-none ng-scope']")
	static WebElement Download_Document;

	/************** PAGES TO BE USED ****************/

	public static Console_Colors colcon;
	public WebDriver driver;
	static ElementLocatorUtils el;
	public static JavascriptUtil jl;

	/************** Initialize page elements ***********/

	public User_Agreement_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		System.out.println(colcon.BLUE_BOLD_BRIGHT + "I am on ---->User Agreement Page" + colcon.RESET);
	}

	/**** Passing WebElements **********/

	public static WebElement FirstName_UAGP() {
		return FirstName;
	}

	public static WebElement LastName_UAGP() {
		return LastName;
	}

	public static WebElement Email_UAGP() {
		return Email;
	}

	public static WebElement Continue_button_UAGP() {
		return Continue_button;
	}

	public static WebElement Next_button_UAGP() {
		return Next_button;
	}

	public static WebElement Click_To_Sign_UAGP() {
		return Click_To_Sign;
	}

	public static WebElement Draw_Tab_UAGP() {
		return Draw_Tab;
	}

	public static WebElement Canvas_To_Draw_UAGP() {
		return Canvas_To_Draw;
	}

	public static WebElement Clear_Canvas_UAGP() {
		return Clear_Canvas;
	}

	public static WebElement Type_Tab_UAGP() {
		return Type_Tab;
	}

	public static WebElement Sign_Text_UAGP() {
		return Sign_Text;
	}

	public static WebElement Sign_Models_UAGP() {
		return Sign_Models;
	}
	
	public static WebElement Sign_Model2_UAGP() {
		return Sign_Model2;
	}

	public static WebElement Black_Text_UAGP() {
		return Black_Color;
	}

	public static WebElement Blue_Text_UAGP() {
		return Blue_Color;
	}

	public static WebElement Red_Text_UAGP() {
		return Red_Color;
	}

	public static WebElement Accept_n_Sign_UAGP() {
		return Accept_and_Sign;
	}

	public static WebElement Signature_View_UAGP() {
		return Signature_View;
	}

	public static WebElement My_Sign_Tab_UAGP() {
		return My_Sign_Tab;
	}

	public static WebElement Signature_UAGP() {
		return Signature;
	}

	public static WebElement Finalize_Doc_UAGP() {
		return Finalize_Document;
	}

	public static WebElement Thank_You_Text_UAGP() {
		return Thank_You_Text;
	}

	public static WebElement Download_Doc_UAGP() {
		return Download_Document;
	}
}
