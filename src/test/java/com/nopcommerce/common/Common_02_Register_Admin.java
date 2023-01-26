package com.nopcommerce.common;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import commons.BaseTest;
import pageObjects.admin.AdminHomePageObject;
import pageObjects.admin.AdminLoginPageObject;
import pageObjects.admin.PageGeneratorManager;
import variables.GlobalConstants;

public class Common_02_Register_Admin extends BaseTest {
	
	@Parameters({"browser", "userType"})
	@BeforeTest
	public void beforeTest(String browserName, String userType) {
		driver = getBrowserDriver(browserName, userType);
		adminLoginPage = PageGeneratorManager.getAdminLoginPageObject(driver);
		adminHomePage =	adminLoginPage.loginIntoAdminPage(driver, GlobalConstants.ADMIN_EMAIL,GlobalConstants.ADMIN_PASSWORD);
	}

	@AfterTest(alwaysRun = true)
	public void afterTest() {
		driver.quit();
	}
	
	private WebDriver driver;
	AdminLoginPageObject adminLoginPage;
	AdminHomePageObject adminHomePage;
}
