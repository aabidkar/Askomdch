package com.qa.askomdch.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.askomdch.factory.DriverFactory;
import com.qa.askomdch.pages.AccountPage;
import com.qa.askomdch.pages.LoginPage;
import com.qa.askomdch.pages.ProductDetailPage;
import com.qa.askomdch.pages.RegisterPage;
import com.qa.askomdch.pages.StorePage;

public class BaseTest {

	DriverFactory driverFactory;
	WebDriver driver;
	protected LoginPage loginPage;
	protected AccountPage accountPage;
	protected Properties prop;
	protected StorePage storePage;
	protected ProductDetailPage productDetailPage;
	protected RegisterPage registerPage;

	@BeforeTest
	public void setup() {
		driverFactory = new DriverFactory();
		prop = driverFactory.initProperties();
		driver = driverFactory.initDriver(prop);
		loginPage = new LoginPage(driver);

	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
