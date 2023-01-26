package com.nopcommerce.data;

import java.util.Locale;
import java.util.Random;

import com.github.javafaker.Faker;

public class DataHelper {

		private Locale local = new Locale("us");
		private Faker faker = new Faker(local);
		
		public static DataHelper getDataHelper()
		{
			return new DataHelper();
		}
		
		public String getFirstName() {
			return faker.address().firstName();
		}
		
		public String getLastName() {
			return faker.address().lastName();
		}
		
		public String getEmail() {
			return faker.internet().emailAddress();
		}
		
		public String getCompanyName() {
			return faker.company().name();
		}
		
		public String getPassword() {
			return faker.internet().password(8, 10, true);
		}
		
		public String getCountry() {
			return faker.address().country();
		}
		
		public String getProvine_State() {
			return faker.address().state();
		}
		
		public String getCity() {
			return faker.address().city();
		}
		
		public String getAddress() {
			return faker.address().fullAddress();
		}
		
		public String getZipCode() {
			return faker.address().zipCode();
		}
		
		public String getPhoneNumber() {
			return faker.phoneNumber().cellPhone();
		}
		
		public String getFaxNumber() {
			return "1232898721254353";
		}
		
		public String getDate() {
			Random rand = new Random();
			String[] dates = {"1", "2", "3", "4", "5", "6", "7", "8","9","10","11","12","13","14","15","16","17"};
			return dates[rand.nextInt(dates.length)];
		}
		
		public String getMonth() {
			Random rand = new Random();
			String[] months = {"January", "Fr", "February", "March", "April", "May", "June", "July","August","September","October","November","December"};
			return months[rand.nextInt(months.length)];
		}
		
		public String getMonthInNumber() {
			Random rand = new Random();
			String[] months = {"1", "2", "3", "March", "4", "5", "6", "7","8","9","10","11","12"};
			return months[rand.nextInt(months.length)];
		}
		
		public String getCreditCardExpiredYear() {
			Random rand = new Random();
			String[] years = {"2024", "2025", "2026", "2027", "2028", "2029", "2030"};
			return years[rand.nextInt(years.length)];
		}
		
		public String getYear() {
			Random rand = new Random();
			String[] years = {"1978", "1979", "1980", "1981", "1982", "1983", "1984", "1985","1986","1987","1988","1989","1990"};
			return years[rand.nextInt(years.length)];
		}
		
		public char getGender() {
			String chars = "MF";
			Random rnd = new Random();
			return chars.charAt(rnd.nextInt(chars.length()));	
		}
		
		public String getCreditCardNumber() {
			return "1245 7213 2219 7691";
		}
		
		public String getCreditCardSecureCode() {
			return "567";
		}
}
