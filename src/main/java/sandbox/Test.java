package sandbox;

import java.util.Random;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class Test {
	WebDriver driver;
	BasePage basePage;
	String projectPath = System.getProperty("user.dir");
	String emailAddress;

	public static void main(String[] args) {
		char c='H';
		if (c=='H') {
			System.out.println("yes");
		}

		Random rand = new Random();
		String[] dates = {"1", "2", "3", "4", "5", "6", "7", "8","9","10","11","12","13","14","15","16","17"};
		System.out.println("out" + dates[rand.nextInt(dates.length)]);
		
		String chars = "MF";
		Random rnd = new Random();
		System.out.println(chars.charAt(rnd.nextInt(chars.length())));
	}
}
