package sandbox;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import commons.BasePage;

public class NopcommerceTest {
	
	public static void main() {
		
		WebDriver driver;
		BasePage basePage;
		String projectPath = System.getProperty("user.dir");
		String emailAddress;
		
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		basePage = new BasePage();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
		
	}
}
