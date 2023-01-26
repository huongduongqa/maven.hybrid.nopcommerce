package commons;

import org.openqa.selenium.WebDriver;

import pageObjects.admin.AdminSearchPageObject;
import pageObjects.admin.PageGeneratorManager;
import pageUIs.admin.AdminGenericPageUI;

public class AdminGenericPage extends BasePage {
	
	public void clickToCatalogMenu(WebDriver driver) {
		waitForElementVisible(driver, AdminGenericPageUI.CATALOG_MENU);
		clickToElement(driver, AdminGenericPageUI.CATALOG_MENU);
	}
	
	public AdminSearchPageObject clickToProductsMenu(WebDriver driver) {
		waitForElementVisible(driver, AdminGenericPageUI.PRODUCTS_MENU);
		clickToElement(driver, AdminGenericPageUI.PRODUCTS_MENU);
		return PageGeneratorManager.getAdminSearchPageObject(driver);
	}
}
