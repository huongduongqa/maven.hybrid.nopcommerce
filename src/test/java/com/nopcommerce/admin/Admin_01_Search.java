package com.nopcommerce.admin;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import pageObjects.admin.AdminHomePageObject;
import pageObjects.admin.AdminLoginPageObject;
import pageObjects.admin.AdminSearchPageObject;
import pageObjects.admin.PageGeneratorManager;
import variables.GlobalConstants;

@Epic("Regression Test")
@Feature("Admin Search")
public class Admin_01_Search extends BaseTest {
	
	@Parameters({"browser", "userType"})
	@BeforeClass
	public void beforeClass(String browserName, String userType) {
		driver = getBrowserDriver(browserName, userType);
		adminLoginPage = PageGeneratorManager.getAdminLoginPageObject(driver);
		adminHomePage =	adminLoginPage.loginIntoAdminPage(driver, GlobalConstants.ADMIN_EMAIL,GlobalConstants.ADMIN_PASSWORD);
		adminHomePage.clickToCatalogMenu(driver);
		adminSearchPage = adminHomePage.clickToProductsMenu(driver);
		
		productCategory = "";
		
	}
	
	@Description("Search with empty data")
	@Test
	public void Admin_Search_01_By_Product_Name() {
		productName ="Lenovo IdeaCentre 600 All-in-One PC";
		adminSearchPage.inputToProductNameTextBox(productName);
		adminSearchPage.clickToSearchButton();
		Assert.assertEquals(adminSearchPage.getNumberRecordFound(), 1);
		Assert.assertEquals(adminSearchPage.getProductNameFound(), productName);
		Assert.assertEquals(adminSearchPage.getProductSKUFound(), "LE_IC_600");
		Assert.assertEquals(adminSearchPage.getProductPriceFound(), "500");
		Assert.assertEquals(adminSearchPage.getProductStockQuantityFound(), productName);
		Assert.assertEquals(adminSearchPage.getProductPublishedStatus(), "");
	}
	
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		driver.quit();
	}
	
	WebDriver driver;
	String productName,productCategory;
	AdminLoginPageObject adminLoginPage;
	AdminHomePageObject adminHomePage;
	AdminSearchPageObject adminSearchPage;
}
