package pageObjects.admin;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
	
	public static AdminHomePageObject getAdminHomePageObject (WebDriver driver) {
		return new AdminHomePageObject(driver);
	}
	
	public static AdminLoginPageObject getAdminLoginPageObject (WebDriver driver) {
		return new AdminLoginPageObject(driver);
	}
	
	public static AdminSearchPageObject getAdminSearchPageObject (WebDriver driver) {
		return new AdminSearchPageObject(driver);
	}
}

