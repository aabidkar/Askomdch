package com.qa.askomdch.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.askomdch.factory.DriverFactory;
import com.qa.askomdch.pages.AccountPage;
import com.qa.askomdch.pages.LoginPage;

public class BaseTest {

	DriverFactory driverFactory;
	WebDriver driver;
	protected LoginPage loginPage;
	protected AccountPage accountPage;

	@BeforeTest
	public void setup() {
		driverFactory = new DriverFactory();
		driver = driverFactory.initDriver("chrome");
		loginPage = new LoginPage(driver);

	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
