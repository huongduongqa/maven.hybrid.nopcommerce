package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.common.Common_01_Register_User;

import commons.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import pageObjects.user.HomePageObject;
import pageObjects.user.LoginPageObject;
import pageObjects.user.PageGeneratorManager;

@Epic("Regression Test")
@Feature("Login with Normal User")
public class User_02_Login extends BaseTest {
	
	@Parameters({"browser", "userType"})
	@BeforeClass
	public void beforeClass(String browserName, String userType) {
		driver = getBrowserDriver(browserName, userType);
		email = Common_01_Register_User.email;
		validPassword = Common_01_Register_User.validPassword; 
		homePage = PageGeneratorManager.getHomePage(driver);
	}
	
	@Story("Login with Normal User")
	@Description("Login with empty data")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void Login_01_Empty_Data() {
		loginPage = homePage.clickToLoginLink();
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Please enter your email");
	}
	
	@Story("Login with Normal User")
	@Description("Login with invalid email")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void Login_02_Invalid_Email() {
		loginPage.inputToEmailTextbox("abc");
		loginPage.inputToPasswordTextbox(validPassword);
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Wrong email");
	}
	
	@Story("Login with Normal User")
	@Description("Login with not-existing email")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void Login_03_Not_Existing_Email() {
		loginPage.inputToEmailTextbox("nguyenanh@gmail.com");
		loginPage.inputToPasswordTextbox(validPassword);
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getUnsuccessfulErrorMessage(), "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
	}
	
	@Story("Login with Normal User")
	@Description("Login with valid email and blank password")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void Login_04_Blank_Password() {
		loginPage.inputToEmailTextbox(email);
		loginPage.inputToPasswordTextbox("");
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getUnsuccessfulErrorMessage(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}

	@Story("Login with Normal User")
	@Description("Login with valid email and wrong password")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void Login_05_Wrong_Password() {
		loginPage.inputToEmailTextbox(email);
		loginPage.inputToPasswordTextbox("wrong_pass");
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getUnsuccessfulErrorMessage(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}
	
	@Story("Login with Normal User")
	@Description("Login successfully with correct email and password")
	@Severity(SeverityLevel.CRITICAL)
	@Test
	public void Login_06_Correct_Account() throws InterruptedException {
		loginPage.inputToEmailTextbox(email);
		loginPage.inputToPasswordTextbox(validPassword);
		homePage = loginPage.clickToLoginButton();	
		Assert.assertTrue(homePage.IsMyAccountLinkDisplayed());
		Assert.assertTrue(homePage.IsLogoutLinkDisplayed());
	}
	
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		driver.quit();
	}
	
	private WebDriver driver;
	private String email, validPassword;
	private HomePageObject homePage;
	LoginPageObject loginPage;
}
