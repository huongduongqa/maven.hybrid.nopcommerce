package com.nopcommerce.user;

import java.util.Set;

import org.openqa.selenium.Cookie;
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
import pageObjects.user.HomePageObject;
import pageObjects.user.PageGeneratorManager;
import pageObjects.user.SearchPageObject;

@Epic("Regression Test")
@Feature("Search")
public class User_04_Search extends BaseTest {
	
	@Parameters({"browser", "userType"})
	@BeforeClass
	public void beforeClass(String browserName, String userType) {
		driver = getBrowserDriver(browserName, userType);
		
		email = Common_01_Register_User.email;
		password = Common_01_Register_User.validPassword; 
		homePage = PageGeneratorManager.getHomePage(driver);
		loggedCookies =Common_01_Register_User.loggedCookies;			
		homePage.setCookies(driver, loggedCookies);
	
	}
	
	@Description("Search with empty data")
	@Test
	public void Search_01_Search_Empty_Data() {
		searchPage = homePage.clickToSearchLink(driver);
		searchPage.clickToSearchButton();
		Assert.assertEquals(searchPage.getMessageWithEmptySearch(),"Search term minimum length is 3 characters");
	}
	
	@Description("Search with not existing data")
	@Test
	public void Search_02_Search_Not_Existing_Data() {
		searchPage.inputToSearchTexbox("not existing keyword");
		searchPage.clickToSearchButton();
		Assert.assertEquals(searchPage.getMessageWithEmptySearch(),"No products were found that matched your criteria.");
	}
	
	@Description("Search with relative data")
	@Test
	public void Search_03_Search_Relative_Data() {
		searchPage.inputToSearchTexbox("Lenovo");
		searchPage.clickToSearchButton();
		Assert.assertEquals(searchPage.getNumberOfResult(), 2);
		Assert.assertTrue(searchPage.isProductNameContainedKeyword("Lenovo"));
	}
	
	@Description("Search with obsolute data")
	@Test
	public void Search_04_Search_Obsolute_Data() {
		searchPage.inputToSearchTexbox("ThinkPad X1 Carbon");
		searchPage.clickToSearchButton();
		Assert.assertEquals(searchPage.getNumberOfResult(), 1);
		Assert.assertTrue(searchPage.isProductNameContainedKeyword("Lenovo Thinkpad X1 Carbon Laptop"));
	}
	
	@Description("Advance Search with parent category")
	@Test
	public void Search_05_Advance_Search_Parent_Category() {
		searchPage.inputToSearchTexbox("Apple MacBook Pro");
		searchPage.checkToAdvancedSearchCheckbox();
		searchPage.selectItemInCategoryCombobox("Computers");
		searchPage.clickToSearchButton();
		Assert.assertEquals(searchPage.getMessageWithEmptySearch(),"No products were found that matched your criteria.");
	}
	
	@Description("Advance Search with sub category")
	@Test
	public void Search_06_Advance_Search_Sub_Category() {
		searchPage.inputToSearchTexbox("Apple MacBook Pro");
		searchPage.checkToAdvancedSearchCheckbox();
		searchPage.selectItemInCategoryCombobox("Computers");
		searchPage.checkToAutoSearchSubCategoryCheckbox();
		searchPage.clickToSearchButton();
		Assert.assertEquals(searchPage.getNumberOfResult(), 1);
		Assert.assertTrue(searchPage.isProductNameContainedKeyword("Apple MacBook Pro 13-inch"));
	}
	
	@Description("Advance Search with incorrect manufacturer")
	@Test
	public void Search_07_Advance_Search_Incorrect_Manufacturer() {
		searchPage.inputToSearchTexbox("Apple MacBook Pro");
		searchPage.checkToAdvancedSearchCheckbox();
		searchPage.selectItemInCategoryCombobox("Computers");
		searchPage.checkToAutoSearchSubCategoryCheckbox();
		searchPage.selectItemInManufacturerCombobox("HP");
		searchPage.clickToSearchButton();
		Assert.assertEquals(searchPage.getMessageWithEmptySearch(),"No products were found that matched your criteria.");
	}
	
	@Description("Advance Search with correct manufacturer")
	@Test
	public void Search_08_Advance_Search_Correct_Manufacturer() {
		searchPage.inputToSearchTexbox("Apple MacBook Pro");
		searchPage.checkToAdvancedSearchCheckbox();
		searchPage.selectItemInCategoryCombobox("Computers");
		searchPage.checkToAutoSearchSubCategoryCheckbox();
		searchPage.selectItemInManufacturerCombobox("Apple");
		searchPage.clickToSearchButton();
		Assert.assertEquals(searchPage.getNumberOfResult(), 1);
		Assert.assertTrue(searchPage.isProductNameContainedKeyword("Apple MacBook Pro 13-inch"));
	}
	
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		driver.quit();
	}
	
	private WebDriver driver;
	String email, password;
	Set<Cookie> loggedCookies;
	private HomePageObject homePage;
	private SearchPageObject searchPage;
}
