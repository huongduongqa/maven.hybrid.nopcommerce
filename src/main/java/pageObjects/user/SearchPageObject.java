package pageObjects.user;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import io.qameta.allure.Step;
import pageUIs.user.SearchPageUI;

public class SearchPageObject extends BasePage{
	
	WebDriver driver;
	
	public SearchPageObject(WebDriver driver) {
		this.driver = driver;
	}

	@Step("Click to Search Button")
	public void clickToSearchButton() {
		waitForElementClickable(driver, SearchPageUI.SEARCH_BUTTON);
		clickToElement(driver, SearchPageUI.SEARCH_BUTTON);
	}
	
	public String getMessageWithEmptySearch() {
		waitForElementVisible(driver, SearchPageUI.SEARCH_WARNING_MESSAGE);
		return getElementText(driver, SearchPageUI.SEARCH_WARNING_MESSAGE);
	}
	
	@Step("Input into Search textbox with {0}")
	public void inputToSearchTexbox(String keyword) {
		waitForElementVisible(driver, SearchPageUI.SEARCH_KEYWORD_TEXTBOX);
		sendkeyToElement(driver, SearchPageUI.SEARCH_KEYWORD_TEXTBOX, keyword);
	}

	public int getNumberOfResult() {
		List<WebElement> list = getListWebElement(driver, SearchPageUI.SEARCH_RETURNED_RESULTS);
		return list.size();
	}

	public boolean isProductNameContainedKeyword(String keyword) {
		boolean check = true;
		List<WebElement> list = getListWebElement(driver, SearchPageUI.SEARCH_RETURNED_RESULTS);
		for (WebElement item : list) {
			if (!item.getText().contains(keyword))
				check = false;
		}
		return check;
	}

	@Step("Check to Advance Search checkbox")
	public void checkToAdvancedSearchCheckbox() {
		waitForElementClickable(driver, SearchPageUI.ADVANCE_SEARCH_CHECKBOX);
		checkDefaultCheckboxRadio(driver, SearchPageUI.ADVANCE_SEARCH_CHECKBOX);
	}

	@Step("Select item in category comboxbox")
	public void selectItemInCategoryCombobox(String item) {
		waitForElementClickable(driver, SearchPageUI.CATEGORY_COMBOBOX);
		selectItemInDefaultDropdown(driver, SearchPageUI.CATEGORY_COMBOBOX, item);
	}

	@Step("Check to Auto Search Sub Category")
	public void checkToAutoSearchSubCategoryCheckbox() {
		waitForElementClickable(driver, SearchPageUI.AUTO_SEARCH_SUB_CATEGORY_CHECKBOX);
		checkDefaultCheckboxRadio(driver, SearchPageUI.AUTO_SEARCH_SUB_CATEGORY_CHECKBOX);	
	}

	public void selectItemInManufacturerCombobox(String item) {
		waitForElementClickable(driver, SearchPageUI.MANUFACTURER_COMBOBOX);
		selectItemInDefaultDropdown(driver, SearchPageUI.MANUFACTURER_COMBOBOX, item);
	}
}
