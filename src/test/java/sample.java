import java.util.Calendar;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.zyto.test.ConsoleColors.Console_Colors;
import com.zyto.test.ReportListeners.ExtentReportListener;
import com.zyto.test.UtilTestCases.RegistrationProcess;
import com.zyto.test.base.ZytoBase;
import com.zyto.test.pages.Introduction_Page;
import com.zyto.test.pages.Login_Page;
import com.zyto.test.pages.Payment_Method_Page;
import com.zyto.test.pages.Product_Company_Selection_Page;
import com.zyto.test.pages.Signup_Options_page;
import com.zyto.test.pages.User_Agreement_Page;
import com.zyto.test.util.java.ConstantKeywords;
import com.zyto.test.util.java.ElementLocatorUtils;
import com.zyto.test.util.java.JavascriptUtil;

public class sample extends ZytoBase {

	/*
	 * @FindBy(xpath="//div[@class='profile-container']//div[3]//div") static
	 * WebElement Clientlist;
	 * 
	 * @FindBy(
	 * xpath="//div[@class='d-flex align-items-centerd-flex align-items-center justify-content-between mb-4']//a[1]//img[1]"
	 * ) static WebElement filter_button;
	 * 
	 * @FindBy(xpath="//mat-slide-toggle[@id='mat-slide-toggle-1']") static
	 * WebElement PrivacyMode;
	 */

	// Pages to Used //
	ZytoBase zytobase;
	Console_Colors concol;
	Introduction_Page intropage;
	ConstantKeywords ConstKeys;
	static ElementLocatorUtils el;
	JavascriptUtil jl;
	User_Agreement_Page uap;
	RegistrationProcess rp;
	Signup_Options_page signuppage;
	Product_Company_Selection_Page pcsp;
	Payment_Method_Page pmp;
	ExtentReportListener ext;
	Login_Page login;

	public sample() {
		super();
	}

	// Init()
	@BeforeMethod
	public void SetUp() throws InterruptedException {
		zytobase = new ZytoBase();
		prop = zytobase.init_prop();
		driver = zytobase.init_driver(prop);
		zytobase.EventFire();
		driver.get("https://test-insights.zyto.com");
		driver.manage().window().maximize();
		Thread.sleep(10000);
		long waitTime = 10;
		WebDriverWait wait = new WebDriverWait(driver, waitTime);
		intropage = new Introduction_Page(driver);
		jl = new JavascriptUtil(driver);
		uap = new User_Agreement_Page(driver);
		rp = new RegistrationProcess(driver);
		signuppage = new Signup_Options_page(driver);
		pcsp = new Product_Company_Selection_Page(driver);
		pmp = new Payment_Method_Page(driver);
		ext = new ExtentReportListener();
		concol = new Console_Colors();
		login = new Login_Page(driver);
	}

	@Test
	public void invisibility() throws InterruptedException {
		Thread.sleep(10000);

		login.Login_Email_Input("rick@grims.com");
		Thread.sleep(3000);

		login.Login_Password_Input("Password@1");
		Thread.sleep(3000);

		login.Sigin_button_Click();
		Thread.sleep(30000);
		
		
		

		WebElement Clientlist = driver.findElement(By.xpath("//div[@class='profile-container']//div[3]//div"));
		WebElement filter_button = driver.findElement(By.xpath(
				"//div[@class='d-flex align-items-centerd-flex align-items-center justify-content-between mb-4']//a[1]//img[1]"));

		try {
			Clientlist.isDisplayed();
			System.out.println(Clientlist.getText());
		} catch (NoSuchElementException ignored) {
			Assert.fail();
		} catch (StaleElementReferenceException ignored) {
			Assert.fail();
		}

		filter_button.click();
		Thread.sleep(5000);

		WebElement PrivacyMode = driver.findElement(By.xpath("//mat-slide-toggle[@id='mat-slide-toggle-1']"));
		PrivacyMode.click();
		Thread.sleep(5000);

		try {
			Clientlist.isDisplayed();
			Assert.fail();
		} catch (NoSuchElementException ignored) {

		} catch (StaleElementReferenceException ignored) {

		}

	}

	@SuppressWarnings("static-access")
	@Test
	public  void bgcolor() throws InterruptedException {
		Thread.sleep(10000);

		login.Login_Email_Input("rick@grims.com");
		Thread.sleep(3000);

		login.Login_Password_Input("Password@1");
		Thread.sleep(3000);

		login.Sigin_button_Click();
		Thread.sleep(30000);

		WebElement Clientlist = driver.findElement(By.xpath("//div[@class='profile-container']//div[3]//div"));
		WebElement filter_button = driver.findElement(By.xpath(
				"//div[@class='d-flex align-items-centerd-flex align-items-center justify-content-between mb-4']//a[1]//img[1]"));

		filter_button.click();
		Thread.sleep(5000);

		if (!(Clientlist.getSize().equals(null))) {
		}

		WebElement localclient = driver.findElement(By.xpath("//mat-slide-toggle[@id='mat-slide-toggle-2']"));

		localclient.click();
		Thread.sleep(5000);

		String actualcolor = Clientlist.getCssValue("border");

		System.out.println(actualcolor);

		String expcolor = "rgb(213, 213, 213)";

		Assert.assertEquals(actualcolor, expcolor);

	}

	@Test
	public void date_picker() throws InterruptedException {
		
		WebElement SelectDate = driver.findElement((By.xpath("//button[@class='btn btn-calendar']//i")));
		WebElement Previous =  driver.findElement(By.xpath("//bs-days-calendar-view[@class='ng-tns-c16-3 bs-datepicker-multiple ng-star-inserted'][1]//div[1]//button[@class='previous']"));
		WebElement Next =  driver.findElement(By.xpath("//bs-days-calendar-view[@class='ng-tns-c16-3 bs-datepicker-multiple ng-star-inserted'][2]//div[1]//button[@class='next']"));
		WebElement month1 =  driver.findElement(By.xpath("//bs-days-calendar-view[@class='ng-tns-c16-3 bs-datepicker-multiple ng-star-inserted'][1]//div[1]//button[@class='current ng-star-inserted']"));
		WebElement month2 = driver.findElement(By.xpath("//bs-days-calendar-view[@class='ng-tns-c16-3 bs-datepicker-multiple ng-star-inserted'][2]//div[1]//button[@class='current ng-star-inserted']"));
		WebElement Year =  driver.findElement(By.xpath("//bs-days-calendar-view[@class='ng-tns-c13-2 bs-datepicker-multiple ng-star-inserted'][1]//div[@class='bs-datepicker-head']//button[@class='current']"));
		List<WebElement> days1 = driver.findElements(By.xpath("//bs-days-calendar-view[@class='ng-tns-c13-2 bs-datepicker-multiple ng-star-inserted'][1]//div[@class='bs-datepicker-body']//table//tbody//tr//td"));
		List<WebElement>  days2 =  driver.findElements(By.xpath("//bs-days-calendar-view[@class='ng-tns-c13-2 bs-datepicker-multiple ng-star-inserted'][2]//div[@class='bs-datepicker-body']//table//tbody//tr//td"));
		List<WebElement> monthslist1 = driver.findElements(By.xpath("//bs-month-calendar-view[@class='ng-tns-c13-2 bs-datepicker-multiple ng-star-inserted'][1]//tr//td"));
		List<WebElement> monthslist2 =  driver.findElements(By.xpath("//bs-month-calendar-view[@class='ng-tns-c13-2 bs-datepicker-multiple ng-star-inserted'][2]//tr//td"));
		
		

		// Date and Time to be set in textbox

		int DT =  Calendar.DATE; //20-03-1994 20:33:13
		
		String dateTime = Integer.toString(DT);

		// button to open calendar

		SelectDate.click();

		// button to move next in calendar
		WebElement nextLink = Next;

		// button to click in center of calendar header
		WebElement yearlink = Year;

		// button to move previous month in calendar
		WebElement previousLink = Previous;

		// Split the date time to get only the date part
		String date_dd_MM_yyyy[] = (dateTime.split(" ")[0]).split("-");
		

		// get the year difference between current year and year to set in calendar
		int yearDiff = Integer.parseInt(date_dd_MM_yyyy[2]) - Calendar.getInstance().get(Calendar.YEAR);
		yearlink.click();
//if(year=! 2021){

		if (yearDiff != 0) {
			// if you have to move next year
			if (yearDiff > 0) {
				for (int i = 0; i < yearDiff; i++) {
					System.out.println("Year Diff->" + i);
					nextLink.click();
				}
			}
			// if you have to move previous year
			else if (yearDiff < 0) {
				for (int i = 0; i < (yearDiff * (-1)); i++) {
					System.out.println("Year Diff->" + i);
					previousLink.click();
				}
			}
		}
		Thread.sleep(1000);
		// Get all months from calendar to select correct one
		List<WebElement> list_AllMonthToBook = monthslist1;
		list_AllMonthToBook.get(Integer.parseInt(date_dd_MM_yyyy[1]) - 1).click();

		Thread.sleep(1000);

		// get all dates from calendar to select correct one
		List<WebElement> list_AllDateToBook = days1;
		list_AllDateToBook.get(Integer.parseInt(date_dd_MM_yyyy[0]) - 1).click();
	}



	@AfterMethod
	public void EndTest() {
		System.out.println(concol.BLUE_BOLD_BRIGHT + "****Quitting the browser****" + concol.RESET);
		driver.quit();
	}

}
