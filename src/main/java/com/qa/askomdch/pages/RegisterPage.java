package com.qa.askomdch.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.askomdch.constants.AppConstants;
import com.qa.askomdch.utils.ElementUtil;

public class RegisterPage {

	private WebDriver driver;
	private ElementUtil elementUtil;
	private By username = By.id("reg_username");
	private By emailAddress = By.id("reg_email");
	private By password = By.id("reg_password");
	private By registerBtn = By.name("register");
	private By logoutText = By.xpath("//a[text()='Log out']");
	private By logoutLink = By.xpath("//a[text()='Logout']");

	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}

	public Boolean registerUser(String userName, String emaildId, String pwd) {
		elementUtil.waitForElementVisible(username, AppConstants.DEFAULT_SHORT_TIME_OUT).sendKeys(userName);
		elementUtil.doSendKeys(emailAddress, emaildId);
		elementUtil.doSendKeys(password, pwd);
		elementUtil.doClick(registerBtn);
		if (elementUtil.doElementIsDisplayed(logoutText)) {
			elementUtil.doClick(logoutLink);
			return true;
		}
		return false;
	}
}
