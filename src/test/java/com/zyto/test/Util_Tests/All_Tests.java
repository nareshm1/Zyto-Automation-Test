package com.zyto.test.Util_Tests;

import org.openqa.selenium.WebDriver;

import com.zyto.test.TestCases.Create_New_Account_Test;
import com.zyto.test.TestCases.Introduction_Page_Test;
import com.zyto.test.TestCases.Registration_Test;
import com.zyto.test.UtilTestCases.RegistrationProcess;
import com.zyto.test.base.ZytoBase;
import com.zyto.test.pages.Introduction_Page;

public class All_Tests extends ZytoBase{
	
	/* Instead of declaring all the tests in each individual pages and tests below
	 * methods can be called
	 *****/

	/**** WebDriver Declaration ****/
	public static WebDriver driver;
	
	/**** Test Pages declaration ***/
	  public static Create_New_Account_Test createnewaccounttest;
	  public static Introduction_Page_Test intropagetest; 
	  public static Registration_Test registerpagetest;
	  
	 /** Test Util Declaration ***/
	
	  public static RegistrationProcess registration;
	  
	  public All_Tests(WebDriver driver) {
		  super();
	  }
				
	  public static void All_Tests() {
		  createnewaccounttest = new Create_New_Account_Test();
		  intropagetest= new Introduction_Page_Test();
		  registerpagetest = new Registration_Test();
		  
		  
		  registration = new  RegistrationProcess(driver);
		  
	  }
	  
	  

}
