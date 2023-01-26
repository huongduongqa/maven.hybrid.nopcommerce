package commons;

import java.io.File;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;
import sandbox.VerificationFailures;
import variables.BrowserList;
import variables.EnvironmentList;
import variables.GlobalConstants;
import variables.UserTypeList;

public class BaseTest {
	private WebDriver driver;
	
	public WebDriver getDriverInstance() {
		return this.driver;
	}
	
	@BeforeSuite
	public void initBeforeSuite()
	{
		deleteAllFileInFolder();
	}

	protected WebDriver getBrowserDriver(String browserName, String userType) {
		BrowserList browser = BrowserList.valueOf(browserName.toUpperCase());
		UserTypeList user = UserTypeList.valueOf(userType.toUpperCase());

		if (browser == BrowserList.FIREFOX) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		} else if (browser == BrowserList.H_FIREFOX) {
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--headless");
			options.addArguments("window-size=1920x1080");
			driver = new FirefoxDriver(options);

		} else if (browser == BrowserList.CHROME) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		} else if (browser == BrowserList.H_CHROME) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless");
			options.addArguments("window-size=1920x1080");
			driver = new ChromeDriver(options);

		} else if (browser == BrowserList.EDGE) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();

		} else if (browser == BrowserList.OPERA) {
			WebDriverManager.operadriver().setup();
			driver = new OperaDriver();

		} else if (browser == BrowserList.COCCOC) {
			WebDriverManager.chromedriver().driverVersion("107.0.5304.62").setup();// coccoc -5 = chrome version
			ChromeOptions options = new ChromeOptions();
			if (GlobalConstants.OS_NAME.startsWith("Windows")) {
				options.setBinary("C:\\Program Files (x86)\\CocCoc\\Browser\\Application\\browser.exe");
			} else
				options.setBinary("...");
			driver = new ChromeDriver(options);

		} else if (browser == BrowserList.BRAVE) {
			WebDriverManager.chromedriver().driverVersion("107.0.5304.62").setup();// check version of brave
			ChromeOptions options = new ChromeOptions();
			options.setBinary("path of brave exe file");
			driver = new ChromeDriver(options);

		} else {
			throw new RuntimeException("Browser name is not valid");
		}

		driver.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.SECONDS);
		
		if (user == UserTypeList.USER) 
			driver.get(GlobalConstants.USER_PROD_URL);
		else
			driver.get(GlobalConstants.ADMIN_PROD_URL);
		
		return driver;
	}

	protected WebDriver getBrowserDriver(String browserName, String environmentName, String userType) {
		BrowserList browser = BrowserList.valueOf(browserName.toUpperCase());

		if (browser == BrowserList.FIREFOX) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		} else if (browser == BrowserList.H_FIREFOX) {
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--headless");
			options.addArguments("window-size=1920x1080");
			driver = new FirefoxDriver(options);

		} else if (browser == BrowserList.CHROME) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		} else if (browser == BrowserList.H_CHROME) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless");
			options.addArguments("window-size=1920x1080");
			driver = new ChromeDriver(options);

		} else if (browser == BrowserList.EDGE) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();

		} else if (browser == BrowserList.OPERA) {
			WebDriverManager.operadriver().setup();
			driver = new OperaDriver();

		} else if (browser == BrowserList.COCCOC) {
			WebDriverManager.chromedriver().driverVersion("107.0.5304.62").setup();// coccoc -5 = chrome version
			ChromeOptions options = new ChromeOptions();
			if (GlobalConstants.OS_NAME.startsWith("Windows")) {
				options.setBinary("C:\\Program Files (x86)\\CocCoc\\Browser\\Application\\browser.exe");
			} else
				options.setBinary("...");
			driver = new ChromeDriver(options);

		} else if (browser == BrowserList.BRAVE) {
			WebDriverManager.chromedriver().driverVersion("107.0.5304.62").setup();// check version of brave
			ChromeOptions options = new ChromeOptions();
			options.setBinary("path of brave exe file");
			driver = new ChromeDriver(options);

		} else {
			throw new RuntimeException("Browser name is not valid");
		}

		driver.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.SECONDS);
		driver.get(getEnvironmentUrl(environmentName));
		return driver;
	}

	private String getEnvironmentUrl(String serverName) {
		String envUrl = null;
		EnvironmentList environment = EnvironmentList.valueOf(serverName.toUpperCase());
		if (environment == EnvironmentList.PROD)
			envUrl = GlobalConstants.USER_PROD_URL;

		else if (environment == EnvironmentList.STAGING)
			envUrl = GlobalConstants.USER_STAGING_URL;

		else if (environment == EnvironmentList.TEST)
			envUrl = GlobalConstants.USER_TESTING_URL;

		else if (environment == EnvironmentList.DEV)
			envUrl = GlobalConstants.USER_DEV_URL;

		return envUrl;
	}

	protected boolean verifyTrue(boolean condition) {
		boolean pass = true;
		try {
			Assert.assertTrue(condition);
			// log.info(" -------------------------- PASSED -------------------------- ");
		} catch (Throwable e) {
			pass = false;

			// Add lỗi vào ReportNG
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyFalse(boolean condition) {
		boolean pass = true;
		try {
			if (condition == false) {
				// log.info(" -------------------------- PASSED -------------------------- ");
			} else {
				// log.info(" -------------------------- FAILED -------------------------- ");
			}
			Assert.assertFalse(condition);
		} catch (Throwable e) {
			pass = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyEquals(Object actual, Object expected) {
		boolean pass = true;
		try {
			Assert.assertEquals(actual, expected);
			// log.info(" -------------------------- PASSED -------------------------- ");
		} catch (Throwable e) {
			pass = false;
			// log.info(" -------------------------- FAILED -------------------------- ");
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	public void deleteAllFileInFolder() {
		try {
			String pathFolderDownload = GlobalConstants.PROJECT_PATH + "/allure-json";
			File file = new File(pathFolderDownload);
			File[] listOfFiles = file.listFiles();
			for (int i = 0; i < listOfFiles.length; i++) {
				if (listOfFiles[i].isFile()) {
					System.out.println(listOfFiles[i].getName());
					new File(listOfFiles[i].toString()).delete();
				}
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}
	protected int generateFakeNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}
	
	
}
