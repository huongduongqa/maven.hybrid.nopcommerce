package com.nopcommerce.user;

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
import pageObjects.user.CategoryPageObject;
import pageObjects.user.HomePageObject;
import pageObjects.user.PageGeneratorManager;

@Epic("Regression Test")
@Feature("Sort-Display-Paging")
public class User_05_Sort extends BaseTest {
	
	@Parameters({"browser", "userType"})
	@BeforeClass
	public void beforeClass(String browserName, String userType) {
		driver = getBrowserDriver(browserName, userType);
		
		homePage = PageGeneratorManager.getHomePage(driver);
		categoryMainMenu ="Computers ";
		categorySubMenu = "Notebooks ";
		homePage.moveMouseToCategoryMainMenuLink(driver, categoryMainMenu);
		categoryPage = homePage.clickCategorySubMenuLink(driver, categorySubMenu);
	}
	
	@Description("Sort with name ascending: A to Z")
	@Test
	public void Sort_01_Name_A_To_Z() {
		categoryPage.SelectSortByComboboxByText("Name: A to Z");
		Assert.assertTrue(categoryPage.isProductNameSortedByAscending());
	}
	
	@Description("Sort with name descending: Z to A")
	@Test
	public void Sort_02_Name_Z_To_A() {
		categoryPage.SelectSortByComboboxByText("Name: Z to A");
		Assert.assertTrue(categoryPage.isProductNameSortedByDescending());
	}
	
	@Description("Sort with price: low to high")
	@Test
	public void Sort_03_Price_Low_To_High() {
		categoryPage.SelectSortByComboboxByText("Price: Low to High");
		Assert.assertTrue(categoryPage.isProductPriceSortedLowToHigh());
	}
	
	@Description("Sort with price: high to low")
	@Test
	public void Sort_04_Price_High_To_Low() {
		categoryPage.SelectSortByComboboxByText("Price: High to Low");
		Assert.assertTrue(categoryPage.isProductPriceSortedHighToLow());
	}
	
	@Description("Display 3 products per page")
	@Test
	public void Sort_05_Paging_3_Product() {
		categoryPage.SelectDisplayNumberOfProductPerPage("3");
		Assert.assertEquals(categoryPage.getNumberOfRecord(3), true);
		categoryPage.clickToIndividualPage();
		Assert.assertTrue(categoryPage.isPreviousPagingDisplayed());
		categoryPage.clickToIndividualPage();
		Assert.assertTrue(categoryPage.isNextPagingDisplayed());
	}
	
	@Description("Display 6 products per page")
	@Test
	public void Sort_06_Paging_6_Product() {
		categoryPage.SelectDisplayNumberOfProductPerPage("6");
		Assert.assertEquals(categoryPage.getNumberOfRecord(6), true);
		Assert.assertFalse(categoryPage.isPagingUndisplayed());
	}
	
	@Description("Display 6 products per page")
	@Test
	public void Sort_07_Paging_9_Product() {
		categoryPage.SelectDisplayNumberOfProductPerPage("9");
		Assert.assertEquals(categoryPage.getNumberOfRecord(9), true);
		Assert.assertFalse(categoryPage.isPagingUndisplayed());
	}
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		driver.quit();
	}
	
	private WebDriver driver;
	String categoryMainMenu, categorySubMenu;
	private HomePageObject homePage;
	private CategoryPageObject categoryPage;
}
