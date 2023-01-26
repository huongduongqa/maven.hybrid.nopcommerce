package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.user.CheckoutPageUI;

public class CheckoutPageObject extends BasePage{

	WebDriver driver;
	
	public CheckoutPageObject (WebDriver driver)
	{
		this.driver = driver;
	}

	public void inputInfoToBillingAddressForm(String firstname, String lastname, String email, String country, String state, String city, String address_01, String zipCode, String phoneNumber)
	{
		waitForElementVisible(driver, CheckoutPageUI.FIRSTNAME_TEXTBOX);
		sendkeyToElement(driver, CheckoutPageUI.FIRSTNAME_TEXTBOX, firstname);
		waitForElementVisible(driver, CheckoutPageUI.LASTNAME_TEXTBOX);
		sendkeyToElement(driver, CheckoutPageUI.LASTNAME_TEXTBOX, lastname);
		waitForElementVisible(driver, CheckoutPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, CheckoutPageUI.EMAIL_TEXTBOX, email);
		waitForElementVisible(driver, CheckoutPageUI.COUNTRY_COMBOBOX);
		selectItemInDefaultDropdown(driver, CheckoutPageUI.COUNTRY_COMBOBOX, country);
		waitForElementVisible(driver, CheckoutPageUI.STATE_COMBOBOX);
		selectItemInDefaultDropdown(driver, CheckoutPageUI.STATE_COMBOBOX, state);
		waitForElementVisible(driver, CheckoutPageUI.CITY_TEXTBOX);
		sendkeyToElement(driver, CheckoutPageUI.CITY_TEXTBOX, city);
		waitForElementVisible(driver, CheckoutPageUI.ADDRESS1_TEXTBOX);
		sendkeyToElement(driver, CheckoutPageUI.ADDRESS1_TEXTBOX, address_01);
		waitForElementVisible(driver, CheckoutPageUI.ZIPCODE_TEXTBOX);
		sendkeyToElement(driver, CheckoutPageUI.ZIPCODE_TEXTBOX, zipCode);
		waitForElementVisible(driver, CheckoutPageUI.PHONE_NUMBER_TEXTBOX);
		sendkeyToElement(driver, CheckoutPageUI.PHONE_NUMBER_TEXTBOX, phoneNumber);
	}

	public void clickToBillingAddressContinueButton() {
		waitForElementClickable(driver, CheckoutPageUI.BILLING_ADDRESS_CONTINUE_BUTTON);
		clickToElement(driver, CheckoutPageUI.BILLING_ADDRESS_CONTINUE_BUTTON);
	}

	public void clickToShippingMethodRadio(String shippingMethod) {
		waitForElementClickable(driver, CheckoutPageUI.SHIPPING_METHOD_RADIO, shippingMethod);
		checkDefaultCheckboxRadio(driver, CheckoutPageUI.SHIPPING_METHOD_RADIO, shippingMethod);
	}

	public void clickToPaymentMethodRadio(String paymentMethod) {
		waitForElementClickable(driver, CheckoutPageUI.PAYMENT_METHOD_RADIO, paymentMethod);
		checkDefaultCheckboxRadio(driver, CheckoutPageUI.PAYMENT_METHOD_RADIO, paymentMethod);
	}

	public void clickToShippingMethodContinueButton() {
		waitForElementClickable(driver, CheckoutPageUI.SHIPPING_METHOD_CONTINUE_BUTTON);
		clickToElement(driver, CheckoutPageUI.SHIPPING_METHOD_CONTINUE_BUTTON);
	}

	public void clickToPaymentMethodContinueButton() {
		waitForElementClickable(driver, CheckoutPageUI.PAYMENT_METHOD_CONTINUE_BUTTON);
		clickToElement(driver, CheckoutPageUI.PAYMENT_METHOD_CONTINUE_BUTTON);
	}
	
	public void clickToPaymentInfoContinueButton() {
		waitForElementClickable(driver, CheckoutPageUI.PAYMENT_INFO_CONTINUE_BUTTON);
		clickToElement(driver, CheckoutPageUI.PAYMENT_INFO_CONTINUE_BUTTON);
	}

	public void inputPaymentInfoForm(String string, String string2, String string3, String string4, String string5,
			String string6) {
		// TODO Auto-generated method stub
		
	}

	public void clickToConfirmOrderButton() {
		waitForElementClickable(driver, CheckoutPageUI.CONFIRM_BUTTON);
		clickToElement(driver, CheckoutPageUI.CONFIRM_BUTTON);
	}

	public void checkShipToSameAddressCheckbox() {
		waitForElementClickable(driver, CheckoutPageUI.SHIP_TO_SAME_ADDRESS_CHECKBOX);
		checkDefaultCheckboxRadio(driver, CheckoutPageUI.SHIP_TO_SAME_ADDRESS_CHECKBOX);
	}

	public String getPaymentInfo() {
		waitForElementVisible(driver,CheckoutPageUI.PAYMENT_INFO_CONFIRM_MESSAGE);
		return getElementText(driver, CheckoutPageUI.PAYMENT_INFO_CONFIRM_MESSAGE);
	}

	public String getBillingInfoName() {
		waitForElementVisible(driver,CheckoutPageUI.BILLING_INFO_NAME);
		return getElementText(driver, CheckoutPageUI.BILLING_INFO_NAME);
	}

	public String getBillingInfoEmail() {
		waitForElementVisible(driver,CheckoutPageUI.BILLING_INFO_EMAIL);
		return getElementText(driver, CheckoutPageUI.BILLING_INFO_EMAIL);
	}

	public String getBillingInfoPhone() {
		waitForElementVisible(driver,CheckoutPageUI.BILLING_INFO_PHONE);
		return getElementText(driver, CheckoutPageUI.BILLING_INFO_PHONE);
	}

	public String getBillingInfoFax() {
		waitForElementVisible(driver,CheckoutPageUI.BILLING_INFO_FAX);
		return getElementText(driver, CheckoutPageUI.BILLING_INFO_FAX);
	}

	public String getBillingInfoCompany() {
		waitForElementVisible(driver,CheckoutPageUI.BILLING_INFO_COMPANY);
		return getElementText(driver, CheckoutPageUI.BILLING_INFO_COMPANY);
	}

	public String getBillingInfoAddress01() {
		waitForElementVisible(driver,CheckoutPageUI.BILLING_INFO_ADDRRESS_01);
		return getElementText(driver, CheckoutPageUI.BILLING_INFO_ADDRRESS_01);
	}

	public String getBillingInfoCityStateZip() {
		waitForElementVisible(driver,CheckoutPageUI.BILLING_INFO_CITY_STATE_ZIP);
		return getElementText(driver, CheckoutPageUI.BILLING_INFO_CITY_STATE_ZIP);
	}

	public String getBillingInfoCountry() {
		waitForElementVisible(driver,CheckoutPageUI.BILLING_INFO_COUNTRY);
		return getElementText(driver, CheckoutPageUI.BILLING_INFO_COUNTRY);
	}

	public String getShippingInfoName() {
		waitForElementVisible(driver,CheckoutPageUI.SHIPPING_INFO_NAME);
		return getElementText(driver, CheckoutPageUI.SHIPPING_INFO_NAME);
	}

	public String getShippingInfoEmail() {
		waitForElementVisible(driver,CheckoutPageUI.SHIPPING_INFO_EMAIL);
		return getElementText(driver, CheckoutPageUI.SHIPPING_INFO_EMAIL);
	}

	public String getShippingInfoPhone() {
		waitForElementVisible(driver,CheckoutPageUI.SHIPPING_INFO_PHONE);
		return getElementText(driver, CheckoutPageUI.SHIPPING_INFO_PHONE);
	}

	public String getShippingInfoFax() {
		waitForElementVisible(driver,CheckoutPageUI.SHIPPING_INFO_FAX);
		return getElementText(driver, CheckoutPageUI.SHIPPING_INFO_FAX);
	}

	public String getShippingInfoCompany() {
		waitForElementVisible(driver,CheckoutPageUI.SHIPPING_INFO_COMPANY);
		return getElementText(driver, CheckoutPageUI.SHIPPING_INFO_COMPANY);
	}

	public String getShippingInfoAddress01() {
		waitForElementVisible(driver,CheckoutPageUI.SHIPPING_INFO_ADDRESS_01);
		return getElementText(driver, CheckoutPageUI.SHIPPING_INFO_ADDRESS_01);
	}

	public String getShippingInfoCityStateZip() {
		waitForElementVisible(driver,CheckoutPageUI.SHIPPING_INFO_CITY_STATE_ZIP);
		return getElementText(driver, CheckoutPageUI.SHIPPING_INFO_CITY_STATE_ZIP);
	}

	public String getShippingInfoCountry() {
		waitForElementVisible(driver,CheckoutPageUI.SHIPPING_INFO_COUNTRY);
		return getElementText(driver, CheckoutPageUI.SHIPPING_INFO_COUNTRY);
	}

	public String getPaymentMethod() {
		waitForElementVisible(driver,CheckoutPageUI.PAYMENT_METHOD_VALUE);
		return getElementText(driver, CheckoutPageUI.PAYMENT_METHOD_VALUE);
	}

	public String getShippingMethod() {
		waitForElementVisible(driver,CheckoutPageUI.SHIPPING_METHOD_VALUE);
		return getElementText(driver, CheckoutPageUI.SHIPPING_METHOD_VALUE);
	}

	public String getGiftWrappingInfo() {
		waitForElementVisible(driver,CheckoutPageUI.GIFT_WRAPPING);
		return getElementText(driver, CheckoutPageUI.GIFT_WRAPPING);
	}

	public String getProductSKU() {
		waitForElementVisible(driver,CheckoutPageUI.PRODUCT_SKU);
		return getElementText(driver, CheckoutPageUI.PRODUCT_SKU);
	}

	public String getProductName() {
		waitForElementVisible(driver,CheckoutPageUI.PRODUCT_NAME);
		return getElementText(driver, CheckoutPageUI.PRODUCT_NAME);
	}

	public String getProductPrice() {
		waitForElementVisible(driver,CheckoutPageUI.PRODUCT_PRICE);
		return getElementText(driver, CheckoutPageUI.PRODUCT_PRICE);
	}

	public String getProductQty() {
		waitForElementVisible(driver,CheckoutPageUI.PRODUCT_QTY);
		return getElementText(driver, CheckoutPageUI.PRODUCT_QTY);
	}

	public String getProductTotal() {
		waitForElementVisible(driver,CheckoutPageUI.TOTAL_IN_TABLE);
		return getElementText(driver, CheckoutPageUI.TOTAL_IN_TABLE);
	}

	public String getCartTotalInfo(String locatorTitle) {
		waitForElementVisible(driver,CheckoutPageUI.CART_TOTAL_INFO, locatorTitle);
		return getElementText(driver, CheckoutPageUI.CART_TOTAL_INFO, locatorTitle);
	}

	public String getPageTitleMessage() {
		waitForElementVisible(driver,CheckoutPageUI.PAGE_TITLE_LABEL);
		System.out.println("page title: "+ getElementText(driver, CheckoutPageUI.PAGE_TITLE_LABEL));
		return getElementText(driver, CheckoutPageUI.PAGE_TITLE_LABEL);
	}

	public String getSuccesfulMessage() {
		waitForElementVisible(driver,CheckoutPageUI.SUCCESS_MESSAGE_LABEL);
		return getElementText(driver, CheckoutPageUI.SUCCESS_MESSAGE_LABEL);
	}

	public String getOrderNumber() {
		waitForElementVisible(driver,CheckoutPageUI.ORDER_NUMBER_LABEL);
		return getElementText(driver, CheckoutPageUI.ORDER_NUMBER_LABEL);
	}
}
