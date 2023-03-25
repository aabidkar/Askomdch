package com.qa.askomdch.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.askomdch.constants.AppConstants;
import com.qa.askomdch.utils.ElementUtil;

public class StorePage {

	private WebDriver driver;
	private ElementUtil elementUtil;

	private By searchField = By.xpath("//form/input[@id='woocommerce-product-search-field-0']");
	private By searchBtn = By.xpath("//button[@value='Search']");
	private By searchResult = By.xpath("//h2[@class='woocommerce-loop-product__title']");
	private By storeLink = By.xpath("//li[@id='menu-item-1227']/a");

	public StorePage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}

	public String getStorePageTitle() {
		String title = elementUtil.waitForTitleContainsAndFetch(AppConstants.DEFAULT_SHORT_TIME_OUT,
				AppConstants.STORE_PAGE_TITLE_VALUE);
		System.out.println("Page Title is => " + title);
		return title;
	}

	public String getStorePageURL() {
		String url = elementUtil.waitForURLContainsAndFetch(AppConstants.DEFAULT_SHORT_TIME_OUT,
				AppConstants.STORE_PAGE_URL_FRACTION_VALUE);
		System.out.println("Account Page URL is => " + url);
		return url;
	}

	public int searchedProductCount(String productName) {
		elementUtil.waitForElementVisible(searchField, AppConstants.DEFAULT_MEDIUM_TIME_OUT).sendKeys(productName);
		elementUtil.doClick(searchBtn);
		elementUtil.clearElement(searchField);
		elementUtil.getTotalElementsCount(searchResult);
		return elementUtil.waitForElementsPresence(searchResult, AppConstants.DEFAULT_MEDIUM_TIME_OUT).size();
	}

	public ProductDetailPage searchPorduct(String searchKey, String productName) {
		elementUtil.doClick(storeLink);
		By productLocator = By
				.xpath("//div[@class='ast-woocommerce-container']//*[contains(text(),'" + productName + "')]");
		elementUtil.waitForElementVisible(searchField, AppConstants.DEFAULT_MEDIUM_TIME_OUT).sendKeys(searchKey);
		elementUtil.doClick(searchBtn);
		elementUtil.doClick(productLocator);
		return new ProductDetailPage(driver);
	}

}
