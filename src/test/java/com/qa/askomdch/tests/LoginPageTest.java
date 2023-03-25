package com.qa.askomdch.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.askomdch.base.BaseTest;
import com.qa.askomdch.constants.AppConstants;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("Epic - Design Login Page for AskOmDch application.")
@Story("Login - 101: Login Page feature for AskOmDch.")
public class LoginPageTest extends BaseTest {

	@Severity(SeverityLevel.TRIVIAL)
	@Description("Verifying the Login Page Title.")
	@Test(priority = 1)
	public void loginPageTitleTest() {
		String actualPageTitle = loginPage.getLoginPageTitle();
		Assert.assertEquals(actualPageTitle, AppConstants.LOGIN_PAGE_TITLE_VALUE);
	}

	@Severity(SeverityLevel.TRIVIAL)
	@Description("Verifying the Login Page URL.")
	@Test(priority = 2)
	public void loginPageURLTest() {
		String actualURL = loginPage.getLoginPageURL();
		Assert.assertTrue(actualURL.contains(AppConstants.LOGIN_PAGE_URL_FRACTION_VALUE));
	}

	@Severity(SeverityLevel.CRITICAL)
	@Description("Verifying the Lost your password link exist or not.")
	@Test(priority = 3)
	public void lostYourPwdLinkExistTest() {
		Assert.assertTrue(loginPage.isLostYourPwodLnkExist());
	}

	@Severity(SeverityLevel.CRITICAL)
	@Description("Verifying the Login Page with Valid Username and Password.")
	@Test(priority = 5)
	public void loginTest() {
		accountPage = loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
		Assert.assertTrue(accountPage.isLogoutLnkExist());
	}

	@Severity(SeverityLevel.TRIVIAL)
	@Description("Verifying the required field count.")
	@Test(priority = 4)
	public void requiredFieldCountTest() {
		Assert.assertEquals(loginPage.getRequiredFieldCount(), 2);
	}

}
