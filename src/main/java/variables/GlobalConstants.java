package variables;

import java.io.File;

public class GlobalConstants {

	public static final String USER_PROD_URL = "https://demo.nopcommerce.com/";
	public static final String USER_STAGING_URL = "";
	public static final String USER_TESTING_URL = "";
	public static final String USER_DEV_URL = "";
	
	public static final String ADMIN_PROD_URL = "https://admin-demo.nopcommerce.com/login?ReturnUrl=/admin/";
	public static final String ADMIN_STAGING_URL = "";
	public static final String ADMIN_TESTING_URL = "";
	public static final String ADMIN_DEV_URL = "";
	
	public static final String PROJECT_PATH = System.getProperty("user.dir");
	public static final String OS_NAME = System.getProperty("os.name");
	public static final String UPLOAD_FILE = PROJECT_PATH + File.separator + "uploadFiles";
	public static final String JAVA_VERSION = System.getProperty("java.version");
	public static final String DOWNLOAD_FILE = PROJECT_PATH + File.separator + "downloadFiles";
	public static final String BROWSER_LOG = PROJECT_PATH + File.separator + "browserLogs";
	public static final String DRAG_DROP_HTML5 = PROJECT_PATH + File.separator + "dragDropHTML5";
	public static final String AUTO_IT_SCRIPT = PROJECT_PATH + File.separator + "autoIT";
	
	public static final String DB_PROD_URL = "192.168.1.1:9860";
	public static final String DB_PROD_USER= "automationfc";
	public static final String DB_PROD_PASS = "Password123@";
	
	public static final String ADMIN_EMAIL = "admin@yourstore.com";
	public static final String ADMIN_PASSWORD = "admin";
	
	public static final int LONG_TIMEOUT = 15;
	public static final int SHORT_TIMEOUT = 5;
	public static final int RETRY_TEST_FAIL = 3;
}
