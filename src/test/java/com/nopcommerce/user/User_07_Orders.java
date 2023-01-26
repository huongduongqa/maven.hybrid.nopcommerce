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
import com.nopcommerce.data.DataHelper;

import commons.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import pageObjects.user.CategoryPageObject;
import pageObjects.user.CheckoutPageObject;
import pageObjects.user.CustomerInfoPageObject;
import pageObjects.user.HomePageObject;
import pageObjects.user.OrdersPageObject;
import pageObjects.user.PageGeneratorManager;
import pageObjects.user.ProductPageObject;
import pageObjects.user.ShoppingCartPageObject;

@Epic("Regression Test")
@Feature("Order Products")
public class User_07_Orders extends BaseTest {
	
	@Parameters({"browser", "userType"})
	@BeforeClass
	public void beforeClass(String browserName, String userType) {
		driver = getBrowserDriver(browserName, userType);
		dataHelper = new DataHelper();
		categoryMainMenu ="Computers ";
		categorySubMenu = "Desktops ";
		productName = "Build your own computer";
		productQty = "2";
		paymentMethod = "Check / Money Order";
		shipmentMethod = "Ground ($0.00)";
		
		email = Common_01_Register_User.email;
		password = Common_01_Register_User.validPassword;
		firstname = Common_01_Register_User.firstname;
		lastname = Common_01_Register_User.lastname;
		companyName = Common_01_Register_User.companyName;
		country = "United States";
		state = "California";
		city = dataHelper.getCity();
		address_01 = dataHelper.getCity();
		zipCode = dataHelper.getZipCode();
		phoneNumber = dataHelper.getPhoneNumber();
		creditCardNumber = dataHelper.getCreditCardNumber();
		expiredMonth = dataHelper.getMonthInNumber();
		expiredYear = dataHelper.getCreditCardExpiredYear();
		securedNumber = dataHelper.getCreditCardSecureCode();
				
		homePage = PageGeneratorManager.getHomePage(driver);
		loggedCookies = Common_01_Register_User.loggedCookies;			
		homePage.setCookies(driver, loggedCookies);
		
		homePage.moveMouseToCategoryMainMenuLink(driver, categoryMainMenu);
		categoryPage = homePage.clickCategorySubMenuLink(driver, categorySubMenu);
		productPage = categoryPage.clickToProductNameLink(driver, productName);
	}
	
	@Description("Add to wishlist")
	@Test
	public void Order_01_Add_Product_To_Cart() {
		String processor ="2.2 GHz Intel Pentium Dual-Core E2200";
		String RAM = "2 GB";
		String HDD ="320 GB";
		String OS = "Vista Home [+$50.00]";
		String Software = "Microsoft Office [+$50.00]";
		String productAtribute = "Processor: "+ processor +"\n" + "RAM: " + RAM +"\n"+ "HDD: " + HDD +"\n" + "OS: " + OS;
		productPage.selectProcessorCombobox(processor);
		productPage.selectRAMCombobox(RAM);
		productPage.SelectHDDRadio(HDD);
		productPage.SelectOSRadio(OS);
		productPage.SelectSoftwareCheckbox(Software);
		productPage.inputToQuantityTextbox("1");
		productPage.clickToAddToCartButton(productName);
		Assert.assertEquals(productPage.getAddToCartSuccesfulMessage(), "The product has been added to your shopping cart");
		shoppingCartPage = productPage.clickToShoppingCartLink(driver);
		Assert.assertEquals(shoppingCartPage.getNumberofProductInCart(driver),"(1)");	
		
		shoppingCartPage.moveMouseToTheCartLink();
		
		Assert.assertEquals(shoppingCartPage.getNumberofProductInMiniCart(),"There are 1 item(s) in your cart.");
		Assert.assertEquals(shoppingCartPage.getProductNameInMiniCart(),productName);
		Assert.assertEquals(shoppingCartPage.getProductAttributesInMiniCart(),productAtribute);
		Assert.assertEquals(shoppingCartPage.getProductUnitPriceInMiniCart(),"Unit price: $1,250.00");
		Assert.assertEquals(shoppingCartPage.getProductQuantityInMiniCart(),"Quantity: 1");
		Assert.assertEquals(shoppingCartPage.getTotalPriceInMiniCart(),"Sub-Total: $1,250.00");
	}
	
	@Description("Edit products in cart")
	@Test
	public void Order_02_Edit_Product_In_Cart() {
		String processor ="2.2 GHz Intel Pentium Dual-Core E2200";
		String RAM = "4GB [+$20.00]";
		String HDD ="320 GB";
		String OS = "Vista Home [+$50.00]";
		String Software = "Microsoft Office [+$50.00]";
		String productAtribute = "Processor: "+ processor +"\n" + "RAM: " + RAM +"\n"+ "HDD: " + HDD +"\n" + "OS: " + OS +"\n" + "Software: " +Software;
		
		productPage = shoppingCartPage.clickToEditLinkByProductName();
		productPage.selectProcessorCombobox(processor);
		productPage.selectRAMCombobox(RAM);
		productPage.SelectHDDRadio(HDD);
		productPage.SelectOSRadio(OS);
		productPage.SelectSoftwareCheckbox(Software);
		Assert.assertEquals(productPage.getProductPrice(), "$1,320.00");
		productPage.inputToQuantityTextbox("2");
		productPage.clickToUpdateButon(productName);
		Assert.assertEquals(productPage.getAddToCartSuccesfulMessage(), "The product has been added to your shopping cart");
		
		shoppingCartPage = productPage.clickToShoppingCartLink(driver);
		shoppingCartPage.moveMouseToTheCartLink();
		
		Assert.assertEquals(shoppingCartPage.getNumberofProductInMiniCart(),"There are 2 item(s) in your cart.");
		Assert.assertEquals(shoppingCartPage.getProductNameInMiniCart(),productName);
		Assert.assertEquals(shoppingCartPage.getProductAttributesInMiniCart(),productAtribute);
		Assert.assertEquals(shoppingCartPage.getProductUnitPriceInMiniCart(),"Unit price: $1,320.00");
		Assert.assertEquals(shoppingCartPage.getProductQuantityInMiniCart(),"Quantity: 2");
		Assert.assertEquals(shoppingCartPage.getTotalPriceInMiniCart(),"Sub-Total: $2,640.00");
	}
	
	@Description("Empty the cart")
	@Test
	public void Order_03_Remove_Product_From_Cart() {
		shoppingCartPage.clickToRemoveButtonByProductName(productName);
		Assert.assertEquals(shoppingCartPage.getNoDataMessage(),"Your Shopping Cart is empty!");
		Assert.assertFalse(shoppingCartPage.isNoProductDisplayed());
	}
	
	@Description("Update the cart")
	@Test
	public void Order_04_Update_The_Cart() {
		shoppingCartPage.clickToWishListLink(driver); 
		productName = "Lenovo IdeaCentre 600 All-in-One PC";
		shoppingCartPage.moveMouseToCategoryMainMenuLink(driver, categoryMainMenu);
		categoryPage = shoppingCartPage.clickCategorySubMenuLink(driver, categorySubMenu);
		productPage = categoryPage.clickToProductNameLink(driver, productName);
		productPage.clickToAddToCartButton(productName);
		shoppingCartPage = productPage.clickToShoppingCartLink(driver);
		shoppingCartPage.inputToProductQuantityTextboxByProductName("5");
		shoppingCartPage.clickToUpdateShoppingCartButton();
		
		Assert.assertEquals(shoppingCartPage.getTotalPriceInTable(),"$2,500.00");
		Assert.assertEquals(shoppingCartPage.getTotalPriceOutTable(),"$2,500.00");
		shoppingCartPage.clickToRemoveButtonByProductName(productName);
		customerInfoPage = shoppingCartPage.clickToMyAccountLink(driver);
	}
	
	@Description("Checkout an order")
	@Test
	public void Order_05_Checkout_Order() {
		
		categorySubMenu = "Notebooks ";
		productName = "Apple MacBook Pro 13-inch";
		
		customerInfoPage.moveMouseToCategoryMainMenuLink(driver, categoryMainMenu);
		categoryPage = customerInfoPage.clickCategorySubMenuLink(driver, categorySubMenu);
		productPage = categoryPage.clickToProductNameLink(driver, productName);
		productPage.inputToQuantityTextbox("2");
		productPrice = productPage.getProductPrice();
		productSKU = productPage.getProductSKU();
		productPage.clickToAddToCartButton(productName);
		shoppingCartPage = productPage.clickToShoppingCartLink(driver);
		shoppingCartPage.selectGiftWrappingCombobox("No");
		shoppingCartPage.checkToTermOfServiceCheckbox();
		checkoutPage = shoppingCartPage.clickToCheckoutButton();
		
		checkoutPage.checkShipToSameAddressCheckbox();
		checkoutPage.inputInfoToBillingAddressForm(firstname, lastname, email, country,state, city, address_01, zipCode, phoneNumber);
		checkoutPage.clickToBillingAddressContinueButton();
		checkoutPage.clickToShippingMethodRadio(shipmentMethod);
		checkoutPage.clickToShippingMethodContinueButton();
		checkoutPage.clickToPaymentMethodRadio(paymentMethod);
		checkoutPage.clickToPaymentMethodContinueButton();
		Assert.assertEquals(checkoutPage.getPaymentInfo(), "NOP SOLUTIONS\nyour address here,\nNew York, NY 10001\nUSA");
		checkoutPage.clickToPaymentInfoContinueButton();
		
		Assert.assertEquals(checkoutPage.getBillingInfoName(),firstname + " " + lastname);
		Assert.assertEquals(checkoutPage.getBillingInfoEmail(),"Email: "+email);
		Assert.assertEquals(checkoutPage.getBillingInfoPhone(),"Phone: "+phoneNumber);
		Assert.assertEquals(checkoutPage.getBillingInfoFax(),"Fax:");
		Assert.assertEquals(checkoutPage.getBillingInfoCompany(),companyName);
		Assert.assertEquals(checkoutPage.getBillingInfoAddress01(),address_01);
		Assert.assertEquals(checkoutPage.getBillingInfoCityStateZip(),city +","+state +","+ zipCode);
		Assert.assertEquals(checkoutPage.getBillingInfoCountry(),country);
		
		Assert.assertEquals(checkoutPage.getShippingInfoName(),firstname + " " + lastname);
		Assert.assertEquals(checkoutPage.getShippingInfoEmail(),"Email: "+email);
		Assert.assertEquals(checkoutPage.getShippingInfoPhone(),"Phone: "+phoneNumber);
		Assert.assertEquals(checkoutPage.getShippingInfoFax(),"Fax:");
		Assert.assertEquals(checkoutPage.getShippingInfoCompany(),companyName);
		Assert.assertEquals(checkoutPage.getShippingInfoAddress01(),address_01);
		Assert.assertEquals(checkoutPage.getShippingInfoCityStateZip(),city +","+state +","+ zipCode);
		Assert.assertEquals(checkoutPage.getShippingInfoCountry(),country);
		
		Assert.assertEquals(checkoutPage.getPaymentMethod(),paymentMethod);
		Assert.assertEquals(checkoutPage.getShippingMethod(),"Ground");
		Assert.assertEquals(checkoutPage.getProductSKU(),productSKU);
		Assert.assertEquals(checkoutPage.getProductName(),productName);
		Assert.assertEquals(checkoutPage.getProductPrice(),productPrice);
		Assert.assertEquals(checkoutPage.getProductQty(),productQty);
		Assert.assertEquals(checkoutPage.getProductTotal(),"$3,600.00");
		
		Assert.assertEquals(checkoutPage.getGiftWrappingInfo(),"Gift wrapping: No");
		Assert.assertEquals(checkoutPage.getCartTotalInfo("Sub-Total:"),"$3,600.00");
		Assert.assertEquals(checkoutPage.getCartTotalInfo("Shipping:"),"$0.00");
		Assert.assertEquals(checkoutPage.getCartTotalInfo("Tax:"),"$0.00");
		Assert.assertEquals(checkoutPage.getCartTotalInfo("Total:"),"$3,600.00");
		
		checkoutPage.clickToConfirmOrderButton();
		Assert.assertEquals(checkoutPage.getPageTitleMessage(),"Checkout");
		Assert.assertEquals(checkoutPage.getSuccesfulMessage(),"Your order has been successfully processed!");
		Assert.assertEquals(checkoutPage.getOrderNumber(),"ORDER NUMBER: 1035");
		
		customerInfoPage = checkoutPage.clickToMyAccountLink(driver);
		ordersPage = customerInfoPage.clickToOrdersLink(driver);
		Assert.assertEquals(ordersPage.getOrderNumber(),"Order Number: 1035");
	}
	
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		//driver.quit();
	}
	
	private WebDriver driver;
	String email, password,firstname, lastname, companyName, country, state, city, address_01, zipCode, phoneNumber, creditCardNumber, expiredMonth, expiredYear, securedNumber;
	String paymentMethod, shipmentMethod;
	String categoryMainMenu, categorySubMenu, productName, productSKU, productPrice, productQty ;
	Set<Cookie> loggedCookies;
	DataHelper dataHelper;
	private HomePageObject homePage;
	private CategoryPageObject categoryPage;
	private ProductPageObject productPage;
	private ShoppingCartPageObject shoppingCartPage;
	private CheckoutPageObject checkoutPage;
	private CustomerInfoPageObject customerInfoPage;
	private OrdersPageObject ordersPage;
}
