package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.user.ShoppingCartPageUI;
import pageUIs.user.WishListSharedPageUI;

public class WishListSharedPageObject extends BasePage{
	
	WebDriver driver;
	
	public WishListSharedPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToAddToCartCheckbox() {
		waitForElementVisible(driver, WishListSharedPageUI.ADD_TO_CART_CHECKBOX);
		clickToElement(driver, WishListSharedPageUI.ADD_TO_CART_CHECKBOX);
	}

	public ShoppingCartPageObject clickToAddToCartButton() {
		waitForElementVisible(driver, WishListSharedPageUI.ADD_TO_CART_BUTTON);
		clickToElement(driver, WishListSharedPageUI.ADD_TO_CART_BUTTON);
		return PageGeneratorManager.getShoppingCartPageObject(driver);
	}
	
	public String getPageTitleText() {
		waitForElementVisible(driver, WishListSharedPageUI.PAGE_TITLE);
		return getElementText(driver, WishListSharedPageUI.PAGE_TITLE);
	}

}
