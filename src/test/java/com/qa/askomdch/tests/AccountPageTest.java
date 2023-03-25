package com.qa.askomdch.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.askomdch.base.BaseTest;
import com.qa.askomdch.constants.AppConstants;

public class AccountPageTest extends BaseTest {

	@BeforeClass
	public void accPageSetup() {
		accountPage = loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
	}

	@Test(priority = 1)
	public void accountPageTitleTest() {
		String actualPageTitle = accountPage.getAccountPageTitle();
		Assert.assertEquals(actualPageTitle, AppConstants.LOGIN_PAGE_TITLE_VALUE);
	}

	@Test(priority = 2)
	public void accountPageURLTest() {
		String actualURL = accountPage.getAccountPageURL();
		Assert.assertTrue(actualURL.contains(AppConstants.LOGIN_PAGE_URL_FRACTION_VALUE));
	}

	@Test(priority = 3)
	public void accLogoutLinkExistTest() {
		Assert.assertTrue(accountPage.isLogoutLnkExist());
	}

	@Test(priority = 4)
	public void accPageNavigationListCountTest() {
		Assert.assertEquals(accountPage.getNavigationList().size(), AppConstants.ACCOUNT_PAGE_NAVIGATION_LIST_COUNT);
	}

	@Test(priority = 5)
	public void accPageNavigationListTest() {
		List<String> actualNavigationList = accountPage.getNavigationList();
		System.out.println("Navigation list => " + actualNavigationList);
		Assert.assertEquals(actualNavigationList, AppConstants.EXPECTED_ACCOUNT_PAGE_NAVIGATION_LIST);
	}

	@Test(priority = 6)
	public void clickOnStoreLink() {
		storePage = accountPage.clickOnStoreLink();

	}

	@DataProvider
	public Object[][] getProductData() {
		return new Object[][] { { "blue" }, { "shoes" }, { "bracelet" }, { "shirt" }, };
	}

	@Test(priority = 7, dataProvider = "getProductData")
	public void storeSearchCount(String searchKey) {
		Assert.assertTrue(storePage.searchedProductCount(searchKey) > 0);
	}

	@DataProvider
	public Object[][] getProductTestData() {
		return new Object[][] { { "blue", "Denim Blue Jeans" }, { "shoes", "Red Shoes" },
				{ "bracelet", "Boho Bangle Bracelet" }, { "shirt", "Green Tshirt" }, };
	}

	@Test(priority = 8, dataProvider = "getProductTestData")
	public void selectProduct(String searchKey, String productName){
		productDetailPage = storePage.searchPorduct(searchKey, productName);
		String actualProductName = productDetailPage.getProductHeader();
		Assert.assertEquals(actualProductName, productName);
	}
}
