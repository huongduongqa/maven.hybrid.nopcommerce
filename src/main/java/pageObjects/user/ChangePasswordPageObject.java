package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import io.qameta.allure.Step;
import pageUIs.user.ChangePasswordPageUI;

public class ChangePasswordPageObject extends BasePage {
	WebDriver driver;
	
	public ChangePasswordPageObject(WebDriver driver) {
		this.driver = driver;
	}

	@Step("Input to Old Password Textbox with: {0}")
	public void inputToOldPasswordTextbox(String password) {
		waitForElementVisible(driver, ChangePasswordPageUI.OLD_PASSWORD_TEXTBOX);
		sendkeyToElement(driver, ChangePasswordPageUI.OLD_PASSWORD_TEXTBOX, password);
	}

	@Step("Input to New Password Textbox with: {0}")
	public void inputToNewPasswordTextbox(String newPassword) {
		waitForElementVisible(driver, ChangePasswordPageUI.NEW_PASSWORD_TEXTBOX);
		sendkeyToElement(driver, ChangePasswordPageUI.NEW_PASSWORD_TEXTBOX, newPassword);
	}

	@Step("Input to Confirm Password Textbox with: {0}")
	public void inputToConfirmPasswordTextbox(String newPassword) {
		waitForElementVisible(driver, ChangePasswordPageUI.CONFIRM_PASSWORD_TEXTBOX);
		sendkeyToElement(driver, ChangePasswordPageUI.CONFIRM_PASSWORD_TEXTBOX, newPassword);	
	}

	@Step("Click To Change Password Button")
	public void clickToChangePasswordButton() {
		waitForElementClickable(driver, ChangePasswordPageUI.CHANGE_PASSWORD_BUTTON);
		clickToElement(driver, ChangePasswordPageUI.CHANGE_PASSWORD_BUTTON);
	}

	public String getBarNotificationText() {
		waitForElementVisible(driver, ChangePasswordPageUI.BAR_NOTIFICATION_SUCCESS);
		return getElementText(driver, ChangePasswordPageUI.BAR_NOTIFICATION_SUCCESS);
	}

	@Step("Click To Bar Notification Close Icon")
	public void clickToBarNotificationCloseIcon() {
		waitForElementClickable(driver, ChangePasswordPageUI.BAR_NOTIFICATION_CLOSE_ICON);
		clickToElement(driver, ChangePasswordPageUI.BAR_NOTIFICATION_CLOSE_ICON);
		sleepInSecond(3);
	}
}
