package com.qa.askomdch.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountPage {

	private WebDriver driver;

	private By logoutLink = By.linkText("Logout");
	private By navigationMenu = By.xpath("//nav[@class='woocommerce-MyAccount-navigation']//a");

	public AccountPage(WebDriver driver) {
		this.driver = driver;
	}

	public String getAccountPageTitle() {
		String title = driver.getTitle();
		System.out.println("Page Title is => " + title);
		return title;
	}

	public String getAccountPageURL() {
		String url = driver.getCurrentUrl();
		System.out.println("Account Page URL is => " + url);
		return url;
	}

	public Boolean isLogoutLnkExist() {
		return driver.findElement(logoutLink).isDisplayed();
	}

	public List<String> getNavigationList() {

		List<WebElement> navList = driver.findElements(navigationMenu);
		List<String> accNavList = new ArrayList<>();
		for (WebElement e : navList) {
			String tempText = e.getText();
			accNavList.add(tempText);
		}
		return accNavList;

	}

}
