package pageObjects.admin;

import org.openqa.selenium.WebDriver;

import commons.AdminGenericPage;

public class AdminHomePageObject extends AdminGenericPage{
	WebDriver driver;
	
	public AdminHomePageObject(WebDriver driver) {
		this.driver = driver;
	}
}
