package pageUIs.user;

public class ShoppingCartPageUI {
	
	public static final String SKU_TEXT = "xpath=//table[@class='cart']//span[@class='sku-number']";
	public static final String PRODUCT_NAME_TEXT = "xpath=//table[@class='cart']//a[@class='product-name']";
	public static final String PRICE_TEXT = "xpath=//table[@class='cart']//span[@class='product-unit-price']";
	
	
	public static final String MINI_CART_NUMBER_PRODUCT_SUMMARY = "xpath=//div[@class='mini-shopping-cart']/div[@class='count']";
	public static final String MINI_CART_PRODUCT_NAME ="xpath=//div[@class='item first']//div[@class='name']";
	public static final String MINI_CART_PRODUCT_ATTRIBUTES = "xpath=//div[@class='item first']//div[@class='attributes']";
	public static final String MINI_CART_PRODUCT_PRICE = "xpath=//div[@class='item first']//div[@class='price']";
	public static final String MINI_CART_PRODUCT_QUANTITY = "xpath=//div[@class='item first']//div[@class='quantity']";
	public static final String MINI_CART_SUB_TOTAL = "xpath=//div[@id='flyout-cart']//div[@class='totals']";
	public static final String EDIT_LINK_BY_PRODUCT_NAME = "xpath=//div[@class='edit-item']/a";
	public static final String REMOVE_BUTTON ="xpath=//a[text()='%s']/parent::td//following-sibling::td[@class='remove-from-cart']";
	public static final String NO_DATA_MESSAGE ="xpath=//div[@class='no-data']";
	public static final String PRODUCT_TABLE ="xpath=//table[@class='cart']";
	public static final String QUANTITY_TEXTBOX_BY_PRODUCT_NAME = "xpath=//td[@class='quantity']/input";
	public static final String UPDATE_SHOPPING_CART_BUTTON = "xpath=//button[@id='updatecart']";
	public static final String TOTAL_PRICE_IN_TABLE = "xpath=//table[@class='cart']//span[@class='product-subtotal']";
	public static final String TOTAL_PRICE_OUT_TABLE = "xpath=//span[@class='value-summary']/strong";
	
	public static final String GIFT_WRAPPING_COMBOBOX = "xpath=//label[@class='text-prompt']//ancestor::dt/following-sibling::dd/select";
	public static final String TERM_OF_SERVICE_CHECKBOX = "xpath=//input[@id='termsofservice']";
	public static final String CHECKOUT_BUTTON = "xpath=//button[@id='checkout']";
}
