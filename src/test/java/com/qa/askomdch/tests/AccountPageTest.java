package com.qa.askomdch.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;

import com.qa.askomdch.base.BaseTest;

public class AccountPageTest extends BaseTest {

	@BeforeClass
	public void accPageSetup() {
		accountPage = loginPage.doLogin("aabidkar", "aabidkar");
	}

	public void accountPageTitleTest() {
		String actualPageTitle = accountPage.getAccountPageTitle();
		Assert.assertEquals(actualPageTitle, "Account – AskOmDch");
	}

	public void accountPageURLTest() {
		String actualURL = accountPage.getAccountPageURL();
		Assert.assertTrue(actualURL.contains("account"));
	}

	public void logoutLinkExistTest() {
		Assert.assertTrue(accountPage.isLogoutLnkExist());
	}

	public void navigationList() {
		accountPage.getNavigationList();
	}

}
