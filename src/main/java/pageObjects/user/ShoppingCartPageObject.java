package pageObjects.user;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.user.BasePageUI;
import pageUIs.user.ShoppingCartPageUI;

public class ShoppingCartPageObject extends BasePage {
	
	WebDriver driver;
	
	public ShoppingCartPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public String getProductSKUText() {
		waitForElementVisible(driver, ShoppingCartPageUI.SKU_TEXT);
		return getElementText(driver, ShoppingCartPageUI.SKU_TEXT);
	}

	public String getProductNameText() {
		waitForElementVisible(driver, ShoppingCartPageUI.PRODUCT_NAME_TEXT);
		return getElementText(driver, ShoppingCartPageUI.PRODUCT_NAME_TEXT);
	}

	public String getProductPriceText() {
		waitForElementVisible(driver, ShoppingCartPageUI.PRICE_TEXT);
		return getElementText(driver, ShoppingCartPageUI.PRICE_TEXT);
	}

	public String getProductQtyText() {
		waitForElementVisible(driver, ShoppingCartPageUI.QUANTITY_TEXTBOX_BY_PRODUCT_NAME);
		return getElementAttribute(driver, ShoppingCartPageUI.QUANTITY_TEXTBOX_BY_PRODUCT_NAME, "value");
	}

	public String getProductTotalPriceText() {
		waitForElementVisible(driver, ShoppingCartPageUI.TOTAL_PRICE_IN_TABLE);
		return getElementText(driver, ShoppingCartPageUI.TOTAL_PRICE_IN_TABLE);
	}

	public void moveMouseToTheCartLink() {
		waitForElementVisible(driver, BasePageUI.CART_LINK);
		moveMouseToElement(driver, BasePageUI.CART_LINK);
	}

	public String getNumberofProductInMiniCart() {
		waitForElementVisible(driver, ShoppingCartPageUI.MINI_CART_NUMBER_PRODUCT_SUMMARY);
		return getElementText(driver, ShoppingCartPageUI.MINI_CART_NUMBER_PRODUCT_SUMMARY);
	}

	public String getProductNameInMiniCart() {
		waitForElementVisible(driver, ShoppingCartPageUI.MINI_CART_PRODUCT_NAME);
		return getElementText(driver, ShoppingCartPageUI.MINI_CART_PRODUCT_NAME);
	}

	public String getProductAttributesInMiniCart() {
		waitForElementVisible(driver, ShoppingCartPageUI.MINI_CART_PRODUCT_ATTRIBUTES);
		return getElementText(driver, ShoppingCartPageUI.MINI_CART_PRODUCT_ATTRIBUTES);
	}

	public String getProductUnitPriceInMiniCart() {
		waitForElementVisible(driver, ShoppingCartPageUI.MINI_CART_PRODUCT_PRICE);
		return getElementText(driver, ShoppingCartPageUI.MINI_CART_PRODUCT_PRICE);
	}

	public String getProductQuantityInMiniCart() {
		waitForElementVisible(driver, ShoppingCartPageUI.MINI_CART_PRODUCT_QUANTITY);
		return getElementText(driver, ShoppingCartPageUI.MINI_CART_PRODUCT_QUANTITY);
	}

	public String getTotalPriceInMiniCart() {
		waitForElementVisible(driver, ShoppingCartPageUI.MINI_CART_SUB_TOTAL);
		return getElementText(driver, ShoppingCartPageUI.MINI_CART_SUB_TOTAL);
	}

	public ProductPageObject clickToEditLinkByProductName() {
		
		waitForElementClickable(driver, ShoppingCartPageUI.EDIT_LINK_BY_PRODUCT_NAME);
		clickToElement(driver, ShoppingCartPageUI.EDIT_LINK_BY_PRODUCT_NAME);
		return PageGeneratorManager.getProductPageObject(driver);
	}

	public void clickToRemoveButtonByProductName(String prodName) {
		waitForElementClickable(driver, ShoppingCartPageUI.REMOVE_BUTTON, prodName);
		System.out.println("remove prd from the cart");
		clickToElement(driver, ShoppingCartPageUI.REMOVE_BUTTON, prodName);
	}

	public String getNoDataMessage() {
		waitForElementVisible(driver, ShoppingCartPageUI.NO_DATA_MESSAGE);
		return getElementText(driver, ShoppingCartPageUI.NO_DATA_MESSAGE);
	}

	public boolean isNoProductDisplayed() {
		List<WebElement> productList = getListWebElement(driver, ShoppingCartPageUI.PRODUCT_TABLE);
		if (productList.size()==0)
			return false;
		else return true;
	}

	public void inputToProductQuantityTextboxByProductName(String quantity) {
		waitForElementVisible(driver, ShoppingCartPageUI.QUANTITY_TEXTBOX_BY_PRODUCT_NAME);
		sendkeyToElement(driver, ShoppingCartPageUI.QUANTITY_TEXTBOX_BY_PRODUCT_NAME, quantity);
	}

	public void clickToUpdateShoppingCartButton() {
		waitForElementClickable(driver, ShoppingCartPageUI.UPDATE_SHOPPING_CART_BUTTON);
		clickToElement(driver, ShoppingCartPageUI.UPDATE_SHOPPING_CART_BUTTON);
	}

	public String getTotalPriceInTable() {
		waitForElementVisible(driver, ShoppingCartPageUI.TOTAL_PRICE_IN_TABLE);
		return getElementText(driver, ShoppingCartPageUI.TOTAL_PRICE_IN_TABLE);
	}

	public String getTotalPriceOutTable() {
		waitForElementVisible(driver, ShoppingCartPageUI.TOTAL_PRICE_OUT_TABLE);
		return getElementText(driver, ShoppingCartPageUI.TOTAL_PRICE_OUT_TABLE);
	}

	public void selectGiftWrappingCombobox(String itemValue) {
		waitForElementVisible(driver, ShoppingCartPageUI.GIFT_WRAPPING_COMBOBOX);
		selectItemInDefaultDropdown(driver, ShoppingCartPageUI.GIFT_WRAPPING_COMBOBOX, itemValue);
	}

	public void checkToTermOfServiceCheckbox() {
		waitForElementVisible(driver, ShoppingCartPageUI.TERM_OF_SERVICE_CHECKBOX);
		checkDefaultCheckboxRadio(driver, ShoppingCartPageUI.TERM_OF_SERVICE_CHECKBOX);
	}

	public CheckoutPageObject clickToCheckoutButton() {
		waitForElementClickable(driver, ShoppingCartPageUI.CHECKOUT_BUTTON);
		clickToElement(driver, ShoppingCartPageUI.CHECKOUT_BUTTON);
		return PageGeneratorManager.getCheckoutPageObject(driver);
	}
}
