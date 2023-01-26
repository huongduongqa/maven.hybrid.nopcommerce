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
import pageObjects.user.CategoryPageObject;
import pageObjects.user.CompareProductListPageObject;
import pageObjects.user.HomePageObject;
import pageObjects.user.PageGeneratorManager;
import pageObjects.user.ProductPageObject;
import pageObjects.user.RecentViewedProductPageObject;
import pageObjects.user.ShoppingCartPageObject;
import pageObjects.user.WishListPageObject;
import pageObjects.user.WishListSharedPageObject;

@Epic("Regression Test")
@Feature("Wishlist - Compare - Recent View")
public class User_06_WishList_Compare_ReviewView extends BaseTest {
	
	@Parameters({"browser", "userType"})
	@BeforeClass
	public void beforeClass(String browserName, String userType) {
		driver = getBrowserDriver(browserName, userType);
		email = Common_01_Register_User.email;
		password = Common_01_Register_User.validPassword;
		firstname = Common_01_Register_User.firstname;
		lastname = Common_01_Register_User.lastname;
		categoryMainMenu ="Computers ";
		categorySubMenu = "Notebooks ";
		
		homePage = PageGeneratorManager.getHomePage(driver);
		loggedCookies =Common_01_Register_User.loggedCookies;			
		homePage.setCookies(driver, loggedCookies);
		
		homePage.moveMouseToCategoryMainMenuLink(driver, categoryMainMenu);
		categoryPage = homePage.clickCategorySubMenuLink(driver, categorySubMenu);
		productPage = categoryPage.clickToProductNameLink(driver, "HP Spectre XT Pro UltraBook");
	}
	
	@Description("Add to wishlist")
	@Test
	public void WishList_01_Add_To_WishList() {
		productPage.clickToWishListButton();
		Assert.assertEquals(productPage.getWishListMessageInBarNotification(), "The product has been added to your wishlist");
		wishListPage = productPage.clickToWishListLink(driver);
		Assert.assertEquals(wishListPage.getProductSKUText(), "HP_SPX_UB");
		Assert.assertEquals(wishListPage.getProductNameText(), "HP Spectre XT Pro UltraBook");
		Assert.assertEquals(wishListPage.getProductPriceText(), "$1,350.00");
		Assert.assertEquals(wishListPage.getProductQtyText(), "1");
		Assert.assertEquals(wishListPage.getProductTotalPriceText(), "$1,350.00");
		wishListSharedPage = wishListPage.clickToWishListForSharingLink();
		Assert.assertEquals(wishListSharedPage.getPageTitleText(), "Wishlist of " + firstname + " " + lastname);
	}
	
	@Description("Add product from wishlist to cart")
	@Test
	public void WishList_02_Add_Product_To_Cart_From_WishList() {
		wishListSharedPage.clickToAddToCartCheckbox();
		shoppingCartPage = wishListSharedPage.clickToAddToCartButton();
		Assert.assertEquals(shoppingCartPage.getProductSKUText(), "HP_SPX_UB");
		Assert.assertEquals(shoppingCartPage.getProductNameText(), "HP Spectre XT Pro UltraBook");
		Assert.assertEquals(shoppingCartPage.getProductPriceText(), "$1,350.00");
		Assert.assertEquals(shoppingCartPage.getProductQtyText(), "1");
		Assert.assertEquals(shoppingCartPage.getProductTotalPriceText(), "$1,350.00");
		
		Assert.assertEquals(shoppingCartPage.getNumberofProductInWishlist(driver),"(1)");
		Assert.assertEquals(shoppingCartPage.getNumberofProductInCart(driver),"(1)");	
	}
	
	@Description("Remove product from Wishlist")
	@Test
	public void WishList_03_Remove_Product_From_WishList() {
		wishListPage = shoppingCartPage.clickToWishListLink(driver);
		wishListPage.clickToRemoveProductButtonIcon();
		Assert.assertEquals(wishListPage.getNoDataMessage(),"The wishlist is empty!");		
	}
	
	@Description("Add product to compare")
	@Test
	public void WishList_04_Add_Product_To_Compare() {
		wishListPage = wishListPage.clickToWishListLink(driver);
		wishListPage.moveMouseToCategoryMainMenuLink(driver, "Electronics ");
		categoryPage = wishListPage.clickCategorySubMenuLink(driver, "Cell phones ");
		categoryPage.clickToAddToCompareListButton("Nokia Lumia 1020");
		Assert.assertEquals(categoryPage.getAddToCompareMessageInBarNotification(), "The product has been added to your product comparison");
		categoryPage.clickToAddToCompareListButton("HTC One Mini Blue");
		Assert.assertEquals(categoryPage.getAddToCompareMessageInBarNotification(), "The product has been added to your product comparison");	
		compareProductListPage = categoryPage.clickToCompareProductListLink(driver);
		Assert.assertTrue(compareProductListPage.isRemovedButtonDisplayed("HTC One Mini Blue"));
		Assert.assertTrue(compareProductListPage.isProductNameDisplayed("HTC One Mini Blue"));
		Assert.assertEquals(compareProductListPage.getProductPrice("HTC One Mini Blue"),"$100.00");
		Assert.assertTrue(compareProductListPage.isRemovedButtonDisplayed("Nokia Lumia 1020"));
		Assert.assertTrue(compareProductListPage.isProductNameDisplayed("Nokia Lumia 1020"));
		Assert.assertEquals(compareProductListPage.getProductPrice("Nokia Lumia 1020"),"$349.00");
		Assert.assertTrue(compareProductListPage.isClearListButtonDisplayed());
		
		compareProductListPage.clickToClearListButton();
		Assert.assertEquals(compareProductListPage.getNoDataMessage(),"You have no items to compare.");
		Assert.assertFalse(compareProductListPage.isProductNotDisplayed());
	}
	
	@Description("View Details of Product then check in Recent View")
	@Test
	public void WishList_05_View_Product_Details() {	
		categoryPage = compareProductListPage.goToCategoryPage(driver,"Computers ","Notebooks ");
		productPage = categoryPage.clickToProductNameLink(driver, "Apple MacBook Pro 13-inch");
		
		categoryPage = productPage.goToCategoryPage(driver,"Computers ","Notebooks ");
		productPage = categoryPage.clickToProductNameLink(driver, "Asus N551JK-XO076H Laptop");
		
		categoryPage = productPage.goToCategoryPage(driver,"Computers ","Notebooks ");
		productPage = categoryPage.clickToProductNameLink(driver, "HP Envy 6-1180ca 15.6-Inch Sleekbook");
		
		categoryPage = productPage.goToCategoryPage(driver,"Computers ","Notebooks ");
		productPage = categoryPage.clickToProductNameLink(driver, "Lenovo Thinkpad X1 Carbon Laptop");
		
		categoryPage = productPage.goToCategoryPage(driver,"Computers ","Notebooks ");
		productPage = categoryPage.clickToProductNameLink(driver, "Samsung Series 9 NP900X4C Premium Ultrabook");
		
		recentViewedProductPage= productPage.clickToRecentViewedProductLink(driver);
		Assert.assertTrue(recentViewedProductPage.isLastThreeProductsViewedDisplayed());
		Assert.assertTrue(recentViewedProductPage.IsThisProductDisplayed("HP Envy 6-1180ca 15.6-Inch Sleekbook"));
		Assert.assertTrue(recentViewedProductPage.IsThisProductDisplayed("Lenovo Thinkpad X1 Carbon Laptop"));
		Assert.assertTrue(recentViewedProductPage.IsThisProductDisplayed("Samsung Series 9 NP900X4C Premium Ultrabook"));
	}
	
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		driver.quit();
	}
	
	private WebDriver driver;
	String email, password,firstname, lastname, categoryMainMenu, categorySubMenu;
	Set<Cookie> loggedCookies;
	private HomePageObject homePage;
	private CategoryPageObject categoryPage;
	private ProductPageObject productPage;
	WishListPageObject wishListPage;
	WishListSharedPageObject wishListSharedPage;
	ShoppingCartPageObject shoppingCartPage;
	CompareProductListPageObject compareProductListPage;
	RecentViewedProductPageObject recentViewedProductPage;
}
