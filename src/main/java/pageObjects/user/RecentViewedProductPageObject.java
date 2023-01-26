package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.user.RecentViewedProductPageUI;

public class RecentViewedProductPageObject extends BasePage {
	
	WebDriver driver;
	
	public RecentViewedProductPageObject(WebDriver driver)
	{
		this.driver = driver;
	}

	public boolean isLastThreeProductsViewedDisplayed() {
		int productNumber = getElementSize(driver, RecentViewedProductPageUI.PRODUCT_NUMBER);
		if (productNumber == 3)
			return true;
		else return false;
	}

	public boolean IsThisProductDisplayed(String productName) {
		waitForElementVisible(driver, RecentViewedProductPageUI.PRODUCT_NAME,productName);
		return isElementDisplayed(driver, RecentViewedProductPageUI.PRODUCT_NAME,productName);
	}

}
