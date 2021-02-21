package com.testexecution;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.generic.code.BaseLogin;

public class SmokeTestWithTestNG {

	WebDriver driver;

	@BeforeTest
	public void getDriverSetup() throws Throwable {
		driver = BaseLogin.getDriverManager();
	}

	@Test
	public void getLogin() throws Throwable {

		driver = BaseLogin.getLogin(driver);
	}
	
	@Test
	public void getPriceTable() throws Throwable {

		driver= BaseLogin.getPriceTable(driver);
	}


	@AfterTest
	public void getDriceClose() {
		driver.quit();// close the browser

	}

}
