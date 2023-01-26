package pageUIs.user;

public class ProductPageUI {
	
	public static final String ADD_YOUR_REVIEW_LINK = "xpath=//div[@class='product-review-links']/a[text()='Add your review']";
	public static final String ADD_TO_WISHLIST_LINK = "xpath=//div[@class='add-to-wishlist']/button";
	public static final String ADD_TO_WISHLIST_BAR_NOTIFICATION = "css=div.bar-notification>p";
	
	public static final String PROCESSOR_COMBOBOX = "xpath=//select[@id='product_attribute_1']";
	public static final String RAM_COMBOBOX = "xpath=//select[@id='product_attribute_2']";
	public static final String HDD_RADIO = "xpath=//input[@type='radio']/following-sibling::label[text()='%s']";
	public static final String OS_RADIO ="xpath=//input[@type='radio']/following-sibling::label[text()='%s']";

	public static final String SOFTWARE_CHECKBOX ="xpath=//input[@type='checkbox']/following-sibling::label[text()='%s']";

	public static final String QUANTITY_TEXTBOX ="xpath=//div[@class='add-to-cart-panel']/input";
	public static final String ADD_TO_CART_BUTTON ="xpath=//h1[text()='%s']/parent::div/following-sibling::div[@class='add-to-cart']//button";
	public static final String PRODUCT_PRICE = "xpath=//div[@class='product-price']";
	public static final String ADDING_SUCCESSFUL_MESSAGE ="xpath=//p[@class='content']";
	
	public static final String PRODUC_SKU = "xpath=//div[@class='sku']/span[@class='value']";	
	
}

