package com.qa.askomdch.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.askomdch.constants.AppConstants;
import com.qa.askomdch.utils.ElementUtil;

import io.qameta.allure.Step;

public class LoginPage {

	private WebDriver driver;
	private ElementUtil elementUtil;

	// 1. Private by Locator
	private By username = By.xpath("//p/input[@id='username']");
	private By password = By.xpath("//p/input[@id='password']");
	private By remberMe = By.id("rememberme");
	private By loginBtn = By.xpath("//button[@value='Log in']");
	private By lostYourPwd = By.xpath("//p/a[text()='Lost your password?']");
	private By requried = By.xpath("//form[contains(@class,'login')]//span[@class='required']");
	private By account = By.xpath("(//li/a[text()='Account'])[1]");

	// 2. Page Constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}

	// 3. Page actions/methods
	@Step("Getting the login page title.")
	public String getLoginPageTitle() {
		String title = elementUtil.waitForTitleContainsAndFetch(AppConstants.DEFAULT_SHORT_TIME_OUT,
				AppConstants.LOGIN_PAGE_TITLE_VALUE);
		System.out.println("Login Page Title is => " + title);
		return title;
	}

	@Step("Getting the login page URL.")
	public String getLoginPageURL() {
		String url = elementUtil.waitForURLContainsAndFetch(AppConstants.DEFAULT_SHORT_TIME_OUT,
				AppConstants.LOGIN_PAGE_URL_FRACTION_VALUE);
		System.out.println("Login Page URL is => " + url);
		return url;
	}

	@Step("Checking the lost your password link exist.")
	public Boolean isLostYourPwodLnkExist() {
		return elementUtil.waitForElementPresence(lostYourPwd, AppConstants.DEFAULT_SHORT_TIME_OUT).isDisplayed();
	}

	@Step("Getting the reqied field count.")
	public int getRequiredFieldCount() {
		return elementUtil.getTotalElementsCount(requried);
	}

	@Step("Doing the Login with valid username : {0} and password : {1}.")
	public AccountPage doLogin(String usrName, String pwd) {
		System.out.println("Your Log in credientials are Username => " + usrName + " Password is => " + pwd);
		elementUtil.waitForElementVisible(username, AppConstants.DEFAULT_MEDIUM_TIME_OUT).sendKeys(usrName);
		elementUtil.doSendKeys(password, pwd);
		elementUtil.doClick(remberMe);
		elementUtil.doClick(loginBtn);
		return new AccountPage(driver);
	}

	public RegisterPage navigateToRegister() {
		elementUtil.doClick(account);
		return new RegisterPage(driver);
	}
}
