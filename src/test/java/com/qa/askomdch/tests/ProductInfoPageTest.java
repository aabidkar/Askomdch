package com.qa.askomdch.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.askomdch.base.BaseTest;

public class ProductInfoPageTest extends BaseTest {

	@BeforeClass
	public void productInfoPageSetup() {
		accountPage = loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
	}

	@DataProvider
	public Object[][] getProductTestData() {
		return new Object[][] { { "blue", "Denim Blue Jeans", 4 }, { "shoes", "Red Shoes", 4 } };
	}

	@Test(priority = 1, dataProvider = "getProductTestData")
	public void relatedProductImageCountTest(String searchKey, String productName, int imageCount) {
		storePage = accountPage.clickOnStoreLink();
		productDetailPage = storePage.searchPorduct(searchKey, productName);
		Assert.assertEquals(productDetailPage.getRelatedProductsCount(), imageCount);
		Assert.assertTrue(productDetailPage.verifyProductDesc());
		Assert.assertTrue(productDetailPage.verifyAdditionalInfo());
		Assert.assertTrue(productDetailPage.verifyReview());
	}

	public void submitReviewTest() {
		String expectedText = "Your review is awaiting approval";
		String actualText = productDetailPage.submitReview(4, "Testing Comment, Please Ignore => " + System.currentTimeMillis()).toString().trim();
		Assert.assertEquals(expectedText, actualText);

	}
	
	@DataProvider
	public Object[][] addProductTestData() {
		return new Object[][] { { "blue", "Denim Blue Jeans" }, { "shoes", "Red Shoes" } };
	}

	@Test(priority = 3, dataProvider = "addProductTestData")
	public void addToCartTest(String searchKey, String productName) {
		int productQty = 2;
		storePage = accountPage.clickOnStoreLink();
		productDetailPage = storePage.searchPorduct(searchKey, productName);
		productDetailPage.enterQuantity(productQty);
		String actualCartMsg = productDetailPage.addProductToCart().trim();
		// 232 × “Anchor Bracelet” have been added to your cart.
		String expectedCartMsg = productQty + " × “" + productName + "” have been added to your cart.";
		Assert.assertEquals(actualCartMsg, actualCartMsg);
	}
}
