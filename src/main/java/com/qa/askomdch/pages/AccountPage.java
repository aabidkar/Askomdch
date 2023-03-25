package com.qa.askomdch.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.askomdch.constants.AppConstants;
import com.qa.askomdch.utils.ElementUtil;

public class AccountPage {

	private WebDriver driver;
	private ElementUtil elementUtil;

	private By logoutLink = By.linkText("Logout");
	private By navigationMenu = By.xpath("//nav[@class='woocommerce-MyAccount-navigation']//a");
	private By storeLink = By.xpath("//li[@id='menu-item-1227']/a");

	public AccountPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}

	public String getAccountPageTitle() {
		String title = elementUtil.waitForTitleContainsAndFetch(AppConstants.DEFAULT_SHORT_TIME_OUT,
				AppConstants.LOGIN_PAGE_TITLE_VALUE);
		System.out.println("Page Title is => " + title);
		return title;
	}

	public String getAccountPageURL() {
		String url = elementUtil.waitForURLContainsAndFetch(AppConstants.DEFAULT_SHORT_TIME_OUT,
				AppConstants.LOGIN_PAGE_URL_FRACTION_VALUE);
		System.out.println("Account Page URL is => " + url);
		return url;
	}

	public Boolean isLogoutLnkExist() {
		return elementUtil.waitForElementPresence(logoutLink, AppConstants.DEFAULT_SHORT_TIME_OUT).isDisplayed();
	}

	public List<String> getNavigationList() {
		List<WebElement> accNavigationList = elementUtil.waitForElementsVisible(navigationMenu,
				AppConstants.DEFAULT_MEDIUM_TIME_OUT);
		List<String> accNavigationValList = new ArrayList<>();
		for (WebElement temp : accNavigationList) {
			String tempText = temp.getText();
			accNavigationValList.add(tempText);
		}
		return accNavigationValList;
	}

	public StorePage clickOnStoreLink() {
		elementUtil.doClick(storeLink);
		return new StorePage(driver);

	}

}
