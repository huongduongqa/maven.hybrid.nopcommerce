package pageUIs.user;

public class CompareProductListPageUI {
	public static final String PRODUCT_NAME_TEXT ="xpath=//table[@class='compare-products-table']//tr[@class='product-name']//a[text()='%s']";
	public static final String PRODUCT_INDEX = "xpath=//table//tr//a[text()='%s']//parent::td/preceding-sibling::td";
	public static final String REMOVE_BUTTON_BY_PRPODUCT_INDEX = "xpath=//table//tr[@class='remove-product']/td[%s]";
	public static final String PRODUCT_PRICE_BY_PRODUCT_INDEX ="xpath=//table//tr[@class='product-price']/td[%s]";
	public static final String CLEAR_LIST_BUTTON = "xpath=//div[@class='page-body']/a";
	public static final String PRODUCT_TABLE = "xpath=//table[@class='compare-products-table']";
	public static final String NO_DATA_MESSAGE = "xpath=//div[@class='no-data']";
}
