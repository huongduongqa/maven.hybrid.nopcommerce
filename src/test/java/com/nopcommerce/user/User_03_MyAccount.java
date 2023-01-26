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
import pageObjects.user.AddressPageObject;
import pageObjects.user.CategoryPageObject;
import pageObjects.user.ChangePasswordPageObject;
import pageObjects.user.CustomerInfoPageObject;
import pageObjects.user.HomePageObject;
import pageObjects.user.LoginPageObject;
import pageObjects.user.MyProductReviewPageObject;
import pageObjects.user.PageGeneratorManager;
import pageObjects.user.ProductPageObject;
import pageObjects.user.ProductReviewPageObject;

@Epic("Regression Test")
@Feature("My Account")
public class User_03_MyAccount extends BaseTest {
	
	@Parameters({"browser", "userType"})
	@BeforeClass
	public void beforeClass(String browserName, String userType) {
		driver = getBrowserDriver(browserName, userType);
		
		email = Common_01_Register_User.email;
		password = Common_01_Register_User.validPassword; 
		homePage = PageGeneratorManager.getHomePage(driver);
		loggedCookies =Common_01_Register_User.loggedCookies;			
		homePage.setCookies(driver, loggedCookies);
		customerInfoPage = homePage.clickToMyAccountLink(driver);	
		
		dataHelper = new DataHelper();
		newGender = 'F';
		newFirstName = "Huong";
		newLastName = "Duong";
		newEmail = dataHelper.getEmail();
		newDate = "12";
		newMonth="September";
		newYear = "1990";
		newCompanyName = "Quality Assurance";
		newPassword = dataHelper.getPassword();
		
		country = "United States";
		state = "Alabama";
		city = dataHelper.getCity();
		address_01 = dataHelper.getAddress();
		address_02 = dataHelper.getAddress();
		zipCode = dataHelper.getZipCode();
		phoneNumber = dataHelper.getPhoneNumber();
		faxNumber = dataHelper.getFaxNumber();
		
		categoryMainMenuName ="Electronics ";
		categorySubMenuName ="Cell phones ";
		productName ="HTC One Mini Blue";
		productReviewTitle = "Caption of Review by Huong Duong";
		productReviewContent = "Content of Review by Huong Duong";
	}
	
	@Description("Update successfully Customer Information")
	@Test
	public void MyAccoun_01_Update_Customer_Information() {
		customerInfoPage.clickToGenderRadioButton(newGender);
		customerInfoPage.inputToFirstnameTextbox(newFirstName);
		customerInfoPage.inputToLastnameTextbox(newLastName);
		customerInfoPage.selectDateComboxboxByText(newDate);
		customerInfoPage.selectMonthComboxboxByText(newMonth);
		customerInfoPage.selectYearComboxboxByText(newYear);
		customerInfoPage.inputEmailToTextbox(newEmail);
		customerInfoPage.inputToCompanyNameTextbox(newCompanyName);
		customerInfoPage.clickToSaveButton();
		
		homePage = customerInfoPage.clickToLogoutLink(driver);
		loginPage = homePage.clickToLoginLink();
		homePage = loginPage.login(newEmail, password);
		
		customerInfoPage =  homePage.clickToMyAccountLink(driver);
		
		Assert.assertEquals(customerInfoPage.getSelectedGender(),newGender);
		Assert.assertEquals(customerInfoPage.getTextInFirstnameTextbox(), newFirstName);
		Assert.assertEquals(customerInfoPage.getTextInLastnameTextbox(), newLastName);
		Assert.assertEquals(customerInfoPage.getSelectedItemInDateCombobox(), newDate);
		Assert.assertEquals(customerInfoPage.getSelectedItemInMonthCombobox(), newMonth);
		Assert.assertEquals(customerInfoPage.getSelectedItemInYearCombobox(), newYear);
		Assert.assertEquals(customerInfoPage.getTextInEmailTextbox(), newEmail);
		Assert.assertEquals(customerInfoPage.getTextInCompanyNameTextbox(), newCompanyName);
	}
	
	@Description("Add successfully an address to Customer Account")
	@Test
	public void MyAccoun_02_Add_Address() {
		addressPage = customerInfoPage.clickToAddressesLink(driver);
		addressPage.cickToAddNewButton();
		addressPage.inputToFirstNameTextbox(newFirstName);
		addressPage.inputToLastNameTextbox(newLastName);
		addressPage.inputToEmailTextbox(newEmail);
		addressPage.inputToCompanyTextbox(newCompanyName);
		addressPage.selectCountryCombobox(country);
		addressPage.selectStateProvine(state);
		addressPage.inputToCityTextbox(city);
		addressPage.inputToAddress1Textbox(address_01);
		addressPage.inputToAddress2Textbox(address_02);
		addressPage.inputToZipCodeTextbox(zipCode);
		addressPage.inputToPhoneNumberTextbox(phoneNumber);
		addressPage.inputToFaxNumberTextbox(faxNumber);
		addressPage.clickToSaveButton();
		
		Assert.assertEquals(addressPage.getAddressTitle(),newFirstName +" "+ newLastName);
		Assert.assertEquals(addressPage.getAddressName(),newFirstName +" "+ newLastName);
		Assert.assertEquals(addressPage.getAddressEmail(),"Email: " + newEmail);
		Assert.assertEquals(addressPage.getAddressPhone(),"Phone number: "+ phoneNumber);
		Assert.assertEquals(addressPage.getAddressFax(),"Fax number: " + faxNumber);
		Assert.assertEquals(addressPage.getAddressCompany(),newCompanyName);	
		Assert.assertEquals(addressPage.getAddressAddress1(),address_01);
		Assert.assertEquals(addressPage.getAddressAddress2(),address_02); 
		Assert.assertEquals(addressPage.getAddressCity_State_ZipCode(), city + ", " + state + ", " +zipCode);
		Assert.assertEquals(addressPage.getCountry(),country);
	}
	
	@Description("Chang password sucessfully")
	@Test
	public void MyAccoun_03_Change_Password() {
		changePasswordPage = customerInfoPage.clickToChangePasswordLink(driver);
		changePasswordPage.inputToOldPasswordTextbox(password);
		changePasswordPage.inputToNewPasswordTextbox(newPassword);
		changePasswordPage.inputToConfirmPasswordTextbox(newPassword);
		changePasswordPage.clickToChangePasswordButton();
		Assert.assertEquals(changePasswordPage.getBarNotificationText(), "Password was changed");
		changePasswordPage.clickToBarNotificationCloseIcon();
//		homePage = changePasswordPage.clickToLogoutLink(driver);
//		loginPage =	homePage.clickToLoginLink();
//		homePage = loginPage.login(email, newPassword);
//		Assert.assertTrue(homePage.IsMyAccountLinkDisplayed());
//		Assert.assertTrue(homePage.IsLogoutLinkDisplayed());
//		homePage.clickToLogoutLink(driver);
//		loginPage = homePage.clickToLoginLink();
//		homePage = loginPage.login(email, password);
//		Assert.assertEquals(loginPage.getUnsuccessfulErrorMessage(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}
	
	@Description("Add review to a product")
	@Test
	public void MyAccoun_04_Review_Product() {
		myProductReviewPage = changePasswordPage.clickToMyProductReviewLink(driver);
		myProductReviewPage.moveMouseToCategoryMainMenuLink(driver, categoryMainMenuName);
		categoryPage = myProductReviewPage.clickCategorySubMenuLink(driver, categorySubMenuName);
		productPage = categoryPage.clickToProductNameLink(driver, productName);
		productReviewPage = productPage.clickToAddYourReviewLink();
		productReviewPage.inputToReviewTitleTextbox(productReviewTitle);
		productReviewPage.inputToReviewTextTextbox (productReviewContent);
		productReviewPage.clickToSubmitReviewButton();
		customerInfoPage = productReviewPage.clickToMyAccountLink(driver);
		myProductReviewPage = customerInfoPage.clickToMyProductReviewLink(driver);
		Assert.assertEquals(myProductReviewPage.getReviewTitleText(), productReviewTitle);
		Assert.assertEquals(myProductReviewPage.getReviewContentText(), productReviewContent);
		Assert.assertEquals(myProductReviewPage.getTitleInfoText(),"Product review for: " + productName + "" );
	}
	
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		driver.quit();
	}
	
	private WebDriver driver;
	String email, password,newPassword;
	String newFirstName, newLastName, newEmail, newCompanyName, newDate, newMonth, newYear;
	String country, state, city, address_01, address_02, zipCode, phoneNumber, faxNumber;
	String categoryMainMenuName,categorySubMenuName, productName, productReviewTitle, productReviewContent;
	char newGender;
	DataHelper dataHelper;
	Set<Cookie> loggedCookies;
	private HomePageObject homePage;
	private LoginPageObject loginPage;
	private CustomerInfoPageObject customerInfoPage;	
	private AddressPageObject addressPage;
	private ChangePasswordPageObject changePasswordPage;
	private MyProductReviewPageObject myProductReviewPage;
	private ProductPageObject productPage;
	private CategoryPageObject categoryPage;
	private ProductReviewPageObject productReviewPage;
}
