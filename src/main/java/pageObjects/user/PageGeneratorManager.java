package pageObjects.user;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {

	public static HomePageObject getHomePage(WebDriver driver) {
		return new HomePageObject(driver);
	}
	
	public static LoginPageObject getLoginPage(WebDriver driver) {
		return new LoginPageObject(driver);
	}
	
	public static RegisterPageObject getRegisterPage(WebDriver driver) {
		return new RegisterPageObject(driver);
	}
	
	public static CustomerInfoPageObject getCustomerInfoPage(WebDriver driver) {
		return new CustomerInfoPageObject(driver);
	}
	
	public static AddressPageObject getAddressPage(WebDriver driver) {
		return new AddressPageObject(driver);
	}
	
	public static ChangePasswordPageObject getChangePasswordPage(WebDriver driver) {
		return new ChangePasswordPageObject(driver);
	}
	
	public static MyProductReviewPageObject getMyProductReviewPage(WebDriver driver) {
		return new MyProductReviewPageObject(driver);
	}
	
	public static ProductReviewPageObject getProductReviewPage(WebDriver driver) {
		return new ProductReviewPageObject(driver);
	}
	
	public static ProductPageObject getProductPageObject(WebDriver driver) {
		return new ProductPageObject(driver);
	}
	
	public static CategoryPageObject getCategoryPageObject(WebDriver driver) {
		return new CategoryPageObject(driver);
	}
	
	public static SearchPageObject getSearchPageObject(WebDriver driver) {
		return new SearchPageObject(driver);
	}
	
	public static WishListPageObject getWishListPageObject(WebDriver driver) {
		return new WishListPageObject(driver);
	}
	
	public static WishListSharedPageObject getWishListSharedPageObject(WebDriver driver) {
		return new WishListSharedPageObject(driver);
	}
	
	public static ShoppingCartPageObject getShoppingCartPageObject(WebDriver driver) {
		return new ShoppingCartPageObject(driver);
	}
	
	public static CompareProductListPageObject getCompareProductListPageObject(WebDriver driver) {
		return new CompareProductListPageObject(driver);
	}
	
	public static RecentViewedProductPageObject getRecentViewedProductPageObject(WebDriver driver) {
		return new RecentViewedProductPageObject(driver);
	}
	
	public static CheckoutPageObject getCheckoutPageObject (WebDriver driver) {
		return new CheckoutPageObject(driver);
	}
	
	public static OrdersPageObject getOrdersPageObject (WebDriver driver) {
		return new OrdersPageObject(driver);
	}
}
