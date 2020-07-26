package com.zyto.test.util.java;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.zyto.test.ConsoleColors.Console_Colors;
import com.zyto.test.base.ZytoBase;
import com.zyto.test.base.ZytoBaseTest;

public class WebEventListener extends ZytoBase implements WebDriverEventListener {
	
	Console_Colors concol;
	
	public void beforeNavigateTo(String url, WebDriver tldriver) {
		System.out.println(concol.PURPLE_BOLD_BRIGHT+"Before navigating to: '" + url + "'"+concol.RESET);
	}

	public void afterNavigateTo(String url, WebDriver driver) {
		System.out.println(concol.PURPLE_BOLD_BRIGHT+"Navigated to:'" + url + "'"+concol.RESET);
	}

	public void beforeChangeValueOf(WebElement element, WebDriver driver) {
		System.out.println(concol.PURPLE_BOLD_BRIGHT+"Value of the:" + element.toString() + " before any changes made"+concol.RESET);
	}

	public void afterChangeValueOf(WebElement element, WebDriver driver) {
		System.out.println(concol.PURPLE_BOLD_BRIGHT+"Element value changed to: " + element.toString()+concol.RESET);
	}

	public void beforeClickOn(WebElement element, WebDriver driver) {
		System.out.println(concol.PURPLE_BOLD_BRIGHT+"Trying to click on: " + element.toString()+concol.RESET);
	}

	public void afterClickOn(WebElement element, WebDriver driver) {
		System.out.println(concol.PURPLE_BOLD_BRIGHT+"Clicked on: " + element.toString()+concol.RESET);
	}

	public void beforeNavigateBack(WebDriver driver) {
		System.out.println(concol.PURPLE_BOLD_BRIGHT+"Navigating back to previous page"+concol.RESET);
	}

	public void afterNavigateBack(WebDriver driver) {
		System.out.println(concol.PURPLE_BOLD_BRIGHT+"Navigated back to previous page"+concol.RESET);
	}

	public void beforeNavigateForward(WebDriver driver) {
		System.out.println(concol.PURPLE_BOLD_BRIGHT+"Navigating forward to next page"+concol.RESET);
	}

	public void afterNavigateForward(WebDriver driver) {
		System.out.println(concol.PURPLE_BOLD_BRIGHT+"Navigated forward to next page"+concol.RESET);
	}

	public void onException(Throwable error, WebDriver driver) {
		System.out.println(concol.RED_BOLD_BRIGHT+"Exception occured: " + error+concol.RESET);
		try {
			Test_Utilities_File.takeScreenshotAtEndOfTest();
			System.out.println(concol.RED_BOLD_BRIGHT+"Took Screenshot of error  "+concol.RESET);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void MovetoElement(By by, WebElement element, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		System.out.println(concol.PURPLE_BOLD_BRIGHT+"Trying to find Element By : " + by.toString()+concol.RESET);
	}


	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		System.out.println(concol.PURPLE_BOLD_BRIGHT+"Trying to find Element By : " + by.toString()+concol.RESET);
	}

	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		System.out.println(concol.PURPLE_BOLD_BRIGHT+"Found Element By : " + by.toString()+concol.RESET);
	}

	/*
	 * non overridden methods of WebListener class
	 */
	public void beforeScript(String script, WebDriver driver) {
	}

	public void afterScript(String script, WebDriver driver) {
	}

	public void beforeAlertAccept(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void afterAlertAccept(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void afterAlertDismiss(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void beforeAlertDismiss(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void beforeNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void afterNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		// TODO Auto-generated method stub

	}

	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		// TODO Auto-generated method stub

	}

	public <X> void afterGetScreenshotAs(OutputType<X> arg0, X arg1) {
		// TODO Auto-generated method stub
		
	}

	public void afterGetText(WebElement arg0, WebDriver arg1, String arg2) {
		// TODO Auto-generated method stub
		
	}

	public void afterSwitchToWindow(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	public <X> void beforeGetScreenshotAs(OutputType<X> arg0) {
		// TODO Auto-generated method stub
		
	}

	public void beforeGetText(WebElement arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	public void beforeSwitchToWindow(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}
	public void MoveToElemet(String windowName, WebDriver driver) {
		 /**
		   * This action will be performed each time after  {@link org.openqa.selenium.WebDriver.TargetLocator#window(java.lang.String)}
		   *
		   * @param driver WebDriver
		   */

	}
	

}
