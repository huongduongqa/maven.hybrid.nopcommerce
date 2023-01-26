package pageUIs.user;

public class CategoryPageUI {
	
	public static final String PRODUCT_NAME_LINK = "xpath=//div[@class='product-item']//a[text()='%s']";
	public static final String SORT_BY_COMBOBOX = "css=select#products-orderby";
	public static final String DISPLAY_COMBOBOX = "css=select#products-pagesize";
	public static final String PRODUCT_NAME_LIST = "xpath=//div[@class='product-item']//h2/a";
	public static final String PRODUCT_PRICE_LIST = "xpath=//div[@class='product-item']//div[@class='prices']";
	public static final String CURRENT_PAGE = "xpath=//div[@class='pager']//li[@class='current-page']";
	public static final String PREVIOUS_PAGE = "xpath=//div[@class='pager']//li[@class='previous-page']";
	public static final String NEXT_PAGE ="xpath=//div[@class='pager']//li[@class='next-page']";
	public static final String INDIVIDUAL_PAGE ="xpath=//div[@class='pager']//li[@class='individual-page']";
	public static final String PAGING = "xpath=//div[@class='pager']";
	public static final String ADD_TO_MY_LIST_BUTTON = "xpath=//div[@class='product-item']//a[text()='%s']//ancestor::div[@class='details']//following-sibling::div[@class='add-info']//button[@title='Add to compare list']";
	public static final String ADD_TO_COMPARE_NOTIFICATION_BAR = "xpath=//div[@class='bar-notification success']";
	
}
