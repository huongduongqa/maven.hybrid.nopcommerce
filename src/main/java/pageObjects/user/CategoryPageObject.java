package pageObjects.user;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import io.qameta.allure.Step;
import pageUIs.user.CategoryPageUI;
import pageUIs.user.ProductPageUI;

public class CategoryPageObject extends BasePage {
	WebDriver driver;
	
	public CategoryPageObject(WebDriver driver) {
		this.driver = driver;
	}

	@Step("Click To Product Name link")
	public ProductPageObject clickToProductNameLink(WebDriver driver2, String productName) {
		waitForElementClickable(driver, CategoryPageUI.PRODUCT_NAME_LINK, productName);
		clickToElement(driver, CategoryPageUI.PRODUCT_NAME_LINK, productName);
		return PageGeneratorManager.getProductPageObject(driver);
	}

	public void SelectSortByComboboxByText(String string) {
		waitForElementClickable(driver, CategoryPageUI.SORT_BY_COMBOBOX);
		selectItemInDefaultDropdown(driver, CategoryPageUI.SORT_BY_COMBOBOX, string);
	}

	public boolean isProductNameSortedByAscending() {
		ArrayList<String> productNames = new ArrayList<String>();
		List<WebElement> listProduct = getListWebElement(driver, CategoryPageUI.PRODUCT_NAME_LIST);
		for (WebElement item : listProduct) 
			productNames.add(item.getText());
		
		ArrayList<String> productNamesSorted = new ArrayList<String>();
		for (String itemName : productNames) {
			productNamesSorted.add(itemName);
		}
		Collections.sort(productNamesSorted);
		
		return productNames.equals(productNamesSorted);
	}

	public boolean isProductNameSortedByDescending() {
		ArrayList<String> productNames = new ArrayList<String>();
		List<WebElement> listProduct = getListWebElement(driver, CategoryPageUI.PRODUCT_NAME_LIST);
		for (WebElement item : listProduct) 
			productNames.add(item.getText());
			
		ArrayList<String> productNamesSorted = new ArrayList<String>();
		for (String itemName : productNames) {
			productNamesSorted.add(itemName);
		}
		Collections.sort(productNamesSorted);
		Collections.reverse(productNamesSorted);
		
		return productNames.equals(productNamesSorted);
	}

	public boolean isProductPriceSortedLowToHigh() {
		ArrayList<Float> productPrices = new ArrayList<Float>();
		List<WebElement> listProduct = getListWebElement(driver, CategoryPageUI.PRODUCT_PRICE_LIST);
		for (WebElement element : listProduct) 
			productPrices.add(Float.parseFloat(element.getText().replace("$", "").replace(",", "")));
		
		ArrayList<Float> productPricesSorted = new ArrayList<Float>();
		for (Float float_item : productPrices) 
			productPricesSorted.add(float_item);
		
		Collections.sort(productPricesSorted);
		return productPrices.equals(productPricesSorted);
	}

	public boolean isProductPriceSortedHighToLow() {
		ArrayList<Float> productPrices = new ArrayList<Float>();
		List<WebElement> listProduct = getListWebElement(driver, CategoryPageUI.PRODUCT_PRICE_LIST);
		for (WebElement element : listProduct) 
			productPrices.add(Float.parseFloat(element.getText().replace("$", "").replace(",", "")));
		
		ArrayList<Float> productPricesSorted = new ArrayList<Float>();
		for (Float float_item : productPrices) 
			productPricesSorted.add(float_item);
		
		Collections.sort(productPricesSorted);
		Collections.reverse(productPricesSorted);
		return productPrices.equals(productPricesSorted);
	}

	public void SelectDisplayNumberOfProductPerPage(String string) {
		waitForElementClickable(driver, CategoryPageUI.DISPLAY_COMBOBOX);
		selectItemInDefaultDropdown(driver, CategoryPageUI.DISPLAY_COMBOBOX, string);
	}

	public boolean getNumberOfRecord(int expectedNumber) {
		List<WebElement> listProduct = getListWebElement(driver, CategoryPageUI.PRODUCT_NAME_LIST);
		return listProduct.size()<=expectedNumber;
	}

	public void clickToIndividualPage() {
		waitForElementClickable(driver, CategoryPageUI.INDIVIDUAL_PAGE);
		clickToElement(driver, CategoryPageUI.INDIVIDUAL_PAGE);
	}

	public boolean isPreviousPagingDisplayed() {
		waitForElementVisible(driver, CategoryPageUI.PREVIOUS_PAGE);
		return isElementDisplayed(driver, CategoryPageUI.PREVIOUS_PAGE);
	}

	public boolean isNextPagingDisplayed() {
		waitForElementVisible(driver, CategoryPageUI.NEXT_PAGE);
		return isElementDisplayed(driver, CategoryPageUI.NEXT_PAGE);
	}

	public boolean isPagingUndisplayed() {
		List<WebElement> element = getListWebElement(driver, CategoryPageUI.PAGING);
		if (element.size() == 0)
				return false;
		else return true;
	}

	public void clickToAddToCompareListButton(String productName) {
		waitForElementClickable(driver, CategoryPageUI.ADD_TO_MY_LIST_BUTTON,productName);
		clickToElement(driver, CategoryPageUI.ADD_TO_MY_LIST_BUTTON, productName);
	}

	public String getAddToCompareMessageInBarNotification() {
		waitForElementVisible(driver, CategoryPageUI.ADD_TO_COMPARE_NOTIFICATION_BAR);
		return getElementText(driver, CategoryPageUI.ADD_TO_COMPARE_NOTIFICATION_BAR);
	}
}
