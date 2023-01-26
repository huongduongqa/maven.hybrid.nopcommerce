package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.user.WishListPageUI;
import pageUIs.user.WishListSharedPageUI;

public class WishListPageObject extends BasePage {

	WebDriver driver;
	
	public WishListPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public String getProductSKUText() {
		waitForElementVisible(driver, WishListPageUI.SKU_TEXT);
		return getElementText(driver, WishListPageUI.SKU_TEXT);
	}

	public String getProductNameText() {
		waitForElementVisible(driver, WishListPageUI.PRODUCT_NAME_TEXT);
		return getElementText(driver, WishListPageUI.PRODUCT_NAME_TEXT);
	}

	public String getProductPriceText() {
		waitForElementVisible(driver, WishListPageUI.PRICE_TEXT);
		return getElementText(driver, WishListPageUI.PRICE_TEXT);
	}

	public String getProductQtyText() {
		waitForElementVisible(driver, WishListPageUI.QTY_TEXT);
		return getElementAttribute(driver, WishListPageUI.QTY_TEXT, "value");
	}

	public String getProductTotalPriceText() {
		waitForElementVisible(driver, WishListPageUI.TOTAL_PRICE_TEXT);
		return getElementText(driver, WishListPageUI.TOTAL_PRICE_TEXT);
	}

	public WishListSharedPageObject clickToWishListForSharingLink() {
		waitForElementClickable(driver, WishListPageUI.SHARE_LINK);
		clickToElement(driver, WishListPageUI.SHARE_LINK);
		return PageGeneratorManager.getWishListSharedPageObject(driver);
	}

	public void clickToRemoveProductButtonIcon() {
		waitForElementClickable(driver, WishListPageUI.REMOVE_PRODUCT_BUTTON_ICON);
		clickToElement(driver, WishListPageUI.REMOVE_PRODUCT_BUTTON_ICON);
	}

	public String getNoDataMessage() {
		waitForElementVisible(driver, WishListPageUI.NO_DATA_MESSAGE);
		return getElementText(driver, WishListPageUI.NO_DATA_MESSAGE);
	}
}
