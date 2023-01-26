package pageObjects.user;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import io.qameta.allure.Step;
import pageUIs.user.CustomerInfoPageUI;

public class CustomerInfoPageObject extends BasePage {
	
	WebDriver driver;
	
	public CustomerInfoPageObject (WebDriver driver) {
		this.driver = driver;
	}

	@Step("Click to Gender")
	public void clickToGenderRadioButton(char gender) {
		if (gender == 'M') {
			waitForElementVisible(driver, CustomerInfoPageUI.MALE_RADIO);
			clickToElement(driver, CustomerInfoPageUI.MALE_RADIO);
		}else {
			waitForElementVisible(driver, CustomerInfoPageUI.FEMALE_RADIO);
			clickToElement(driver, CustomerInfoPageUI.FEMALE_RADIO);
		}	
	}

	@Step("Input FirstName with: {0}")
	public void inputToFirstnameTextbox(String firstname) {
		waitForElementVisible(driver, CustomerInfoPageUI.FIRSTNAME_TEXTBOX);
		sendkeyToElement(driver, CustomerInfoPageUI.FIRSTNAME_TEXTBOX, firstname);
	}

	@Step("Input Lastname with: {0}")
	public void inputToLastnameTextbox(String lastname) {
		waitForElementVisible(driver, CustomerInfoPageUI.LASTNAME_TEXTBOX);
		sendkeyToElement(driver, CustomerInfoPageUI.LASTNAME_TEXTBOX, lastname);
	}

	@Step("Select a date with: {0}")
	public void selectDateComboxboxByText(String date) {
		waitForElementVisible(driver, CustomerInfoPageUI.DATE_DROPDOWN);
		selectItemInDefaultDropdown(driver, CustomerInfoPageUI.DATE_DROPDOWN, date);
	}

	@Step("Select a month with: {0}")
	public void selectMonthComboxboxByText(String month) {
		waitForElementVisible(driver, CustomerInfoPageUI.MONTH_DROPDOWN);
		selectItemInDefaultDropdown(driver, CustomerInfoPageUI.MONTH_DROPDOWN, month);
	}

	@Step("Select a year with: {0}")
	public void selectYearComboxboxByText(String year) {
		waitForElementVisible(driver, CustomerInfoPageUI.YEAR_DROPDOWN);
		selectItemInDefaultDropdown(driver, CustomerInfoPageUI.YEAR_DROPDOWN, year);
	}

	@Step("Input Email with: {0}")
	public void inputEmailToTextbox(String email) {
		waitForElementVisible(driver, CustomerInfoPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, CustomerInfoPageUI.EMAIL_TEXTBOX, email);
	}

	@Step("Input CompanyName with: {0}")
	public void inputToCompanyNameTextbox(String companyName) {
		waitForElementVisible(driver, CustomerInfoPageUI.COMPANY_NAME_TEXTBOX);
		sendkeyToElement(driver, CustomerInfoPageUI.COMPANY_NAME_TEXTBOX, companyName);
	}

	@Step("Click Save Button")
	public void clickToSaveButton() {
		waitForElementClickable(driver, CustomerInfoPageUI.SAVE_BUTTON);
		clickToElement(driver, CustomerInfoPageUI.SAVE_BUTTON);
	}

	public char getSelectedGender() {
		char result = 'E';
		waitForElementVisible(driver, CustomerInfoPageUI.FEMALE_RADIO);
		WebElement femaleRadio = getWebElement(driver, CustomerInfoPageUI.FEMALE_RADIO);
		waitForElementVisible(driver, CustomerInfoPageUI.MALE_RADIO);
		WebElement maleRadio = getWebElement(driver, CustomerInfoPageUI.MALE_RADIO);
		if (femaleRadio.isSelected())
			result ='F';
		else if (maleRadio.isSelected())
			result ='M';	
		return result;
	}

	public String getTextInFirstnameTextbox() {
		waitForElementVisible(driver, CustomerInfoPageUI.FIRSTNAME_TEXTBOX);
		return getElementAttribute(driver, CustomerInfoPageUI.FIRSTNAME_TEXTBOX, "value");
	}

	public String getTextInLastnameTextbox() {
		waitForElementVisible(driver, CustomerInfoPageUI.LASTNAME_TEXTBOX);
		return getElementAttribute(driver, CustomerInfoPageUI.LASTNAME_TEXTBOX, "value");
	}

	public String getSelectedItemInDateCombobox() {
		waitForElementVisible(driver, CustomerInfoPageUI.DATE_DROPDOWN);
		return getSelectedItemDefaultDropdown(driver, CustomerInfoPageUI.DATE_DROPDOWN);
	}

	public String getSelectedItemInMonthCombobox() {
		waitForElementVisible(driver, CustomerInfoPageUI.MONTH_DROPDOWN);
		return getSelectedItemDefaultDropdown(driver, CustomerInfoPageUI.MONTH_DROPDOWN);
	}

	public String getSelectedItemInYearCombobox() {
		waitForElementVisible(driver, CustomerInfoPageUI.YEAR_DROPDOWN);
		return getSelectedItemDefaultDropdown(driver, CustomerInfoPageUI.YEAR_DROPDOWN);
	}

	public String getTextInEmailTextbox() {
		waitForElementVisible(driver, CustomerInfoPageUI.EMAIL_TEXTBOX);
		return getElementAttribute(driver, CustomerInfoPageUI.EMAIL_TEXTBOX,"value");
	}

	public String getTextInCompanyNameTextbox() {
		waitForElementVisible(driver, CustomerInfoPageUI.COMPANY_NAME_TEXTBOX);
		return getElementAttribute(driver, CustomerInfoPageUI.COMPANY_NAME_TEXTBOX,"value");
	}
}
