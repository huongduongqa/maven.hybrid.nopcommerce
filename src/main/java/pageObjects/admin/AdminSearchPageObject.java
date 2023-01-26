package pageObjects.admin;

import org.openqa.selenium.WebDriver;

import commons.AdminGenericPage;
import pageUIs.admin.AdminSearchPageUI;

public class AdminSearchPageObject extends AdminGenericPage{
	WebDriver driver;
	
	public AdminSearchPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToProductNameTextBox(String productName) {
		waitForElementVisible(driver, AdminSearchPageUI.PRODUCT_NAME_TEXTBOX);
		sendkeyToElement(driver, AdminSearchPageUI.PRODUCT_NAME_TEXTBOX, productName);
	}

	public void clickToSearchButton() {
		waitForElementClickable(driver, AdminSearchPageUI.SEARCH_BUTTON);
		clickToElement(driver, AdminSearchPageUI.SEARCH_BUTTON);
	}

	public Object getNumberRecordFound() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getProductNameFound() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getProductSKUFound() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getProductPriceFound() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getProductStockQuantityFound() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getProductPublishedStatus() {
		// TODO Auto-generated method stub
		return null;
	}
}