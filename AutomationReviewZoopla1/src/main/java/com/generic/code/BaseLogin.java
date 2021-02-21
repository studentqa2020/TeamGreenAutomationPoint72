package com.generic.code;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.page.object.model.MasterPageFactoryLoginPage;
import com.util.BaseConfig;
import com.util.Highlighter;
import com.util.ScreenShot;
import com.util.SeleniumWait;

public class BaseLogin {
	static MasterPageFactoryLoginPage pf;

	public static WebDriver getDriverManager() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		// implicit wait = HTML loaded
		// driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get(BaseConfig.getConfigValue("url"));
		ScreenShot.getScreenShot(driver, "Zoopla Home Page");
		System.out.println("Driver setup finished");
		return driver;
	}

	public static WebDriver getLogin(WebDriver driver) throws Throwable {
		System.out.println("Actual Test started");
		pf = new MasterPageFactoryLoginPage(driver);
		SeleniumWait.getExplicitWait(driver, pf.getAcceptCookies());// ctrl+Lt mouse click
		ScreenShot.getScreenShot(driver, "Check Cookies");
		pf.getAcceptCookies().click();// clickable
		SeleniumWait.getExplicitWait(driver, pf.getLogin());
		ScreenShot.getScreenShot(driver, "Login Page");
		Highlighter.getcolor(driver, pf.getLogin());// clickable
		pf.getLogin().click();
		Highlighter.getcolor(driver, pf.getEmail());
		pf.getEmail().sendKeys(BaseConfig.getConfigValue("email"));
		Highlighter.getcolor(driver, pf.getPass());
		pf.getPass().sendKeys(BaseConfig.getConfigValue("pass"));
		Highlighter.getcolor(driver, pf.getSubmit());
		SeleniumWait.getExplicitWait(driver, pf.getSubmit());
		pf.getSubmit().click();
		ScreenShot.getScreenShot(driver, "Login Done");
		return driver;
	}

	public static WebDriver getPriceTable(WebDriver driver) throws Throwable {
		// Highlighter.getcolor(driver, pf.getTableRows().get(0));
		// System.out.println(pf.getTableRows().get(0).getText());

		// Java looping

		pf.getTableRows().forEach(eachRow -> {
			Highlighter.getcolor(driver, eachRow);
			System.out.println(eachRow.getText());
		});
		ScreenShot.getScreenShot(driver, "WebTable");
		// -> = lamda sign(Java 8) == same a java method

		return driver;
	}

}
