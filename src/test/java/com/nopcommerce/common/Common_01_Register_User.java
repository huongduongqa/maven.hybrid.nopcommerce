package com.nopcommerce.common;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.nopcommerce.data.DataHelper;

import commons.BaseTest;
import pageObjects.user.HomePageObject;
import pageObjects.user.LoginPageObject;
import pageObjects.user.PageGeneratorManager;
import pageObjects.user.RegisterPageObject;

public class Common_01_Register_User extends BaseTest {
	
	@Parameters({"browser", "userType"})
	@BeforeTest
	public void beforeClass(String browserName, String userType) {
		driver = getBrowserDriver(browserName, userType);
		homePage = PageGeneratorManager.getHomePage(driver);
		
		dataHelper = new DataHelper();
		firstname = dataHelper.getFirstName();
		lastname = dataHelper.getLastName();
		date = dataHelper.getDate();
		month= dataHelper.getMonth();
		year = dataHelper.getYear();
		email = dataHelper.getEmail();
		companyName = dataHelper.getCompanyName();
		validPassword = dataHelper.getPassword();
		gender = dataHelper.getGender();
		
		registerPage = homePage.openRegisterPage();
		registerPage.clickToRadioByLabel(gender);
		registerPage.inputToFirstnameTextbox(firstname);
		registerPage.inputToLastnameTextbox(lastname);
		registerPage.selectDateComboxboxByText(date);
		registerPage.selectMonthComboxboxByText(month);
		registerPage.selectYearComboxboxByText(year);
		registerPage.inputEmailToTextbox(email);
		registerPage.inputToCompanyNameTextbox(companyName);
		registerPage.inputToPasswordTextbox(validPassword);
		registerPage.inputToConfirmPasswordTextbox(validPassword);
		homePage = registerPage.clickToRegisterButton();
		loginPage = homePage.clickToLoginLink();
		homePage = loginPage.login(email, validPassword);
	    
		loggedCookies = driver.manage().getCookies();
		homePage = registerPage.clickToLogoutLink(driver);
	}

	@AfterTest(alwaysRun = true)
	public void afterTest() {
		driver.quit();
	}
	
	private WebDriver driver;
	public static String email, validPassword, firstname, lastname, companyName;
	private String date, month, year;
	private char gender;
	private HomePageObject homePage;
	private LoginPageObject loginPage;
	private RegisterPageObject registerPage;
	private DataHelper dataHelper;
	public static Set<Cookie> loggedCookies;
}
