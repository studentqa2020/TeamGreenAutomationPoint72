package com.testexecution;

import org.openqa.selenium.WebDriver;

import com.generic.code.BaseLogin;

public class SmokeTest {

	static WebDriver driver;
	
	public static void main(String[] args) throws Throwable {

		driver =BaseLogin.getDriverManager();//setup
		
		driver=	BaseLogin.getLogin(driver);//test cases
		
		driver= BaseLogin.getPriceTable(driver);
		
		driver.quit();//close the browser
	}
	
	//work =YES
	//Problem = no report
	
}
