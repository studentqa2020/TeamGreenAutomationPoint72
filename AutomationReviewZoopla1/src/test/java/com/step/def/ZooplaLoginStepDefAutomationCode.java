package com.step.def;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.email.manager.EmailWithAttachment;
import com.email.manager.SendEmail;
import com.page.object.model.MasterPageFactoryLoginPage;
import com.util.BaseConfig;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ZooplaLoginStepDefAutomationCode {

	WebDriver driver;
	MasterPageFactoryLoginPage pf;

	@Given("Open the browser")
	public void open_the_browser() {
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

	}

	@When("Send URL")
	public void send_URL() throws Throwable {

		driver.get(BaseConfig.getConfigValue("url"));
	}

	@When("Accept cookies")
	public void accept_cookies() {
		pf = new MasterPageFactoryLoginPage(driver);
		pf.getAcceptCookies().click();
	}

	@When("Click Sign in btn")
	public void click_Sign_in_btn() {

		pf.getLogin().click();
	}

	@When("Send valid email")
	public void send_valid_email() throws Throwable {
		pf.getEmail().sendKeys(BaseConfig.getConfigValue("email"));

	}

	@When("Send valid password")
	public void send_valid_password() throws IOException {
		pf.getPass().sendKeys(BaseConfig.getConfigValue("pass"));

	}

	@When("Click submit btn")
	public void click_submit_btn() {
		pf.getSubmit().click();

	}

	@Then("Validate login success or fail")
	public void validate_login_success_or_fail() {
		// create today

	}

	@When("close the browser")
	public void close_the_browser() throws Throwable {
		driver.quit();
	}

}
