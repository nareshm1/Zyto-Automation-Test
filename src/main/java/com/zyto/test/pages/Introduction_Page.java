package com.zyto.test.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.zyto.test.ConsoleColors.Console_Colors;
import com.zyto.test.base.ZytoBase;
import com.zyto.test.util.java.ConstantKeywords;
import com.zyto.test.util.java.ElementLocatorUtils;
import com.zyto.test.util.java.JavascriptUtil;

public class Introduction_Page extends ZytoBase {
	

	/***********************************
	 ******* INTRODUCTION PAGE*********
	 ***********************************/
	 // Create Account button on Signup Options page
	@FindBy(xpath = "//button[@type='button'][contains(text(),'Continue')]")
	static WebElement Intro_Continue_button;
	
	//Text on Intro page
	@FindBy(xpath ="//div[@class='sign-container mt-3 mt-md-5']")
	static WebElement Intro_Page_Text;
	
	/************** PAGES TO BE USED ****************/

	public static Console_Colors colcon;
	public static WebDriver driver;
	static ElementLocatorUtils el;
	static JavascriptUtil jl;

	/************** Initialize page elements ***********/

	public Introduction_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		System.out.println(colcon.BLUE_BOLD_BRIGHT + "Introduction Page Test Started" + colcon.RESET);
	}
	
	/************Passing WebElements************/
	
	public WebElement intropage_continuebutton() {
		return Intro_Continue_button;
		
	}
	

	/************** ACTIONS TO BE PERFOMED  ***********/

	// Validate the content on Page
	public static String  Validate_Content() {
		String Content =Intro_Page_Text.getText() ;
		return Content;
	}
	
	//Click on Continue button
	public static void Click_Continue_button() throws InterruptedException {
		scrollTo(Intro_Continue_button);
		Thread.sleep(3000);
		Intro_Continue_button.click();
	}
	
		
	

}
