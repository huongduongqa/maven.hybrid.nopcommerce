package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import io.qameta.allure.Step;
import pageUIs.user.ProductReviewPageUI;

public class ProductReviewPageObject extends BasePage {
	
	private WebDriver driver;
	
	public ProductReviewPageObject(WebDriver driver) {
		this.driver = driver;
	}

	@Step("Input Review Title with: {0}")
	public void inputToReviewTitleTextbox(String title) {
		waitForElementVisible(driver, ProductReviewPageUI.REVIEW_TITLE_TEXTBOX);
		sendkeyToElement(driver, ProductReviewPageUI.REVIEW_TITLE_TEXTBOX, title);
	}

	@Step("Input Review Content with: {0}")
	public void inputToReviewTextTextbox(String content) {
		waitForElementVisible(driver, ProductReviewPageUI.REVIEW_TEXT_TEXTBOX);
		sendkeyToElement(driver, ProductReviewPageUI.REVIEW_TEXT_TEXTBOX, content);
	}

	@Step("Click to Submit Review button")
	public void clickToSubmitReviewButton() {
		waitForElementClickable(driver, ProductReviewPageUI.SUBMIT_REVIEW_BUTTON);
		clickToElement(driver, ProductReviewPageUI.SUBMIT_REVIEW_BUTTON);
	}

}
