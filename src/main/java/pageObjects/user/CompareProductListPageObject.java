package pageObjects.user;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.user.CategoryPageUI;
import pageUIs.user.CompareProductListPageUI;

public class CompareProductListPageObject extends BasePage{
	
	WebDriver driver;
	
	public CompareProductListPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isRemovedButtonDisplayed(String productName) {
		int columnIndex = getElementSize(driver, CompareProductListPageUI.PRODUCT_INDEX,productName)+1;
		waitForElementVisible(driver, CompareProductListPageUI.REMOVE_BUTTON_BY_PRPODUCT_INDEX, String.valueOf(columnIndex));
		return isElementDisplayed(driver,CompareProductListPageUI.REMOVE_BUTTON_BY_PRPODUCT_INDEX, String.valueOf(columnIndex));
	}

	public boolean isProductNameDisplayed(String productName) {
		waitForElementVisible(driver, CompareProductListPageUI.PRODUCT_NAME_TEXT,productName);
		return isElementDisplayed(driver,CompareProductListPageUI.PRODUCT_NAME_TEXT,productName);
	}

	public String getProductPrice(String productName) {
		int columnIndex = getElementSize(driver, CompareProductListPageUI.PRODUCT_INDEX,productName)+1;
		waitForElementVisible(driver, CompareProductListPageUI.PRODUCT_PRICE_BY_PRODUCT_INDEX, String.valueOf(columnIndex));
		return getElementText(driver,CompareProductListPageUI.PRODUCT_PRICE_BY_PRODUCT_INDEX, String.valueOf(columnIndex));
	}

	public boolean isClearListButtonDisplayed() {
		waitForElementVisible(driver, CompareProductListPageUI.CLEAR_LIST_BUTTON);
		return isElementDisplayed(driver,CompareProductListPageUI.CLEAR_LIST_BUTTON);
	}

	public void clickToClearListButton() {
		waitForElementClickable(driver, CompareProductListPageUI.CLEAR_LIST_BUTTON);
		clickToElement(driver, CompareProductListPageUI.CLEAR_LIST_BUTTON);
	}

	public String getNoDataMessage() {
		waitForElementVisible(driver, CompareProductListPageUI.NO_DATA_MESSAGE);
		return getElementText(driver, CompareProductListPageUI.NO_DATA_MESSAGE);
	}

	public boolean isProductNotDisplayed() {
		List<WebElement> element = getListWebElement(driver, CompareProductListPageUI.PRODUCT_TABLE);
		if (element.size() == 0)
				return false;
		else return true;
	}
}
