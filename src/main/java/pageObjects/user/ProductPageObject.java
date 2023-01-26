package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import io.qameta.allure.Step;
import pageUIs.user.ProductPageUI;

public class ProductPageObject extends BasePage {
	
	WebDriver driver;

	public ProductPageObject (WebDriver driver)
	{
		this.driver = driver;
	}

	@Step("Click to Add Your Review Link")
	public ProductReviewPageObject clickToAddYourReviewLink() {
		waitForElementClickable(driver, ProductPageUI.ADD_YOUR_REVIEW_LINK);
		clickToElement(driver, ProductPageUI.ADD_YOUR_REVIEW_LINK);
		return PageGeneratorManager.getProductReviewPage(driver);
	}

	public WishListPageObject clickToWishListButton() {
		waitForElementClickable(driver, ProductPageUI.ADD_TO_WISHLIST_LINK);
		clickToElement(driver, ProductPageUI.ADD_TO_WISHLIST_LINK);
		return PageGeneratorManager.getWishListPageObject(driver);	
	}

	public String getWishListMessageInBarNotification() {
		waitForElementVisible(driver, ProductPageUI.ADD_TO_WISHLIST_BAR_NOTIFICATION);
		return getElementText(driver, ProductPageUI.ADD_TO_WISHLIST_BAR_NOTIFICATION);
	}

	public void selectProcessorCombobox(String processor) {
		waitForElementClickable(driver, ProductPageUI.PROCESSOR_COMBOBOX);
		selectItemInDefaultDropdown(driver, ProductPageUI.PROCESSOR_COMBOBOX, processor);
	}

	public void selectRAMCombobox(String RAM) {
		waitForElementClickable(driver, ProductPageUI.RAM_COMBOBOX);
		selectItemInDefaultDropdown(driver, ProductPageUI.RAM_COMBOBOX, RAM);
	}

	public void SelectHDDRadio(String HDD) {
		waitForElementClickable(driver, ProductPageUI.HDD_RADIO, HDD );
		checkDefaultCheckboxRadio(driver, ProductPageUI.HDD_RADIO, HDD);
	}

	public void SelectOSRadio(String OS) {
		waitForElementClickable(driver, ProductPageUI.OS_RADIO, OS );
		checkDefaultCheckboxRadio(driver, ProductPageUI.OS_RADIO, OS);
	}

	public void SelectSoftwareCheckbox(String software) {
		waitForElementClickable(driver, ProductPageUI.SOFTWARE_CHECKBOX, software );
		checkDefaultCheckboxRadio(driver, ProductPageUI.SOFTWARE_CHECKBOX, software);	
	}

	public void inputToQuantityTextbox(String quantity) {
		waitForElementVisible(driver, ProductPageUI.QUANTITY_TEXTBOX);
		sendkeyToElement(driver, ProductPageUI.QUANTITY_TEXTBOX, quantity);
	}
	
	public void clickToAddToCartButton(String productName) {
		waitForElementClickable(driver, ProductPageUI.ADD_TO_CART_BUTTON, productName);
		clickToElement(driver, ProductPageUI.ADD_TO_CART_BUTTON, productName);	
	}

	public String getAddToCartSuccesfulMessage() {
		waitForElementVisible(driver, ProductPageUI.ADDING_SUCCESSFUL_MESSAGE);
		return getElementText(driver, ProductPageUI.ADDING_SUCCESSFUL_MESSAGE);
	}

	public String getProductPrice() {
		waitForElementVisible(driver, ProductPageUI.PRODUCT_PRICE);
		return getElementText(driver, ProductPageUI.PRODUCT_PRICE);
	}

	public void clickToUpdateButon(String productName) {
		waitForElementClickable(driver, ProductPageUI.ADD_TO_CART_BUTTON,productName);
		clickToElement(driver, ProductPageUI.ADD_TO_CART_BUTTON,productName);	
	}

	public String getProductSKU() {
		waitForElementVisible(driver, ProductPageUI.PRODUC_SKU);
		return getElementText(driver, ProductPageUI.PRODUC_SKU);
	}	
}
