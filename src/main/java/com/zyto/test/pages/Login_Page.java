package com.zyto.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.zyto.test.ConsoleColors.Console_Colors;
import com.zyto.test.base.ZytoBase;
import com.zyto.test.util.java.ElementLocatorUtils;
import com.zyto.test.util.java.JavascriptUtil;

public class Login_Page extends ZytoBase {

	/***********************************
	 ** ***************LOGIN  PAGE*********
	 ***********************************/
	// Login Email FEILD
	@FindBy(xpath = "//input[@name='email']")
	static WebElement Login_Email;
	
	//Login Password 
	@FindBy(xpath= "//input[@name='password']")
	static WebElement Login_Password;
	
	//Don't remember your password?
	@FindBy(xpath="//a[@class='auth0-lock-alternative-link']")
	static WebElement Forgot_Password;
	
	//Signin button
	@FindBy(xpath="//span[@class='auth0-label-submit']")
	static WebElement Signin_button;	

	/************** PAGES TO BE USED ****************/

	public static Console_Colors colcon;
	public WebDriver driver;
	static ElementLocatorUtils el;
	public static JavascriptUtil jl;

	/************** Initialize page elements ***********/

	public Login_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		System.out.println(colcon.BLUE_BOLD_BRIGHT + "Iam on ---> Payment Method Page " + colcon.RESET);
	}
	
	/**********Passing WebElements*********/
	public static WebElement LoginEmail() {
		return Login_Email;
	}
	
	public static  WebElement LoginPassword() {
		return Login_Password;
	}
	
	public static  WebElement ForgotPassword() {
		return Forgot_Password;
	}
	
	public static  WebElement Signinbutton() {
		return Signin_button;
	}
	
	/****Actions to be performed ******/
	
	//Entering input into Email fields
	public static void Login_Email_Input(String Email) {
		LoginEmail().sendKeys(Email);
	}
	
	//Entering input into Password fields
	public static void Login_Password_Input(String Password) {
		LoginPassword().sendKeys(Password);
	}
	
	//Clicking on Forgot password link
	public static void Forgot_Password_Click() {
		ForgotPassword().click();
	}
	
	//Clicking on Signin button
	public static void Sigin_button_Click() {
		Signinbutton().click();
	}
	
	
	
}


