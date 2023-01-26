package pageUIs.user;

public class RegisterPageUI {
	
	public static final String MALE_RADIO ="xpath=//input[@id='gender-male']";
	public static final String FEMALE_RADIO ="xpath=//input[@id='gender-female']";
	public static final String FIRSTNAME_TEXTBOX = "xpath=//input[@id='FirstName']";
	public static final String LASTNAME_TEXTBOX = "xpath=//input[@id='LastName']";
	public static final String DATE_DROPDOWN = "name=DateOfBirthDay";
	public static final String MONTH_DROPDOWN = "name=DateOfBirthMonth";
	public static final String YEAR_DROPDOWN = "name=DateOfBirthYear";
	public static final String EMAIL_TEXTBOX = "xpath=//input[@id='Email']";
	public static final String COMPANY_NAME_TEXTBOX = "xpath=//input[@id='Company']";
	public static final String PASSWORD_TEXTBOX = "xpath=//input[@id='Password']";
	public static final String CONFIRM_PASS_TEXTBOX = "xpath=//input[@id='ConfirmPassword']";
	public static final String REGISTER_BUTTON ="xpath=//button[@id='register-button']";
	
	
	public static final String REGISTER_SUCCESS_MESSAGE = "xpath=//div[@class = 'result']";
	public static final String ERROR_EXISTING_EMAIL_MESSAGE = "css=div.message-error li";
	public static final String ERROR_REQUIRED_FIELDS_MESSAGE = "xpath=//span[@id='%s']";
	
	
	
}
