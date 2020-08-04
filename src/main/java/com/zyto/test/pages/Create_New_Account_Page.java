package com.zyto.test.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.zyto.test.ConsoleColors.Console_Colors;
import com.zyto.test.base.ZytoBase;
import com.zyto.test.util.java.ElementLocatorUtils;
import com.zyto.test.util.java.JavascriptUtil;

public class Create_New_Account_Page extends ZytoBase {

	/***********************************
	 ******* CREATE NEW ACCOUNT PAGE*********
	 ***********************************/
	// FIRST NAME FEILD
	@FindBy(xpath = "//input[@id='fName']")
	static WebElement First_Name;
	
	By First_Name1 =  By.xpath("//input[@id='fName']");

	// LAST NAME FEILD
	@FindBy(xpath = "//input[@id='lName']")
	static WebElement Last_Name;

	// Email FEILD
	@FindBy(xpath = "//input[@id='email']")
	static WebElement Email;

	// Create Password FEILD
	@FindBy(xpath = "//input[@id='cp']")
	static WebElement Create_Password;

	// Confirm Password FEILD
	@FindBy(xpath = "//input[@id='cp1']")
	static WebElement Confirm_Password;

	// Country Dropdown
	@FindBy(xpath = "//div[@class='selected-flag dropdown-toggle']")
	static WebElement Phone_Country_Dropdown;

	// Country Code displayed on dropdown
	@FindBy(xpath = "//div[@class='selected-dial-code ng-star-inserted']")
	static WebElement Country_code_Selected;

	// Search Country Text field
	@FindBy(xpath = "//input[@id='country-search-box']")
	static WebElement Select_Country_Text;

	// Country List in dropdown
	@FindBy(xpath = "//ul")
	static WebElement Country_List_In_Dropdown;

	// Country as Individual
	@FindBy(xpath = "//ul//li[@class='country ng-star-inserted']")
	static List<WebElement> Country_Individual_In_Dropdown;

	// Country name in dropdown individual
	@FindBy(xpath = "//ul//li[@class='country ng-star-inserted']//span[1]")
	static List<WebElement> Country_Individual_name_In_Dropdown;

	// Country code in dropdown individual
	@FindBy(xpath = "//ul//li[@class='country ng-star-inserted']//span[2]")
	static WebElement Country_Individual_code_In_Dropdown;

	// Phone number
	@FindBy(xpath = "//input[@id='phone']")
	static WebElement Phone_Number_Field;

	// Dob month dropdown
	@FindBy(xpath = "//select[@id='month']")
	static WebElement Month_in_DOB;

	// Dob date dropdown
	@FindBy(xpath = "//select[@id='date']")
	static WebElement Date_in_DOB;

	// Dob year dropdown
	@FindBy(xpath = "//select[@id='year']")
	static WebElement Year_in_DOB;

	// Gender dropdown
	@FindBy(xpath = "//select[@id='male']")
	static WebElement Gender_Dropdown;

	// Address 1 field
	@FindBy(xpath = "//input[@id='Address1']")
	static WebElement Address1_Field;

	// Address 2 field
	@FindBy(xpath = "//input[@id='Address2']")
	static WebElement Address2_Field;

	// City field
	@FindBy(xpath = "//input[@id='city']")
	static WebElement City_Field;

	// Country dropdown
	@FindBy(xpath = "//select[@id='country']")
	static WebElement Country_Dropdown;

	// State/Province dropdown
	@FindBy(xpath = "//select[@id='state']")
	static WebElement State_Dropdown;

	// PostCodee dropdown
	@FindBy(xpath = "//input[@id='pcode']")
	static WebElement Postcode_Field;

	// Continue/Submit button
	@FindBy(xpath = "//button[@class='btn btn-blue mt-3']")
	static WebElement Continue_button;

	// Scroll Up button
	@FindBy(xpath = "//button[@class='scroll-to-top show-scroll']//mat-icon")
	static WebElement Scroll_Up_button;

	// Language change option -- World icon
	@FindBy(xpath = "//a[@class='mr-2']")
	static WebElement Language_Change_World_Icon;

	/****************** SELECT A LANGUAGE FROM POPUP/FRAME *******************/

	// English Language Radiobutton
	@FindBy(xpath = "//input[@value='en']")
	static WebElement English_Language_RadioBtn;

	// Spanish Language Radiobutton
	@FindBy(xpath = "//input[@value='es']")
	static WebElement Spanish_Language_RadioBtn;

	// Spanish Language Radiobutton
	@FindBy(xpath = "//i")
	static WebElement Cross_icon_on_Frame;

	/************** PAGES TO BE USED ****************/

	public static Console_Colors colcon;
	public WebDriver driver;
	static ElementLocatorUtils el;
	public static JavascriptUtil jl;

	/************** Initialize page elements ***********/

	public Create_New_Account_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		System.out.println(colcon.BLUE_BOLD_BRIGHT + "Signup Options Page Test Started" + colcon.RESET);
	}

	/******************** Passing WebElements **************/

	public WebElement FirstName() {
		return First_Name;
	}

	public WebElement LastName() {
		return Last_Name;
	}

	public WebElement Email() {
		return Email;
	}

	public WebElement CreatePassword() {
		return Create_Password;
	}

	public WebElement ConfirmPassword() {
		return Confirm_Password;
	}

	public WebElement PhoneNumber() {
		return Phone_Number_Field;
	}

	public WebElement Country_Code_dropdown() {
		return Phone_Country_Dropdown;
	}

	public WebElement Country_Name_dropdown() {
		return Select_Country_Text;
	}

	public List<WebElement> Country_In_Dropdonw() {
		return Country_Individual_In_Dropdown;
	}

	public List<WebElement> Country_Name_In_Dropdown() {
		return Country_Individual_name_In_Dropdown;
	}

	public WebElement Month_DOB() {
		return Month_in_DOB;
	}

	public WebElement Date_DOB() {
		return Date_in_DOB;
	}

	public WebElement Year_DOB() {
		return Year_in_DOB;
	}

	public WebElement Gender() {
		return Gender_Dropdown;
	}

	public WebElement Address1() {
		return Address1_Field;
	}

	public WebElement Address2() {
		return Address2_Field;
	}

	public WebElement City() {
		return City_Field;
	}

	public WebElement Country() {
		return Country_Dropdown;
	}

	public WebElement State() {
		return State_Dropdown;
	}

	public WebElement PostCode() {
		return Postcode_Field;
	}

	public WebElement Continue() {
		return Continue_button;
	}

	public Select Month_DOB_Select() {
		Select month = new Select(Month_in_DOB);
		return month;
	}

	public Select Date_DOB_Select() {
		Select Date = new Select(Date_in_DOB);
		return Date;
	}

	public Select Year_DOB_Select() {
		Select Year = new Select(Year_in_DOB);
		return Year;
	}

	public Select Gender_DD() {
		Select Gender = new Select(Gender_Dropdown);
		return Gender;
	}

	public Select Country_DD() {
		Select Country = new Select(Country_Dropdown);
		return Country;
	}

	public Select State_DD() {
		Select state = new Select(State_Dropdown);
		return state;
	}
	
	
}
