package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.user.CheckoutPageUI;
import pageUIs.user.OrdersPageUI;

public class OrdersPageObject extends BasePage{

	WebDriver driver;
	
	public OrdersPageObject (WebDriver driver)
	{
		this.driver = driver;
	}

	public String getOrderNumber() {
		waitForElementVisible(driver,OrdersPageUI.ORDER_NUMBER);
		return getElementText(driver,OrdersPageUI.ORDER_NUMBER);
	}
}