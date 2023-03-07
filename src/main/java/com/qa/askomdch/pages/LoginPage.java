package com.qa.askomdch.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	private WebDriver driver;

	// 1. Private by Locator
	private By username = By.xpath("//p/input[@id='username']");
	private By password = By.xpath("//p/input[@id='password']");
	private By remberMe = By.id("rememberme");
	private By loginBtn = By.xpath("//button[@value='Log in']");
	private By lostYourPwd = By.xpath("//p/a[text()='Lost your password?']");
	private By requried = By.xpath("//form[contains(@class,'login')]//span[@class='required']");

	// 2. Page Constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	// 3. Page actions/methods
	public String getLoginPageTitle() {
		String title = driver.getTitle();
		System.out.println("Login Page Title is => " + title);
		return title;
	}

	public String getLoginPageURL() {
		String url = driver.getCurrentUrl();
		System.out.println("Login Page URL is => " + url);
		return url;
	}

	public Boolean isLostYourPwodLnkExist() {
		return driver.findElement(lostYourPwd).isDisplayed();
	}

	public int getRequiredFildCount() {
		return driver.findElements(requried).size();
	}

	public AccountPage doLogin(String username, String password) {
		driver.findElement(this.username).sendKeys(username);
		driver.findElement(this.password).sendKeys(password);
		driver.findElement(remberMe).click();
		driver.findElement(loginBtn).click();
		return new AccountPage(driver);
		
	}
}
