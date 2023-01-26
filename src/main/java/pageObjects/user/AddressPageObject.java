package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import io.qameta.allure.Step;
import pageUIs.user.AddressPageUI;

public class AddressPageObject extends BasePage {
	
	WebDriver driver;
	
	public AddressPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	@Step("Click to AddNew button")
	public void cickToAddNewButton() {
		waitForElementClickable(driver, AddressPageUI.ADDNEW_BUTTON);
		clickToElement(driver, AddressPageUI.ADDNEW_BUTTON);
	}

	@Step("Input to FirstName textbox with: {0}")
	public void inputToFirstNameTextbox(String newFirstName) {
		waitForElementVisible(driver, AddressPageUI.FIRSTNAME_TEXTBOX);
		sendkeyToElement(driver, AddressPageUI.FIRSTNAME_TEXTBOX, newFirstName);
	}

	@Step("Input to LastName textbox with: {0}")
	public void inputToLastNameTextbox(String newLastName) {
		waitForElementVisible(driver, AddressPageUI.LASTNAME_TEXTBOX);
		sendkeyToElement(driver, AddressPageUI.LASTNAME_TEXTBOX, newLastName);
	}

	@Step("Input to Company Name textbox with: {0}")
	public void inputToCompanyTextbox(String newCompanyName) {
		waitForElementVisible(driver, AddressPageUI.COMPANY_TEXTBOX);
		sendkeyToElement(driver, AddressPageUI.COMPANY_TEXTBOX, newCompanyName);	
	}

	@Step("Input to Email textbox with: {0}")
	public void inputToEmailTextbox(String newEmail) {
		waitForElementVisible(driver, AddressPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, AddressPageUI.EMAIL_TEXTBOX, newEmail);
	}

	@Step("Select an item in Country combobox: {0}")
	public void selectCountryCombobox(String country) {
		waitForElementVisible(driver, AddressPageUI.COUNTRY_COMBOBOX);
		selectItemInDefaultDropdown(driver, AddressPageUI.COUNTRY_COMBOBOX, country);
	}

	@Step("Select an item in State/Provine combobox: {0}")
	public void selectStateProvine(String provine) {
		waitForElementVisible(driver, AddressPageUI.STATE_COMBOBOX);
		selectItemInDefaultDropdown(driver, AddressPageUI.STATE_COMBOBOX, provine);
	}

	@Step("Input to City textbox with: {0}")
	public void inputToCityTextbox(String city) {
		waitForElementVisible(driver, AddressPageUI.CITY_TEXTBOX);
		sendkeyToElement(driver, AddressPageUI.CITY_TEXTBOX, city);
	}

	@Step("Input to Address_01 textbox with: {0}")
	public void inputToAddress1Textbox(String address_01) {
		waitForElementVisible(driver, AddressPageUI.ADDRESS1_TEXTBOX);
		sendkeyToElement(driver, AddressPageUI.ADDRESS1_TEXTBOX, address_01);
	}

	@Step("Input to Address_02 textbox with: {0}")
	public void inputToAddress2Textbox(String address_02) {
		waitForElementVisible(driver, AddressPageUI.ADDRESS2_TEXTBOX);
		sendkeyToElement(driver, AddressPageUI.ADDRESS2_TEXTBOX, address_02);
	}
	
	@Step("Input to ZipCode textbox with: {0}")
	public void inputToZipCodeTextbox(String zipCode) {
		waitForElementVisible(driver, AddressPageUI.ZIPCODE_TEXTBOX);
		sendkeyToElement(driver, AddressPageUI.ZIPCODE_TEXTBOX, zipCode);		
	}

	@Step("Input to PhoneNumber textbox with: {0}")
	public void inputToPhoneNumberTextbox(String phoneNumber) {
		waitForElementVisible(driver, AddressPageUI.PHONE_NUMBER_TEXTBOX);
		sendkeyToElement(driver, AddressPageUI.PHONE_NUMBER_TEXTBOX, phoneNumber);	
	}

	@Step("Input to TaxNumber textbox with: {0}")
	public void inputToFaxNumberTextbox(String faxNumber) {
		waitForElementVisible(driver, AddressPageUI.FAX_NUMBER_TEXTBOX);
		sendkeyToElement(driver, AddressPageUI.FAX_NUMBER_TEXTBOX, faxNumber);
	}

	@Step("Click to Save Button")
	public void clickToSaveButton() {
		waitForElementClickable(driver, AddressPageUI.SAVE_BUTTON);
		clickToElement(driver, AddressPageUI.SAVE_BUTTON);	
	}
	
	public String getAddressTitle() {
		waitForElementVisible(driver, AddressPageUI.ADDRESS_SAVED_TITLE);
		return getElementText(driver, AddressPageUI.ADDRESS_SAVED_TITLE);
	}

	public String getAddressName() {
		waitForElementVisible(driver, AddressPageUI.ADDRESS_SAVED_NAME);
		return getElementText(driver, AddressPageUI.ADDRESS_SAVED_NAME);
	}

	public String getAddressEmail() {
		waitForElementVisible(driver, AddressPageUI.ADDRESS_SAVED_EMAIL);
		return getElementText(driver, AddressPageUI.ADDRESS_SAVED_EMAIL);
	}

	public String getAddressPhone() {
		waitForElementVisible(driver, AddressPageUI.ADDRESS_SAVED_PHONE_NUMBER);
		return getElementText(driver, AddressPageUI.ADDRESS_SAVED_PHONE_NUMBER);
	}

	public Object getAddressFax() {
		waitForElementVisible(driver, AddressPageUI.ADDRESS_SAVED_FAX_NUMBER);
		return getElementText(driver, AddressPageUI.ADDRESS_SAVED_FAX_NUMBER);
	}

	public String getAddressCompany() {
		waitForElementVisible(driver, AddressPageUI.ADDRESS_SAVED_COMPANY_NAME);
		return getElementText(driver, AddressPageUI.ADDRESS_SAVED_COMPANY_NAME);
	}

	public String getAddressAddress1() {
		waitForElementVisible(driver, AddressPageUI.ADDRESS_SAVED_ADDRESS1);
		return getElementText(driver, AddressPageUI.ADDRESS_SAVED_ADDRESS1);
	}

	public String getAddressAddress2() {
		waitForElementVisible(driver, AddressPageUI.ADDRESS_SAVED_ADDRESS2);
		return getElementText(driver, AddressPageUI.ADDRESS_SAVED_ADDRESS2);
	}

	public String getAddressCity_State_ZipCode() {
		waitForElementVisible(driver, AddressPageUI.ADDRESS_SAVED_CITY_STATE_ZIP);
		return getElementText(driver, AddressPageUI.ADDRESS_SAVED_CITY_STATE_ZIP);
	}

	public String getCountry() {
		waitForElementVisible(driver, AddressPageUI.ADDRESS_SAVED_COUNTRY);
		return getElementText(driver, AddressPageUI.ADDRESS_SAVED_COUNTRY);
	}

	

	

	
	
	

}
