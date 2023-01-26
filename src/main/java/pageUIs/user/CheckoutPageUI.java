package pageUIs.user;

public class CheckoutPageUI {
	public static final String FIRSTNAME_TEXTBOX = "css=input#BillingNewAddress_FirstName";
	public static final String LASTNAME_TEXTBOX = "css=input#BillingNewAddress_LastName";
	public static final String EMAIL_TEXTBOX = "css=input#BillingNewAddress_Email";
	public static final String COUNTRY_COMBOBOX = "css=select#BillingNewAddress_CountryId";
	public static final String STATE_COMBOBOX = "css=select#BillingNewAddress_StateProvinceId";
	public static final String CITY_TEXTBOX = "css=input#BillingNewAddress_City";
	public static final String ADDRESS1_TEXTBOX = "css=input#BillingNewAddress_Address1";
	public static final String ZIPCODE_TEXTBOX = "css=input#BillingNewAddress_ZipPostalCode";
	public static final String PHONE_NUMBER_TEXTBOX = "css=input#BillingNewAddress_PhoneNumber";
	public static final String BILLING_ADDRESS_CONTINUE_BUTTON = "xpath=//div[@id='billing-buttons-container']/button[text()='Continue']";
	public static final String SHIPPING_METHOD_CONTINUE_BUTTON ="xpath=//div[@id='shipping-method-buttons-container']/button[text()='Continue']";
	public static final String PAYMENT_METHOD_CONTINUE_BUTTON = "xpath=//div[@id='payment-method-buttons-container']//button";
	public static final String PAYMENT_INFO_CONTINUE_BUTTON = "xpath=//div[@id='payment-info-buttons-container']//button";
	
	public static final String SHIP_TO_SAME_ADDRESS_CHECKBOX = "xpath=//input[@id='ShipToSameAddress']";
	public static final String SHIPPING_METHOD_RADIO = "xpath=//label[text()='%s']/preceding-sibling::input";
	public static final String PAYMENT_METHOD_RADIO = "xpath=//label[text()='%s']/preceding-sibling::input";
	public static final String CREDIT_CARD_COMBOBOX = "css=select#CreditCardType";
	public static final String CARD_HOLDER_NAME_TEXTBOX = "css=input#CardholderName";
	public static final String CARD_NUMBER_TEXTBOX = "css=select#ExpireMonth";
	public static final String EXPIRED_MONTH_COMBOBOX = "css=select#ExpireYear";
	public static final String EXPIRED_YEAR_COMBOBOX = "css=input#CardCode";
	public static final String CARD_CODE_TEXTBOX = "css=CardCode";
	public static final String CONFIRM_BUTTON ="xpath=//div[@id='confirm-order-buttons-container']//button";	
	public static final String PAGE_TITLE_LABEL = "xpath=//div[@class='page-title']";
	public static final String SUCCESS_MESSAGE_LABEL = "xpath=//div[@class='section order-completed']/div[@class='title']";
	public static final String ORDER_NUMBER_LABEL = "xpath=//div[@class='order-number']";
	public static final String PAYMENT_INFO_CONFIRM_MESSAGE = "xpath=//div[@class='info']//p[2]";
	
	public static final String BILLING_INFO_NAME = "xpath=//div[@class='billing-info']//li[@class='name']";
	public static final String BILLING_INFO_EMAIL = "xpath=//div[@class='billing-info']//li[@class='email']";
	public static final String BILLING_INFO_PHONE = "xpath=//div[@class='billing-info']//li[@class='phone']";
	public static final String BILLING_INFO_FAX = "xpath=//div[@class='billing-info']//li[@class='fax']";
	public static final String BILLING_INFO_COMPANY = "xpath=//div[@class='billing-info']//li[@class='company']";
	public static final String BILLING_INFO_ADDRRESS_01 = "xpath=//div[@class='billing-info']//li[@class='address1']";
	public static final String BILLING_INFO_CITY_STATE_ZIP = "xpath=//div[@class='billing-info']//li[@class='city-state-zip']";
	public static final String BILLING_INFO_COUNTRY = "xpath=//div[@class='billing-info']//li[@class='country']";
	
	public static final String PAYMENT_METHOD_VALUE = "xpath=//div[@class='payment-method-info']//span[@class='value']";
	
	public static final String SHIPPING_INFO_NAME = "xpath=//div[@class='shipping-info-wrap']//li[@class='name']";
	public static final String SHIPPING_INFO_EMAIL = "xpath=//div[@class='shipping-info-wrap']//li[@class='email']";
	public static final String SHIPPING_INFO_PHONE = "xpath=//div[@class='shipping-info-wrap']//li[@class='phone']";
	public static final String SHIPPING_INFO_FAX = "xpath=//div[@class='shipping-info-wrap']//li[@class='fax']";
	public static final String SHIPPING_INFO_COMPANY = "xpath=//div[@class='shipping-info-wrap']//li[@class='company']";
	public static final String SHIPPING_INFO_ADDRESS_01 = "xpath=//div[@class='shipping-info-wrap']//li[@class='address1']";
	public static final String SHIPPING_INFO_CITY_STATE_ZIP = "xpath=//div[@class='shipping-info-wrap']//li[@class='city-state-zip']";
	public static final String SHIPPING_INFO_COUNTRY = "xpath=//div[@class='shipping-info-wrap']//li[@class='country']";
	
	public static final String SHIPPING_METHOD_VALUE = "xpath=//div[@class='shipping-method-info']//span[@class='value']";
	public static final String GIFT_WRAPPING = "xpath=//div[@class='selected-checkout-attributes']";
	
	public static final String PRODUCT_SKU = "xpath=//table[@class='cart']//span[@class='sku-number']";
	public static final String PRODUCT_NAME = "xpath=//table[@class='cart']//a[@class='product-name']";
	public static final String PRODUCT_PRICE = "xpath=//table[@class='cart']//span[@class='product-unit-price']";
	public static final String PRODUCT_QTY = "xpath=//table[@class='cart']//span[@class='product-quantity']";
	public static final String TOTAL_IN_TABLE = "xpath=//table[@class='cart']//span[@class='product-subtotal']";
	
	public static final String SUB_TOTAL = "xpath=//label[text()='Sub-Total:']/parent::td/following-sibling::td/span";
	public static final String SHIPPING_FEE = "xpath://label[text()='Shipping:']/parent::td/following-sibling::td/span";
	public static final String TAX_FEE = "xpath=//label[text()='Tax:']/parent::td/following-sibling::td/span";
	public static final String TOTAL_OUT_TABLE = "xpath=//label[text()='Total:']/parent::td/following-sibling::td/span";
	
	public static final String CART_TOTAL_INFO = "xpath=//label[text()='%s']/parent::td/following-sibling::td/span";
}
