package com.qa.askomdch.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
	public WebDriver driver;

	public WebDriver initDriver(String browserName) {
		System.out.println("Passed Browser Name is => " + browserName);
		if (browserName.trim().equalsIgnoreCase("chrome"))
			driver = new ChromeDriver();
		else if (browserName.trim().equalsIgnoreCase("firefox"))
			driver = new FirefoxDriver();
		else if (browserName.trim().equalsIgnoreCase("edge"))
			driver = new EdgeDriver();
		else
			System.out.println("Please enter a valid browser name...");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://askomdch.com/account/");
		return driver;
	}
}
