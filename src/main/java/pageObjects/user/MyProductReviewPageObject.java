package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.user.MyProductReviewPageUI;

public class MyProductReviewPageObject extends BasePage {
	WebDriver driver;
	
	public MyProductReviewPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public String getReviewTitleText() {
		waitForElementVisible(driver, MyProductReviewPageUI.REVIEW_TITLE);
		return getElementText(driver, MyProductReviewPageUI.REVIEW_TITLE);
	}

	public String getReviewContentText() {
		waitForElementVisible(driver, MyProductReviewPageUI.REVIEW_CONTENT);
		return getElementText(driver, MyProductReviewPageUI.REVIEW_CONTENT);
	}

	public String getTitleInfoText() {
		waitForElementVisible(driver, MyProductReviewPageUI.REVIEW_INFO);
		return getElementText(driver, MyProductReviewPageUI.REVIEW_INFO);
	}

}
