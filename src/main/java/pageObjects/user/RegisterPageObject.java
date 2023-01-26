package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import io.qameta.allure.Step;
import pageUIs.user.RegisterPageUI;

public class RegisterPageObject extends BasePage {

	private WebDriver driver;
	
	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}

	@Step("Click to Gender")
	public void clickToRadioByLabel(char gender) {
		if (gender == 'M') {
			waitForElementVisible(driver, RegisterPageUI.MALE_RADIO);
			clickToElement(driver, RegisterPageUI.MALE_RADIO);
		}else {
			waitForElementVisible(driver, RegisterPageUI.FEMALE_RADIO);
			clickToElement(driver, RegisterPageUI.FEMALE_RADIO);
		}	
	}

	@Step("Input FirstName with: {0}")
	public void inputToFirstnameTextbox(String firstname) {
		waitForElementVisible(driver, RegisterPageUI.FIRSTNAME_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.FIRSTNAME_TEXTBOX, firstname);
	}

	@Step("Input Lastname with: {0}")
	public void inputToLastnameTextbox(String lastname) {
		waitForElementVisible(driver, RegisterPageUI.LASTNAME_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.LASTNAME_TEXTBOX, lastname);
	}

	@Step("Select a date with: {0}")
	public void selectDateComboxboxByText(String date) {
		waitForElementVisible(driver, RegisterPageUI.DATE_DROPDOWN);
		selectItemInDefaultDropdown(driver, RegisterPageUI.DATE_DROPDOWN, date);
	}

	@Step("Select a month with: {0}")
	public void selectMonthComboxboxByText(String month) {
		waitForElementVisible(driver, RegisterPageUI.MONTH_DROPDOWN);
		selectItemInDefaultDropdown(driver, RegisterPageUI.MONTH_DROPDOWN, month);
	}

	@Step("Select a year with: {0}")
	public void selectYearComboxboxByText(String year) {
		waitForElementVisible(driver, RegisterPageUI.YEAR_DROPDOWN);
		selectItemInDefaultDropdown(driver, RegisterPageUI.YEAR_DROPDOWN, year);
	}

	@Step("Input Email with: {0}")
	public void inputEmailToTextbox(String email) {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, email);
	}

	@Step("Input CompanyName with: {0}")
	public void inputToCompanyNameTextbox(String companyName) {
		waitForElementVisible(driver, RegisterPageUI.COMPANY_NAME_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.COMPANY_NAME_TEXTBOX, companyName);
	}

	@Step("Input Password with: {0}")
	public void inputToPasswordTextbox(String validPassword) {
		waitForElementVisible(driver, RegisterPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.PASSWORD_TEXTBOX, validPassword);	
	}

	@Step("Input Confirm Password with: {0}")
	public void inputToConfirmPasswordTextbox(String confirmPassword) {
		waitForElementVisible(driver, RegisterPageUI.CONFIRM_PASS_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.CONFIRM_PASS_TEXTBOX, confirmPassword);
	}

	@Step("Click to Register button")
	public HomePageObject clickToRegisterButton() {
		waitForElementClickable(driver, RegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);
		return PageGeneratorManager.getHomePage(driver);
		
	}
	
	public String getRegisterSuccessMessage() {
		waitForElementVisible(driver, RegisterPageUI.REGISTER_SUCCESS_MESSAGE);
		return getElementText(driver, RegisterPageUI.REGISTER_SUCCESS_MESSAGE);
	}

	public String getRegisterRequiredFieldsMessage(String locatorID) {
		waitForElementVisible(driver, RegisterPageUI.ERROR_REQUIRED_FIELDS_MESSAGE, locatorID);
		return getElementText(driver, RegisterPageUI.ERROR_REQUIRED_FIELDS_MESSAGE, locatorID);
	}

	public String getErrorExistingEmailMessage() {
		waitForElementVisible(driver,RegisterPageUI.ERROR_EXISTING_EMAIL_MESSAGE);
		return getElementText(driver, RegisterPageUI.ERROR_EXISTING_EMAIL_MESSAGE);
	}
}
