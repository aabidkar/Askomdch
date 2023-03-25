package com.qa.askomdch.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.askomdch.base.BaseTest;
import com.qa.askomdch.constants.AppConstants;
import com.qa.askomdch.utils.ExcelUtil;

public class RegisterPageTest extends BaseTest {
	
	static String userName;
	static String emailId;

	@BeforeClass
	public void regPageSetup() {
		registerPage = loginPage.navigateToRegister();
	}
	
	public String getRandomUsername() {
		userName = "automation" + System.currentTimeMillis();
		emailId = userName + "@gmail.com";
		return emailId;
	}

	@DataProvider
	public Object[][] getRegistrationTestData() {
		Object[][] regData = ExcelUtil.getTestData(AppConstants.REGISTER_SHEET_NAME);
		return regData;
	}

	@Test(dataProvider = "getRegistrationTestData", priority = 1)
	public void userRegistrationTest(String pwd) {
		getRandomUsername();
		Assert.assertTrue(registerPage.registerUser(userName,emailId, pwd));
	}
}
