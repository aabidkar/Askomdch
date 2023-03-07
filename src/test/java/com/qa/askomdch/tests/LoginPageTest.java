package com.qa.askomdch.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.askomdch.base.BaseTest;

public class LoginPageTest extends BaseTest {

	@Test(priority = 1)
	public void loginPageTitleTest() {
		String actualPageTitle = loginPage.getLoginPageTitle();
		Assert.assertEquals(actualPageTitle, "Account – AskOmDch");
	}

	@Test(priority = 2)
	public void loginPageURLTest() {
		String actualURL = loginPage.getLoginPageURL();
		Assert.assertTrue(actualURL.contains("account"));
	}

	@Test(priority = 3)
	public void lostYourPwdLinkExistTest() {
		Assert.assertTrue(loginPage.isLostYourPwodLnkExist());
	}

	@Test(priority = 5)
	public void login() {
		loginPage.doLogin("aabidkar", "aabidkar");
	}

	@Test(priority = 4)
	public void requiredFieldCount() {
		Assert.assertEquals(loginPage.getRequiredFildCount(), 2);
	}

}
