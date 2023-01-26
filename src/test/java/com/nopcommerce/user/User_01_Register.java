package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.data.DataHelper;

import commons.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import pageObjects.user.HomePageObject;
import pageObjects.user.PageGeneratorManager;
import pageObjects.user.RegisterPageObject;

@Epic("Regression Test")
@Feature("Register with Normal User")
public class User_01_Register extends BaseTest {
	
	@Parameters({"browser", "userType"})
	@BeforeClass
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
	}
	
	@Story("Register with Normal User")
	@Description("Warning message to register with empty form")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void Register_01_Empty_Data() {
		registerPage = homePage.openRegisterPage();
		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getRegisterRequiredFieldsMessage("FirstName-error"),"First name is required.");
		Assert.assertEquals(registerPage.getRegisterRequiredFieldsMessage("LastName-error"),"Last name is required.");
		Assert.assertEquals(registerPage.getRegisterRequiredFieldsMessage("Email-error"),"Email is required.");
		Assert.assertEquals(registerPage.getRegisterRequiredFieldsMessage("Password-error"),"Password is required.");
		Assert.assertEquals(registerPage.getRegisterRequiredFieldsMessage("ConfirmPassword-error"),"Password is required.");
	}
	
	@Story("Register with Normal User")
	@Description("Invalid email warning message")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void Register_02_Invalid_Email() {
		registerPage.clickToRadioByLabel(gender);
		registerPage.inputToFirstnameTextbox(firstname);
		registerPage.inputToLastnameTextbox(lastname);
		registerPage.selectDateComboxboxByText(date);
		registerPage.selectMonthComboxboxByText(month);
		registerPage.selectYearComboxboxByText(year);
		registerPage.inputEmailToTextbox("invalid_email@@gmail.com");
		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getRegisterRequiredFieldsMessage("Email-error"),"Wrong email");
	}
	
	@Story("Register with Normal User")
	@Description("Register successfully with valid information")
	@Severity(SeverityLevel.CRITICAL)
	@Test
	public void Register_03_Valid_Information() {
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
		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(),"Your registration completed");
		
		homePage = registerPage.clickToLogoutLink(driver);
	}
	
	@Story("Register with Normal User")
	@Description("Warning for register with existing email")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void Register_04_Email_Existing() {
		registerPage = homePage.openRegisterPage();
		registerPage.inputToFirstnameTextbox(firstname);
		registerPage.inputToLastnameTextbox(lastname);
		registerPage.inputEmailToTextbox(email);
		registerPage.inputToPasswordTextbox(validPassword);
		registerPage.inputToConfirmPasswordTextbox(validPassword);
		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getErrorExistingEmailMessage(),"The specified email already exists");
	}
	
	@Story("Register with Normal User")
	@Description("Warning when password is less than 6 chars")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void Register_05_Password_Less_Than_6Chars() {
		registerPage.inputToFirstnameTextbox(firstname);
		registerPage.inputToLastnameTextbox(lastname);
		registerPage.inputEmailToTextbox(email);
		registerPage.inputToPasswordTextbox("abc12");
		registerPage.inputToConfirmPasswordTextbox("abc12");
		registerPage.clickToRegisterButton();
		
		Assert.assertEquals(registerPage.getRegisterRequiredFieldsMessage("Password-error"),"Password must meet the following rules:\nmust have at least 6 characters");
	}
	
	@Story("Register with Normal User")
	@Description("Warning when passwords are mismatched")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void Register_06_Mismatched_Password() {
		registerPage.inputToFirstnameTextbox(firstname);
		registerPage.inputToLastnameTextbox(lastname);
		registerPage.inputEmailToTextbox(email);
		registerPage.inputToPasswordTextbox("abc12345");
		registerPage.inputToConfirmPasswordTextbox("abc12357");
		registerPage.clickToRegisterButton();
		
		Assert.assertEquals(registerPage.getRegisterRequiredFieldsMessage("ConfirmPassword-error"),"The password and confirmation password do not match.");
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		//driver.quit();
	}
	
	private WebDriver driver;
	private String firstname, lastname, email, companyName, validPassword;
	private char gender;
	private String date, month, year;
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private DataHelper dataHelper;
}
